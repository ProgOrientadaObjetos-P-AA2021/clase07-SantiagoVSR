/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete4;

// Uso de la clase Formatter para escribir datos en un archivo de texto.

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



public class ArchivoEscritura {

    private String nombreArchivo;
    private ArrayList<Hospital> listaHospital;
    private Hospital registro;
    private ObjectOutputStream salidaArchivo;

    public ArchivoEscritura(String nameA) {
        nombreArchivo = nameA;
        establecerListaHospital();
        try // abre el archivo
        {
            salidaArchivo = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            // proceso para ingresar nuevamente los valores del archivo
            if (obtenerListaHospital().size() > 0) {
                for (int i = 0; i < obtenerListaHospital().size(); i++) {
                    establecerRegistro(obtenerListaHospital().get(i));
                    establecerSalida();
                }
            }
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        } // fin de catch
    }
    
    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    
    public void establecerRegistro(Hospital n) {
        registro = n;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }


    public Hospital obtenerRegistro() {
        return registro;
    }
    
    public void establecerListaHospital() {
        ArchivoLectura l = new ArchivoLectura(obtenerNombreArchivo());
        l.establecerLista();
        listaHospital = l.obtenerLista();
    }
    
    public ArrayList<Hospital> obtenerListaHospital() {
        return listaHospital;
    }

    // agrega registros al archivo
    public void establecerSalida() {
        try {
            salidaArchivo.writeObject(registro); // envía el registro como 
                                                  // objeto al archivo
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void cerrarArchivo() {
        try // cierra el archivo
        {
            if (salidaArchivo != null) {
                salidaArchivo.close();
            }
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            
        } // fin de catch
    }

}
