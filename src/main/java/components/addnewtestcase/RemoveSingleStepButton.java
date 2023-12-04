package components.addnewtestcase;

import panels.addnewtestcase.AddStepPanel;
import panels.addnewtestcase.StepsContainerPanel;
import sections.CreateNewTestCaseMenu;

import javax.swing.*;
import java.util.List;

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
        StepsContainerPanel stepsContainerPanel = CreateNewTestCaseMenu.getStepsContainerPanel();

        // Remove the add step panel from the steps container panel
        stepsContainerPanel.remove(addStepPanel);

        // Update step numbers
        updateStepNumbers(stepsContainerPanel);

        // Repaint the steps container panel
        stepsContainerPanel.repaint();

        // Revalidate the steps container panel
        stepsContainerPanel.revalidate();

        // Decrement the steps count
        AddNewStepButton.decrementStepsCount();
    }

    private void updateStepNumbers(StepsContainerPanel stepsContainerPanel) {
        List<AddStepPanel> stepPanels = stepsContainerPanel.getStepsPanelFromStepsContainerPanel();

        for (int i = 0; i < stepPanels.size(); i++) {
            AddStepPanel stepPanel = stepPanels.get(i);
            stepPanel.updateStepNumber(i + 1); // Aktualizuj numer kroku
        }
    }
}
