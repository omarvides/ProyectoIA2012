/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package solucion;

import MAPITA.mapa;
import gui.FrontEnd;
import gui.avance;
import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.StringGene;
import structures.*;

/**
 *
 * @author Lyo
 */
public class resolucion {

    private static final int MAX_EVOLUCIONES_PERMITIDAS = Integer.parseInt(FrontEnd.evoluciones.getValue().toString());
    public static String cadenaoptima = "";
    public static int posicioninicialx = 0;
    public static int posicioninicialy = 0;
    public static int posicionfinaly = 0;
    public static int posicionfinalx = 0;

    public static void setCadenaoptima(String cadenaoptima) {
        resolucion.cadenaoptima = cadenaoptima;
    }


    public void calcularrutaoptima(mapa m, Coordinate pfinal) throws Exception {

        // Se crea una configuracion con valores predeterminados.
        // -------------------------------------------------------------
        Configuration conf = new DefaultConfiguration();
        // Se indica en la configuracion que el elemento mas apto siempre pase a
        // la proxima generacion
        // -------------------------------------------------------------
        conf.setPreservFittestIndividual(true);
        // Se Crea la funcion de aptitud y se setea en la configuracion
        // ---------------------------------------------------------
        FitnessFunction myFunc = new fitness( m, pfinal);
        conf.setFitnessFunction(myFunc);
        // Ahora se debe indicar a la configuracion como seran los cromosomas: en
        // este caso tendran 8 genes (uno para cada tipo de moneda) con un valor
        // entero (cantidad de monedas de ese tipo).
        // Se debe crear un cromosoma de ejemplo y cargarlo en la configuracion
        // Cada gen tendra un valor maximo y minimo que debe setearse.
        // --------------------------------------------------------------
        Gene[] sampleGenes = new Gene[1];
        sampleGenes[0] = new StringGene(conf, 0, 20, "SENO");


        IChromosome sampleChromosome = new Chromosome(conf, sampleGenes);
        conf.setSampleChromosome(sampleChromosome);
        // Por ultimo se debe indicar el tamaño de la poblacion en la
        // configuracion
        // ------------------------------------------------------------
        conf.setPopulationSize(Integer.parseInt(FrontEnd.poblacion.getValue().toString()));
        Genotype Poblacion;
        // El framework permite obtener la poblacion inicial de archivos xml
        // pero para este caso particular resulta mejor crear una poblacion
        // aleatoria, para ello se utiliza el metodo randomInitialGenotype que
        // devuelve la poblacion random creada
        Poblacion = Genotype.randomInitialGenotype(conf);
        // La Poblacion debe evolucionar para obtener resultados mas aptos
        // --------------------------   -------------------------------------
        long TiempoComienzo = System.currentTimeMillis();
        avance.jProgressBar1.setMaximum(MAX_EVOLUCIONES_PERMITIDAS-1);
            avance.jProgressBar1.setMinimum(0);
            
        for (int i = 0; i < MAX_EVOLUCIONES_PERMITIDAS; i++) {
            Poblacion.evolve();
            System.out.println(i + ":  " + Poblacion.getFittestChromosome());
            //System.out.println(""+ new Double( ((Double.parseDouble(""+i) /Double.parseDouble(""+MAX_EVOLUCIONES_PERMITIDAS))*100)).shortValue()+"%");
            //System.out.println(" "+i);
            avance.jProgressBar1.setValue(i);
            
        }
        long TiempoFin = System.currentTimeMillis();
        System.err.println(        "Tiempo total de evolucion: " + (TiempoFin - TiempoComienzo) + " ms");
        //guardarPoblacion(Poblacion);
        // Una vez que la poblacion evoluciono es necesario obtener el cromosoma
        // mas apto para mostrarlo como solucion al problema planteado para ello
        // se utiliza el metodo getFittestChromosome
         cromosomaMasApto = Poblacion.getFittestChromosome();
        System.out.println(cromosomaMasApto.getGene(0).getAllele().toString());
     this.cadenaoptima=cromosomaMasApto.getGene(0).getAllele().toString();
     m.setrutaoptima(cadenaoptima);
     m.llenarresultado();
     boolean x=FrontEnd.Report.isEmpty();
     FrontEnd.av.setVisible(false);
    }
     public static IChromosome cromosomaMasApto;
}
