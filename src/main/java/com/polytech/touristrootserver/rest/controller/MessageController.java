package com.polytech.touristrootserver.rest.controller;

import com.polytech.touristrootserver.rest.dto.ChatDto;
import com.polytech.touristrootserver.rest.dto.MessageDto;
import com.polytech.touristrootserver.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/message/insert")
    public MessageDto insert(@RequestBody MessageDto messageDto) {
        return MessageDto.toDto(messageService.insert(MessageDto.fromDto(messageDto)));
    }

}
