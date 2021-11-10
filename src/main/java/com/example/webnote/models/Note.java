package com.example.webnote.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
//
@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false, length = 50)
    private String header;
    @Column
    private String text;
    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    @JoinTable(name = "notes_user",
            joinColumns = @JoinColumn(
                    name = "note_id", unique = true, nullable = false),
            inverseJoinColumns = @JoinColumn(
                    name = "user_id", nullable = false)
    )
    private User user;
}