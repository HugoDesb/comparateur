package ordinateur;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.stream.Stream;

/**
 * Classe qui décrit le composant ram d'un ordinateur
 * @author Alexandre Monnot - alexandre.monnot@etu.univ-amu.fr - & Vincent Paoli - vincent.paoli.1@etu.univ-amu.fr -
 */
public class Ram extends Composant{
	
	/**
	 * Capacite de la ram en Mo
	 */
	private int capacite;
	
	/**
	 * Frequence de fonctionnement de la ram en Mhz
	 */
	private int frequence;
	
	/**
	 * Type de ram (DDR3, DDR4)
	 */
	private String type;
	
    /**
	 * Constructeur par hydratation de ram
	 * @param db Objet de connexion a la base de donnee
	 * @param ref Reference unique de la ram
	 */
	public Ram(Db db, String ref){
		TreeMap<String, String> row = db.getRowFromQuery("SELECT * FROM ram WHERE reference='" + ref + "';");
		reference = row.get("reference");
		prix = Double.parseDouble(row.get("prix"));
		capacite = Integer.parseInt(row.get("capacite"));
		frequence = Integer.parseInt(row.get("frequence"));
		type = row.get("type");
	}

    /**
	 * Constructeur d'un objet ram
	 * @param reference Reference unique de la ram
	 * @param prix Prix de la ram en euros
	 * @param capacite Capacite de la ram
	 * @param frequence Frequence de fonctionnement de la ram
	 * @param type Type de ram (DDR3, DDR4)
	 */
	public Ram(String reference, double prix, int capacite, int frequence, String type) {
		super(reference, prix);
		this.capacite = capacite;
		this.frequence = frequence;
		this.type = type;
	}
	
	/**
     * Renvoie la capacite de la ram
     * @return La capacite de la ram
     */
	public int getCapacite() {
		return capacite;
	}

	/**
     * Renvoie la frequence de la ram
     * @return La frequence de la ram
     */
	public int getFrequence() {
		return frequence;
	}

	/**
     * Renvoie le type de ram
     * @return Le type ram
     */
	public String getType() {
		return type;
	}
	
	/**
	 * Renvoie un tableau de l'ensemble des caracteristiques de la ram (caracteristiques + prix)
	 * @return Un tableau de l'ensemble des caracteristiques de la ram (caracteristiques + prix)
	 */
	@Override
	public Object[] toArray(){
		Object[] array1 = super.toArray();
		Object[] array2 = new Object[]{capacite, frequence, type};
		Object[] newArray = Stream.concat(Arrays.stream(array1), Arrays.stream(array2)).toArray(Object[]::new);
		return newArray;
	}
	
	/**
	 * Renvoie une representation de l'objet ram sous la forme "Ram : {reference, prix, capacite, frequence, type}"
	 * @return Une chaine de caractère caractérisant la ram
	 */
	@Override
	public String toString(){
		String string = "Ram : {";
		for(Object o : this.toArray()){
			string += o + ", ";
		}
		return string.substring(0, string.length() - 2) + "}";
	}

}
