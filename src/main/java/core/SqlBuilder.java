package core;

import java.awt.*;
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
                    idAndTitleOfTestCases[i][2] = "Details";
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

     public static String getTestCaseTitleById(int testCaseId) {
            String testCaseTitle = "";
            try {
                PropertiesHandler propertiesHandler = new PropertiesHandler();
                Connection connection = getConnection(propertiesHandler);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT testcase_name FROM test_cases WHERE testcase_id = " + testCaseId);
                while (resultSet.next()) {
                    testCaseTitle = resultSet.getString("testcase_name");
                }
                closeResources(resultSet, statement, connection);
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println(e);
            }
            return testCaseTitle;
     }

     public static String getTestCaseDescriptionById(int testCaseId) {
            String testCaseDescription = "";
            try {
                PropertiesHandler propertiesHandler = new PropertiesHandler();
                Connection connection = getConnection(propertiesHandler);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT testcase_description FROM test_cases WHERE testcase_id = " + testCaseId);
                while (resultSet.next()) {
                    testCaseDescription = resultSet.getString("testcase_description");
                }
                closeResources(resultSet, statement, connection);
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println(e);
            }
            return testCaseDescription;
     }

        public static String getTestCasePriorityById(int testCaseId) {
                String testCasePriority = "";
                try {
                    PropertiesHandler propertiesHandler = new PropertiesHandler();
                    Connection connection = getConnection(propertiesHandler);
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT testcase_priority FROM test_cases WHERE testcase_id = " + testCaseId);
                    while (resultSet.next()) {
                        testCasePriority = resultSet.getString("testcase_priority");
                    }
                    closeResources(resultSet, statement, connection);
                } catch (SQLException | ClassNotFoundException e) {
                    System.out.println(e);
                }
                return testCasePriority;
        }

        public static String getTestCaseTypeById(int testCaseId) {
                String testCaseType = "";
                try {
                    PropertiesHandler propertiesHandler = new PropertiesHandler();
                    Connection connection = getConnection(propertiesHandler);
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT testcase_type FROM test_cases WHERE testcase_id = " + testCaseId);
                    while (resultSet.next()) {
                        testCaseType = resultSet.getString("testcase_type");
                    }
                    closeResources(resultSet, statement, connection);
                } catch (SQLException | ClassNotFoundException e) {
                    System.out.println(e);
                }
                return testCaseType;
        }

        public static String getTestCaseStepsById(int testCaseId) {
                String testCaseSteps = "";
                try {
                    PropertiesHandler propertiesHandler = new PropertiesHandler();
                    Connection connection = getConnection(propertiesHandler);
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT step FROM test_cases WHERE testcase_id = " + testCaseId);
                    while (resultSet.next()) {
                        testCaseSteps = resultSet.getString("step");
                    }
                    closeResources(resultSet, statement, connection);
                } catch (SQLException | ClassNotFoundException e) {
                    System.out.println(e);
                }
                return testCaseSteps;
        }

        public static String getTestCaseExpectedResultById(int testCaseId) {
                String testCaseExpectedResult = "";
                try {
                    PropertiesHandler propertiesHandler = new PropertiesHandler();
                    Connection connection = getConnection(propertiesHandler);
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT testcase_expected_results FROM test_cases WHERE testcase_id = " + testCaseId);
                    while (resultSet.next()) {
                        testCaseExpectedResult = resultSet.getString("testcase_expected_results");
                    }
                    closeResources(resultSet, statement, connection);
                } catch (SQLException | ClassNotFoundException e) {
                    System.out.println(e);
                }
                return testCaseExpectedResult;
        }

    public static void deleteTestCaseById(int testCaseId) {
        try {
            PropertiesHandler propertiesHandler = new PropertiesHandler();
            Connection connection = getConnection(propertiesHandler);
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM test_cases WHERE testcase_id = ?");
            preparedStatement.setInt(1, testCaseId);
            preparedStatement.executeUpdate();
            closeResources(preparedStatement, connection);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public static void updateTestCase() {
        // ToDo: Implement update test case
    }

    public static boolean isConnected() {
        try {
            PropertiesHandler propertiesHandler = new PropertiesHandler();
            Connection connection = getConnection(propertiesHandler);
            closeResources(null, null, connection);
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            return false;
        }
    }

    public static int getNumberOfTestCases() {
        int numberOfTestCases = 0;
        try {
            PropertiesHandler propertiesHandler = new PropertiesHandler();
            Connection connection = getConnection(propertiesHandler);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM test_cases");
            while (resultSet.next()) {
                numberOfTestCases = resultSet.getInt(1);
            }
            closeResources(resultSet, statement, connection);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return numberOfTestCases;
    }

    public static int getNumberOfFunctionalTestCases() {
        int numberOfFunctionalTestCases = 0;
        try {
            PropertiesHandler propertiesHandler = new PropertiesHandler();
            Connection connection = getConnection(propertiesHandler);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM test_cases WHERE testcase_type = 'Functional'");
            while (resultSet.next()) {
                numberOfFunctionalTestCases = resultSet.getInt(1);
            }
            closeResources(resultSet, statement, connection);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return numberOfFunctionalTestCases;
    }

    public static int getNumberOfGuiTestCases() {
        int numberOfGuiTestCases = 0;
        try {
            PropertiesHandler propertiesHandler = new PropertiesHandler();
            Connection connection = getConnection(propertiesHandler);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM test_cases WHERE testcase_type = 'GUI'");
            while (resultSet.next()) {
                numberOfGuiTestCases = resultSet.getInt(1);
            }
            closeResources(resultSet, statement, connection);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return numberOfGuiTestCases;
    }

    public static int getNumberOfPerformanceTestCases() {
        int numberOfPerformanceTestCases = 0;
        try {
            PropertiesHandler propertiesHandler = new PropertiesHandler();
            Connection connection = getConnection(propertiesHandler);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM test_cases WHERE testcase_type = 'Performance'");
            while (resultSet.next()) {
                numberOfPerformanceTestCases = resultSet.getInt(1);
            }
            closeResources(resultSet, statement, connection);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return numberOfPerformanceTestCases;
    }

    public static int getNumberOfSecurityTestCases() {
        int numberOfSecurityTestCases = 0;
        try {
            PropertiesHandler propertiesHandler = new PropertiesHandler();
            Connection connection = getConnection(propertiesHandler);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM test_cases WHERE testcase_type = 'Security'");
            while (resultSet.next()) {
                numberOfSecurityTestCases = resultSet.getInt(1);
            }
            closeResources(resultSet, statement, connection);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return numberOfSecurityTestCases;
    }

    public static int getNumberOfUsabilityTestCases() {
        int numberOfUsabilityTestCases = 0;
        try {
            PropertiesHandler propertiesHandler = new PropertiesHandler();
            Connection connection = getConnection(propertiesHandler);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM test_cases WHERE testcase_type = 'Usability'");
            while (resultSet.next()) {
                numberOfUsabilityTestCases = resultSet.getInt(1);
            }
            closeResources(resultSet, statement, connection);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return numberOfUsabilityTestCases;
    }

    public static int getNumberOfLowPriorityTestCases() {
        int numberOfLowPriorityTestCases = 0;
        try {
            PropertiesHandler propertiesHandler = new PropertiesHandler();
            Connection connection = getConnection(propertiesHandler);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM test_cases WHERE testcase_priority = ?");
            preparedStatement.setString(1, "Low");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                numberOfLowPriorityTestCases = resultSet.getInt(1);
            }
            closeResources(resultSet, preparedStatement, connection);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return numberOfLowPriorityTestCases;
    }

    public static int getNumberOfMediumPriorityTestCases() {
        int numberOfMediumPriorityTestCases = 0;
        try {
            PropertiesHandler propertiesHandler = new PropertiesHandler();
            Connection connection = getConnection(propertiesHandler);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM test_cases WHERE testcase_priority = ?");
            preparedStatement.setString(1, "Medium");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                numberOfMediumPriorityTestCases = resultSet.getInt(1);
            }
            closeResources(resultSet, preparedStatement, connection);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return numberOfMediumPriorityTestCases;
    }

    public static int getNumberOfHighPriorityTestCases() {
        int numberOfHighPriorityTestCases = 0;
        try {
            PropertiesHandler propertiesHandler = new PropertiesHandler();
            Connection connection = getConnection(propertiesHandler);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM test_cases WHERE testcase_priority = ?");
            preparedStatement.setString(1, "High");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                numberOfHighPriorityTestCases = resultSet.getInt(1);
            }
            closeResources(resultSet, preparedStatement, connection);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return numberOfHighPriorityTestCases;
    }

    public static int getNumberOfCriticalPriorityTestCases() {
        int numberOfCriticalPriorityTestCases = 0;
        try {
            PropertiesHandler propertiesHandler = new PropertiesHandler();
            Connection connection = getConnection(propertiesHandler);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM test_cases WHERE testcase_priority = ?");
            preparedStatement.setString(1, "Critical");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                numberOfCriticalPriorityTestCases = resultSet.getInt(1);
            }
            closeResources(resultSet, preparedStatement, connection);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return numberOfCriticalPriorityTestCases;
    }
}
