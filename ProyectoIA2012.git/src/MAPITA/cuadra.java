/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MAPITA;

import java.util.ArrayList;

/**
 *
 * @author Lyo
 */
public class cuadra {

    ArrayList<obstaculo> obstaculos=new ArrayList();

    public ArrayList<obstaculo> getObstaculos() {
        return obstaculos;
    }

    public void setObstaculos(obstaculo obst) {
        obst.calculoCosto(obst.getTipo());
        this.obstaculos.add(obst);
    }
    String tipo;

    public cuadra(String tipo) {
        this.tipo = tipo;
    }
}
