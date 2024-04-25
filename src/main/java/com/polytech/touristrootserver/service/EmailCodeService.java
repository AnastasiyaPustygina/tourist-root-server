package com.polytech.touristrootserver.service;

import com.polytech.touristrootserver.domain.EmailCode;

public interface EmailCodeService {

    void insert(String email);

    void update(String email);

    boolean isEqual(EmailCode emailCode);
}
