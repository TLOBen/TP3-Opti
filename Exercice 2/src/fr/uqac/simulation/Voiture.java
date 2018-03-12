package fr.uqac.simulation;

/**
 * propriétés d'une voiture
 * 
 * @author Julien CUSSET, Benjamin DAGOURET
 */
public class Voiture {
    public int vitesse;
    public double panneProba;
    public int resultat;
    
    public Voiture(int vitesse, double panneProba) {
        this.vitesse = vitesse;
        this.panneProba = panneProba;
        resetResultat();
    }
    
    public void resetResultat() {
        this.resultat = 0;
    }
}