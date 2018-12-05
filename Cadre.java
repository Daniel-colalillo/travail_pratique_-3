

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Cadre extends JFrame implements Runnable
{
	
	// IS THIS NECESSARY?	(RELATE 1)
	Election election;
	
	PanneauBas panneau = new PanneauBas(election);
	
	public Cadre(String titre, Election election) 
	{
		super(titre);
		// (RELATE 1)
		this.election = election;
	}
	
	
	
	public void run() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		
		/* HOW TO PASS ELECTION? (RELATE 1) */
		//setContentPane(new PanneauHaut(election));
		setContentPane(panneau.getPanneau());
		
		/* ^^^?REPLACE?^^^ */
		//add(new PanneauHaut(election),BorderLayout.NORTH);
		//add(new PanneauBas(election), BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
}