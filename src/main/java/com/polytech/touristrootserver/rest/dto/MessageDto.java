package com.polytech.touristrootserver.rest.dto;

import com.polytech.touristrootserver.domain.Chat;
import com.polytech.touristrootserver.domain.Message;
import com.polytech.touristrootserver.domain.enums.Sender;
import com.polytech.touristrootserver.domain.enums.StatusMessage;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class MessageDto {
    private long id;
    private StatusMessage status;

    private String text;

    private Timestamp datetime;

    private Sender sender;

    public static MessageDto toDto(Message message){
        return MessageDto.builder().id(message.getId()).status(message.getStatus()).text(message.getText()).datetime(
                message.getDatetime()).sender(message.getSender()).build();
    }
    public static Message fromDto(MessageDto messageDto){
        return Message.builder().id(messageDto.getId()).status(messageDto.getStatus()).text(messageDto.getText()).datetime(
                messageDto.getDatetime()).sender(messageDto.getSender()).build();
    }
}
