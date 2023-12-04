package panels.addnewtestcase;

import components.OptiTextField;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class StepsContainerPanel extends JPanel {

    public StepsContainerPanel(boolean areFieldsEditable, boolean editMode) {

        // Set layout for the panel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Add the first step only if the fields are editable
        AddStepPanel addStepPanel = new AddStepPanel(1, areFieldsEditable);

        // Add the first step to the panel only if the fields are editable
        if (areFieldsEditable && !editMode) {
            add(addStepPanel);
        }
    }

    public List<OptiTextField> getStepsTextFieldFromStepsContainerPanel() {
        return Arrays.stream(getComponents())
                .filter(AddStepPanel.class::isInstance)
                .map(AddStepPanel.class::cast)
                .map(AddStepPanel::getStepTextField)
                .toList();
    }
}
