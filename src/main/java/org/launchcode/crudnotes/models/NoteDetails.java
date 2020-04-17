package org.launchcode.crudnotes.models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class NoteDetails extends AbstractEntity {

    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message = "Need a note to study!")
    @Size(min=1, max = 1000, message = "Must be between 1 and 1000 characters!")
    private String studyNote;

    public NoteDetails(@Size(max = 500, message = "Description too long!") String description, @NotBlank(message = "Need a note to study!") @Size(min = 1, max = 1000, message = "Must be between 1 and 1000 characters!") String studyNote) {
        this.description = description;
        this.studyNote = studyNote;
    }

    public NoteDetails() {}

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
}
