package smartphone;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.stream.Stream;

import ordinateur.Composant;
import ordinateur.Db;

/**
 * Classe qui d�crit le composant ecran d'un smartphone
 * @author Esteban GOBERT - esteban.gobert@etu.univ-amu.fr - & Hugo DESBIOLLES - hugo.desbiolles@etu.univ-amu.fr -
 */

public class Ecran extends Composant {
	
	/**
	 * Type d'�cran
	 */
	private TypeEcran type;
	
	/**
	 * Taille d'�cran en pouces (5.6")
	 */
	private double taille;
	
	/**
	 * R�solution de l'�cran
	 */
	private Resolution resolution;
	
	/**
	 * Constructeur par hydratation d'un �cran
	 * @param db Objet de connexion a la base de donnees
	 * @param ref Reference unique de l'�cran
	 */
	public Ecran(Db db, String ref){
		TreeMap<String, String> row = db.getRowFromQuery("SELECT * FROM ecran WHERE reference='" + ref + "';");
		reference = row.get("reference");
		type = TypeEcran.parseTypeEcran(row.get("type"));
		taille = Double.parseDouble(row.get("taille"));
		resolution = Resolution.parseResolution(row.get("resolution"));
	}
	
	/**
	 * Constructeur d'un objet carte graphique
	 * @param reference Reference unique de la carte graphique 
	 * @param prix Prix de la carte graphique en euros
	 * @param frequence Frequence du GPU de la carte graphique
	 * @param memoire Memoire dedie au GPU de la carte graphique
	 */
	public Ecran(String reference, TypeEcran type, double taille, 
			Resolution resolution) {
		super(reference);
		this.type = type;
		this.taille = taille;
		this.resolution = resolution;
	}
    
	/**
     * Renvoie la valeur du type de l'ecran
     * @return Le type
     */
	public TypeEcran getType() {
		return type;
	}
	
    /**
     * Renvoie la valeur de la taille de l'ecran
     * @return La taille
     */
	public double getTaille() {
		return taille;
	}

    /**
     * Renvoie La valeur de la resolution de l'ecran
     * @return La resolution
     */
	public Resolution getResolution() {
		return resolution;
	}
	
	/**
	 * Renvoie un tableau de l'ensemble des caracteristiques de l'ecran (caracteristiques)
	 * @return Un tableau de l'ensemble des caracteristiques de l'ecran (caracteristiques)
	 */
	@Override
	public Object[] toArray(){
		Object[] array1 = super.toArray();
		Object[] array2 = new Object[]{type, taille, resolution};
		Object[] newArray = Stream.concat(Arrays.stream(array1), Arrays.stream(array2)).toArray(Object[]::new);
		return newArray;
	}
	
	/**
	 * Renvoie une representation de l'objet ecran sous la forme "ecran : {reference, type, taille, resolution}"
	 * @return Une chaine de caractere d�crivant l'�cran
	 */
	@Override
	public String toString(){
		String string = "Ecran : {";
		for(Object o : this.toArray()){
			string += o + ", ";
		}
		return string.substring(0, string.length() - 2) + "}";
	}

}

