package panels.settings;

import core.PropertiesHandler;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseSettingsButtonsPanel extends JPanel {

    public DatabaseSettingsButtonsPanel() {

        JButton saveButton = new JButton("Save");

        // Add components to the panel
        add(saveButton);

        // Add action listeners
        saveButton.addActionListener(e -> {
            if (getListOfEmptyFields().isEmpty()) {
                // Update the properties file
                // ToDO: Add password field
                JOptionPane.showMessageDialog(null, "The settings have been saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Please fill out the following fields: " + getListOfEmptyFields(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

    }

    private List<String> getListOfEmptyFields() {
        List<String> emptyFields = new ArrayList<>();
        if (UrlPanel.getOptiTextField().getText().equals("Please fill out this field!")) {
            emptyFields.add("URL");
        }
        if (UsernamePanel.getOptiTextField().getText().equals("Please fill out this field!")) {
            emptyFields.add("Username");
        }
        return emptyFields;
    }

}
