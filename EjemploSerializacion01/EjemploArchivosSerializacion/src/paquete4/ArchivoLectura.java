/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete4;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.EOFException;

import java.util.ArrayList;


public class ArchivoLectura {

    private ObjectInputStream entrada;
    private String nombreArchivo;
    private ArrayList<Hospital> lista;

    public ArchivoLectura(String n) {
        nombreArchivo = n;
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            try {
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            } // fin de try
            catch (IOException ioException) {
                System.err.println("Error al abrir el archivo: " + ioException);

            } // fin de catch
        }
    }
    
       
    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    // establecer valores de cada línea
    // en la lista de tipo Profesor
    public void establecerLista() {
        lista = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        
       if (f.exists()) {
        
            while (true) {
                try {
                    Hospital registro = (Hospital) entrada.readObject();
                    lista.add(registro);
                } catch (EOFException endOfFileException) {
                    return; // se llegó al fin del archivo
                    // System.err.println("Fin de archivo: " + endOfFileException);

                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    System.err.println("No hay datos en el archivo: " + ex);

                }
            }// fin de while
       }
    }

    public ArrayList<Hospital> obtenerLista() {
        
        return lista;
    }

    public void cerrarArchivo() {
        try // cierra el archivo y sale
        {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        } // fin de
    }

    @Override
    public String toString(){
        String cadena = "El Hospital\n";
        for (int i = 0; i < obtenerLista().size(); i++) {
            cadena = String.format("%s(%d) El %s tiene un total de %s camas y"
                    + " un presupuesto de %s\n", cadena,
                    i+1,
                    obtenerLista().get(i).obtenerNombre(),
                    obtenerLista().get(i).obtenerCiudad(),
                    obtenerLista().get(i).obtenerPresupuesto());
        }
        return cadena;
    }
}
