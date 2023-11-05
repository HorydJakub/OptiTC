package components;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;

public class OptiButton extends JButton {
    private final Color borderColor = Color.GRAY;

    public OptiButton(String text) {
        super(text);
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setOpaque(true);
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));
    }
}
