import java.util.ArrayList;
import java.util.List;
import java.util.Array;


public class PartiDuCentre extends Parti
{
	List<Circonscription> listCirconscription;
	
	public PartiDuCentre()
	{
		this.listCirconscription = new ArrayList<Circonscription>();
	}
	
	public String getCategorie()
	{
		return super.getCategorie() + " de centre ";
	}
	
	public void ajouterCirconscription(Circonscription circonscription)
	{
		if(this.listCirconscription.indexOf(circonscription))
		{
			this.listCirconscription.add(circonscription);
		}
	}
	
	public String[] obtenirTabCirconscription()
	{
		String[] tabCirconscription = new String[this.listCirconscription.size()];
		tabCirconscription = this.listCirconscription.toArray(tabCirconscription);
		return tabCirconscription;
	}
}