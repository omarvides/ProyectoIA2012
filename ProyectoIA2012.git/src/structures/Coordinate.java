/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

/**
 *Estructura que sirve para las validaciones de coordenadas esta contendra una coordenada
 * en X y una en Y asi como la orientacion de si sera calle o avenida
 * @author Omar
 */
public class Coordinate {

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    int x;
    int y;
    String letter;

    public Coordinate() {
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
