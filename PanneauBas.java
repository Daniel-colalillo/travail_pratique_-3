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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class PanneauBas{
	
	private JPanel jpanel = new JPanel();

	/* Les Panneaux */
	private MonJPanel panPartis;
	private MonJPanel panDeputes;
	private MonJPanel panSupporteurs;
	
	/* Variables de l'election */
	private String nomParti;
	private String [] tabNomsDepute = {""};
	private String [] tabNomSupporteurs = {""};
	private String [] tabNomParti = {""};
	
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
		try{
		//obtenire le nom du premiere parti
		
		nomParti = election.nomsPartiCollection.get(0);
		
		//obtenir les depute du parti
		tabNomsDepute = election.obtenirNomsDeputesParParti(nomParti);
		
		//obtenir les supporteurs des deputes
		tabNomSupporteurs = 
				election.obtenirNomsSupporteursParParti(nomParti);
				
		//obtenirs les noms des partis avec leur categorie
		//tabNomParti = election.obtenirNomsParti();
		tabNomParti = new String[election.partiCollection.size()];
		for (int i = 0; i < election.partiCollection.size(); i++)
		{
			tabNomParti[i] = election.partiCollection.get(i).getParti()
					+" ( "+ election.partiCollection.get(i).getCategorie()+" )";
		}
		}catch(NullPointerException e){}
		
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
		
		//ECOUTEUR
		panPartis.listNoms.addListSelectionListener(new MonEcouteur());
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
	 * utilis� pour obtenir jpanel travailler � l'int�rieur de carde
	 * 
	 * @author Daniel Colalillo
	 * @since 12/04/2018
	 * @version 1.0.5
	 */
	public JPanel getPanneau(){
		
		return jpanel;
		
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
	}
	
	/**
	 * Classe interne pour definir l'ecouteur pour liste des partis.
	 * 
	 * @author jason pang
	 * @since 12/05/2018
	 * @version 1.0.0
	 */
	public class MonEcouteur implements ListSelectionListener
	{	
		/**
		 * Changer les elements dans les listes 
		 * 
		 * @author jason pang
		 * @since 12/05/2018
		 * @version 1.0.0
		 */
		public void valueChanged(ListSelectionEvent e)
		{
			/*
			 * Strategie:
			 * Obtenir l'information lier a l'index choisi et remplir
			 * les listes avec les nouveaux informations. Verifier la 
			 * catergorie du parti chois, si c'est une parti de gauche,
			 * afficher la nombre de supporteur.
			 */
			
			JList list = (JList)e.getSource();
			
			// obtenir l'index de ce qui a �t� choisi
			int index = list.getSelectedIndex();
			
			// Obtenir l'information du parti choisi
			Parti parti = election.partiCollection.get(index);
			nomParti = parti.getParti();
			
			//obtenir les depute du parti
			tabNomsDepute = election.obtenirNomsDeputesParParti(nomParti);
			
			// Si la parti est une parti de gauche, afficher la nombre 
			// de supportteur.
			if(parti.getCategorie().equals("Parti de gauche"))
			{
				int nombreSupp = election.obtenirNomsSupporteursParParti(nomParti).length;
				String[] supp = {"Nombre de supporteur OBNL " + nombreSupp};
				tabNomSupporteurs = supp;
			}
			else
			{
				//obtenir les supporteurs des deputes
				tabNomSupporteurs = 
						election.obtenirNomsSupporteursParParti(nomParti);
			}
			
			//Changer les elements que les JLists contiennentt
			panDeputes.listNoms.setListData(tabNomsDepute);
			panSupporteurs.listNoms.setListData(tabNomSupporteurs);
		}
	}
}
