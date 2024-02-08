package com.com.example;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class NotesController {
    private NotesModel model;
    private NotesView view;

    public NotesController(NotesModel model, NotesView view) {
        this.model = model;
        this.view = view;
        initView();
    }

    private void initView() {
        // Register listeners
        view.addAddNoteButtonListener(e -> addNote());
        view.addOpenMenuItemListener(e -> openFile());
        view.addSaveMenuItemListener(e -> saveFile());
        view.addPrintMenuItemListener(e -> printNote());
        view.addNewMenuItemListener(e -> newNote());
        view.addExitMenuItemListener(e -> exitApplication());
    }

    private void addNote() {
        String note = view.getNoteTextArea().getText().trim();
        if (!note.isEmpty()) {
            model.addNote(note);
            view.clearNoteTextArea();
            JOptionPane.showMessageDialog(view.getFrame(), "Note added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(view.getFrame());
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (FileReader reader = new FileReader(file)) {
                view.getNoteTextArea().read(reader, null);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(view.getFrame(), "Could not open file", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void saveFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(view.getFrame());
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (FileWriter writer = new FileWriter(file)) {
                view.getNoteTextArea().write(writer);
                JOptionPane.showMessageDialog(view.getFrame(), "File saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(view.getFrame(), "Could not save file", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void printNote() {
        // Implement the printing logic here
        System.out.println("Print functionality is not implemented yet.");
    }

    private void newNote() {
        view.clearNoteTextArea();
    }

    private void exitApplication() {
        System.exit(0);
    }
}
