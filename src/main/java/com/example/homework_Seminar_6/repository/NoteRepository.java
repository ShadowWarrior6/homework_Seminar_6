package com.example.homework_Seminar_6.repository;

import com.example.homework_Seminar_6.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface NoteRepository extends JpaRepository<Note,Long> {

}
