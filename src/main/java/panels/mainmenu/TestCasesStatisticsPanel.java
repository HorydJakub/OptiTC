package panels.mainmenu;

import core.SqlBuilder;

import javax.swing.*;

public class TestCasesStatisticsPanel extends JPanel {

    public TestCasesStatisticsPanel() {

        // some statistics
        int numberOfTestCases = SqlBuilder.getNumberOfTestCases();
        int numberOfFunctionalTestCases = SqlBuilder.getNumberOfFunctionalTestCases();
        int numberOfGuiTestCases = SqlBuilder.getNumberOfGuiTestCases();
        int numberOfPerformanceTestCases = SqlBuilder.getNumberOfPerformanceTestCases();
        int numberOfSecurityTestCases = SqlBuilder.getNumberOfSecurityTestCases();
        int numberOfUsabilityTestCases = SqlBuilder.getNumberOfUsabilityTestCases();

        // Set layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Statistic label:
        JLabel statisticLabel = new JLabel("This is the list of statistics: ");

        // Set statistic label to center
        statisticLabel.setAlignmentX(CENTER_ALIGNMENT);

        // Set bigger font for statistic label
        statisticLabel.setFont(statisticLabel.getFont().deriveFont(16.0f));

        // Set italic for statistic label
        statisticLabel.setFont(statisticLabel.getFont().deriveFont(statisticLabel.getFont().getStyle() | java.awt.Font.ITALIC));

        // create labels
        JLabel numberOfTestCasesLabel = new JLabel("Number of test cases: " + numberOfTestCases);
        JLabel numberOfFunctionalTestCasesLabel = new JLabel("Number of functional test cases: " + numberOfFunctionalTestCases);
        JLabel numberOfGuiTestCasesLabel = new JLabel("Number of GUI test cases: " + numberOfGuiTestCases);
        JLabel numberOfPerformanceTestCasesLabel = new JLabel("Number of performance test cases: " + numberOfPerformanceTestCases);
        JLabel numberOfSecurityTestCasesLabel = new JLabel("Number of security test cases: " + numberOfSecurityTestCases);
        JLabel numberOfUsabilityTestCasesLabel = new JLabel("Number of usability test cases: " + numberOfUsabilityTestCases);

        // Center every label
        numberOfTestCasesLabel.setAlignmentX(CENTER_ALIGNMENT);
        numberOfFunctionalTestCasesLabel.setAlignmentX(CENTER_ALIGNMENT);
        numberOfGuiTestCasesLabel.setAlignmentX(CENTER_ALIGNMENT);
        numberOfPerformanceTestCasesLabel.setAlignmentX(CENTER_ALIGNMENT);
        numberOfSecurityTestCasesLabel.setAlignmentX(CENTER_ALIGNMENT);
        numberOfUsabilityTestCasesLabel.setAlignmentX(CENTER_ALIGNMENT);

        // Set margin for every label
        numberOfTestCasesLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        numberOfFunctionalTestCasesLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        numberOfGuiTestCasesLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        numberOfPerformanceTestCasesLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        numberOfSecurityTestCasesLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        numberOfUsabilityTestCasesLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        // Set color to gray and italic for every label
        numberOfTestCasesLabel.setForeground(java.awt.Color.GRAY);
        numberOfFunctionalTestCasesLabel.setForeground(java.awt.Color.GRAY);
        numberOfGuiTestCasesLabel.setForeground(java.awt.Color.GRAY);
        numberOfPerformanceTestCasesLabel.setForeground(java.awt.Color.GRAY);
        numberOfSecurityTestCasesLabel.setForeground(java.awt.Color.GRAY);
        numberOfUsabilityTestCasesLabel.setForeground(java.awt.Color.GRAY);

        numberOfTestCasesLabel.setFont(numberOfTestCasesLabel.getFont().deriveFont(numberOfTestCasesLabel.getFont().getStyle() | java.awt.Font.ITALIC));
        numberOfFunctionalTestCasesLabel.setFont(numberOfFunctionalTestCasesLabel.getFont().deriveFont(numberOfFunctionalTestCasesLabel.getFont().getStyle() | java.awt.Font.ITALIC));
        numberOfGuiTestCasesLabel.setFont(numberOfGuiTestCasesLabel.getFont().deriveFont(numberOfGuiTestCasesLabel.getFont().getStyle() | java.awt.Font.ITALIC));
        numberOfPerformanceTestCasesLabel.setFont(numberOfPerformanceTestCasesLabel.getFont().deriveFont(numberOfPerformanceTestCasesLabel.getFont().getStyle() | java.awt.Font.ITALIC));
        numberOfSecurityTestCasesLabel.setFont(numberOfSecurityTestCasesLabel.getFont().deriveFont(numberOfSecurityTestCasesLabel.getFont().getStyle() | java.awt.Font.ITALIC));
        numberOfUsabilityTestCasesLabel.setFont(numberOfUsabilityTestCasesLabel.getFont().deriveFont(numberOfUsabilityTestCasesLabel.getFont().getStyle() | java.awt.Font.ITALIC));



        // Add labels to panel
        add(statisticLabel);
        add(numberOfTestCasesLabel);
        add(numberOfFunctionalTestCasesLabel);
        add(numberOfGuiTestCasesLabel);
        add(numberOfPerformanceTestCasesLabel);
        add(numberOfSecurityTestCasesLabel);
        add(numberOfUsabilityTestCasesLabel);

    }
}
