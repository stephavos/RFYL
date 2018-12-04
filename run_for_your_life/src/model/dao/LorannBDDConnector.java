package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Sutibun
 *
 */
final class LorannBDDConnector {


    private static LorannBDDConnector instance;
    private static String user     = "root";
    private static String password = "";
    private static String url      = "jdbc:mysql://localhost/TNTRun?useSSL=false&serverTimezone=UTC";
    private Connection    connection;
    private Statement     statement;
    private LorannBDDConnector() {
        this.open();
    }

    /**
     * @return
     */
    public static LorannBDDConnector getInstance() {
        if (instance == null) {
            setInstance(new LorannBDDConnector());
        }
        return instance;
    }

    /**
     * @param instance
     */
    private static void setInstance(final LorannBDDConnector instance) {
        LorannBDDConnector.instance = instance;
    }

    /**
     * @return
     */
    private boolean open() {
        try {
            this.connection = DriverManager.getConnection(LorannBDDConnector.url, LorannBDDConnector.user,
                    LorannBDDConnector.password);
            this.statement = this.connection.createStatement();
            return true;
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    /**
     * @param query
     * @return
     */
    public ResultSet executeQuery(final String query) {
        try {
            return this.getStatement().executeQuery(query);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param query
     * @return
     */
    public java.sql.CallableStatement prepareCall(final String query) {
        try {
            return this.getConnection().prepareCall(query);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param query
     * @return
     */
    public int executeUpdate(final String query) {
        try {
            return this.statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * @return
     */
    public Connection getConnection() {
        return this.connection;
    }

    /**
     * @param connection
     */
    public void setConnection(final Connection connection) {
        this.connection = connection;
    }

    /**
     * @return
     */
    public Statement getStatement() {
        return this.statement;
    }

    /**
     * @param statement
     */
    public void setStatement(final Statement statement) {
        this.statement = statement;
    }

}