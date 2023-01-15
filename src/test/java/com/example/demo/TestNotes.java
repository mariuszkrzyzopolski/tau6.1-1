package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestNotes {
    NotesStorage notesService;
    Note noteOne = new Note("one", 1.0f);
    Note noteTwo = new Note("two", 2.0f);

    MockNotes storage = new MockNotes();

    @BeforeEach
    public void setUp() {
        storage.add(noteOne);
        storage.add(noteTwo);
    }

    @Test
    public void testNotEmpty() {
        boolean noteEmpty = storage.getAllNotesOf("name1").isEmpty();
        assertFalse(noteEmpty);
    }

    @Test
    public void testStorageCleared() {
        storage.clear();
        assertTrue(storage.notesList.isEmpty());
    }

}
