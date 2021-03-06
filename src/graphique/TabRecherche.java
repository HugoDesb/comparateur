package graphique;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
  * Classe gerant l'onglet pour rechercher des offres
 * 
 */
@SuppressWarnings("serial")
public class TabRecherche extends JPanel{
	
	/**
	 * Panneau deroulant contenant les offres recherchees
	 */
	private JScrollPane listeRecherche;
	
	/**
	 * Tableau contenant les offres recherchees
	 */
	private JTable tableRecherche;
	
	/**
	 * Modele du tableau des offres recherchees
	 */
	private DefaultTableModel tableRechercheModel;

	/**
	 * Label affichant le titre de l'onglet
	 */
	private JLabel labelRechercherTop;

	/**
	 * Combobox contenant les reponses a la question 1
	 */
	private JComboBox<String> comboBoxRechercher1;
	
	/**
	 * Comboboxcontenant les reponses a la question 2
	 */
	private JComboBox<String> comboBoxRechercher2;
	
	/**
	 * Comboboxcontenant les reponses a la question 3
	 */
	private JComboBox<String> comboBoxRechercher3;
	
	/**
	 * Comboboxcontenant les reponses a la question 4
	 */
	private JComboBox<String> comboBoxRechercher4;
	
	/**
	 * Comboboxcontenant les reponses a la question 5
	 */
	private JComboBox<String> comboBoxRechercher5;
	
	/**
	 * Comboboxcontenant les reponses a la question 6
	 */
	private JComboBox<String> comboBoxRechercher6;
	
	/**
	 * Comboboxcontenant les reponses a la question 7
	 */
	private JComboBox<String> comboBoxRechercher7;

	/**
	 * Bouton pour lancer la recherche
	 */
	private JButton btnRechercher;

	/**
	 * Label affichant les details de la recherche une fois lancee
	 */
	private JLabel labelAideRecherche;

	/**
	 * Constructeur de l'onglet pour rechercher des offres
	 */
	public TabRecherche(){
	    
		//polices de texte utilisees
		Font f30 = new Font("Helvetica", Font.BOLD, 30);
		Font f14 = new Font("Helvetica", Font.BOLD, 14);
		Font f14plain = new Font("Helvetica", Font.PLAIN, 14);
		Font italic = new Font("Helvetica", Font.ITALIC, 14);

				
		GridBagLayout gbl_this = new GridBagLayout();
		gbl_this.columnWidths = new int[] { 620, 0 };
		gbl_this.rowHeights = new int[] { 340, 0, 337, 0 };
		gbl_this.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_this.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		this.setLayout(gbl_this);

		JPanel critereRecherche = new JPanel();
		GridBagConstraints gbc_critereRecherche = new GridBagConstraints();
		gbc_critereRecherche.anchor = GridBagConstraints.NORTH;
		gbc_critereRecherche.fill = GridBagConstraints.HORIZONTAL;
		gbc_critereRecherche.insets = new Insets(0, 0, 5, 0);
		gbc_critereRecherche.gridx = 0;
		gbc_critereRecherche.gridy = 0;
		this.add(critereRecherche, gbc_critereRecherche);
		GridBagLayout gbl_critereRecherche = new GridBagLayout();
		gbl_critereRecherche.columnWidths = new int[] { 0, 481, 411, 30, 0 };
		gbl_critereRecherche.rowHeights = new int[] { 20, 36, 0, 0, 0, 0, 0, 0, 0, 0, 31, 0, 0 };
		gbl_critereRecherche.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_critereRecherche.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		critereRecherche.setLayout(gbl_critereRecherche);

		// Label d'introduction
		labelRechercherTop = new JLabel("<HTML><U>Veuillez remplir entierement le formulaire ci-dessous :</U></HTML> ");
		labelRechercherTop.setFont(f30);
		GridBagConstraints gbc_labelRechercherTop = new GridBagConstraints();
		gbc_labelRechercherTop.insets = new Insets(0, 0, 5, 5);
		gbc_labelRechercherTop.gridx = 1;
		gbc_labelRechercherTop.gridy = 0;
		gbc_labelRechercherTop.gridwidth = 2;
		critereRecherche.add(labelRechercherTop, gbc_labelRechercherTop);

		// Question 1
		JLabel labelRecherche1 = new JLabel("Mon smartphone doit me permettre : ");

		labelRecherche1.setFont(f14);
		GridBagConstraints gbc_labelRecherche1 = new GridBagConstraints();
		gbc_labelRecherche1.anchor = GridBagConstraints.EAST;
		gbc_labelRecherche1.insets = new Insets(0, 0, 5, 5);
		gbc_labelRecherche1.gridx = 1;
		gbc_labelRecherche1.gridy = 2;
		critereRecherche.add(labelRecherche1, gbc_labelRecherche1);

		comboBoxRechercher1 = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxRechercher1 = new GridBagConstraints();
		gbc_comboBoxRechercher1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxRechercher1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxRechercher1.gridx = 2;
		gbc_comboBoxRechercher1.gridy = 2;
		critereRecherche.add(comboBoxRechercher1, gbc_comboBoxRechercher1);
		comboBoxRechercher1.addItem("d'appeler, envoyer des mails et des messages");
		comboBoxRechercher1.addItem("de filmer et/ou prendre des photos de bonne qualit�");
		comboBoxRechercher1.addItem("de jouer a mes jeux vid�os favoris");
		comboBoxRechercher1.setFont(f14plain);

		// Question 2
		JLabel labelRecherche2 = new JLabel("Jouez-vous sur votre smartphone ? Si oui, de quel type ?");
		labelRecherche2.setFont(f14);
		GridBagConstraints gbc_labelRecherche2 = new GridBagConstraints();
		gbc_labelRecherche2.anchor = GridBagConstraints.EAST;
		gbc_labelRecherche2.insets = new Insets(0, 0, 5, 5);
		gbc_labelRecherche2.gridx = 1;
		gbc_labelRecherche2.gridy = 3;
		critereRecherche.add(labelRecherche2, gbc_labelRecherche2);

		comboBoxRechercher2 = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxRechercher2 = new GridBagConstraints();
		gbc_comboBoxRechercher2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxRechercher2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxRechercher2.gridx = 2;
		gbc_comboBoxRechercher2.gridy = 3;
		critereRecherche.add(comboBoxRechercher2, gbc_comboBoxRechercher2);
		comboBoxRechercher2.addItem("Non, jamais");
		comboBoxRechercher2.addItem("Oui, des jeux 2D");
		comboBoxRechercher2.addItem("Oui, des jeux 3D");
		comboBoxRechercher2.setFont(f14plain);

		// Question 3
		JLabel labelRecherche3 = new JLabel("Voulez-vous beaucoup d'autonomie ? ");
		labelRecherche3.setFont(f14);
		GridBagConstraints gbc_labelRecherche3 = new GridBagConstraints();
		gbc_labelRecherche3.anchor = GridBagConstraints.EAST;
		gbc_labelRecherche3.insets = new Insets(0, 0, 5, 5);
		gbc_labelRecherche3.gridx = 1;
		gbc_labelRecherche3.gridy = 4;
		critereRecherche.add(labelRecherche3, gbc_labelRecherche3);

		comboBoxRechercher3 = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxRechercher3 = new GridBagConstraints();
		gbc_comboBoxRechercher3.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxRechercher3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxRechercher3.gridx = 2;
		gbc_comboBoxRechercher3.gridy = 4;
		critereRecherche.add(comboBoxRechercher3, gbc_comboBoxRechercher3);
		comboBoxRechercher3.addItem("Ca m'est egal");
		comboBoxRechercher3.addItem("1 jour me suffit");
		comboBoxRechercher3.addItem("plus d'un jour");
		comboBoxRechercher3.setFont(f14plain);

		// Question 4
		JLabel labelRecherche4 = new JLabel("Utiliserez-vous votre smartphone comme lecteur vid�o ?");
		labelRecherche4.setFont(f14);
		GridBagConstraints gbc_labelRecherche4 = new GridBagConstraints();
		gbc_labelRecherche4.anchor = GridBagConstraints.EAST;
		gbc_labelRecherche4.insets = new Insets(0, 0, 5, 5);
		gbc_labelRecherche4.gridx = 1;
		gbc_labelRecherche4.gridy = 5;
		critereRecherche.add(labelRecherche4, gbc_labelRecherche4);

		comboBoxRechercher4 = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxRechercher4 = new GridBagConstraints();
		gbc_comboBoxRechercher4.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxRechercher4.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxRechercher4.gridx = 2;
		gbc_comboBoxRechercher4.gridy = 5;
		critereRecherche.add(comboBoxRechercher4, gbc_comboBoxRechercher4);
		comboBoxRechercher4.addItem("Jamais");
		comboBoxRechercher4.addItem("�a m'arrive");
		comboBoxRechercher4.addItem("Souvent");
		comboBoxRechercher4.setFont(f14plain);

		// Question 5
		JLabel labelRecherche5 = new JLabel(
				"Seriez-vous prets a payer plus cher pour une meilleure qualit� ?");
		labelRecherche5.setFont(f14);
		GridBagConstraints gbc_labelRecherche5 = new GridBagConstraints();
		gbc_labelRecherche5.insets = new Insets(0, 0, 5, 5);
		gbc_labelRecherche5.anchor = GridBagConstraints.EAST;
		gbc_labelRecherche5.gridx = 1;
		gbc_labelRecherche5.gridy = 6;
		critereRecherche.add(labelRecherche5, gbc_labelRecherche5);

		comboBoxRechercher5 = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxRechercher5 = new GridBagConstraints();
		gbc_comboBoxRechercher5.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxRechercher5.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxRechercher5.gridx = 2;
		gbc_comboBoxRechercher5.gridy = 6;
		critereRecherche.add(comboBoxRechercher5, gbc_comboBoxRechercher5);
		comboBoxRechercher5.addItem("Non, ca m'est egal");
		comboBoxRechercher5.addItem("Oui, c'est important");
		comboBoxRechercher5.setFont(f14plain);

		// Question 6
		JLabel labelRecherche6 = new JLabel("L'appareil photo doit il etre de bonne qualit� ?");
		labelRecherche6.setFont(f14);
		GridBagConstraints gbc_labelRecherche6 = new GridBagConstraints();
		gbc_labelRecherche6.anchor = GridBagConstraints.EAST;
		gbc_labelRecherche6.insets = new Insets(0, 0, 5, 5);
		gbc_labelRecherche6.gridx = 1;
		gbc_labelRecherche6.gridy = 7;
		critereRecherche.add(labelRecherche6, gbc_labelRecherche6);

		comboBoxRechercher6 = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxRechercher6 = new GridBagConstraints();
		gbc_comboBoxRechercher6.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxRechercher6.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxRechercher6.gridx = 2;
		gbc_comboBoxRechercher6.gridy = 7;
		critereRecherche.add(comboBoxRechercher6, gbc_comboBoxRechercher6);
		comboBoxRechercher6.addItem("Pas sp�cialement");
		comboBoxRechercher6.addItem("Oui, absolument");
		comboBoxRechercher6.setFont(f14plain);

		// Question 7
		JLabel labelRecherche7 = new JLabel("Combien seriez-vous pret a investir dans votre smartphone ?");
		labelRecherche6.setFont(f14);
		GridBagConstraints gbc_labelRecherche7 = new GridBagConstraints();
		gbc_labelRecherche7.anchor = GridBagConstraints.EAST;
		gbc_labelRecherche7.insets = new Insets(0, 0, 5, 5);
		gbc_labelRecherche7.gridx = 1;
		gbc_labelRecherche7.gridy = 8;
		critereRecherche.add(labelRecherche7, gbc_labelRecherche7);

		comboBoxRechercher7 = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxRechercher7 = new GridBagConstraints();
		gbc_comboBoxRechercher7.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxRechercher7.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxRechercher7.gridx = 2;
		gbc_comboBoxRechercher7.gridy = 8;
		critereRecherche.add(comboBoxRechercher7, gbc_comboBoxRechercher7);
		comboBoxRechercher7.addItem("Moins de 200�");
		comboBoxRechercher7.addItem("Moins de 600�");
		comboBoxRechercher7.addItem("Plus de  600�");
		comboBoxRechercher7.setFont(f14plain);

		// Bouton Rechercher
		btnRechercher = new JButton("RECHERCHER");
		GridBagConstraints gbc_btnRechercher = new GridBagConstraints();
		gbc_btnRechercher.insets = new Insets(0, 0, 0, 5);
		gbc_btnRechercher.anchor = GridBagConstraints.EAST;
		gbc_btnRechercher.gridx = 2;
		gbc_btnRechercher.gridy = 11;
		critereRecherche.add(btnRechercher, gbc_btnRechercher);
				
		//label aide
		labelAideRecherche = new JLabel("");
		labelAideRecherche.setFont(italic);
		GridBagConstraints gbc_labelAideRecherche = new GridBagConstraints();
		gbc_labelAideRecherche.anchor = GridBagConstraints.WEST;
		gbc_labelAideRecherche.insets = new Insets(0, 0, 5, 0);
		gbc_labelAideRecherche.gridx = 0;
		gbc_labelAideRecherche.gridy = 1;
		this.add(labelAideRecherche, gbc_labelAideRecherche);
				
		//panel des offres proposees
		listeRecherche = new JScrollPane();
	}

	/**
	 * Getter de l'attribut tableOffre
	 * @return l'attribut tableOffre
	 */
	public JScrollPane getListeRecherche() {
		return listeRecherche;
	}

	/**
	 * Getter de l'attribut tableRecherche
	 * @return l'attribut tableRecherche
	 */
	public JTable getTableRecherche() {
		return tableRecherche;
	}

	/**
	 * Definie l'attribut tableRecherche a la valeur passee en parametre
	 * @return l'attribut tableRecherche
	 */
	public void setTableRecherche(JTable tableRecherche) {
		this.tableRecherche = tableRecherche;
	}

	/**
	 * Getter de l'attribut tableRechercheModel
	 * @return l'attribut tableRechercheModel
	 */
	public DefaultTableModel getTableRechercheModel() {
		return tableRechercheModel;
	}

	/**
	 * * Definie l'attribut tableRechercheModel a la valeur passee en parametre
	 * @param tableRechercheModel
	 */
	public void setTableRechercheModel(DefaultTableModel tableRechercheModel) {
		this.tableRechercheModel = tableRechercheModel;
	}

	/**
	 * Getter de l'attribut labelRechercherTop
	 * @return l'attribut labelRechercherTop
	 */
	public JLabel getLabelRechercherTop() {
		return labelRechercherTop;
	}

	/**
	 * Getter de l'attribut comboBoxRechercher1
	 * @return l'attribut comboBoxRechercher1
	 */
	public JComboBox<String> getComboBoxRechercher1() {
		return comboBoxRechercher1;
	}

	/**
	 * Getter de l'attribut comboBoxRechercher2
	 * @return l'attribut comboBoxRechercher2
	 */
	public JComboBox<String> getComboBoxRechercher2() {
		return comboBoxRechercher2;
	}

	/**
	 * Getter de l'attribut comboBoxRechercher3
	 * @return l'attribut comboBoxRechercher3
	 */
	public JComboBox<String> getComboBoxRechercher3() {
		return comboBoxRechercher3;
	}

	/**
	 * Renvoie la combobox contenant les reponses a la question 4
	 * @return La combobox contenant les reponses a la question 4
	 */
	public JComboBox<String> getComboBoxRechercher4() {
		return comboBoxRechercher4;
	}

	/**
	 * Renvoie la combobox contenant les reponses a la question 5
	 * @return La combobox contenant les reponses a la question 5
	 */
	public JComboBox<String> getComboBoxRechercher5() {
		return comboBoxRechercher5;
	}

	/**
	 * Renvoie la combobox contenant les reponses a la question 6
	 * @return La combobox contenant les reponses a la question 6
	 */
	public JComboBox<String> getComboBoxRechercher6() {
		return comboBoxRechercher6;
	}

	/**
	 * Renvoie la combobox contenant les reponses a la question 7
	 * @return La combobox contenant les reponses a la question 7
	 */
	public JComboBox<String> getComboBoxRechercher7() {
		return comboBoxRechercher7;
	}

	/**
	 * Renvoie le bouton pour lancer la recherche
	 * @return Le bouton pour lancer la recherche
	 */
	public JButton getBtnRechercher() {
		return btnRechercher;
	}

	/**
	 * Renvoie le label affichant les details de la recherche une fois lancee
	 * @return Le label affichant les details de la recherche une fois lancee
	 */
	public JLabel getLabelAideRecherche() {
		return labelAideRecherche;
	}
	
	
}
