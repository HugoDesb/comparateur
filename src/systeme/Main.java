package systeme;

import java.awt.EventQueue;

import graphique.Graphique;
import ordinateur.Db;

/**
 * Classe qui initialise le programme
 * @author Alexandre Monnot - alexandre.monnot@etu.univ-amu.fr - & Vincent Paoli - vincent.paoli.1@etu.univ-amu.fr -
 */
public class Main {
    
    /**
     * Fonction main qui initialise le programme
     */
	public static void main(String[] args) {
		
		Db db = new Db("comparateur");

		// Initialisation interface graphique
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {

				try {
					Graphique frame = new Graphique();
					frame.setVisible(true);

					Controleur controleur = new Controleur(db, frame);

					controleur.addEventListenerAuthentification();

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		});

		// Lorsqu'on arrete le programme
		Runtime.getRuntime().addShutdownHook(new Thread() {

			@Override
			public void run() {
				db.disconnect();
			}
		});

	}

}
