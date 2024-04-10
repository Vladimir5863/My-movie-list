package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modeli.Korisnik;

public class DAO_Korisnik {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://localhost/projekat", "root", "");
	}

	public ArrayList<Korisnik> vratiKorisnike() throws ClassNotFoundException, SQLException {
		ArrayList<Korisnik> lista = new ArrayList<Korisnik>();

		connect();
		statement = connect.createStatement();
		resultSet = statement.executeQuery("select * from korisnik");

		while (resultSet.next()) {
			
			int id_korisnika=resultSet.getInt("id_korisnika");
			String ime=resultSet.getString("ime");
			String prezime=resultSet.getString("prezime");	
			int godina_rodjenja=resultSet.getInt("godina_rodjenja");
			String username=resultSet.getString("username");
			String password=resultSet.getString("password");
			
			Korisnik o = new Korisnik(id_korisnika, ime, prezime, username, password, godina_rodjenja);

			lista.add(o);
		}
		close();
		return lista;
	}
	
	public ArrayList<Korisnik> vratiKorisnikePSTM() throws ClassNotFoundException, SQLException {
		ArrayList<Korisnik> lista = new ArrayList<Korisnik>();

		connect();
		preparedStatement = connect.prepareStatement("select * from korisnik");

		preparedStatement.execute();
		
		resultSet = preparedStatement.getResultSet();
		
		while (resultSet.next()) {
			int id_korisnika=resultSet.getInt("id_korsnika");
			String ime=resultSet.getString("ime");
			String prezime=resultSet.getString("prezime");	
			int godina_rodjenja=resultSet.getInt("godina_rodjenja");
			String username=resultSet.getString("username");
			String password=resultSet.getString("password");

			Korisnik o = new Korisnik(id_korisnika, ime, prezime, username, password, godina_rodjenja);

			lista.add(o);
		}	
		close();
		return lista;
	}

	public void unesiKorisnika(Korisnik o) throws SQLException, ClassNotFoundException {
		connect();
		preparedStatement = connect.prepareStatement("INSERT INTO `korisnik`(`ime`, `prezime`, `godina_rodjenja`, `username`, `password`) VALUES (?,?,?,?,?)");

		preparedStatement.setString(1, o.getIme());
		preparedStatement.setString(2, o.getPrezime());
		preparedStatement.setInt(3, o.getGodina_rodjenja());
		preparedStatement.setString(4, o.getUsername());
		preparedStatement.setString(5, o.getPassword());
		preparedStatement.executeUpdate();
		close();
	}
	
	public Korisnik login (JTextField username, JTextField password) throws ClassNotFoundException, SQLException {

		connect();
		Korisnik o1=null;
		try {
			preparedStatement = connect.prepareStatement("SELECT * FROM `korisnik` WHERE `username` =? AND `password`=?");
			preparedStatement.setString(1, username.getText().trim());
			preparedStatement.setString(2, password.getText().trim());

			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
			    int id_korisnika = resultSet.getInt("id_korisnika");
			    String ime = resultSet.getString("ime");
			    String prezime = resultSet.getString("prezime");
			    int godina_rodjenja = resultSet.getInt("godina_rodjenja");
			    String username2 = resultSet.getString("username");
			    String password2 = resultSet.getString("password");

			    o1 = new Korisnik(id_korisnika, ime, prezime, username2, password2, godina_rodjenja);
			    close();
			    return o1;
			} else {
			   close();
			    JOptionPane.showMessageDialog(password, "Nepostojeci username ili password");
			}}
		catch (Exception e) {
			// TODO: handle exception
		}
		return o1;
		}
	
	public boolean daliima (JTextField username) throws ClassNotFoundException, SQLException {
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU
		connect();
		try {
			preparedStatement = connect.prepareStatement("SELECT * FROM `korisnik` WHERE `username` =? ");
			preparedStatement.setString(1, username.getText().trim());

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