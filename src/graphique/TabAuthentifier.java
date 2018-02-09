package graphique;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/**
 * Classe gerant l'onglet pour s'authentifier
 * 
 */
@SuppressWarnings("serial")
public class TabAuthentifier extends JPanel{

	/**
	 * Zone de saisie du mot de passe
	 */
	private JPasswordField passwordField;
	
	/**
	 * Bouton pour se connecter en tant qu'utilisateur
	 */
	private JButton btnUtilisateur;
	
	/**
	 * Bouton pour se connecter en tant qu'administrateur
	 */
	private JButton btnAdministrateur;
	
	/**
	 * Constructeur de l'onglet pour s'authentifier
	 */
	public TabAuthentifier() {

		// Polices de texte utilisees
		Font f30 = new Font("Helvetica", Font.BOLD, 30);
		Font f15 = new Font("Helvetica", Font.BOLD, 15);
		
		GridBagLayout gbl_authentifier = new GridBagLayout();
		gbl_authentifier.columnWidths = new int[] { 32, 108, 50, 226, 131, 0, 0 };
		gbl_authentifier.rowHeights = new int[] { 30, 47, 0, 26, 0, 54, 26, 26, 0, 50, 362, 0 };
		gbl_authentifier.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_authentifier.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		this.setLayout(gbl_authentifier);

		// Texte d'accueil
		JLabel labelAccueil = new JLabel("<HTML><U>Choisissez votre mode d'utilisation :</U></HTML> ");
		labelAccueil.setFont(f30);
		GridBagConstraints gbc_labelAccueil = new GridBagConstraints();
		gbc_labelAccueil.gridwidth = 6;
		gbc_labelAccueil.insets = new Insets(0, 0, 5, 5);
		gbc_labelAccueil.gridx = 0;
		gbc_labelAccueil.gridy = 0;
		this.add(labelAccueil, gbc_labelAccueil);

		// label utilisateur
		JLabel labelUtilisateur = new JLabel("Selectionnez le mode ci-dessous si vous etes un utilisateur lambda : ");
		labelUtilisateur.setFont(f15);
		GridBagConstraints gbc_labelUtilisateur = new GridBagConstraints();
		gbc_labelUtilisateur.anchor = GridBagConstraints.WEST;
		gbc_labelUtilisateur.gridwidth = 4;
		gbc_labelUtilisateur.insets = new Insets(0, 0, 5, 5);
		gbc_labelUtilisateur.gridx = 1;
		gbc_labelUtilisateur.gridy = 2;
		this.add(labelUtilisateur, gbc_labelUtilisateur);
		
		// Bouton utilisateur
		btnUtilisateur = new JButton("Utilisateur");
		btnUtilisateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		GridBagConstraints gbc_btnUtilisateur = new GridBagConstraints();
		gbc_btnUtilisateur.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnUtilisateur.insets = new Insets(0, 0, 5, 5);
		gbc_btnUtilisateur.gridx = 1;
		gbc_btnUtilisateur.gridy = 4;
		this.add(btnUtilisateur, gbc_btnUtilisateur);

		// label  administrateur
		JLabel labelAdministrateur = new JLabel("Saisissez le mot de passe et selectionnez le mode ci-dessous pour vous connecter en tant qu'administrateur :");
		labelAdministrateur.setFont(f15);
		GridBagConstraints gbc_labelAdministrateur = new GridBagConstraints();
		gbc_labelAdministrateur.gridwidth = 4;
		gbc_labelAdministrateur.anchor = GridBagConstraints.WEST;
		gbc_labelAdministrateur.insets = new Insets(0, 0, 5, 5);
		gbc_labelAdministrateur.gridx = 1;
		gbc_labelAdministrateur.gridy = 6;
		this.add(labelAdministrateur, gbc_labelAdministrateur);
		
		// Bouton Administrateur
		btnAdministrateur = new JButton("Administrateur");

		GridBagConstraints gbc_btnAdministrateur = new GridBagConstraints();
		gbc_btnAdministrateur.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAdministrateur.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdministrateur.gridx = 1;
		gbc_btnAdministrateur.gridy = 8;
		this.add(btnAdministrateur, gbc_btnAdministrateur);

		// Mot de passe
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 3;
		gbc_passwordField.gridy = 8;
		this.add(passwordField, gbc_passwordField);
		
		// Inserer  l'image du logo polytech
		JLabel labelLogo = new JLabel(/*new ImageIcon(this.getClass().getResource("/images/logo.png") )*/);
		GridBagConstraints gbc_labelLogo = new GridBagConstraints();
		gbc_labelLogo.gridwidth = 2;
		gbc_labelLogo.anchor = GridBagConstraints.SOUTHEAST;
		gbc_labelLogo.insets = new Insets(0, 0, 0, 5);
		gbc_labelLogo.gridx = 4;
		gbc_labelLogo.gridy = 10;
		this.add(labelLogo, gbc_labelLogo);
	}

	/**
	 * Renvoie la zone de saisie du mot de passe
	 * @return La zone de saisie du mot de passe
	 */
	public JPasswordField getPasswordField() {
		return passwordField;
	}

	/**
	 * Renvoie le bouton pour se connecter en tant qu'utilisateur
	 * @return Le bouton pour se connecter en tant qu'utilisateur
	 */
	public JButton getBtnUtilisateur() {
		return btnUtilisateur;
	}

	/**
	 * Renvoie le bouton pour se connecter en tant qu'admin
	 * @return Le bouton pour se connecter en tant qu'admin
	 */
	public JButton getBtnAdministrateur() {
		return btnAdministrateur;
	}
	
}
