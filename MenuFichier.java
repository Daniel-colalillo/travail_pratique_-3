import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;



public class MenuFichier extends JMenuBar{
	
	JMenuBar menuBar;
	
	JMenu menu;
	
	JMenuItem menuItem;
	
	
	
	
	public MenuFichier(Election election) {
		
		
		creerMenu("menu Fichier");
		
		ajouteMenuItem("Ouvrir fichier texte");
		
		ajouteMenuItem("Ouvrir fichier binaire");
		
		ajouteMenuItem("Quitter");
		
		creerFrame();
		
	}
	
	private void creerFrame() {
		
	    JFrame frame = new JFrame();
	    
	    // Install the menu bar in the frame
	    frame.setJMenuBar(menuBar);
	}

	private void creerMenu(String nom){
				
		//Create the menu bar
		menuBar = new JMenuBar();
				
		//Build the first menu
		menu = new JMenu("Menu");
				
		menuBar.add(menu);
	}

	private void ajouteMenuItem(String nom){
		
		menuItem = new JMenuItem(nom);
		
		//menuItem.addActionListener(new MenuEcouteur());
		
		menu.add(menuItem);
		
	}
	
	
	public class MenuEcouteur extends JMenuBar implements ActionListener {
		
		
		public void actionPerformed(ActionEvent e) {
	        JMenuItem source = (JMenuItem)e.getSource();
	        
	        Election election = new Election(Constantes.ANNEE_ELECTION);
	        
			if(source.getText() == "Ouvrir fichier texte"){
	        	
	        	ModuleFichier.getElection(election);
	        	
				election.genererIndex();
				
				ModuleFichier.sauverFichierBinaire(election);
				
	        }
	        else if(source.getText() == "Ouvrir fichier binaire"){
	        	
	        	election = ModuleFichier.getElectionBinaire();
	        }
	        else if(source.getText() == "Quitter"){
	        	
	        	System.exit(0);
	        }
			
			
			// generer les parti pour l'election
			ModuleFichier.genererPartis(election);
			
			// genere les supporteurs
			ModuleFichier.genererSupporteurs(election);
			
			Cadre.setElection(election);
	    }
	}
}

