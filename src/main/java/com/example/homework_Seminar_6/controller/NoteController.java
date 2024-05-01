package com.example.homework_Seminar_6.controller;

import lombok.RequiredArgsConstructor;
import com.example.homework_Seminar_6.model.Note;
import com.example.homework_Seminar_6.service.NoteService;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService service;
    @GetMapping("/{id}")
    public ResponseEntity<List <Note>>getAll(){
       return new ResponseEntity<>(service.getAllNotes(), HttpStatus.OK );

    }
    @PostMapping
    public ResponseEntity<Note>create(@RequestBody Note note){
        return new ResponseEntity<>(service.createNotes(note),HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Note>getProductById(@PathVariable("id") Long id){
        Note noteById;
        try {
            noteById =service.getNotesById(id);

        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());

        }
        return new ResponseEntity<>(noteById,HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Note>redact(@RequestBody Note note){
        return new ResponseEntity<>(service.redactNotes(note),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Note>delete(@PathVariable("id")Long id){
       service.deleteNotes(id);
       return new ResponseEntity<>(HttpStatus.OK);
    }



}
