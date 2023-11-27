package core;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class SqlBuilder {

    private static final String INSERT_QUERY = "INSERT INTO test_cases " +
            "(testcase_name, testcase_description, testcase_priority, testcase_type, step, testcase_expected_results) " +
            "VALUES (?, ?, ?, ?, ?, ?)";

    private static final String CREATE_TEST_CASES_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS test_cases (" +
            "testcase_id INT AUTO_INCREMENT PRIMARY KEY," +
            "testcase_name VARCHAR(80) NOT NULL," +
            "testcase_description VARCHAR(255) NOT NULL," +
            "testcase_priority ENUM('Low', 'Medium', 'High', 'Critical')," +
            "testcase_type ENUM('Functional', 'Non-functional', 'Smoke', 'Usability', 'GUI', 'Security')," +
            "step TEXT NOT NULL," +
            "testcase_expected_results VARCHAR(255) NOT NULL" +
            ")";

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
        Connection connection = DriverManager.getConnection(
                propertiesHandler.getSqlUrl(), propertiesHandler.getSqlUser(), propertiesHandler.getSqlPassword());

        createTestCasesTableIfNotExists(connection);

        return connection;
    }

    private static void createTestCasesTableIfNotExists(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(CREATE_TEST_CASES_TABLE_QUERY);
        statement.close();
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

    private static void closeResources(ResultSet resultSet, Statement preparedStatement, Connection connection) throws SQLException {
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
        if (resultSet != null) {
            resultSet.close();
        }
    }

    public static int getNumberOfRowsFromTestCasesTable() {
        int numberOfRows = 0;
        try {
            PropertiesHandler propertiesHandler = new PropertiesHandler();
            Connection connection = getConnection(propertiesHandler);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM test_cases");
            while (resultSet.next()) {
                numberOfRows = resultSet.getInt(1);
            }
            closeResources(resultSet, statement, connection);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return numberOfRows;
    }
     public static Object[][] getIdAndTitleOfTestCases() {
            Object[][] idAndTitleOfTestCases = new Object[getNumberOfRowsFromTestCasesTable()][3];
            try {
                PropertiesHandler propertiesHandler = new PropertiesHandler();
                Connection connection = getConnection(propertiesHandler);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT testcase_id, testcase_name FROM test_cases");
                int i = 0;
                while (resultSet.next()) {
                    idAndTitleOfTestCases[i][0] = resultSet.getInt("testcase_id");
                    idAndTitleOfTestCases[i][1] = resultSet.getString("testcase_name");
                    idAndTitleOfTestCases[i][2] = "Edit";
                    i++;
                }
                closeResources(resultSet, statement, connection);
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println(e);
            }
            return idAndTitleOfTestCases;
     }

     public static Object[] getAllDataFromTestCase(int testCaseId) {
            Object[] testCaseData = new Object[6];
            try {
                PropertiesHandler propertiesHandler = new PropertiesHandler();
                Connection connection = getConnection(propertiesHandler);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM test_cases WHERE testcase_id = " + testCaseId);
                while (resultSet.next()) {
                    testCaseData[0] = resultSet.getString("testcase_name");
                    testCaseData[1] = resultSet.getString("testcase_description");
                    testCaseData[2] = resultSet.getString("testcase_priority");
                    testCaseData[3] = resultSet.getString("testcase_type");
                    testCaseData[4] = resultSet.getString("step");
                    testCaseData[5] = resultSet.getString("testcase_expected_results");
                }
                closeResources(resultSet, statement, connection);
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println(e);
            }
            return testCaseData;
     }
}
