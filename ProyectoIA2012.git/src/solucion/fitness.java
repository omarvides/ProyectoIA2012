/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package solucion;


import org.jgap.*;

/**
 *
 * @author Lyo
 */
public class fitness extends FitnessFunction{

    @Override
    protected double evaluate(IChromosome ic) {
        //throw new UnsupportedOperationException("Not supported yet.");
       
          System.err.println(ic.getGene(0).getAllele().toString());
          
        return 0;
        
        
    }
    
}
