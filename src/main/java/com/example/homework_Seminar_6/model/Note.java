package com.example.homework_Seminar_6.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private long quantity;

    private LocalDateTime dateTime;

    @PrePersist
public void prePersist(){
    dateTime=LocalDateTime.now();
}

}
