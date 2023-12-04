package components;

import core.SqlBuilder;
import enumerates.Priorities;
import enumerates.Types;

import java.util.Arrays;
import java.util.List;

public class TestCase {

    private int testCaseId;
    private String testCaseTitle;
    private String testCaseDescription;
    private String testCasePriority;
    private String testCaseType;
    private String testCaseExpectedResult;
    private String testCaseSteps;

    public TestCase(int testCaseId) {
        this.testCaseId = testCaseId;
        this.testCaseTitle = SqlBuilder.getTestCaseTitleById(testCaseId);
        this.testCaseDescription = SqlBuilder.getTestCaseDescriptionById(testCaseId);
        this.testCasePriority = SqlBuilder.getTestCasePriorityById(testCaseId);
        this.testCaseType = SqlBuilder.getTestCaseTypeById(testCaseId);
        this.testCaseSteps = SqlBuilder.getTestCaseStepsById(testCaseId);
        this.testCaseExpectedResult = SqlBuilder.getTestCaseExpectedResultById(testCaseId);
    }

    public int getTestCaseId() {
        return testCaseId;
    }

    public String getTestCaseTitle() {
        return testCaseTitle;
    }

    public String getTestCaseDescription() {
        return testCaseDescription;
    }

    public Priorities getTestCasePriority() {
        return Priorities.valueOf(testCasePriority.toUpperCase());
    }

    public Types getTestCaseType() {
        return Types.valueOf(testCaseType.toUpperCase());
    }

    public String getTestCaseExpectedResult() {
        return testCaseExpectedResult;
    }

    public List<String> getTestCaseStepsValuesAsList() {
        // Split by new line
        return Arrays.asList(testCaseSteps.split("\\r?\\n"));
    }

    public String getTestCaseStepValueByStepNumber(int stepNumber) {
        return getTestCaseStepsValuesAsList().get(stepNumber - 1);
    }
}
