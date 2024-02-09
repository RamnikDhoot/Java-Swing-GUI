package com.example;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class NoteManager {
    private NoteData model;
    private NoteInterface view;

    public NoteManager(NoteData model, NoteInterface view) {
        this.model = model;
        this.view = view;
        initializeView();
    }

    private void initializeView() {
        // Initialize listeners
        view.setAddNoteButtonAction(e -> createNote());
        view.setOpenMenuAction(e -> loadFile());
        view.setSaveMenuAction(e -> writeFile());
        view.setOpenMenuAction(e -> printNoteDetails());
        view.setOpenMenuAction(e -> createNewNote());
        view.setExitMenuAction(e -> terminateApplication());
    }

    private void createNote() {
        String noteContent = view.getNoteText().trim();
        if (!noteContent.isEmpty()) {
            model.appendNote(noteContent);
            view.getNoteText();
            JOptionPane.showMessageDialog(view.getMainFrame(), "Note has been added!", "Operation Successful", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void loadFile() {
        JFileChooser chooser = new JFileChooser();
        int option = chooser.showOpenDialog(view.getMainFrame());
        if (option == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            try (FileReader fileReader = new FileReader(selectedFile)) {
                view.getNoteText().read(fileReader, null);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(view.getMainFrame(), "Failed to load file", "Read Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void writeFile() {
        JFileChooser chooser = new JFileChooser();
        int option = chooser.showSaveDialog(view.getMainFrame());
        if (option == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            try (FileWriter fileWriter = new FileWriter(selectedFile)) {
                view.getNoteText().write(fileWriter);
                JOptionPane.showMessageDialog(view.getMainFrame(), "File has been saved!", "Operation Successful", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(view.getMainFrame(), "Failed to save file", "Write Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void printNoteDetails() {
        // Print note functionality to be implemented
        System.out.println("Printing functionality currently unavailable.");
    }

    private void createNewNote() {
        view.getNoteText();
    }

    private void terminateApplication() {
        System.exit(0);
    }
}
