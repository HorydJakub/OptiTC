package core;

import components.OptiButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestCaseManagerApp {

    public TestCaseManagerApp() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        int leftPanelWidth = (int) (screenWidth * 0.2);

        // Create main window
        JFrame mainWindow = new JFrame("OptiTC Manager");
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setSize(screenWidth, screenHeight);

        // Create main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create panel for buttons on the left side with GridBagLayout
        JPanel leftPanel = new JPanel(new GridBagLayout());

        // Creating new buttons
//        JButton addTestCaseButton = new JButton("Add new Test Case");
//        JButton viewTestCasesButton = new JButton("See all Test Cases");
//        JButton exitButton = new JButton("Exit");
        OptiButton addTestCaseButton = new OptiButton("Add new Test Case");
        OptiButton viewTestCasesButton = new OptiButton("See all Test Cases");
        OptiButton exitButton = new OptiButton("Exit");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.insets = new Insets(10, 20, 10, 20);

        // Add buttons to left panel
        leftPanel.add(addTestCaseButton, gbc);
        leftPanel.add(Box.createVerticalStrut(150));
        leftPanel.add(viewTestCasesButton, gbc);
        leftPanel.add(exitButton, gbc);

        // Set preferred size for leftPanel
        leftPanel.setPreferredSize(new Dimension(leftPanelWidth, screenHeight));

        // Add left panel to main panel on the left side
        mainPanel.add(leftPanel, BorderLayout.WEST);

        // Create panel for displaying results on the right side with a blue background
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.BLUE);

        // Add right panel to main panel on the right side
        mainPanel.add(rightPanel, BorderLayout.CENTER);

        // Show the main window
        mainWindow.add(mainPanel);
        mainWindow.setVisible(true);

        // Listeners for buttons

        // Add new Test Case listener
        addTestCaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("I am adding a new test case");
            }
        });

        // See all Test Cases listener
        viewTestCasesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("I show all test cases");
            }
        });

        // Exit listener
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("I close the application");
                System.exit(0);
            }
        });
    }

}
