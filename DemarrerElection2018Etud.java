

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import java.util.ArrayList;
import java.util.List;

/*
 * Programme pour suivre les élections du Québec en 2018
 * 
 * @author Pierre Bélisle
 * @version Copyright A2018
 * 
 * @revision Daniel Colalillo
 */
public class DemarrerElection2018Etud {

	public static void main(String[] args) {
		
		preparerPourMac();
		
		Thread t = new Thread(new Cadre("Election"));
		t.start();

	}

	
	/*
	 * Nécessaire à  JOptionPane sur un Mac
	 */
	public static void preparerPourMac() {

		try {
			
	         UIManager.setLookAndFeel(
	        		 UIManager.getCrossPlatformLookAndFeelClassName());
	         
	      } catch (Exception e) {  
	         e.printStackTrace();
	      }
	}
}
