package org.launchcode.crudnotes.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Note extends AbstractEntity{

    @NotBlank(message = "Can't be blank!")
    @Size(min = 4, max = 50, message = "Type your full school name out!")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private NoteDetails noteDetails;

    @ManyToOne
    @NotNull(message = "Type is required")
    private NoteCategory noteCategory;

    public Note(String name, NoteCategory noteCategory) {
        this.name = name;
        this.noteCategory = noteCategory;

    }

    public Note() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NoteCategory getNoteCategory() {
        return noteCategory;
    }

    public void setNoteCategory(NoteCategory noteCategory) {
        this.noteCategory = noteCategory;
    }

    public NoteDetails getNoteDetails() {
        return noteDetails;
    }

    public void setNoteDetails(NoteDetails noteDetails) {
        this.noteDetails = noteDetails;
    }

    @Override
    public String toString() {
        return name;
    }

}
