import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.LinkedList;
import java.util.Arrays;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;

public class Election implements Serializable{
	
	public int annee;
	
	/**
	 * constructeur utilis� pour initialiser une classe en fonction des 
	 * entr�es de l'utilisateur
	 * 
	 * @param int annee
	 * 
	 * @author Daniel Colalillo
	 * @since 10/27/2018
	 * @version 1.0.0
	 */
    public Election(int annee){
    	this.annee = annee;
    }
    /*
     * Collection d'objet
     */
	List<Circonscription> circonscriptionCollection = new ArrayList<Circonscription>();
	
	List<String> nomsCirconscriptionCollection = new ArrayList<String>();
	
	Vector<String> nomsPartiCollection = new Vector<String>();

	List<Depute> deputeCollection = new LinkedList<Depute>();
	
	List<String> nomsDeputeCollection = new ArrayList<String>();
	
	List<Parti> partiCollection = new ArrayList<Parti>();
	
	
	
	int[][] index;

	/**
	 * retourne la taille de la collection depute
	 * 
	 * 
	 * @author Daniel Colalillo
	 * @since 11/6/2018
	 * @version 1.0.0
	 */
public int getNombreDepute(){
	
	return deputeCollection.size();
}

/**
 * retourne la taille de la collection circonscription
 * 
 * 
 * @author Daniel Colalillo
 * @since 11/6/2018
 * @version 1.0.0
 */
public int getNombreCirconscription(){
	
	return circonscriptionCollection.size();
}


/**
 * retourne la taille de la parti collection
 * 
 * 
 * @author Daniel Colalillo
 * @since 11/6/2018
 * @version 1.0.0
 */
public int getnumeroDePartiCollection(){
	
	/*
	 * Strategie:
	 */
	
	return partiCollection.size();
}

	/**
	 * initialise un index
	 * 
	 * @author Daniel Colalillo
	 * @author Jason Pang
	 * @since 10/30/2018
	 * @version 1.0.1
	 */
	public void genererIndex(){
	
		/*
		 * Strategie:
		 * Generer une index 2D avec les tailles des collections
		 * nomsCirconscriptionCollection et nomsPartiCollection.
		 * Initializer les valeurs de l'index a -1(VIDE).
		 * Utiliser le method peuplerIndex() pour remplir les cases
		 * de l'index.
		 */
		index = new int[nomsCirconscriptionCollection.size()][nomsPartiCollection.size()];
		//Remplir tous les cases avec -1.
		for(int[] row: index)
			Arrays.fill(row, Constantes.VIDE);
		
		peuplerIndex(index);
		
	}
	
	/**
	 * Remplir l'index avec les numero des cases des depute associe avec les
	 * partis et circonscriptions.
	 * 
	 * @param index
	 * 
	 * @author Jason Pang
	 * @since 11/1/2018
	 * @version 1.0.1
	 */
	public void peuplerIndex(int[][] index)
	{
		/*
		 * Strategie:
		 * Utiliser un for loop pour remplir l'index avec tout les Deputes.
		 */
		
		// Peupler l'index avec tout les deputes dans la collection des deputes.
		for (int i = 0; i < deputeCollection.size(); i++)
		{
			// Remplir l'index avec le numero de case du Depute.
			String nomDepute = deputeCollection.get(i).getDepute();
			index [deputeCollection.get(i).getNumCase()]
					[deputeCollection.get(i).getNumParti()]
					= nomsDeputeCollection.indexOf(nomDepute);
		}
	}
	
	/**
	 * l�ajoutez � la collection de nomsPartiCollection et retournez la 
	 * position o� il a �t� ajout�.
	 * 
	 * @param le String nom du parti.
	 * 
	 * @return position o� il a �t� ajout� ou trouv� avec int index.
	 * 
	 * @author Daniel Colalillo
	 * @since 10/27/2018
	 * @version 1.0.0
	 */
	public void ajouterParti(Parti parti){
		
		/*
		 * strategie: 
		 * v�rifie si le nom du parti existe en utilisant la m�thode 
		 * .indexOf() puis s'il existe, retourne la position avec un index. 
		 * toutefois, si elle n�existe pas, utilisez la m�thode .add pour 
		 * remplir la Parti collection.
		 * 
		 */
		
		//si le nom ne se trouve pas dans la liste, ajoutez-y
		if(!partiCollection.contains(parti)) partiCollection.add(parti);

	}
	
	
	/**
	 * retourne un tableau du partiCollection
	 * 
	 * @return tableau de particollection
	 * 
	 * @author Daniel Colalillo
	 * @since 11/8/2018
	 * @version 1.0.0
	 */
	public Parti[] retourneTableauParti(){
		
		/*
		 * strategie: 
		 * creer un nouveau parti et rempli le avec particollection.
		 * 
		 */
		
		// creer un nouveau parti et rempli le avec la particollection
		Parti [] Parti = partiCollection.
				toArray(new Parti[partiCollection.size()]);
		
		return Parti;
	}
	
	
	/**
	 * retourne le depute de l'index d'entr�e
	 * 
	 * @param int i
	 * 
	 * @return depute a lindice i
	 * 
	 * @author Daniel Colalillo
	 * @since 11/8/2018
	 * @version 1.0.0
	 */
	public Depute retourneDepute(int i){
		
		/*
		 * strategie: 
		 * retourne le depute d�sir� en utilisant la parametres du fonction
		 * 
		 */
		
	
		return deputeCollection.get(i);
	}
	
	/**
	 * retourne la circonscription avec l'index des param�tres
	 * 
	 * @param int i
	 * 
	 * @return circonscription a lindice i
	 * 
	 * @author Daniel Colalillo
	 * @since 11/8/2018
	 * @version 1.0.0
	 */
	
	public Circonscription obtenirCirconscription(int i){
		
		// si la collection est pas vide retourne la reponse sinon 
		// reoturne null
		return (i < circonscriptionCollection.size())
				?circonscriptionCollection.get(i): null;
	 
	}
	
	
	
	
	/**
	 * l�ajoutez � la collection de nomsCirconscriptionCollection. Vous 
	 * retenez la position o� il a �t� ajout� que vous retournez.
	 * 
	 * @param le String nom et le int num�ro de l��lu.
	 * 
	 * @return position o� il a �t� ajout� avec int index.
	 * 
	 * @author Daniel Colalillo
	 * @since 10/27/2018
	 * @version 1.0.0
	 */
	public int ajouterCirconscription(String nom, int numero){
		
		/*
		 * strategie: 
		 * v�rifie si le nom existe en utilisant la m�thode .indexOf () puis 
		 * s'il existe, retourne la position avec un index. toutefois, si 
		 * elle n�existe pas, utilisez la m�thode .add pour remplir la 
		 * circonscription.
		 * 
		 */
		
		//cherche le nom entr�e et l'insere dans un index
		int index = nomsCirconscriptionCollection.indexOf(nom);
		
		//si le nom ne se trouve pas dans la liste, ajoutez-y
		if(index == -1){
			
			circonscriptionCollection.add(new Circonscription(numero, nom, Constantes.VIDE));  //ajoute dans collection d'objets
			
			nomsCirconscriptionCollection.add(new String(nom));  //ajoute dans collection de noms
			
			//d�finir l'index de la nouvelle conscription comme derni�re place du tableau
			index = circonscriptionCollection.size() - 1;
		}
		
		return index;
		
	}
		
	/**
	 * l�ajoutez � la collection de nomsPartiCollection et retournez la 
	 * position o� il a �t� ajout�.
	 * 
	 * @param le String nom du parti.
	 * 
	 * @return position o� il a �t� ajout� ou trouv� avec int index.
	 * 
	 * @author Daniel Colalillo
	 * @since 10/27/2018
	 * @version 1.0.0
	 */
	public int ajouterNomParti(String nomParti){
		
		/*
		 * strategie: 
		 * v�rifie si le nom du parti existe en utilisant la m�thode 
		 * .indexOf() puis s'il existe, retourne la position avec un index. 
		 * toutefois, si elle n�existe pas, utilisez la m�thode .add pour 
		 * remplir la Parti collection.
		 * 
		 */
	
		//cherche le nom entr�e et l'insere dans un index
		int index = nomsPartiCollection.indexOf(nomParti);
		
		//si le nom ne se trouve pas dans la liste, ajoutez-y
		if(index == -1){
			
			nomsPartiCollection.add(new String(nomParti));
		
			//d�finir l'index de la nouvelle parti comme derni�re place du tableau
			index = nomsPartiCollection.size() - 1;
		}
		
		return index;
	}
	
	/**
	 * l�ajoutez � la collection de debuteCollection et retournez la 
	 * position o� il a �t� ajout�.
	 * 
	 * @param le nom du d�put�, le num�ro de circonscription et le num�ro du parti
	 * 
	 * @return position o� il a �t� ajout� ou trouv� avec int index.
	 * 
	 * @author Daniel Colalillo
	 * @since 10/27/2018
	 * @version 1.0.0
	 */
	
	public void ajouterDepute(int circonscription, String nomDepute, int noParti){
		
		/*
		 * strategie: 
		 * v�rifie si le Depute existe en utilisant la m�thode 
		 * .indexOf() puis s'il existe, retourne la position avec un index. 
		 * toutefois, si elle n�existe pas, utilisez la m�thode .add pour 
		 * remplir la debute collection.
		 * 
		 */
		
		//cherche le nom entr�e et l'insere dans un index
		int index = deputeCollection.indexOf(nomDepute);
		
		//si le nom ne se trouve pas dans la liste, ajoutez-y
		if(index == -1){
			
			deputeCollection.add(new Depute(nomDepute, circonscription, noParti));
		
			nomsDeputeCollection.add(nomDepute);
			
			//d�finir l'index de la nouvelle debute comme derni�re place du tableau
			index = deputeCollection.size() - 1;
		}

	}
	
	/**
	 * Obtient et retourne les noms des consciptions en forme de String array.
	 * 
	 * @return
	 * 
	 * @author Jason Pang
	 * @since 10/30/2018
	 * @version 1.0.0
	 */
	public String[] obtenirNomsCirconscription()
	{
		/*
		 * Strategie:
		 * Creer un nouveau tableau de type String de la taille de 
		 * nomsCirconscriptionCollection. Convertir la liste en tableau
		 * avec la methode toArray().
		 */
		
		// Creer un tableau pour les noms des circonscriptions
		String[] tabNomsCirconsciption = 
				new String[nomsCirconscriptionCollection.size()];
		// Convertir la liste en tableau 
		tabNomsCirconsciption = 
				nomsCirconscriptionCollection.toArray(tabNomsCirconsciption);
		
		return tabNomsCirconsciption;
	}
	
	/**
	 * Obtient et retourne les noms des partis en forme de String aray.
	 * 
	 * @return tabNomsParti
	 * 
	 * @author Jason Pang
	 * @since 10/30/2018
	 * @version 1.0.0
	 */
	public String[] obtenirNomsParti()
	{
		/*
		 * Strategie:
		 * Creer un nouveau tableau de type String de la taille de 
		 * nomsPartiCollection. Convertir la liste en tableau
		 * avec la methode toArray().
		 */
		
		// Creer un tableau pour les noms des partis
		String[] tabNomsParti = new String[nomsPartiCollection.size()];
		// Convertir la liste en tableau 
		tabNomsParti = nomsPartiCollection.toArray(tabNomsParti);
		
		return tabNomsParti;	
	}
	
	/**
	 * Obtient la liste et retourne les noms des deputes en forme de String array.
	 * 
	 * @return tabNomsDepute
	 * 
	 * @author Jason Pang
	 * @since 10/30/2018
	 * @version 1.0.0
	 */
	public String[] obtenirNomsDepute()
	{
		/*
		 * Strategie:
		 * Creer un nouveau tableau de type String de la taille de 
		 * nomsDeputeCollection. Convertir la liste en tableau
		 * avec la methode toArray().
		 */
		
		// Creer un tableau pour les noms des deputes
		String[] tabNomsDepute = new String[nomsDeputeCollection.size()];
		// Convertir la liste en tableau 
		return nomsDeputeCollection.toArray(tabNomsDepute);
			
		//return tabNomsDepute;		
	}
	
	
	/**
	 * Retourne le nom de tous les d�put�s d'un parti en ordre croissant.
            *
	 * @param nomParti Le nom du parti cherch�
	 * @return Un tableau des noms des d�put�s de ce parti
	 */
	public String[]  obtenirNomsDeputesParParti(String nomParti) {
		
		int numParti = nomsPartiCollection.indexOf(nomParti);
		
		List<String> depute = new ArrayList<String>();
		
		for(int i = 0; i < Constantes.NB_CATERGORIES_PARTI; i++){
			
			if(index[numParti][i] != Constantes.VIDE){
				
				depute.add(deputeCollection.get(index[numParti][i]).toString());
			}
		}
		String [] deput = new String [depute.size()];
		
		deput = depute.toArray(deput);
		
		Arrays.sort(deput);
		
		return deput;
	}
	
	
	/**
	 * Retourne le nom de tous les supporteurs d'un parti en ordre croissant.
            *
	 * @param nomParti Le nom du parti cherch�
	 * @return Un tableau des noms des supporteurs de ce parti
	 */
	public String[]  obtenirNomsSupporteursParParti(String nomParti) {
		
int numParti = nomsPartiCollection.indexOf(nomParti);
		
		String[] supporteurs;
		
		if(partiCollection.get(numParti).getCategorie().equals("Parti de gauche") ){
			
			supporteurs = obtenirsupporteurs((PartiDeGauche) partiCollection.get(numParti));
		}
		else if(partiCollection.get(numParti).getCategorie().equals("Parti du centre")){
		   
			supporteurs = obtenirsupporteurs((PartiDuCentre) partiCollection.get(numParti));
		}
		else{
			
			supporteurs = obtenirsupporteurs((PartiDeDroite) partiCollection.get(numParti));
		} 
		Arrays.sort(supporteurs);
		
		return supporteurs;
	}
	
	public String [] obtenirsupporteurs(PartiDuCentre parti){
		
		int max = parti.obtenirTabCirconscription().length;
		
		String [] supporteur = new String [max];
		
		Circonscription[] tableau = parti.obtenirTabCirconscription();
		
		for( int i = 0; i < max; i++){
			
			supporteur[i] = tableau[i].toString();
		}
		return supporteur;	
	}
	
	public String [] obtenirsupporteurs(PartiDeDroite parti){
		
		
		int max = parti.obtenirTabDepute().length;
		
		String [] supporteur = new String [max];
		
		Depute[] tableau = parti.obtenirTabDepute();
		
		for( int i = 0; i < max; i++){
			
			supporteur[i] = tableau[i].toString();
		}
		return supporteur;		
	}
	
	
	public String [] obtenirsupporteurs(PartiDeGauche parti){
		
		int max = parti.obtenirTabOBNL().length;
		
		String [] supporteur = new String [max];
		
		String[] tableau = parti.obtenirTabOBNL();
		
		for( int i = 0; i < max; i++){
			
			supporteur[i] = tableau[i].toString();
		}
		return supporteur;		
	}

}



