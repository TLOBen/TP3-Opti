package fr.uqac.simulation;

import fr.uqac.random.RNG;
import fr.uqac.struct.Client;
import java.util.ArrayList;

/**
 * La simulation avec les 3 voitures
 * 
 * @author Julien CUSSET, Benjamin DAGOURET
 */
public class Simulation {
    private final RNG rng;
    private final int heures;
    private final double moyenne;
    private ArrayList<Client> listeClients;
   
    public Simulation(int heures, double moyenne) {
        this.rng = new RNG();
        this.heures = heures;
        this.moyenne = moyenne;
        this.listeClients = new ArrayList();
    }
   
    public void simulate() {
        arriveeClients();
        serviceClients();
        afficherResultat();
    }
   
    public void arriveeClients() {
        double tempsArriveeDernier = 0;
       
        while (tempsArriveeDernier < 4) {
            tempsArriveeDernier += rng.Exp(moyenne);
           
            if (tempsArriveeDernier < 4) {
                Client client = new Client(tempsArriveeDernier);
                this.listeClients.add(client);
            }
        }
    }
    
    public void serviceClients() {
        double tempsAttenteTotal = 0.0;
        double tempsServiceAncienClient = 0.0;
        
        for (Client client : listeClients) {
            double randomNumber = rng.generateNumber();
            
            if (client.arrivee > tempsAttenteTotal) {
                tempsAttenteTotal = client.arrivee;
            }
            client.tempsAttente = tempsAttenteTotal - client.arrivee;
            
            if (randomNumber < 0.6) {
                client.tempsService = 3.0/60.0;
            } else if (randomNumber < 0.8) {
                client.tempsService = 4.0/60.0;
            } else if (randomNumber < 0.9) {
                client.tempsService = 5.0/60.0;
            } else {
                client.tempsService = 6.0/60.0;
            }
        
            tempsAttenteTotal += client.tempsService;
        }
    }
    
    public void afficherResultat() {
        double tempsMaxiamlAttente = 0;
        
        System.out.println("+-----------------+-----------------+------------------+");
        System.out.println("| Heure d'arrivee | Temps d'attente | temps de service |");
        System.out.println("+-----------------+-----------------+------------------+");
        
        for (Client client : listeClients) {
            if (client.tempsAttente > tempsMaxiamlAttente) {
                tempsMaxiamlAttente = client.tempsAttente;
            }
            
            int heureArrivee = (int) client.arrivee / 1;
            double minuteArrivee = (client.arrivee - heureArrivee) * 60;
            double minuteAttente = client.tempsAttente * 60;
            double minuteService = client.tempsService * 60;
            
            System.out.format("|           %02d:%02.0f |         %.1f min |            %.0f min |%n", heureArrivee, minuteArrivee, minuteAttente, minuteService);
        }
        
        System.out.println("+-----------------+-----------------+------------------+");
        System.out.println("Nombre de clients : " + listeClients.size());
        System.out.format("Temps d'attente maximal : %.1f min%n", tempsMaxiamlAttente*60);
    }
}