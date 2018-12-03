

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import java.util.ArrayList;
import java.util.List;

/*
 * Programme pour suivre les élections du Québec en 2018
 * 
 * @author Pierre Bélisle
 * @version Copyright A2018
 * 
 * @revision Daniel Colalillo
 */
public class DemarrerElection2018Etud {

	public static void main(String[] args) {
		
		String[] tabMenuPremierFois = {"Ouvrir fichier texte", 
				                       "Ouvrir fichier binaire"};
		
		
		preparerPourMac();
		
		/*
		 * Les données sont chargées en mémoire.
		 */
		Election election = new Election(Constantes.ANNEE_ELECTION);
		
		String str = (String) JOptionPane.showInputDialog(null, 
				                    "Sélectionnez le type de fichier", 
				                    "Type de fichier (texte ou binaire?)", 
				                    0, null, tabMenuPremierFois, 0);
		
		/*
		 * 
		 * À exécuter la première fois.
		 * 
		 */				
		if(str.equals(tabMenuPremierFois[0])) {
			
			ModuleFichier.getElection(election);
			election.genererIndex();
			ModuleFichier.sauverFichierBinaire(election);
		}		
		/* A éxécuter seulement après que le fichier texte a été  ouvert
		 * et sauvegarder en binaire.
		 */
		else {
			
			election = ModuleFichier.getElectionBinaire();
		}
		
		ModuleFichier.genererPartis(election);
		
		ModuleFichier.genererSupporteurs(election);
		
		//String options = null;
		
		/*
		List<String> choix = new ArrayList<String>();
		
		String [] tabChoix = new String [election.partiCollection.size()];
		
		for(int i = 0; i < election.partiCollection.size(); i++){
			
			choix.add(election.partiCollection.get(i).toString());
		}
		
		choix.toArray(tabChoix);
		*/
		
		//TEST
		String [] tabChoix = new String [election.nomsCirconscriptionCollection.size()];
		
		tabChoix = election.nomsCirconscriptionCollection.toArray(tabChoix);
		
		while(true){
			String input = (String) JOptionPane.showInputDialog(null, "choisi circonscription",
			        "choisi circonscription", JOptionPane.QUESTION_MESSAGE, null, 
			        tabChoix, // Array of choices
			        tabChoix[0]); // Initial choice
			
			String[] nomsPartiParCirc = election.obtenirNomsPartisParCirconscrition(input);
			String[] nomsDeputeParCirc = election.obtenirNomsDeputesParCirconscription(input, nomsPartiParCirc);
			
			JOptionPane.showMessageDialog(null, nomsPartiParCirc, "Noms Des Partis De La Circonscription", 0);
			
			JOptionPane.showMessageDialog(null, nomsDeputeParCirc, "Noms Des Deputes De La Circonscription", 0);
			
		/*
		 	String input = (String) JOptionPane.showInputDialog(null, "choisi parti",
			        "choisi parti", JOptionPane.QUESTION_MESSAGE, null, 
			        tabChoix, // Array of choices
			        tabChoix[0]); // Initial choice
		
		 	int index = choix.indexOf(input);
		 
		 	if(election.partiCollection.get(index).getCategorie().equals("Parti de gauche") ){
			   
			 	obtenirSup((PartiDeGauche)election.partiCollection.get(index));
		 	}
		 	else if(election.partiCollection.get(index).getCategorie().equals("Parti du centre")){
			   
			 	obtenirSup((PartiDuCentre)election.partiCollection.get(index));
		 	}
		 	else obtenirSup((PartiDeDroite)election.partiCollection.get(index));
		*/
		}
	
	}
	public static void obtenirSup(PartiDeGauche parti){
		//test
		//System.out.printf("TEST1");
		 JOptionPane.showMessageDialog(null, parti.listOBNL.size(), "nombre de supporteurs OBNL", 0);
		
	}
	
	public static void obtenirSup(PartiDuCentre parti){
		
		//test
		//System.out.printf("TEST2");
		 JOptionPane.showMessageDialog(null, parti.obtenirTabCirconscription(), "liste de supporteurs du parti du centre", 0);
	}


	public static void obtenirSup(PartiDeDroite parti){
		//test
		//System.out.printf("TEST3");
		 JOptionPane.showMessageDialog(null, parti.obtenirTabDepute(), "liste de supporteurs du parti de droite", 0);
	}
	
	/**
	 * affiche le nom et le parti des membres de la conscription choisie.
	 * 
	 * @param collection election de type Election
	 * 
	 * @author Daniel Colalillo
	 * @since 11/6/2018
	 * @version 1.0.0
	 */
	public static void nomCirconscription(Election election){
		
		/*
		 * strategie: 
		 * demander à l'utilisateur une conscription, 
		 * vérifier le nombre de députés dans la conscription 
		 * et afficher les députés associés et leurs partis à 
		 * l'aide d'une boucle pour remplir un tableau.
		 * 
		 */
		
		
		String options = null;
		
		int optionChoisi = 0;
		
		List<String> nomDeputeParti = new ArrayList<String>();
		
		nomDeputeParti.add("nom Depute \t numero de parti\n");
		
		//demander à l'utilisateur une conscription et stocker la réponse dans 
		//des options
		options = JOptionPane.showInputDialog(null, 
				"choisi un circonscription", "circonscription", 
				0, null, election.obtenirNomsCirconscription(), 0).toString();
		
		//convertir le nombre en son équivalent de chaîne
		optionChoisi = election.nomsCirconscriptionCollection.indexOf(options);
		
		for( int i = 0; i < election.nomsPartiCollection.size(); i++)
		{
			//si l'index est vide ajouter pas une nouvelle chaîne
			if(election.index[optionChoisi][i] != Constantes.VIDE){
				
				//ajouter la partie indexée avec le nom du député en 
				//utilisant la méthode de l'index pour obtenir la position
				//des députés
				nomDeputeParti.add(new String(election.deputeCollection.get
						(election.index[optionChoisi][i]).getDepute()) + 
						election.nomsPartiCollection.get(i));
			}
			
		}
		
		//afficher la liste des députés et de leurs partis en fonction de 
		//la conscription sélectionnée
		JOptionPane.showMessageDialog(null, nomDeputeParti.toArray(), 
				"parti et depute", 0);
		
	}
	
	/**
	 * Afficher les noms de parti. Afficher les noms des deputes qui appartient
	 * au parti choisi part l'utilisateur.
	 * 
	 * @param election
	 * 
	 * @author Jason Pang
	 * @since 11/6/2018
	 * @version 1.0.1
	 */
	public static void nomParti(Election election)
	{
		/*
		 * Strategie:
		 * Utiliser les methodes de JOptionPane pour afficher la liste des
		 * partis et affichier les noms des deputes. Utiliser indexOf() pour
		 * savoir la position du parti dans la liste de parti et obtenir les 
		 * noms des depute.
		 */
		
		String options = null;
		
		List<String> nomsDepute = new ArrayList<String>();
		
		//Demander l'utilisateur de choisir un parti
		options = JOptionPane.showInputDialog(null, 
                "choisi un Parti", "Parti", 0, null, 
                election.obtenirNomsParti(), 0).toString();
		
		//Obtenir la numero du parti. 
		int numParti = election.nomsPartiCollection.indexOf(options);
		
		/*
		 * Remplir la liste avec les noms des depute associer avec le parti
		 */
		for (int i = 0; i < election.circonscriptionCollection.size(); i++)
		{
			//Verifier si l'index east vide.
			if(election.index[i][numParti] != Constantes.VIDE)
			{
				nomsDepute.add(new String(election.nomsDeputeCollection.get
						(election.index[i][numParti])));
			}
		}
		
		//Affichier les deputes du Parti
		JOptionPane.showMessageDialog(null, nomsDepute.toArray(), 
				"Les Deputes de " + options, 0);
	}
	
	/**
	 * Afficher les noms des Deputes. Afficher la circonscription et la parti
	 * des deputes qui appartient au depute choisi part l'utilisateur.
	 * 
	 * @param election
	 * 
	 * @author Jason Pang
	 * @since 11/6/2018
	 * @version 1.0.1
	 */
	public static void nomsDepute(Election election)
	{
		/*
		 * Strategie:
		 * Utiliser les methodes de JOptionPane pour afficher la liste des
		 * deputes et affichier la circonscription et la parti du deputes.
		 * Utiliser indexOf() pour savoir la position du depute dans la liste
		 * de depute et obtenir leur circonscription et leur parti. 
		 */
		
		String options = null;
		
		//Demander l'utlisateur de choisir un Depute
		options = JOptionPane.showInputDialog(null, 
                "choisi un Depute", "Depute", 
                0, null, election.obtenirNomsDepute(), 0).toString();
		
		//Obtenir la numero de Depute.
		int depute = election.nomsDeputeCollection.indexOf(options);
		
		//Obtenir la circonscription du depute.
		int noCirc = election.deputeCollection.get(depute).getNumCase();
		//Obtenir la parti du depute.
		int noParti = election.deputeCollection.get(depute).getNumParti();
		
		String information = 
				"Circonscription: \n" +
				election.nomsCirconscriptionCollection.get(noCirc) + 
				"\nParti: \n" + 
				election.nomsPartiCollection.get(noParti);
		
		//Afficher la circonscription et parti du Depute.
		JOptionPane.showMessageDialog(null, information, options + ": \n", 0);
	}
	
	/**
	 * quitte le programme et affiche un message notifiant l'utilisateur
	 * 
	 * @param collection election de type Election
	 * 
	 * @author Daniel Colalillo
	 * @since 11/6/2018
	 * @version 1.0.0
	 */
	public static void quitter(Election election){
		
		/*
		 * strategie: 
		 * affiche un message en utilisant joptionpane puis quitte le 
		 * programme en utilisant system.exit
		 * 
		 */
		
		
		JOptionPane.showMessageDialog(null, "quitter programme", "quitter", 0);
		
		//quitte le programme
		System.exit(0);
			
	}
	
	/*
	 * Nécessaire à  JOptionPane sur un Mac
	 */
	public static void preparerPourMac() {

		try {
			
	         UIManager.setLookAndFeel(
	        		 UIManager.getCrossPlatformLookAndFeelClassName());
	         
	      } catch (Exception e) {  
	         e.printStackTrace();
	      }
	}
}
