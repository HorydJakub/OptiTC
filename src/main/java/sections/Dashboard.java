package sections;

import javax.swing.*;

public class Dashboard extends JPanel {

    public Dashboard() {

        JLabel welcomeLabel = new JLabel("Welcome to the Test Case Manager");
        welcomeLabel.setBackground(java.awt.Color.RED);
        add(welcomeLabel);
        add(new CreateNewTestCaseMenu());
    }
}
