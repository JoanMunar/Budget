package dbc;
import java.sql.Connection;

        import java.sql.DriverManager;
        import java.sql.SQLException;


public class ConnectionFactory {
    private static ConnectionFactory instance = new ConnectionFactory();
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static  String DB_URL;

    //  Database credentials
    static  String USER;
    static  String PASS;

    private ConnectionFactory() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL,USER, PASS);
        } catch (SQLException e) {
            System.out.println("ERROR: Unable to Connect to Database.");
        }
        return connection;
    }

    public static Connection getConnection() {
        return instance.createConnection();
    }

    public ConnectionFactory(String DB_URL, String USER,String PASS ){
        this.DB_URL = DB_URL;
        this.USER = USER;
        this.PASS = PASS;
    }


}