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

    public void updateStepNumbers() {
        // Pobierz listę paneli kroków
        List<AddStepPanel> stepPanels = getStepsPanelFromStepsContainerPanel();

        // Iteruj przez listę paneli kroków i aktualizuj numerację
        for (int i = 0; i < stepPanels.size(); i++) {
            AddStepPanel stepPanel = stepPanels.get(i);
            stepPanel.updateStepNumber(i + 1); // Aktualizuj numer kroku
        }
    }

    public List<AddStepPanel> getStepsPanelFromStepsContainerPanel() {
        return Arrays.stream(getComponents())
                .filter(component -> component instanceof AddStepPanel)
                .map(component -> (AddStepPanel) component)
                .toList();
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
