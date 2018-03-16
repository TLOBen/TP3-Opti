package fr.uqac.simulation;

import fr.uqac.struct.Voiture;
import fr.uqac.random.RNG;
import fr.uqac.struct.ResultatFinal;
import fr.uqac.util.ResultFileWriter;
import java.util.ArrayList;

/**
 * La simulation avec les 3 voitures
 * 
 * @author Julien CUSSET, Benjamin DAGOURET
 */
public class Simulation {
    private ResultatFinal resultatFinal;
    private final int iterations;
    private ArrayList<Voiture> voitures;
    private RNG rng;
    
    public Simulation(int iterations) {
        this.iterations = iterations;
        this.voitures = new ArrayList();
        this.rng = new RNG();
    }
    
    public void simuler() {
        this.resultatFinal = new ResultatFinal(this.voitures);
        
        for (int i=0; i<this.iterations; i++) {
            this.resultatFinal.addResultatChampionnat();
        }
        
        ResultFileWriter fw = new ResultFileWriter();
        fw.makeFileResult(this.resultatFinal);
    }
    
    public void addVoiture(String name, int vitesse, double panneProba) {
        Voiture voiture = new Voiture(name, vitesse, panneProba);
        this.voitures.add(voiture);
    }
}