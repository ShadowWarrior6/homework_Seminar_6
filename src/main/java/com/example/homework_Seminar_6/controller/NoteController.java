package com.example.homework_Seminar_6.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import com.example.homework_Seminar_6.model.Note;
import com.example.homework_Seminar_6.service.NoteService;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@AllArgsConstructor
public class NoteController {
    private final NoteService service;
    @GetMapping("/getAll")
    public ResponseEntity<List <Note>>getAll(){
       return new ResponseEntity<>(service.getAllNotes(), HttpStatus.OK );

    }
    @PostMapping("/create")
    public ResponseEntity<Note>create(@RequestBody Note note){
        return new ResponseEntity<>(service.createNotes(note),HttpStatus.CREATED);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Note>getProductById(@PathVariable("id") Long id){
        Note noteById;
        try {
            noteById =service.getNotesById(id);

        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());

        }
        return new ResponseEntity<>(noteById,HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Note>redact(@RequestBody Note note,@PathVariable("id") Long id){
        return new ResponseEntity<>(service.redactNotes(note),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Note>delete(@PathVariable("id")Long id){
       service.deleteNotes(id);
       return new ResponseEntity<>(HttpStatus.OK);
    }



}
