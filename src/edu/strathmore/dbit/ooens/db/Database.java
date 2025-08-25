package edu.strathmore.dbit.ooens.db;

import edu.strathmore.dbit.ooens.utils.log.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author strategide
 */
public class Database {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static final String SCHEME = "jdbc:mysql://";
    private static final String HOST = "localhost";
    private static final int PORT = 3306;
    private static final String DATABASE_NAME = "ooens";

    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    private static final String URL = String.format(
            "%s%s:%d/%s",
            SCHEME,
            HOST,
            PORT,
            DATABASE_NAME
    );

    private static Database INSTANCE;

    public static Database getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Database();
            INSTANCE.init();
        }

        return INSTANCE;
    }

    private Connection connection;
    private Statement statement;

    private Database() {
    }

    private void loadDriver() throws ClassNotFoundException {
        Log.v("Loading driver...", this);
        Log.v(" → Driver: " + DRIVER);
        Class.forName(DRIVER);
    }

    private void connect() throws SQLException {
        Log.v("Connecting to database...", this);
        Log.v(" → URL: " + URL, this);
        connection = DriverManager.getConnection(URL, DB_USERNAME, DB_PASSWORD);
    }

    private void init() {
        try {
            loadDriver();
            connect();
            Log.v(" ✅ Connected.", this);
        } catch (ClassNotFoundException e) {
            Log.e(" → Loading the jdbc driver failed: " + e.getMessage(), this);
            disconnect();
        } catch (SQLException e) {
            Log.e(" → Database connection failed: " + e.getMessage(), this);
            disconnect();
        }
    }

    public boolean createTable(String query) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            Log.e(" → Executing 'createTable' failed: " + e.getMessage(), this);
            cleanUp();
            return false;
        }
    }
    
    private void cleanUp() {
        if (statement == null) {
            return;
        }
        
        try {
            statement.close();
        } catch (SQLException e) {
            Log.e(" → Executing 'cleanUp' failed: " + e.getMessage(), this);
        } finally {
            statement = null;
        }
    }

    private void disconnect() {
        if (connection == null) {
            return;
        }

        Log.v("Disconnecting...", this);

        try {
            if (!connection.isClosed()) {
                connection.close();
            }
            Log.v(" ✅ Disconnected.", this);
        } catch (SQLException e) {
            Log.e(" → Database disconnection failed: " + e.getMessage(), this);
        } finally {
            connection = null;
        }

    }

}
