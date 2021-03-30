package com.example.atat.converter;

import com.example.atat.command.NotesCommand;
import com.example.atat.domains.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {
    @Override
    @Synchronized
    @Nullable
    public Notes convert(NotesCommand notesCommand) {
        if (notesCommand==null){
            return null;
        }

        final Notes notes = new Notes();
        notes.setId(notesCommand.getId());
        notes.setRecipeNotes(notesCommand.getRecipeNotes());
        return notes; }
}

