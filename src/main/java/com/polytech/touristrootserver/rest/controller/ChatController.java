package com.polytech.touristrootserver.rest.controller;

import com.polytech.touristrootserver.rest.dto.ChatDto;
import com.polytech.touristrootserver.rest.dto.EventDto;
import com.polytech.touristrootserver.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;

    @GetMapping("/chat/{id}")
    public ChatDto getById(@PathVariable(name = "id") long id) {
        return ChatDto.toDto(chatService.getChatById(id));
    }

    @GetMapping("/chat/tourist/{id}")
    public List<ChatDto> getByTouristId(@PathVariable(name = "id") long id) {
        return chatService.getChatsByTouristId(id).stream().map(ChatDto::toDto).toList();
    }

    @GetMapping("/chat/organization/{id}")
    public List<ChatDto> getByOrganizationId(@PathVariable(name = "id") long id) {
        return chatService.getChatsByOrganizationId(id).stream().map(ChatDto::toDto).toList();
    }

    @PostMapping("/chat/insert")
    public ChatDto insert(@RequestBody ChatDto chatDto) {
        return ChatDto.toDto(chatService.insert(ChatDto.fromDto(chatDto)));
    }
}
