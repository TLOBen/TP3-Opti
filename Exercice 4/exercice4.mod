/*********************************************
 * OPL 12.8.0.0 Model
 * Author: Julien CUSSET, Benjamin DAGOURET
 * Creation Date: 27 mars 2018 at 18:34:40
 *********************************************/

using CP;
 
 // parametres
 int nbFournisseurs = ...;
 int nbClients = ...;
 float cout[1 .. nbClients, 1 .. nbFournisseurs] = ...;
 
 int capacite[1 .. nbFournisseurs] = ...;
 int demande[1 .. nbClients] = ...;
 int preference[1 .. nbClients, 1 .. nbFournisseurs] = ...;
 
 string Fournisseurs[1 .. nbFournisseurs] = ...;
 string Clients[1 .. nbClients] = ...;
 
 //variables de decision
 dvar int demandeFournie[1 .. nbClients, 1 .. nbFournisseurs] in 0 .. 1;
 
 // objectif
 //minimize sum(c in 1 .. nbClients) sum(f in 1 .. nbFournisseurs) cout[c, f] * demandeFournie[c, f] * demande[c];
 maximize ((sum(c in 1 .. nbClients) sum(f in 1 .. nbFournisseurs) demandeFournie[c, f] * preference[c, f]) * sum(c in 1 .. nbClients) demande[c]) 
 			- (sum(c in 1 .. nbClients) sum(f in 1 .. nbFournisseurs) cout[c, f] * demandeFournie[c, f] * demande[c]);
 
 // contraintes
 subject to{
 	// chaque client est servi par un et un seul fournisseur
 	forall(c in 1 .. nbClients) {
  		sum(f in 1 .. nbFournisseurs) demandeFournie[c, f] == 1;
 	}
 	
 	// chaque fournisseur f dispose de capacite[f] tonnes pour le mois
 	forall(f in 1 .. nbFournisseurs){
 		sum(c in 1 .. nbClients) (demandeFournie[c, f] * demande[c]) <= capacite[f]; 	
 	}
 }
 
 // Affichage
 execute{ 
 	for(var c = 1; c <= nbClients; c++){
 		for(var f = 1; f <= nbFournisseurs; f++){
 			if(demandeFournie[c][f] != 0){
 			 	writeln(Clients[c] + " recoit " + demande[c] + " de " + Fournisseurs[f]);	
 			} 		
 		} 	
 	}
}  
 
  