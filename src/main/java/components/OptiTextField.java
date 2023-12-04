package components;

import core.ConstantValues;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class OptiTextField extends JTextField {

    public OptiTextField(boolean isEditable, boolean canBeEmpty) {
        super(ConstantValues.DEFAULT_VALUE_FOR_EMPTY_FIELD);
        // set editable
        setEditable(isEditable);
        setPreferredSize(new Dimension(500, 30));
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(ConstantValues.DEFAULT_VALUE_FOR_EMPTY_FIELD) && isEditable) {
                    setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty() && isEditable && !canBeEmpty) {
                    setText(ConstantValues.DEFAULT_VALUE_FOR_EMPTY_FIELD);
                }
            }
        });
    }
}
