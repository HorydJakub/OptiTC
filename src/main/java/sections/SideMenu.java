package sections;

import components.ExitConfirmationPopup;
import components.OptiSideMenuButton;
import core.ConstantValues;
import core.SqlBuilder;
import core.TestCaseAppManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class SideMenu extends JPanel {

    public SideMenu() {

        // The left menu width should be at leat 1/6 of width of the screen
        setPreferredSize(new Dimension(ConstantValues.SCREEN_WIDTH/6, ConstantValues.SCREEN_HEIGHT));

        // Set the layout of the panel
        setLayout(new GridLayout(6, 1));

        // Title of application
        JLabel title = new JLabel(ConstantValues.APP_NAME + " " + ConstantValues.APP_VERSION);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.LIGHT_GRAY));

        // List of buttons
        OptiSideMenuButton mainMenuButton = new OptiSideMenuButton("Main Menu");
        OptiSideMenuButton createNewTestCaseButton = new OptiSideMenuButton("Create New Test Case");
        OptiSideMenuButton manageTestCasesButton = new OptiSideMenuButton("Manage Test Cases");
        OptiSideMenuButton settingsButton = new OptiSideMenuButton("Settings");
        OptiSideMenuButton exitButton = new OptiSideMenuButton("Exit");

        // Add components to the panel
        add(title);
        add(mainMenuButton);
        add(createNewTestCaseButton);
        add(manageTestCasesButton);
        add(settingsButton);
        add(exitButton);

        // Add action listeners to the buttons

        // Main Menu Button
        mainMenuButton.addActionListener(e -> {
            TestCaseAppManager.getDashboard().removeAll();
            TestCaseAppManager.getDashboard().add(new MainMenu());
            TestCaseAppManager.getDashboard().revalidate();
            TestCaseAppManager.getDashboard().repaint();
        });

        // Create New Test Case Button
        createNewTestCaseButton.addActionListener(e -> {
            TestCaseAppManager.getDashboard().removeAll();
            TestCaseAppManager.getDashboard().add(new CreateNewTestCaseMenu());
            TestCaseAppManager.getDashboard().revalidate();
            TestCaseAppManager.getDashboard().repaint();
        });

        // Manage Test Cases Button
        manageTestCasesButton.addActionListener(e -> {
            TestCaseAppManager.getDashboard().removeAll();
            TestCaseAppManager.getDashboard().add(new ManageTestCasesMenu());
            TestCaseAppManager.getDashboard().revalidate();
            TestCaseAppManager.getDashboard().repaint();
        });

        // Settings Button
        settingsButton.addActionListener(e -> {
            TestCaseAppManager.getDashboard().removeAll();
            TestCaseAppManager.getDashboard().add(new SettingsMenu());
            TestCaseAppManager.getDashboard().revalidate();
            TestCaseAppManager.getDashboard().repaint();
        });

        exitButton.addActionListener(
                exitConfirmationPopup -> new ExitConfirmationPopup()
        );
    }
}
