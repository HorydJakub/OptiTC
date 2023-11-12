package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class OptiTextField extends JTextField {

    public OptiTextField(String text, int width, int height) {
        super(text);
        setPreferredSize(new Dimension(width, height));
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(text)) {
                    setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setText(text);
                }
            }
        });
    }
}
