package com.note.book.service.interfaces;

import com.note.book.entity.Note;

import java.util.List;

public interface NoteServiceInterface {
    boolean addNote(Note note);
    boolean updateNote(Long id, Note note);
    boolean deleteOneNote(Note note);
    boolean deleteOneNoteById(Long id);
    boolean deleteAllNotes();
    List<Note> getAllNotes();
}
