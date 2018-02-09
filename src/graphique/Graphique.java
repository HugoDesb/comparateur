package graphique;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JTabbedPane;

/**
 * Classe gerant les composants graphiques
 * 
 */
@SuppressWarnings("serial")
public class Graphique extends JFrame {

	/**
	 * Rattache les differents onglets 
	 */
	protected JTabbedPane tabbedPane;
	
    /**
     * Onglet d'authentification
     */
	private TabAuthentifier tabAuthentifier;
	
	/**
	 * Onglet pour ajouter une offre 
	 */
	private TabAjoutOffre tabAjoutOffre;
	
	/**
	 * Onglet pour ajouter une reference
	 */
	private TabAjoutComposant tabAjoutReference;
	
	/**
	 * Onglet pour consulter les offres
	 */
	private TabListeOffre tabListeOffre;
	
	/**
	 * Onglet pour rechercher des offres
	 */
	private TabRecherche tabRecherche;
	
	/**
	 * Onglet de deconnexion (retour a la page d'acccueil)
	 */
	private TabDisconnect tabDisconnect;

	/**
	 * Constructeur de la fenetre graphique
	 */
	public Graphique() {
		
		setTitle("Comparateur de smartphones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		double largeur = dim.width;
		double hauteur = dim.height;
		setBounds((int) (0.08 * largeur), (int) (0.08 * hauteur), (int) (0.8 * largeur), (int) (0.8 * hauteur));
		getContentPane().setLayout(new BorderLayout(0, 0));
		setIconImage(new ImageIcon(this.getClass().getResource("/images/icone.png")).getImage());

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.NORTH);


		
		this.addTabAuthentifier();

	}
	
	/**
	 * Renvoie la structure qui raccroche les onglets entre eux
	 * @return La structure qui raccroche les onglets entre eux
	 */
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	/**
	 * Renvoie l'onglet d'authentification
	 * @return L'onglet d'authentification
	 */
	public TabAuthentifier getTabAuthentifier() {
		return tabAuthentifier;
	}

	/**
	 * Renvoie l'onglet pour ajouter une offre
	 * @return L'onglet pour ajouter une offre
	 */
	public TabAjoutOffre getTabAjoutOffre() {
		return tabAjoutOffre;
	}

	/**
	 * Renvoie l'onglet pour ajouter une reference
	 * @return L'onglet pour ajouter une reference
	 */
	public TabAjoutComposant getTabAjoutReference() {
		return tabAjoutReference;
	}

	/**
	 * Renvoie l'onglet pour consulter les offres
	 * @return L'onglet pour consulter les offres
	 */
	public TabListeOffre getTabListeOffre() {
		return tabListeOffre;
	}

	/**
	 * Renvoie l'onglet pour rechercher des offres
	 * @return L'onglet pour rechercher des offres
	 */
	public TabRecherche getTabRecherche() {
		return tabRecherche;
	}

	/**
	 * Renvoie l'onglet pour se deconnecter
	 * @return L'onglet pour se deconnecter
	 */
	public TabDisconnect getTabDisconnect() {
		return tabDisconnect;
	}
	
	/**
	 * Ajoute l'onglet pour s'authentifier a la structure d'onglets
	 */
	public void addTabAuthentifier(){
		tabAuthentifier = new TabAuthentifier();
		tabbedPane.addTab("Authentification", new ImageIcon(this.getClass().getResource("/images/iconeAuthentifier.png")), tabAuthentifier, "S'authentifier");
	}
	
	/**
	 * Ajoute l'onglet pour ajouter une offre a la structure d'onglets
	 */
	public void addTabAjoutOffre(){
		tabAjoutOffre = new TabAjoutOffre();
		tabbedPane.addTab("Ajouter une offre", new ImageIcon(this.getClass().getResource("/images/iconeOrdi.png")), tabAjoutOffre, "Ajouter un ordinateur parmis les offres deja existantes");
	}
	
	/**
	 * Ajoute l'onglet pour ajouter une reference a la structure d'onglets
	 */
	public void addTabAjoutReference(){
		tabAjoutReference = new TabAjoutComposant();
		tabbedPane.addTab("Ajouter une reference",  new ImageIcon(this.getClass().getResource("/images/iconeComp.png")), tabAjoutReference, "Ajouter un composant utilisable dans les offres");
   	}
	
	/**
	 * Ajoute l'onglet pour consulter les offres a la structure d'onglets
	 */
	public void addTabListeOffres(){
		tabListeOffre = new TabListeOffre();
		tabbedPane.addTab("Consulter les offres", new ImageIcon(this.getClass().getResource("/images/iconeBd.png")), tabListeOffre, "Consulter les offres presentent dans la base de donnees");
	}
	
	/**
	 * Ajoute l'onglet pour rechercher des offres a la structure d'onglets
	 */
	public void addTabRecherche(){
		tabRecherche = new TabRecherche();
		tabbedPane.addTab("Rechercher",  new ImageIcon(this.getClass().getResource("/images/iconeRecherche.png")), tabRecherche, "Rechercher des offres, selon vos criteres, parmis celles disponibles");
	}
	
	/**
	 * Ajoute l'onglet pour se deconnecter a la structure d'onglets
	 */
	public void addTabDisconnect(){
		tabDisconnect= new TabDisconnect();
		tabbedPane.addTab("Se deconnecter",  new ImageIcon(this.getClass().getResource("/images/iconeDeco.png")), tabDisconnect, "Retourner a la page d'authentification");
	}
	
}
