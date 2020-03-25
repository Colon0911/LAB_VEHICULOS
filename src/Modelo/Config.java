/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johan
 */
public class Config {
    public  void muestraContenido(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            System.out.println(cadena);
        }
        b.close();
    }

    public void config(String txt){
        File archivo=new File("C:\\Users\\johan\\OneDrive\\Documentos\\NetBeansProjects\\TiendaDeVehiculos\\Config.ini");
        if (!archivo.exists()) {
            try {
            archivo.createNewFile();
            
        } catch (IOException e) {
            System.out.println("Error");
        
        }
        }else{
            try {
                FileWriter fw=new FileWriter(archivo, true);
                BufferedWriter bw=new BufferedWriter(fw);
                bw.write(txt);
                bw.close();
            } catch (IOException ex) {
                
            }
        }
    }
    
    public void buscarconfig(){
        File archivo=new File("C:\\Users\\johan\\OneDrive\\Documentos\\NetBeansProjects\\TiendaDeVehiculos\\Config.ini");
         if (!archivo.exists()) {
            try {
            archivo.createNewFile();
            
        } catch (IOException e) {
           
        
        }
        }else{
            try {
                FileReader fw=new FileReader(archivo);
                BufferedReader bw=new BufferedReader(fw);
                String linea;
                String [] datos;
                do{
                linea=bw.readLine();
                    if (linea!=null) {
                        datos=linea.split(" ");
                         if ("fndfg".equals(datos[1].trim())) {
                            System.out.println(datos[0].trim()+" "+ datos[1].trim()+" "+datos[2].trim());
                         }
                    }else{
                        System.out.println("no se encontro");
                    }
                }while (linea!=null);
                
                
                bw.close();
            } catch (IOException ex) {
                
            }
        }
    }
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Config cf=new Config();
        String txt="hola que hace";
        cf.config(txt);
        try {
            cf.muestraContenido("C:\\Users\\johan\\OneDrive\\Documentos\\NetBeansProjects\\TiendaDeVehiculos\\Config.ini");
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cf.buscarconfig();
        
    }
    
    
    
    
}
