/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.sql.Time;
import java.util.Date;




/**
 *
 * @author johan
 */
public class Bitacora {
  private int id;
  private Vehiculo vehiculo;
  private String provincia;
  private String destino;
  private Date fechaSalida;
  private Time horaSalida;
  private int KInical;
  private Date fechaLlegada;
  private Time horaLlegada;
  private int KFinal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

   

    public void setPlaca(Vehiculo placa) {
        this.vehiculo=placa;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFechaSalida() {
        
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
//        if (fechaSalida.after(fechaLlegada)) {
            this.fechaSalida = fechaSalida;
//        }else{
//            System.out.println("No es posible");
//        }
        
    }

    public Time getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Time horaSalida) {
        this.horaSalida = horaSalida;
    }

    public int getKInical() {
        return KInical;
    }

    public void setKInical(int KInical) {
        if (this.KInical < KFinal) {
           this.KInical = KInical;
        }
    }

    public Date getFechaLlegada() {
     
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
//        if (fechaLlegada.before(fechaSalida)) {
          this.fechaLlegada = fechaLlegada;
//        }else{
//               System.out.println("No es posible");
//        }
        
    }

    public Time getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Time horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public int getKFinal() {
        return KFinal;
    }

    public void setKFinal(int KFinal) {
        if (this.KFinal > KInical) {
            this.KFinal = KFinal;
        }
    }

    public Bitacora() {
        this.id = 0;
        this.vehiculo = null;
        this.provincia = null;
        this.destino = null;
        this.fechaSalida = null;
        this.horaSalida = null;
        this.KInical = 0;
        this.fechaLlegada = null;
        this.horaLlegada = null;
        this.KFinal = 0;
    }
    public Bitacora(Vehiculo placa) {
        this.id = 0;
        this.vehiculo = placa;
        this.provincia = null;
        this.destino = null;
        this.fechaSalida = null;
        this.horaSalida = null;
        this.KInical = 0;
        this.fechaLlegada = null;
        this.horaLlegada = null;
        this.KFinal = 0;
    }

    public Bitacora(int id, Vehiculo placa, String provincia, String destino, Date fechaSalida, Time horaSalida, int KInical, Date fechaLlegada, Time horaLlegada, int KFinal) {
        this.id = id;
        this.vehiculo = placa;
        this.provincia = provincia;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.horaSalida = horaSalida;
        this.KInical = KInical;
        this.fechaLlegada = fechaLlegada;
        this.horaLlegada = horaLlegada;
        this.KFinal = KFinal;
    }
    
    @Override
    public String toString() {
        return "Bitacora{" + "id=" + id + ", vehiculo=" + vehiculo + ", provincia=" + provincia + ", destino=" + destino + ", fechaSalida=" + fechaSalida + ", horaSalida=" + horaSalida + ", KInical=" + KInical + ", fechaLlegada=" + fechaLlegada + ", horaLlegada=" + horaLlegada + ", KFinal=" + KFinal + '}';
    }
  
  
}
