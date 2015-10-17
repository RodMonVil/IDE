package ide;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;

public class DatabaseManager {

    //Hacer variables y metodos estáticos
    private Connection connection = null;
    private String url = "";
    private String dbName = "";
    private String userName = "";
    private String password = "";
    private final String driver = "com.mysql.jdbc.Driver";
    private boolean isConnected = false;
    private Statement stmt;

    public DatabaseManager(String url, String dbName, String userName, String password) {
        this.url = url;
        this.dbName = dbName;
        this.userName = userName;
        this.password = password;
    }

    public Connection getConnection() {
        if (isConnected) {
            return connection;
        } else {
            OpenConnection();
        }
        return connection;
    }

    public void closeConnection() {
        if (isConnected) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void OpenConnection() { //Hacer privado
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
    public void create() {
        //INSERT
    }
    
    public ArrayList<Row> read(String table, String columns) {
        ArrayList<Row> resultList = new ArrayList<>();
        String[] columnsArray = columns.split(",");
        int columnCount = columnsArray.length;
        try {
            //SELECT
            String query = "SELECT " + columns + " FROM " + table;
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while(result.next()) {
                Row row = new Row();
                for(int i = 0; i < columnCount; i++) {
                    row.put(columnsArray[i], result.getString(i + 1));
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

    public ResultSet Select(String query) {
        if (isConnected) {
            try {
                PreparedStatement stmt = connection.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();
//            rs.close();
//            stmt.close();
                return rs;
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public String InsertXML(String query, String name, String path) {
        if (isConnected) {
            try {

                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, name);
                preparedStmt.setString(2, path);
                // execute the preparedstatement
                preparedStmt.execute();

//            connection.close();
                return "XML Inserted";
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "No Connection to Database";
    }
}
