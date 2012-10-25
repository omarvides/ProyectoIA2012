/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MAPITA;

/**
 *
 * @author pablo
 */
public class Vehiculo {
     private float velocidad;
    
   private float gasolina;
    
    
    public void setVelocidad (float v)
    {
        velocidad = v;
    }
    
    public void setGasolina (float g)
    {
        gasolina=g;
    }
    
    
    public float getVelocidad()
    {
        return velocidad;
    }
    
    public float getGasolina()
    {
        return gasolina;
    }
}
