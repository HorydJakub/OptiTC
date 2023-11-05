package sections;

import core.ConstantValues;
import fonts.FooterFont;

import javax.swing.*;
import java.awt.*;

public class FooterMenu extends JPanel {

        public FooterMenu() {

            String footerText;
            footerText = ConstantValues.APP_NAME + " " + ConstantValues.APP_VERSION + " by " + ConstantValues.APP_AUTHOR + " | " + ConstantValues.LICENCE;
            JLabel footerLabel = new JLabel(footerText);
            footerLabel.setFont(new FooterFont());
            footerLabel.setBackground(Color.GRAY);
            add(footerLabel);
        }
}
