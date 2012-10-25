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
    }
    cuadra calleiz;
    cuadra calleder;
    Coordinate pos;

    public cuadra getCalleiz() {
        return calleiz;
    }

    public cuadra getCalleder() {
        return calleder;
    }

    public void setCalleiz(cuadra calleiz) {
        this.calleiz = calleiz;
    }

    public void setCalleder(cuadra calleder) {
        this.calleder = calleder;
    }
}
