package ordinateur;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.stream.Stream;

/**
 * Classe qui decrit la batterie d'un smartphone
 * @author Esteban GOBERT - esteban.gobert@etu.univ-amu.fr - & Hugo DESBIOLLES - hugo.desbiolles@etu.univ-amu.fr -
 */
public class Batterie extends Composant {
		
	/**
	 * Capacit� de la batterie (en mAh)
	 */
	private int capacite;

	
	
	
    /**
	 * Constructeur par hydratation d'une batterie
	 * @param db Objet de connexion a la base de donnees
	 * @param ref Reference unique de la batterie
	 */
	public Batterie(Db db, String ref){	
		TreeMap<String, String> row = db.getRowFromQuery("SELECT * FROM batterie WHERE reference='" + ref + "';");
		reference = row.get("reference");
		capacite = Integer.parseInt(row.get("capacite"));
	}
	
	/**
	 * Constructeur d'une batterie
	 * @param reference Reference unique de la batterie
	 * @param capacite de la batterie
	 */
	public Batterie(String reference, int capacite) {
		super(reference);
		this.capacite = capacite;
	}

	
	/**
	 * Renvoie la marque de la batterie
	 * @return La marque de la batterie
	 */
	public int getCapacite() {
		return capacite;
	}
		
	/**
	 * Renvoie un tableau de l'ensemble des caracteristiques de la batterie (capacite)
	 * @return Un tableau de l'ensemble des caracteristiques de la batterie (capacite)
	 */
	@Override
	public Object[] toArray(){
		Object[] array1 = super.toArray();
		Object[] array2 = new Object[]{capacite};
		Object[] newArray = Stream.concat(Arrays.stream(array1), Arrays.stream(array2)).toArray(Object[]::new);
		return newArray;
	}
		
	/**
	 * Renvoie une representation de l'objet batterie sous la forme "Batterie : {capacite}"
	 * @return Une chaine de caractère caractérisant la batterie
	 */
	@Override
	public String toString(){
		String string = "Batterie : {";
		for(Object o : this.toArray()){
			string += o + ", ";
		}
		return string.substring(0, string.length() - 2) + "}";
	}
	


}
