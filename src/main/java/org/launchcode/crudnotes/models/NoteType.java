package org.launchcode.crudnotes.models;

public enum NoteType {

    SHORTANSWER("Short-Answer"),
    ESSAY("Essay"),
    FLASHCARD("Flash-Card"),
    NUMBER("Number");

    private final String displayName;

    NoteType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
