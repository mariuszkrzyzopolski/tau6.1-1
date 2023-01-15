package com.example.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MockNotes implements NotesService, NotesStorage{
    List<Note> notesList = new ArrayList<>();

    @Override
    public void add(Note note) {

        notesList.add(note);

    }

    @Override
    public List<Note> getAllNotesOf(String name) {
        return notesList;
    }

    @Override
    public float averageOf(String name) {
        float sum = 0.0f;
        final Collection<Note> notes = notesList;
        for (final Note note : notes) {
            if (notesList.contains(name)) {
                sum += note.getNote();
            }

        }
        return sum / notes.size();
    }

    @Override
    public void clear() {

        notesList.clear();


    }
}
