package com.note.book.controller;

import com.note.book.entity.Note;
import com.note.book.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private NoteService noteService;

    @GetMapping(path = "/home")
    public String getWelcomeMessage() {
        IO.println("Welcome home!");
        return "Welcome home!";
    }

    @PostMapping(path = "/note/add", consumes = "application/json")
    public Note addUser(@RequestBody Note note) {
        IO.println(note);
        this.noteService.addNote(note);
        return note;
    }

    @PutMapping(path = "/note/update/{id}", consumes = "application/json")
    public Note updateUser(@PathVariable Long id, @RequestBody Note note) {
        IO.println(note);
        this.noteService.updateNote(id, note);
        return note;
    }

    @GetMapping(path = "note/get/all")
    public List<Note> getAllNotes(){
        return this.noteService.getAllNotes();
    }

    @DeleteMapping("/note/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        this.noteService.deleteOneNoteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/note/delete/all")
    public ResponseEntity<Void> deleteUser() {
        this.noteService.deleteAllNotes();
        return ResponseEntity.ok().build();
    }
}
