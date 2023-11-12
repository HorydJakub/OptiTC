package panels.addnewtestcase;

import enumerates.Priorities;

import javax.swing.*;
import java.util.Arrays;

public class TestCasePriorityPanel extends JPanel {

    private JLabel priorityLabel;
    private static JComboBox priorityComboBox;

    public TestCasePriorityPanel() {

        // Create Priority Label
        priorityLabel = new JLabel("Priority:");

        // Create Priority ComboBox
        priorityComboBox = new JComboBox();
        Arrays.stream(Priorities.values()).toList().forEach(priorityComboBox::addItem);

        // Select default value
        priorityComboBox.setSelectedItem(Priorities.MEDIUM);

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
