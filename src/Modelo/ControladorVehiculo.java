/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johan
 */
public class ControladorVehiculo {
    private Connection cn;
    private PreparedStatement pst;
    private ResultSet rs;
    Vehiculo vehiculo;

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    public void conectar(){
        try {
            this.cn = DriverManager.getConnection("\"jdbc:mysql://localhost/empresavehiculos\",\"root\",\"\"");
            this.pst = cn.prepareStatement("insert into vehiculos values(?,?,?)");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
    
    public boolean  Agregar(Vehiculo vehiculo){
        try {
            pst.setString(2, String.valueOf(vehiculo.getPlaca()));
            pst.setString(3, String.valueOf(vehiculo.getDescripcion()));
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorVehiculo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public Vehiculo buscar(Vehiculo vehiculo){
        try {
            pst.setString(2, String.valueOf(vehiculo.getPlaca()));
            rs=pst.executeQuery();
            if (rs.next()) {
                return vehiculo;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorVehiculo.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }
    
    public boolean actualizar(Vehiculo vehiculo){
       
        return false;
        
    }
    public boolean eliminar(){
        try {
            pst = cn.prepareStatement("delete from vehiculos where id = ?");
            pst.setString(1, String.valueOf(vehiculo.getId()));
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorVehiculo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
