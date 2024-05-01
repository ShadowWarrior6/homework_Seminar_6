package com.example.homework_Seminar_6.service;

import com.example.homework_Seminar_6.model.Note;

import java.util.List;

public interface NoteService {


    List<Note>getAllNotes();
    Note getNotesById(Long id);
    Note redactNotes(Note note);
    Note updateNotes(Note note);
    Note createNotes(Note note);
    void deleteNotes(Long id);


}
