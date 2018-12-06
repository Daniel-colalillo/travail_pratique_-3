import java.util.ArrayList;
import java.util.List;


/**
 * Sous-class PartiDeGauche qui herite Parti.
 * Ajoute une liste de OBNL au parti.
 * 
 * @author jason pang
 * @since 11/07/2018
 * @version 1.0.2
 */
public class PartiDeGauche extends Parti
{
	//Liste des supporteurs OBNL
	List<String> listOBNL;
	
	/**
	 * Constructeur qui initialise une parti et 
	 * une nouvelle liste de String.
	 * 
	 * @param parti
	 * 
	 * @author jason pang
	 * @since 11/08/2018
	 * @version 1.0.1
	 */
	public PartiDeGauche(String parti)
	{
		super(parti);
		this.listOBNL = new ArrayList<String>();
	}
	
	/**
	 * Obtenir la categorie du parti. Remplacer la 
	 * méthode getCategorie de la super-classe.
	 * 
	 * @return "Parti de gauche"
	 * 
	 * @author jason pang
	 * @since 11/07/2018
	 * @version 1.0.0
	 */
	@Override
	public String getCategorie()
	{
		return super.getCategorie() + " de gauche";
	}
	
	/**
	 * Ajouter un OBNL a la liste de OBNL du parti.
	 * 
	 * @param nomOBNL
	 * 
	 * @author jason pang
	 * @since 11/07/2018
	 * @version 1.0.0
	 */
	public void ajouterOBNL(String nomOBNL)
	{
			this.listOBNL.add(nomOBNL);
	}
	
	/**
	 * Obtenir tout les OBNLs dans la liste de OBNL
	 * 
	 * @return tabOBNL
	 * 
	 * @author jason pang
	 * @since 11/07/2018
	 * @version 1.0.1
	 */
	public String[] obtenirTabOBNL()
	{
		String[] tabOBNL = new String[this.listOBNL.size()];
		tabOBNL = this.listOBNL.toArray(tabOBNL);
		return tabOBNL;
	}
	
	/**
	 * Retourne le nom du parti et sa categorie. Remplacer 
	 * la méthode toString de la super-classe
	 * 
	 * @return String
	 * 
	 * @author jason pang
	 * @since 11/18/2018
	 * @version 1.0.0
	 */
	@Override
	public String toString()
	{
		return super.toString()+ " " +this.getCategorie();
	}
}