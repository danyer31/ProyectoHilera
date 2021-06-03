/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import config.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Josué
 */

public class Popup {
         

    public static void main(String[] args){
        Conexion con = new Conexion();
        Connection cn;
        Statement st;
        ResultSet rs;
        DefaultTableModel modelo;
        int id;
        

        String sql = "SELECT Fecha_Mantenimiento, Descripcion_Mantenimiento FROM mantenimiento";
        try{
            cn = con.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            Object[]persona = new Object[2];            
            while (rs.next()){
                persona[0]= rs.getString("Fecha_Mantenimiento");
                persona[1] = rs.getString("Descripcion_Mantenimiento");                
            }            
        } catch(Exception e){
        }
        JOptionPane.showMessageDialog(null, "Proximo mantenimiento: " + sql );
    }
    
}

