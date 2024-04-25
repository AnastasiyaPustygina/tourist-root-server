package com.polytech.touristrootserver.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "chat")
@NamedEntityGraph(name = "chat-graph", attributeNodes = {@NamedAttributeNode("tourist"), @NamedAttributeNode("organization"),
@NamedAttributeNode("messages")})
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(targetEntity = Tourist.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "tourist_id")
    private Tourist tourist;

    @ManyToOne(targetEntity = Organization.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Message.class, cascade = CascadeType.REMOVE, mappedBy = "chat")
    private List<Message> messages;
}
