package panels.mainmenu;

import core.SqlBuilder;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class TestCasesStatisticsPanel extends JPanel {

    private final Map<String, Integer> statisticsMap = new HashMap<>();

    public TestCasesStatisticsPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        statisticsMap.put("Number of test cases", SqlBuilder.getNumberOfTestCases());
        statisticsMap.put("Number of functional test cases", SqlBuilder.getNumberOfFunctionalTestCases());
        statisticsMap.put("Number of GUI test cases", SqlBuilder.getNumberOfGuiTestCases());
        statisticsMap.put("Number of performance test cases", SqlBuilder.getNumberOfPerformanceTestCases());
        statisticsMap.put("Number of security test cases", SqlBuilder.getNumberOfSecurityTestCases());
        statisticsMap.put("Number of usability test cases", SqlBuilder.getNumberOfUsabilityTestCases());
        statisticsMap.put("Number of smoke test cases", SqlBuilder.getNumberOfSmokeTestCases());

        addStatisticLabels();
    }

    private void addStatisticLabels() {
        JLabel statisticLabel = new JLabel("This is the list of statistics:");
        formatLabel(statisticLabel, true);

        add(statisticLabel);

        for (String statistic : statisticsMap.keySet()) {
            JLabel label = new JLabel(statistic + ": " + statisticsMap.get(statistic));
            formatLabel(label, false);
            add(label);
        }
    }

    private void formatLabel(JLabel label, boolean isHeader) {
        label.setAlignmentX(CENTER_ALIGNMENT);
        label.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        if (isHeader) {
            label.setFont(label.getFont().deriveFont(Font.BOLD | Font.ITALIC, 16.0f));
            label.setForeground(Color.GRAY);
        } else {
            label.setFont(label.getFont().deriveFont(Font.ITALIC));
            label.setForeground(Color.GRAY);
        }
    }
}
