import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;


public class ChangeReservation extends JPanel {
	JLabel cr_x ;
	JTextField cr_txt_noroom;
	JMenuItem cr_sh ;
	JMenuItem cr_bh ;
	JMenuItem cr_cr;
	JMenuItem cr_sr;
	JComboBox cr_combobox ;
	JButton cr_cancel ;
	JButton cr_changeroom ;
	JButton cr_changedate ;
	/**
	 * Create the panel.
	 */
	public ChangeReservation() {
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
		
		cr_x = new JLabel("  X");
		
		cr_x.setFont(new Font("Arial", Font.BOLD, 25));
		cr_x.setBounds(935, 0, 49, 32);
		cr_x.setForeground(new Color(51,63,125));
		contentPane.add(cr_x);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(193, 0, 742, 31);
		menuBar.setBorder(null);
		menuBar.setBackground(new Color(255,245,238));
		contentPane.add(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		mnMenu.setForeground(new Color(51,63,125));
		mnMenu.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		
		cr_sh = new JMenuItem("Search hotel");
		

		cr_sh.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		mnMenu.add(cr_sh);
		
		cr_bh = new JMenuItem("Book hotel");
		
		cr_bh.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		mnMenu.add(cr_bh);
		
		cr_cr = new JMenuItem("Change reservation");
		cr_cr.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		mnMenu.add(cr_cr);
		
		cr_sr = new JMenuItem("Search reservation");
		
		cr_sr.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		mnMenu.add(cr_sr);	
		
		
		JLabel lblHotel = new JLabel("Change your Reservation");
		lblHotel.setForeground(new Color(51,63,125));
		lblHotel.setFont(new Font("Viner Hand ITC", Font.BOLD, 50));
		lblHotel.setBounds(206, 15, 889, 139);
		contentPane.add(lblHotel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SearchHotel.class.getResource("/images/101Half.jpg")));
		lblNewLabel.setBounds(32, 0, 161, 603);
		contentPane.add(lblNewLabel);
		
		JLabel lblHotelId = new JLabel("Ordered number:");
		lblHotelId.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblHotelId.setBackground(Color.GRAY);
		lblHotelId.setBounds(429, 281, 200, 23);
		contentPane.add(lblHotelId);
		
		cr_txt_noroom = new JTextField();
		cr_txt_noroom.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		cr_txt_noroom.setColumns(10);
		cr_txt_noroom.setBounds(619, 269, 96, 48);
		contentPane.add(cr_txt_noroom);
		
		cr_changedate = new JButton("Change Date");
		
		cr_changedate.setForeground(SystemColor.inactiveCaptionBorder);
		cr_changedate.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		cr_changedate.setBackground(new Color(51, 63, 125));
		cr_changedate.setBounds(474, 442, 166, 32);
		contentPane.add(cr_changedate);
		
		cr_cancel = new JButton("Cancel");
		
		cr_cancel.setForeground(SystemColor.inactiveCaptionBorder);
		cr_cancel.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		cr_cancel.setBackground(new Color(51,63,125));
		cr_cancel.setBounds(291, 442, 132, 32);
		contentPane.add(cr_cancel);
		
		cr_changeroom = new JButton("Change Room");
		
		cr_changeroom.setForeground(SystemColor.inactiveCaptionBorder);
		cr_changeroom.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		cr_changeroom.setBackground(new Color(51, 63, 125));
		cr_changeroom.setBounds(689, 442, 166, 32);
		contentPane.add(cr_changeroom);
		
	}
}
