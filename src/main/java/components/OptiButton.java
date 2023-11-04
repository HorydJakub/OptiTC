package components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class OptiButton extends JButton {

    public OptiButton(String text) {
        super(text);
        setBorderForButton();
        setContentAreaFilled(false);
        setFocusPainted(false);
        setRolloverEnabled(true);
        setFont(new Font("Calibri", Font.BOLD, 20));
    }

    private void setBorderForButton() {
        setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.ORANGE, 2, true),
                new EmptyBorder(10, 20, 10, 20)
        ));
    }
}
