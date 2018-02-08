package ordinateur;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.stream.Stream;

/**
 * Classe qui décrit le composant processeur d'un ordinateur
 * @author Alexandre Monnot - alexandre.monnot@etu.univ-amu.fr - & Vincent Paoli - vincent.paoli.1@etu.univ-amu.fr -
 */
public class Cpu extends Composant{
	
	/**
	 * Frequence d'horloge du processeur de la carte graphique en Mhz
	 */
	private double frequence;

	/**
	 * Gamme du processeur
	 */
	private String coeur;
	
    /**
	 * Constructeur par hydratation d'un processeur'
	 * @param db Objet de connexion a la base de donnees
	 * @param ref Reference unique du processeur
	 */
	public Cpu(Db db, String ref){
		TreeMap<String, String> row = db.getRowFromQuery("SELECT * FROM cpu WHERE reference='" + ref + "';");
		reference = row.get("reference");
		prix = Double.parseDouble(row.get("prix"));
		frequence = Double.parseDouble(row.get("frequence"));
		coeur = row.get("coeur");
	}
	
	/**
	 * Constructeur d'un processeur
	 * @param reference Reference unique du processeur
	 * @param prix Prix du processeur en euros
	 * @param frequence Frequence du processeur du processeur
	 * @param memoire Gamme du processeur
	 */
	public Cpu(String reference, double prix, double frequence, String coeur) {
		super(reference, prix);
		this.frequence = frequence;
		this.coeur = coeur;
	}
	
	/**
	 * Renvoie la frequence du processeur
	 * @return La frequence du processeur
	 */
	public double getFrequence() {
		return frequence;
	}

	
	/**
	 * Renvoie la gamme du processeur
	 * @return La gamme du processeur
	 */
	public String getCoeur() {
		return coeur;
	}
		
	/**
	 * Renvoie un tableau de l'ensemble des caracteristiques du processeur (frequence + gamme)
	 * @return Un tableau de l'ensemble des caracteristiques du processeur (frequence + gamme)
	 */
	@Override
	public Object[] toArray(){
		Object[] array1 = super.toArray();
		Object[] array2 = new Object[]{frequence, coeur};
		Object[] newArray = Stream.concat(Arrays.stream(array1), Arrays.stream(array2)).toArray(Object[]::new);
		return newArray;
	}
		
	/**
	 * Renvoie une representation de l'objet processeur sous la forme "Cpu : {frequence, gamme}"
	 * @return Une chaine de caractère caractérisant le processeur
	 */
	@Override
	public String toString(){
		String string = "Cpu : {";
		for(Object o : this.toArray()){
			string += o + ", ";
		}
		return string.substring(0, string.length() - 2) + "}";
	}
}
