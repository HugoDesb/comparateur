package graphique;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Classe gerant l'onglet pour ajouter une offre
 * 
 */
@SuppressWarnings("serial")
public class TabAjoutOffre extends JPanel{
	
	/**
	 * Label qui affiche le prix de la carte graphique choisie
	 */
	private JLabel labelPrixUnitaireEcran;
	
	/**
	 * Label qui affiche le prix du processeur choisi
	 */
	private JLabel labelPrixUnitaireProcesseur;
	
	/**
	 * Label qui affiche le prix du disque dur choisi
	 */
	private JLabel labelPrixUnitaireBatterie;
	
	/**
	 * Label qui affiche le prix de la ram choisie
	 */
	private JLabel labelPrixUnitaireAppareilPhoto;
	
	/**
	 * Combobox contenant tous les disques durs disponibles
	 */
	private JComboBox<String> comboBoxAjoutOffreBatterie;
	
	/**
	 * Combobox contenant toutes les ram disponibles
	 */
	private JComboBox<String> comboBoxAjoutOffreAppareilPhoto;
	
	/**
	 * Combobox contenant toutes les cartes graphiques disponibles
	 */
	private JComboBox<String> comboBoxAjoutOffreEcran;
	
	/**
	 *  Combobox contenant tous les processeurs disponibles
	 */
	private JComboBox<String> comboBoxAjoutOffreProcesseur;
	
	/**
	 *  Bouton pour ajouter l'offre choisie
	 */
	private JButton btnInsererLoffre;
	
	/**
	 * Label qui affiche le prix de l'offre choisie
	 */
	private JLabel labelPrixTotal;

	/**
	 * Constructeur de l'onglet pour ajouter une offre
	 */
	public TabAjoutOffre(){
	
		// Polices de texte utilisees
		Font f30 = new Font("Helvetica", Font.BOLD, 30);
		Font f14 = new Font("Helvetica", Font.BOLD, 14);
		Font f14plain = new Font("Helvetica", Font.PLAIN, 14);
			
			
		GridBagLayout gbl_this = new GridBagLayout();
    	gbl_this.columnWidths = new int[] { 30, 32, 32, 32, 32, 30, 0 };
		gbl_this.rowHeights = new int[] { 0, 36, 30, 24, 0, 0, 0, 0, 0, 40, 0, 0, 0, 0 };
		gbl_this.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_this.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		this.setLayout(gbl_this);
			
		// label de presentation
		JLabel labelTopOffre = new JLabel("<HTML> <U> Selectionnez tous les composants de l'offre que vous souhaitez ajouter :</U> </HTML>");
		labelTopOffre.setFont(f30);
		GridBagConstraints gbc_labelTopOffre = new GridBagConstraints();
		gbc_labelTopOffre.gridwidth = 4;
		gbc_labelTopOffre.insets = new Insets(0, 0, 5, 5);
		gbc_labelTopOffre.gridx = 1;
		gbc_labelTopOffre.gridy = 0;
		this.add(labelTopOffre, gbc_labelTopOffre);

		// label du prix
		JLabel labelPrixUnitaire = new JLabel("Prix unitaire");
		labelPrixUnitaire.setFont(f14);
		GridBagConstraints gbc_labelPrixUnitaire = new GridBagConstraints();
		gbc_labelPrixUnitaire.insets = new Insets(15,15,15,15);
		gbc_labelPrixUnitaire.gridx = 4;
		gbc_labelPrixUnitaire.gridy = 2;
		this.add(labelPrixUnitaire, gbc_labelPrixUnitaire);

		// Carte graphique
		labelPrixUnitaireEcran = new JLabel("");
		labelPrixUnitaireEcran.setFont(f14);
		GridBagConstraints gbc_labelPrixUnitaireEcran = new GridBagConstraints();
		gbc_labelPrixUnitaireEcran.insets = new Insets(0, 0, 5, 5);
		gbc_labelPrixUnitaireEcran.gridx = 4;
		gbc_labelPrixUnitaireEcran.gridy = 3;
		this.add(labelPrixUnitaireEcran, gbc_labelPrixUnitaireEcran);

		JLabel labelEcran = new JLabel("Ecran :");
		labelEcran.setFont(f14);
		GridBagConstraints gbc_labelEcran = new GridBagConstraints();
		gbc_labelEcran.insets = new Insets(0, 0, 5, 5);
		gbc_labelEcran.anchor = GridBagConstraints.EAST;
		gbc_labelEcran.gridx = 1;
		gbc_labelEcran.gridy = 3;
		this.add(labelEcran, gbc_labelEcran);

		comboBoxAjoutOffreEcran = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxAjoutOffreEcran = new GridBagConstraints();
		gbc_comboBoxAjoutOffreEcran.fill = GridBagConstraints.HORIZONTAL;
    	gbc_comboBoxAjoutOffreEcran.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxAjoutOffreEcran.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxAjoutOffreEcran.gridx = 2;
		gbc_comboBoxAjoutOffreEcran.gridy = 3;
		this.add(comboBoxAjoutOffreEcran, gbc_comboBoxAjoutOffreEcran);
		comboBoxAjoutOffreEcran.setFont(f14plain);

		// CPU
		labelPrixUnitaireProcesseur = new JLabel("");
		labelPrixUnitaireProcesseur.setFont(f14);
		GridBagConstraints gbc_labelPrixUnitaireProcesseur = new GridBagConstraints();
		gbc_labelPrixUnitaireProcesseur.insets = new Insets(0, 0, 5, 5);
		gbc_labelPrixUnitaireProcesseur.gridx = 4;
		gbc_labelPrixUnitaireProcesseur.gridy = 4;
		this.add(labelPrixUnitaireProcesseur, gbc_labelPrixUnitaireProcesseur);

		JLabel labelProcesseur = new JLabel("Processeur :");
		labelProcesseur.setFont(f14);
		GridBagConstraints gbc_labelProcesseur = new GridBagConstraints();
		gbc_labelProcesseur.insets = new Insets(0, 0, 5, 5);
		gbc_labelProcesseur.anchor = GridBagConstraints.EAST;
		gbc_labelProcesseur.gridx = 1;
		gbc_labelProcesseur.gridy = 4;
		this.add(labelProcesseur, gbc_labelProcesseur);

		comboBoxAjoutOffreProcesseur = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxAjoutOffreProcesseur = new GridBagConstraints();
		gbc_comboBoxAjoutOffreProcesseur.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxAjoutOffreProcesseur.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxAjoutOffreProcesseur.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxAjoutOffreProcesseur.gridx = 2;
		gbc_comboBoxAjoutOffreProcesseur.gridy = 4;
		this.add(comboBoxAjoutOffreProcesseur, gbc_comboBoxAjoutOffreProcesseur);
		comboBoxAjoutOffreProcesseur.setFont(f14plain);

		// Disque dur
		labelPrixUnitaireBatterie = new JLabel("");
		labelPrixUnitaireBatterie.setFont(f14);
		GridBagConstraints gbc_labelPrixUnitaireBatterie = new GridBagConstraints();
		gbc_labelPrixUnitaireBatterie.insets = new Insets(0, 0, 5, 5);
		gbc_labelPrixUnitaireBatterie.gridx = 4;
		gbc_labelPrixUnitaireBatterie.gridy = 5;
		this.add(labelPrixUnitaireBatterie, gbc_labelPrixUnitaireBatterie);

		JLabel labelBatterie = new JLabel("Batterie :");
		labelBatterie.setFont(f14);
		GridBagConstraints gbc_labelBatterie = new GridBagConstraints();
		gbc_labelBatterie.insets = new Insets(0, 0, 5, 5);
		gbc_labelBatterie.anchor = GridBagConstraints.EAST;
		gbc_labelBatterie.gridx = 1;
		gbc_labelBatterie.gridy = 5;
		this.add(labelBatterie, gbc_labelBatterie);

		comboBoxAjoutOffreBatterie = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxAjoutOffreBatterie = new GridBagConstraints();
		gbc_comboBoxAjoutOffreBatterie.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxAjoutOffreBatterie.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxAjoutOffreBatterie.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxAjoutOffreBatterie.gridx = 2;
		gbc_comboBoxAjoutOffreBatterie.gridy = 5;
		this.add(comboBoxAjoutOffreBatterie, gbc_comboBoxAjoutOffreBatterie);
		comboBoxAjoutOffreBatterie.setFont(f14plain);

		// RAM
		labelPrixUnitaireAppareilPhoto = new JLabel("");
		labelPrixUnitaireAppareilPhoto.setFont(f14);
		GridBagConstraints gbc_labelPrixUnitaireAppareilPhoto = new GridBagConstraints();
		gbc_labelPrixUnitaireAppareilPhoto.insets = new Insets(0, 0, 5, 5);
		gbc_labelPrixUnitaireAppareilPhoto.gridx = 4;
		gbc_labelPrixUnitaireAppareilPhoto.gridy = 7;
		this.add(labelPrixUnitaireAppareilPhoto, gbc_labelPrixUnitaireAppareilPhoto);

		JLabel labelAppareilPhoto = new JLabel("Appareil Photo :");
		labelAppareilPhoto.setFont(f14);
		GridBagConstraints gbc_labelAppareilPhoto = new GridBagConstraints();
		gbc_labelAppareilPhoto.insets = new Insets(0, 0, 5, 5);
		gbc_labelAppareilPhoto.anchor = GridBagConstraints.EAST;
		gbc_labelAppareilPhoto.gridx = 1;
		gbc_labelAppareilPhoto.gridy = 7;
		this.add(labelAppareilPhoto, gbc_labelAppareilPhoto);

		comboBoxAjoutOffreAppareilPhoto = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxAjoutOffreAppareilPhoto = new GridBagConstraints();
		gbc_comboBoxAjoutOffreAppareilPhoto.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxAjoutOffreAppareilPhoto.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxAjoutOffreAppareilPhoto.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxAjoutOffreAppareilPhoto.gridx = 2;
		gbc_comboBoxAjoutOffreAppareilPhoto.gridy = 7;
		this.add(comboBoxAjoutOffreAppareilPhoto, gbc_comboBoxAjoutOffreAppareilPhoto);
		comboBoxAjoutOffreAppareilPhoto.setFont(f14plain);

		labelPrixTotal = new JLabel("");
		labelPrixTotal.setFont(f14);
		GridBagConstraints gbc_labelPrixTotal = new GridBagConstraints();
		gbc_labelPrixTotal.insets = new Insets(0, 0, 5, 5);
		gbc_labelPrixTotal.gridx = 4;
		gbc_labelPrixTotal.gridy = 8;
		this.add(labelPrixTotal, gbc_labelPrixTotal);

		JLabel labelPrix = new JLabel("Prix total :");
		labelPrix.setFont(f14);
		GridBagConstraints gbc_labelPrix = new GridBagConstraints();
		gbc_labelPrix.anchor = GridBagConstraints.EAST;
		gbc_labelPrix.insets = new Insets(0, 0, 5, 5);
		gbc_labelPrix.gridx = 2;
		gbc_labelPrix.gridy = 8;
		this.add(labelPrix, gbc_labelPrix);

		btnInsererLoffre = new JButton("Ajouter la configuration");
		GridBagConstraints gbc_btnInsererLoffre = new GridBagConstraints();
		gbc_btnInsererLoffre.insets = new Insets(0, 0, 5, 5);
		gbc_btnInsererLoffre.anchor = GridBagConstraints.EAST;
		gbc_btnInsererLoffre.gridx = 2;
		gbc_btnInsererLoffre.gridy = 10;
		this.add(btnInsererLoffre, gbc_btnInsererLoffre);

		JLabel labelLogo = new JLabel(/*new ImageIcon(this.getClass().getResource("/images/logo.png") )*/);
		GridBagConstraints gbc_labelLogo = new GridBagConstraints();
		gbc_labelLogo.anchor = GridBagConstraints.EAST;
		gbc_labelLogo.gridwidth = 4;
		gbc_labelLogo.insets = new Insets(0, 0, 0, 5);
		gbc_labelLogo.gridx = 2;
		gbc_labelLogo.gridy = 12;
		this.add(labelLogo, gbc_labelLogo);
    }

	/**
	 * Renvoie le prix de la carte graphique choisie
	 * @return Le prix de la carte graphique choisie
	 */
	public JLabel getLabelPrixUnitaireEcran() {
		return labelPrixUnitaireEcran;
	}

	/**
	 * Renvoie le prix du processeur choisi
	 * @return Le prix du processeur choisi
	 */
	public JLabel getLabelPrixUnitaireProcesseur() {
		return labelPrixUnitaireProcesseur;
	}

	/**
	 * Renvoie le prix du disque dur choisi
	 * @return Le prix du disque dur choisi
	 */
	public JLabel getLabelPrixUnitaireBatterie() {
		return labelPrixUnitaireBatterie;
	}

	/**
	 * Renvoie le prix de la ram choisie
	 * @return Le prix de la ram choisie
	 */
	public JLabel getLabelPrixUnitaireAppareilPhoto() {
		return labelPrixUnitaireAppareilPhoto;
	}

	/**
	 * Renvoie la combobox associee aux disques durs choisi
	 * @return La combobox associee aux disques durs choisi
	 */
	public JComboBox<String> getComboBoxAjoutOffreBatterie() {
		return comboBoxAjoutOffreBatterie;
	}

	/**
	 * Renvoie la combobox associee aux ram choisie
	 * @return La combobox associee aux ram choisie
	 */
	public JComboBox<String> getComboBoxAjoutOffreAppareilPhoto() {
		return comboBoxAjoutOffreAppareilPhoto;
	}

	/**
	 * Renvoie la combobox associee aux cartes graphiques
	 * @return La combobox associee aux cartes graphiques
	 */
	public JComboBox<String> getComboBoxAjoutOffreEcran() {
		return comboBoxAjoutOffreEcran;
	}

	/**
	 * Renvoie la combobox associee aux processeurs
	 * @return La combobox associee aux processeurs
	 */
	public JComboBox<String> getComboBoxAjoutOffreProcesseur() {
		return comboBoxAjoutOffreProcesseur;
	}

    /**
    * Renvoie le bouton pour inserer une offre
    * @return Le bouton pour inserer une offre
    */
	public JButton getBtnInsererLoffre() {
		return btnInsererLoffre;
	}
	
	/**
	 * Renvoie le label affichant prix total 
	 * @return Le label affichant prix total 
	 */
	public JLabel getLabelPrixTotal() {
		return labelPrixTotal;
	}

}
