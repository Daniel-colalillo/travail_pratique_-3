

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
		
		// generer les parti pour l'election
		ModuleFichier.genererPartis(election);
		
		// genere les supporteurs
		ModuleFichier.genererSupporteurs(election);
		
		//menu
		
		Thread t = new Thread(new Cadre("Election", election));
		t.start();

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
