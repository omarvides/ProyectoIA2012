/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package solucion;

import MAPITA.automovil;
import MAPITA.mapa;
import gui.FrontEnd;
import gui.avance;
import java.util.logging.Level;
import java.util.logging.Logger;
import structures.Coordinate;

/**
 *
 * @author Lyo
 */
public class ejecucion extends Thread{
    
    
    
    public void run(){
                
                automovil ferrari=new automovil(new Coordinate(3,2));
                mapa m1=new mapa(13,10,ferrari);
                Coordinate inicial =new Coordinate(1,2);
                Coordinate pfinal =new Coordinate(9,9);
                resolucion res=new resolucion();
                try {
                    res.calcularrutaoptima(m1, pfinal);
                } catch (Exception ex) {
                    Logger.getLogger(FrontEnd.class.getName()).log(Level.SEVERE, null, ex);
                }
}
}
