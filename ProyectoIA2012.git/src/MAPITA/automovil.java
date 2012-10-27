/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MAPITA;

import gui.FrontEnd;
import structures.Coordinate;

/**
 *
 * @author Lyo
 */
public class automovil {
    double velocidadMax;
    double aceleracion;
    double potencia;
    double consumo;
    Coordinate posicion;
    
    public automovil(Coordinate posicion) {
        this.posicion = posicion;
        this.aceleracion=FrontEnd.acc;
        this.consumo=FrontEnd.consumoGas;
        this.velocidadMax=FrontEnd.maxVel;
        this.potencia=FrontEnd.potencia;
                
        
    }

    public Coordinate getPosicion() {
        return posicion;
    }

    public void setPosicion(Coordinate posicion) {
        this.posicion = posicion;
    }
    public void iralnorte(){
        posicion.setY(posicion.getY()+1);
    }
    public void iralsur(){
        posicion.setY(posicion.getY()-1);
    }
    public void iraleste(){
        posicion.setX(posicion.getX()+1);
    }
    public void iraloeste(){
        posicion.setX(posicion.getX()-1);
    }
    
    
    
    
}
