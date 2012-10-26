/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package solucion;

import MAPITA.automovil;
import MAPITA.mapa;
import org.jgap.*;
import structures.Coordinate;

/**
 *
 * @author Lyo
 */
public class fitness extends FitnessFunction {
    mapa mapa;
    Coordinate inicial;
    automovil ferrari;
    Coordinate pfinal;
    public fitness(mapa m, Coordinate fin) {
        mapa=m;
        
        pfinal=fin; 
    }

    @Override
    protected double evaluate(IChromosome ic) {
        //throw new UnsupportedOperationException("Not supported yet.");

      //  System.err.println(ic.getGene(0).getAllele().toString());
       return  mapa.recorermapa(ic.getGene(0).getAllele().toString(), pfinal);
        
        
        
      //  return 0;


    }
}
