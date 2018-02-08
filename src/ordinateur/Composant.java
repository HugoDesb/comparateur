package ordinateur;

/**
 * Classe qui décrit un composant d'un ordinateur
 * @author Alexandre Monnot - alexandre.monnot@etu.univ-amu.fr - & Vincent Paoli - vincent.paoli.1@etu.univ-amu.fr -
 */
public class Composant {

    /**
     * Reference unique d'un composant
     */
	protected String reference;
	
    /**
     * Prix du composant
     */
	protected double prix;
		
    /**
     * Constructeur par defaut d'un composant
     */
	public Composant(){
		this.reference = null;
		prix = 0;
	}
		
    /**
     * Constructeur d'un composant
     * @param reference Reference d'un composant
     * @param prix Prix d'un composant
     */
	public Composant(String reference, double prix){
		this.reference = reference;
		this.prix = prix;
	}

    /**
     * Renvoie la reference d'un comopsant
     * @return La reference d'un composant
     */
	public String getReference() {
		return reference;
	}
	
    /**
     * Renvoie le prix d'un comopsant
     * @return Le prix d'un composant
     */
	public double getPrix(){
		return prix;
	}
	
    /**
     * Renvoie un tableau de l'ensemble des caracteristiques d'un composant (reference + prix)
     * @return Un tableau de l'ensemble des caracteristiques d'un composant (reference + prix)
     */
	public Object[] toArray(){
		Object[] array = new Object[]{reference, prix};
		return array;
	}
		
    /**
     * Renvoie une representation de l'objet composant sous la forme "Composant : {reference, prix}"
     * @return Une chaine de caractère caractérisant le composant
     */
	@Override
	public String toString(){
		String string = "Composant : {";
		for(Object o : this.toArray()){
			string += o + ", ";
		}
		return string.substring(0, string.length() - 2) + "}";
	}
	
}
