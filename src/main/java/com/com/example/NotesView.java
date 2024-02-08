package com.com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class NotesView {
    private JFrame frame;
    private JTextArea noteTextArea;
    private JButton addNoteButton;
    private JMenuBar mainMenuBar;
    private JMenuItem openMenuItem, saveMenuItem, printMenuItem, newMenuItem, exitMenuItem;

    public NotesView() {
        initialize();
    }

    private void initialize() {
        // Main application frame
        frame = new JFrame("Notes Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);

        // Text area for notes
        noteTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(noteTextArea); // Add scroll pane to text area
        frame.add(scrollPane, BorderLayout.CENTER);

        // Add Note button
        addNoteButton = new JButton("Add Note");
        frame.add(addNoteButton, BorderLayout.SOUTH);

        // Menu bar
        mainMenuBar = new JMenuBar();
        
        // File menu
        JMenu fileMenu = new JMenu("File");
        newMenuItem = new JMenuItem("New");
        openMenuItem = new JMenuItem("Open");
        saveMenuItem = new JMenuItem("Save");
        printMenuItem = new JMenuItem("Print");
        exitMenuItem = new JMenuItem("Exit");
        
        // Add menu items to file menu
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(printMenuItem);
        fileMenu.add(exitMenuItem);

        // Add file menu to menu bar
        mainMenuBar.add(fileMenu);
        
        // Set the menu bar to the frame
        frame.setJMenuBar(mainMenuBar);
    }

    public void showGUI() {
        frame.setVisible(true);
    }

    // Getters for components to which the controller might need access
    public JTextArea getNoteTextArea() {
        return noteTextArea;
    }

    public JFrame getFrame() {
        return frame;
    }

    // Methods to register event handlers
    public void addAddNoteButtonListener(ActionListener listener) {
        addNoteButton.addActionListener(listener);
    }

    public void addOpenMenuItemListener(ActionListener listener) {
        openMenuItem.addActionListener(listener);
    }

    public void addSaveMenuItemListener(ActionListener listener) {
        saveMenuItem.addActionListener(listener);
    }

    public void addPrintMenuItemListener(ActionListener listener) {
        printMenuItem.addActionListener(listener);
    }

    public void addNewMenuItemListener(ActionListener listener) {
        newMenuItem.addActionListener(listener);
    }

    public void addExitMenuItemListener(ActionListener listener) {
        exitMenuItem.addActionListener(listener);
    }

    // Utility methods for common UI operations
    public void clearNoteTextArea() {
        noteTextArea.setText("");
    }

    public void showMessageDialog(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(frame, message, title, messageType);
    }
}
