package fr.uqac.struct;

import java.util.HashMap;

/**
 *
 * @author Benjamin
 */
public class Course {
    public HashMap<String, Integer> resultatCourse;
    
    public Course() {
        this.resultatCourse = new HashMap();
    }
    
    public void addResultatCourse(String nomVoiture, int score) {
        this.resultatCourse.put(nomVoiture, score);
    }
}