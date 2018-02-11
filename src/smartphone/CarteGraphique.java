package ordinateur;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.stream.Stream;

/**
 * Classe qui décrit le composant carte graphique d'un ordinateur
 * @author Alexandre Monnot - alexandre.monnot@etu.univ-amu.fr - & Vincent Paoli - vincent.paoli.1@etu.univ-amu.fr -
 */
public class CarteGraphique extends Composant{
	
	/**
	 * Frequence d'horloge du GPU de la carte graphique en Mhz
	 */
	private int frequence;
	
	/**
	 * Capacite memoire dedie au GPU en Mo
	 */
	private int memoire;
	
	/**
	 * Constructeur par hydratation d'une carte graphique
	 * @param db Objet de connexion a la base de donnees
	 * @param ref Reference unique de la carte graphique
	 */
	public CarteGraphique(Db db, String ref){
		TreeMap<String, String> row = db.getRowFromQuery("SELECT * FROM carte_graphique WHERE reference='" + ref + "';");
		reference = row.get("reference");
		prix = Double.parseDouble(row.get("prix"));
		frequence = Integer.parseInt(row.get("frequence"));
		memoire = Integer.parseInt(row.get("memoire"));
	}
	
	/**
	 * Constructeur d'un objet carte graphique
	 * @param reference Reference unique de la carte graphique 
	 * @param prix Prix de la carte graphique en euros
	 * @param frequence Frequence du GPU de la carte graphique
	 * @param memoire Memoire dedie au GPU de la carte graphique
	 */
	public CarteGraphique(String reference, double prix, int frequence, int memoire) {
		super(reference, prix);
		this.frequence = frequence;
		this.memoire = memoire;
	}
    
    /**
     * Renvoie la valeur de la frequence de la carte graphique
     * @return La frequence de la carte graphique
     */
	public int getFrequence() {
		return frequence;
	}

    /**
     * Renvoie La valeur de la memoire de la carte graphique
     * @return La memoire de la carte graphique
     */
	public int getMemoire() {
		return memoire;
	}
	
	/**
	 * Renvoie un tableau de l'ensemble des caracteristiques de la carte graphique (caracteristiques + prix)
	 * @return Un tableau de l'ensemble des caracteristiques de la carte graphique (caracteristiques + prix)
	 */
	@Override
	public Object[] toArray(){
		Object[] array1 = super.toArray();
		Object[] array2 = new Object[]{frequence, memoire};
		Object[] newArray = Stream.concat(Arrays.stream(array1), Arrays.stream(array2)).toArray(Object[]::new);
		return newArray;
	}
	
	/**
	 * Renvoie une representation de l'objet carte graphique sous la forme "CarteGraphique : {reference, prix, frequence, memoire}"
	 * @return Une chaine de caractère caractérisant la carte graphique
	 */
	@Override
	public String toString(){
		String string = "CarteGraphique : {";
		for(Object o : this.toArray()){
			string += o + ", ";
		}
		return string.substring(0, string.length() - 2) + "}";
	}

}

