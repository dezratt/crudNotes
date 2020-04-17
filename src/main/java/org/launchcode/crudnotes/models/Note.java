package org.launchcode.crudnotes.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
public class Note extends AbstractEntity{


    @NotBlank(message = "Can't be blank!")
    @Size(min = 10, max = 50, message = "Type your full school name out!")
    private String name;

    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message = "Need a note to study!")
    @Size(min=1, max = 1000, message = "Must be between 1 and 1000 characters!")
    private String studyNote;

    private NoteType type;

    public Note(String name, String description, String studyNote, NoteType type) {
        this.name = name;
        this.description = description;
        this.studyNote = studyNote;
        this.type = type;

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

    public NoteType getType() {
        return type;
    }

    public void setType(NoteType type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return name;
    }

}
