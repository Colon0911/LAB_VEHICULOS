/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author johan
 */
public class Vehiculo {
    private int Id;
    private String Placa;
    private String Descripcion;

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

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Vehiculo() {
        this.Id = 0;
        this.Placa = null;
        this.Descripcion = null;
    }

    public Vehiculo(int Id, String Placa, String Descripcion) {
        this.Id = Id;
        this.Placa = Placa;
        this.Descripcion = Descripcion;
    }

    public Vehiculo(String Placa) {
        this.Id = 0;
        this.Placa = Placa;
        this.Descripcion = null;
    }
    
    public boolean comprobar(int Id, String Placa, String Descripcion){
        if (Id!=0 && Placa!=null && Descripcion!=null) {
            return true;
        }else
            return false;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "Id=" + Id + ", Placa=" + Placa + ", Descripcion=" + Descripcion + '}';
    }
    
}
