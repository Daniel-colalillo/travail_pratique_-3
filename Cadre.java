

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Cadre extends JFrame implements Runnable
{
	public static Election election = new Election(Constantes.ANNEE_ELECTION);
	
	
	public Cadre(String titre) 
	{
		super(titre);

		//this.election = election;
	}
	
	public void run() 
	{
		
		if (System.getProperty("os.name").contains("Mac")) {
			  System.setProperty("apple.laf.useScreenMenuBar", "true");
			}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		//frame.setJMenuBar(MenuFichier.creMenuBar());
		
		JMenuBar  menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");		
		        
        JMenuItem newMenuItem = new JMenuItem("New");
		
		//menuItem.addActionListener(new MenuEcouteur());
		menuBar.add(menu);
		
		//setJMenuBar(menuBar);
		add(menuBar);
		menu.add(newMenuItem);

	    super.setJMenuBar(menuBar);
		//setJMenuBar(menuBar);
    
		//add(new PanneauHaut(election),BorderLayout.NORTH);
    
		//herite par composition
		//PanneauBas panneau = new PanneauBas(election);
	
		//add(panneau.getPanneau() , BorderLayout.SOUTH);
        super.pack();

		super.setVisible(true);
	}
	
	public static void setElection(Election electionDonner){
		
		election = electionDonner;
	}
}
