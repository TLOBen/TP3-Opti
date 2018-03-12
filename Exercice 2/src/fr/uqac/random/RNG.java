package fr.uqac.random;

import java.util.Random;

/**
 * Générateur de nombre aléatoires
 * 
 * @author Julien CUSSET, Benjamin DAGOURET
 */
public class RNG {
    private Random rng;
    
    public RNG() {
        this.rng = new Random();
        this.rng.setSeed(System.currentTimeMillis());
    }
    
    private double generateNumber() {
        return this.rng.nextDouble();
    }
}