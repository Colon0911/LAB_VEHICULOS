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
 * @author XPC
 */
public class Bitacora {
    private int Id;
    private String Placa;
    private String Provincia;
    private String Destino;
    private String FechaSalida;
    private String HoraSalida;
    private int KInicial;
    private String FechaLLegada;
    private String HoraLLegada;
    private int KFinal;

    public String getFechaSalida() {
        return FechaSalida;
    }

    public void setFechaSalida(String FechaSalida) {
        this.FechaSalida = FechaSalida;
    }

    public String getHoraSalida() {
        return HoraSalida;
    }

    public void setHoraSalida(String HoraSalida) {
        this.HoraSalida = HoraSalida;
    }

    public String getFechaLLegada() {
        return FechaLLegada;
    }

    public void setFechaLLegada(String FechaLLegada) {
        this.FechaLLegada = FechaLLegada;
    }

    public String getHoraLLegada() {
        return HoraLLegada;
    }

    public void setHoraLLegada(String HoraLLegada) {
        this.HoraLLegada = HoraLLegada;
    }

   
    
    

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public String getProvincia() {
        return Provincia;
    }

    public void setProvincia(String Provincia) {
        this.Provincia = Provincia;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String Destino) {
        this.Destino = Destino;
    }


    public int getKInicial() {
        return KInicial;
    }

    public void setKInicial(int KInicial) {
        this.KInicial = KInicial;
    }


    public int getKFinal() {
        return KFinal;
    }

    public void setKFinal(int KFinal) {
        this.KFinal = KFinal;
    }

    public Bitacora(int Id, String Placa, String Provincia, String Destino, String FechaSalida, String HoraSalida, int KInicial, String FechaLLegada, String HoraLLegada, int KFinal) {
        this.Id = Id;
        this.Placa = Placa;
        this.Provincia = Provincia;
        this.Destino = Destino;
        this.FechaSalida = FechaSalida;
        this.HoraSalida = HoraSalida;
        this.KInicial = KInicial;
        this.FechaLLegada = FechaLLegada;
        this.HoraLLegada = HoraLLegada;
        this.KFinal = KFinal;
    }

    

    
    
    
    
    
    
    
}
