
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

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
//    public static com.mysql.jdbc.Connection setKoneksi() {
//        String konString ="jdbc:mysql://localhost/db_donasi_online";
//        com.mysql.jdbc.Connection koneksi = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            koneksi = (com.mysql.jdbc.Connection)DriverManager.getConnection(konString,"root","");
//            System.out.println("Koneksi Berhasil");
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(database.class.getName()).log(Level.SEVERE,null, ex);
//            System.out.println("Koneksi Gagal");
//        } catch (SQLException ex) {
//            Logger.getLogger(database.class.getName()).log(Level.SEVERE,null, ex);
//            System.out.println("Koneksi Gagal");
//        }
//        return koneksi;
//
//    }
//
//    public static int execute(String SQL) {
//        int status = 0;
//        com.mysql.jdbc.Connection koneksi = setKoneksi();
//        try {
//            Statement st = koneksi.createStatement();
//            status = st.executeUpdate(SQL);
//        } catch (SQLException ex) {
//            Logger.getLogger(database.class.getName()).log(Level.SEVERE,null, ex);
//        }
//        return status;
//    }
//
//    public static ResultSet executeQuery(String SQL) {
//        ResultSet rs = null;
//        com.mysql.jdbc.Connection koneksi = setKoneksi();
//        try {
//            Statement st = koneksi.createStatement();
//            rs = st.executeQuery(SQL);
//        } catch (SQLException ex) {
//            Logger.getLogger(database.class.getName()).log(Level.SEVERE,null, ex);
//        }
//        return rs;
//    }
//
//    static Object GetConnection() {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
    
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
}