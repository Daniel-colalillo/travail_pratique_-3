

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

public class PanneauHaut extends JPanel 
{
	/* Les Panneaux */
	private JList panCirc;
	private JList panParti;
	private JList panDepute;
	
	/* Les Etiquettes */
	private JLabel etiqPanCirc; 
	private JLabel etiqPanParti;
	private JLabel etiqPanDepute;
	
	private Election election;
	
	public PanneauHaut(Election election) 
	{
		this.election = election;
		
		initComposants();
	}
	
	private void initComposants() 
	{
		// Obtenir nom du premiere circonscription
		String nomCirc = election.nomsCirconscriptionCollection.get(0);
		// Obtenir les partis dans le premiere circonscription
		String [] tabNomsPartis= 
				election.obtenirNomsPartisParCirconscription(nomCirc);
		// Obtenir les deputes des partis
		String [] tabNomsDeputes = 
				election.obtenirNomsDeputesParCirconscription
				(nomCirc, tabNomsPartis);
				
		// Panneau des circonscriptions
		panCirc = new JList(election.obtenirNomsCirconscription());
		panCirc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panCirc.setLayoutOrientation(JList.VERTICAL);
		panCirc.setVisibleRowCount(-1);
				
		// Panneau des partis
		panParti = new JList(tabNomsPartis);
		panParti.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panParti.setLayoutOrientation(JList.VERTICAL);
		panParti.setVisibleRowCount(-1);
		
		// Panneau des Deputes
		panDepute = new JList(tabNomsDeputes);
		panDepute.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panDepute.setLayoutOrientation(JList.VERTICAL);
		panDepute.setVisibleRowCount(-1);
		
		etiqPanCirc = new JLabel("Noms des circonscription");
		
		etiqPanParti = new JLabel("Noms des partis");
		
		etiqPanDepute = new JLabel("Noms des deputes");
		
		addEtiquette();
		
		addPanneau();
	}
	
	
	private void addPanneau() 
	{
		add(panCirc);
		add(panParti);
		add(panDepute);
	}
	
	private void addEtiquette() 
	{
		add(etiqPanCirc);
		add(etiqPanParti);
		add(etiqPanDepute);
	}
	
	/*
	private class MonJList extends JList
	{
		
		
		public MonJList(String[] data) 
		{
			super(data);
		}
		
		public void PanneauAffichageNoms() 
		{
			
		}
	}
	*/
}
