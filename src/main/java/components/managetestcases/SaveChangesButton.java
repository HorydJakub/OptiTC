package components.managetestcases;

import core.SqlBuilder;

import javax.swing.*;

public class SaveChangesButton extends JButton {

  public SaveChangesButton() {
            super("Save Changes");
            addActionListener(e -> saveChanges());
        }

        private void saveChanges() {
            // Show confirmation dialog
            int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to save changes?", "Save Changes", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                SqlBuilder.updateTestCase();
            }
        }
}
