package modeli;

public class Korisnik {
private int id_korisnika;
private String ime;
private String prezime;
private String username;
private String password;
private int godina_rodjenja;
;
public Korisnik() {
	super();
	// TODO Auto-generated constructor stub
}
public Korisnik(int id_korisnika, String ime, String prezime, String username, String password, int godina_rodjenja) {
	super();
	this.id_korisnika = id_korisnika;
	this.ime = ime;
	this.prezime = prezime;
	this.username = username;
	this.password = password;
	this.godina_rodjenja = godina_rodjenja;
}
public Korisnik( String ime, String prezime, String username, String password, int godina_rodjenja) {
	super();
	this.ime = ime;
	this.prezime = prezime;
	this.username = username;
	this.password = password;
	this.godina_rodjenja = godina_rodjenja;
}
public int getId_korisnika() {
	return id_korisnika;
}
public void setId_korisnika(int id_korisnika) {
	this.id_korisnika = id_korisnika;
}
public String getIme() {
	return ime;
}
public void setIme(String ime) {
	this.ime = ime;
}
public String getPrezime() {
	return prezime;
}
public void setPrezime(String prezime) {
	this.prezime = prezime;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getGodina_rodjenja() {
	return godina_rodjenja;
}
public void setGodina_rodjenja(int godina_rodjenja) {
	this.godina_rodjenja = godina_rodjenja;
}
@Override
public String toString() {
	return "Korisnik [ime=" + ime + ", prezime=" + prezime + ", godina_rodjenja=" + godina_rodjenja + "]";
}}