package components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OptiButton extends JButton {

    private Color normalBackground = new Color(240, 240, 240);
    private Color rolloverBackground = new Color(255, 200, 0);
    private Color pressedBackground = new Color(255, 140, 0);

    public OptiButton(String text) {
        super(text);
        setBorderForButton();
        setContentAreaFilled(true);
        setBackground(normalBackground);
        setForeground(Color.BLACK);
        setFocusPainted(false);
        setRolloverEnabled(true);
        setFont(new Font("Calibri", Font.BOLD, 20));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBorder(BorderFactory.createCompoundBorder(
                        new LineBorder(new Color(255, 165, 0), 4, true),
                        new EmptyBorder(10, 20, 10, 20)
                ));
                setBackground(rolloverBackground);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBorderForButton();
                setBackground(normalBackground);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(pressedBackground);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(rolloverBackground);
            }
        });
    }

    private void setBorderForButton() {
        setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(255, 165, 0), 2, true),
                new EmptyBorder(10, 20, 10, 20)
        ));
    }
}


