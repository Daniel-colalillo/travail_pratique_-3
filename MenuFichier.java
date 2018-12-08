import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


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
		//Creer le menubar
		super();
		this.cadre = cadre;
		//menuBar = new JMenuBar();
		//menuBar.setPreferredSize(new Dimension(,15));
		//menu
		menu = new JMenu("Fichier");
		add(menu);
		
		//menu items
		menuItem = new JMenuItem(choixMenu[0]);
		menuItem.addActionListener(new MenuEcouteur());
		menu.add(menuItem);
		
		menuItem = new JMenuItem(choixMenu[1]);
		menuItem.addActionListener(new MenuEcouteur());
		menu.add(menuItem);
		
		menuItem = new JMenuItem(choixMenu[2]);
		menuItem.addActionListener(new MenuEcouteur());
		menu.add(menuItem);
		
		this.cadre.setJMenuBar(menuBar);
	}
	
	public class MenuEcouteur implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			JMenuItem source = (JMenuItem)arg0.getSource();
			
			Election election = new Election(Constantes.ANNEE_ELECTION);
			
			if(source.getText().equals(choixMenu[0]))
			{
				//Ouvrir fichier texte et sauvegarder en forme binaire
				ModuleFichier.getElection(election);
				election.genererIndex();
				ModuleFichier.sauverFichierBinaire(election);
			}
			else if(source.getText().equals(choixMenu[1]))
			{
				//Ouvrir fichier binaire
				election = ModuleFichier.getElectionBinaire();
			}
			else
			{
				//Quitter al programme
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
