package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class OptiTextField extends JTextField {

    public OptiTextField(boolean isEditable, boolean canBeEmpty) {
        super("Please fill out this field!");
        // set editable
        setEditable(isEditable);
        setPreferredSize(new Dimension(500, 30));
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals("Please fill out this field!") && isEditable) {
                    setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty() && isEditable && !canBeEmpty) {
                    setText("Please fill out this field!");
                }
            }
        });
    }
}
