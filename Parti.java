/**
 * Super classe Parti contien le nom du parti.
 *
 *@author jason pang
 *@since 11/06/2018
 *@version 1.0.2
 */
 
public class Parti
{
	//Nom du parti
	private String Parti;
	
	/**
	 * Constructeur defaut (parti vide)
	 * 
	 * @author jason pang
	 * @since 11/06/2018
	 * @version 1.0.0
	 */
	public Parti()
	{
		this.Parti = "";
	}
	
	/**
	 * Construteur avec le nom du parti
	 * 
	 * @param parti, nom du parti type String
	 * 
	 * @author jason pang
	 * @since 11/06/2018
	 * @version 1.0.0
	 */
	public Parti(String parti)
	{
		this.Parti = parti;
	}
	
	/**
	 * Contructeur qui cree une parti avec les meme valeur d'une autre parti
	 * 
	 * @param parti, objet du type parti
	 * 
	 * @author jason pang
	 * @since 11/06/2018
	 * @version 1.0.0
	 */
	public Parti(Parti parti)
	{
		this.Parti = parti.getParti();
	}
	
	/**
	 * Obtenir le nom du parti.
	 * 
	 * @return Parti, nom du parti
	 * 
	 * @author jason pang
	 * @since 11/06/2018
	 * @version 1.0.0
	 */
	public String getParti()
	{
		return Parti;
	}
	
	/**
	 * Definir le nom du parti
	 * 
	 * @param parti, nom du parti type String
	 * 
	 * @author jason pang
	 * @since 11/06/2018
	 * @version 1.0.0
	 */
	public void setParti(String parti)
	{
		this.Parti = parti;
	}
	
	/**
	 * Convertir cet parti en String.
	 * 
	 * @return parti en String
	 * 
	 * @author jason pang
	 * @since 11/06/2018
	 * @version 1.0.0
	 */
	public String toString()
	{
		return this.Parti;
	}
	
	/**
	 * Cloner cet objet dans un autre objet.
	 * 
	 * @param parti, type objet Parti
	 * 
	 * @author jason pang
	 * @since 11/06/2018
	 * @version 1.0.0
	 */
	public void cloneParti(Parti parti)
	{
		parti.setParti(this.Parti);
	}
	
	/**
	 * Verifier si une parti est egaux a cet parti
	 * 
	 * @param parti
	 * @return vrai or faux
	 * 
	 * @author jason pang
	 * @since 11/06/2018
	 * @version 1.0.1
	 */
	public boolean equals(Parti parti)
	{
		return this.Parti.equals(parti.getParti());
	}
	
	/**
	 * Retourne le categorie du parti.
	 * 
	 * @return "Parti"
	 * 
	 * @author jason pang
	 * @since 11/07/2018
	 * @1.0.0
	 */
	public String getCategorie()
	{
		return "Parti";
	}
}