package sections;

import components.ExitConfirmationPopup;
import components.OptiButton;
import core.ConstantValues;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeftMenu extends JPanel {

    public LeftMenu(Dashboard dashboard) {

        // The left menu width should be at leat 1/6 of width of the screen
        setPreferredSize(new Dimension(ConstantValues.SCREEN_WIDTH/6, ConstantValues.SCREEN_HEIGHT));

        // Set the layout of the panel
        setLayout(new GridLayout(6, 1));

        // Title of application
        JLabel title = new JLabel(ConstantValues.APP_NAME + " " + ConstantValues.APP_VERSION);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        // List of buttons
        OptiButton createNewTestCaseButton = new OptiButton("Create New Test Case");
        OptiButton manageTestCasesButton = new OptiButton("Manage Test Cases");
        OptiButton createNewRunButton = new OptiButton("Create New Run");
        OptiButton manageRunsButton = new OptiButton("Manage Runs");
        OptiButton exitButton = new OptiButton("Exit");

        // Add components to the panel
        add(title);
        add(createNewTestCaseButton);
        add(manageTestCasesButton);
        add(createNewRunButton);
        add(manageRunsButton);
        add(exitButton);

        // Add action listeners to the buttons
        createNewTestCaseButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Create New Test Case");
                        dashboard.removeAll();
                        dashboard.add(new CreateNewTestCaseMenu());
                        dashboard.revalidate();
                        dashboard.repaint();
                    }
                }
        );

        exitButton.addActionListener(
                ExitConfirmationPopup -> new ExitConfirmationPopup()
        );
    }
}
