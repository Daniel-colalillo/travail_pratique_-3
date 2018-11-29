import java.util.ArrayList;
import java.util.List;


/**
 * Sous-class PartiDuCentre qui herite Parti.
 * Ajoute une liste de Circonscription au parti.
 * 
 * @author jason pang
 * @since 11/07/2018
 * @version 1.0.2
 */
public class PartiDuCentre extends Parti
{
	//Liste des supporteurs circonscription
	List<Circonscription> listCirconscription;
	
	/**
	 * Constructeur qui initialise une parti et 
	 * une nouvelle liste de type Circonscription.
	 * 
	 * @param parti
	 * 
	 * @author jason pang
	 * @since 11/08/2018
	 * @version 1.0.1
	 */
	public PartiDuCentre(String parti)
	{
		super(parti);
		this.listCirconscription = new ArrayList<Circonscription>();
	}
	
	/**
	 * Obtenir la categorie du parti. Remplacer la 
	 * méthode getCategorie de la super-classe.
	 * 
	 * @return "Parti du centre"
	 * 
	 * @author jason pang
	 * @since 11/07/2018
	 * @version 1.0.0
	 */
	@Override
	public String getCategorie()
	{
		return super.getCategorie() + " du centre";
	}

	/**
	 * Ajouter un Circonscription a la liste de Circonscription du parti.
	 * 
	 * @param circonscription
	 * 
	 * @author jason pang
	 * @since 11/07/2018
	 * @version 1.0.0
	 */
	public void ajouterCirconscription(Circonscription circonscription)
	{
		if(this.listCirconscription.indexOf(circonscription) == Constantes.VIDE)
		{
			this.listCirconscription.add(circonscription);
		}
	}
	
	/**
	 * Obtenir tout les Circonscription dans la liste de Circonscription
	 * 
	 * @return tabCirconscription
	 * 
	 * @author jason pang
	 * @since 11/07/2018
	 * @version 1.0.1
	 */
	public Circonscription[] obtenirTabCirconscription()
	{
		Circonscription[] tabCirconscription = new Circonscription[this.listCirconscription.size()];
		tabCirconscription = this.listCirconscription.toArray(tabCirconscription);
		return tabCirconscription;
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