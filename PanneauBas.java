
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
		
		//obtenire le nom du premiere parti
			
		String nomParti = election.nomsPartiCollection.get(0);
		
		//obtenir les depute du parti
		String [] tabNomsDepute = election.obtenirNomsDeputesParParti(nomParti);
		
		//obtenir les supporteurs des deputes
		String [] tabNomSupporteurs = 
				election.obtenirNomsSupporteursParParti(nomParti);
				
		//obtenirs les noms des partis
		String [] tabNomParti = election.obtenirNomsParti();
		
		/*
		 * Initialiser les sous panneaux avec leur etiquette et l'information
		 * pour afficher sur les listes.
		 */
		panPartis = new MonJPanel("partis", tabNomParti);
		
		panDeputes = new MonJPanel("depute", tabNomsDepute);
		
		panSupporteurs = new MonJPanel("supporteurs", tabNomSupporteurs);
		
		//
		panPartis.ajouterComponsants();
		
		panDeputes.ajouterComponsants();
		
		panSupporteurs.ajouterComponsants();
		
				addPanneau();
	}
	
	
	private void addPanneau() 
	{
		jpanel.add(panPartis, BorderLayout.WEST);
		jpanel.add(panDeputes, BorderLayout.CENTER);
		jpanel.add(panSupporteurs, BorderLayout.EAST);
	}
	
	public JPanel getPanneau(){
		
		return jpanel;
		
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
			add(listScroller, BorderLayout.SOUTH);
		}
		
		public void setInformation(String[] data)
		{
			this.listNoms.setListData(data);
		}
	}
	
}
