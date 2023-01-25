package com.coctails.service;

import com.coctails.entity.ConfirmationTokenEntity;
import com.coctails.interfaces.EmailSender;
import com.coctails.entity.Role;
import com.coctails.entity.User;
import com.coctails.regex.Validator;
import com.coctails.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Transactional
@Log4j2
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private ConfirmationTokenService tokenService;
    @Autowired
    private ConfirmationTokenService confirmationTokenService;
    @Autowired
    private EmailSender emailSender;

    @Transactional
    public void save(User user) {
        user.setRole(Role.ADMIN);
        userRepository.save(user);
    }

    public void addUser(User user) {
        userFormat(user);
        ConfirmationTokenEntity confirmationTokenEntity = new ConfirmationTokenEntity(
                UUID.randomUUID().toString(),
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );

        tokenService.save(confirmationTokenEntity);
        save(user);
        sendEmail(confirmationTokenEntity, user);
    }

    public void sendEmail(ConfirmationTokenEntity confirmationTokenEntity, User user){
        String link = "http://localhost:4200/user/confirm?token=" + confirmationTokenEntity.getToken();
        emailSender.send(user.getEmail(), buildEmail(user.getEmail(),link));
    }

    public void generateNewToken(String token){
        ConfirmationTokenEntity confirmationTokenEntity = confirmationTokenService.generateNewToken(token);
        tokenService.save(confirmationTokenEntity);
        sendEmail(confirmationTokenEntity, confirmationTokenService.getToken(token).get().getUser());
    }

    private void userFormat(User user) {
        user.setEmail(user.getEmail().toLowerCase());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

    public boolean userExists(String email) {
        User tempUser = userRepository.findByEmail(email);
        return tempUser != null;
    }

    public ResponseEntity<?> validation(User user) {
        ResponseEntity<?> validationResult = Validator.validator(user);
        if (validationResult != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return null;
    }

    public void allowAccess(String token){
        ConfirmationTokenEntity confirmationTokenEntity = tokenService.getToken(token).get();
        log.info("Token: " + userRepository.findById(confirmationTokenEntity.getUser().getIduser()).get());
        User user = userRepository.findById(confirmationTokenEntity.getUser().getIduser()).get();
        user.setActive(1);
        save(user);
    }

    @Transactional
    public ResponseEntity<?> confirmToken(String token){
        ConfirmationTokenEntity confirmationTokenEntity = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.valueOf(404),"Token nie istnieje"));
        log.info("jest token");
        if (confirmationTokenEntity.getConfirmed() != null) {
//            throw new IllegalStateException("email already confirmed");
            throw new ResponseStatusException(HttpStatus.valueOf(401),"Email zostal potwierdzony");
        }

        LocalDateTime expired = confirmationTokenEntity.getExpired();

        if (expired.isBefore(LocalDateTime.now())) {
//            return "Czas na potwierdzenie minal. Sprobuj ponownie";
            throw new ResponseStatusException(HttpStatus.valueOf(410),"Czas na potwierdzenie minal. Sprobuj ponownie");
        }

        confirmationTokenService.setConfirmed(token);
        allowAccess(token);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private String buildEmail(String name, String link) {
        return "<div style=\"font-family:Helvetica,Arial,sans-serif;font-size:16px;margin:0;color:#0b0c0c\">\n" +
                "\n" +
                "<span style=\"display:none;font-size:1px;color:#fff;max-height:0\"></span>\n" +
                "\n" +
                "  <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;min-width:100%;width:100%!important\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"100%\" height=\"53\" bgcolor=\"#0b0c0c\">\n" +
                "        \n" +
                "        <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;max-width:580px\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">\n" +
                "          <tbody><tr>\n" +
                "            <td width=\"70\" bgcolor=\"#0b0c0c\" valign=\"middle\">\n" +
                "                <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td style=\"padding-left:10px\">\n" +
                "                  \n" +
                "                    </td>\n" +
                "                    <td style=\"font-size:28px;line-height:1.315789474;Margin-top:4px;padding-left:10px\">\n" +
                "                      <span style=\"font-family:Helvetica,Arial,sans-serif;font-weight:700;color:#ffffff;text-decoration:none;vertical-align:top;display:inline-block\">Confirm your email</span>\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "              </a>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"10\" height=\"10\" valign=\"middle\"></td>\n" +
                "      <td>\n" +
                "        \n" +
                "                <table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td bgcolor=\"#1D70B8\" width=\"100%\" height=\"10\"></td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\" height=\"10\"></td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "\n" +
                "\n" +
                "\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "      <td style=\"font-family:Helvetica,Arial,sans-serif;font-size:19px;line-height:1.315789474;max-width:560px\">\n" +
                "        \n" +
                "            <p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">Hi " + name + ",</p><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> Thank you for registering. Please click on the below link to activate your account: </p><blockquote style=\"Margin:0 0 20px 0;border-left:10px solid #b1b4b6;padding:15px 0 0.1px 15px;font-size:19px;line-height:25px\"><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> <a href=\"" + link + "\">Activate Now</a> </p></blockquote>\n Link will expire in 15 minutes. <p>See you soon</p>" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "  </tbody></table><div class=\"yj6qo\"></div><div class=\"adL\">\n" +
                "\n" +
                "</div></div>";
    }
}
