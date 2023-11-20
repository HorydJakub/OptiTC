package core;

import java.sql.*;
import java.util.List;

public abstract class SqlBuilder {

    private static final String INSERT_QUERY = "INSERT INTO test_cases " +
            "(testcase_name, testcase_description, testcase_priority, testcase_type, step, testcase_expected_results) " +
            "VALUES (?, ?, ?, ?, ?, ?)";

    public static void sendNewTestCaseToDatabase(String testCaseTitleValue, String testCaseDescriptionValue,
                                                 String testCasePriorityValue, String testCaseTypeValue,
                                                 List<String> stepsTextFieldFromStepsContainerPanelValues,
                                                 String testCaseExpectedResultsValue) {
        try {
            PropertiesHandler propertiesHandler = new PropertiesHandler();
            Connection connection = getConnection(propertiesHandler);
            PreparedStatement preparedStatement = createPreparedStatement(connection);
            String stepsConcatenated = concatenateSteps(stepsTextFieldFromStepsContainerPanelValues);
            executeInsertQuery(preparedStatement, testCaseTitleValue, testCaseDescriptionValue,
                    testCasePriorityValue, testCaseTypeValue, stepsConcatenated, testCaseExpectedResultsValue);

            closeResources(preparedStatement, connection);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    private static Connection getConnection(PropertiesHandler propertiesHandler) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                propertiesHandler.getSqlUrl(), propertiesHandler.getSqlUser(), propertiesHandler.getSqlPassword());
    }

    private static PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
        return connection.prepareStatement(INSERT_QUERY);
    }

    private static String concatenateSteps(List<String> steps) {
        StringBuilder stepsConcatenated = new StringBuilder();
        for (String step : steps) {
            stepsConcatenated.append(step).append("\n"); // Separating steps by newline
        }
        return stepsConcatenated.toString();
    }

    private static void executeInsertQuery(PreparedStatement preparedStatement, String testCaseTitleValue,
                                           String testCaseDescriptionValue, String testCasePriorityValue,
                                           String testCaseTypeValue, String stepsConcatenated,
                                           String testCaseExpectedResultsValue) throws SQLException {
        preparedStatement.setString(1, testCaseTitleValue);
        preparedStatement.setString(2, testCaseDescriptionValue);
        preparedStatement.setString(3, testCasePriorityValue);
        preparedStatement.setString(4, testCaseTypeValue);
        preparedStatement.setString(5, stepsConcatenated);
        preparedStatement.setString(6, testCaseExpectedResultsValue);

        preparedStatement.executeUpdate();
    }

    private static void closeResources(PreparedStatement preparedStatement, Connection connection) throws SQLException {
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}