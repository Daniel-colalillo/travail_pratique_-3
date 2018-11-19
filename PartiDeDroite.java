import java.util.ArrayList;
import java.util.List;
//import java.util.Arrays;


public class PartiDeDroite extends Parti
{
	List<Depute> listDepute;
	
	public PartiDeDroite()
	{
		this.listDepute = new ArrayList<Depute>();
	}
	
	public String getCategorie()
	{
		return super.getCategorie() + " de droite ";
	}
	
	public void ajouterDepute(Depute depute)
	{
		if(this.listDepute.indexOf(depute) == -1)
		{
			this.listDepute.add(depute);
		}
	}
	
	public String[] obtenirTabDepute()
	{
		String[] tabDepute = new String[this.listDepute.size()];
		tabDepute = this.listDepute.toArray(tabDepute);
		return tabDepute;
	}
}