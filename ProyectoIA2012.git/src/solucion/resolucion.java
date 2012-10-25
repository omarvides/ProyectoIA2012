/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package solucion;
import java.io.File;
import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.data.DataTreeBuilder;
import org.jgap.data.IDataCreators;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;
import org.jgap.impl.StringGene;
import org.jgap.xml.XMLDocumentBuilder;
import org.jgap.xml.XMLManager;
import org.w3c.dom.Document;
import structures.*;


/**
 *
 * @author Lyo
 */
public class resolucion {
    private static final int MAX_EVOLUCIONES_PERMITIDAS = 2200;
       public static String cadenaoptima ="";
       public static int posicioninicialx=0;
       public static int posicioninicialy=0;
       public static int posicionfinaly=0;
       public static int posicionfinalx=0;

    public static void setCadenaoptima(String cadenaoptima) {
        resolucion.cadenaoptima = cadenaoptima;
    }

    public static void setPosicioninicialx(int posicioninicialx) {
        resolucion.posicioninicialx = posicioninicialx;
    }

    public static void setPosicioninicialy(int posicioninicialy) {
        resolucion.posicioninicialy = posicioninicialy;
    }

    public static void setPosicionfinaly(int posicionfinaly) {
        resolucion.posicionfinaly = posicionfinaly;
    }

    public static void setPosicionfinalx(int posicionfinalx) {
        resolucion.posicionfinalx = posicionfinalx;
    }

    public static int getMAX_EVOLUCIONES_PERMITIDAS() {
        return MAX_EVOLUCIONES_PERMITIDAS;
    }

    public static String getCadenaoptima() {
        return cadenaoptima;
    }

    public static int getPosicioninicialx() {
        return posicioninicialx;
    }

    public static int getPosicioninicialy() {
        return posicioninicialy;
    }

    public static int getPosicionfinaly() {
        return posicionfinaly;
    }

    public static int getPosicionfinalx() {
        return posicionfinalx;
    }
       
       
       

    public static void calcularrutaoptima( )throws Exception {
            
		// Se crea una configuracion con valores predeterminados.
		// -------------------------------------------------------------
		Configuration conf = new DefaultConfiguration();
		// Se indica en la configuracion que el elemento mas apto siempre pase a
		// la proxima generacion
		// -------------------------------------------------------------
		conf.setPreservFittestIndividual(true);
		// Se Crea la funcion de aptitud y se setea en la configuracion
		// ---------------------------------------------------------
		FitnessFunction myFunc = new fitness();
		conf.setFitnessFunction(myFunc);
		// Ahora se debe indicar a la configuracion como seran los cromosomas: en
		// este caso tendran 8 genes (uno para cada tipo de moneda) con un valor
		// entero (cantidad de monedas de ese tipo).
		// Se debe crear un cromosoma de ejemplo y cargarlo en la configuracion
		// Cada gen tendra un valor maximo y minimo que debe setearse.
		// --------------------------------------------------------------
		Gene[] sampleGenes = new Gene[4];
                    sampleGenes[0]= new StringGene(conf, 0, 10, "SENO");
                
                
                
		IChromosome sampleChromosome = new Chromosome(conf, sampleGenes);
		conf.setSampleChromosome(sampleChromosome);
		// Por ultimo se debe indicar el tamaño de la poblacion en la
		// configuracion
		// ------------------------------------------------------------
		conf.setPopulationSize(1000);
		Genotype Poblacion;
		// El framework permite obtener la poblacion inicial de archivos xml
		// pero para este caso particular resulta mejor crear una poblacion
		// aleatoria, para ello se utiliza el metodo randomInitialGenotype que
		// devuelve la poblacion random creada
		Poblacion = Genotype.randomInitialGenotype(conf);
		// La Poblacion debe evolucionar para obtener resultados mas aptos
		// --------------------------   -------------------------------------
		//long TiempoComienzo = System.currentTimeMillis();
		for (int i = 0; i < MAX_EVOLUCIONES_PERMITIDAS; i++) {
			Poblacion.evolve();
                        System.out.println(i+":  "+Poblacion.getFittestChromosome());
		}
		//long TiempoFin = System.currentTimeMillis();
		//cadena+="Tiempo total de evolucion: " + (TiempoFin - TiempoComienzo) + " ms";		guardarPoblacion(Poblacion);
		// Una vez que la poblacion evoluciono es necesario obtener el cromosoma
		// mas apto para mostrarlo como solucion al problema planteado para ello
		// se utiliza el metodo getFittestChromosome
		IChromosome cromosomaMasApto = Poblacion.getFittestChromosome();
		//cadena+="\n"+ "El cromosoma mas apto encontrado tiene un valor de aptitud de: " + cromosomaMasApto.getFitnessValue();
		//cadena+="\n"+"Y esta formado por la siguiente distribucion de monedas: ";
//		cadena+="\n"+"\t"	+ CambioMinimoFuncionAptitud.getNumeroDeComendasDeGen(cromosomaMasApto, 0) + " Monedas de 1 dólar";
//                cadena+="\n"+"\t"	+ CambioMinimoFuncionAptitud.getNumeroDeComendasDeGen(cromosomaMasApto, 1) + " Monedas de 50 centavos";
//		cadena+="\n"+"\t"	+ CambioMinimoFuncionAptitud.getNumeroDeComendasDeGen(cromosomaMasApto, 2) + " Monedas de 25 centavos";
//		cadena+="\n"+"\t"	+ CambioMinimoFuncionAptitud.getNumeroDeComendasDeGen(cromosomaMasApto, 3) + " Monedas de 10 centavos";
//		cadena+="\n"+"\t"	+ CambioMinimoFuncionAptitud.getNumeroDeComendasDeGen(cromosomaMasApto, 4) + " Monedas de 5 centavos";
//		cadena+="\n"+"\t" + CambioMinimoFuncionAptitud.getNumeroDeComendasDeGen(cromosomaMasApto, 5) + " Monedas de 1 centavo";
//                cadena+="\n"+"Para un total de "+ CambioMinimoFuncionAptitud.montoCambioMoneda(cromosomaMasApto) + " centavos en " + CambioMinimoFuncionAptitud.getNumeroTotalMonedas(cromosomaMasApto) + " monedas.";
	}

    
    
}
