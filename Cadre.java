/**
 * Class Cadre qui herite JFrame et implement Runnable.
 * Contient Election, deux panneaux et une methode setElection() 
 * pour rafraichir les panneaux.
 * 
 * @author jason pang
 * @since 12/04/2018
 * @version 1.0.3
 */
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class Cadre extends JFrame implements Runnable
{
	private Election election;
	
	private PanneauHaut panneau1;
	private PanneauBas panneau2;
	
	/**
	 * Constructeur avec une titre. Instancier un JFrame avec la titre donner
	 * et instancier une panneauHaut et une panneauBas.
	 * 
	 * @param titre
	 * 
	 * @author jason pang
	 * @since 12/05/2018
	 * @version 1.0.1
	 */
	public Cadre(String titre) 
	{
		super(titre);
		
		// Instancier les panneaux
		panneau1 = new PanneauHaut(election);
		panneau2 = new PanneauBas(election);
	}
	
	public void run() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		// Ajouter menu au cadre
		add(new MenuFichier(this), BorderLayout.PAGE_START);
		
		// Ajouter PanneauHaut au cadre
		add(panneau1);
		
		// Ajouter PanneauBas au cadre
		add(panneau2.getPanneau(),BorderLayout.PAGE_END);
				
		setVisible(true);
	}
	
	/**
	 * Enregistrez les nouvelles informations d'election et actualisez
	 * les panneaux.
	 * 
	 * @param election
	 * 
	 * @author jason pang
	 * @since 12/05/2018
	 * @version 1.1.0
	 */
	public void setElection(Election election)
	{
		/*
		 * Strategie:
		 * Stocker l'election. Enlever les panneauHaut et panneauBas.
		 * Initialiser a nouveau les panneauHaut et panneauBas avec 
		 * nouveau information.
		 */
		
		this.election = election;
		
		// Enlever les panneaux
		remove(panneau1);
		remove(panneau2.getPanneau());
		revalidate();
		
		// Ajouter un nouveau panneauHaut
		panneau1 = new PanneauHaut(election);
		add(panneau1);
		revalidate();
		
		// Ajouter un nouveau panneauBas
		panneau2 = new PanneauBas(election);
		add(panneau2.getPanneau(),BorderLayout.PAGE_END);
		revalidate();
		
			
	}
	
}
