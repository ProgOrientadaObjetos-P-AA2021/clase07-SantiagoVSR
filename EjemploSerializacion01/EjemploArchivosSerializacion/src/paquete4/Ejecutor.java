/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete4;

public class Ejecutor {

    public static void main(String[] args) {

        // nombre del archivo
        String nombreArchivo = "hospitales.txt";
        
        Hospital h1 = new Hospital("Hospital Luis Vernaza", 100, 150.50);
        Hospital h2 = new Hospital ("Hospital Isidro Ayora", 67,857.6);
        Hospital h3 = new Hospital ("Hospital Eugenio Espejo", 56,756.4);

        Hospital[] lista = {h1, h2,h3 };

        ArchivoEscritura escritura = new ArchivoEscritura(nombreArchivo);
        // establecer el valor del atributo registro
        for (int i = 0; i < lista.length; i++) {
            // establecer el valor del atributo registro
            escritura.establecerRegistro(lista[i]);
            // estabalecer en el archivo el atributo del registro
            escritura.establecerSalida(); 
        }
        
        escritura.cerrarArchivo();
        
        // proceso para lectura del archivo
        ArchivoLectura lectura = new ArchivoLectura(nombreArchivo);
        lectura.establecerLista();
        // System.out.println(lectura.toString());
        System.out.println(lectura);

    }
}
