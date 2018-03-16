/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.uqac.util;

import fr.uqac.struct.Championnat;
import fr.uqac.struct.Course;
import fr.uqac.struct.Podium;
import fr.uqac.struct.ResultatFinal;
import fr.uqac.struct.Voiture;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Benjamin
 */
public class ResultFileWriter {
    /**
     * Créée un texte contenant les résultats à écrire dans le fichier
     * 
     * @param result Les résultats
     * @param makespan Le makespan
     * @return Une chaîne de caractères
     */
    public String createStringResult(ResultatFinal resultat) {
        String resultString = new String();
        
        resultString = resultString + "    +-----+------+------+\n";
        resultString = resultString + "    | 1er | 2ème | 3ème |\n";
        resultString = resultString + "+---+-----+------+------+\n";
        
        for (String nomVoiture : resultat.podiums.keySet()) {
            Podium podium = resultat.podiums.get(nomVoiture);
            resultString = resultString + String.format("| " + nomVoiture + " | %3d | %4d | %4d |%n", podium.premier, podium.deuxieme, podium.troisieme);
            resultString = resultString + "+---+-----+------+------+\n";
        }
        
        resultString = resultString + "\n\n\n\n\n";
        
        for (Championnat championnat : resultat.resultatChampionnats) {
            resultString = resultString + "    +----+----+----+----+----+----+----+----+----+----+-------+\n";
            resultString = resultString + "    |  1 |  2 |  3 |  4 |  5 |  6 |  7 |  8 |  9 | 10 | Total |\n";
            resultString = resultString + "+---+----+----+----+----+----+----+----+----+----+----+-------+\n";
            
            for (Voiture voiture : resultat.voitures) {
                int total = 0;
                String nomVoiture = voiture.name;
                
                resultString = resultString + "| " + nomVoiture + " |";

                for (Course course : championnat.resultatCourses) {
                    total += course.resultatCourse.get(nomVoiture);
                    resultString = resultString + String.format(" %2d |", course.resultatCourse.get(nomVoiture));
                }
                resultString = resultString + String.format(" %5d |", total);
                resultString = resultString + "\n+---+----+----+----+----+----+----+----+----+----+----+-------+\n";
            }
            
            resultString = resultString + "\n\n";
        }
        
        return resultString;
    }
    
    /**
     * Créée un fichier avec la liste des jobs ordonnancés et le makespan
     * 
     * @param result L'ordonnancement des jobs
     * @param makespan Le temps de réalisation des jobs
     */
    public void makeFileResult(ResultatFinal resultat) {
        try {
            String resultString = createStringResult(resultat);
            
            File resultFile = new File("result.txt");
            resultFile.createNewFile();
            
            FileWriter fw = new FileWriter("result.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.printf(resultString);
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(ResultFileWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}