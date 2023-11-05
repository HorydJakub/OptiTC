import core.ConstantValues;
import sections.Dashboard;
import sections.FooterMenu;
import sections.LeftMenu;

import javax.swing.*;
import java.awt.*;

public class TestCaseAppManager extends JFrame {

    public TestCaseAppManager() {

        // COMPONENTS
        // Create components
        Dashboard dashboard = new Dashboard();
        LeftMenu leftMenu = new LeftMenu(dashboard);
        FooterMenu footerMenu = new FooterMenu();

        // Set the size and location of the frame
        setSize(ConstantValues.SCREEN_WIDTH, ConstantValues.SCREEN_HEIGHT);

        // Set the title of the frame
        setTitle(ConstantValues.APP_NAME + " " + ConstantValues.APP_VERSION);

        // Set the icon of the frame
        setVisible(true);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // LAYOUT MANAGER
        // Set the layout of the frame
        setLayout(new BorderLayout());

        // Add components to the frame
        add(leftMenu, BorderLayout.WEST);
        add(dashboard, BorderLayout.CENTER);
        add(footerMenu, BorderLayout.SOUTH);
    }
}