package fr.uqac.main;

import fr.uqac.simulation.Simulation;

/**
 * Main class
 * 
 * @author Julien CUSSET, Benjamin DAGOURET
 */
public class Main {
    /**
     * @param args Arguments données en ligne de commande
     */
    public static void main(String[] args) {
        Simulation simulation = new Simulation(1000);
        simulation.addVoiture("A", 210, 0.3);
        simulation.addVoiture("B", 205, 0.15);
        simulation.addVoiture("C", 200, 0.1);
        simulation.simuler();
    }
}