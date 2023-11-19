package components;

import fonts.SideMenuFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OptiSideMenuButton extends JButton {

    public OptiSideMenuButton(String text) {
        super(text);
        setBorderPainted(true);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setOpaque(true);
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));

        // Add action listener for hover effect (change font to italic when hover)
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                setFont(SideMenuFont.getHoverFont());
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                setFont(SideMenuFont.getDefaultFont());
            }
        });
    }
}
