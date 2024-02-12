package com.com.example;

public class NotesController {
    private NotesModel model;
    private NotesView view;

    public NotesController(NotesModel model, NotesView view) {
        this.model = model;
        this.view = view;
        setupEventListeners();
    }

    private void setupEventListeners() {
        view.addAddNoteButtonListener(e -> {
            String noteText = view.getNoteTextArea().getText();
            if (!noteText.trim().isEmpty()) {
                model.addNote(noteText);
                view.clearNoteTextArea(); 
            }
        });


        model.addChangeListener(this::updateView);
    }

    private void updateView(List<String> notes) {
        
    }

    public void initializeView() {
        updateView(model.getNotes());
    }
}
