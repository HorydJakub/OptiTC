package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class OptiTextField extends JTextField {

    public OptiTextField(String text, int width, int height, boolean isEditable) {
        super(text);
        // set editable
        setEditable(isEditable);
        setPreferredSize(new Dimension(width, height));
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(text) && isEditable) {
                    setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty() && isEditable) {
                    setText(text);
                }
            }
        });
    }
}
