package modeli;

public class Gledanje extends Film {
 private int id_gledanja;
 private int id_korisnika;
 private int ocena;
 private String status;
public int getId_gledanja() {
	return id_gledanja;
}
public void setId_gledanja(int id_gledanja) {
	this.id_gledanja = id_gledanja;
}
public int getId_korisnika() {
	return id_korisnika;
}
public void setId_korisnika(int id_korisnika) {
	this.id_korisnika = id_korisnika;
}
public int getOcena() {
	return ocena;
}
public void setOcena(int ocena) {
	this.ocena = ocena;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Gledanje(int id_filma, String naziv, int trajanje, String zanr, String reziser, int id_gledanja,
		int id_korisnika, int ocena, String status) {
	super(id_filma, naziv, trajanje, zanr, reziser);
	this.id_gledanja = id_gledanja;
	this.id_korisnika = id_korisnika;
	this.ocena = ocena;
	this.status = status;
}
public Gledanje() {
	super();
	// TODO Auto-generated constructor stub
}
public Gledanje(int id_filma, String naziv, int trajanje, String zanr, String reziser) {
	super(id_filma, naziv, trajanje, zanr, reziser);
	// TODO Auto-generated constructor stub
}}