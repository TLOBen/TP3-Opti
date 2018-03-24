package fr.uqac.random;

import static java.lang.Math.log;
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
        this.rng.setSeed(System.nanoTime());
    }
    
    public double generateNumber() {
        return this.rng.nextDouble();
    }
    
    public double Exp(double lambda) {
        return -(1 / lambda) * log(1 - generateNumber());
    }
}