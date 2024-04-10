package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modeli.Film;

public class DAO_Film {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://localhost/projekat", "root", "");
	}

	public ArrayList<Film> vratiFilmove() throws ClassNotFoundException, SQLException {
		ArrayList<Film> filmovi = new ArrayList<Film>();

		connect();
		statement = connect.createStatement();
		resultSet = statement.executeQuery("select * from film");

		while (resultSet.next()) {
			int id_filma=resultSet.getInt("id_filma");
			String naziv = resultSet.getString("naziv");
			int trajanje = resultSet.getInt("trajanje");
			String zanr=resultSet.getString("zanr");
			String reziser = resultSet.getString("direktor");

			Film f = new Film(id_filma, naziv, trajanje,zanr, reziser);

			filmovi.add(f);
		}
		close();
		return filmovi;
	}
	
	public ArrayList<Film> vratiFilmovepoImenu(String nazivfilma) throws ClassNotFoundException, SQLException {
		ArrayList<Film> filmovi = new ArrayList<Film>();

		connect();

		preparedStatement=connect.prepareStatement("SELECT * FROM `film` WHERE `naziv` LIKE ?;");
		preparedStatement.setString(1, "%" + nazivfilma + "%");
		resultSet = preparedStatement.executeQuery();
		
		while (resultSet.next()) {
			int id_filma=resultSet.getInt("id_filma");
			String naziv = resultSet.getString("naziv");
			int trajanje = resultSet.getInt("trajanje");
			String zanr=resultSet.getString("zanr");
			String reziser = resultSet.getString("direktor");

			Film f = new Film(id_filma, naziv, trajanje,zanr, reziser);
			filmovi.add(f);
		}
		close();
		return filmovi;
	}
	
	public ArrayList<Film> vratiFilmovePSTM() throws ClassNotFoundException, SQLException {
		ArrayList<Film> lista = new ArrayList<Film>();

		connect();
		preparedStatement = connect.prepareStatement("select * from film");
		
		preparedStatement.execute();
		
		resultSet = preparedStatement.getResultSet();
		
		while (resultSet.next()) {
			int id_filma=resultSet.getInt("id_filma");
			String naziv = resultSet.getString("naziv");
			int trajanje = resultSet.getInt("trajanje");
			String zanr=resultSet.getString("zanr");
			String direktor = resultSet.getString("direktor");

			Film f = new Film(id_filma, naziv, trajanje,zanr, direktor);

			lista.add(f);
		}
		close();
		return lista;
	}

	public void unesiFilm(Film f) throws SQLException, ClassNotFoundException {
		connect();
		preparedStatement = connect.prepareStatement("INSERT INTO `film`(`naziv`, `trajanje`,'zanr', `direktor`) VALUES (?,?,?,?)");

		preparedStatement.setString(1, f.getNaziv());
		preparedStatement.setInt(2, f.getTrajanje());
		preparedStatement.setString(3, f.getZanr());
		preparedStatement.setString(4, f.getDirektor());
		preparedStatement.executeUpdate();
		close();
	}

	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
	    }}}