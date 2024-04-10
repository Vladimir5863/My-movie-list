package interfac;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import modeli.Korisnik;

public interface IGui {
public void changePanel(JPanel curent, JPanel next);
public void moji_filmovi_tabela(Korisnik korisnik);
public void logovanje(JTextField username, JPasswordField password);
public void svi_filmovi_tabela();
}
