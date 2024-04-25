package com.polytech.touristrootserver.domain;

import com.polytech.touristrootserver.domain.enums.AgePeriod;
import com.polytech.touristrootserver.domain.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tourist")
@NamedEntityGraph(name = "tourist-graph", attributeNodes = {@NamedAttributeNode("chats"),
@NamedAttributeNode("entries"), @NamedAttributeNode("notificationMessages"), @NamedAttributeNode("notificationEntries")})
public class Tourist {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "gender")
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(name = "age-period")
    @Enumerated(value = EnumType.STRING)
    private AgePeriod agePeriod;

    @Column(name = "information")
    private String information;

    @Column(name = "password")
    private String password;

    @OneToMany(targetEntity = Entry.class, cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "tourist")
    private List<Entry> entries;

    @OneToMany(targetEntity = Chat.class, cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "tourist")
    private List<Chat> chats;

    @OneToMany(targetEntity = NotificationEntry.class, cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY, mappedBy = "tourist")
    private List<NotificationEntry> notificationEntries;

    @OneToMany(targetEntity = NotificationMessage.class, cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY, mappedBy = "tourist")
    private List<NotificationMessage> notificationMessages;

    @OneToOne(targetEntity = Image.class)
    @JoinColumn(name = "image_id")
    private Image image;
}
