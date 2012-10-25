/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MAPITA;

import gui.FrontEnd;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import structures.Coordinate;

/**
 *
 * @author Lyo
 */
public class mapa {

    int manzanasver;
    int manzanashor;
    block mapa[][];
    ArrayList<String[]> semaforos;
    ArrayList<String[]> agujeros;
    ArrayList<String[]> comerciales;
    ArrayList<String[]> escuelas;
    ArrayList<String[]> reductores;

    public mapa(int manzanasver, int manzanashor) {
        this.manzanasver = manzanasver;
        this.manzanashor = manzanashor;

        mapa = new block[manzanashor][manzanasver];
        try {
            // Abrimos el archivo
            FileInputStream fstream = new FileInputStream(FrontEnd.archivo);

            // Creamos el objeto de entrada
            DataInputStream entrada = new DataInputStream(fstream);
            // Creamos el Buffer de Lectura
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            String strLinea;
            // Leer el archivo linea por linea
            while ((strLinea = buffer.readLine()) != null) {
                // Imprimimos la línea por pantalla
                System.out.println(strLinea);
                if (strLinea.equalsIgnoreCase("SEMAFOROS")){

                        String cadena1 = buffer.readLine();
                        String semaforos[] = cadena1.split("/");
                        for (int i = 0; i < semaforos.length; i++) {
                            String sem[] = semaforos[i].split(",");
                            this.semaforos.add(sem);
                        }
                }else if (strLinea.equalsIgnoreCase("AGUJEROS")){
                        String cadena2 = buffer.readLine();
                        String agujeros[] = cadena2.split("/");
                        for (int i = 0; i < agujeros.length; i++) {
                            String sem[] = agujeros[i].split(",");
                            this.agujeros.add(sem);
                        }
                 }else if (strLinea.equalsIgnoreCase("COMERCIALES")){
                        String cadena3 = buffer.readLine();
                        String comerciales[] = cadena3.split("/");
                        for (int i = 0; i < comerciales.length; i++) {
                            String sem[] = comerciales[i].split(",");
                            this.comerciales.add(sem);
                        }
                 }else if (strLinea.equalsIgnoreCase("ESCUELAS")){
                        String cadena4 = buffer.readLine();
                        String escuelas[] = cadena4.split("/");
                        for (int i = 0; i < escuelas.length; i++) {
                            String sem[] = escuelas[i].split(",");
                            this.escuelas.add(sem);
                        }
                 }else if (strLinea.equalsIgnoreCase("REDUCTORES")){
               
                        String cadena5 = buffer.readLine();
                        String reductores[] = cadena5.split("/");
                        for (int i = 0; i < reductores.length; i++) {
                            String sem[] = reductores[i].split(",");
                            this.reductores.add(sem);
                        }
                 }else{
                 }
                       
                }

            
            // Cerramos el archivo
            entrada.close();
        } catch (Exception e) { //Catch de excepciones
            System.err.println("Ocurrio un error: " + e.getMessage());
        }



        for (int i = 0; i < manzanashor; i++) {
            for (int j = 0; j < manzanasver; j++) {
                mapa[i][j] = new block(new Coordinate(i, j));

            }
        }
    }
}
