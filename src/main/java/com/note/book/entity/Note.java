package com.note.book.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Note")
@Table(name = "NOTE", schema = "notebook")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "DATE_TIME", nullable = false)
    private String dateTime;

    @Column(name = "NOTE_TEXT", nullable = false)
    private String noteText;
}
