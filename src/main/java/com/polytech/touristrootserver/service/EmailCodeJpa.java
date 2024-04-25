package com.polytech.touristrootserver.service;

import com.polytech.touristrootserver.domain.EmailCode;
import com.polytech.touristrootserver.repository.EmailCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class EmailCodeJpa implements EmailCodeService{

    private final EmailCodeRepository repository;
    private final EmailCodeSender sender;

    @Override
    public void insert(String email) {
        if(repository.findByEmail(email).isPresent()) update(email);
        else{
            EmailCode code = repository.save(EmailCode.builder().email(email).value(generateCode()).build());
            sender.sendCode(code);
        }
    }

    @Override
    public void update(String email) {
        Optional<EmailCode> emailCode = repository.findByEmail(email);
        if(emailCode.isEmpty()) insert(email);
        else{
            EmailCode code = repository.save(EmailCode.builder().id(emailCode.get().getId())
                    .email(email).value(generateCode()).build());
            sender.sendCode(code);
        }
    }

    @Override
    public boolean isEqual(EmailCode emailCode) {
        return emailCode.getValue().equals(repository.findByEmail(emailCode.getEmail()).get().getValue());
    }

    private String generateCode(){
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }
}
