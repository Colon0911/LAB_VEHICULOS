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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tiendadevehiculos.frmConfiguracion;

/**
 *
 * @author johan
 */
public class ControladorVehiculo {
    private Connection cn;
    private PreparedStatement pst;
    private Statement psss;
    private ResultSet rs;
    Vehiculo vehiculo;

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
//    public void conectar(){
//        try {
//            
//            cn = DriverManager.getConnection("\"jdbc:mysql://localhost/empresavehiculos","root","johansel");
//            pst = cn.prepareStatement("insert into vehiculos values(?,?,?)");
//            System.out.println("se conecto");
//        } catch (SQLException ex) {
//            Logger.getLogger(ControladorVehiculo.class.getName()).log(Level.SEVERE, null, ex);
//            //new frmConfiguracion().setVisible(true);
//            System.out.println("hola");
//        }
//  
//    }
      public void conectar(){
        try {
            this.cn = DriverManager.getConnection("jdbc:mysql://localhost/empresavehiculos?useServerPrepStmts=true", "root", "johansel");
           
            pst = cn.prepareStatement("insert into vehiculos values(?,?,?)");
        } catch (SQLException ex) {
            System.out.println("Error de conexion");
        }
    }
    public void conectar(String motor, String servidor, String usuario, String contraseña){
        try {
            this.cn = DriverManager.getConnection("jdbc:"+motor+"://"+servidor+"/empresavehiculos?useServerPrepSrmts=true",usuario,contraseña);
            this.pst = cn.prepareStatement("insert into vehiculos values(?,?,?)");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorVehiculo.class.getName()).log(Level.SEVERE, null, ex);
            
        }  
    }
    
    public boolean  Agregar(Vehiculo vehiculo){
        try {
            pst.setString(1, String.valueOf(vehiculo.getId()));
            pst.setString(2, String.valueOf(vehiculo.getPlaca()));
            pst.setString(3, String.valueOf(vehiculo.getDescripcion()));
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorVehiculo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public Vehiculo buscar(Vehiculo vehiculo){
        String placa=vehiculo.getPlaca();
        
        try {
            
            pst = cn.prepareStatement("select * from vehiculos where placa = ?");
             pst.setString(1, placa.trim());
            rs=pst.executeQuery();
           
           
            if (rs.next()) {
                return vehiculo;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorVehiculo.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        return null;
    }
    
    public boolean actualizar(Vehiculo vehiculo){
       
        return false;
        
    }
    public boolean eliminar(int id){
        try {
            pst = cn.prepareStatement("delete from vehiculos where id = "+id);
            
            pst.executeUpdate();
           
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorVehiculo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public ArrayList listar(String descricion){
        ArrayList<Vehiculo> array=new ArrayList<>();
        try {
            pst = cn.prepareStatement("select * from vehiculos where descripcion = like '"+descricion +"%'");
            rs=pst.executeQuery();
           
           
            while (rs.next()) {
               array.add(vehiculo);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return array;
    }
    

public static void main(String[] args) {
   ControladorVehiculo n=new ControladorVehiculo();
   Vehiculo v=new Vehiculo(100, "ut", "rojo");
   Vehiculo vv=new Vehiculo(1, "qwe", "negro");

   //n.conectar("mysql", "127.0.0.1", "root", "johansel");
    n.conectar();
    //n.Agregar(vv);
  //n.eliminar(100);
    System.out.println(n.listar("n"));
  System.out.println(n.buscar(vv));
}}
