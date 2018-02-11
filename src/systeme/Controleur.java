package systeme;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultCellEditor;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import graphique.Graphique;
import ordinateur.CarteGraphique;
import ordinateur.Composant;
import ordinateur.Cpu;
import ordinateur.Db;
import ordinateur.DisqueDur;
import ordinateur.Evaluation;
import ordinateur.Ordinateur;
import ordinateur.Ram;
import smartphone.*;

/**
 * Classe qui controle les interactions entre l'homme et la machine
 */
@SuppressWarnings("serial")
public class Controleur {

    /**
     * Objet de connexion a la base de donnees
     */
	private final Db db;
	
    /**
     * Objet graphique associe a ce controleur
     */
	private Graphique graphique;
	
    /**
     * Instance du controleur
     */
	private static Controleur instance;
	
    /**
     * Booleen qui indique si on est administrateur (true) ou utilisateur (false)
     */
	private boolean admin;
	
    /**
     * Constructeur d'un objet controleur
     * @param db Objet de connexion a la base de donnees
     * @param graphique Graphique associe a ce controleur
     */
	Controleur(Db db, Graphique graphique) {
		this.db = db;
		this.graphique = graphique;
		Controleur.instance = this;
	}
	
    /**
     * EventListeners de l'onglet "Authentification"
     * Appuie sur la touche entree fait une action sur le bouton administrateur
     * Appuie sur le bouton utilisateur donne les acces de l'utilisateur
     * Appuie sur le bouton administrateur donne les acces de l'administrateur
     */
	public void addEventListenerAuthentification() {
		graphique.getTabAuthentifier().getPasswordField().addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					graphique.getTabAuthentifier().getBtnAdministrateur().doClick();
				}
			}
		});

		graphique.getTabAuthentifier().getBtnUtilisateur().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				admin = false;

				graphique.getTabbedPane().remove(graphique.getTabAuthentifier());
				graphique.addTabRecherche();
				graphique.addTabDisconnect();
				instance.addEventListenerBoutonRechercher();
				instance.addEventListenerDisconnect();
			}
		});

		graphique.getTabAuthentifier().getBtnAdministrateur().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (String.valueOf(graphique.getTabAuthentifier().getPasswordField().getPassword()).equals("admin")) {
					admin = true;
					graphique.getTabbedPane().remove(graphique.getTabAuthentifier());
					graphique.addTabRecherche();
					graphique.addTabAjoutOffre();
					graphique.addTabAjoutReference();
					graphique.addTabListeOffres();
					graphique.addTabDisconnect();

					instance.fillTableOffres();
					instance.fillComboBox();
					instance.addEventListenerBoutonRechercher();
					instance.addEventListenerAjoutOffrePrix();
					instance.addEventListenerAjoutReference();
					instance.addEventListenerBoutonAjoutOffre();
					instance.addEventListenerBoutonAjoutReference();
					instance.addEventListenerChangeTab();
					instance.addEventListenerDisconnect();
					instance.addEventListenerTableListeOffre();

				} else {
					JOptionPane.showMessageDialog(graphique, "Le mot de passe est incorrect");
				}
			}
		});
	}
	
    /**
     * Definit la structure et remplit la table des offres
     */
	public void fillTableOffres() {

		Object[] tableHeader = new String[] { "ID", "Ecran", "Processeur", "Batterie", "Appareil Photo", "Prix"};
		graphique.getTabListeOffre().getTableOffreModel().setColumnIdentifiers(tableHeader);

		for (TreeMap<String, String> row : db.getRowsFrom("smartphone")) {
			
			String[] tableRow;
	
			tableRow = new String[] { row.get("id"), row.get("ecran"), row.get("processeur"),
					row.get("batterie"), row.get("appareil_photo"), row.get("prix"), row.get("marque")};

			graphique.getTabListeOffre().getTableOffreModel().addRow(tableRow);
		}

		graphique.getTabListeOffre().setTableOffre(new JTable(graphique.getTabListeOffre().getTableOffreModel()) {
			public boolean isCellEditable(int row, int column) {
				if (column == 0 || column == 5)
					return false;
				else
					return true;
			}
		});
		graphique.getTabListeOffre().getTableOffre().getTableHeader().setReorderingAllowed(false);

		//layout de la table des offres
		double largeur = graphique.getSize().getWidth();
		double[] tailleCol = new double[]{largeur/16, largeur/6, largeur/8,  largeur /6, largeur / 4, largeur/10};
		
		for(int i = 0 ; i < graphique.getTabListeOffre().getTableOffre().getColumnCount() - 1; i++){
			graphique.getTabListeOffre().getTableOffre().getColumnModel().getColumn(i).setPreferredWidth((int) tailleCol[i] );
		}
		
		DefaultTableCellRenderer centrer = new DefaultTableCellRenderer();
		centrer.setHorizontalAlignment(JLabel.CENTER);
		for(int i = 0 ; i < graphique.getTabListeOffre().getTableOffre().getColumnCount() ; i++){
			graphique.getTabListeOffre().getTableOffre().getColumnModel().getColumn(i).setCellRenderer(centrer);
		}
		
		graphique.getTabListeOffre().getTableOffre().getColumn("Ecran")
				.setCellEditor(new DefaultCellEditor(graphique.getTabListeOffre().getComboBoxModifEcran()));
		graphique.getTabListeOffre().getTableOffre().getColumn("Processeur").setCellEditor(new DefaultCellEditor(graphique.getTabListeOffre().getComboBoxModifProcesseur()));
		graphique.getTabListeOffre().getTableOffre().getColumn("Batterie")
				.setCellEditor(new DefaultCellEditor(graphique.getTabListeOffre().getComboBoxModifBatterie()));
		graphique.getTabListeOffre().getTableOffre().getColumn("Appareil Photo").setCellEditor(new DefaultCellEditor(graphique.getTabListeOffre().getComboBoxModifAppareilPhoto()));
		graphique.getTabListeOffre().getTableOffre().getColumn("Marque").setCellEditor(new DefaultCellEditor(graphique.getTabListeOffre().getComboBoxModifReserve()));

		graphique.getTabListeOffre().getTableOffre().setRowHeight(20);
		graphique.getTabListeOffre().getViewport().add(graphique.getTabListeOffre().getTableOffre());
		
	}
	
	
	
	
    /**
     * Remplit toutes les comboBox 
     */
	public void fillComboBox() {
		for (TreeMap<String, String> row : db.getRowsFrom("carte_graphique")) {
			graphique.getTabAjoutOffre().getComboBoxAjoutOffreEcran().addItem(row.get("reference"));
			graphique.getTabListeOffre().getComboBoxModifEcran().addItem(row.get("reference"));
		}

		for (TreeMap<String, String> row : db.getRowsFrom("cpu")) {
			graphique.getTabAjoutOffre().getComboBoxAjoutOffreProcesseur().addItem(row.get("reference"));
			graphique.getTabListeOffre().getComboBoxModifProcesseur().addItem(row.get("reference"));
		}

		for (TreeMap<String, String> row : db.getRowsFrom("disque_dur")) {
			graphique.getTabAjoutOffre().getComboBoxAjoutOffreBatterie().addItem(row.get("reference"));
			graphique.getTabListeOffre().getComboBoxModifBatterie().addItem(row.get("reference"));
		}

		for (TreeMap<String, String> row : db.getRowsFrom("ram")) {
			graphique.getTabAjoutOffre().getComboBoxAjoutOffreAppareilPhoto().addItem(row.get("reference"));
			graphique.getTabListeOffre().getComboBoxModifAppareilPhoto().addItem(row.get("reference"));
		}

		graphique.getTabListeOffre().getComboBoxModifReserve().addItem("Disponible");
		graphique.getTabListeOffre().getComboBoxModifReserve().addItem("Reserve");

		String[] composants = new String[] { "Carte Graphique", "CPU", "Disque Dur", "RAM" };
		for (String composant : composants) {
			graphique.getTabAjoutReference().getComboBoxAjoutReference().addItem(composant);
		}
	}
	
    /**
     * EventListeners de l'onglet "Consulter les offres"
     * Modification de la table
     */
	public void addEventListenerTableListeOffre() {
		
		// Action a effectuer lorsque la table est modifie
		AbstractAction modificationTable = new AbstractAction(){
					
		    public void actionPerformed(ActionEvent e){
		        TableCellListener tcl = (TableCellListener)e.getSource();
				        
		        int column = tcl.getColumn();
				int row = tcl.getRow();
				double ancienPrixComposant, nouveauPrixComposant, nouveauPrixOffre;
				String sql;

				if(column != 5 && column != 6){
				// Lorsqu'un ordinateur est modifie (hormis le prix et la
				// reservation)

					// On copie notre modification dans "ordi"
					Ordinateur ordi = new Ordinateur(
							new CarteGraphique(db, (String) graphique.getTabListeOffre().getTableOffre().getValueAt(row, 1)),
							new Cpu(db, (String) graphique.getTabListeOffre().getTableOffre().getValueAt(row, 2)),
							new DisqueDur(db, (String) graphique.getTabListeOffre().getTableOffre().getValueAt(row, 3)),
							new Ram(db, (String) graphique.getTabListeOffre().getTableOffre().getValueAt(row, 4)));
							

					// On verifie avant de modifier que l'ordinateur n'existe
					// pas deja
					if (!db.isPresent(ordi)) {

						// Recupere l'ancien prix du composant retirer
						sql = "SELECT " + db.getColumnNamesFrom("ordinateur")[column] + ".prix FROM "
								+ db.getColumnNamesFrom("ordinateur")[column] + ", ordinateur " + "WHERE ordinateur."
								+ db.getColumnNamesFrom("ordinateur")[column] + " = "
								+ db.getColumnNamesFrom("ordinateur")[column] + ".reference AND ordinateur.id="
								+ graphique.getTabListeOffre().getTableOffre().getValueAt(row, 0) + ";";
						ancienPrixComposant = Double.parseDouble(db.getRowFromQuery(sql).get("prix"));

						// Acualise le composant
						sql = "UPDATE ordinateur SET " + db.getColumnNamesFrom("ordinateur")[column] + "='"
								+ graphique.getTabListeOffre().getTableOffre().getValueAt(row, column) + "' WHERE id="
								+ graphique.getTabListeOffre().getTableOffre().getValueAt(row, 0) + ";";
						db.updateRowFromQuery(sql);

						// Actualise le prix de l'offre
						sql = "SELECT prix FROM " + db.getColumnNamesFrom("ordinateur")[column] + " WHERE reference='"
								+ graphique.getTabListeOffre().getTableOffre().getValueAt(row, column) + "';";
						nouveauPrixComposant = Double.parseDouble(db.getRowFromQuery(sql).get("prix"));

						nouveauPrixOffre = Double.parseDouble((String) graphique.getTabListeOffre().getTableOffre().getValueAt(row, 5))
								- ancienPrixComposant + nouveauPrixComposant;

						sql = "UPDATE ordinateur SET prix=" + nouveauPrixOffre + " WHERE id="
								+ graphique.getTabListeOffre().getTableOffre().getValueAt(row, 0) + ";";
						db.updateRowFromQuery(sql);
						graphique.getTabListeOffre().getTableOffre().setValueAt("" + nouveauPrixOffre, row, 5);
					} else {
						JOptionPane.showMessageDialog(graphique,
								"L'ordinateur existe deja, votre modification n'est pas prise en compte");
						graphique.getTabListeOffre().getTableOffre().setValueAt(tcl.getOldValue(), row, column);
					}
				} else if (column == 6) {
					// Si on passe de disponible a reserve
					if (graphique.getTabListeOffre().getComboBoxModifReserve().getSelectedItem().equals("Reserve")) {
						sql = "UPDATE ordinateur SET reserve=1 WHERE id=" + graphique.getTabListeOffre().getTableOffre().getValueAt(row, 0)
								+ ";";
						// Si on passe de disponible a reserve
					} else {
						sql = "UPDATE ordinateur SET reserve=0 WHERE id=" + graphique.getTabListeOffre().getTableOffre().getValueAt(row, 0)
								+ ";";
					}
					db.updateRowFromQuery(sql);
				}
			}
		};
			
		new TableCellListener(graphique.getTabListeOffre().getTableOffre(), modificationTable);

		addEventListenerSupprimer();
	}

	
    /**
     * EventListeners de l'onglet "Consulter les offres"
     * Ajoute le menu contextuel avec possibilitee de supprimer
     */
	public void addEventListenerSupprimer() {

		JPopupMenu popupMenu = new JPopupMenu();
		JMenuItem itemSupprimer = new JMenuItem("Supprimer");
		itemSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (graphique.getTabListeOffre().getTableOffre().getSelectedRows().length != 0) {
					// 0 correspond a oui"
					if (JOptionPane.showConfirmDialog(graphique,
							"Voulez vraiment supprimer la selection d'offre ?") == 0) {
						int[] rows = graphique.getTabListeOffre().getTableOffre().getSelectedRows();
						for (int i = 0; i < rows.length; i++) {
							String sql = "DELETE FROM ordinateur WHERE id="
									+ graphique.getTabListeOffre().getTableOffre().getValueAt(rows[i] - i, 0) + ";";
							((DefaultTableModel) graphique.getTabListeOffre().getTableOffre().getModel()).removeRow(rows[i] - i);
							db.updateRowFromQuery(sql);
						}
					}
				} else {
					JOptionPane.showMessageDialog(graphique, "Vous n'avez rien selectionne !");
				}
			}
		});

		popupMenu.add(itemSupprimer);
		graphique.getTabListeOffre().getTableOffre().setComponentPopupMenu(popupMenu);
	}

	
    /**
     * EventListeners de l'onglet "Ajouter une offre"
     * Affiche le prix du composant selectionne et le total
     */
	public void addEventListenerAjoutOffrePrix() {
		graphique.getTabAjoutOffre().getComboBoxAjoutOffreEcran().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				graphique.getTabAjoutOffre().getLabelPrixUnitaireEcran().setText(db
						.getRowFromQuery("SELECT prix FROM carte_graphique WHERE reference='"
								+ (String) graphique.getTabAjoutOffre().getComboBoxAjoutOffreEcran().getSelectedItem() + "';")
						.get("prix") + " euros");
				writeTotalInLabel();
			}
		});

		graphique.getTabAjoutOffre().getComboBoxAjoutOffreProcesseur().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				graphique.getTabAjoutOffre().getLabelPrixUnitaireProcesseur().setText(db
						.getRowFromQuery("SELECT prix FROM cpu WHERE reference='"
								+ (String) graphique.getTabAjoutOffre().getComboBoxAjoutOffreProcesseur().getSelectedItem() + "';")
						.get("prix") + " euros");
				writeTotalInLabel();
			}
		});

		graphique.getTabAjoutOffre().getComboBoxAjoutOffreBatterie().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				graphique.getTabAjoutOffre().getLabelPrixUnitaireBatterie().setText(db
						.getRowFromQuery("SELECT prix FROM disque_dur WHERE reference='"
								+ (String) graphique.getTabAjoutOffre().getComboBoxAjoutOffreBatterie().getSelectedItem() + "';")
						.get("prix") + " euros");
				writeTotalInLabel();
			}
		});

		graphique.getTabAjoutOffre().getComboBoxAjoutOffreAppareilPhoto().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				graphique.getTabAjoutOffre().getLabelPrixUnitaireAppareilPhoto().setText(db
						.getRowFromQuery("SELECT prix FROM ram WHERE reference='"
								+ (String) graphique.getTabAjoutOffre().getComboBoxAjoutOffreAppareilPhoto().getSelectedItem() + "';")
						.get("prix") + " euros");
				writeTotalInLabel();
			}
		});
	}

	
    /**
     * EventListeners de l'onglet "Ajouter une reference"
     * Gere l'affichage des champs caracterstiques de chaque reference
     */
	public void addEventListenerAjoutReference() {

		graphique.getTabAjoutReference().getComboBoxAjoutReference().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Active les champs prix et reference
				graphique.getTabAjoutReference().getLabelReference().setEnabled(true);
				graphique.getTabAjoutReference().getTextFieldReference().setEnabled(true);
				graphique.getTabAjoutReference().getLabelPrix().setEnabled(true);
				graphique.getTabAjoutReference().getTextFieldPrix().setEnabled(true);

				// Desactive les autres champs
				graphique.getTabAjoutReference().getTextFieldAjoutReferenceEcran1().setVisible(false);
				graphique.getTabAjoutReference().getTextFieldAjoutReferenceEcran2().setVisible(false);
				graphique.getTabAjoutReference().getTextFieldAjoutReferenceProcesseur1().setVisible(false);
				graphique.getTabAjoutReference().getComboBoxAjoutReferenceProcesseur1().setVisible(false);
				graphique.getTabAjoutReference().getTextFieldAjoutReferenceBatterie1().setVisible(false);
				graphique.getTabAjoutReference().getTextFieldAjoutReferenceBatterie2().setVisible(false);
				graphique.getTabAjoutReference().getComboBoxAjoutReferenceBatterie1().setVisible(false);
				graphique.getTabAjoutReference().getTextFieldAjoutReferenceAppareilPhoto1().setVisible(false);
				graphique.getTabAjoutReference().getTextFieldAjoutReferenceAppareilPhoto2().setVisible(false);
				graphique.getTabAjoutReference().getComboBoxAjoutReferenceAppareilPhoto1().setVisible(false);

				switch ((String) graphique.getTabAjoutReference().getComboBoxAjoutReference().getSelectedItem()) {
				case "Carte Graphique":
					graphique.getTabAjoutReference().getLabelAjoutReference1().setText("Frequence :");
					graphique.getTabAjoutReference().getLabelAjoutReference2().setText("Memoire :");
					graphique.getTabAjoutReference().getLabelAjoutReference3().setText("");
					graphique.getTabAjoutReference().getLabelAjoutReferenceUnite1().setText("MHz");
					graphique.getTabAjoutReference().getLabelAjoutReferenceUnite2().setText("Mo");
					graphique.getTabAjoutReference().getLabelAjoutReferenceUnite3().setText("");
					graphique.getTabAjoutReference().getTextFieldAjoutReferenceEcran1().setVisible(true);
					graphique.getTabAjoutReference().getTextFieldAjoutReferenceEcran2().setVisible(true);
					graphique.getTabbedPane().repaint();

					break;
				case "CPU":
					graphique.getTabAjoutReference().getLabelAjoutReference1().setText("Frequence :");
					graphique.getTabAjoutReference().getLabelAjoutReference2().setText("Coeur :");
					graphique.getTabAjoutReference().getLabelAjoutReference3().setText("");
					graphique.getTabAjoutReference().getLabelAjoutReferenceUnite1().setText("GHz");
					graphique.getTabAjoutReference().getLabelAjoutReferenceUnite2().setText("");
					graphique.getTabAjoutReference().getLabelAjoutReferenceUnite3().setText("");
					graphique.getTabAjoutReference().getTextFieldAjoutReferenceProcesseur1().setVisible(true);
					graphique.getTabAjoutReference().getComboBoxAjoutReferenceProcesseur1().setVisible(true);
					graphique.getTabbedPane().repaint();
					break;
				case "Disque Dur":
					graphique.getTabAjoutReference().getLabelAjoutReference1().setText("Capacite :");
					graphique.getTabAjoutReference().getLabelAjoutReference2().setText("Type :");
					graphique.getTabAjoutReference().getLabelAjoutReference3().setText("Vitesse Rotation (si HDD) :");
					graphique.getTabAjoutReference().getLabelAjoutReferenceUnite1().setText("Go");
					graphique.getTabAjoutReference().getLabelAjoutReferenceUnite2().setText("");
					graphique.getTabAjoutReference().getLabelAjoutReferenceUnite3().setText("RPM");
					graphique.getTabAjoutReference().getTextFieldAjoutReferenceBatterie1().setVisible(true);
					graphique.getTabAjoutReference().getComboBoxAjoutReferenceBatterie1().setVisible(true);
					graphique.getTabAjoutReference().getTextFieldAjoutReferenceBatterie2().setVisible(true);
					graphique.getTabbedPane().repaint();
					break;
				case "RAM":
					graphique.getTabAjoutReference().getLabelAjoutReference1().setText("Capacite :");
					graphique.getTabAjoutReference().getLabelAjoutReference2().setText("Frequence :");
					graphique.getTabAjoutReference().getLabelAjoutReference3().setText("Type :");
					graphique.getTabAjoutReference().getLabelAjoutReferenceUnite1().setText("Go");
					graphique.getTabAjoutReference().getLabelAjoutReferenceUnite2().setText("MHz");
					graphique.getTabAjoutReference().getLabelAjoutReferenceUnite3().setText("");
					graphique.getTabAjoutReference().getTextFieldAjoutReferenceAppareilPhoto1().setVisible(true);
					graphique.getTabAjoutReference().getTextFieldAjoutReferenceAppareilPhoto2().setVisible(true);
					graphique.getTabAjoutReference().getComboBoxAjoutReferenceAppareilPhoto1().setVisible(true);
					graphique.getTabbedPane().repaint();
					break;
				}
			}
		});
	}
	
    /**
     * EventListeners de l'onglet "Ajouter une offre"
     * Appuie sur le bouton provoque l'ajout de l'offre dans la bd après verification
     */
	public void addEventListenerBoutonAjoutOffre() {
		// Event Listener Ajout Offre
		graphique.getTabAjoutOffre().getBtnInsererLoffre().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Pattern.matches("([0-9])+.?([0-9])* euros", graphique.getTabAjoutOffre().getLabelPrixTotal().getText())) {
					Ordinateur ordinateur = new Ordinateur(
							new CarteGraphique(db,
									(String) graphique.getTabAjoutOffre().getComboBoxAjoutOffreEcran().getSelectedItem()),
							new Cpu(db, (String) graphique.getTabAjoutOffre().getComboBoxAjoutOffreProcesseur().getSelectedItem()),
							new DisqueDur(db, (String) graphique.getTabAjoutOffre().getComboBoxAjoutOffreBatterie().getSelectedItem()),
							new Ram(db, (String) graphique.getTabAjoutOffre().getComboBoxAjoutOffreAppareilPhoto().getSelectedItem()));

					if (!db.isPresent(ordinateur)) {

						// Ajout a base de donnee
						Object[] array1 = ordinateur.toArray();
						Object[] array2 = new Object[] { 0 };
						Object[] newArray = Stream.concat(Arrays.stream(array1), Arrays.stream(array2))
								.toArray(Object[]::new);
						db.addToDb("ordinateur", newArray);

						// Ajout au tableau liste des offres
						String sql = "SELECT * FROM ordinateur WHERE carte_graphique='"
								+ graphique.getTabAjoutOffre().getComboBoxAjoutOffreEcran().getSelectedItem() + "' AND " + "cpu='"
								+ graphique.getTabAjoutOffre().getComboBoxAjoutOffreProcesseur().getSelectedItem() + "' AND " + "disque_dur='"
								+ graphique.getTabAjoutOffre().getComboBoxAjoutOffreBatterie().getSelectedItem() + "' AND " + "ram='"
								+ graphique.getTabAjoutOffre().getComboBoxAjoutOffreAppareilPhoto().getSelectedItem() + "';";

						TreeMap<String, String> row = db.getRowFromQuery(sql);
						String[] tableRow = new String[] { row.get("id"), row.get("carte_graphique"), row.get("cpu"),
								row.get("disque_dur"), row.get("ram"), row.get("prix"), "Reserve" };
						((DefaultTableModel) graphique.getTabListeOffre().getTableOffre().getModel()).addRow(tableRow);

						JOptionPane.showMessageDialog(graphique, "La configuration a bien ete ajoutee");
					} else {
						JOptionPane.showMessageDialog(graphique, "La configuration existe deja !");
					}
				} else {
					JOptionPane.showMessageDialog(graphique, "Veuillez remplir tous les champs !");
				}
			}
		});
	}
	
    /**
     * EventListeners de l'onglet "Ajouter une reference"
     * Appuie sur le bouton provoque l'ajout de la reference du composant dans la bd
     */
	public void addEventListenerBoutonAjoutReference() {
		// Event Listener Ajout Reference
		graphique.getTabAjoutReference().getBtnInsererReference().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean ok = false;
				String table = "";
				Composant composant = null;

				switch ((String) graphique.getTabAjoutReference().getComboBoxAjoutReference().getSelectedItem()) {
				case "Carte Graphique":
					if (Pattern.matches("([0-9])+.?([0-9]){0,2}", graphique.getTabAjoutReference().getTextFieldPrix().getText())
							&& Pattern.matches("([0-9])+", graphique.getTabAjoutReference().getTextFieldAjoutReferenceEcran1().getText())
							&& Pattern.matches("([0-9])+", graphique.getTabAjoutReference().getTextFieldAjoutReferenceEcran2().getText())) {
						ok = true;
						composant = new CarteGraphique(graphique.getTabAjoutReference().getTextFieldReference().getText(),
								Double.parseDouble(graphique.getTabAjoutReference().getTextFieldPrix().getText()),
								Integer.parseInt(graphique.getTabAjoutReference().getTextFieldAjoutReferenceEcran1().getText()),
								Integer.parseInt(graphique.getTabAjoutReference().getTextFieldAjoutReferenceEcran2().getText()));
						table = "carte_graphique";
						graphique.getTabListeOffre().getComboBoxModifEcran().addItem(graphique.getTabAjoutReference().getTextFieldReference().getText());
						graphique.getTabAjoutOffre().getComboBoxAjoutOffreEcran().addItem(graphique.getTabAjoutReference().getTextFieldReference().getText());
					}
					break;
				case "CPU":
					if (Pattern.matches("([0-9])+.?([0-9]){0,2}", graphique.getTabAjoutReference().getTextFieldPrix().getText()) && Pattern
							.matches("([0-9])+.?([0-9]){0,2}", graphique.getTabAjoutReference().getTextFieldAjoutReferenceProcesseur1().getText())) {
						ok = true;
						composant = new Cpu(graphique.getTabAjoutReference().getTextFieldReference().getText(),
								Double.parseDouble(graphique.getTabAjoutReference().getTextFieldPrix().getText()),
								Double.parseDouble(graphique.getTabAjoutReference().getTextFieldAjoutReferenceProcesseur1().getText()),
								(String) graphique.getTabAjoutReference().getComboBoxAjoutReferenceProcesseur1().getSelectedItem());
						table = "cpu";
						graphique.getTabListeOffre().getComboBoxModifProcesseur().addItem(graphique.getTabAjoutReference().getTextFieldReference().getText());
						graphique.getTabAjoutOffre().getComboBoxAjoutOffreProcesseur().addItem(graphique.getTabAjoutReference().getTextFieldReference().getText());
					}
					break;
				case "Disque Dur":

					table = "disque_dur";

					if (graphique.getTabAjoutReference().getComboBoxAjoutReferenceBatterie1().getSelectedItem().equals("SSD")) {

						if (Pattern.matches("([0-9])+.?([0-9]){0,2}", graphique.getTabAjoutReference().getTextFieldPrix().getText())
								&& Pattern.matches("([0-9])+", graphique.getTabAjoutReference().getTextFieldAjoutReferenceBatterie1().getText())) {
							ok = true;
							composant = new DisqueDur(graphique.getTabAjoutReference().getTextFieldReference().getText(),
									Double.parseDouble(graphique.getTabAjoutReference().getTextFieldPrix().getText()),
									Integer.parseInt(graphique.getTabAjoutReference().getTextFieldAjoutReferenceBatterie1().getText()),
									(String) graphique.getTabAjoutReference().getComboBoxAjoutReferenceBatterie1().getSelectedItem(), 0);
							graphique.getTabListeOffre().getComboBoxModifBatterie().addItem(graphique.getTabAjoutReference().getTextFieldReference().getText());
							graphique.getTabAjoutOffre().getComboBoxAjoutOffreBatterie().addItem(graphique.getTabAjoutReference().getTextFieldReference().getText());
						}
					} else {
						if (Pattern.matches("([0-9])+.?([0-9]){0,2}", graphique.getTabAjoutReference().getTextFieldPrix().getText())
								&& Pattern.matches("([0-9])+", graphique.getTabAjoutReference().getTextFieldAjoutReferenceBatterie1().getText())
								&& Pattern.matches("([0-9])+", graphique.getTabAjoutReference().getTextFieldAjoutReferenceBatterie2().getText())) {
							ok = true;
							composant = new DisqueDur(graphique.getTabAjoutReference().getTextFieldReference().getText(),
									Double.parseDouble(graphique.getTabAjoutReference().getTextFieldPrix().getText()),
									Integer.parseInt(graphique.getTabAjoutReference().getTextFieldAjoutReferenceBatterie1().getText()),
									(String) graphique.getTabAjoutReference().getComboBoxAjoutReferenceBatterie1().getSelectedItem(),
									Integer.parseInt(graphique.getTabAjoutReference().getTextFieldAjoutReferenceBatterie2().getText()));
							graphique.getTabListeOffre().getComboBoxModifBatterie().addItem(graphique.getTabAjoutReference().getTextFieldReference().getText());
							graphique.getTabAjoutOffre().getComboBoxAjoutOffreBatterie().addItem(graphique.getTabAjoutReference().getTextFieldReference().getText());
						}
					}
					break;
				case "RAM":
					if (Pattern.matches("([0-9])+.?([0-9]){0,2}", graphique.getTabAjoutReference().getTextFieldPrix().getText())
							&& Pattern.matches("([0-9])+", graphique.getTabAjoutReference().getTextFieldAjoutReferenceAppareilPhoto1().getText())
							&& Pattern.matches("([0-9])+", graphique.getTabAjoutReference().getTextFieldAjoutReferenceAppareilPhoto2().getText())) {
						ok = true;
						composant = new Ram(graphique.getTabAjoutReference().getTextFieldReference().getText(),
								Double.parseDouble(graphique.getTabAjoutReference().getTextFieldPrix().getText()),
								Integer.parseInt(graphique.getTabAjoutReference().getTextFieldAjoutReferenceAppareilPhoto1().getText()),
								Integer.parseInt(graphique.getTabAjoutReference().getTextFieldAjoutReferenceAppareilPhoto2().getText()),
								(String) graphique.getTabAjoutReference().getComboBoxAjoutReferenceAppareilPhoto1().getSelectedItem());
						table = "ram";
						graphique.getTabListeOffre().getComboBoxModifAppareilPhoto().addItem(graphique.getTabAjoutReference().getTextFieldReference().getText());
						graphique.getTabAjoutOffre().getComboBoxAjoutOffreAppareilPhoto().addItem(graphique.getTabAjoutReference().getTextFieldReference().getText());
					}
					break;
				}

				if (!ok) {
					JOptionPane.showMessageDialog(graphique, "Un des champs n'est pas correct !");
				} else if (db.isPresent(composant)) {
					JOptionPane.showMessageDialog(graphique, "La reference existe dejaࠡ");
				} else {
					db.addToDb(table, composant.toArray());
					JOptionPane.showMessageDialog(graphique, "La reference a bien ete ajoutee");
				}

			}
		});

		graphique.getTabAjoutReference().getComboBoxAjoutReferenceBatterie1().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (graphique.getTabAjoutReference().getComboBoxAjoutReferenceBatterie1().getSelectedItem().equals("SSD")) {
					graphique.getTabAjoutReference().getTextFieldAjoutReferenceBatterie2().setEnabled(false);
				} else {
					graphique.getTabAjoutReference().getTextFieldAjoutReferenceBatterie2().setEnabled(true);
				}
			}
		});
	}
	
    /**
     * EventListeners sur tous les onglets
     * Actualise la fenetre graphique de l'onglet courant
     */
	public void addEventListenerChangeTab() {
		graphique.getTabbedPane().addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent changeEvent) {
				JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
				sourceTabbedPane.repaint();
			}
		});
	}
	
    /**
     * EventListeners de l'onglet "Rechercher"
     * Appuie sur bouton provoque l'evaluation des ordinateurs selon le formulaire
     * Affiche les meilleurs ordinateurs
     */
	public void addEventListenerBoutonRechercher() {
		graphique.getTabRecherche().getBtnRechercher().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				/*
				 * getSelectedIndex donne le choix selectionne
				 */
				Evaluation eval = new Evaluation(db, graphique.getTabRecherche().getComboBoxRechercher1().getSelectedIndex(),
						graphique.getTabRecherche().getComboBoxRechercher2().getSelectedIndex(),
						graphique.getTabRecherche().getComboBoxRechercher3().getSelectedIndex(),
						graphique.getTabRecherche().getComboBoxRechercher4().getSelectedIndex(),
						graphique.getTabRecherche().getComboBoxRechercher5().getSelectedIndex(),
						graphique.getTabRecherche().getComboBoxRechercher6().getSelectedIndex(),
						graphique.getTabRecherche().getComboBoxRechercher7().getSelectedIndex());

				String budget;
				// Si l'option selectionn� est "Ca m'est egal"
				if(graphique.getTabRecherche().getComboBoxRechercher8().getSelectedIndex() == 4){
					budget = "";
				}else{
					budget = "AND prix<";
					String reponse = (String) graphique.getTabRecherche().getComboBoxRechercher8().getSelectedItem();
					int prix = Integer.parseInt(reponse.substring(0, 4).trim());
					int tolerancePrix = (int) (prix + 0.1 * prix);
					budget += tolerancePrix;
				}

				// Tableau qui associe une evaluation a un ordinateur
				SortedMap<Integer, Double> map = new TreeMap<Integer, Double>();
				
				// On evalue tous les ordinateurs et on remplit le tableau
				for (TreeMap<String, String> row : db.getRowsFrom("ordinateur", "reserve=0 " + budget)) {
					Ordinateur ordi = new Ordinateur(new CarteGraphique(db, row.get("carte_graphique")),
							new Cpu(db, row.get("cpu")), new DisqueDur(db, row.get("disque_dur")),
							new Ram(db, row.get("ram")));

					map.put(Integer.parseInt(row.get("id")), eval.evaluer(ordi));
				}

				// On trie les ordinateurs selont leurs evaluations
				SortedSet<Map.Entry<Integer, Double>> sortedMap = new TreeSet<Map.Entry<Integer, Double>>(
						new Comparator<Map.Entry<Integer, Double>>() {
							@Override
							public int compare(Map.Entry<Integer, Double> e1, Map.Entry<Integer, Double> e2) {
								return e2.getValue().compareTo(e1.getValue());
							}
						});
				sortedMap.addAll(map.entrySet());

				// Creation du tableau de recherche
				graphique.getTabRecherche().setTableRechercheModel(new DefaultTableModel());
				Object[] tableHeader = new String[] { "ID", "Carte Graphique", "CPU", "Disque Dur", "RAM",
						"Prix (euros)" };
				graphique.getTabRecherche().getTableRechercheModel().setColumnIdentifiers(tableHeader);

				int nbOrdi = 1;
				for (Map.Entry<Integer, Double> ordi : sortedMap) {
					if (nbOrdi > eval.NB_RESULTATS && ordi.getValue() < eval.EXIGENCE)
						break;

					String sql = "SELECT * FROM ordinateur WHERE id=" + ordi.getKey() + ";";
					TreeMap<String, String> row = db.getRowFromQuery(sql);

					String[] tableRow = { row.get("id"), row.get("carte_graphique"), row.get("cpu"),
							row.get("disque_dur"), row.get("ram"), row.get("prix") };

					graphique.getTabRecherche().getTableRechercheModel().addRow(tableRow);

					nbOrdi++;
				}

				// propositions
				graphique.getTabRecherche().setTableRecherche(new JTable(graphique.getTabRecherche().getTableRechercheModel()) {
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				});
				
				//layout de la table des offres
				double largeur = graphique.getSize().getWidth();
				double[] tailleCol = new double[]{largeur/16, largeur/6, largeur/8,  largeur /6, largeur / 4};
				
				for(int i = 0 ; i < graphique.getTabRecherche().getTableRecherche().getColumnCount() - 1; i++){
					graphique.getTabRecherche().getTableRecherche().getColumnModel().getColumn(i).setPreferredWidth((int) tailleCol[i] );
				}
				
				DefaultTableCellRenderer centrer = new DefaultTableCellRenderer();
				centrer.setHorizontalAlignment(JLabel.CENTER);
				for(int i = 0 ; i < graphique.getTabRecherche().getTableRecherche().getColumnCount() ; i++){
					graphique.getTabRecherche().getTableRecherche().getColumnModel().getColumn(i).setCellRenderer(centrer);
				}
				
				graphique.getTabRecherche().getTableRecherche().setRowHeight(20);
				graphique.getTabRecherche().getTableRecherche().setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				graphique.getTabRecherche().getListeRecherche().getViewport().add(graphique.getTabRecherche().getTableRecherche());

				GridBagConstraints gbc_listeRecherche = new GridBagConstraints();
				gbc_listeRecherche.anchor = GridBagConstraints.NORTH;
				gbc_listeRecherche.fill = GridBagConstraints.BOTH;
				gbc_listeRecherche.gridx = 0;
				gbc_listeRecherche.gridy = 2;
				gbc_listeRecherche.fill = GridBagConstraints.BOTH;
				graphique.getTabRecherche().add(graphique.getTabRecherche().getListeRecherche(), gbc_listeRecherche);

				graphique.repaint();

				addChangeListenerReservation();

				// On fait apparaitre le label qui explique
				graphique.getTabRecherche().getLabelAideRecherche().setText(
						"<html><b>Resultats trouves : " + graphique.getTabRecherche().getTableRecherche().getRowCount() + "</b><br>Voici les ordinateurs qui correspondent le plus a vos besoins. "
								+ "Pour en reserver un, effectuez un clic droit sur celui-ci.</html>");
			}
		});

	}
	
    /**
     * EventListeners de l'onglet "Rechercher"
     * Ajoute le menu contextuel avec possibilite de reserver
     */
	public void addChangeListenerReservation() {

		JPopupMenu popupMenu = new JPopupMenu();
		JMenuItem itemReserver = new JMenuItem("Reserver");
		itemReserver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// SI on selectionne une offre pour reserver
				if (graphique.getTabRecherche().getTableRecherche().getSelectedRows().length == 1) {
					int idCourant = Integer.parseInt(
							(String) graphique.getTabRecherche().getTableRecherche().getValueAt(graphique.getTabRecherche().getTableRecherche().getSelectedRow(), 0));
					String sql = "UPDATE ordinateur SET reserve=1 WHERE id=" + idCourant + ";";
					db.updateRowFromQuery(sql);
					if (admin == true) {
						int i = 0;
						while (Integer.parseInt((String) graphique.getTabListeOffre().getTableOffre().getValueAt(i, 0)) != idCourant) {
							i++;
						}
						graphique.getTabListeOffre().getTableOffre().setValueAt("Reserve", i, 6);
					}
					JOptionPane.showMessageDialog(graphique, "Votre reservation a bien ete prise en compte !");

					// Si on ne selectionne pas d'offre a reserver
				} else if (graphique.getTabRecherche().getTableRecherche().getSelectedRows().length == 0) {
					JOptionPane.showMessageDialog(graphique, "Vous n'avez rien s鬥ctionne !");

					// SI on selectionne plusieurs offres
				} else {
					JOptionPane.showMessageDialog(graphique,
							"Vous ne pouvez reserver qu'un ordinateur a la fois !");
				}
			}
		});

		popupMenu.add(itemReserver);
		graphique.getTabRecherche().getTableRecherche().setComponentPopupMenu(popupMenu);

	}
	
    /**
     * EventListeners dans tous les onglets
     * Appuie sur l'onglet "Se deconnecter" rammene a la page d'accueil
     */
	public void addEventListenerDisconnect() {
		graphique.getTabbedPane().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				JTabbedPane pane = (JTabbedPane) e.getSource();
				int index = pane.getSelectedIndex();
				if (admin) {
					if (index == 4) {
						// admin se deconnecte
						graphique.getTabbedPane().remove(graphique.getTabListeOffre());
						graphique.getTabbedPane().remove(graphique.getTabRecherche());
						graphique.getTabbedPane().remove(graphique.getTabAjoutOffre());
						graphique.getTabbedPane().remove(graphique.getTabAjoutReference());
						graphique.getTabbedPane().remove(graphique.getTabDisconnect());

						graphique.addTabAuthentifier();
						instance.addEventListenerAuthentification();

					}
				} else {
					if (index == 1) {
						// utilisateur se deconnecte
						graphique.getTabbedPane().remove(graphique.getTabRecherche());
						graphique.getTabbedPane().remove(graphique.getTabDisconnect());

						graphique.addTabAuthentifier();
						instance.addEventListenerAuthentification();
					}

				}
			}

		});
	}

    /**
     * Calcule la somme des composants utilises dans un ordinateur et l'ecrit (onglet "Ajouter une offre")
     */
	private void writeTotalInLabel() {
		// Pour arrondir au centieme
		java.text.DecimalFormat df = new java.text.DecimalFormat("0.##");

		if (graphique.getTabAjoutOffre().getLabelPrixUnitaireEcran().getText() != "" && graphique.getTabAjoutOffre().getLabelPrixUnitaireProcesseur().getText() != ""
				&& graphique.getTabAjoutOffre().getLabelPrixUnitaireBatterie().getText() != ""
				&& graphique.getTabAjoutOffre().getLabelPrixUnitaireAppareilPhoto().getText() != "")
			graphique.getTabAjoutOffre().getLabelPrixTotal().setText((df
					.format(Double.parseDouble(graphique.getTabAjoutOffre().getLabelPrixUnitaireEcran().getText().replace("euros", ""))
							+ Double.parseDouble(graphique.getTabAjoutOffre().getLabelPrixUnitaireProcesseur().getText().replace("euros", ""))
							+ Double.parseDouble(graphique.getTabAjoutOffre().getLabelPrixUnitaireBatterie().getText().replace("euros", ""))
							+ Double.parseDouble(graphique.getTabAjoutOffre().getLabelPrixUnitaireAppareilPhoto().getText().replace("euros", "")))
					+ " euros").replace(",", "."));
	}
	
	
	/**
	 * Classe qui permet de r�cuperer un changement de valeur lors d'une selection sur une cellule du tableau
	 * @author Alexandre Monnot - alexandre.monnot@etu.univ-amu.fr - & Vincent Paoli - vincent.paoli.1@etu.univ-amu.fr -
	 */
	private class TableCellListener implements PropertyChangeListener, Runnable{
		
		private JTable table;
		private Action action;

		private int row;
		private int column;
		private Object oldValue;
		private Object newValue;

		/**
		 * Constructeur de TableCellListener
		 *  @param table   table sur laquelle on ecoute les changement de valeurs 
		 *  @param action  action a invoque lors d'un changement de valeur
		 */
		public TableCellListener(JTable table, Action action){
			this.table = table;
			this.action = action;
			this.table.addPropertyChangeListener(this);
		}
		

		/**
		 *  Constructeur de TableCellListener
		 *
		 *  @param row  la ligne du changemement de valeur
		 *  @param column  la colonne du changement de valeur
		 *  @param oldValue  l'ancienne valeur de la cellule
		 *  @param newValue  la nouvelle valeur de la cellule
		 */
		private TableCellListener(JTable table, int row, int column, Object oldValue, Object newValue)
		{
			this.table = table;
			this.row = row;
			this.column = column;
			this.oldValue = oldValue;
			this.newValue = newValue;
		}

		/**
		 *  Getter de l'attribut colonne
		 *  @return la colonne dernierement edite
		 */
		public int getColumn(){
			return column;
		}

		/**
		 *  Getter de l'attribut newValue
		 *  @return l'objet issu du changement de valeur
		 */
		public Object getNewValue(){
			return newValue;
		}

		/**
		 *  Getter de l'attribut oldValue
		 *  @return l'objet present avant le changement de valeur
		 */
		public Object getOldValue()
		{
			return oldValue;
		}

		/**
		 *  Getter de l'attribut row
		 *  @return la ligne dernierement edite
		 */
		public int getRow()
		{
			return row;
		}
		
		/**
		 * Getter de l'attribut table
		 * @return la table associe a cet evenement
		 */
		public JTable getTable(){
			return table;
		}
	

		@Override
		public void propertyChange(PropertyChangeEvent e){
			
			// Une cellule a commence ou s'est arrete d'etre modifie
			if ("tableCellEditor".equals(e.getPropertyName()))
			{
				if (table.isEditing())
					processEditingStarted();
				else
					processEditingStopped();
			}
		}

		/**
		 * Sauvegarde les donnees avant le changement de valeurs
		 */
		private void processEditingStarted(){
			//  The invokeLater is necessary because the editing row and editing
			//  column of the table have not been set when the "tableCellEditor"
			//  PropertyChangeEvent is fired.
			//  This results in the "run" method being invoked

			SwingUtilities.invokeLater(this);
		}

		@Override
		public void run(){
			row = table.convertRowIndexToModel( table.getEditingRow() );
			column = table.convertColumnIndexToModel( table.getEditingColumn() );
			oldValue = table.getModel().getValueAt(row, column);
			newValue = null;
		}

		/*
		 *	Met a jour l'historique de la cellule quand c'est necessaire
		 */
		private void processEditingStopped(){
			newValue = table.getModel().getValueAt(row, column);

			// Si les donnees on change
			if (!newValue.equals(oldValue)){

				// Copie les donnes au cas ou une autre cellule commence a s'editer
				TableCellListener tcl = new TableCellListener(getTable(), getRow(), getColumn(), getOldValue(), getNewValue());

				ActionEvent event = new ActionEvent(tcl, ActionEvent.ACTION_PERFORMED,"");
				action.actionPerformed(event);
			}
		}
	}

}
