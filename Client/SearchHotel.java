import java.awt.Color;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;


import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.UIManager;

public class SearchHotel extends JPanel {
	JTextField sh_datecheckin;
	JTextField sh_datecheckout;
	JTextField searchhotel_noroom;
	JLabel bsearchhotel_signin ;
	JMenuItem msh_bookhotel ;
	JMenuItem msh_changere ;
	JMenuItem msh_searchhotel ;
	JMenuItem msh_searchre ;
	JLabel bsearchhotel_x ;
	JButton bsearchhotel_search ;
	JComboBox searchhotel_combobox ;
	
	public void showDate() {
		java.util.Date d = new java.util.Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
		sh_datecheckin.setText(f.format(d));
		sh_datecheckout.setText(f.format(d));
	}
	
	/**
	 * Create the panel.
	 */
	public SearchHotel() {
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(150,50,984,603);
		
		
		JPanel contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(255,245,238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 984, 603);
		add(contentPane);
		contentPane.setLayout(null);
		
		bsearchhotel_signin = new JLabel("Sign in");

		bsearchhotel_signin.setForeground(new Color(51,63,125));
		bsearchhotel_signin.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		bsearchhotel_signin.setBounds(790, 8, 69, 23);
		contentPane.add(bsearchhotel_signin);
	
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(193, 0, 550, 31);
		menuBar.setBorder(null);
		menuBar.setBackground(new Color(255,245,238));
		contentPane.add(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		mnMenu.setForeground(new Color(51,63,125));
		mnMenu.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		
		msh_searchhotel = new JMenuItem("Search hotel");
		msh_searchhotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});

		msh_searchhotel.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		mnMenu.add(msh_searchhotel);
		
		msh_bookhotel = new JMenuItem("Book hotel");
		
		msh_bookhotel.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		mnMenu.add(msh_bookhotel);
		
		msh_changere = new JMenuItem("Change reservation");
		
		msh_changere.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		mnMenu.add(msh_changere);
		
		msh_searchre = new JMenuItem("Search reservation");
		
		msh_searchre.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		mnMenu.add(msh_searchre);
		
		JLabel lblTitle = new JLabel("Search your Hotel!");
		lblTitle.setForeground(new Color(51,63,125));
		lblTitle.setFont(new Font("Viner Hand ITC", Font.BOLD, 50));
		lblTitle.setBounds(206, 15, 889, 139);
		contentPane.add(lblTitle);
		
		JLabel lblDate = new JLabel("Date from:");
		lblDate.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblDate.setBackground(Color.GRAY);
		lblDate.setBounds(216, 190, 114, 23);
		contentPane.add(lblDate);
		
		sh_datecheckin = new JTextField();
		sh_datecheckin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				DatePopup datepopup = new DatePopup(sh_datecheckin);
				datepopup.showDialog();
			}
		});
		

		
		JLabel sign = new JLabel("");
		sign.setForeground(Color.RED);
		sign.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		sign.setBounds(548, 284, 391, 23);
		contentPane.add(sign);
		
		JLabel sign2 = new JLabel("");
		sign2.setForeground(Color.RED);
		sign2.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		sign2.setBounds(540, 370, 391, 23);
		contentPane.add(sign2);
		sh_datecheckin.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		sh_datecheckin.setBounds(345, 178, 218, 48);
		contentPane.add(sh_datecheckin);
		sh_datecheckin.setColumns(10);
		
		JLabel lblTo = new JLabel("to");
		lblTo.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblTo.setBackground(Color.GRAY);
		lblTo.setBounds(596, 190, 31, 23);
		contentPane.add(lblTo);
		
		sh_datecheckout = new JTextField();
		sh_datecheckout.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				DatePopup datepopup = new DatePopup(sh_datecheckout);
				datepopup.showDialog();
			}
		});
		sh_datecheckout.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		sh_datecheckout.setColumns(10);
		sh_datecheckout.setBounds(651, 178, 218, 48);
		contentPane.add(sh_datecheckout);
		
		JLabel lblRoomType = new JLabel("Room type:");
		lblRoomType.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblRoomType.setBackground(Color.GRAY);
		lblRoomType.setBounds(216, 284, 156, 23);
		contentPane.add(lblRoomType);
		
		JLabel lblNumberOfRoom = new JLabel("Number of room:");
		lblNumberOfRoom.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNumberOfRoom.setBackground(Color.GRAY);
		lblNumberOfRoom.setBounds(216, 370, 218, 23);
		contentPane.add(lblNumberOfRoom);
		
		searchhotel_noroom = new JTextField();
		searchhotel_noroom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try { 
					int i = Integer.valueOf(searchhotel_noroom.getText());
					sign2.setText("");
					
				}catch(NumberFormatException e) {
					
					sign2.setText("(Invalid number!)");
				}
			}
		});
		searchhotel_noroom.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		searchhotel_noroom.setColumns(10);
		searchhotel_noroom.setBounds(455, 358, 70, 48);
		contentPane.add(searchhotel_noroom);
		
		
		bsearchhotel_x = new JLabel("  X");
		
		
		bsearchhotel_x.setFont(new Font("Arial", Font.BOLD, 25));
		bsearchhotel_x.setBounds(935, 0, 49, 32);
		bsearchhotel_x.setForeground(new Color(51,63,125));
		contentPane.add(bsearchhotel_x);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SearchHotel.class.getResource("/images/101Half.jpg")));
		lblNewLabel.setBounds(32, 0, 218, 603);
		contentPane.add(lblNewLabel);
		
		searchhotel_combobox = new JComboBox();
		searchhotel_combobox.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		searchhotel_combobox.setModel(new DefaultComboBoxModel(new String[] {"Single room", "Double room", "Quad room"}));
		searchhotel_combobox.setBounds(407, 279, 156, 32);
		contentPane.add(searchhotel_combobox);
		
		bsearchhotel_search = new JButton("Search");
		
		bsearchhotel_search.setBounds(492, 526, 111, 31);
		bsearchhotel_search.setForeground(new Color(51,23,125));
		bsearchhotel_search.setBackground(SystemColor.control);
		bsearchhotel_search.setFont(new Font("Bahnschrift", Font.PLAIN, 19));
		contentPane.add(bsearchhotel_search);

		showDate();
	}
}
