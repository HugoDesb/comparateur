package ordinateur;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.stream.Stream;

/**
 * Classe qui décrit le composant disque dur d'un ordinateur
 * @author Alexandre Monnot - alexandre.monnot@etu.univ-amu.fr - & Vincent Paoli - vincent.paoli.1@etu.univ-amu.fr -
 */
public class DisqueDur extends Composant{
	
	/**
	 * Capacite du disque dur en Mo
	 */
	private int capacite;
	
	/**
	 * Type de disque dur (HDD ou SSD)
	 */
	private String type;
	
	/**
	 * Vitesse de rotation du disque dur (inutile dans le cas d'un type SSD) en RPM
	 */
	private int vitesseRotation;

    /**
	 * Constructeur par hydratation de disque dur
	 * @param db Objet de connexion a la base de donnee
	 * @param ref Reference unique du disque dur
	 */
	public DisqueDur(Db db, String ref){
		TreeMap<String, String> row = db.getRowFromQuery("SELECT * FROM disque_dur WHERE reference='" + ref + "';");
		reference = row.get("reference");
		prix = Double.parseDouble(row.get("prix"));
		capacite = Integer.parseInt(row.get("capacite"));
		type = row.get("type");
		vitesseRotation = Integer.parseInt(row.get("vitesse_rotation"));
	}

    /**
	 * Constructeur d'un objet disque dur
	 * @param reference Reference unique du disque dur
	 * @param prix Prix de la carte graphique en euros
	 * @param capacite Capacite du disque dur
	 * @param type Type de disque dur (HDD ou SSD)
	 * @param vitesseRotation La vitesse de rotation du disque dur (inutile dans le cas d'un type SSD)
	 */
	public DisqueDur(String reference, double prix, int capacite, String type, int vitesseRotation) {
		super(reference, prix);
		this.capacite = capacite;
		this.type = type;
		this.vitesseRotation = vitesseRotation;
	}
	
	/**
     * Renvoie la capacite du disque dur
     * @return La capacite du disque dur
     */
	public int getCapacite() {
		return capacite;
	}

    /**
     * Renvoie le type du disque dur
     * @return Le type du disque dur
     */
	public String getType() {
		return type;
	}

	/**
     * Renvoie la vitesse de rotation du disque dur
     * @return La vitesse de rotation du disque dur
     */
	public int getVitesseRotation() {
		return vitesseRotation;
	}
	
	/**
	 * Renvoie un tableau de l'ensemble des caracteristiques du disque dur (caracteristiques + prix)
	 * @return Un tableau de l'ensemble des caracteristiques du disque dur (caracteristiques + prix)
	 */
	@Override
	public Object[] toArray(){
		Object[] array1 = super.toArray();
		Object[] array2 = new Object[]{capacite, type, vitesseRotation};
		Object[] newArray = Stream.concat(Arrays.stream(array1), Arrays.stream(array2)).toArray(Object[]::new);
		return newArray;
	}
	
	/**
	 * Renvoie une representation de l'objet disque dur sous la forme "DisqueDur : {reference, prix, capacite, type, vitesseRotation}"
	 * @return Une chaine de caractère caractérisant le disque dur
	 */
	@Override
	public String toString(){
		String string = "DisqueDur : {";
		for(Object o : this.toArray()){
			string += o + ", ";
		}
		return string.substring(0, string.length() - 2) + "}";
	}

}
