package com.com.example;

import javax.swing.SwingUtilities;

/**
 * The main class that launches the Notes Application.
 * It sets up the Model-View-Controller architecture and initializes the application.
 */
public class NotesApplication {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NotesModel model = new NotesModel();
            NotesView view = new NotesView();
            NotesController controller = new NotesController(model, view);
            
            view.showGUI(); // Make sure the GUI is visible
        });
    }

    /** 
    * Preloads the model with some example notes. This is optional and can be adjusted
    * or removed depending on the application requirements.
    *
    * @param model The notes model to preload data into.
    */
   private static void preloadModelWithData(NotesModel model) {
       model.addNote("Welcome to the Notes Application!");
       model.addNote("Use the menu or toolbar to add, edit, or delete notes.");
       model.addNote("Your notes will appear here.");
   }
}
