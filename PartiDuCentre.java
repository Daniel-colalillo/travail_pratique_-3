import java.util.ArrayList;
import java.util.List;
//import java.util.Arrays;


public class PartiDuCentre extends Parti
{
	List<Circonscription> listCirconscription;
	
	public PartiDuCentre(String parti)
	{
		super(parti);
		this.listCirconscription = new ArrayList<Circonscription>();
	}
	@Override
	public String getCategorie()
	{
		return super.getCategorie() + " du centre";
	}
	
	public void ajouterCirconscription(Circonscription circonscription)
	{
		if(this.listCirconscription.indexOf(circonscription) == Constantes.VIDE)
		{
			this.listCirconscription.add(circonscription);
		}
	}
	
	public Circonscription[] obtenirTabCirconscription()
	{
		Circonscription[] tabCirconscription = new Circonscription[this.listCirconscription.size()];
		tabCirconscription = this.listCirconscription.toArray(tabCirconscription);
		return tabCirconscription;
	}
	@Override
	public String toString()
	{
		return super.toString()+ " " +this.getCategorie();
	}
}