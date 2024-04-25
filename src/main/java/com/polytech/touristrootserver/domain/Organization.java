package com.polytech.touristrootserver.domain;

import com.polytech.touristrootserver.domain.enums.OrganizationStatus;
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
@Table(name = "organization")
@NamedEntityGraph(name = "organization-graph", attributeNodes = {
@NamedAttributeNode("documents")})
public class Organization {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "fullname", unique = true)
    private String fullname;

    @Column(name = "shortname")
    private String shortname;

    @Column(name = "website", unique = true)
    private String website;

    @Column(name = "contacts")
    private String contacts;

    @Column(name = "information")
    private String information;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private OrganizationStatus status;

    @OneToOne(targetEntity = Manager.class)
    @JoinColumn(name = "manager_id", nullable = false)
    private Manager manager;

    @OneToMany(targetEntity = Image.class, cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY)
    private List<Image> documents;

    @OneToOne(targetEntity = Image.class)
    @JoinColumn(name = "image_id")
    private Image image;

    @OneToMany(targetEntity = Entry.class, cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY)
    private List<Entry> entries;

    @OneToMany(targetEntity = Event.class, cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY)
    private List<Event> events;

    @OneToMany(targetEntity = Chat.class, cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "organization")
    private List<Chat> chats;

    @OneToMany(targetEntity = NotificationEntry.class, cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY)
    private List<NotificationEntry> notificationEntries;

    @OneToMany(targetEntity = NotificationMessage.class, cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY, mappedBy = "organization")
    private List<NotificationMessage> notificationMessages;
}
