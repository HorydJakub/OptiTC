import sections.Dashboard;
import sections.FooterMenu;
import sections.LeftMenu;

import javax.swing.*;
import java.awt.*;

public class TestCaseAppManager extends JFrame {

    public TestCaseAppManager() {

        // COMPONENTS
        // Create components
        LeftMenu leftMenu = new LeftMenu();
        Dashboard dashboard = new Dashboard();
        FooterMenu footerMenu = new FooterMenu();


        // Get the screen size
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

        // Set the size and location of the frame
        setSize(screenWidth / 2, screenHeight / 2);
        setLocation(screenWidth / 4, screenHeight / 4);

        // Set the title of the frame
        setTitle("JFrame");

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
