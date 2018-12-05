/**
 * Panneau haut herite JPanel par extension. Utilise trois sous-panneaux
 * pour afficher la liste des circonscriptions et des partis et de leur 
 * deputes a l'interieur de la circonscription.
 * 
 * @author jason pang
 * @since 12/02/2018
 * @version 1.1.3
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class PanneauHaut extends JPanel 
{
	/*
	 * Strategie:
	 * Creer throis sous panneaux pour les circonscription, les partis et
	 * les deputes. Creer des variables pour retenir les information de 
	 * l'election. Creer une classe privee qui herite JPanel qui contien
	 * sera utiliser pour les sous-panneaux, il contient les etiquette et 
	 * les listes.
	 */
	
	/* Les sous-panneaux */
	private MonJPanel panCirc;
	private MonJPanel panParti;
	private MonJPanel panDepute;
	
	/* Variables de l'election */
	private String nomCirc;
	private String [] tabNomsPartis;
	private String [] tabNomsDeputes;
	private String [] tabNomsCirconscription;
	
	/* Etiquette pour les sous-panneaux */
	private String [] etiquette = {"Noms des circonscription",
								   "Noms des partis",
								   "Noms des deputes"};
	
	private Election election;
	
	/**
	 * Constructeur qui reference a Election
	 * 
	 * @param election
	 * 
	 * @author jason pang
	 * @since 12/02/2018
	 * @version 1.0.1
	 */
	public PanneauHaut(Election election) 
	{
		/*
		 * Strategie:
		 * Stocker l'election dans une variable privee et
		 * initialise tous les composants.
		 */
		
		this.election = election;
		
		initComposants();
	}
	
	/**
	 * Initialiser les composants du Panneau haut.
	 * 
	 * @author jason pang
	 * @since 12/02/2018
	 * @version 1.1.0
	 */
	private void initComposants() 
	{
		/*
		 * Strategie:
		 * Utiliser les methodes le l'election pour retenir des information.
		 * Initialiser les JPanel avec leur etiquette et l'information qui
		 * devrai etre afficher dans le JList. Ajouter les sous-panneaux au
		 * PanneauHaut.
		 */
		
		// Obtenir nom du premiere circonscription
		nomCirc = election.nomsCirconscriptionCollection.get(0);
		// Obtenir les partis dans le premiere circonscription
		tabNomsPartis= election.obtenirNomsPartisParCirconscription(nomCirc);
		// Obtenir les deputes des partis
		tabNomsDeputes = election.obtenirNomsDeputesParCirconscription
						 (nomCirc, tabNomsPartis);
		// Obtenir les noms de toutes les circonscriptions
		tabNomsCirconscription = election.obtenirNomsCirconscription();
		
		/*
		 * Initialiser les sous panneaux avec leur etiquette et l'information
		 * pour afficher sur les listes.
		 */
		panCirc = new MonJPanel(etiquette[0], tabNomsCirconscription);
		panParti = new MonJPanel(etiquette[1], tabNomsPartis);
		panDepute = new MonJPanel(etiquette[2], tabNomsDeputes);
		
		/*
		 * Ajouter les composants des sous-panneau au sous-panneau
		 */
		panCirc.ajouterComponsants();
		panParti.ajouterComponsants();
		panDepute.ajouterComponsants();
		
		addPanneau();
	}	
	
	/**
	 * Ajouter les sous-panneau au panneau haut
	 * 
	 * @author jason pang
	 * @since 12/04/2018
	 * @version 1.0.0
	 */
	private void addPanneau()
	{
		/*
		 * Strategie:
		 * Utiliser la methode add() pour ajouter les sous-panneaux 
		 * au PanneauHaut.
		 */
		
		add(panCirc, BorderLayout.WEST);
		add(panParti, BorderLayout.CENTER);
		add(panDepute, BorderLayout.EAST);
	}
	/**
	 * Classe privee qui herite Jpanel. Il est utiliser comme
	 * sous-panneau pour PanneauHaut. Ce panneau contient une etiquette,
	 * une liste et un scroller pour la liste.
	 * 
	 * @author jason pang
	 * @since 12/04/2018
	 * @version 1.0.2
	 */
	private class MonJPanel extends JPanel
	{
		/* Les composants du sous-panneau */
		private JLabel etiquette;
		private JList listNoms;
		private JScrollPane listScroller;
		
		/**
		 * Constructeur pour le JPanel. Initialise les composants du sous-panneau.
		 * 
		 * @param titre L'etiquette du liste
		 * @param data L'information du liste
		 * 
		 * @author jason pang
		 * @since 12/04/2018
		 * @version 1.0.4
		 */
		public MonJPanel(String titre, String[] data) 
		{
			/*
			 * Strategie:
			 * Utiliser super pour initialiser le JPanel avec BorderLayout.
			 * Initialiser l'etiquette avec la titre donner. Initialiser la 
			 * liste avec l'information donner. Initialiser la scroller pour
			 * la liste.
			 */
			super(new BorderLayout());
			
			//etiquette
			etiquette = new JLabel(titre);
			
			//liste
			listNoms = new JList(data);
			listNoms.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listNoms.setLayoutOrientation(JList.VERTICAL);
			listNoms.setVisibleRowCount(-1);
		
			//scroller
			listScroller = new JScrollPane(listNoms);
			listScroller.setPreferredSize(new Dimension(
											Constantes.FENETRE_LONGEUR, 
											Constantes.FENETRE_HAUTEUR));
			listScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		}
		
		/**
		 * Ajouter les composants au sous-panneau.
		 * 
		 * @author jason pang
		 * @since 12/04/2018
		 * @version 1.0.1
		 */
		public void ajouterComponsants() 
		{
			/*
			 * Strategie:
			 * Ajouter l'etiquette au nord et la list au sud du sous-panneau.
			 */
			add(etiquette, BorderLayout.NORTH);
			add(listScroller, BorderLayout.SOUTH);
		}
		
		/**
		 * changer les informations qui apparaîtront sur la liste.
		 * 
		 * @param data L'information qui sera afficher
		 * 
		 * @author jason pang
		 * @since 12/04/2018
		 * @version 1.0.0
		 */
		public void setInformation(String[] data)
		{
			/*
			 * Strategie:
			 * Utiliser la methode setListData de JList
			 */
			this.listNoms.setListData(data);
		}
	}
	
}
