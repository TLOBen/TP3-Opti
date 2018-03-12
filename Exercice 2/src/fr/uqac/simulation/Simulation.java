package fr.uqac.simulation;

/**
 * La simulation avec les 3 voitures
 * 
 * @author Julien CUSSET, Benjamin DAGOURET
 */
public class Simulation {
    private Voiture voitureA;
    private Voiture voitureB;
    private Voiture voitureC;
    private int iterations;
    
    public Simulation(int iterations) {
        this.voitureA = new Voiture(210, 0.3);
        this.voitureB = new Voiture(205, 0.15);
        this.voitureC = new Voiture(200, 0.1);
        this.iterations = iterations;
    }
    
    public void simulate() {
        for (int i=0; i<this.iterations; i++) {
            resetVoituresResultat();
        }
    }
    
    public void resetVoituresResultat() {
        
    }
}
