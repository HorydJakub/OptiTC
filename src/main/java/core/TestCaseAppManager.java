package core;

import sections.Dashboard;
import sections.FooterMenu;
import sections.MainMenu;
import sections.SideMenu;

import javax.swing.*;
import java.awt.*;

public class TestCaseAppManager extends JFrame {

    private static final Dashboard dashboard = new Dashboard();
    private static final SideMenu leftMenu = new SideMenu();
    private static final FooterMenu footerMenu = new FooterMenu();
    private static final MainMenu mainMenu = new MainMenu();
    public TestCaseAppManager() {

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

        // Show main menu by default
        dashboard.add(mainMenu);
    }

    public static Dashboard getDashboard() {
        return dashboard;
    }

    public static SideMenu getLeftMenu() {
        return leftMenu;
    }

    public static FooterMenu getFooterMenu() {
        return footerMenu;
    }
}