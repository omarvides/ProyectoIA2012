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
        calle=new cuadra("C");
        avenida=new cuadra("A");
        
    }
    String tipo;
    cuadra calle;
    cuadra avenida;
    Coordinate pos;
    public void setobstaculo(String tipocuadra, obstaculo obs){
        if(tipocuadra.equalsIgnoreCase("C")){
            calle.setObstaculos(obs);
            tipo = "C";
        }else{
            avenida.setObstaculos(obs);
            tipo = "A";
        }
    
    }
//        
//    public void setTipo(String t){
//        if (t.equals())
//    }
    public void setCalle(cuadra calle) {
        this.calle = calle;
    }

    public void setCalleariba(cuadra avenida) {
        this.avenida = avenida;
    }

    public void setPos(Coordinate pos) {
        this.pos = pos;
    }

    public cuadra getCalle() {
        return calle;
    }

    public cuadra getAvenida() {
        return avenida;
    }

    public Coordinate getPos() {
        return pos;
    }

    

    
}
