/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author XPC
 */
public class controladorBitacora {
    private Connection cn;
      private PreparedStatement pst;
      private ResultSet rs;
      private Bitacora bitacora;
    
    
    public void conectar(){
        try {
            this.cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/empresavehiculos?useServerPrepStmts=true", "root", "");   
            pst = cn.prepareStatement("insert into bitacora values(null,?,?,?,?,?,?,?,?)");
        } catch (SQLException ex) {
            System.out.println("Error de conexion");
        }
    }
          public boolean  Agregar(Bitacora bitacora){
      try {
            this.pst.executeUpdate("insert into bitacora values(null,'"+bitacora.getPlaca()+"','"+bitacora.getProvincia()+"','"+bitacora.getDestino()+"','"+bitacora.getFechaSalida()+"','"+bitacora.getHoraSalida()+"','"+bitacora.getKInicial()+"','"+bitacora.getFechaLLegada()+"','"+bitacora.getHoraLLegada()+"','"+bitacora.getKFinal()+"')",Statement.RETURN_GENERATED_KEYS);
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
          
          
          
          
    public Bitacora buscar(Bitacora bitacora){
        String placa=bitacora.getPlaca();
        
        try {
            pst = cn.prepareStatement("select * from vehiculos where placa = ?");
            pst.setString(1, placa.trim());
            rs=pst.executeQuery();
            if (rs.next()) {
                bitacora = new Bitacora(rs.getInt("id"),rs.getString("placa"),rs.getString("provincia"),rs.getString("destino"),rs.getString("FechaSalida"),rs.getString("HoraSalida"),rs.getInt("KInicial"),rs.getString("FechaLlegada"),rs.getString("FechaLlegada"),rs.getInt("KFinal"));
                return bitacora;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorVehiculo.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        return null;
    }
    
    public void actualizar(Bitacora bitacora,Date fl,Date hl,String kf){
        
        
        if(bitacora.getFechaLLegada()==null ){
            
        }
        
    }
    public boolean eliminar(Bitacora bitacora){
        try {
                String placa=bitacora.getPlaca();
                pst = cn.prepareStatement("select * from bitacora where placa = ?");
                pst.setString(1, placa.trim());
                rs=pst.executeQuery();
            if (rs.next()) {
                bitacora = new Bitacora(rs.getInt("id"),rs.getString("placa"),rs.getString("provincia"),rs.getString("destino"),rs.getString("FechaSalida"),rs.getString("HoraSalida"),rs.getInt("KInicial"),rs.getString("FechaLlegada"),rs.getString("FechaLlegada"),rs.getInt("KFinal"));
                pst = cn.prepareStatement("delete from bitacora where id = "+bitacora.getId());
                pst.executeUpdate(); 
                return true;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorVehiculo.class.getName()).log(Level.SEVERE, null, ex);     
        }
        return false;
    }
    
    
    public ArrayList listar(String placa){
        ArrayList<Bitacora> array=new ArrayList<>();
        try {
           
           pst = cn.prepareStatement("select * from bitacora where placa like '"+placa.trim() +"%'");
           rs=pst.executeQuery();
           bitacora = new Bitacora(rs.getInt("id"),rs.getString("placa"),rs.getString("provincia"),rs.getString("destino"),rs.getString("FechaSalida"),rs.getString("HoraSalida"),rs.getInt("KInicial"),rs.getString("FechaLlegada"),rs.getString("FechaLlegada"),rs.getInt("KFinal"));
           while (rs.next()) {
                
                array.add(bitacora);
                  
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return array;
    }
     public boolean validarPK(Bitacora bitacora){
         
    
        String placa=bitacora.getPlaca();
        if(this.buscar(bitacora)!=bitacora){
            System.out.println("no se encuentra");
            return true;
            
        }else{
            try {

            pst = cn.prepareStatement("select * from bitacora where placa = ?");
            pst.setString(1, placa.trim());
            rs=pst.executeQuery();
            if(rs.next()){
                
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("placa"));
                System.out.println(rs.getString("descripcion"));
            }
        } catch (SQLException ex) {
            System.out.println("ERROR EN EL READ"); 
        }
            return false;
        }
     }
     
     
    
    public static void main(String[] args) {
            Date objDate = new Date(0);
            
            System.out.println(objDate); 
            SimpleDateFormat objSDF = new SimpleDateFormat("dd/MM/yyyy");
            String fecha=objSDF.format(objDate);
            Date ho = new Date(0);
            String hora= "hh: mm: ss";
            SimpleDateFormat hos = new SimpleDateFormat(hora);
            
            //Bitacora b=new Bitacora(0, "ho", "san", "puto", objDate, ho, 0, objDate, ho, 0);
            controladorBitacora bi=new controladorBitacora();
            bi.conectar();
            
            Bitacora b=new Bitacora(0, "w", "e", "r", fecha, hora, 2, fecha, hora, 3);
            Bitacora bb=new Bitacora(0, "wa", "e", "r", fecha, hora, 2, fecha, hora, 3);
            Bitacora bbb=new Bitacora(0, "comida", "e", "r", fecha, hora, 2, fecha, hora, 3);
//            bi.Agregar(b);
//            bi.Agregar(bb);
//            bi.Agregar(bbb);
//            bi.eliminar(b);
            bi.listar("wa");

        }
    
}
