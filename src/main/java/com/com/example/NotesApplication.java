package com.com.example;

import javax.swing.SwingUtilities;

public class NotesApplication {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NotesModel model = new NotesModel();
            NotesView view = new NotesView();
            NotesController controller = new NotesController(model, view);
            
            view.showGUI(); // Make sure the GUI is visible
        });
    }
}
