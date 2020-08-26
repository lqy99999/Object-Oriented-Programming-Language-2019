

import java.awt.Color;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.util.*;

import javax.swing.SwingConstants;


public class showSearchHotel extends JPanel {
	JTextField numberOfPeople;
	JTextField numberOfRoom;
	JTable table;
	JButton showsh_book ;
	JLabel showsh_x ;
	JButton showsh_search ;
	JButton showsh_back ;
	JComboBox showsh_combobox ;
	JTextField checkin1 ;
	JTextField checkout1 ;
	DefaultTableModel tablemodel ;
	
	public DefaultTableModel makeHotellist(List<HotelInfo> _AHR) {
		String[] heading =new String[] {"ID", "Star", "City", "Address", "Price"};
		  tablemodel = new DefaultTableModel(heading, 0);
		  // get data
		  for (int i = 0; i < _AHR.size(); i++) {
		   int id = _AHR.get(i).ID; // id
		   int star = _AHR.get(i).star; // star
		   String city = _AHR.get(i).city; // locality
		   String address = _AHR.get(i).address; // address
		   int price = _AHR.get(i).price; // price
		   Object[] data = { id, star, city, address, price};
		   tablemodel.addRow(data);
		  }
		  return tablemodel;
	}
	/**
	 * Create the panel.
	 */
	
	public showSearchHotel() {
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
		
		JLabel lblDate = new JLabel("Date from:");
		lblDate.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblDate.setBackground(Color.GRAY);
		lblDate.setBounds(206, 132, 114, 23);
		contentPane.add(lblDate);
		
		checkin1 = new JTextField();
		checkin1.setHorizontalAlignment(SwingConstants.CENTER);
		
		checkin1.setEditable(false);
		checkin1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		checkin1.setBounds(304, 128, 114, 35);
		contentPane.add(checkin1);
		checkin1.setColumns(10);
		
		JLabel lblTo = new JLabel("to");
		lblTo.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblTo.setBackground(Color.GRAY);
		lblTo.setBounds(425, 132, 31, 23);
		contentPane.add(lblTo);
		
		checkout1 = new JTextField();
		checkout1.setHorizontalAlignment(SwingConstants.CENTER);
		
		checkout1.setEditable(false);
		checkout1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		checkout1.setColumns(10);
		checkout1.setBounds(448, 128, 114, 35);
		
		contentPane.add(checkout1);
		
		showsh_x = new JLabel("  X");
		
		
		JLabel lblroom = new JLabel("");
		lblroom.setIcon(new ImageIcon(showSearchHotel.class.getResource("/images/door.png")));
		lblroom.setBounds(550, 130, 49, 38);
		contentPane.add(lblroom);
		
		numberOfPeople = new JTextField();
		numberOfPeople.setHorizontalAlignment(SwingConstants.CENTER);
		
		numberOfPeople.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		numberOfPeople.setEditable(false);
		numberOfPeople.setColumns(10);
		numberOfPeople.setBounds(590, 128, 122, 35);
		contentPane.add(numberOfPeople);
		
		numberOfRoom = new JTextField();
		numberOfRoom.setHorizontalAlignment(SwingConstants.CENTER);
		
		numberOfRoom.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		numberOfRoom.setEditable(false);
		numberOfRoom.setColumns(10);
		numberOfRoom.setBounds(717, 128, 49, 35);
		contentPane.add(numberOfRoom);
		
		showsh_x.setFont(new Font("Arial", Font.BOLD, 25));
		showsh_x.setBounds(935, 0, 49, 32);
		showsh_x.setForeground(new Color(51,63,125));
		contentPane.add(showsh_x);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(showSearchHotel.class.getResource("/images/101Half.jpg")));
		lblNewLabel.setBounds(32, 0, 218, 603);
		contentPane.add(lblNewLabel);
		
		showsh_combobox = new JComboBox();
		showsh_combobox.setToolTipText("Filter");
		showsh_combobox.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		showsh_combobox.setForeground(new Color(51,23,125));
		showsh_combobox.setModel(new DefaultComboBoxModel(new String[] {"Price: Low to High", "Star", "Locality"}));
		showsh_combobox.setBounds(761, 81, 187, 32);
		contentPane.add(showsh_combobox);
		
		JLabel lblTitle = new JLabel("Search your Hotel!");
		lblTitle.setForeground(new Color(51,63,125));
		lblTitle.setFont(new Font("Viner Hand ITC", Font.BOLD, 50));
		lblTitle.setBounds(206, 15, 889, 139);
		contentPane.add(lblTitle);
		
		showsh_search = new JButton("Search");
		
		
		showsh_back = new JButton("BACK");
		
		showsh_back.setBackground(SystemColor.control);
		showsh_back.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		showsh_back.setBorderPainted(false);
		showsh_back.setOpaque(false);
		showsh_back.setBounds(882, 129, 87, 32);
		contentPane.add(showsh_back);
		
		showsh_search.setBounds(771, 128, 111, 31);
		showsh_search.setForeground(new Color(51,23,125));
		showsh_search.setBackground(SystemColor.control);
		showsh_search.setFont(new Font("Bahnschrift", Font.PLAIN, 19));
		contentPane.add(showsh_search);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(206, 178, 761, 382);
		contentPane.add(scrollPane);
		
		showsh_book = new JButton("Book");
		
		showsh_book.setForeground(new Color(51, 23, 125));
		showsh_book.setFont(new Font("Bahnschrift", Font.PLAIN, 19));
		showsh_book.setBackground(SystemColor.menu);
		showsh_book.setBounds(538, 565, 111, 31);
		contentPane.add(showsh_book);
		
		table = new JTable();
		JTableHeader head = table.getTableHeader();
		head.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		table.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
				
	}
}


