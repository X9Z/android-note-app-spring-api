package com.note.book.service;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.note.book.entity.Note;
import com.note.book.repository.NoteRepository;
import com.note.book.service.interfaces.NoteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService implements NoteServiceInterface {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public boolean addNote(Note note) {
        try {
            this.noteRepository.save(note);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateNote(Long id, Note note) {
        try {
            Note update = this.noteRepository.findById(id).orElseThrow();
            update.setDateTime(note.getDateTime());
            update.setNoteText(note.getNoteText());
            this.noteRepository.save(update);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteOneNote(Note note) {
        try {
            this.noteRepository.delete(note);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteOneNoteById(Long id) {
        try {
            this.noteRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteAllNotes() {
        try {
            this.noteRepository.deleteAll();
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public List<Note> getAllNotes() {
        return this.noteRepository.findAll();
    }
}
