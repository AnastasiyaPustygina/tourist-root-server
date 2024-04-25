package com.polytech.touristrootserver.rest.controller;

import com.polytech.touristrootserver.domain.EmailCode;
import com.polytech.touristrootserver.rest.dto.ChatDto;
import com.polytech.touristrootserver.service.EmailCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class EmailCodeController {
    private final EmailCodeService emailCodeService;

    @PostMapping("/emailcode/insert")
    public boolean insert(@RequestParam String email) {
        emailCodeService.insert(email);
        return true;
    }

    @PutMapping("/emailcode/update")
    public boolean update(@RequestParam String email) {
        emailCodeService.update(email);
        return true;
    }

    @PostMapping("/emailcode/compare")
    public boolean compare(@RequestParam String email, @RequestParam String code) {
        return emailCodeService.isEqual(new EmailCode(0, code, email));
    }
}
