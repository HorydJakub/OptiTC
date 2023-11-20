package panels.addnewtestcase;

import components.OptiTextField;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class StepsContainerPanel extends JPanel {

    public StepsContainerPanel() {

        // Set layout for the panel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Add the first step
        AddStepPanel addStepPanel = new AddStepPanel(1);

        // Add the first step to the panel
        add(addStepPanel);
    }

    public List<OptiTextField> getStepsTextFieldFromStepsContainerPanel() {
        return Arrays.stream(getComponents())
                .filter(component -> component instanceof AddStepPanel)
                .map(component -> (AddStepPanel) component)
                .map(AddStepPanel::getStepTextField)
                .toList();
    }

    public List<JPanel> getAddStepPanels() {
        return Arrays.stream(getComponents())
                .filter(component -> component instanceof AddStepPanel)
                .map(component -> (JPanel) component)
                .toList();
    }
}
