package components.managetestcases;

import core.SqlBuilder;
import core.TestCaseAppManager;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class TestCasesTable extends JTable {

    private int preferredWidth = TestCaseAppManager.getDashboard().getWidthOfDashboard();

    public TestCasesTable() {
        super(SqlBuilder.getIdAndTitleOfTestCases(), new String[]{"ID", "Name", "Details"});

        setMaximumSize(new Dimension(preferredWidth, 100));
        // rows can not be edited
        setDefaultEditor(Object.class, null);

        getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
        getColumnModel().getColumn(2).setCellEditor(new ButtonEditor(new JCheckBox(), this));
    }

    private class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(UIManager.getColor("Button.background"));
            }
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    private class ButtonEditor extends DefaultCellEditor {
        private JButton button;
        private String label;
        private boolean isClicked;
        private JTable table;

        public ButtonEditor(JCheckBox checkBox, JTable table) {
            super(checkBox);
            this.table = table;
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(e -> fireEditingStopped());
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isClicked = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (isClicked) {
                int testCaseId = (int) this.table.getValueAt(this.table.getSelectedRow(), 0); // Zakładając, że ID jest w pierwszej kolumnie
                showDetailsOfTestCase(testCaseId);
            }
            isClicked = false;
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            isClicked = false;
            return super.stopCellEditing();
        }
    }

    private void showDetailsOfTestCase(int testCaseId) {
        TestCaseAppManager.getDashboard().removeAll();
        TestCaseAppManager.getDashboard().add(new TestCaseDetails(testCaseId));
        TestCaseAppManager.getDashboard().revalidate();
        TestCaseAppManager.getDashboard().repaint();
    }
}
