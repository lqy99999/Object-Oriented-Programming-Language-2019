

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class SearchReservation extends JPanel {
	JTable table2;
	JLabel sr_x ;
	JTextField sr_txt_noroom;
	JMenuItem msr_sh ;
	JMenuItem msr_bh ;
	JMenuItem msr_cr ;
	JButton sh_ok ;
	DefaultTableModel tablemodel2 ;
	/**
	 * Create the panel.
	 */
	public DefaultTableModel makeHotellist2(Query _AHR) {
		String[] heading =new String[] {"Hotel ID", "Type", "Number", "Check in", "Check out" ,"Price"};
		  tablemodel2 = new DefaultTableModel(heading, 0);
		   int id = _AHR.getHotelID();
		   int type = _AHR.getTypeOfRoom(); 
		   int number = _AHR.getNumOfRoom(); 
		   Date checkin = _AHR.getCheckin(); 
		   Date checkout = _AHR.getCheckout();
		   int price = _AHR.getPrice(); 
		   Object[] data = { id, type, number, checkin, checkout, price};
		   tablemodel2.addRow(data);

		  return tablemodel2;
	}
	
	
	public SearchReservation() {
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
		
		sr_x = new JLabel("  X");
		
		sr_x.setFont(new Font("Arial", Font.BOLD, 25));
		sr_x.setBounds(935, 0, 49, 32);
		sr_x.setForeground(new Color(51,63,125));
		contentPane.add(sr_x);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(193, 0, 742, 31);
		menuBar.setBorder(null);
		menuBar.setBackground(new Color(255,245,238));
		contentPane.add(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		mnMenu.setForeground(new Color(51,63,125));
		mnMenu.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		
		msr_sh = new JMenuItem("Search hotel");
		

		msr_sh.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		mnMenu.add(msr_sh);
		
		msr_bh = new JMenuItem("Book hotel");
		
		msr_bh.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		mnMenu.add(msr_bh);
		
		msr_cr = new JMenuItem("Change reservation");
		
		msr_cr.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		mnMenu.add(msr_cr);
		
		JMenuItem mntmSearchRes = new JMenuItem("Search reservation");

		mntmSearchRes.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		mnMenu.add(mntmSearchRes);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SearchHotel.class.getResource("/images/101Half.jpg")));
		lblNewLabel.setBounds(32, 0, 218, 603);
		contentPane.add(lblNewLabel);
		
		JLabel lblTitle = new JLabel("Search your reservation");
		lblTitle.setForeground(new Color(51,63,125));
		lblTitle.setFont(new Font("Viner Hand ITC", Font.BOLD, 50));
		lblTitle.setBounds(206, 15, 889, 139);
		contentPane.add(lblTitle);
		
		sh_ok = new JButton("YES");
		
		sh_ok.setForeground(SystemColor.inactiveCaptionBorder);
		sh_ok.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		sh_ok.setBackground(new Color(51,63,125));
		sh_ok.setBounds(530, 480, 132, 32);
		contentPane.add(sh_ok);
		
		JLabel lblHotelId = new JLabel("Ordered number:");
		lblHotelId.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblHotelId.setBackground(Color.GRAY);
		lblHotelId.setBounds(206, 221, 200, 23);
		contentPane.add(lblHotelId);
		
		sr_txt_noroom = new JTextField();
		sr_txt_noroom.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		sr_txt_noroom.setColumns(10);
		sr_txt_noroom.setBounds(376, 209, 96, 48);
		contentPane.add(sr_txt_noroom);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(208, 284, 761, 145);
		scrollPane.setVisible(true);
		contentPane.add(scrollPane);

				
		table2 = new JTable();
		
		table2.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		scrollPane.setViewportView(table2);

	}

}
