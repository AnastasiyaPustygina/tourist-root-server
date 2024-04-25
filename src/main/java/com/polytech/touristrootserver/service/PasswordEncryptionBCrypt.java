package com.polytech.touristrootserver.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;

@Service
public class PasswordEncryptionBCrypt{
    public String encrypt(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(6));
    }
    public boolean isSamePassword(String password1, String password2) {
        return BCrypt.checkpw(password1, password2);
    }
}
