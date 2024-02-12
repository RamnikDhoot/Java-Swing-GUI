
package com.com.example; 

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Represents the data model for the Notes Application.
 * It manages the list of notes and notifies observers about changes.
 */
public class NotesModel {
    private List<String> notes;
    private List<Consumer<List<String>>> changeListeners;

    /**
     * Constructs a new NotesModel instance.
     */
    public NotesModel() {
        this.notes = new ArrayList<>();
        this.changeListeners = new ArrayList<>();
    }

    /**
     * Adds a new note to the list and notifies observers.
     *
     * @param note The note to be added.
     */
    public void addNote(String note) {
        if (note != null && !note.trim().isEmpty()) {
            notes.add(note);
            notifyChangeListeners();
        }
    }

    /**
     * Deletes a note from the list at the specified index and notifies observers.
     *
     * @param index The index of the note to be deleted.
     * @throws IndexOutOfBoundsException If the index is out of range.
     */
    public void deleteNote(int index) throws IndexOutOfBoundsException {
        notes.remove(index);
        notifyChangeListeners();
    }

    /**
     * Edits an existing note at the specified index with the provided text and notifies observers.
     *
     * @param index The index of the note to be edited.
     * @param newText The new text for the note.
     * @throws IndexOutOfBoundsException If the index is out of range.
     */
    public void editNote(int index, String newText) throws IndexOutOfBoundsException {
        notes.set(index, newText);
        notifyChangeListeners();
    }

    /**
     * Searches for notes containing the specified text.
     *
     * @param query The text to search for.
     * @return A list of notes containing the query.
     */
    public List<String> searchNotes(String query) {
        List<String> searchResults = new ArrayList<>();
        for (String note : notes) {
            if (note.contains(query)) {
                searchResults.add(note);
            }
        }
        return searchResults;
    }

    /**
     * Returns an unmodifiable list of notes.
     *
     * @return A list of notes.
     */
    public List<String> getNotes() {
        return new ArrayList<>(notes); // Return a copy to avoid external modifications
    }

    /**
     * Adds a change listener to be notified about changes in the notes list.
     *
     * @param listener The listener to add.
     */
    public void addChangeListener(Consumer<List<String>> listener) {
        changeListeners.add(listener);
    }

    /**
     * Notifies all registered change listeners about a change in the notes list.
     */
    private void notifyChangeListeners() {
        for (Consumer<List<String>> listener : changeListeners) {
            listener.accept(new ArrayList<>(notes)); // Pass a copy of the notes list
        }
    }

    public void addChangeListener(Object listener) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addChangeListener'");
    }

     public void saveNotesToFile(String filename) {
        try (PrintWriter out = new PrintWriter(filename)) {
            for (String note : notes) {
                out.println(note);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void loadNotesFromFile(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                addNote(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
