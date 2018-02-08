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
 * @author Alexandre Monnot - alexandre.monnot@etu.univ-amu.fr - & Vincent Paoli - vincent.paoli.1@etu.univ-amu.fr -
 * 
 */
@SuppressWarnings("serial")
public class TabAjoutOffre extends JPanel{
	
	/**
	 * Label qui affiche le prix de la carte graphique choisie
	 */
	private JLabel labelPrixUnitaireCarteGraphique;
	
	/**
	 * Label qui affiche le prix du processeur choisi
	 */
	private JLabel labelPrixUnitaireCpu;
	
	/**
	 * Label qui affiche le prix du disque dur choisi
	 */
	private JLabel labelPrixUnitaireDisqueDur;
	
	/**
	 * Label qui affiche le prix de la ram choisie
	 */
	private JLabel labelPrixUnitaireRam;
	
	/**
	 * Combobox contenant tous les disques durs disponibles
	 */
	private JComboBox<String> comboBoxAjoutOffreDisqueDur;
	
	/**
	 * Combobox contenant toutes les ram disponibles
	 */
	private JComboBox<String> comboBoxAjoutOffreRam;
	
	/**
	 * Combobox contenant toutes les cartes graphiques disponibles
	 */
	private JComboBox<String> comboBoxAjoutOffreCarteGraphique;
	
	/**
	 *  Combobox contenant tous les processeurs disponibles
	 */
	private JComboBox<String> comboBoxAjoutOffreCpu;
	
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
		labelPrixUnitaireCarteGraphique = new JLabel("");
		labelPrixUnitaireCarteGraphique.setFont(f14);
		GridBagConstraints gbc_labelPrixUnitaireCarteGraphique = new GridBagConstraints();
		gbc_labelPrixUnitaireCarteGraphique.insets = new Insets(0, 0, 5, 5);
		gbc_labelPrixUnitaireCarteGraphique.gridx = 4;
		gbc_labelPrixUnitaireCarteGraphique.gridy = 3;
		this.add(labelPrixUnitaireCarteGraphique, gbc_labelPrixUnitaireCarteGraphique);

		JLabel labelCarteGraphique = new JLabel("Carte Graphique :");
		labelCarteGraphique.setFont(f14);
		GridBagConstraints gbc_labelCarteGraphique = new GridBagConstraints();
		gbc_labelCarteGraphique.insets = new Insets(0, 0, 5, 5);
		gbc_labelCarteGraphique.anchor = GridBagConstraints.EAST;
		gbc_labelCarteGraphique.gridx = 1;
		gbc_labelCarteGraphique.gridy = 3;
		this.add(labelCarteGraphique, gbc_labelCarteGraphique);

		comboBoxAjoutOffreCarteGraphique = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxAjoutOffreCarteGraphique = new GridBagConstraints();
		gbc_comboBoxAjoutOffreCarteGraphique.fill = GridBagConstraints.HORIZONTAL;
    	gbc_comboBoxAjoutOffreCarteGraphique.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxAjoutOffreCarteGraphique.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxAjoutOffreCarteGraphique.gridx = 2;
		gbc_comboBoxAjoutOffreCarteGraphique.gridy = 3;
		this.add(comboBoxAjoutOffreCarteGraphique, gbc_comboBoxAjoutOffreCarteGraphique);
		comboBoxAjoutOffreCarteGraphique.setFont(f14plain);

		// CPU
		labelPrixUnitaireCpu = new JLabel("");
		labelPrixUnitaireCpu.setFont(f14);
		GridBagConstraints gbc_labelPrixUnitaireCpu = new GridBagConstraints();
		gbc_labelPrixUnitaireCpu.insets = new Insets(0, 0, 5, 5);
		gbc_labelPrixUnitaireCpu.gridx = 4;
		gbc_labelPrixUnitaireCpu.gridy = 4;
		this.add(labelPrixUnitaireCpu, gbc_labelPrixUnitaireCpu);

		JLabel labelCpu = new JLabel("CPU :");
		labelCpu.setFont(f14);
		GridBagConstraints gbc_labelCpu = new GridBagConstraints();
		gbc_labelCpu.insets = new Insets(0, 0, 5, 5);
		gbc_labelCpu.anchor = GridBagConstraints.EAST;
		gbc_labelCpu.gridx = 1;
		gbc_labelCpu.gridy = 4;
		this.add(labelCpu, gbc_labelCpu);

		comboBoxAjoutOffreCpu = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxAjoutOffreCpu = new GridBagConstraints();
		gbc_comboBoxAjoutOffreCpu.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxAjoutOffreCpu.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxAjoutOffreCpu.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxAjoutOffreCpu.gridx = 2;
		gbc_comboBoxAjoutOffreCpu.gridy = 4;
		this.add(comboBoxAjoutOffreCpu, gbc_comboBoxAjoutOffreCpu);
		comboBoxAjoutOffreCpu.setFont(f14plain);

		// Disque dur
		labelPrixUnitaireDisqueDur = new JLabel("");
		labelPrixUnitaireDisqueDur.setFont(f14);
		GridBagConstraints gbc_labelPrixUnitaireDisqueDur = new GridBagConstraints();
		gbc_labelPrixUnitaireDisqueDur.insets = new Insets(0, 0, 5, 5);
		gbc_labelPrixUnitaireDisqueDur.gridx = 4;
		gbc_labelPrixUnitaireDisqueDur.gridy = 5;
		this.add(labelPrixUnitaireDisqueDur, gbc_labelPrixUnitaireDisqueDur);

		JLabel labelDisqueDur = new JLabel("Disque Dur :");
		labelDisqueDur.setFont(f14);
		GridBagConstraints gbc_labelDisqueDur = new GridBagConstraints();
		gbc_labelDisqueDur.insets = new Insets(0, 0, 5, 5);
		gbc_labelDisqueDur.anchor = GridBagConstraints.EAST;
		gbc_labelDisqueDur.gridx = 1;
		gbc_labelDisqueDur.gridy = 5;
		this.add(labelDisqueDur, gbc_labelDisqueDur);

		comboBoxAjoutOffreDisqueDur = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxAjoutOffreDisqueDur = new GridBagConstraints();
		gbc_comboBoxAjoutOffreDisqueDur.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxAjoutOffreDisqueDur.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxAjoutOffreDisqueDur.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxAjoutOffreDisqueDur.gridx = 2;
		gbc_comboBoxAjoutOffreDisqueDur.gridy = 5;
		this.add(comboBoxAjoutOffreDisqueDur, gbc_comboBoxAjoutOffreDisqueDur);
		comboBoxAjoutOffreDisqueDur.setFont(f14plain);

		// RAM
		labelPrixUnitaireRam = new JLabel("");
		labelPrixUnitaireRam.setFont(f14);
		GridBagConstraints gbc_labelPrixUnitaireRam = new GridBagConstraints();
		gbc_labelPrixUnitaireRam.insets = new Insets(0, 0, 5, 5);
		gbc_labelPrixUnitaireRam.gridx = 4;
		gbc_labelPrixUnitaireRam.gridy = 7;
		this.add(labelPrixUnitaireRam, gbc_labelPrixUnitaireRam);

		JLabel labelRam = new JLabel("RAM :");
		labelRam.setFont(f14);
		GridBagConstraints gbc_labelRam = new GridBagConstraints();
		gbc_labelRam.insets = new Insets(0, 0, 5, 5);
		gbc_labelRam.anchor = GridBagConstraints.EAST;
		gbc_labelRam.gridx = 1;
		gbc_labelRam.gridy = 7;
		this.add(labelRam, gbc_labelRam);

		comboBoxAjoutOffreRam = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxAjoutOffreRam = new GridBagConstraints();
		gbc_comboBoxAjoutOffreRam.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxAjoutOffreRam.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxAjoutOffreRam.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxAjoutOffreRam.gridx = 2;
		gbc_comboBoxAjoutOffreRam.gridy = 7;
		this.add(comboBoxAjoutOffreRam, gbc_comboBoxAjoutOffreRam);
		comboBoxAjoutOffreRam.setFont(f14plain);

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
	public JLabel getLabelPrixUnitaireCarteGraphique() {
		return labelPrixUnitaireCarteGraphique;
	}

	/**
	 * Renvoie le prix du processeur choisi
	 * @return Le prix du processeur choisi
	 */
	public JLabel getLabelPrixUnitaireCpu() {
		return labelPrixUnitaireCpu;
	}

	/**
	 * Renvoie le prix du disque dur choisi
	 * @return Le prix du disque dur choisi
	 */
	public JLabel getLabelPrixUnitaireDisqueDur() {
		return labelPrixUnitaireDisqueDur;
	}

	/**
	 * Renvoie le prix de la ram choisie
	 * @return Le prix de la ram choisie
	 */
	public JLabel getLabelPrixUnitaireRam() {
		return labelPrixUnitaireRam;
	}

	/**
	 * Renvoie la combobox associee aux disques durs choisi
	 * @return La combobox associee aux disques durs choisi
	 */
	public JComboBox<String> getComboBoxAjoutOffreDisqueDur() {
		return comboBoxAjoutOffreDisqueDur;
	}

	/**
	 * Renvoie la combobox associee aux ram choisie
	 * @return La combobox associee aux ram choisie
	 */
	public JComboBox<String> getComboBoxAjoutOffreRam() {
		return comboBoxAjoutOffreRam;
	}

	/**
	 * Renvoie la combobox associee aux cartes graphiques
	 * @return La combobox associee aux cartes graphiques
	 */
	public JComboBox<String> getComboBoxAjoutOffreCarteGraphique() {
		return comboBoxAjoutOffreCarteGraphique;
	}

	/**
	 * Renvoie la combobox associee aux processeurs
	 * @return La combobox associee aux processeurs
	 */
	public JComboBox<String> getComboBoxAjoutOffreCpu() {
		return comboBoxAjoutOffreCpu;
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
