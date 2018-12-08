/**
 * Panneau bas herite JPanel par composition. Utilise trois sous-panneaux
 * pour afficher la liste des parti avec leurs depute et leurs supporteurs.
 * 
 * @author Daniel Colalillo / Jason Pang
 * @since 12/02/2018
 * @version 1.2.0
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
public class PanneauBas{
	
	private JPanel jpanel = new JPanel();

	/* Les Panneaux */
	private MonJPanel panPartis;
	private MonJPanel panDeputes;
	private MonJPanel panSupporteurs;
	
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
	public PanneauBas(Election election) 
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
	 * @author jason pang / Daniel Colalillo
	 * @since 12/02/2018
	 * @version 1.2.6
	 */
	private void initComposants(){
		
		/*
		 * Strategie:
		 * Utiliser les methodes le l'election pour retenir des information.
		 * Initialiser les JPanel avec leur etiquette et l'information qui
		 * devrai etre afficher dans le JList. Ajouter les sous-panneaux au
		 * PanneauBas.
		 */
		
		//obtenire le nom du premiere parti
			
		String nomParti = election.nomsPartiCollection.get(0);
		//String nomParti = " ";
		
		//obtenir les depute du parti
		String [] tabNomsDepute = election.obtenirNomsDeputesParParti(nomParti);
		//String [] tabNomsDepute = null;
		
		//obtenir les supporteurs des deputes
		String [] tabNomSupporteurs =
				election.obtenirNomsSupporteursParParti(nomParti);
				
		//obtenirs les noms des partis
		String [] tabNomParti = election.obtenirNomsParti();
		//String [] tabNomParti = null;
		
		/*
		 * Initialiser les sous panneaux avec leur etiquette et l'information
		 * pour afficher sur les listes.
		 */
		panPartis = new MonJPanel("partis", tabNomParti);
		
		panDeputes = new MonJPanel("depute", tabNomsDepute);
		
		panSupporteurs = new MonJPanel("supporteurs", tabNomSupporteurs);
		
		/*
		 * Ajouter les composants des sous-panneau au sous-panneau
		 */
		panPartis.ajouterComponsants();
		
		panDeputes.ajouterComponsants();
		
		panSupporteurs.ajouterComponsants();
		
				addPanneau();
	}
	
	/**
	 * Ajouter les sous-panneau au panneau haut
	 * 
	 * @author jason pang
	 * @editedby Daniel Colalillo
	 * @since 12/04/2018
	 * @version 1.0.1
	 */
	private void addPanneau() 
	{
		/*
		 * Strategie:
		 * Utiliser la methode add() pour ajouter les sous-panneaux 
		 * au PanneauBas.
		 */
		
		jpanel.add(panPartis, BorderLayout.WEST);
		jpanel.add(panDeputes, BorderLayout.CENTER);
		jpanel.add(panSupporteurs, BorderLayout.EAST);
	}
	
	/**
	 * utilisé pour obtenir jpanel travailler à l'intérieur de carde
	 * 
	 * @author Daniel Colalillo
	 * @since 12/04/2018
	 * @version 1.0.5
	 */
	public JPanel getPanneau(){
		
		return jpanel;
		
	}
	
	/**
	 * 
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
