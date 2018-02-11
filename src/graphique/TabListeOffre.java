package graphique;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Classe gerant l'onglet pour consulter les offres
 * 
 */
@SuppressWarnings("serial")
public class TabListeOffre extends JScrollPane{
	
	/**
	 * Tableau content l'ensemble des offres disponibles
	 */
	private JTable tableOffre;
	
	/**
	 * Modele du tableau content l'ensemble des offres disponibles
	 */
	private DefaultTableModel tableOffreModel;
	
	/**
	 * Combobox contenant les disques durs
	 */
	private JComboBox<String> comboBoxModifBatterie;
	
	/**
	 * Combobox contenant les ram
	 */
	private JComboBox<String> comboBoxModifAppareilPhoto;
	
	/**
	 * Combobox contenant les cartes graphiques
	 */
	private JComboBox<String> comboBoxModifEcran;
	
	/**
	 * Combobox contenant les processeurs
	 */
	private JComboBox<String> comboBoxModifProcesseur;
	
	/**
	 * Combobox permettant de reserver ou non une offre
	 */
	private JComboBox<String> comboBoxModifReserve;
	
	/**
	 * Constructeur de l'onglet pour consulter les offres
	 */
	public TabListeOffre(){
		tableOffre = null;
		tableOffreModel = new DefaultTableModel();
		
		comboBoxModifBatterie = new JComboBox<String>();
		comboBoxModifAppareilPhoto = new JComboBox<String>();
		comboBoxModifEcran = new JComboBox<String>();
		comboBoxModifProcesseur = new JComboBox<String>();
		comboBoxModifReserve = new JComboBox<String>();
	}

	/**
	 * Getter de l'attribut tableOffre
	 * @return l'attribut tableOffre
	 */
	public JTable getTableOffre() {
		return tableOffre;
	}

	/**
	 * Definie l'attribut tableOffre a la valeur passee en parametre
	 * @param tableOffre
	 */
	public void setTableOffre(JTable tableOffre) {
		this.tableOffre = tableOffre;
	}

	/**
	 * Getter de l'attribut tableOffreModel
	 * @return l'attribut tableOffreModel
	 */
	public DefaultTableModel getTableOffreModel() {
		return tableOffreModel;
	}

	/**
	 * Getter de l'attribut comboBoxModifDisqueDur
	 * @return l'attribut comboBoxModifDisqueDur
	 */
	public JComboBox<String> getComboBoxModifBatterie() {
		return comboBoxModifBatterie;
	}

	/**
	 * Getter de l'attribut comboBoxModifRam
	 * @return l'attribut comboBoxModifRam
	 */
	public JComboBox<String> getComboBoxModifAppareilPhoto() {
		return comboBoxModifAppareilPhoto;
	}

	/**
	 * Getter de l'attribut comboBoxModifCarteGraphique
	 * @return l'attribut comboBoxModifCarteGraphique
	 */
	public JComboBox<String> getComboBoxModifEcran() {
		return comboBoxModifEcran;
	}

	/**
	 * Getter de l'attribut comboBoxModifCpu
	 * @return l'attribut comboBoxModifCpu
	 */
	public JComboBox<String> getComboBoxModifProcesseur() {
		return comboBoxModifProcesseur;
	}

	/**
	 * Getter de l'attribut comboBoxModifReserve
	 * @return l'attribut comboBoxModifReserve
	 */
	public JComboBox<String> getComboBoxModifReserve() {
		return comboBoxModifReserve;
	}
	
	
}
