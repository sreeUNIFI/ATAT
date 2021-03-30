package com.example.atat.converter;

import com.example.atat.command.NotesCommand;
import com.example.atat.domains.Notes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotesToNotesCommandTest {
    public static final Long ID_VALUE = 1L;
    public static final String DESCRIPTION = "description";
    NotesToNotesCommand toNotesCommand;

    @BeforeEach
    void setUp() {
        toNotesCommand = new NotesToNotesCommand();
    }

    @Test
    void testEmptyObject(){
        assertNotNull(toNotesCommand.convert(new Notes()));
    }

    @Test
    void testNullObject(){
        assertNull(toNotesCommand.convert(null));
    }

    @Test
    void convert() {
//        given
        Notes notes = new Notes();
        notes.setId(ID_VALUE);
        notes.setRecipeNotes(DESCRIPTION);

//        When
        NotesCommand command = toNotesCommand.convert(notes);
//        Then
        assertNotNull(command);
        assertEquals(ID_VALUE,command.getId());
        assertEquals(DESCRIPTION,command.getRecipeNotes());
    }
}