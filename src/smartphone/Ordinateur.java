package ordinateur;

import java.util.Map;
import java.util.TreeMap;

/**
 * Classe qui decrit un ordinateur
 * @author Alexandre Monnot - alexandre.monnot@etu.univ-amu.fr - & Vincent Paoli - vincent.paoli.1@etu.univ-amu.fr -
 */
 
public class Ordinateur {

    /**
     * Collection des composants d'un ordinateur
     */
	private TreeMap<String, Composant> composants;
	
    /**
     * Prix de l'ordinateur
     */
	private double prix;

    /**
     * Constructeur d'un objet ordinateur
     * @param carteGraphique Objet carte graphique de l'ordinateur
     * @param cpu Objet cpu de l'ordinateur
     * @param disqueDur Objet disque dur de l'ordinateur
     * @param ram Objet ram de l'ordinateur
     */
	public Ordinateur(CarteGraphique carteGraphique, Cpu cpu, DisqueDur disqueDur, Ram ram) {
		composants = new TreeMap<String, Composant>();
		composants.put("carteGraphique", carteGraphique);
		composants.put("cpu", cpu);
		composants.put("disqueDur", disqueDur);
		composants.put("ram", ram);
		
		this.prix = 0;
		for (Map.Entry<String, Composant> composant : composants.entrySet()){
			prix = prix + composant.getValue().getPrix();
		}
			
	}
	
	/**
     * Renvoie la carte graphique de l'ordinateur
     * @return L'objet carte graphique de l'ordinateur
     */
	public CarteGraphique getCarteGraphique() {
		return (CarteGraphique)composants.get("carteGraphique");
	}

    /**
     * Renvoie le processeur de l'ordinateur
     * @return L'objet processeur de l'ordinateur
     */
	public Cpu getCpu() {
		return (Cpu)composants.get("cpu");
	}

    /**
     * Renvoie le disque dur de l'ordinateur
     * @return L'objet disque dur de l'ordinateur
     */
	public DisqueDur getDisqueDur() {
		return (DisqueDur)composants.get("disqueDur");
	}

    /**
     * Renvoie la ram de l'ordinateur
     * @return L'objet ram de l'ordinateur
     */
	public Ram getRam() {
		return (Ram)composants.get("ram");
	}

    /**
     * Renvoie le prix de l'ordinateur
     * @return Le prix de l'ordinateur
     */
	public double getPrix() {
		return prix;
	}

    /**
     * Renvoie un tableau de l'ensemble des caracteristiques d'un ordinateur (composants + prix)
     * @return Un tableau de l'ensemble des caracteristiques d'un ordinateur (composants + prix)
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
     * Renvoie une representation de l'objet ordinateur sous la forme "Ordinateur : {composant 1 , composant 2 ... , prix)"
     * @return Une representation de l'objet ordinateur sous la forme "Ordinateur : {composant 1 , composant 2 ... , prix)"
     */
	@Override
	public String toString(){
		String string = "Ordinateur : {";
		for(Object o : this.toArray()){
			string += o + ", ";
		}
		return string.substring(0, string.length() - 2) + "}";
	}

}
