/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Martin3
 */
public class ConnectDB {
    
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "lssai_user";
    private static final String password = "ls123"; 
    private static final String url = "jdbc:mysql://10.10.20.200:3306/lssai_bd";
    
    public ConnectDB() {
        conn = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            
            if(conn != null){
                System.out.println("Conexion establecida");
            }
        } 
        catch(SQLException SQLE){
            JOptionPane.showMessageDialog(null, "ERROR EN LA CONEXION CON BD\nERROR : " + SQLE.getMessage());
        }
        catch(ClassNotFoundException CNFE){
            JOptionPane.showMessageDialog(null, "ERROR DRIVER BD JAVA\nERROR : " + CNFE.getMessage());
        }
    }
    
    // con este metodo nos retorna la conexion
    public Connection getConnection(){
        return conn;
    }
       
    // con este metodo nos desconectamos de la BD
    public void disconnect(){
        conn = null;        
        if(conn == null){
            System.out.println("Conexion terminada");
        }
    }  
}

