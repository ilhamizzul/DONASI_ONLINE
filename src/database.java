
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    
//    public String url = "jdbc:mysql://localhost:3306/db_donasi_online";
//    public String user = "root";
//    public String pass = "";
//    
//    public static Connection con = null;
//    public static Statement stmt = null;
//    public static ResultSet rs = null;
//    
//    public database() {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (Exception e){
//            JOptionPane.showMessageDialog(null, ""+e.getMessage(), "JDBC Driver Error",JOptionPane.WARNING_MESSAGE);
//        }
//        try {
//            con = DriverManager.getConnection(url, user, pass);
//            stmt = con.createStatement();
//        } catch(Exception e) {
//            JOptionPane.showMessageDialog(null, ""+e.getMessage(), "Connection Error",JOptionPane.WARNING_MESSAGE);
//        }
//    }
//    
//    public ResultSet getData(String SQL) throws SQLException {
//        try {
//            rs = stmt.executeQuery(SQL);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, ""+e.getMessage(), "Communication Error",JOptionPane.WARNING_MESSAGE);
//        }
//        return rs;
//    }
//    
//    public void Query (String SQL) {
//        try {
//            stmt.executeUpdate(SQL);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, ""+e.getMessage(), "Communication Error",JOptionPane.WARNING_MESSAGE);
//        }
//    }
    
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
    
    public static int execute(String SQL) {
        int status = 0;
        Connection koneksi = getConnection();
        try {
            Statement st = koneksi.createStatement();
            status = st.executeUpdate(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE,null, ex);
        }
        return status;
    }
    
}