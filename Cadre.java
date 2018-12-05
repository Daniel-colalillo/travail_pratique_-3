

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Cadre extends JFrame implements Runnable
{
	Election election;
	
	
	public Cadre(String titre, Election election) 
	{
		super(titre);

		this.election = election;
	}
	
	public void run() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
    
    add(new PanneauHaut(election),BorderLayout.NORTH);
    
		//h�rite par composition
		PanneauBas panneau = new PanneauBas(election);
	
		add(panneau.getPanneau() , BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
}
