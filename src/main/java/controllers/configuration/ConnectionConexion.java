package controllers.configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionConexion {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/airline_avianca?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "juan";

    public static DataSource getDataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(JDBC_URL);
        basicDataSource.setUsername(JDBC_USER);
        basicDataSource.setPassword(JDBC_PASSWORD);
        basicDataSource.setInitialSize(50);
        return basicDataSource;
    }

    public static Connection getConnection() throws SQLException{
        return getDataSource().getConnection();
    }

    public static void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public  static void closePreparedStatement(PreparedStatement preparedStatement) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public  static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}

