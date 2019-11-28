
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class database {
    private static String serverName = "localhost";
    private static String username = "root";
    private static String password = "";
    private static String dbName = "db_donasi_online";
    private static Integer portNumber = 3306;
    
    public static Connection getConnection() {
        Connection cn = null;
        
        MysqlDataSource datasource = new MysqlDataSource();
        
        datasource.setServerName(serverName);
        datasource.setUser(username);
        datasource.setPassword(password);
        datasource.setDatabaseName(dbName);
        datasource.setPortNumber(portNumber);
        
        try {
            cn = datasource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger("Get Connection ->  " + database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cn;
    }
    
    public static void theQuery(String query) {
        Connection cn = null;
        Statement st = null;
        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_donasi_online", "root", "");
            st = cn.createStatement();
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Query Executed");
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}