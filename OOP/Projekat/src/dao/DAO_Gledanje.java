package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modeli.Film;
import modeli.Gledanje;
import modeli.Korisnik;

public class DAO_Gledanje {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://localhost/projekat", "root", "");
	}

	public ArrayList<Gledanje> vratimojeFilmove(Korisnik k) throws ClassNotFoundException, SQLException {
		ArrayList<Gledanje> filmovi = new ArrayList<Gledanje>();

		connect();
		preparedStatement=connect.prepareStatement("select film.id_filma, film.naziv,film.trajanje,film.zanr,film.direktor,gledanje.id_gledanja,gledanje.id_korisnika,gledanje.ocena,gledanje.status from film,gledanje,korisnik where gledanje.id_filma=film.id_filma and gledanje.id_korisnika=korisnik.id_korisnika and korisnik.id_korisnika=?;");
		preparedStatement.setInt(1, k.getId_korisnika());
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			int id_filma=resultSet.getInt("id_filma");
			String naziv = resultSet.getString("naziv");
			int trajanje = resultSet.getInt("trajanje");
			String zanr=resultSet.getString("zanr");
			String reziser = resultSet.getString("direktor");
			int id_gledanja=resultSet.getInt("id_gledanja");
			int id_korisnika=resultSet.getInt("id_korisnika");
			int ocena=resultSet.getInt("ocena");
			String status=resultSet.getString("status");

			Gledanje f=new Gledanje(id_filma, naziv, trajanje, zanr, reziser, id_gledanja, id_korisnika, ocena, status);

			filmovi.add(f);
		}
		close();
		return filmovi;
	}
	
	public ArrayList<Gledanje> vratimojeFilmovepoImenu(Korisnik k,String nazivfilma) throws ClassNotFoundException, SQLException {
		ArrayList<Gledanje> filmovi = new ArrayList<Gledanje>();

		connect();
		preparedStatement=connect.prepareStatement("select film.id_filma, film.naziv,film.trajanje,film.zanr,film.direktor,gledanje.id_gledanja,gledanje.id_korisnika,gledanje.ocena,gledanje.status from film,gledanje,korisnik where gledanje.id_filma=film.id_filma and gledanje.id_korisnika=korisnik.id_korisnika and korisnik.id_korisnika=? and film.naziv like ?;");
		preparedStatement.setInt(1, k.getId_korisnika());
		preparedStatement.setString(2, "%" + nazivfilma + "%");
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			int id_filma=resultSet.getInt("id_filma");
			String naziv = resultSet.getString("naziv");
			int trajanje = resultSet.getInt("trajanje");
			String zanr=resultSet.getString("zanr");
			String reziser = resultSet.getString("direktor");
			int id_gledanja=resultSet.getInt("id_gledanja");
			int id_korisnika=resultSet.getInt("id_korisnika");
			int ocena=resultSet.getInt("ocena");
			String status=resultSet.getString("status");

			Gledanje f=new Gledanje(id_filma, naziv, trajanje, zanr, reziser, id_gledanja, id_korisnika, ocena, status);

			filmovi.add(f);
		}
		close();
		return filmovi;
	}
	
	public void unesiFilmuListu(Film f,Korisnik k,String status,int ocena) throws SQLException, ClassNotFoundException {
		connect();
		preparedStatement = connect.prepareStatement("INSERT INTO `gledanje`(`id_korisnika`, `id_filma`, `ocena`, `status`) VALUES (?,?,?,?)");
		
		preparedStatement.setInt(1, k.getId_korisnika());
		preparedStatement.setInt(2, f.getId_filma());
		preparedStatement.setInt(3, ocena);
		preparedStatement.setString(4, status);
	
		preparedStatement.executeUpdate();
		close();
	}
	
	public boolean dalijeulisti (Film f,Korisnik k) throws ClassNotFoundException, SQLException {
		connect();
		try {
		
     		preparedStatement = connect.prepareStatement("SELECT * FROM `gledanje` WHERE `id_korisnika`= ? AND`id_filma`= ? ");
            preparedStatement.setInt(1, k.getId_korisnika());
            preparedStatement.setInt(2, f.getId_filma());
			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				close();
			    return true;
			} else {
                close();
             return false;
			}}
		catch (Exception e) {
			// TODO: handle exception
		}
		return false;
		}

	public void izbrisi (int id_filma,int id_korisnika) throws ClassNotFoundException, SQLException {
		connect();
		try {
		
     		preparedStatement = connect.prepareStatement("DELETE FROM `gledanje` WHERE `id_korisnika`=? AND `id_filma`=? ");
            preparedStatement.setInt(1, id_korisnika);
            preparedStatement.setInt(2, id_filma);
            int affectedRows = preparedStatement.executeUpdate();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		close();
	    }
	
	public void izmeni (int ocena,String status, int id_gledanja) throws ClassNotFoundException, SQLException {
		connect();
		try {
		
     		preparedStatement = connect.prepareStatement("UPDATE `gledanje` SET `ocena`=?,`status`=? WHERE id_gledanja=?");
            preparedStatement.setInt(1, ocena);
            preparedStatement.setString(2, status);
            preparedStatement.setInt(3, id_gledanja);
            int affectedRows = preparedStatement.executeUpdate();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
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