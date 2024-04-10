package modeli;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class Tabela_Filmovi extends AbstractTableModel {

private static final long serialVersionUID = 1L;
ArrayList<Film> filmovi;
public Tabela_Filmovi(ArrayList<Film> filmovi) {
	this.filmovi=filmovi;
}
@Override
public int getRowCount() {
	return filmovi.size();
}
@Override
public int getColumnCount() {
	// TODO Auto-generated method stub
	return 4;
}
@Override
public Object getValueAt(int rowIndex, int columnIndex) {
	Film f=filmovi.get(rowIndex);
	switch (columnIndex) {
	case 0: return f.getNaziv();
	case 1: return f.getTrajanje();
	case 2: return f.getZanr();
	case 3: return f.getDirektor();
	case 4: return f.getId_filma();
	default:
		throw new IllegalArgumentException("Unexpected value: " + columnIndex);
	}
}

@Override
public String getColumnName(int column) {
	switch (column) {
	case 0: return "Naziv filma";
	case 1: return "Trajanje filma";
	case 2: return "Zanr filma";
	case 3: return "Direktor filma";	
	default:
		throw new IllegalArgumentException("Unexpected value: " + column);
	}}}