package ide;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;

public class DatabaseManager {

    //Hacer variables y metodos estáticos
    private static Connection connection = null;
    private static String url = "";
    private static String dbName = "";
    private static String userName = "";
    private static String password = "";
    private final static String driver = "com.mysql.jdbc.Driver";
    private static boolean isConnected = false;
    private static Statement stmt;

//    public DatabaseManager(String url, String dbName, String userName, String password) {
//        DatabaseManager.url = url;
//        DatabaseManager.dbName = dbName;
//        DatabaseManager.userName = userName;
//        DatabaseManager.password = password;
//    }
    public static void setConnectionData(String url, String dbName, String userName, String password) {
        DatabaseManager.url = url;
        DatabaseManager.dbName = dbName;
        DatabaseManager.userName = userName;
        DatabaseManager.password = password;
    }

    public static Connection getConnection() {
        if (isConnected) {
            return connection;
        } else {
            OpenConnection();
        }
        return connection;
    }

    public static void closeConnection() {
        if (isConnected) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static void OpenConnection() {
        try {
            Class.forName(driver).newInstance();
            connection = DriverManager.getConnection(url + dbName, userName, password);
            isConnected = !connection.isClosed();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //CRUDE
    public static int create(String table, String columns, String values) {
        //INSERT
        try {
            String query = "INSERT INTO " + table + " (" + columns + ") VALUES (" + values + ")";
            stmt = connection.createStatement();
            int result = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
            stmt.close();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static ArrayList<Row> read(String table, String columns, String condition) {
        ArrayList<Row> resultList = new ArrayList<>();
        try {
            //SELECT
            String query = "SELECT " + columns + " FROM " + table + " WHERE " + condition;
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);
            ResultSetMetaData queryColumns = result.getMetaData();
            int columnCount = queryColumns.getColumnCount();
            while (result.next()) {
                Row row = new Row();
                for (int i = 1; i <= columnCount; i++) {
                    row.put(queryColumns.getColumnName(i), result.getString(i));
                }
                resultList.add(row);
            }
            result.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultList;
    }

    public static ArrayList<Row> read(String table, String columns) {
        ArrayList<Row> resultList = new ArrayList<>();
        try {
            //SELECT
            String query = "SELECT " + columns + " FROM " + table;
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);
            ResultSetMetaData queryColumns = result.getMetaData();
            int columnCount = queryColumns.getColumnCount();
            while (result.next()) {
                Row row = new Row();
                for (int i = 1; i <= columnCount; i++) {
                    row.put(queryColumns.getColumnName(i), result.getString(i));
                }
                resultList.add(row);
            }
            result.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultList;
    }

    public int delete(String table, String condition, int id) {
        try {
            String query = "DELETE FROM " + table + " WHERE id_xmlProject ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);
            return pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

//    public static ResultSet Select(String query) {
//        if (isConnected) {
//            try {
//                PreparedStatement stmt = connection.prepareStatement(query);
//                ResultSet rs = stmt.executeQuery();
////            rs.close();
////            stmt.close();
//                return rs;
//            } catch (SQLException ex) {
//                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return null;
//    }
//    public static String InsertXML(String query, String name, String path) {
//        if (isConnected) {
//            try {
//
//                // create the mysql insert preparedstatement
//                PreparedStatement preparedStmt = connection.prepareStatement(query);
//                preparedStmt.setString(1, name);
//                preparedStmt.setString(2, path);
//                // execute the preparedstatement
//                preparedStmt.execute();
//
////            connection.close();
//                return "XML Inserted";
//            } catch (SQLException ex) {
//                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return "No Connection to Database";
//    }
}
