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
public class automovil {

    public automovil(Coordinate posicion) {
        this.posicion = posicion;
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
    
    double velocidadMax;
    double aceleracion;
    double potencia;
    double peso;
    double consumo;
    Coordinate posicion;
    
    
    
}
