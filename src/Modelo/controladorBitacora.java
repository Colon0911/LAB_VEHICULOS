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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johan
 */
public class controladorBitacora extends Bitacora {

    private Connection cn;
    private PreparedStatement pst;
    private ResultSet rs;
    private Bitacora bitacora;

    public void conectar() {
        try {
            this.cn = DriverManager.getConnection("jdbc:mysql://localhost/empresavehiculos?useServerPrepStmts=true", "root", "johansel");
            System.out.println("conecto");
            pst = cn.prepareStatement("insert into bitacora values(null,?,?,?,?,?,?,?,?,?)");
        } catch (SQLException ex) {
            System.out.println("Error de conexion");
        }
    }

    public boolean Agregar(Bitacora bitacora) {
        try {
            // SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            this.pst.executeUpdate("insert into bitacora values(null,'"
                    + bitacora.getVehiculo().getPlaca()+ "','"
                    + bitacora.getProvincia() + "','"
                    + bitacora.getDestino() + "',CURDATE(),CURTIME(),'"
                    + bitacora.getKInical() + "',null,null,null", Statement.RETURN_GENERATED_KEYS);
            this.rs = this.pst.getGeneratedKeys();

            if (rs.next()) {
                rs.getInt(1);
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("ERROR AL AGREGAR");
        }
        return false;
    }

    public Bitacora buscar(Bitacora bitacora) {
        String placa = bitacora.getVehiculo().getPlaca();

        try {
            pst = cn.prepareStatement("select * from bitacora where placa = ?");
            pst.setString(1, placa);
            rs = pst.executeQuery();
            if (rs.next()) {
                bitacora = new Bitacora(rs.getInt("id"), (bitacora.getVehiculo()), rs.getString("provincia"), rs.getString("destino"), rs.getDate("FechaSalida"), rs.getTime("HoraSalida"), rs.getInt("KInicial"), rs.getDate("FechaLlegada"), rs.getTime("FechaLlegada"), rs.getInt("KFinal"));
//                 bitacora.setPlaca(bitacora.getVehiculo());
//                 bitacora.setProvincia((rs.getString(3)));
//                 bitacora.setDestino((rs.getString(4)));
//                 bitacora.setFechaSalida((rs.getDate(5)));
//                 bitacora.setHoraSalida((rs.getTime(6)));
//                 bitacora.setKInical((rs.getInt(7)));
//                 bitacora.setFechaLlegada((rs.getDate(8)));
//                 bitacora.setHoraLlegada((rs.getTime(9)));
//                 bitacora.setKFinal((rs.getInt(10)));
                return bitacora;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorVehiculo.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
    }

    public boolean actualizar(Bitacora bitacora) {
        String placa = bitacora.getVehiculo().getPlaca();
        try {
            pst = cn.prepareStatement("select * from bitacora where placa = ?");
            pst.setString(1, placa.trim());
            rs = pst.executeQuery();
            if (rs.next()) {
                bitacora = new Bitacora(rs.getInt("id"), (bitacora.getVehiculo()), rs.getString("provincia"), rs.getString("destino"), rs.getDate("FechaSalida"), rs.getTime("HoraSalida"), rs.getInt("KInicial"), rs.getDate("FechaLlegada"), rs.getTime("FechaLlegada"), rs.getInt("KFinal"));
                pst = cn.prepareStatement("UPDATE bitacora SET FechaLlegada=?, HoraLlegada=?, KFinal=? WHERE id =" + bitacora.getId());
                pst.setString(5, rs.getString("FechaLlegada"));
                pst.setString(6, rs.getString("HoraLlegada"));
                pst.setString(10, rs.getString("KFinal"));
                pst.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    public boolean eliminar(Bitacora bitacora) {
        try {
            String placa = bitacora.getVehiculo().getPlaca();
            pst = cn.prepareStatement("select * from bitacora where placa = ?");
            pst.setString(1, placa.trim());
            rs = pst.executeQuery();
            if (rs.next()) {
                bitacora = new Bitacora(rs.getInt("id"), (bitacora.getVehiculo()), rs.getString("provincia"), rs.getString("destino"), rs.getDate("FechaSalida"), rs.getTime("HoraSalida"), rs.getInt("KInicial"), rs.getDate("FechaLlegada"), rs.getTime("FechaLlegada"), rs.getInt("KFinal"));
                pst = cn.prepareStatement("delete from bitacora where id = " + bitacora.getId());
                pst.executeUpdate();
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList listar(String placa) {
        ArrayList<Bitacora> array = new ArrayList<>();
        try {

            pst = cn.prepareStatement("select * from bitacora where placa like '" + placa.trim() + "%'");
            rs = pst.executeQuery();
            bitacora = new Bitacora(rs.getInt("id"), (bitacora.getVehiculo()), rs.getString("provincia"), rs.getString("destino"), rs.getDate("FechaSalida"), rs.getTime("HoraSalida"), rs.getInt("KInicial"), rs.getDate("FechaLlegada"), rs.getTime("FechaLlegada"), rs.getInt("KFinal"));
            while (rs.next()) {
               array.add(new Bitacora());

            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return array;
    }

    public boolean validarPK(Bitacora bitacora) {

        String placa = bitacora.getVehiculo().getPlaca();
        if (this.buscar(bitacora) != bitacora) {
            System.out.println("no se encuentra");
            return true;

        } else {
            try {

                pst = cn.prepareStatement("select * from bitacora where placa = ?");
                pst.setString(1, placa.trim());
                rs = pst.executeQuery();
                if (rs.next()) {

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

        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

        //System.out.println( ho.getMinutes());
        //Bitacora b=new Bitacora(0, "ho", "san", "puto", objDate, ho, 0, objDate, ho, 0);
        controladorBitacora bi = new controladorBitacora();
        bi.conectar();
        // Bitacora b=new Bitacora(0, "w", "e", "r", b.setFechaSalida(fecha), ho, 2, objDate, ho, 3);
        //bi.Agregar(b);
    }
}
