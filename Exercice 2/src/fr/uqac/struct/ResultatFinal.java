package fr.uqac.struct;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Benjamin
 */
public class ResultatFinal {
    public ArrayList<Voiture> voitures;
    public ArrayList<Championnat> resultatChampionnats;
    public HashMap<String, Podium> podiums;
    
    public ResultatFinal(ArrayList<Voiture> voitures) {
        this.voitures = voitures;
        this.resultatChampionnats = new ArrayList();
        this.podiums = new HashMap();
        
        for (Voiture voiture : voitures) {
            this.podiums.put(voiture.name, new Podium());
        }
    }
    
    public void addResultatChampionnat() {
        Championnat championnat = new Championnat(voitures);
        championnat.faireChampionnat();
        ArrayList<String> classementChampionnat = faireClassement(championnat.resultatChampionnat);
        
        for (int i=0; i < classementChampionnat.size(); i++) {
            String nomVoiture = classementChampionnat.get(i);
            
            switch (i) {
                case 0:
                    this.podiums.get(nomVoiture).incPremier();
                    break;
                case 1:
                    this.podiums.get(nomVoiture).incDeuxieme();
                    break;
                case 2:
                    this.podiums.get(nomVoiture).incTroisieme();
                    break;
            }
        }
        
        this.resultatChampionnats.add(championnat);
    }
    
    private String scoreMax(HashMap<String, Integer> resultatChampionnat) {
        String nom = "";
        int score = -1;
        
        for (String nomVoiture : resultatChampionnat.keySet()) {
            if (resultatChampionnat.get(nomVoiture) > score) {
                score = resultatChampionnat.get(nomVoiture);
                nom = nomVoiture;
            }
        }
        
        return nom;
    }
    
    public ArrayList<String> faireClassement(HashMap<String, Integer> resultatChampionnat) {
        ArrayList<String> classement = new ArrayList();
        HashMap<String, Integer> temp = (HashMap) resultatChampionnat.clone();
        
        String premier = scoreMax(temp);
        temp.remove(premier);
        classement.add(premier);
        
        String deuxieme = scoreMax(temp);
        temp.remove(deuxieme);
        classement.add(deuxieme);
        
        String troisieme = scoreMax(temp);
        temp.remove(troisieme);
        classement.add(troisieme);
        
        return classement;
    }
    
    public void display() {
        for (String nomVoitures : podiums.keySet()) {
            System.out.println("Voiture " + nomVoitures);
            System.out.println(podiums.get(nomVoitures).premier);
            System.out.println(podiums.get(nomVoitures).deuxieme);
            System.out.println(podiums.get(nomVoitures).troisieme);
        }
    }
}