package org.launchcode.crudnotes.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Note {

    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Can't be blank!")
    @Size(min = 10, max = 50, message = "Type your full school name out!")
    private String name;

    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message = "Need a note to study!")
    @Size(min=1, max = 1000, message = "Must be between 1 and 1000 characters!")
    private String studyNote;

    public Note(String name, String description, String studyNote) {
        this.name = name;
        this.description = description;
        this.studyNote = studyNote;
        this.id = nextId;
        nextId++;
    }

    public Note() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStudyNote() {
        return studyNote;
    }

    public void setStudyNote(String studyNote) {
        this.studyNote = studyNote;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return id == note.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
