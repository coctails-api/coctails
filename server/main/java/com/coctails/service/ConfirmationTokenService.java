package com.coctails.service;

import com.coctails.entity.ConfirmationTokenEntity;
import com.coctails.repository.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Log4j2
public class ConfirmationTokenService {
    private final ConfirmationTokenRepository confirmationTokenRepository;

    @Transactional
    public void save(ConfirmationTokenEntity token){
        confirmationTokenRepository.save(token);
    }

    public Optional<ConfirmationTokenEntity> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    public int setConfirmed(String token) {
        ConfirmationTokenEntity confirmationTokenEntity = confirmationTokenRepository.findByToken(token).get();
        confirmationTokenEntity.setConfirmed(LocalDateTime.now());
        return 1;
    }

    public ConfirmationTokenEntity generateNewToken(String token) {
        log.info("Generate new token" + token);
        log.info(getToken(token).get());
        ConfirmationTokenEntity confirmationToken = new ConfirmationTokenEntity(
                UUID.randomUUID().toString(),
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                getToken(token).get().getUser()
        );
        return confirmationToken;
    }
}
