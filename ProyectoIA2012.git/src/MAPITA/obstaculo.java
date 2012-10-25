/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MAPITA;

/**
 *
 * @author Lyo
 */
public class obstaculo {

    public obstaculo(int tipo) {
        this.tipo = tipo;
    }

    int tipo;
    int costo;

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getTipo() {
        return tipo;
    }

    public int getCosto() {
        return costo;
    }
}
