/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;
import java.sql.Time;




/**
 *
 * @author johan
 */
public class Bitacora {
  private int id;
  private String placa;
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

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
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
        if (fechaSalida.before(fechaLlegada)) {
            this.fechaSalida = fechaSalida;
        }else{
            System.out.println("No es posible");
        }
        
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
        this.KInical = KInical;
    }

    public Date getFechaLlegada() {
     
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        if (fechaLlegada.after(fechaSalida)) {
          this.fechaLlegada = fechaLlegada;
        }else{
               System.out.println("No es posible");
        }
        
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
        this.KFinal = KFinal;
    }

    public Bitacora() {
        this.id = 0;
        this.placa = null;
        this.provincia = null;
        this.destino = null;
        this.fechaSalida = null;
        this.horaSalida = null;
        this.KInical = 0;
        this.fechaLlegada = null;
        this.horaLlegada = null;
        this.KFinal = 0;
    }
    public Bitacora(String placa) {
        this.id = 0;
        this.placa = placa;
        this.provincia = null;
        this.destino = null;
        this.fechaSalida = null;
        this.horaSalida = null;
        this.KInical = 0;
        this.fechaLlegada = null;
        this.horaLlegada = null;
        this.KFinal = 0;
    }

    public Bitacora(int id, String placa, String provincia, String destino, Date fechaSalida, Time horaSalida, int KInical, Date fechaLlegada, Time horaLlegada, int KFinal) {
        this.id = id;
        this.placa = placa;
        this.provincia = provincia;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.horaSalida = horaSalida;
        this.KInical = KInical;
        this.fechaLlegada = fechaLlegada;
        this.horaLlegada = horaLlegada;
        this.KFinal = KFinal;
    }
    
   
  
  
}
