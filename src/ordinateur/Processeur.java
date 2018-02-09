package ordinateur;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.stream.Stream;

/**
 * Classe qui decrit le composant processeur d'un smartphone
 * @author Esteban GOBERT - esteban.gobert@etu.univ-amu.fr - & Hugo DESBIOLLES - hugo.desbiolles@etu.univ-amu.fr -
 */
public class Processeur extends Composant{
	
	
	/**
	 * Architecture	du processeur
	 */
	private String architecture;
	
	/**
	 * Frequence d'horloge du processeur du smartphone en Mhz
	 */
	private double frequence;

	/**
	 * Marque du processeur
	 */
	private String marque;
	
	
	
    /**
	 * Constructeur par hydratation d'un processeur'
	 * @param db Objet de connexion a la base de donnees
	 * @param ref Reference unique du processeur
	 */
	public Processeur(Db db, String ref){	
		TreeMap<String, String> row = db.getRowFromQuery("SELECT * FROM processeur WHERE reference='" + ref + "';");
		reference = row.get("reference");
		architecture = row.get("architecture");
		frequence = Double.parseDouble(row.get("frequence"));
		marque = row.get("marque");
	}
	
	/**
	 * Constructeur d'un processeur
	 * @param reference Reference unique du processeur
	 * @param prix Prix du processeur en euros
	 * @param frequence Frequence du processeur du processeur
	 * @param memoire Gamme du processeur
	 */
	public Processeur(String reference,String architecture, double frequence, String marque) {
		super(reference);
		this.architecture = architecture;
		this.frequence = frequence;
		this.marque = marque;
	}
	
	
	/**
	 * Renvoie l'architecture du processeur
	 * @return L'architecture du processeur
	 */
	public String getArchitecture() {
		return architecture;
	}
	
	/**
	 * Renvoie la frequence du processeur
	 * @return La frequence du processeur
	 */
	public double getFrequence() {
		return frequence;
	}

	
	/**
	 * Renvoie la marque du processeur
	 * @return La marque du processeur
	 */
	public String getMarque() {
		return marque;
	}
		
	/**
	 * Renvoie un tableau de l'ensemble des caracteristiques du processeur (architecture + frequence + marque)
	 * @return Un tableau de l'ensemble des caracteristiques du processeur (architecture + frequence + marque)
	 */
	@Override
	public Object[] toArray(){
		Object[] array1 = super.toArray();
		Object[] array2 = new Object[]{architecture, frequence, marque};
		Object[] newArray = Stream.concat(Arrays.stream(array1), Arrays.stream(array2)).toArray(Object[]::new);
		return newArray;
	}
		
	/**
	 * Renvoie une representation de l'objet processeur sous la forme "Processeur : {architecture,frequence,marque}"
	 * @return Une chaine de caractère caractérisant le processeur
	 */
	@Override
	public String toString(){
		String string = "Processeur : {";
		for(Object o : this.toArray()){
			string += o + ", ";
		}
		return string.substring(0, string.length() - 2) + "}";
	}
}

