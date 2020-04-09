package org.launchcode.crudnotes.data;

import org.launchcode.crudnotes.models.Note;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class NoteData {

    private static final Map<Integer, Note> notes = new HashMap<>();

    public static Collection<Note> getAll() {
        return notes.values();
    }

    public static Note getById(int id) {
        return notes.get(id);
    }

    public static void add(Note note) {
        notes.put(note.getId(), note);
    }

    public static void remove(int id) {
        notes.remove(id);
    }

}
