package com.polytech.touristrootserver.domain;

import com.polytech.touristrootserver.domain.enums.Category;
import com.polytech.touristrootserver.domain.enums.StatusEvent;
import com.polytech.touristrootserver.domain.enums.StatusMessage;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "event")
@NamedEntityGraph(name = "event-graph", attributeNodes = {@NamedAttributeNode("images"), @NamedAttributeNode("entries")})
public class Event {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private int cost;

    @Column(name = "current_count")
    private int currentCount;

    @Column(name = "max_count")
    private int maxCount;

    @Column(name = "place")
    private String place;

    @Column(name = "category")
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @Column(name = "date_start")
    private Timestamp dateStart;

    @Column(name = "date_end")
    private Timestamp dateEnd;

    @Column(name = "requirement")
    private String requirement;

    @Column(name = "information")
    private String information;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private StatusEvent status;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Entry.class, cascade = CascadeType.REMOVE, mappedBy = "event")
    private List<Entry> entries;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
    @JoinColumn(name = "organization_id")
    private Organization organization;
    @OneToMany(targetEntity = Image.class, cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinTable(name = "event_images", joinColumns = @JoinColumn(name = "event_id",
            referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "images_id", referencedColumnName = "id"))
    private List<Image> images;

}
