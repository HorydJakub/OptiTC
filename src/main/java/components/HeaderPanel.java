package components;

import core.ConstantValues;
import fonts.HeaderFont;

import javax.swing.*;
import java.awt.*;

public class HeaderPanel extends JPanel {

    public HeaderPanel(String textOfLabel) {
        JLabel label = new JLabel(textOfLabel);
        label.setFont(new HeaderFont());
        add(label);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        setPreferredSize(new Dimension(ConstantValues.SCREEN_WIDTH, ConstantValues.SCREEN_HEIGHT / 10));
        setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
    }
}
