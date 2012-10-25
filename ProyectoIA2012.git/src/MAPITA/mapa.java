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
    ArrayList <String[]> obstaculos;
    
     
    public mapa(int manzanasver, int manzanashor) {
        this.manzanasver = manzanasver;
        this.manzanashor = manzanashor;
        
        mapa=new block[manzanashor][manzanasver];
          try{
            // Abrimos el archivo
            FileInputStream fstream = new FileInputStream(FrontEnd.archivo);
        
            // Creamos el objeto de entrada
            DataInputStream entrada = new DataInputStream(fstream);
            // Creamos el Buffer de Lectura
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            String strLinea;
            // Leer el archivo linea por linea
            while ((strLinea = buffer.readLine()) != null)   {
                // Imprimimos la línea por pantalla
                System.out.println (strLinea);
            }
            // Cerramos el archivo
            entrada.close();
        }catch (Exception e){ //Catch de excepciones
            System.err.println("Ocurrio un error: " + e.getMessage());
        }
        
        
        
        for (int i=0;i<manzanashor;i++){
            for(int j=0;j<manzanasver;j++){
                mapa[i][j]=new block(new Coordinate(i,j));
                
            }           
        }
    }
    
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
}
