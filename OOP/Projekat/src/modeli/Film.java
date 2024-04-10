package modeli;

public class Film {
private int id_filma;
private String naziv;
private int trajanje;
private String zanr;
private String direktor;
public String getZanr() {
	return zanr;
}
public void setZanr(String zanr) {
	this.zanr = zanr;
}
public int getId_filma() {
	return id_filma;
}
public void setId_filma(int id_filma) {
	this.id_filma = id_filma;
}
public String getNaziv() {
	return naziv;
}
public void setNaziv(String naziv) {
	this.naziv = naziv;
}
public int getTrajanje() {
	return trajanje;
}
public void setTrajanje(int trajanje) {
	this.trajanje = trajanje;
}
public String getDirektor() {
	return direktor;
}
public void setDirektor(String direktor) {
	this.direktor = direktor;
}
@Override
public String toString() {
	return "Film [naziv=" + naziv + ", trajanje=" + trajanje + ", reziser=" + direktor + " zanr="+zanr+"]";
}
public Film(int id_filma, String naziv, int trajanje,String zanr, String reziser) {
	super();
	this.id_filma = id_filma;
	this.naziv = naziv;
	this.trajanje = trajanje;
	this.zanr=zanr;
	this.direktor = reziser;
}
public Film() {
	super();
	// TODO Auto-generated constructor stub
}}