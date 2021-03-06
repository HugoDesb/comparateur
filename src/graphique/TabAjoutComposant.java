package graphique;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Classe gerant l'onglet pour ajouter une reference
 * 
 */
@SuppressWarnings("serial")
public class TabAjoutComposant extends JPanel{

	/**
	 * Menu déroulant permettant de choisir le composant à ajouter
	 */
	private JComboBox<String> comboBoxAjoutReference;
	
	/**
	 * Texte d'indication pour savoir la donnee que l'utilisateur doit renseigner
	 */
	private JLabel labelAjoutReference1;
	
	/**
	 * Texte d'indication pour savoir la donnee que l'utilisateur doit renseigner
	 */
	private JLabel labelAjoutReference2;
	
	/**
	 * Texte d'indication pour savoir la donnee que l'utilisateur doit renseigner
	 */
	private JLabel labelAjoutReference3;
	
	/**
	 * Texte d'incation renseignant l'unite du textField 1
	 */
	private JLabel labelAjoutReferenceUnite1;
	
	/**
	 * Texte d'incation renseignant l'unite du textField 2
	 */
	private JLabel labelAjoutReferenceUnite2;
	
	/**
	 * Texte d'incation renseignant l'unite du textField 3
	 */
	private JLabel labelAjoutReferenceUnite3;
	
	/**
	 * Zone de texte a remplir pour renseigner la frequence de la carte graphique
	 */
	private JTextField textFieldAjoutReferenceEcran1;
	
	/**
	 * Zone de texte a remplir pour renseigner la memoire de la carte graphique
	 */
	private JTextField textFieldAjoutReferenceEcran2;
	
	/**
	 * Zone de texte a remplir pour renseigner la frequence du processeur
	 */
	private JTextField textFieldAjoutReferenceProcesseur1;
	
	/**
	 * Zone de texte a remplir pour renseigner le type de coeur du processeur
	 */
	private JComboBox<String> comboBoxAjoutReferenceProcesseur1;
	
	/**
	 * Zone de texte a remplir pour renseigner la capacite du disque dur
	 */
	private JTextField textFieldAjoutReferenceBatterie1;
	
	/**
	 * Zone de texte a remplir pour renseigner la vitesse de rotation du disque dur
	 */
	private JTextField textFieldAjoutReferenceBatterie2;
	
	/**
	 * Zone de texte a remplir pour renseigner le type du disque dur
	 */
	private JComboBox<String> comboBoxAjoutReferenceBatterie1;
	
	/**
	 * Zone de texte a remplir pour renseigner la capacite de la ram
	 */
	private JTextField textFieldAjoutReferenceAppareilPhoto1;
	
	/**
	 * Zone de texte a remplir pour renseigner la frequence de la ram
	 */
	private JTextField textFieldAjoutReferenceAppareilPhoto2;
	
	/**
	 * Zone de texte a remplir pour renseigner le type de ram
	 */
	private JComboBox<String> comboBoxAjoutReferenceAppareilPhoto1;
	
	/**
	 * Bouton permettant de valider le formulaire de création de composant
	 */
	private JButton btnInsererReference;
	
	/**
	 * Texte d'indication pour indiquer la reference du composant a ajouter
	 */
	private JLabel labelReference;
	
	/**
	 * Zone de texte pour indiquer la reference du composant a ajouter
	 */
	private JTextField textFieldReference;
	
	/**
	 * Texte d'indication du prix
	 */
	private JLabel labelPrix;
	
	/**
	 * Zone de texte pour affecter un prix a un composant
	 */
	private JTextField textFieldPrix;
	
	/**
	 * Constructeur de l'onglet pour ajouter une reference
	 */
	public TabAjoutComposant(){
		
		// Polices de texte utilisees
			Font f30 = new Font("Helvetica", Font.BOLD, 30);
			Font f14 = new Font("Helvetica", Font.BOLD, 14);
			Font f14plain = new Font("Helvetica", Font.PLAIN, 14);
				
				
			GridBagLayout gbl_this = new GridBagLayout();
			gbl_this.columnWidths = new int[] { 30, 135, 253, 74, 30, 0 };
			gbl_this.rowHeights = new int[] { 0, 39, 0, 0, 0, 0, 29, 0, 40, 14, 0, 0, 0 };
			gbl_this.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
			gbl_this.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0,
					Double.MIN_VALUE };
			this.setLayout(gbl_this);
				
			//label presentation reference
			JLabel labelTopReference = new JLabel("<HTML><U>Seletionnez toutes les caracteristiques du composant que vous souhaitez ajouter :</U></HTML> ");
			labelTopReference.setFont(f30);
			GridBagConstraints gbc_labelTopReference = new GridBagConstraints();
			gbc_labelTopReference.gridwidth = 3;
			gbc_labelTopReference.insets = new Insets(0, 0, 5, 5);
			gbc_labelTopReference.gridx = 1;
			gbc_labelTopReference.gridy = 0;
			this.add(labelTopReference, gbc_labelTopReference);

			JLabel labelTypeComposant = new JLabel("Type composant :");
			labelTypeComposant.setFont(f14);
			GridBagConstraints gbc_labelTypeComposant = new GridBagConstraints();
			gbc_labelTypeComposant.insets = new Insets(0, 0, 5, 5);
			gbc_labelTypeComposant.anchor = GridBagConstraints.EAST;
			gbc_labelTypeComposant.gridx = 1;
			gbc_labelTypeComposant.gridy = 2;
			this.add(labelTypeComposant, gbc_labelTypeComposant);

			comboBoxAjoutReference = new JComboBox<String>();
			GridBagConstraints gbc_comboBoxAjoutReference = new GridBagConstraints();
			gbc_comboBoxAjoutReference.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxAjoutReference.anchor = GridBagConstraints.NORTH;
			gbc_comboBoxAjoutReference.insets = new Insets(0, 0, 5, 5);
			gbc_comboBoxAjoutReference.gridx = 2;
			gbc_comboBoxAjoutReference.gridy = 2;
			this.add(comboBoxAjoutReference, gbc_comboBoxAjoutReference);
			comboBoxAjoutReference.setFont(f14plain);

			labelReference = new JLabel("Reference :");
			labelReference.setFont(f14);
			labelReference.setEnabled(false);
			GridBagConstraints gbc_labelReference = new GridBagConstraints();
			gbc_labelReference.insets = new Insets(0, 0, 5, 5);
			gbc_labelReference.anchor = GridBagConstraints.EAST;
			gbc_labelReference.gridx = 1;
			gbc_labelReference.gridy = 3;
			this.add(labelReference, gbc_labelReference);

			textFieldReference = new JTextField();
			textFieldReference.setFont(f14plain);
			textFieldReference.setEnabled(false);
			GridBagConstraints gbc_textFieldReference = new GridBagConstraints();
			gbc_textFieldReference.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldReference.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldReference.gridx = 2;
			gbc_textFieldReference.gridy = 3;
			this.add(textFieldReference, gbc_textFieldReference);
			textFieldReference.setColumns(10);

			labelPrix = new JLabel("Prix :");
			labelPrix.setFont(f14);
			labelPrix.setEnabled(false);
			GridBagConstraints gbc_labelPrix = new GridBagConstraints();
			gbc_labelPrix.insets = new Insets(0, 0, 5, 5);
			gbc_labelPrix.anchor = GridBagConstraints.EAST;
			gbc_labelPrix.gridx = 1;
			gbc_labelPrix.gridy = 4;
			this.add(labelPrix, gbc_labelPrix);

			JLabel labelPrixUnite = new JLabel("euros");
			labelPrixUnite.setFont(f14);
			labelPrix.setEnabled(false);
			GridBagConstraints gbc_labelPrixUnite = new GridBagConstraints();
			gbc_labelPrixUnite.insets = new Insets(0, 0, 5, 5);
			gbc_labelPrixUnite.gridx = 3;
			gbc_labelPrixUnite.gridy = 4;
			this.add(labelPrixUnite, gbc_labelPrixUnite);

			textFieldPrix = new JTextField();
			textFieldPrix.setFont(f14plain);
			textFieldPrix.setEnabled(false);
			GridBagConstraints gbc_textFieldPrix = new GridBagConstraints();
			gbc_textFieldPrix.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldPrix.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldPrix.gridx = 2;
			gbc_textFieldPrix.gridy = 4;
			this.add(textFieldPrix, gbc_textFieldPrix);
			textFieldPrix.setColumns(10);

			labelAjoutReference1 = new JLabel("");
			labelAjoutReference1.setFont(f14);
			GridBagConstraints gbc_labelAjoutReference1 = new GridBagConstraints();
			gbc_labelAjoutReference1.insets = new Insets(0, 0, 5, 5);
			gbc_labelAjoutReference1.anchor = GridBagConstraints.EAST;
			gbc_labelAjoutReference1.gridx = 1;
			gbc_labelAjoutReference1.gridy = 5;
			this.add(labelAjoutReference1, gbc_labelAjoutReference1);

			labelAjoutReference2 = new JLabel("");
			labelAjoutReference2.setFont(f14);
			GridBagConstraints gbc_labelAjoutReference2 = new GridBagConstraints();
			gbc_labelAjoutReference2.insets = new Insets(0, 0, 5, 5);
			gbc_labelAjoutReference2.anchor = GridBagConstraints.EAST;
			gbc_labelAjoutReference2.gridx = 1;
			gbc_labelAjoutReference2.gridy = 6;
			this.add(labelAjoutReference2, gbc_labelAjoutReference2);

			labelAjoutReference3 = new JLabel("");
			labelAjoutReference3.setFont(f14);
			GridBagConstraints gbc_labelAjoutReference3 = new GridBagConstraints();
			gbc_labelAjoutReference3.insets = new Insets(0, 0, 5, 5);
			gbc_labelAjoutReference3.anchor = GridBagConstraints.EAST;
			gbc_labelAjoutReference3.gridx = 1;
			gbc_labelAjoutReference3.gridy = 7;
			this.add(labelAjoutReference3, gbc_labelAjoutReference3);

			labelAjoutReferenceUnite1 = new JLabel("");
			labelAjoutReferenceUnite1.setFont(f14);
			GridBagConstraints gbc_labelAjoutReferenceUnite1 = new GridBagConstraints();
			gbc_labelAjoutReferenceUnite1.insets = new Insets(0, 0, 5, 5);
			gbc_labelAjoutReferenceUnite1.gridx = 3;
			gbc_labelAjoutReferenceUnite1.gridy = 5;
			this.add(labelAjoutReferenceUnite1, gbc_labelAjoutReferenceUnite1);

			labelAjoutReferenceUnite2 = new JLabel("");
			labelAjoutReferenceUnite2.setFont(f14);
			GridBagConstraints gbc_labelAjoutReferenceUnite2 = new GridBagConstraints();
			gbc_labelAjoutReferenceUnite2.insets = new Insets(0, 0, 5, 5);
			gbc_labelAjoutReferenceUnite2.gridx = 3;
			gbc_labelAjoutReferenceUnite2.gridy = 6;
			this.add(labelAjoutReferenceUnite2, gbc_labelAjoutReferenceUnite2);

			labelAjoutReferenceUnite3 = new JLabel("");
			labelAjoutReferenceUnite3.setFont(f14);
			GridBagConstraints gbc_labelAjoutReferenceUnite3 = new GridBagConstraints();
			gbc_labelAjoutReferenceUnite3.insets = new Insets(0, 0, 5, 5);
			gbc_labelAjoutReferenceUnite3.gridx = 3;
			gbc_labelAjoutReferenceUnite3.gridy = 7;
			this.add(labelAjoutReferenceUnite3, gbc_labelAjoutReferenceUnite3);

			// Carte Graphique
			textFieldAjoutReferenceEcran1 = new JTextField();
			textFieldAjoutReferenceEcran1.setFont(f14plain);
			GridBagConstraints gbc_textFieldAjoutReferenceCarteGraphique1 = new GridBagConstraints();
			gbc_textFieldAjoutReferenceCarteGraphique1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldAjoutReferenceCarteGraphique1.anchor = GridBagConstraints.NORTH;
			gbc_textFieldAjoutReferenceCarteGraphique1.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldAjoutReferenceCarteGraphique1.gridx = 2;
			gbc_textFieldAjoutReferenceCarteGraphique1.gridy = 5;
			this.add(textFieldAjoutReferenceEcran1, gbc_textFieldAjoutReferenceCarteGraphique1);
			textFieldAjoutReferenceEcran1.setVisible(false);

			textFieldAjoutReferenceEcran2 = new JTextField();
			textFieldAjoutReferenceEcran2.setFont(f14plain);
			GridBagConstraints gbc_textFieldAjoutReferenceCarteGraphique2 = new GridBagConstraints();
			gbc_textFieldAjoutReferenceCarteGraphique2.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldAjoutReferenceCarteGraphique2.anchor = GridBagConstraints.NORTH;
			gbc_textFieldAjoutReferenceCarteGraphique2.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldAjoutReferenceCarteGraphique2.gridx = 2;
			gbc_textFieldAjoutReferenceCarteGraphique2.gridy = 6;
			this.add(textFieldAjoutReferenceEcran2, gbc_textFieldAjoutReferenceCarteGraphique2);
			textFieldAjoutReferenceEcran2.setVisible(false);

			// Cpu
			textFieldAjoutReferenceProcesseur1 = new JTextField();
			textFieldAjoutReferenceProcesseur1.setFont(f14plain);
			GridBagConstraints gbc_textFieldAjoutReferenceCpu1 = new GridBagConstraints();
			gbc_textFieldAjoutReferenceCpu1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldAjoutReferenceCpu1.anchor = GridBagConstraints.NORTH;
			gbc_textFieldAjoutReferenceCpu1.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldAjoutReferenceCpu1.gridx = 2;
			gbc_textFieldAjoutReferenceCpu1.gridy = 5;
			this.add(textFieldAjoutReferenceProcesseur1, gbc_textFieldAjoutReferenceCpu1);
			textFieldAjoutReferenceProcesseur1.setVisible(false);

			comboBoxAjoutReferenceProcesseur1 = new JComboBox<String>();
			GridBagConstraints gbc_comboBoxAjoutReferenceCpu1 = new GridBagConstraints();
			gbc_comboBoxAjoutReferenceCpu1.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxAjoutReferenceCpu1.anchor = GridBagConstraints.NORTH;
			gbc_comboBoxAjoutReferenceCpu1.insets = new Insets(0, 0, 5, 5);
			gbc_comboBoxAjoutReferenceCpu1.gridx = 2;
			gbc_comboBoxAjoutReferenceCpu1.gridy = 6;
			this.add(comboBoxAjoutReferenceProcesseur1, gbc_comboBoxAjoutReferenceCpu1);
			comboBoxAjoutReferenceProcesseur1.addItem("I3");
			comboBoxAjoutReferenceProcesseur1.addItem("I5");
			comboBoxAjoutReferenceProcesseur1.addItem("I7");
			comboBoxAjoutReferenceProcesseur1.setVisible(false);
			comboBoxAjoutReferenceProcesseur1.setFont(f14plain);

			// Disque Dur
			comboBoxAjoutReferenceBatterie1 = new JComboBox<String>();
			GridBagConstraints gbc_comboBoxAjoutReferenceDisqueDur1 = new GridBagConstraints();
			gbc_comboBoxAjoutReferenceDisqueDur1.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxAjoutReferenceDisqueDur1.anchor = GridBagConstraints.NORTH;
			gbc_comboBoxAjoutReferenceDisqueDur1.insets = new Insets(0, 0, 5, 5);
			gbc_comboBoxAjoutReferenceDisqueDur1.gridx = 2;
			gbc_comboBoxAjoutReferenceDisqueDur1.gridy = 6;
			this.add(comboBoxAjoutReferenceBatterie1, gbc_comboBoxAjoutReferenceDisqueDur1);
			comboBoxAjoutReferenceBatterie1.addItem("HDD");
		    comboBoxAjoutReferenceBatterie1.addItem("SSD");
			comboBoxAjoutReferenceBatterie1.setVisible(false);
			comboBoxAjoutReferenceBatterie1.setFont(f14plain);
				
			textFieldAjoutReferenceBatterie1 = new JTextField();
			textFieldAjoutReferenceBatterie1.setFont(f14plain);
			GridBagConstraints gbc_textFieldAjoutReferenceDisqueDur1 = new GridBagConstraints();
			gbc_textFieldAjoutReferenceDisqueDur1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldAjoutReferenceDisqueDur1.anchor = GridBagConstraints.NORTH;
			gbc_textFieldAjoutReferenceDisqueDur1.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldAjoutReferenceDisqueDur1.gridx = 2;
			gbc_textFieldAjoutReferenceDisqueDur1.gridy = 5;
			this.add(textFieldAjoutReferenceBatterie1, gbc_textFieldAjoutReferenceDisqueDur1);
			textFieldAjoutReferenceBatterie1.setVisible(false);

			textFieldAjoutReferenceBatterie2 = new JTextField();
			textFieldAjoutReferenceBatterie2.setFont(f14plain);
			GridBagConstraints gbc_textFieldAjoutReferenceDisqueDur2 = new GridBagConstraints();
			gbc_textFieldAjoutReferenceDisqueDur2.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldAjoutReferenceDisqueDur2.anchor = GridBagConstraints.NORTH;
			gbc_textFieldAjoutReferenceDisqueDur2.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldAjoutReferenceDisqueDur2.gridx = 2;
			gbc_textFieldAjoutReferenceDisqueDur2.gridy = 7;
			this.add(textFieldAjoutReferenceBatterie2, gbc_textFieldAjoutReferenceDisqueDur2);
			textFieldAjoutReferenceBatterie2.setVisible(false);

			// Ram
			comboBoxAjoutReferenceAppareilPhoto1 = new JComboBox<String>();
			GridBagConstraints gbc_comboBoxAjoutReferenceRam1 = new GridBagConstraints();
			gbc_comboBoxAjoutReferenceRam1.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxAjoutReferenceRam1.anchor = GridBagConstraints.NORTH;
			gbc_comboBoxAjoutReferenceRam1.insets = new Insets(0, 0, 5, 5);
			gbc_comboBoxAjoutReferenceRam1.gridx = 2;
			gbc_comboBoxAjoutReferenceRam1.gridy = 7;
			this.add(comboBoxAjoutReferenceAppareilPhoto1, gbc_comboBoxAjoutReferenceRam1);
			comboBoxAjoutReferenceAppareilPhoto1.addItem("DDR3");
			comboBoxAjoutReferenceAppareilPhoto1.addItem("DDR4");
			comboBoxAjoutReferenceAppareilPhoto1.setVisible(false);
			comboBoxAjoutReferenceAppareilPhoto1.setFont(f14plain);

			textFieldAjoutReferenceAppareilPhoto1 = new JTextField();
			textFieldAjoutReferenceAppareilPhoto1.setFont(f14plain);
			GridBagConstraints gbc_textFieldAjoutReferenceRam1 = new GridBagConstraints();
			gbc_textFieldAjoutReferenceRam1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldAjoutReferenceRam1.anchor = GridBagConstraints.NORTH;
			gbc_textFieldAjoutReferenceRam1.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldAjoutReferenceRam1.gridx = 2;
			gbc_textFieldAjoutReferenceRam1.gridy = 5;
			this.add(textFieldAjoutReferenceAppareilPhoto1, gbc_textFieldAjoutReferenceRam1);
			textFieldAjoutReferenceAppareilPhoto1.setVisible(false);

			textFieldAjoutReferenceAppareilPhoto2 = new JTextField();
			textFieldAjoutReferenceAppareilPhoto2.setFont(f14plain);
			GridBagConstraints gbc_textFieldAjoutReferenceRam2 = new GridBagConstraints();
			gbc_textFieldAjoutReferenceRam2.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldAjoutReferenceRam2.anchor = GridBagConstraints.NORTH;
			gbc_textFieldAjoutReferenceRam2.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldAjoutReferenceRam2.gridx = 2;
			gbc_textFieldAjoutReferenceRam2.gridy = 6;
			this.add(textFieldAjoutReferenceAppareilPhoto2, gbc_textFieldAjoutReferenceRam2);
			textFieldAjoutReferenceAppareilPhoto2.setVisible(false);
				
			btnInsererReference = new JButton("Ajouter la reference");
			GridBagConstraints gbc_btnInsererReference = new GridBagConstraints();
			gbc_btnInsererReference.insets = new Insets(0, 0, 5, 5);
			gbc_btnInsererReference.anchor = GridBagConstraints.EAST;
			gbc_btnInsererReference.gridx = 2;
			gbc_btnInsererReference.gridy = 9;
			this.add(btnInsererReference, gbc_btnInsererReference);

			JLabel Labellogo = new JLabel(/*new ImageIcon(this.getClass().getResource("/images/logo.png") )*/);
			GridBagConstraints gbc_lblLabellogo = new GridBagConstraints();
			gbc_lblLabellogo.anchor = GridBagConstraints.EAST;
			gbc_lblLabellogo.gridwidth = 3;
			gbc_lblLabellogo.insets = new Insets(0, 0, 0, 5);
			gbc_lblLabellogo.gridx = 2;
			gbc_lblLabellogo.gridy = 11;
			this.add(Labellogo, gbc_lblLabellogo);
	}

	/**
	 * Getter de l'attribut comboBoxAjoutReference
	 * @return l'attribut comboBoxAjoutReference
	 */
	public JComboBox<String> getComboBoxAjoutReference() {
		return comboBoxAjoutReference;
	}

	/**
	 * Getter de l'attribut labelAjoutReference1
	 * @return l'attribut labelAjoutReference1
	 */
	public JLabel getLabelAjoutReference1() {
		return labelAjoutReference1;
	}

	/**
	 * Getter de l'attribut labelAjoutReference2
	 * @return l'attribut labelAjoutReference2
	 */
	public JLabel getLabelAjoutReference2() {
		return labelAjoutReference2;
	}

	/**
	 * Getter de l'attribut labelAjoutReference3
	 * @return l'attribut labelAjoutReference3
	 */
	public JLabel getLabelAjoutReference3() {
		return labelAjoutReference3;
	}

	/**
	 * Getter de l'attribut labelAjoutReferenceUnite1
	 * @return l'attribut labelAjoutReferenceUnite1
	 */
	public JLabel getLabelAjoutReferenceUnite1() {
		return labelAjoutReferenceUnite1;
	}

	/**
	 * Getter de l'attribut labelAjoutReferenceUnite2
	 * @return l'attribut labelAjoutReferenceUnite2
	 */
	public JLabel getLabelAjoutReferenceUnite2() {
		return labelAjoutReferenceUnite2;
	}

	/**
	 * Getter de l'attribut labelAjoutReferenceUnite3
	 * @return l'attribut labelAjoutReferenceUnite3
	 */
	public JLabel getLabelAjoutReferenceUnite3() {
		return labelAjoutReferenceUnite3;
	}

	/**
	 * Getter de l'attribut textFieldAjoutReferenceCarteGraphique1
	 * @return l'attribut textFieldAjoutReferenceCarteGraphique1
	 */
	public JTextField getTextFieldAjoutReferenceEcran1() {
		return textFieldAjoutReferenceEcran1;
	}

	/**
	 * Getter de l'attribut textFieldAjoutReferenceCarteGraphique2
	 * @return l'attribut textFieldAjoutReferenceCarteGraphique2
	 */
	public JTextField getTextFieldAjoutReferenceEcran2() {
		return textFieldAjoutReferenceEcran2;
	}

	/**
	 * Getter de l'attribut textFieldAjoutReferenceCpu1
	 * @return l'attribut textFieldAjoutReferenceCpu1
	 */
	public JTextField getTextFieldAjoutReferenceProcesseur1() {
		return textFieldAjoutReferenceProcesseur1;
	}

	/**
	 * Getter de l'attribut comboBoxAjoutReferenceCpu1
	 * @return l'attribut comboBoxAjoutReferenceCpu1
	 */
	public JComboBox<String> getComboBoxAjoutReferenceProcesseur1() {
		return comboBoxAjoutReferenceProcesseur1;
	}

	/**
	 * Getter de l'attribut textFieldAjoutReferenceDisqueDur1
	 * @return l'attribut textFieldAjoutReferenceDisqueDur1
	 */
	public JTextField getTextFieldAjoutReferenceBatterie1() {
		return textFieldAjoutReferenceBatterie1;
	}

	/**
	 * Getter de l'attribut textFieldAjoutReferenceDisqueDur2
	 * @return l'attribut textFieldAjoutReferenceDisqueDur2
	 */
	public JTextField getTextFieldAjoutReferenceBatterie2() {
		return textFieldAjoutReferenceBatterie2;
	}

	/**
	 * Getter de l'attribut comboBoxAjoutReferenceDisqueDur1
	 * @return l'attribut comboBoxAjoutReferenceDisqueDur1
	 */
	public JComboBox<String> getComboBoxAjoutReferenceBatterie1() {
		return comboBoxAjoutReferenceBatterie1;
	}

	/**
	 * Getter de l'attribut textFieldAjoutReferenceRam1
	 * @return l'attribut textFieldAjoutReferenceRam1
	 */
	public JTextField getTextFieldAjoutReferenceAppareilPhoto1() {
		return textFieldAjoutReferenceAppareilPhoto1;
	}

	/**
	 * Getter de l'attribut textFieldAjoutReferenceRam2
	 * @return l'attribut textFieldAjoutReferenceRam2
	 */
	public JTextField getTextFieldAjoutReferenceAppareilPhoto2() {
		return textFieldAjoutReferenceAppareilPhoto2;
	}

	/**
	 * Getter de l'attribut comboBoxAjoutReferenceRam1
	 * @return l'attribut comboBoxAjoutReferenceRam1
	 */
	public JComboBox<String> getComboBoxAjoutReferenceAppareilPhoto1() {
		return comboBoxAjoutReferenceAppareilPhoto1;
	}

	/**
	 * Getter de l'attribut btnInsererReference
	 * @return l'attribut btnInsererReference
	 */
	public JButton getBtnInsererReference() {
		return btnInsererReference;
	}

	/**
	 * Getter de l'attribut labelReference
	 * @return l'attribut labelReference
	 */
	public JLabel getLabelReference() {
		return labelReference;
	}

	/**
	 * Getter de l'attribut textFieldReference
	 * @return l'attribut textFieldReference
	 */
	public JTextField getTextFieldReference() {
		return textFieldReference;
	}

	/**
	 * Getter de l'attribut labelPrix
	 * @return l'attribut labelPrix
	 */
	public JLabel getLabelPrix() {
		return labelPrix;
	}

	/**
	 * Getter de l'attribut textFieldPrix
	 * @return l'attribut textFieldPrix
	 */
	public JTextField getTextFieldPrix() {
		return textFieldPrix;
	}

}
