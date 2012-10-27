/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

import java.util.ArrayList;

/**
 *Este metodo contiene el arreglo de coordenadas para cada tipo de obstaculo
 * el obstaculo se identifica por el nombre en el string name, este arreglo
 * es recorrido para construir el mapa y su funcionamiento es validado
 * respecto a esta estructura.
 * @author Omar
 */
public class Item {

    String name;
    ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();

    public void addCoordinate(Coordinate newCoordinate) {
        this.coordinates.add(newCoordinate);
    }

    public ArrayList<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(ArrayList<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
