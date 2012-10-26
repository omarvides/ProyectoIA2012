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
    double costo;
    int retardo; //Tiempo en que se tarda por el obstaculo.
    double gasolina;//Cantidad de gasolina consumida por el obstaculo.
    
    public void setRetardo(int ret)
    {
        this.retardo = ret;
    }
    
    public void setGasolina(double gas)
    {
        this.gasolina = gas;
    }
    
    public int getRetardo()
    {
        return retardo;
    }
    
    public double getGasolina()
    {
        return gasolina;
    }
    
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getTipo() {
        return tipo;
    }

    public double getCosto() {
        return costo;
    }
        
    
    public void calculoCosto(int tipo)
    {
        switch(tipo)
        {
            case 1: //Agujeros
                this.setGasolina(0.05);
                this.setRetardo(30);
                
            case 2://Comerciales
                this.setGasolina(0.03);
                this.setRetardo(10);
                break;    
             case 3://Escuelas
                 this.setGasolina(0.002);
                 this.setRetardo(15);
                break;
             case 4://Reductores
                 this.setGasolina(0.0001);
                 this.setRetardo(1);
                break;
             case 5://Semaforos
                 this.setGasolina(0.02);
                 this.setRetardo(10);
                 break;
              case 6://Objetos
                  this.setGasolina(0.005);
                  this.setRetardo(13);
                break;   
        }
         this.setCosto(getCosto()*getRetardo());
        
    }
    
}
