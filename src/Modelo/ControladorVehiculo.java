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
public class ControladorVehiculo extends Vehiculo{
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

      public void conectar(){
        try {
            this.cn = DriverManager.getConnection("jdbc:mysql://localhost/empresavehiculos?useServerPrepStmts=true", "root", "johansel");
           
            pst = cn.prepareStatement("insert into vehiculos values(null,?,?)");
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
            //this.sentencias.executeUpdate("insert into datosgenerales values(null,'"+nombre+"','"+ciudad+"')");
            this.pst.executeUpdate("insert into vehiculos values(null,'"+vehiculo.getPlaca()+"','"+vehiculo.getDescripcion()+"')",Statement.RETURN_GENERATED_KEYS);
            this.rs=this.pst.getGeneratedKeys();
            if(rs.next()){
                rs.getInt(1);
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("ERROR AL AGREGAR");
            
        }
        return false;
    }
    
    public Vehiculo buscar(Vehiculo vehiculo){
        String placa=vehiculo.getPlaca();
        
        try {
            
            pst = cn.prepareStatement("select * from vehiculos where placa = ?");
            pst.setString(1, placa.trim());
            rs=pst.executeQuery();
            if (rs.next()) {
                vehiculo = new Vehiculo(rs.getInt("id"),rs.getString("placa"),rs.getString("descripcion"));
                return vehiculo;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorVehiculo.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        return null;
    }
    
    public boolean actualizar(Vehiculo vehiculo, String dato){
        
        vehiculo.setDescripcion(dato);
        String placa=vehiculo.getPlaca();
        
        if(vehiculo.getDescripcion()==dato){
            try {
                pst = cn.prepareStatement("select * from vehiculos where placa = ?");
                pst.setString(1, placa.trim());
                rs=pst.executeQuery();
            if (rs.next()) {
                vehiculo = new Vehiculo(rs.getInt("id"),rs.getString("placa"),rs.getString("descripcion"));
                pst = cn.prepareStatement("UPDATE vehiculos SET descripcion=? WHERE id ="+vehiculo.getId());
                pst.setString(1, dato);
                pst.executeUpdate();
            } 
            } catch (SQLException ex) {
                Logger.getLogger(ControladorVehiculo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return true;
        }else{
            return false;
        }
    }
    
    public boolean eliminar(Vehiculo vehiculo){
        try {
                String placa=vehiculo.getPlaca();
                pst = cn.prepareStatement("select * from vehiculos where placa = ?");
                pst.setString(1, placa.trim());
                rs=pst.executeQuery();
            if (rs.next()) {
                vehiculo = new Vehiculo(rs.getInt("id"),rs.getString("placa"),rs.getString("descripcion"));
                pst = cn.prepareStatement("delete from vehiculos where id = "+vehiculo.getId());
                pst.executeUpdate(); 
                return true;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorVehiculo.class.getName()).log(Level.SEVERE, null, ex);     
        }
        return false;
    } 
    
   public ArrayList listar(String descripcion){
        ArrayList<Vehiculo> array=new ArrayList<>();
        try {
           
           pst = cn.prepareStatement("select * from vehiculos where descripcion like '"+descripcion.trim() +"%'");
           rs=pst.executeQuery();
  
           while (rs.next()) {
                vehiculo = new Vehiculo(rs.getInt("id"),rs.getString("placa"),rs.getString("descripcion"));
                array.add(vehiculo);      
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return array;
    }
    
     public boolean validarPK(Vehiculo vehiculo){
        if(this.buscar(vehiculo)!=vehiculo){
            return true;
            
        }else{
            return false;   
        }}
        
    
    public boolean validarFK(){
        return true;
    }
    

public static void main(String[] args) {
   ControladorVehiculo n=new ControladorVehiculo();
   Vehiculo v=new Vehiculo(0,"hol", "amarillo");
   Vehiculo vv=new Vehiculo(0,"qwet", "negro");
   Vehiculo vvf=new Vehiculo(0,"34567", "Camaro");
   Vehiculo vvv=new Vehiculo(0,"qqqwwet", "nsdegro");
    n.conectar();
   Vehiculo vc=new Vehiculo("hola");

   //n.conectar("mysql", "127.0.0.1", "root", "johansel");
  
  // n.Agregar(vvf);
   //n.eliminar(100);
   //System.out.println(n.listar("n"));
   // n.actualizar(vvf, "amarillo");
     
    System.out.println(n.buscar(vc));
  
    System.out.println(n.validarPK(vc));
    
     //System.out.println( n.listar("n"));
  
}}
