package smartphone;


import java.util.Map;
import java.util.TreeMap;

import ordinateur.Composant;

/**
 * Classe qui decrit un smartphone
 * @author Esteban GOBERT - esteban.gobert@etu.univ-amu.fr - & Hugo DESBIOLLES - hugo.desbiolles@etu.univ-amu.fr -
 */
 
public class Smartphone {

    /**
     * Collection des composants d'un smartphone
     */
	private TreeMap<String, Composant> composants;
	
    /**
     * Prix du smartphone
     */
	private double prix;

    /**
     * Constructeur d'un objet smartphone
     * @param ecran Objet ecran du smartphone
     * @param processeur Objet processeur du smartphone
     * @param batterie Objet batterie du smartphone
     * @param appareilPhoto Objet appareil photo du smartphone
     */
	public Smartphone(double prix, Ecran ecran, Processeur processeur,
			Batterie batterie, AppareilPhoto appareilPhoto) {
		this.prix = prix;
		composants = new TreeMap<String, Composant>();
		composants.put("ecran", ecran);
		composants.put("processeur", processeur);
		composants.put("batterie", batterie);
		composants.put("appareilPhoto", appareilPhoto);
	}
	
	/**
     * Renvoie l'�cran du smartphone
     * @return L'objet �cran du smartphone
     */
	public Ecran getEcran() {
		return (Ecran)composants.get("ecran");
	}

    /**
     * Renvoie le processeur du smartphone
     * @return L'objet processeur du smartphone
     */
	public Processeur getProcesseur() {
		return (Processeur)composants.get("processeur");
	}

    /**
     * Renvoie la batterie du smartphone
     * @return L'objet batterie du smartphone
     */
	public Batterie getBatterie() {
		return (Batterie)composants.get("batterie");
	}

    /**
     * Renvoie l'appareilPhoto du smartphone
     * @return L'objet appareilPhoto du smartphone
     */
	public AppareilPhoto getAppareilPhoto() {
		return (AppareilPhoto)composants.get("appareilPhoto");
	}

    /**
     * Renvoie le prix du smartphone
     * @return Le prix de smartphone
     */
	public double getPrix() {
		return prix;
	}

    /**
     * Renvoie un tableau de l'ensemble des caracteristiques d'un smartphone (composants + prix)
     * @return Un tableau de l'ensemble des caracteristiques d'un smartphone (composants + prix)
     */
	public Object[] toArray() {
		
		Object[] array = new Object[composants.size() + 1];
		
		int i = 0;
		for (Map.Entry<String, Composant> composant : composants.entrySet()) {
			array[i] = composant.getValue().getReference();
			i++;
		}
		array[i] = prix;
		
		return array;
	}
	
    /**
     * Renvoie une representation de l'objet smartphone sous la forme "Smartphone : {composant 1 , composant 2 ... , prix)"
     * @return Une representation de l'objet smartphone sous la forme "Smartphone : {composant 1 , composant 2 ... , prix)"
     */
	@Override
	public String toString(){
		String string = "Smartphone : {";
		for(Object o : this.toArray()){
			string += o + ", ";
		}
		return string.substring(0, string.length() - 2) + "}";
	}

}
