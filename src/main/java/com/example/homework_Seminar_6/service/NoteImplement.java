package com.example.homework_Seminar_6.service;

import com.example.homework_Seminar_6.model.Note;
import com.example.homework_Seminar_6.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class NoteImplement implements NoteService {
    private final NoteRepository productRepo;



    @Override
    public List<Note> getAllNotes() {
        return productRepo.findAll();
    }


    @Override
    public Note getNotesById(Long id) {
        return productRepo.findById(id).orElseThrow(null);
    }

    @Override
    public Note redactNotes(Note note) {
       Note noteRedact =getNotesById(note.getId());
       noteRedact.setName(note.getName());
       return productRepo.save(noteRedact);

    }

    @Override
    public Note updateNotes(Note note) {
        Note noteById = getNotesById(note.getId());


        noteById.setName(note.getName());
        noteById.setQuantity(note.getQuantity());


        return productRepo.save(noteById);
    }

    @Override
    public Note createNotes(Note note) {
        return productRepo.save(note);
    }

    @Override
    public void deleteNotes(Long id) {
        Note noteById = getNotesById(id);
        productRepo.delete(noteById);
    }
}
