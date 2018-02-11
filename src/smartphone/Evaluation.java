package ordinateur;

import java.util.TreeMap;

/**
 * Classe qui evalue un ordinateur
 * @author Alexandre Monnot - alexandre.monnot@etu.univ-amu.fr - & Vincent Paoli - vincent.paoli.1@etu.univ-amu.fr -
 */
public class Evaluation {

	/**
	 * Constante definissant le nombre de resultats minimun a afficher
	 */
	public final int NB_RESULTATS = 10;

	/**
	 * Constante utilisee pour determiner sur une echelle de 0 a 1 si
	 * un ordinateur correspond aux criteres de l'utilisateur
	 */
	public final Double EXIGENCE = 0.65;

	/**
	 * Objet de connexion a la base de donnees
	 */
	private Db db;
	
	/**
	 * Evaluation maximale d'une carte graphique
	 */
	private double evalCarteGraphique = 1.0;
		
	/**
	 * Evaluation maximale d'un processeur
	 */
	private double evalCpu = 1.0;
		
	/**
	 * Evaluation maximale d'un disque dur
	 */
	private double evalDisqueDur = 1.0;
		
	/**
	 * Evaluation maximale d'une ram
	 */
	private double evalRam = 1.0;
		
	/**
	 * Reponse a la question 1
	 */
	private int utilisation;
			
	/**
	 * Reponse a la question 2
	 */
	private int jouer;
			
	/**
	 * Reponse a la question 3
	 */
	private int autonomie;
			
	/**
	 * Reponse a la question 4
	 */
	private int stockage;
			
	/**
	 * Reponse a la question 5
	 */
	private int rapidite;
			
	/**
	 * Reponse a la question 6
	 */
	private int applications;
			
	/**
	 * Reponse a la question 7
	 */
	private int preference;

    		
	/**
	 * Constructeur d'un objet evaluation
	 * @param db Base de donnees
	 * @param q1 Reponse a la question 1
	 * @param q2 Reponse a la question 2
	 * @param q3 Reponse a la question 3
	 * @param q4 Reponse a la question 4
	 * @param q5 Reponse a la question 5
	 * @param q6 Reponse a la question 6
	 * @param q7 Reponse a la question 7
	 */
	public Evaluation(Db db, int q1, int q2, int q3, int q4, int q5, int q6, int q7) {
	    
		// recupere les reponses de chaque question
		this.db = db;
		this.utilisation = q1;
		this.jouer = q2;
		this.autonomie = q3;
		this.stockage = q4;
		this.rapidite = q5;
		this.applications = q6;
		this.preference = q7;
		
		//on recupere les eval max (pour normer)
		this.evalCarteGraphique = evalMaxCarteGraphique();
		this.evalCpu = evalMaxCpu();
		this.evalDisqueDur = evalMaxDisqueDur();
		this.evalRam = evalMaxRam();
	}
    		
	/**
	 * Renvoie la meilleure evaluation parmi les cartes graphiques
	 * @return La meilleure evaluation parmi les cartes graphiques
	 */
    public double evalMaxCarteGraphique(){
		
		double evalCourant = 0;
		double evalMax = 0;
		
		// On parcourt la BD
		for(TreeMap<String, String> row : db.getRowsFrom("carte_graphique")){
			CarteGraphique carteGraphique = new CarteGraphique(db, row.get("reference"));
			evalCourant = evaluer(carteGraphique);
			if(evalCourant > evalMax)
				evalMax = evalCourant;
		}
		
		return evalMax;
		
	}
    		
	/**
	 * Renvoie la meilleure evaluation parmi les processeurs
	 * @return La meilleure evaluation parmi les processeurs
	 */
    public double evalMaxCpu(){
    	
    	double evalCourant = 0;
    	double evalMax = 0;
    	
    	// On parcourt la BD
    	for(TreeMap<String, String> row : db.getRowsFrom("cpu")){
    		Cpu cpu = new Cpu(db, row.get("reference"));
    		evalCourant = evaluer(cpu);
    		if(evalCourant > evalMax)
    			evalMax = evalCourant;
    	}
    	
    	return evalMax;
    	
    }
        		
	/**
	 * Renvoie la meilleure evaluation parmi les disques durs
	 * @return La meilleure evaluation parmi les disques durs
	 */
    public double evalMaxDisqueDur(){
    	
    	double evalCourant = 0;
    	double evalMax = 0;
    	
    	// On parcourt la BD
    	for(TreeMap<String, String> row : db.getRowsFrom("disque_dur")){
    		DisqueDur dd = new DisqueDur(db, row.get("reference"));
    		evalCourant = evaluer(dd);
    		if(evalCourant > evalMax)
    			evalMax = evalCourant;
    	}
    	
    	return evalMax;
    	
    }
            		
	/**
	 * Renvoie la meilleure evaluation parmi les ram
	 * @return La meilleure evaluation parmi les ram
	 */
    public double evalMaxRam(){
    	
    	double evalCourant = 0;
    	double evalMax = 0;
    	
    	// On parcourt la BD
    	for(TreeMap<String, String> row : db.getRowsFrom("ram")){
    		Ram ram = new Ram(db, row.get("reference"));
    		evalCourant = evaluer(ram);
    		if(evalCourant > evalMax)
    			evalMax = evalCourant;
    	}
    	
    	return evalMax;
    	
    }
        		
	/**
	 * Renvoie l'evaluation d'un ordinateur en fonction de sa correpondance par rapport aux questions posee
	 * L'evaluation retourne une valeur entre 0 et 1 (1 pour la plus grande correspondance)
	 * @param ordi Ordinateur a evaluer
	 * @return L'evaluation d'un ordinateur
	 */
	public double evaluer(Ordinateur ordi) {
		
		double evalCarteGraphique = evaluer(ordi.getCarteGraphique());
		double evalCpu = evaluer(ordi.getCpu());
		double evalDisqueDur = evaluer(ordi.getDisqueDur());
		double evalRam = evaluer(ordi.getRam());

		double pointsMax = 0;
		double pointsMax1;
		double pointsMax2;
		double pointsMax3;
		double pointsMax4;
		double pointsMax6;
		double pointsMax7;
		
		// question 1
		double points1;
		//si reponse = exigeante
		if (utilisation == 2) {
			points1 = evalCarteGraphique * 6 + evalCpu * 4;
			pointsMax1 = 10;
		//si reponse = polyvalente
		} else if (utilisation == 1) {
			points1 = evalCarteGraphique * 4 + evalCpu * 2;
			pointsMax1 = 6;
		//si reponse = basique
		} else {
			points1 = evalCarteGraphique + evalCpu;
			pointsMax1 = 2;
		}
		pointsMax += pointsMax1;

		// question 2
		double points2;
		if (jouer == 3) {
			points2 = evalCarteGraphique * 7 + evalCpu * 3;
			pointsMax2 = 10;
		} else if (jouer == 2) {
			points2 = evalCarteGraphique * 4 + evalCpu * 3;
			pointsMax2 = 7;
		} else if (jouer == 1) {
			points2 = evalCarteGraphique * 2 + evalCpu * 2;
			pointsMax2 = 4;
		} else {
			points2 = evalCarteGraphique  + evalCpu ;
			pointsMax2 = 2;
		}
		pointsMax += pointsMax2;

		// question 3
		double points3;
		if (autonomie == 3) {
			points3 = 10 * (1 - (0.7 * evalCarteGraphique + 0.3 * evalCpu)) ;
			pointsMax3 = 10;
		} else if (autonomie == 2) {
			points3 = 7 * (1 - (0.7 * evalCarteGraphique + 0.3 * evalCpu)) ;
			pointsMax3 = 7;
		} else if (autonomie == 1) {
			points3 = 3 * (1 - (0.7 * evalCarteGraphique + 0.3 * evalCpu)) ;
			pointsMax3 = 3;
		} else {
			points3 = 1 - (0.7 * evalCarteGraphique + 0.3 * evalCpu) ;
			pointsMax3 = 1;
		}
		pointsMax += pointsMax3;
		
		// question 4
		double points4;
		if (stockage == 2) {
			points4 = 10 * evalDisqueDur;
			pointsMax4 = 10;
		} else if (stockage == 1) {
			points4 = 5 * evalDisqueDur;
			pointsMax4 = 5;
		} else {
			points4 =  evalDisqueDur;
			pointsMax4 = 1;
		}
		pointsMax += pointsMax4;
		
		// question 6
		double points6;
		if (applications == 2) {
			points6 = 10 * evalRam;
			pointsMax6 = 10;
		} else if (applications == 1) {
			points6 = 5 * evalRam;
			pointsMax6 = 5;
		} else {
			points6 = evalRam;
			pointsMax6 = 1;
		}
		pointsMax += pointsMax6;
				
		// question 7
		double points7;
		//bonne performance
		if (preference == 1) {
			points7 = (points1 + points2) / 2 ;
			pointsMax7 = (pointsMax1 + pointsMax2) / 2  ;
		//bonne autonomie
		} else {
			points7 = points3;
			pointsMax7 = pointsMax3;
		}
		pointsMax += pointsMax7;

		double pointsFinaux = points1 + points2 + points3 + points4 + points6 + points7;
		
		//On norme entre 0 et 1 avec pointsMax
		return pointsFinaux / pointsMax;
	}

    /**
	 * Renvoie l'evaluation d'une carte graphique
	 * 0 correspond a un composant privilegiant l'autonomie plutot que la performance
	 * 1 correspond a un composant privilegiant la performance plutot que l'autonomie
	 * @return l'evaluation de la carte graphique comprise entre 0 et 1
	 */
	public double evaluer(CarteGraphique cg) {
	
		double res;
		res = (cg.getFrequence() +Math.sqrt(cg.getMemoire()) );
		return res / evalCarteGraphique;
	}

    /**
	 * Renvoie l'evaluation d'un cpu
	 * 0 correspond a un composant privilegiant l'autonomie plutot que la performance
	 * 1 correspond a un composant privilegiant la performance plutot que l'autonomie
	 * @return l'evaluation de la cpu comprise entre 0 et 1
	 */
	public double evaluer(Cpu cpu) {

		double res;
		
		double coeur = 0;
		switch (cpu.getCoeur()) {
		case "I3":
			coeur = 2;
			break;

		case "I5":
			coeur = 4;
			break;

		case "I7":
			coeur = 7;
			break;
		}
		
		res = (cpu.getFrequence() + coeur );
		return res / evalCpu;
	}
	
    /**
	 * Renvoie l'evaluation d'un disque dur
	 * 0 correspond a un composant privilegiant l'autonomie plutot que la performance
	 * 1 correspond a un composant privilegiant la performance plutot que l'autonomie
	 * Cette evaluation tiens compte d'un des criteres du formulaire a savoir le demarrage rapide du systeme
	 * @return l'evaluation de la ram comprise entre 0 et 1
	 */
	public double evaluer(DisqueDur dd) {
	
		double res;
		
		//L'utilisateur veut un demarrage rapide
		if(rapidite == 1){
			//SSD
			if(dd.getType().equals("SSD")){
				res = dd.getCapacite() * 10;
			//HDD
			}else{
				res = dd.getCapacite() + dd.getVitesseRotation() / 7;
			}
		//l'utilisateur se moque de la rapidite
		}else{
				res = dd.getCapacite() + dd.getVitesseRotation() / 100;
		}
	
		return  res / evalDisqueDur;
	}

    /**
	 * Renvoie l'evaluation d'une ram
	 * 0 correspond a un composant privilegiant l'autonomie plutot que la performance
	 * 1 correspond a un composant privilegiant la performance plutot que l'autonomie
	 * @return l'evaluation de la ram comprise entre 0 et 1
	 */
	public double evaluer(Ram ram) {

        double res;
		
		double type = 0;
		switch (ram.getType()) {
		case "DDR3":
			type = 3;
			break;

		case "DDR4":
			type = 4;
			break;

		}
		
		res = ram.getFrequence() / 500 + ram.getCapacite() + type;
		return res / evalRam;
	}
}
