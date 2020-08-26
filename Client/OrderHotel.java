
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class OrderHotel extends JPanel {
	JTextField txt;
	JTextField txt1;
	JTextField txt_3;
	JLabel borderhotel_x ;
	JMenuItem moh_sh ;
	JMenuItem moh_bh ;
	JMenuItem moh_cr ;
	JMenuItem moh_sr ;
	JButton borderhotel_ok ;
	JComboBox bh_hotelid ;
	JComboBox orderhotel_nopeople ;
	JTextField txt_noroom ;
	/**
	 * Create the panel.
	 */
	public OrderHotel() {
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
		
		borderhotel_x = new JLabel("  X");
		
		borderhotel_x.setFont(new Font("Arial", Font.BOLD, 25));
		borderhotel_x.setBounds(935, 0, 49, 32);
		borderhotel_x.setForeground(new Color(51,63,125));
		contentPane.add(borderhotel_x);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(193, 0, 550, 31);
		menuBar.setBorder(null);
		menuBar.setBackground(new Color(255,245,238));
		contentPane.add(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		mnMenu.setForeground(new Color(51,63,125));
		mnMenu.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		
		moh_sh = new JMenuItem("Search hotel");
		

		moh_sh.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		mnMenu.add(moh_sh);
		
		moh_bh = new JMenuItem("Book hotel");
		moh_bh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		moh_bh.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		mnMenu.add(moh_bh);
		
		moh_cr = new JMenuItem("Change reservation");
		
		moh_cr.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		mnMenu.add(moh_cr);
		
		moh_sr = new JMenuItem("Search reservation");
		
		moh_sr.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		mnMenu.add(moh_sr);
		
		
		JLabel lblTitle = new JLabel("Book your hotel!");
		lblTitle.setForeground(new Color(51,63,125));
		lblTitle.setFont(new Font("Viner Hand ITC", Font.BOLD, 50));
		lblTitle.setBounds(206, 15, 889, 139);
		contentPane.add(lblTitle);
		
		JLabel lblDate = new JLabel("Date from:");
		lblDate.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblDate.setBackground(Color.GRAY);
		lblDate.setBounds(216, 278, 114, 23);
		contentPane.add(lblDate);
		
		txt = new JTextField();
		txt.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				DatePopup datepopup = new DatePopup(txt);
				datepopup.showDialog();
			}
		});
		txt.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		txt.setBounds(345, 266, 218, 48);
		contentPane.add(txt);
		txt.setColumns(10);
		
		JLabel lblTo = new JLabel("to");
		lblTo.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblTo.setBackground(Color.GRAY);
		lblTo.setBounds(596, 278, 31, 23);
		contentPane.add(lblTo);
		
		txt1 = new JTextField();
		txt1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		txt1.setColumns(10);
		txt1.setBounds(651, 266, 218, 48);
		txt1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				DatePopup datepopup = new DatePopup(txt1);
				datepopup.showDialog();
			}
		});
		contentPane.add(txt1);
		
		JLabel lblNumberOfPeople = new JLabel("Type of room:");
		lblNumberOfPeople.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNumberOfPeople.setBackground(Color.GRAY);
		lblNumberOfPeople.setBounds(216, 356, 162, 23);
		contentPane.add(lblNumberOfPeople);
		
		JLabel lblNumberOfRoom = new JLabel("Number of room:");
		lblNumberOfRoom.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNumberOfRoom.setBackground(Color.GRAY);
		lblNumberOfRoom.setBounds(216, 431, 162, 23);
		contentPane.add(lblNumberOfRoom);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(495, 431, 391, 23);
		contentPane.add(lblNewLabel_2);
		
		txt_noroom = new JTextField();
		txt_noroom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				try { 
					int i = Integer.parseInt(txt_noroom.getText());
					lblNewLabel_2.setText("");
					
				}catch(NumberFormatException e) {
					
					lblNewLabel_2.setText("(Invalid number!)");
				}
			}
		});
		txt_noroom.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		txt_noroom.setColumns(10);
		txt_noroom.setBounds(393, 419, 96, 48);
		contentPane.add(txt_noroom);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SearchHotel.class.getResource("/images/101Half.jpg")));
		lblNewLabel.setBounds(32, 0, 218, 603);
		contentPane.add(lblNewLabel);
		
		JLabel lblUserId = new JLabel("User ID:");
		lblUserId.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblUserId.setBackground(Color.GRAY);
		lblUserId.setBounds(216, 195, 114, 23);
		contentPane.add(lblUserId);
		
		txt_3 = new JTextField();
		txt_3.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		txt_3.setColumns(10);
		txt_3.setBounds(314, 183, 218, 48);
		contentPane.add(txt_3);
		
		JLabel lblHotelId = new JLabel("Hotel ID:");
		lblHotelId.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblHotelId.setBackground(Color.GRAY);
		lblHotelId.setBounds(596, 195, 114, 23);
		contentPane.add(lblHotelId);
		
		String[] content = new String[1500];
		for(int i = 0; i <1500; i++) {
			content[i] = String.valueOf(i);
		}
		bh_hotelid = new JComboBox();
		bh_hotelid.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		bh_hotelid.setModel(new DefaultComboBoxModel(content));
		bh_hotelid.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		bh_hotelid.setBounds(713, 190, 106, 32);
		contentPane.add(bh_hotelid);
		
		orderhotel_nopeople = new JComboBox();
		orderhotel_nopeople.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		orderhotel_nopeople.setModel(new DefaultComboBoxModel(new String[] {"Single room", "Double room", "Quad room"}));
		orderhotel_nopeople.setBounds(407, 351, 156, 32);
		contentPane.add(orderhotel_nopeople);
		
		
		borderhotel_ok = new JButton("YES");
		
		borderhotel_ok.setForeground(SystemColor.inactiveCaptionBorder);
		borderhotel_ok.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		borderhotel_ok.setBackground(new Color(51,63,125));
		borderhotel_ok.setBounds(495, 509, 132, 32);
		contentPane.add(borderhotel_ok);

		
	}
}
