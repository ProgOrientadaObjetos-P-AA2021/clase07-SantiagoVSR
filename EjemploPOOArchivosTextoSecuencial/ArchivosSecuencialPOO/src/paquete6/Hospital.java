package paquete6;

public class Hospital {
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
/* 
    Agregar valor de objetos de tipo Hospital a un archivo
    Y leer el archivo
*/
