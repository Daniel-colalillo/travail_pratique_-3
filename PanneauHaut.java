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
		 * 
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
		add(panCirc, BorderLayout.WEST);
		add(panParti, BorderLayout.CENTER);
		add(panDepute, BorderLayout.EAST);
	}
	
	private class MonJPanel extends JPanel
	{
		private JLabel etiquette;
		private JList listNoms;
		private JScrollPane listScroller;
		
		public MonJPanel(String titre, String[] data) 
		{
			super(new BorderLayout());
			
			etiquette = new JLabel(titre);
			
			listNoms = new JList(data);
			listNoms.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listNoms.setLayoutOrientation(JList.VERTICAL);
			listNoms.setVisibleRowCount(-1);
		
			listScroller = new JScrollPane(listNoms);
			listScroller.setPreferredSize(new Dimension(
											Constantes.FENETRE_LONGEUR, 
											Constantes.FENETRE_HAUTEUR));
			listScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		}
		
		public void ajouterComponsants() 
		{
			add(etiquette, BorderLayout.NORTH);
			add(listScroller, BorderLayout.CENTER);
		}
		
		public void setInformation(String[] data)
		{
			this.listNoms.setListData(data);
		}
	}
	
}
