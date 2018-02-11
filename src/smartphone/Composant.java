package smartphone;

/**
 * Classe qui décrit un composant d'un smartphone
 * @author Alexandre Monnot - alexandre.monnot@etu.univ-amu.fr - & Vincent Paoli - vincent.paoli.1@etu.univ-amu.fr -
 */
public class Composant {

    /**
     * Reference unique d'un composant
     */
	protected String reference;
	
	/**
	 * Origine d'un composant
	 */
	protected Origine origine;
		
    /**
     * Constructeur par defaut d'un composant
     */
	public Composant(){
		this.reference = null;
	}
		
    /**
     * Constructeur d'un composant
     * @param reference Reference d'un composant
     */
	public Composant(String reference){
		this.reference = reference;
	}

    /**
     * Renvoie la reference d'un comopsant
     * @return La reference d'un composant
     */
	public String getReference() {
		return reference;
	}
	
    /**
     * Renvoie un tableau de l'ensemble des caracteristiques d'un composant (reference)
     * @return Un tableau de l'ensemble des caracteristiques d'un composant (reference)
     */
	public Object[] toArray(){
		Object[] array = new Object[]{reference};
		return array;
	}
		
    /**
     * Renvoie une representation de l'objet composant sous la forme "Composant : {reference}"
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
