package com.massage.controller.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {
    private final ConfirmationTokenRepository confirmationTokenRepository;

    @Transactional
    public void save(ConfirmationToken token){
        confirmationTokenRepository.save(token);
    }
}
