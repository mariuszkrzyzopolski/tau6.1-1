package com.example.demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestNotesMock {


    @Test
    public void addNoteTest() {
        NotesStorage mockedStorage = createMock(NotesStorage.class);
        NotesService service = NotesServiceImpl.createWith(mockedStorage);

        Note note = new Note("Tester", 7.0f);
        mockedStorage.add(note);
        expectLastCall();
        replay(mockedStorage);

        service.add(note);

        verify(mockedStorage);
    }

    @Test
    public void clearNotesTest() {
        NotesStorage mockedStorage = createMock(NotesStorage.class);
        NotesService service = NotesServiceImpl.createWith(mockedStorage);

        mockedStorage.clear();
        expectLastCall();
        replay(mockedStorage);

        service.clear();

        verify(mockedStorage);
    }

    @Test
    public void getAllOfNotesTest() {
        NotesStorage mockedStorage = createMock(NotesStorage.class);
        NotesService service = NotesServiceImpl.createWith(mockedStorage);

        Note note = new Note("Tester", 7.0f);
        mockedStorage.add(note);
        expect(mockedStorage.getAllNotesOf("Tester")).andReturn(new ArrayList<Note>());
        replay(mockedStorage);

        float testedAverage = service.averageOf("Tester");

        assertEquals(Float.NaN, testedAverage, 7.0f);



    }
}
