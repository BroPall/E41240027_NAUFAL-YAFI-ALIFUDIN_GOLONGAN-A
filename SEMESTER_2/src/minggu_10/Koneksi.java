package minggu_10;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Koneksi {

    public static Connection con;
    public static Statement stm;
    
    public static void main(String[] args) {
        
       try {
           String url = "jdbc:mysql://localhost/penjualan";
           String user = "root";
           String pass = "";
           Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection(url,user,pass);
           stm = con.createStatement();
           System.out.println("Koneksi Berhasil");
       }
       catch (Exception e){
           System.out.println("Koneksi Gagal" + e.getMessage());
       } 
    }
}
