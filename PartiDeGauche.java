import java.util.ArrayList;
import java.util.List;
//import java.util.Arrays;


public class PartiDeGauche extends Parti
{
	List<String> listOBNL;
	
	public PartiDeGauche(String parti)
	{
		super(parti);
		this.listOBNL = new ArrayList<String>();
	}
	
	public String getCategorieDeGauche()
	{
		return super.getCategorie() + " de gauche";
	}
	
	public void ajouterOBNL(String nomOBNL)
	{
		if(this.listOBNL.indexOf(nomOBNL) == Constantes.VIDE)
		{
			this.listOBNL.add(new String(nomOBNL));
		}
	}
	
	public String[] obtenirTabOBNL()
	{
		String[] tabOBNL = new String[this.listOBNL.size()];
		tabOBNL = this.listOBNL.toArray(tabOBNL);
		return tabOBNL;
	}
}