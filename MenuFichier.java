import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * crée et ajoute des éléments fonctionnels à la jmenubar
 *
 * 
 * @author Daniel Colalillo
 * @since 12/05/2018
 * @version 1.1.3
 */
public class MenuFichier extends JMenuBar
{
	
	
	
	//Election election;
	Cadre cadre;
	
	String[] choixMenu = {"Ouvrir fichier texte",
						  "Ouvrir fichier binaire",
						  "Quitter"};
	
	/* Les elements du Menu */
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem menuItem;
	
	public MenuFichier(Cadre cadre)
	{
		/*
		 * Strategie:
		 * crée un nouveau menu et utilise des sous-fonctions 
		 * pour ajouter des éléments à une jmenubar
		 * 
		 */
		
		
		//Creer le menubar
		super();
		
		this.cadre = cadre;

		menu = new JMenu("Fichier");
		
		add(menu);
		
		
		//éléments de menu
		ajouteItem(choixMenu[0]);
		
		ajouteItem(choixMenu[1]);
		
		ajouteItem(choixMenu[2]);
		
		this.cadre.setJMenuBar(menuBar);
	}
	
	
	/**
	 * ajoute un article à la jmenubar
	 * 
	 * @param String item
	 * 
	 * @author Daniel Colalillo
	 * @since 12/05/2018
	 * @version 1.0.2
	 */
	private void ajouteItem(String item){
		
		/*
		 * Strategie:
		 * crée un nouvel élément jmenu et y ajoute un écouteur d'actions
		 * 
		 */
		
		//crée un nouvel élément jmenu
		menuItem = new JMenuItem(item);
		
		//ajoute un écouteur d'actions
		menuItem.addActionListener(new MenuEcouteur());
		
		//ajoute l'article à la jmenubar
		menu.add(menuItem);
		
		
	}
	
	
	/**
	 * classe pour les actionevents
	 * 
	 * 
	 * @author Daniel Colalillo
	 * @since 12/05/2018
	 * @version 1.0.5
	 */
	public class MenuEcouteur implements ActionListener
	{
		
		/**
		 * événements d'action qui lancent le processus de lecture et de 
		 * stockage d'un fichier texte ou d'un fichier binaire
		 * 
		 * 
		 * @author Daniel Colalillo
		 * @since 12/05/2018
		 * @version 1.0.5
		 */
		public void actionPerformed(ActionEvent arg0) 
		{
			/*
			 * Strategie:
			 * en utilisant des fonctions précédemment créées qui 
			 * stockent des données de fichier texte dans une collection 
			 * d'élection. utilise également les instructions if pour 
			 * déterminer si l'utilisateur souhaite ouvrir un fichier txt, 
			 * un fichier binaire ou quitter le programme.
			 * 
			 */
			
			
			//obtient quel article dans la jmenubar a été pressé
			JMenuItem source = (JMenuItem)arg0.getSource();
			
			//instancie la collection électorale
			Election election = new Election(Constantes.ANNEE_ELECTION);
			
			//si l'utilisateur a sélectionné l'option d'ouvrir un fichier 
			//texte ouvert et de stocker le fichier texte
			if(source.getText().equals(choixMenu[0]))
			{
				//Ouvrir fichier texte et sauvegarder en forme binaire
				ModuleFichier.getElection(election);
				
				election.genererIndex();
				
				ModuleFichier.sauverFichierBinaire(election);
			}
			
			//si l'utilisateur a sélectionné l'option d'ouvrir un fichier
			//binaire et de stocker le fichier texte
			else if(source.getText().equals(choixMenu[1]))
			{
				//Ouvrir fichier binaire
				election = ModuleFichier.getElectionBinaire();
			}
			//Quitter al programme
			else
			{
				
				System.exit(0);
			}
			
			// generer les parti pour l'election
			ModuleFichier.genererPartis(election);
			
			// genere les supporteurs
			ModuleFichier.genererSupporteurs(election);
			
			cadre.setElection(election);
		}
	}
}
