/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MAPITA;

import gui.FrontEnd;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import structures.Coordinate;

/**
 *
 * @author Lyo
 */
public class mapa {

    int manzanasver;
    int manzanashor;
    block mapa[][];
    String clima;
    automovil ferrari;

    
    public ArrayList<String[]> semaforos=new ArrayList();
    public ArrayList<String[]> agujeros=new ArrayList();

    public String getRutaoptima() {
        
        return rutaoptima;
    }
    
    public ArrayList<String[]> comerciales=new ArrayList();
    public ArrayList<String[]> escuelas=new ArrayList();
    public ArrayList<String[]> reductores=new ArrayList();
    public ArrayList<String[]> objetos=new ArrayList();
    public ArrayList <ArrayList> obstaculos=new ArrayList();
//sho si esta! vos dijiste linea 34 y esta en al 33 jajajaj esque no los ha'bía visto
    /* esq  mira ahi tengo  6 array list de string[]
     ahi esta x y C
     va y es ese array list de hasta abajo de ostaculos es donde meto lso array list */
    public mapa(int manzanashor, int manzanasver, automovil carro) {
        this.manzanashor = manzanashor;
        this.manzanasver = manzanasver;
        ferrari=carro;
        mapa = new block[manzanashor][manzanasver];
        try {
            // Abrimos el archivo
            System.out.println(FrontEnd.archivo.getPath());
            FileInputStream fstream = new FileInputStream(FrontEnd.archivo);

            // Creamos el objeto de entrada
            DataInputStream entrada = new DataInputStream(fstream);
            // Creamos el Buffer de Lectura
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            String strLinea;
            // Leer el archivo linea por linea
            while ((strLinea = buffer.readLine()) != null) {
                // Imprimimos la línea por pantalla
                //System.out.println(strLinea+"ssssssssssss");
                if (strLinea.equalsIgnoreCase("SEMAFOROS:")){

                        String cadena1 = buffer.readLine();
                        String semaforos[] = cadena1.split("/");
                        for (int i = 0; i < semaforos.length; i++) {
                            String sem[] = semaforos[i].replace("(", "").replace(")", "").split(",");
                            this.semaforos.add(sem);
                        }
                }else if (strLinea.equalsIgnoreCase("AGUJEROS:")){
                        String cadena2 = buffer.readLine();
                        String agujeros[] = cadena2.split("/");
                        for (int i = 0; i < agujeros.length; i++) {
                            String sem[] = agujeros[i].replace("(", "").replace(")", "").split(",");
                            this.agujeros.add(sem);
                        }
                 }else if (strLinea.equalsIgnoreCase("COMERCIALES:")){
                        String cadena3 = buffer.readLine();
                        String comerciales[] = cadena3.split("/");
                        for (int i = 0; i < comerciales.length; i++) {
                            String sem[] = comerciales[i].replace("(", "").replace(")", "").split(",");
                            this.comerciales.add(sem);
                        }
                 }else if (strLinea.equalsIgnoreCase("ESCUELAS:")){
                        String cadena4 = buffer.readLine();
                        String escuelas[] = cadena4.split("/");
                        for (int i = 0; i < escuelas.length; i++) {
                            String sem[] = escuelas[i].replace("(", "").replace(")", "").split(",");
                            this.escuelas.add(sem);
                        }
                 }else if (strLinea.equalsIgnoreCase("OBJETOS:")){
                        String cadena5 = buffer.readLine();
                        String objetos[] = cadena5.split("/");
                        for (int i = 0; i < objetos.length; i++) {
                            String sem[] = objetos[i].replace("(", "").replace(")", "").split(",");
                            this.objetos.add(sem);
                        }
                 }else if (strLinea.equalsIgnoreCase("REDUCTORES:")){
               
                        String cadena5 = buffer.readLine();
                        String reductores[] = cadena5.split("/");
                        for (int i = 0; i < reductores.length; i++) {
                            String sem[] = reductores[i].replace("(", "").replace(")", "").split(",");
                            this.reductores.add(sem);
                        }
                 }else{
                 }
                       
                }

            
            // Cerramos el archivo
            entrada.close();
        } catch (Exception e) { //Catch de excepciones
            System.err.println("Ocurrio un error: " + e.getMessage());
        }
obstaculos.add(agujeros);
obstaculos.add(comerciales);
obstaculos.add(escuelas);
obstaculos.add(reductores);
obstaculos.add(semaforos);
obstaculos.add(objetos);
/*aqui ve no se si te sirve si me sirve pero todo el mapa con todo y los obstaculos donde creas el mapa
 para podelro jalar en la ventana principal   
 
 emm pues aqui perame te muestro
 
 
 
 aqui abajo es ve es un mapa de blocks q los block son las manzanas a ya entonces voy a hacer un metodo getMapa para 
 poder jalarlo 
 si y ese llenar obstaculos de abajo llena las cuadras de obstaculosok
 nítido
 10-4 ELDiaQueNoParaMI
 
 hay le das pull q pablo acaba de ahcer un cambio
 ok*/

        for (int i = 0; i < manzanashor; i++) {
            for (int j = 0; j < manzanasver; j++) {
                mapa[i][j] = new block(new Coordinate(i, j));

            }
        }
        llenardeobstaculos();     
    }

    public block[][] getMapa(){
        return this.mapa;
    }
    
    public int getManzVertical(){
        return this.manzanasver;
    }
    
    public int getManzHorizontal(){
        return this.manzanashor;
    }
    
    private void llenardeobstaculos() {
        int tipo=0;
       for(int i=0;i<obstaculos.size();i++){
           tipo++;
           ArrayList <String[]> aux=new ArrayList();
           aux=obstaculos.get(i);
           for (int j=0;j<aux.size();j++){
                String  detalle[]=aux.get(j);
                obstaculo obs=new obstaculo(tipo);
                obs.calculoCosto(tipo);
                mapa[Integer.parseInt(detalle[0])-1][Integer.parseInt(detalle[1])-1].setobstaculo(detalle[2], obs);
                
           }
       }
//       tipo=1212;
    }
    public void setClima(String clima) {
        this.clima = clima;
    }


    public String getClima() {
        return clima;
    }
    
    public automovil getFerrari() {
        return ferrari;
    }

    public void setFerrari(automovil ferrari) {
        this.ferrari = ferrari;
    }
    
    public double recorermapa(String camino,Coordinate objetivo){
        int tam;
        double puntos=0;
        tam=camino.length();
        Coordinate resetpos=new  Coordinate(ferrari.posicion.getX(), ferrari.posicion.getY());
//       switch (tam){
//            case 1:
//                puntos=puntos+500;
//                break;
//            case 2:
//                puntos=puntos+480;
//                break;
//            case 3:             
//                puntos=puntos+460;
//                break;
//            case 4:             
//                puntos=puntos+440;
//                break;
//            case 5: 
//                puntos=puntos+420;
//                break;
//            case 6:    
//                puntos=puntos+400;
//                break;
//            
//            case 7:
//                puntos=puntos+380;
//                break;
//            
//            case 8:             
//                puntos=puntos+360;
//                break;
//            
//            case 9:             
//                puntos=puntos+340;
//                break;
//            
//            case 10: 
//                puntos=puntos+320;
//                break;
//            case 11:
//                puntos=puntos+300;
//                break;
//            
//                
//            case 12:
//                puntos=puntos+280;
//                break;
//            
//                
//            case 13:            
//                puntos=puntos+260;
//                break;
//            
//            case 14:            
//                puntos=puntos+240;
//                break;
//            
//            case 15: 
//                puntos=puntos+220;
//                break;
//            case 16:
//            case 17:
//            case 18:                
//            case 19:                
//            case 20: 
//                puntos=puntos+75;
//                break;
//            default :
//                puntos=puntos+0;
//       }
        puntos=puntos+(100000/((tam*tam)+1));
        
       for (int i=0;i<tam;i++){
        int carrox=ferrari.getPosicion().getX();
        int carroy=ferrari.getPosicion().getY();
            if(camino.charAt(i)=="N".charAt(0)){
                if(carroy+1<this.manzanasver){
                    if(caldculoPeso(ferrari.posicion.getX(), ferrari.posicion.getY()+1, "C")!=0)
                    {  
                        puntos=puntos-(10000*this.caldculoPeso(ferrari.posicion.getX(), ferrari.posicion.getY()+1, "C"));
                    }
                    ferrari.iralnorte();
                    
                }else{
                    i=tam;
                }
                
                if(((i-1)>=0)&&(i!=tam)){
                if ((camino.charAt(i)==camino.charAt(i-1))){
                    //puntos=puntos+200;
                }else if(camino.charAt(i-1)=="S".charAt(0)){
                    puntos=puntos-5000;
                }
                }         
            }else if(camino.charAt(i)=="S".charAt(0)){
                if(carroy-1>=0){
                    if(caldculoPeso(ferrari.posicion.getX(), ferrari.posicion.getY()-1, "C")!=0)
                    {  
                        puntos=puntos-(10000*this.caldculoPeso(ferrari.posicion.getX(), ferrari.posicion.getY()-1, "C"));
                    }
                    ferrari.iralsur();
                }else{
                    i=tam;
                }
                if(((i-1)>=0)&&(i!=tam)){
                if ((camino.charAt(i)==camino.charAt(i-1))){
                    //puntos=puntos+200;
                }else if(camino.charAt(i-1)=="N".charAt(0)){
                    puntos=puntos-5000;
                }
                }
            }else if(camino.charAt(i)=="E".charAt(0)){
                if(carrox+1<this.manzanashor){
                    if(caldculoPeso(ferrari.posicion.getX()+1, ferrari.posicion.getY(), "A")!=0)
                    {  
                        puntos=puntos-(10000*this.caldculoPeso(ferrari.posicion.getX()+1, ferrari.posicion.getY(), "A"));
                    }
                    ferrari.iraleste();
                    

                }else{
                    i=tam;
                }
                
                if(((i-1)>=0)&&(i!=tam)){
                if ((camino.charAt(i)==camino.charAt(i-1))){
                   // puntos=puntos+200;
                }else if(camino.charAt(i-1)=="O".charAt(0)){
                    puntos=puntos-5000;
                }
                }
            }else if(camino.charAt(i)=="O".charAt(0)){
                if(carrox-1>=0){
                    
                    if(caldculoPeso(ferrari.posicion.getX()-1, ferrari.posicion.getY(), "A")!=0)
                    {  
                        puntos=puntos-(10000*this.caldculoPeso(ferrari.posicion.getX()-1, ferrari.posicion.getY(), "A"));
                    }   
                    ferrari.iraloeste();
                    
                }else{
                    i=tam;
                }
                
                if(((i-1)>=0)&&(i!=tam)){
                if ((camino.charAt(i)==camino.charAt(i-1))){
                    //puntos=puntos+200;
                }else if(camino.charAt(i-1)=="E".charAt(0)){
                    puntos=puntos-5000;
                }
                }
            }
            }
        
        
        if((objetivo.getX()==ferrari.posicion.getX())&&(objetivo.getY()==ferrari.posicion.getY())){
            puntos=puntos+6000000;      
          //  System.out.println("si llego----------------------------------------------------------------------"+ camino);
        }else{
            puntos=0;
        }
        
        ferrari.setPosicion(resetpos);
        
        if(puntos <0){
        puntos=0;
        }
        
        return puntos;
    }
    
     public double caldculoPeso(int x, int y, String tipo)
    {
        double costo=0.00;
        ArrayList<obstaculo> aux_obstaculos;
        obstaculo aux_obstaculo;
        cuadra aux_cuadra;
        
        if (tipo.equals("C"))
        {
            aux_cuadra = mapa[x][y].getCalle();
        }
        else
        {
            aux_cuadra = mapa[x][y].getAvenida();
        }
        
        aux_obstaculos= aux_cuadra.getObstaculos();
        if (aux_obstaculos.size()!=0){
        for (int i =0; i<aux_obstaculos.size(); i++)
        {
            aux_obstaculo= aux_obstaculos.get(i);
            costo+=aux_obstaculo.getCosto();
        }}
     return costo;
    }
     String rutaoptima;
    public void setrutaoptima(String cadenaoptima) {
        rutaoptima=cadenaoptima;
    }

    public void llenarresultado() {
        //FrontEnd.Report.add(0);
        String camino=this.rutaoptima;
        int tam=camino.length();
        automovil ferrari=new automovil(new Coordinate(this.ferrari.getPosicion().getX(),this.ferrari.getPosicion().getY() ));
       for (int i=0;i<tam;i++){
        int carrox=ferrari.getPosicion().getX();
        int carroy=ferrari.getPosicion().getY();
            if(camino.charAt(i)=="N".charAt(0)){
                if(carroy+1<this.manzanasver){
                    if(caldculoPeso(ferrari.posicion.getX(), ferrari.posicion.getY()+1, "C")!=0)
                    {  
                        guardarobstaculo(ferrari.posicion.getX(), ferrari.posicion.getY()+1, "C");
                    }
                    ferrari.iralnorte();
                    
                }else{
                    i=tam;
                }
                
                        
            }else if(camino.charAt(i)=="S".charAt(0)){
                if(carroy-1>=0){
                    if(caldculoPeso(ferrari.posicion.getX(), ferrari.posicion.getY()-1, "C")!=0)
                    {  
                               guardarobstaculo(ferrari.posicion.getX(), ferrari.posicion.getY()-1, "C");
                               
                    }
                    ferrari.iralsur();
                }else{
                    i=tam;
                }
                
            }else if(camino.charAt(i)=="E".charAt(0)){
                if(carrox+1<this.manzanashor){
                    if(caldculoPeso(ferrari.posicion.getX()+1, ferrari.posicion.getY(), "A")!=0)
                    {  
                        guardarobstaculo(ferrari.posicion.getX()+1, ferrari.posicion.getY(), "A");
                    }
                    ferrari.iraleste();
                    

                }else{
                    i=tam;
                }
                
            }else if(camino.charAt(i)=="O".charAt(0)){
                if(carrox-1>=0){
                    
                    if(caldculoPeso(ferrari.posicion.getX()-1, ferrari.posicion.getY(), "A")!=0)
                    {  
                        guardarobstaculo(ferrari.posicion.getX()-1, ferrari.posicion.getY(), "A");
                    }   
                    ferrari.iraloeste();
                    
                }else{
                    i=tam;
                }
                
            }
            }
    }

    private void guardarobstaculo(int x, int y, String tipo) {
        double costo=0.00;
        ArrayList<obstaculo> aux_obstaculos;
        obstaculo aux_obstaculo;
        cuadra aux_cuadra;
        
        if (tipo.equals("C"))
        {
            aux_cuadra = mapa[x][y].getCalle();
        }
        else
        {
            aux_cuadra = mapa[x][y].getAvenida();
        }
        
        aux_obstaculos= aux_cuadra.getObstaculos();
        if (aux_obstaculos.size()!=0){
        for (int i =0; i<aux_obstaculos.size(); i++)
        {
            aux_obstaculo= aux_obstaculos.get(i);
            costo+=aux_obstaculo.getCosto();
            String c=aux_obstaculo.getTipoString()+"/"+x+","+y+"/"+ aux_obstaculo.getGasolina()+"/"+ aux_obstaculo.getRetardo();
           FrontEnd.Report.add(c.split("/"));
        }}
       
    }
}

