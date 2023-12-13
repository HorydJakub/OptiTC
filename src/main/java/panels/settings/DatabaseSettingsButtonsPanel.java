package panels.settings;

import core.PropertiesHandler;
import core.SqlBuilder;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DatabaseSettingsButtonsPanel extends JPanel {

    public DatabaseSettingsButtonsPanel() {

        JButton saveButton = new JButton("Save");

        // Add components to the panel
        add(saveButton);

        // Add action listeners
        saveButton.addActionListener(e -> {
            List<String> emptyFields = getListOfEmptyFields();
            if (emptyFields.isEmpty()) {
                PropertiesHandler.updateProperties(
                        UrlPanel.getOptiTextField().getText(),
                        UsernamePanel.getOptiTextField().getText(),
                        PasswordPanel.getOptiTextField().getText());
                JOptionPane.showMessageDialog(null, "Database settings saved!");

                String connectionMessage = SqlBuilder.isConnected() ? "Connected to database!" : "Could not connect to database! Try again.";
                JOptionPane.showMessageDialog(null, connectionMessage);
            } else {
                JOptionPane.showMessageDialog(null, "Please fill out the following fields: " + String.join(", ", emptyFields));
            }

        });
    }

    private List<String> getListOfEmptyFields() {
        return Stream.of(
                        UrlPanel.getOptiTextField(),
                        UsernamePanel.getOptiTextField(),
                        PasswordPanel.getOptiTextField())
                .filter(textField -> textField.getText().equals("Please fill out this field!"))
                .map(this::getFieldName)
                .collect(Collectors.toList());
    }

    private String getFieldName(JTextField textField) {
        if (textField == UrlPanel.getOptiTextField()) {
            return "URL";
        } else if (textField == UsernamePanel.getOptiTextField()) {
            return "Username";
        }
        return "Password";
    }
}
