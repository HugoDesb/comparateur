package ordinateur;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.stream.Stream;

/**
 * Classe qui décrit le composant appareil photo d'un smartphone
 * @author Esteban GOBERT - esteban.gobert@etu.univ-amu.fr - & Hugo DESBIOLLES - hugo.desbiolles@etu.univ-amu.fr -
 */

public class AppareilPhoto extends Composant {
	/**
	 * Resolution en Mpx
	 */
	private double resolution;
	
	/**
	 * Ouverture de l'appareil photo
	 */
	private double ouverture;
	
	/**
	 * Constructeur par hydratation d'un appareil photo
	 * @param db Objet de connexion a la base de donnees
	 * @param ref Reference unique de l'appareil photo
	 */
	public AppareilPhoto(Db db, String ref){
		TreeMap<String, String> row = db.getRowFromQuery("SELECT * FROM appareil_photo WHERE reference='" + ref + "';");
		reference = row.get("reference");
		resolution = Double.parseDouble(row.get("resolution"));
		ouverture = Double.parseDouble(row.get("ouverture"));
	}
	
	/**
	 * Constructeur d'un objet appareilPhoto
	 * @param reference unique de l'appareil Photo
	 * @param resolution de l'appareil photo
	 * @param ouverture de l'objectif
	 */
	public AppareilPhoto(String reference, double resolution, double ouverture) {
		super(reference);
		this.resolution = resolution;
		this.ouverture = ouverture;
	}
    
	/**
     * Renvoie la valeur de la resolution
     * @return La resolution
     */
	public double getResolution() {
		return resolution;
	}
	
    /**
     * Renvoie la valeur de l'ouverture
     * @return L'ouverture
     */
	public double getOuverture() {
		return ouverture;
	}
	
	/**
	 * Renvoie un tableau de l'ensemble des caracteristiques de l'appareil photo (caracteristiques)
	 * @return Un tableau de l'ensemble des caracteristiques de l'appareil photo (caracteristiques)
	 */
	@Override
	public Object[] toArray(){
		Object[] array1 = super.toArray();
		Object[] array2 = new Object[]{resolution, ouverture};
		Object[] newArray = Stream.concat(Arrays.stream(array1), Arrays.stream(array2)).toArray(Object[]::new);
		return newArray;
	}
	
	/**
	 * Renvoie une representation de l'objet ecran sous la forme "Appareil Photo : {reference, resolution, ouverture}"
	 * @return Une chaine de caractere décrivant l'écran
	 */
	@Override
	public String toString(){
		String string = "Appareil photo : {";
		for(Object o : this.toArray()){
			string += o + ", ";
		}
		return string.substring(0, string.length() - 2) + "}";
	}

}

