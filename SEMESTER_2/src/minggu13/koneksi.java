/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minggu13;

/**
 *
 * @author HP
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class koneksi {
    private static Connection con;
    private static Statement stm;
    
    public static Connection getConnection(){
        if (con == null) {
            try {
               String url = "jdbc:mysql://localhost:3306/penjualan";
               String user = "root";
               String pass = "";
               DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
               con = (Connection) DriverManager.getConnection(url, user, pass);
               stm = con.createStatement();
                System.out.println("berhasil");
            }catch(Exception e){
//                Logger.getLogger(conn.class.getName()).log(Level.SEVERE,null, e);
            }
        }
        return con;
}
}
