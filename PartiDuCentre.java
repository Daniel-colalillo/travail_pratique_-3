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
	
	public String getCategorie()
	{
		return super.getCategorie() + " de centre ";
	}
	
	public void ajouterCirconscription(Circonscription circonscription)
	{
		if(this.listCirconscription.indexOf(circonscription) == -1)
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