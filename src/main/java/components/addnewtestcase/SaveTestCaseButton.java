package components.addnewtestcase;

import panels.addnewtestcase.TestCaseTitlePanel;

import javax.swing.*;

public class SaveTestCaseButton extends JButton {

        public SaveTestCaseButton(String saveTestCaseButtonText) {
            super(saveTestCaseButtonText);

            addActionListener(e -> {
                int dialogResult = JOptionPane.showConfirmDialog(null, "Would You Like to Save this Test Case?", "Warning", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION && !TestCaseTitlePanel.getTestCaseTitleTextField().equals("Enter Test Case Title")) {
                    System.out.println(TestCaseTitlePanel.getTestCaseTitleTextField());
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill out all mandatory fields before saving.");
                }
            });
        }
}
