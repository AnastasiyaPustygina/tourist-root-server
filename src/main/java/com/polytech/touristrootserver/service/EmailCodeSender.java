package com.polytech.touristrootserver.service;

import com.polytech.touristrootserver.domain.EmailCode;

public interface EmailCodeSender {
    void sendCode(EmailCode emailCode);
}
