import java.util.ArrayList;
import java.util.List;


/**
 * Sous-class PartiDeDroite qui herite Parti.
 * Ajoute une liste de Depute au parti.
 * 
 * @author jason pang
 * @since 11/07/2018
 * @version 1.0.2
 */
public class PartiDeDroite extends Parti
{
	//Liste des supporteurs depute
	List<Depute> listDepute;
	
	/**
	 * Constructeur qui initialise une parti et 
	 * une nouvelle liste de type Depute.
	 * 
	 * @param parti
	 * 
	 * @author jason pang
	 * @since 11/08/2018
	 * @version 1.0.1
	 */
	public PartiDeDroite(String parti)
	{
		super(parti);
		this.listDepute = new ArrayList<Depute>();
	}
	
	/**
	 * Obtenir la categorie du parti. Remplacer la 
	 * méthode getCategorie de la super-classe.
	 * 
	 * @return "Parti de droite"
	 * 
	 * @author jason pang
	 * @since 11/07/2018
	 * @version 1.0.0
	 */
	@Override
	public String getCategorie()
	{
		return super.getCategorie() + " de droite";
	}
	
	/**
	 * Ajouter un Depute a la liste de Depute du parti.
	 * 
	 * @param depute
	 * 
	 * @author jason pang
	 * @since 11/07/2018
	 * @version 1.0.0
	 */
	public void ajouterDepute(Depute depute)
	{
		//Verifier que ce Depute n'est pas deja dans la liste 
		if(this.listDepute.indexOf(depute) == Constantes.VIDE)
		{
			this.listDepute.add(depute);
		}
	}
	
	/**
	 * Obtenir tout les Deputes dans la liste de Depute
	 * 
	 * @return tabDepute
	 * 
	 * @author jason pang
	 * @since 11/07/2018
	 * @version 1.0.1
	 */
	public Depute[] obtenirTabDepute()
	{
		Depute[] tabDepute = new Depute[this.listDepute.size()];
		tabDepute = this.listDepute.toArray(tabDepute);
		return tabDepute;
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