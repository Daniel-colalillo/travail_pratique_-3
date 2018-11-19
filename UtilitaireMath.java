/**
 * Offre des fonctions utilitaires communes au projet
 * @author pbelisle
 * 
 * @author Pierre B�lisle
 * @revisor M�lanie Lord
 *  
 * @version A2018
 *
 */
public class UtilitaireMath {

	/**
	 * Retourne une nombre al�atoire dans un intervalle entier donn�.
	 * 
	 * ATTENTION : min doit �tre plus petit que max  mais aucune validation
	 *             n'est effectu�e. 
	 *             
	 * @param min La plus petite valeur possible
	 * @param max La plus grande valeur possible
	 * @return Un nombre entre min et max (inclusivement)
	 */
	public static int alea(int min,int max)
	{
		/*
		 * Strat�gie : On utilise le g�n�rateur de Java qui retourne une valeur 
		 * r�elle entre 0 et 1.  Ensuite, on le ram�ne dans l'intervalle 
		 * min..max et on le transforme en entier.
		 */
		return (int) (Math.random() * (max - min + 1) + min);
	}


}
