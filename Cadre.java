

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


import javax.swing.JMenuBar;

public class Cadre extends JFrame implements Runnable
{
	private Election election;
	private PanneauHaut panneau1;
	private PanneauBas panneau2;
	
	
	public Cadre(String titre) 
	{
		super(titre);
		
		panneau1 = new PanneauHaut(election);

		panneau2 = new PanneauBas(election);
	}
	
	public void run() 
	{
		
		if (System.getProperty("os.name").contains("Mac")) {
			  System.setProperty("apple.laf.useScreenMenuBar", "true");
			}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		add(new MenuFichier(this), BorderLayout.PAGE_START);
		
		add(panneau1);
		
		add(panneau2.getPanneau(),BorderLayout.PAGE_END);
				
		setVisible(true);
	}
	
	public void setElection(Election election)
	{
		this.election = election;
		
		remove(panneau1);
		remove(panneau2.getPanneau());
		revalidate();
		
		panneau1 = new PanneauHaut(election);
		add(panneau1);
		revalidate();
		
		panneau2 = new PanneauBas(election);
		add(panneau2.getPanneau(),BorderLayout.PAGE_END);
		revalidate();
		
			
	}
}
