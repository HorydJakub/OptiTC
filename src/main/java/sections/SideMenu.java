package sections;

import components.ExitConfirmationPopup;
import components.OptiSideMenuButton;
import core.ConstantValues;
import core.SqlBuilder;
import core.TestCaseAppManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SideMenu extends JPanel {

    public SideMenu() {
        setPreferredSize(new Dimension(ConstantValues.SCREEN_WIDTH / 6, ConstantValues.SCREEN_HEIGHT));
        setLayout(new GridLayout(6, 1));

        addTitleLabel();
        addMenuButton("Main Menu", () -> switchDashboardContent(new MainMenu()));

        addMenuButton("Create New Test Case", () -> {
            if (!SqlBuilder.isConnected()) {
                showConnectionErrorMessage();
                switchDashboardContent(new SettingsMenu());
            } else {
                switchDashboardContent(new CreateNewTestCaseMenu());
            }
        });

        addMenuButton("Manage Test Cases", () -> {
            if (!SqlBuilder.isConnected()) {
                showConnectionErrorMessage();
                switchDashboardContent(new SettingsMenu());
            } else {
                switchDashboardContent(new ManageTestCasesMenu());
            }
        });

        addMenuButton("Settings", () -> switchDashboardContent(new SettingsMenu()));
        addExitButton();
    }

    private void addTitleLabel() {
        JLabel title = new JLabel(ConstantValues.APP_NAME + " " + ConstantValues.APP_VERSION);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.LIGHT_GRAY));
        add(title);
    }

    private void addMenuButton(String buttonText, Runnable action) {
        OptiSideMenuButton button = new OptiSideMenuButton(buttonText);
        button.addActionListener(e -> action.run());
        add(button);
    }

    private void addExitButton() {
        OptiSideMenuButton exitButton = new OptiSideMenuButton("Exit");
        exitButton.addActionListener(this::showExitConfirmation);
        add(exitButton);
    }

    private void showConnectionErrorMessage() {
        JOptionPane.showMessageDialog(null, "You are not connected to the database. Please configure your connection first.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void switchDashboardContent(JPanel contentPanel) {
        TestCaseAppManager.getDashboard().removeAll();
        TestCaseAppManager.getDashboard().add(contentPanel);
        TestCaseAppManager.getDashboard().revalidate();
        TestCaseAppManager.getDashboard().repaint();
    }

    private void showExitConfirmation(ActionEvent event) {
        new ExitConfirmationPopup();
    }
}
