package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import dao.DAO_Korisnik;
import dao.DAO_Film;
import dao.DAO_Gledanje;
import interfac.IGui;
import modeli.Korisnik;
import modeli.TabelaMoji_Filmovi;
import modeli.Tabela_Filmovi;
import modeli.Film;
import modeli.Gledanje;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Glavna implements IGui {

	private JFrame frame;
	private JTextField textField_username;
	private JPasswordField passwordField;
	private JPanel panel_new_account;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPanel panel_glavni;
    private DAO_Korisnik dao_korisnik=new DAO_Korisnik();
    private DAO_Film dao_film=new DAO_Film();
    private DAO_Gledanje dao_gledanje=new DAO_Gledanje();
    private Korisnik korisnik;
    private JTextField textField_5;
    private JTextField textField_6;
    private ArrayList<Film> svi_filmovi=new ArrayList<Film>();
    private ArrayList<Gledanje> moji_filmovi=new ArrayList<Gledanje>();
    private JPanel panel_movies;
    private JTable table;
    private JPanel panel_mymovies;
    private JTable table_1;
    private JTextField textField_7;
    private JPanel panel_dodaj_film;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField textField_11;
    private JTextField textField_12;
    private JTextField textField_13;
    private JTextField textField_14;
    private JTextField textField_15;
    private JTextField textField_16;
    private JComboBox<String> comboBox_2;
    private JComboBox<Integer> comboBox_3;
    private JPanel panel_izmeni_film;
    private JPasswordField passwordField_1;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Glavna window = new Glavna();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}}});
		}

	public Glavna() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 590, 469);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel_login = new JPanel();
		frame.getContentPane().add(panel_login, "name_10855941125600");
		panel_login.setLayout(null);
		
		JLabel lblNewLabel_username = new JLabel("Korisnicko ime");
		lblNewLabel_username.setBounds(39, 141, 90, 14);
		panel_login.add(lblNewLabel_username);
		
		JLabel lblNewLabel_passwrod = new JLabel("Lozinka");
		lblNewLabel_passwrod.setBounds(39, 202, 46, 14);
		panel_login.add(lblNewLabel_passwrod);
		
		textField_username = new JTextField();
		textField_username.setBounds(178, 138, 86, 20);
		panel_login.add(textField_username);
		textField_username.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(178, 199, 86, 20);
		panel_login.add(passwordField);
		
		JButton btnNewButton = new JButton("Ulogujte se");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     logovanje(textField_username, passwordField);
					if(korisnik!=null) {
					JOptionPane.showMessageDialog(btnNewButton, "Uspesno ste se loginovali");
					changePanel(panel_login, panel_glavni);
					}
					else JOptionPane.showMessageDialog(btnNewButton, "Niste uspeli");				
					}});
		btnNewButton.setBounds(76, 289, 100, 23);
		panel_login.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Nemate nalog?\r\n\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(360, 190, 100, 17);
		panel_login.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Napravite novi account");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePanel(panel_login, panel_new_account);
			}});
		
		btnNewButton_1.setBounds(320, 289, 163, 23);
		panel_login.add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("Dobro dosli na moju listu filmova");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(150, 35, 250, 20);
		panel_login.add(lblNewLabel_6);
		
		panel_new_account = new JPanel();
		frame.getContentPane().add(panel_new_account, "name_11243352712000");
		panel_new_account.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ime");
		lblNewLabel_1.setBounds(38, 46, 46, 14);
		panel_new_account.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Prezime");
		lblNewLabel_2.setBounds(38, 96, 56, 14);
		panel_new_account.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Godina rodjenja");
		lblNewLabel_3.setBounds(38, 157, 85, 14);
		panel_new_account.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(134, 43, 86, 20);
		panel_new_account.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(134, 93, 86, 20);
		panel_new_account.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(134, 154, 86, 20);
		panel_new_account.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Korisnicko ime");
		lblNewLabel_4.setBounds(38, 222, 100, 14);
		panel_new_account.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Lozinka");
		lblNewLabel_5.setBounds(38, 290, 46, 14);
		panel_new_account.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(134, 219, 86, 20);
		panel_new_account.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Napravi novi nalog");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField!=null && textField.getText().trim().length()>0 && textField_1!=null && textField_1.getText().trim().length()>0 && textField_2!=null && textField_2.getText().trim().length()>0 && textField_3!=null && textField_3.getText().trim().length()>0 && passwordField_1!=null && passwordField_1.getText().trim().length()>0 ) {
					try {
						if(dao_korisnik.daliima(textField_3)==false) {
                    try {
						String ime=textField.getText().trim();
						String prezime =textField_1.getText().trim();
						int godiste=Integer.parseInt(textField_2.getText().trim());
						String username =textField_3.getText().trim();
						String password =passwordField_1.getText().trim();
						dao_korisnik.unesiKorisnika(new Korisnik(ime, prezime, username, password, godiste));
						logovanje(textField_3, passwordField_1);
						JOptionPane.showMessageDialog(btnNewButton_2, "Uspesno kreiran nalog");
						changePanel(panel_new_account, panel_glavni);
                   }catch (NumberFormatException a) {
                          JOptionPane.showMessageDialog(btnNewButton_2, "Los format godine rodjenja");
                   }catch (Exception e2) {
						// TODO: handle exception
                   }}
						else JOptionPane.showMessageDialog(btnNewButton_2, "Uneti username je vec iskoriscen, molimo Vas unesite drugi");
				   } catch (HeadlessException | ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
				  }}}});
		
		btnNewButton_2.setBounds(320, 169, 151, 23);
		panel_new_account.add(btnNewButton_2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(134, 290, 86, 20);
		panel_new_account.add(passwordField_1);
		
		panel_glavni = new JPanel();
		frame.getContentPane().add(panel_glavni, "name_12167664430600");
		panel_glavni.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Moja lista filmova");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(241, 24, 125, 27);
		panel_glavni.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Ime");
		lblNewLabel_8.setBounds(28, 75, 37, 21);
		panel_glavni.add(lblNewLabel_8);
		
		textField_5 = new JTextField();
		textField_5.setBounds(85, 75, 86, 20);
		panel_glavni.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Prezime\r\n");
		lblNewLabel_9.setBounds(28, 133, 46, 14);
		panel_glavni.add(lblNewLabel_9);
		
		textField_6 = new JTextField();
		textField_6.setBounds(85, 130, 86, 20);
		panel_glavni.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Moji filmovi");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moji_filmovi_tabela(korisnik);
				changePanel(panel_glavni, panel_mymovies);
			}});
		
		btnNewButton_3.setBounds(85, 264, 113, 23);
		panel_glavni.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Svi filmovi");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				svi_filmovi_tabela();
				changePanel(panel_glavni, panel_movies);
			}});
		
		btnNewButton_4.setBounds(352, 264, 113, 23);
		panel_glavni.add(btnNewButton_4);
		
		panel_movies = new JPanel();
		frame.getContentPane().add(panel_movies, "name_2263919184400");
		panel_movies.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(10, 61, 554, 306);
		panel_movies.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_5 = new JButton("Nazad");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePanel(panel_movies, panel_glavni);
			}});
		btnNewButton_5.setBounds(455, 396, 89, 23);
		panel_movies.add(btnNewButton_5);
		
		JButton btnNewButton_7 = new JButton("Dodaj");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row=table.getSelectedRow();
				if (row!=-1) {
				String naziv=(String) table.getValueAt(row, 0);
				Film f=new Film();
				for (Film film : svi_filmovi) {
					if(naziv.equals(film.getNaziv()))
						f=film;
				}
				try {
					if(dao_gledanje.dalijeulisti(f,korisnik)==false) {
					textField_7.setText(f.getNaziv());
					textField_8.setText(f.getZanr());
					textField_9.setText(String.valueOf(f.getTrajanje()));
					textField_10.setText(f.getDirektor());
					if (row!=-1) changePanel(panel_movies, panel_dodaj_film);
					}
					else JOptionPane.showMessageDialog(btnNewButton_7, "Film se vec nalazi u listi");
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				else JOptionPane.showMessageDialog(btnNewButton_7, "Molimo Vas izaberite prvo film");
		        }});
				
		btnNewButton_7.setBounds(273, 396, 89, 23);
		panel_movies.add(btnNewButton_7);
		
		textField_11 = new JTextField();
		textField_11.setBounds(125, 23, 86, 20);
		panel_movies.add(textField_11);
		textField_11.setColumns(10);
		
		JButton btnNewButton_10 = new JButton("Pretrazi");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_11.getText().trim().length()>0 && textField_11.getText().trim()!=null) {
				svi_filmovi.clear();
				table.clearSelection();
				try {
					svi_filmovi=dao_film.vratiFilmovepoImenu(textField_11.getText().trim());
					Tabela_Filmovi tablem=new Tabela_Filmovi(svi_filmovi);
					table.setModel(tablem);	
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else  JOptionPane.showMessageDialog(btnNewButton_7, "Ako zelite pretraziti po nazivu molimo Vas unesite naziv po kome zelite da pretrazite");	
		}});
		btnNewButton_10.setBounds(273, 22, 89, 23);
		panel_movies.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("Resetuj");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_11.setText(" ");
				svi_filmovi_tabela();
			}});
		
		btnNewButton_11.setBounds(440, 22, 89, 23);
		panel_movies.add(btnNewButton_11);
		
		panel_mymovies = new JPanel();
		frame.getContentPane().add(panel_mymovies, "name_4067182860400");
		panel_mymovies.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 54, 554, 294);
		panel_mymovies.add(scrollPane_1);
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton_6 = new JButton("Nazad");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePanel(panel_mymovies, panel_glavni);
			}});
		
		btnNewButton_6.setBounds(446, 385, 89, 23);
		panel_mymovies.add(btnNewButton_6);
		
		textField_12 = new JTextField();
		textField_12.setBounds(77, 23, 86, 20);
		panel_mymovies.add(textField_12);
		textField_12.setColumns(10);
		
		JButton btnNewButton_12 = new JButton("Pretrazi");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_12.getText().trim().length()>0 && textField_12.getText().trim()!=null) {
					moji_filmovi.clear();
					table_1.clearSelection();
					try {
						moji_filmovi=dao_gledanje.vratimojeFilmovepoImenu(korisnik, textField_12.getText().trim());
						TabelaMoji_Filmovi tablemym=new TabelaMoji_Filmovi(moji_filmovi);
						table_1.setModel(tablemym);
						
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else  JOptionPane.showMessageDialog(btnNewButton_7, "Ako zelite pretraziti po nazivu molimo Vas unesite naziv po kome zelite da pretrazite");		
			}});
				
		btnNewButton_12.setBounds(268, 22, 89, 23);
		panel_mymovies.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("Resetuj");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_12.setText(" ");
				moji_filmovi_tabela(korisnik);
		}});
		btnNewButton_13.setBounds(412, 20, 89, 23);
		panel_mymovies.add(btnNewButton_13);
		
		JButton btnNewButton_15 = new JButton("Izmeni");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row=table_1.getSelectedRow();
				String naziv=(String) table_1.getValueAt(row, 0);
				Gledanje f=new Gledanje();
				for (Gledanje gledanje : moji_filmovi) {
					if(naziv.equals(gledanje.getNaziv()))
						f=gledanje;
				}
				    textField_13.setText(f.getNaziv());
				    textField_14.setText(f.getZanr());
				    textField_15.setText(String.valueOf(f.getTrajanje()));
				    textField_16.setText(f.getDirektor());
					comboBox_2.setSelectedItem(f.getStatus());
					comboBox_3.setSelectedItem(f.getOcena());
				    changePanel(panel_mymovies, panel_izmeni_film);
		}});
		btnNewButton_15.setBounds(133, 385, 89, 23);
		panel_mymovies.add(btnNewButton_15);
		
		panel_dodaj_film = new JPanel();
		frame.getContentPane().add(panel_dodaj_film, "name_644997643638200");
		panel_dodaj_film.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Naziv");
		lblNewLabel_10.setBounds(25, 67, 46, 14);
		panel_dodaj_film.add(lblNewLabel_10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(90, 64, 100, 20);
		panel_dodaj_film.add(textField_7);
		textField_7.setColumns(10);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Planiram da gledam", "Odgledao", "Na pauzi", "Gledam", "Dropovao"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(312, 63, 180, 22);
		panel_dodaj_film.add(comboBox);
		
		JLabel lblNewLabel_11 = new JLabel("Status");
		lblNewLabel_11.setBounds(243, 67, 46, 14);
		panel_dodaj_film.add(lblNewLabel_11);
		
		JComboBox<Integer> comboBox_1 = new JComboBox<Integer>();
		comboBox_1.setModel(new DefaultComboBoxModel(new Integer[] {1,2,3,4,5,6,7,8,9,10}));
		comboBox_1.setMaximumRowCount(11);
		comboBox_1.setToolTipText("");
		comboBox_1.setBounds(312, 101, 70, 22);
		panel_dodaj_film.add(comboBox_1);
		
		JLabel lblNewLabel_12 = new JLabel("Ocena");
		lblNewLabel_12.setBounds(243, 105, 46, 14);
		panel_dodaj_film.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Zanr");
		lblNewLabel_13.setBounds(25, 105, 46, 14);
		panel_dodaj_film.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Trajanje");
		lblNewLabel_14.setBounds(25, 151, 46, 14);
		panel_dodaj_film.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Direktor");
		lblNewLabel_15.setBounds(25, 199, 46, 14);
		panel_dodaj_film.add(lblNewLabel_15);
		
		textField_8 = new JTextField();
		textField_8.setBounds(90, 102, 100, 20);
		panel_dodaj_film.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(90, 148, 100, 20);
		panel_dodaj_film.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(90, 196, 100, 20);
		panel_dodaj_film.add(textField_10);
		textField_10.setColumns(10);
		
		JButton btnNewButton_8 = new JButton("Potvrdi");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String naziv=textField_7.getText().trim();
				String status=(String) comboBox.getSelectedItem();
				int ocena=(int) comboBox_1.getSelectedItem();
				Film f=new Film();
				for (Film film : svi_filmovi) {
					if (film.getNaziv().equals(naziv)){
						f=film;
						break;
					}}
				try {
					dao_gledanje.unesiFilmuListu(f, korisnik, status, ocena);
					changePanel(panel_dodaj_film, panel_movies);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}});
				
		btnNewButton_8.setBounds(170, 347, 89, 23);
		panel_dodaj_film.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Otkazi");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePanel(panel_dodaj_film, panel_movies);
			}});
		
		btnNewButton_9.setBounds(388, 347, 89, 23);
		panel_dodaj_film.add(btnNewButton_9);
		
		panel_izmeni_film = new JPanel();
		panel_izmeni_film.setLayout(null);
		frame.getContentPane().add(panel_izmeni_film, "name_654089661273200");
		
		JLabel lblNewLabel_10_1 = new JLabel("Naziv");
		lblNewLabel_10_1.setBounds(25, 67, 46, 14);
		panel_izmeni_film.add(lblNewLabel_10_1);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(90, 64, 100, 20);
		panel_izmeni_film.add(textField_13);
		
		comboBox_2 = new JComboBox<String>();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Planiram da gledam", "Odgledao", "Na pauzi", "Gledam", "Dropovao"}));
		comboBox_2.setToolTipText("");
		comboBox_2.setBounds(312, 63, 180, 22);
		panel_izmeni_film.add(comboBox_2);
		
		JLabel lblNewLabel_11_1 = new JLabel("Status");
		lblNewLabel_11_1.setBounds(243, 67, 46, 14);
		panel_izmeni_film.add(lblNewLabel_11_1);
		
		comboBox_3 = new JComboBox<Integer>();
		comboBox_3.setModel(new DefaultComboBoxModel(new Integer[] {1,2,3,4,5,6,7,8,9,10}));
		comboBox_3.setToolTipText("");
		comboBox_3.setMaximumRowCount(11);
		comboBox_3.setBounds(312, 101, 70, 22);
		panel_izmeni_film.add(comboBox_3);
		
		JLabel lblNewLabel_12_1 = new JLabel("Ocena");
		lblNewLabel_12_1.setBounds(243, 105, 46, 14);
		panel_izmeni_film.add(lblNewLabel_12_1);
		
		JLabel lblNewLabel_13_1 = new JLabel("Zanr");
		lblNewLabel_13_1.setBounds(25, 105, 46, 14);
		panel_izmeni_film.add(lblNewLabel_13_1);
		
		JLabel lblNewLabel_14_1 = new JLabel("Trajanje");
		lblNewLabel_14_1.setBounds(25, 151, 46, 14);
		panel_izmeni_film.add(lblNewLabel_14_1);
		
		JLabel lblNewLabel_15_1 = new JLabel("Direktor");
		lblNewLabel_15_1.setBounds(25, 199, 46, 14);
		panel_izmeni_film.add(lblNewLabel_15_1);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(90, 102, 100, 20);
		panel_izmeni_film.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(90, 148, 100, 20);
		panel_izmeni_film.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(90, 196, 100, 20);
		panel_izmeni_film.add(textField_16);
		
		JButton btnNewButton_8_1 = new JButton("Potvrdi");
		btnNewButton_8_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ocena=(int) comboBox_3.getSelectedItem();
				String status=(String) comboBox_2.getSelectedItem();
				String naziv=textField_13.getText().trim();
				int id_gledanja1=-1;
				for (Gledanje gledanje : moji_filmovi) {
					if(gledanje.getNaziv().equals(naziv)) {
						id_gledanja1=gledanje.getId_gledanja();
					break;
				}}
				if(id_gledanja1!=-1) {
				try {
					dao_gledanje.izmeni(ocena, status, id_gledanja1);
					moji_filmovi_tabela(korisnik);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
				changePanel(panel_izmeni_film, panel_mymovies);
				}});

		btnNewButton_8_1.setBounds(240, 347, 89, 23);
		panel_izmeni_film.add(btnNewButton_8_1);
		
		JButton btnNewButton_9_1 = new JButton("Otkazi");
		btnNewButton_9_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePanel(panel_izmeni_film, panel_mymovies);
			}});
		
		btnNewButton_9_1.setBounds(388, 347, 89, 23);
		panel_izmeni_film.add(btnNewButton_9_1);
		
		JButton btnNewButton_14 = new JButton("Obrisi");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int result=	JOptionPane.showConfirmDialog(btnNewButton_14, "Da li ste sigurni da zelite da izbrisete film iz vase liste?");
            int id_filma1=-1;
			if(result==0) {
			for (Gledanje gledanje : moji_filmovi) {
				if(gledanje.getNaziv().equals(textField_13.getText().trim())){
				id_filma1=gledanje.getId_filma();
				break;
				}}
			System.out.println(id_filma1);
			System.out.println(korisnik.getId_korisnika());
			if(id_filma1!=-1) {
			try {
				dao_gledanje.izbrisi(id_filma1, korisnik.getId_korisnika());
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}}
			moji_filmovi.clear();
			table_1.clearSelection();
			try {
				moji_filmovi=dao_gledanje.vratimojeFilmove(korisnik);
				TabelaMoji_Filmovi tablemym=new TabelaMoji_Filmovi(moji_filmovi);
				table_1.setModel(tablemym);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			changePanel(panel_izmeni_film, panel_mymovies);
		}});
		btnNewButton_14.setBounds(80, 347, 89, 23);
		panel_izmeni_film.add(btnNewButton_14);
	}

	@Override
	public void changePanel(JPanel curent, JPanel next) {
		curent.setVisible(false);
		next.setVisible(true);
			}

	@Override
	public void logovanje(JTextField username, JPasswordField password) {
		if(username.getText().trim().length()>0 && username!=null && password.getText().trim().length()>0 && password!=null) {
			try {
				 korisnik=dao_korisnik.login(username, password);
				 textField_5.setText(korisnik.getIme());
				 textField_6.setText(korisnik.getPrezime());
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}}

	@Override
	public void moji_filmovi_tabela(Korisnik korisnik) {
		moji_filmovi.clear();
		table_1.clearSelection();
		try {
			moji_filmovi=dao_gledanje.vratimojeFilmove(korisnik);
			TabelaMoji_Filmovi tablemym=new TabelaMoji_Filmovi(moji_filmovi);
			table_1.setModel(tablemym);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}}

	@Override
	public void svi_filmovi_tabela() {
		table.clearSelection();
		svi_filmovi.clear();
		try {
			svi_filmovi=dao_film.vratiFilmove();
			Tabela_Filmovi tablem=new Tabela_Filmovi(svi_filmovi);
			table.setModel(tablem);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}}
	}