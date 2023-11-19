package sections;

import components.HeaderPanel;
import components.testcaseadded.CreateAnotherTestCaseButton;

import javax.swing.*;
import java.awt.*;

public class TestCaseAddedMenu extends JPanel {

    public TestCaseAddedMenu() {

        // Set layout for the panel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Header panel with success message
        HeaderPanel confirmationMessage = new HeaderPanel("Success!");

        // Info message about the test case being added
        JLabel infoMessage = new JLabel("Your test case has been added to the database.");

        // Set font for the label
        infoMessage.setFont( new Font("Arial", Font.PLAIN, 20));

        // Set alignment for the label
        infoMessage.setAlignmentX(CENTER_ALIGNMENT);

        // Set margin on top and bottom only for info message
        infoMessage.setBorder(BorderFactory.createEmptyBorder(50, 0, 100, 0));

        // Button with option to create another test case
        CreateAnotherTestCaseButton createAnotherTestCaseButton = new CreateAnotherTestCaseButton();

        // Add image with success icon
        ImageIcon successIcon = new ImageIcon("src/main/resources/success.png");

        // JLabel with success icon
        JLabel successIconLabel = new JLabel(successIcon);

        // Set margin for successIconLabel
        successIconLabel.setBorder(BorderFactory.createEmptyBorder(50, 0, 100, 0));

        // Set alignment for the label
        successIconLabel.setAlignmentX(CENTER_ALIGNMENT);

        // Set alignment for the icon
        successIcon.setImage(successIcon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH));

        // Set alignment for the button
        createAnotherTestCaseButton.setAlignmentX(CENTER_ALIGNMENT);

        // Make button bigger
        createAnotherTestCaseButton.setPreferredSize(new Dimension(200, 50));

        // Add components to the panel
        add(confirmationMessage);
        add(successIconLabel);
        add(infoMessage);
        add(createAnotherTestCaseButton);
    }
}
