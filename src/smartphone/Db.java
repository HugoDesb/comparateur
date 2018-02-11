package smartphone;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.stream.Stream;

import ordinateur.Composant;
import ordinateur.Ordinateur;

/**
 * Classe qui gere la connexion a la base de donnees MySQL
 */
 
public class Db {

    /**
     * URL de connexion a la base de donnes
     */
	final String URL;
	
    /**
     * LOGIN de connexion a la base de donnees
     */
	final String LOGIN = "root";
	
    /**
     * Mot de passe de connexion a la base de donnees
     */
	final String PASSWORD = "root";
	
    /**
     * Nom de la base de donnees
     */
	final String DB;

    /**
     * La session de connexion avec la base de donnees
     */ 
	java.sql.Connection connection;
	
	/**
	 * Objet utilise pour executer une requete SQL et pour retourner les resultats
	 */
	java.sql.Statement statement;
	
	/**
	 * La table de donnees representant un resultat de la requete SQL
	 */
	ResultSet result;
	
	/**
	 * Un objet permettant de recuperer des informations sur les colonnes de l'attribut result
	 */
	ResultSetMetaData resultMeta;

    /**
     * Constructeur d'un objet db
	 * @param name Nom de la base de donnee a laquelle cet objet sera connecte 
     */
	public Db(String name) {

		DB = name;
		URL = "jdbc:mysql://localhost/" + name + "?autoReconnect=true&useSSL=false";
		connect();
	}

    /**
     * Renvoie la session de connexion a la base de donnees
     * @return La session de connexion a la base de donnees
     */
	public java.sql.Connection getConnection() {
		return connection;
	}

    /**
     * Initialise une session de connexion a la base de donnees
     */
	private void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

    /**
     * Ferme la session courante de connexion a la base de donnees
     */ 
	public void disconnect() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

    /**
     * Renvoie un tableau associatif d'une ligne de resultat renvoye par mySQL pour la requete passee en parametre. <br>
     * Le tableau est de la forme "nomDeColonne" => "valeur"
     * @param sql Requete sql a executer
     * @return Un tableau associatif des resultats de la requete 
     */
	public TreeMap<String, String> getRowFromQuery(String sql) {

		TreeMap<String, String> row = new TreeMap<String, String>();

		try {
			statement = connection.createStatement();
			result = statement.executeQuery(sql);
			resultMeta = result.getMetaData();

			if (result.next()) {
				for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
					row.put(resultMeta.getColumnName(i), result.getString(i));
				}
			}

			statement.close();

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return row;
	}

    /**
     * Renvoie un boolean indiquant si l'ordinateur passe en parametre est present dans la base de donnees
     * @param ordinateur L'ordinateur dont la presence doit etre verifie dans la base de donnees
     * @return True si l'ordinateur est present dans la base de donnees, False sinon 
     */
	public boolean isPresent(Ordinateur ordinateur) {

		String sql = "SELECT * FROM ordinateur WHERE " + "carte_graphique='"
				+ ordinateur.getCarteGraphique().getReference() + "' AND " + "cpu='"
				+ ordinateur.getCpu().getReference() + "' AND " + "disque_dur='"
				+ ordinateur.getDisqueDur().getReference() + "' AND " + "ram='" + ordinateur.getRam().getReference()
				+ "';";

		TreeMap<String, String> row = getRowFromQuery(sql);

		return !row.isEmpty();

	}

    /**
     * Renvoie un boolean indiquant si le composant passe en parametre est present dans la base de donnees
     * @param composant Le composant dont la presence doit etre verifie dans la base de donnees
     * @return True si le composant est present dans la base de donnees, False sinon 
     */
	public boolean isPresent(Composant composant) {

        // Traitement pour recuperer le type de composant passe en argument
		String temp = composant.getClass().getName();
		temp = temp.replaceAll("(.*)\\.(.*)", "$2");    // Retire le nom du package
		temp = temp.replaceAll("([A-Z])", "_$1");       // Ajoute les _ entre chaque mot
		temp = temp.toLowerCase();                      // Passe en miniscule
		temp = temp.substring(1, temp.length());        // Retire le 1er _ inutile

		String sql = "SELECT * FROM " + temp + " WHERE " + "reference='" + composant.getReference() + "';";

		TreeMap<String, String> row = getRowFromQuery(sql);

		return !row.isEmpty();

	}

    /**
     * Ajoute a la base de donnees, dans une table passee en parametre, les valeurs donnee dans le tableau passe en parametre. <br>
     * Le nombre d'element contenu dans le tableau doit correspondre au nombre de colonnes de la table. <br>
     * La colonne ID sera automatiquement ajoutee dans les tables pour laquelle elle est necessaire. <br>
     * @param table La table dans laquelle on doit ajouter une ligne
     * @param object Tableau d'objet contenant les donnees ajouter dans la table
     */
	public void addToDb(String table, Object[] object) {

		// Ajoute l'élément null en premiere position s'il s'agit d'une table avec ID
		String column1 = getColumnNamesFrom(table)[0];
		if (column1.equals("id")) {
			Object[] array = new Object[] { null };
			Object[] newObject = Stream.concat(Arrays.stream(array), Arrays.stream(object)).toArray(Object[]::new);
			object = newObject;
		}
		
		int taille = object.length;
		String sql = "INSERT INTO " + table + " VALUES (";

		for (int i = 0; i < taille - 1; i++) {
			if (object[i] instanceof String) {
				sql += "'" + object[i] + "', ";
			} else {
				sql += object[i] + ", ";
			}
		}
		if (object[taille - 1] instanceof String) {
			sql += "'" + object[taille - 1] + "');";
		} else {
			sql += object[taille - 1] + ");";
		}

		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

    /**
     * Execute une requete de type UPDATE avec la chaine de caractere passee en argument
     * @param sql La requete a executer
     */
	public void updateRowFromQuery(String sql) {

		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

    /**
     * Renvoie un tableau de chaine de caractere contenant le nom des colonnes de la table passee en parametre
     * @param table La table pour laquelle ont doit recuperer le nom des colonnes
     * @return Un tableau contenant les noms de colonnes de la table
     */
	public String[] getColumnNamesFrom(String table) {

		String[] columns = new String[10];
		String sql = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME='" + table + "';";

		try {
			int i = 0;
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				columns[i] = resultSet.getString("COLUMN_NAME");
				i++;
			}

			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return columns;
	}

    /**
     * Renvoie toutes les lignes d'une table passe en parametre sous la forme d'une collection de tableaux associatifs en precisant une (ou plusieurs) condition(s)
     * @param table La table pour laquelle ont doit recuperer les resultats
     * @param where Condition de recuperation de ligne en syntaxe MySQL
     * @return Une collection de tableau associatif contenant tous les lignes correspondantes a la (les) condition(s) specifiee(s)
     */
	public ArrayList<TreeMap<String, String>> getRowsFrom(String table, String where) {
		
		String sql;
		if (!where.equals("")) {
			sql = "SELECT * FROM " + table + " WHERE " + where + ";";
		} else {
			sql = "SELECT * FROM " + table + ";";
		}
		
		ArrayList<TreeMap<String, String>> rows = new ArrayList<TreeMap<String, String>>();

		try {
			statement = connection.createStatement();
			result = statement.executeQuery(sql);
			resultMeta = result.getMetaData();

			while (result.next()) {

				TreeMap<String, String> row = new TreeMap<String, String>();

				for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
					row.put(resultMeta.getColumnName(i), result.getString(i));
				}

				rows.add(row);
			}

			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rows;
	}

    /**
     * Renvoie toutes les lignes d'une table passe en parametre sous la forme d'une collection de tableaux associatifs. <br>
     * @param table La table pour laquelle ont doit recuperer tous les resultats
     * @return Une collection de tableau associatif contenant toutes les lignes de la table
     */
	public ArrayList<TreeMap<String, String>> getRowsFrom(String table) {
		return getRowsFrom(table, "");
	}

}
