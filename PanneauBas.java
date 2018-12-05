
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;


public class PanneauBas{
	
	private JPanel jpanel = new JPanel();

	/* Les Panneaux */
	private JList panPartis;
	private JList panDeputes;
	private JList panSupporteurs;
	
	
	/* Les Etiquettes */
	private JLabel etiqPanPartis; 
	private JLabel etiqPanDeputes;
	private JLabel etiqPanSupporteurs;
	
	private Election election;
	
	public PanneauBas(Election election) 
	{
		this.election = election;
		
		initComposants();
	}
	private void initComposants(){
		
		//obtenire premiere parti
		String nomParti = election.nomsPartiCollection.firstElement();
		
		//obtenir les depute du parti
		String [] tabNomsDepute = election.obtenirNomsDeputesParParti(nomParti);
		
		//obtenir les supporteurs des deputes
		String [] tabNomSupporteurs = election.obtenirNomsSupporteursParParti(nomParti);
		
		
		// Panneau des parti
				panPartis = new JList(election.obtenirNomsParti());
				
				panPartis.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				
				panPartis.setLayoutOrientation(JList.VERTICAL);
				
				panPartis.setVisibleRowCount(-1);
		
				
				// Panneau des deputes
				panDeputes = new JList(tabNomsDepute);
				
				panDeputes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				
				panDeputes.setLayoutOrientation(JList.VERTICAL);
				
				panDeputes.setVisibleRowCount(-1);
				
				// Panneau des supporteurs
				panSupporteurs = new JList(tabNomSupporteurs);
				
				panSupporteurs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				
				panSupporteurs.setLayoutOrientation(JList.VERTICAL);
				
				panSupporteurs.setVisibleRowCount(-1);
				
				
				
				etiqPanPartis = new JLabel("Noms des partis");
				
				etiqPanDeputes = new JLabel("Noms des deputes");
				
				etiqPanSupporteurs = new JLabel("Noms des supporteurs");
				
				addEtiquette();
				
				addPanneau();
	}
	
	
	private void addPanneau() 
	{
		jpanel.add(panPartis);
		jpanel.add(panDeputes);
		jpanel.add(panSupporteurs);
	}
	
	private void addEtiquette() 
	{
		jpanel.add(etiqPanPartis);
		jpanel.add(etiqPanDeputes);
		jpanel.add(etiqPanSupporteurs);
	}
	
	public JPanel getPanneau(){
		
		return jpanel;
		
	}
}
