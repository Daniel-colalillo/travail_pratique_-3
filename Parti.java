/**
 *
 *
 */
 
public class Parti
{
	private String Parti;
	
	public Parti()
	{
		this.Parti = "";
	}
	
	public Parti(String parti)
	{
		this.Parti = parti;
	}
	
	public Parti(Parti parti)
	{
		this.Parti = parti.getParti();
	}
	
	public String getParti()
	{
		return Parti;
	}
	
	public void setParti(String parti)
	{
		this.Parti = parti;
	}
	
	public String toString()
	{
		return this.Parti;
	}
	
	public void cloneParti(Parti parti)
	{
		parti.setParti(this.Parti);
	}
	
	public boolean equals(Parti parti)
	{
		return this.Parti.equals(parti.getParti());
	}
	
	/**
	 */
	public String getCategorie()
	{
		return "Parti";
	}
}