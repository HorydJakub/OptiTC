package components.testcaseadded;

import core.TestCaseAppManager;
import sections.CreateNewTestCaseMenu;

import javax.swing.*;

public class CreateAnotherTestCaseButton extends JButton {

    public CreateAnotherTestCaseButton() {

        // Set the text of the button
        setText("Create Another Test Case");

        // Set action on click
        addActionListener(a -> {
            // Remove all components from dashboard
            TestCaseAppManager.getDashboard().removeAll();
            TestCaseAppManager.getDashboard().add(new CreateNewTestCaseMenu());
            TestCaseAppManager.getDashboard().revalidate();
            TestCaseAppManager.getDashboard().repaint();
        });
    }
}
