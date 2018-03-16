package fr.uqac.struct;

import fr.uqac.random.RNG;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Benjamin
 */
public class Championnat {
    public ArrayList<Voiture> voitures;
    public ArrayList<Course> resultatCourses;
    public HashMap<String, Integer> resultatChampionnat;
    
    public Championnat(ArrayList<Voiture> voitures) {
        this.voitures = voitures;
        this.resultatCourses = new ArrayList();
        this.resultatChampionnat = new HashMap();
        
        for (Voiture voiture : voitures) {
            this.resultatChampionnat.put(voiture.name, 0);
        }
    }
    
    public void faireChampionnat() {
        for (int i=0; i < 10; i++) {
            faireCourse();
        }
    }
    
    public void faireCourse() {
        RNG rng = new RNG();
        Course course = new Course();
        int nombrePannes = 0;
        int indexVoiture = 0;
        
        for (Voiture voiture : voitures) {
            String nomVoiture = voiture.name;
            int score = this.resultatChampionnat.get(voiture.name);
            
            if (rng.generateNumber() < voiture.panneProba) {
                nombrePannes++;
                course.addResultatCourse(nomVoiture, 0);
            }
            else {
                if (indexVoiture - nombrePannes == 0) {
                    course.addResultatCourse(nomVoiture, 10);
                    this.resultatChampionnat.put(nomVoiture, score+10);
                }
                if (indexVoiture - nombrePannes == 1) {
                    course.addResultatCourse(nomVoiture, 6);
                    this.resultatChampionnat.put(nomVoiture, score+6);
                }
                if (indexVoiture - nombrePannes == 2) {
                    course.addResultatCourse(nomVoiture, 4);
                    this.resultatChampionnat.put(nomVoiture, score+4);
                }
            }
            
            indexVoiture++;
        }

        this.resultatCourses.add(course);
    }
}