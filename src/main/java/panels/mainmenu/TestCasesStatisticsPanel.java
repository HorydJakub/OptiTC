package panels.mainmenu;

import core.SqlBuilder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class TestCasesStatisticsPanel extends JPanel {

    public TestCasesStatisticsPanel() {
        setLayout(new BorderLayout());

        DefaultCategoryDataset dataset = createDataset();

        // Create a bar chart
        JFreeChart barChart = ChartFactory.createBarChart(
                "Test Cases Statistics",
                "Test Cases",
                "Number",
                dataset);

        // Set custom colors for each series (category)
        List<Color> colors = Arrays.asList(
                Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW, Color.ORANGE, Color.CYAN
        );

        CategoryPlot plot = (CategoryPlot) barChart.getPlot();
        for (int i = 0; i < dataset.getRowCount(); i++) {
            plot.getRenderer().setSeriesPaint(i, colors.get(i));
        }

        // Create a chart panel to hold the chart
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(300, 200));

        // Create a panel to contain the chart panel
        JPanel statisticsPanel = new JPanel(new BorderLayout());
        statisticsPanel.add(chartPanel, BorderLayout.CENTER);

        // Set chart panel alignment to center
        statisticsPanel.setAlignmentX(CENTER_ALIGNMENT);

        // Set maximum dimensions for the panel holding the chart
        statisticsPanel.setMaximumSize(new Dimension(350, 250));

        // Set smaller font size
        Font font = statisticsPanel.getFont().deriveFont(12.0f);
        statisticsPanel.setFont(font);

        // Create JLabel with total number of test cases
        JLabel totalNumberOfTestCasesLabel = new JLabel("Total number of test cases: " + SqlBuilder.getNumberOfTestCases());

        // Set alignment to center
        totalNumberOfTestCasesLabel.setAlignmentX(CENTER_ALIGNMENT);

        // Add top margin
        totalNumberOfTestCasesLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        // Add the label to the panel
        statisticsPanel.add(totalNumberOfTestCasesLabel, BorderLayout.NORTH);

        // Add the panel containing the chart to the main panel
        add(statisticsPanel, BorderLayout.CENTER);
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Add data to the dataset
        dataset.addValue(SqlBuilder.getNumberOfFunctionalTestCases(), "Functional", "Functional");
        dataset.addValue(SqlBuilder.getNumberOfGuiTestCases(), "GUI", "GUI");
        dataset.addValue(SqlBuilder.getNumberOfPerformanceTestCases(), "Performance", "Performance");
        dataset.addValue(SqlBuilder.getNumberOfSecurityTestCases(), "Security", "Security");
        dataset.addValue(SqlBuilder.getNumberOfUsabilityTestCases(), "Usability", "Usability");
        dataset.addValue(SqlBuilder.getNumberOfSmokeTestCases(), "Smoke", "Smoke");

        return dataset;
    }
}
