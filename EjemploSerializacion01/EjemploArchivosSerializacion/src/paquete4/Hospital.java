/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete4;

/**
 *
 * @author ASUS
 */
import java.io.Serializable;
public class Hospital implements Serializable{
    
    String nombre;
    int numeroCamas;
    double presupuesto;
    public Hospital(String n, int nc, double c){
        nombre = n;
        numeroCamas = nc;
        presupuesto= c;
    }

    
    public void establecerNombre(String n){
        nombre = n;
    }
    
    public void establecerCiudad(int nc){
        numeroCamas = nc;
    }
    
    public void establecerPresupuesto(double c){
        presupuesto=c;
    }
    
    public String obtenerNombre(){
        return nombre;
    }
    
    public int obtenerCiudad(){
        return numeroCamas;
    }
    
    public double obtenerPresupuesto(){
        return presupuesto;
    }
    
}
