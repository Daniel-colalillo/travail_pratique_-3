import java.util.ArrayList;
import java.util.List;
//import java.util.Arrays;


public class PartiDeDroite extends Parti
{
	List<Depute> listDepute;
	
	public PartiDeDroite(String parti)
	{
		super(parti);
		this.listDepute = new ArrayList<Depute>();
	}
	@Override
	public String getCategorie()
	{
		return super.getCategorie() + " de droite";
	}
	
	public void ajouterDepute(Depute depute)
	{
		if(this.listDepute.indexOf(depute) == Constantes.VIDE)
		{
			this.listDepute.add(depute);
		}
	}
	
	public Depute[] obtenirTabDepute()
	{
		Depute[] tabDepute = new Depute[this.listDepute.size()];
		tabDepute = this.listDepute.toArray(tabDepute);
		return tabDepute;
	}
	@Override
	public String toString()
	{
		return super.toString()+ " " +this.getCategorie();
	}
}