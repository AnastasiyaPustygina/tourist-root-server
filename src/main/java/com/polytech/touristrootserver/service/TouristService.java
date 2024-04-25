package com.polytech.touristrootserver.service;

import com.polytech.touristrootserver.domain.Tourist;
import org.springframework.transaction.annotation.Transactional;

public interface TouristService {
    Tourist register(Tourist tourist);

    Tourist login(String email, String password);

    Tourist update(Tourist tourist);

    Tourist updatePassword(String newPassword, long touristId);

    @Transactional
    Tourist getTouristById(long id);
}
