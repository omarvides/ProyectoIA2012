/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MAPITA;

import structures.Coordinate;

/**
 *
 * @author Lyo
 */
public class block {

    public block(Coordinate pos) {
        this.pos = pos;
        calleizq=new cuadra("C");
        calleariba=new cuadra("A");
    }
    cuadra calleizq;
    cuadra calleariba;
    Coordinate pos;
    public void setobstaculo(String tipocuadra, obstaculo obs){
        if(tipocuadra.equalsIgnoreCase("C")){
            calleizq.setObstaculos(obs);
        }else{
            calleariba.setObstaculos(obs);
        }
    
    }
        
    public void setCalleizq(cuadra calleizq) {
        this.calleizq = calleizq;
    }

    public void setCalleariba(cuadra calleariba) {
        this.calleariba = calleariba;
    }

    public void setPos(Coordinate pos) {
        this.pos = pos;
    }

    public cuadra getCalleizq() {
        return calleizq;
    }

    public cuadra getCalleariba() {
        return calleariba;
    }

    public Coordinate getPos() {
        return pos;
    }

    

    
}
