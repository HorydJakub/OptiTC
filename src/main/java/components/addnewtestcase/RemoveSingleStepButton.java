package components.addnewtestcase;

import sections.CreateNewTestCaseMenu;

import javax.swing.*;

public class RemoveSingleStepButton extends JButton {

    public RemoveSingleStepButton() {
        super("X");

        // Design for the button
        setFocusPainted(false);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);

        // Set font to red
        setForeground(java.awt.Color.RED);


        // Add listener on click
        addActionListener(e -> {
            removeStepById();
        });
    }

    private void removeStepById() {

        // Get the parent panel
        JPanel parentPanel = (JPanel) getParent();

        // Get the parent panel's parent panel
        JPanel parentParentPanel = (JPanel) parentPanel.getParent();

        // Remove the parent panel from the parent parent panel
        parentParentPanel.remove(parentPanel);

        // Repaint the parent parent panel
        parentParentPanel.repaint();

        // Reset the steps count
        AddNewStepButton.resetStepsCount();
    }
}
