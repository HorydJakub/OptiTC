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
        addActionListener(e -> removeStepById());
    }

    private void removeStepById() {

        // Get the add step panel
        JPanel addStepPanel = (JPanel) getParent();

        // Get the steps container panel
        JPanel stepsContainerPanel = CreateNewTestCaseMenu.getStepsContainerPanel();

        // Remove the add step panel from the steps container panel
        stepsContainerPanel.remove(addStepPanel);

        // Repaint the steps container panel
        stepsContainerPanel.repaint();

        // Reset the steps count
        AddNewStepButton.resetStepsCount();
    }
}
