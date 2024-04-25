package com.polytech.touristrootserver.domain;

import com.polytech.touristrootserver.domain.enums.NotificationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "notification-entry")
public class NotificationEntry {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private NotificationStatus status;

    @ManyToOne(targetEntity = Entry.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "entry_id")
    private Entry entry;

    @ManyToOne(targetEntity = Tourist.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "tourist_id")
    private Tourist tourist;
}
