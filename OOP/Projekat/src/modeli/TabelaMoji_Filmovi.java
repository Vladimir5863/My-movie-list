package modeli;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TabelaMoji_Filmovi extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
private ArrayList<Gledanje> gledanje;

public TabelaMoji_Filmovi (ArrayList<Gledanje> gledanje) {
	this.gledanje=gledanje;
}

@Override
public int getRowCount() {
	// TODO Auto-generated method stub
	return gledanje.size();
}

@Override
public int getColumnCount() {
	return 6;
}

@Override
public Object getValueAt(int rowIndex, int columnIndex) {
	Gledanje g=gledanje.get(rowIndex);
	switch (columnIndex) {
	case 0: return g.getNaziv();
	case 1: return g.getTrajanje();
	case 2: return g.getZanr();
	case 3: return g.getDirektor();
	case 4: return g.getOcena();
	case 5: return g.getStatus();
	case 6: return g.getId_filma();
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
	case 3: return "Reziser filma";
	case 4: return "Moja ocena";
	case 5: return "Status gledanja";
	default:
		throw new IllegalArgumentException("Unexpected value: " + column);
}}}