package fr.uqac.struct;

/**
 * propriétés d'une voiture
 * 
 * @author Julien CUSSET, Benjamin DAGOURET
 */
public class Voiture {
    public final String name;
    public final int vitesse;
    public final double panneProba;
    
    public Voiture(String name, int vitesse, double panneProba) {
        this.name = name;
        this.vitesse = vitesse;
        this.panneProba = panneProba;
    }
}