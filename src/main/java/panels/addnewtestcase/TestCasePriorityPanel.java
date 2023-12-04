package panels.addnewtestcase;

import enumerates.Priorities;

import javax.swing.*;
import java.util.Arrays;

public class TestCasePriorityPanel extends JPanel {

    private JLabel priorityLabel;
    private static final JComboBox priorityComboBox = new JComboBox();

    public TestCasePriorityPanel(boolean isEditable, Priorities defaultPriority) {

        // Create Priority Label
        priorityLabel = new JLabel("Priority:");

        // Create Priority ComboBox
        Arrays.stream(Priorities.values()).toList().forEach(priorityComboBox::addItem);

        // Select default value
        priorityComboBox.setSelectedItem(defaultPriority);

        // Set editable
        priorityComboBox.setEnabled(isEditable);

        // Add components to the panel
        add(priorityLabel);
        add(priorityComboBox);
    }

    public static String getPriorityComboBox() {
        return priorityComboBox.getSelectedItem().toString();
    }

    public static void setPriorityComboBox(String priority) {
        priorityComboBox.setSelectedItem(priority);
    }
}
