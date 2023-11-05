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
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int leftMenuWidth = screenSize.width / 6;
        setPreferredSize(new Dimension(leftMenuWidth, screenSize.height));

        // Set the layout of the panel
        setLayout(new GridLayout(5, 1));

        // Title of application
        JLabel title = new JLabel(ConstantValues.APP_NAME + " " + ConstantValues.APP_VERSION);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));

        // List of buttons
        OptiButton createNewTestCaseButton = new OptiButton("Create New Test Case");
        OptiButton showAllTestCasesButton = new OptiButton("Show All Test Cases");
        OptiButton ConfigureButton = new OptiButton("Configure");
        OptiButton exitButton = new OptiButton("Exit");

        // Add components to the panel
        add(title);
        add(createNewTestCaseButton);
        add(showAllTestCasesButton);
        add(ConfigureButton);
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
        showAllTestCasesButton.addActionListener(e -> System.out.println("Show All Test Cases"));
        ConfigureButton.addActionListener(e -> System.out.println("Configure"));



        exitButton.addActionListener(
                ExitConfirmationPopup -> new ExitConfirmationPopup()
        );
    }
}
