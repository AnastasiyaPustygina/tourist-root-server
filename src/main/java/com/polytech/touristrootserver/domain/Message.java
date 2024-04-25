package com.polytech.touristrootserver.domain;

import com.polytech.touristrootserver.domain.enums.Sender;
import com.polytech.touristrootserver.domain.enums.StatusMessage;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "message")
public class Message {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusMessage status;

    @Column(name = "text")
    private String text;

    @Column(name = "datetime")
    private Timestamp datetime;

    @Column(name = "sender")
    @Enumerated(EnumType.STRING)
    private Sender sender;
    @ManyToOne(targetEntity = Chat.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_id")
    private Chat chat;

}
