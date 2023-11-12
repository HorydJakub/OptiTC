package panels.addnewtestcase;

import enumerates.Types;

import javax.swing.*;
import java.util.Arrays;

public class TestCaseTypePanel extends JPanel {

    private JLabel typeLabel;
    private static JComboBox typeComboBox;

    public TestCaseTypePanel() {

        // Create Type Label
        typeLabel = new JLabel("Type:");

        // Create Type ComboBox
        typeComboBox = new JComboBox();
        Arrays.stream(Types.values()).toList().forEach(typeComboBox::addItem);

        // Select default value
        typeComboBox.setSelectedItem(Types.FUNCTIONAL);

        // Add components to the panel
        add(typeLabel);
        add(typeComboBox);
    }

    public static String getTypeComboBox() {
        return typeComboBox.getSelectedItem().toString();
    }

    public static void setTypeComboBox(String type) {
        typeComboBox.setSelectedItem(type);
    }
}
