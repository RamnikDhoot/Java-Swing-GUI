package com.com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the data model for the Notes Application.
 * It manages the list of notes.
 */
public class NotesModel {
    // List to store notes
    private List<String> notes;

    /**
     * Constructs a new NotesModel instance.
     */
    public NotesModel() {
        this.notes = new ArrayList<>();
    }

    /**
     * Adds a new note to the list.
     *
     * @param note The note to be added.
     */
    public void addNote(String note) {
        if (note != null && !note.trim().isEmpty()) {
            notes.add(note);
        }
    }

    /**
     * Deletes a note from the list at the specified index.
     *
     * @param index The index of the note to be deleted.
     * @throws IndexOutOfBoundsException If the index is out of range.
     */
    public void deleteNote(int index) throws IndexOutOfBoundsException {
        notes.remove(index);
    }

    /**
     * Returns an unmodifiable list of notes.
     *
     * @return A list of notes.
     */
    public List<String> getNotes() {
        return new ArrayList<>(notes); // Return a copy to avoid external modifications
    }
}
