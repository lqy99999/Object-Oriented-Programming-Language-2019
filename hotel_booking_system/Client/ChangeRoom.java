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


public class ChangeRoom extends JPanel {
	JTextField Dnumber;
	JLabel croom_x ;
	JMenuItem croom_sh ;
	JMenuItem croom_bh ;
	JMenuItem croom_sr ;
	JMenuItem croom_cr ;
	JButton croom_ok ;
	/**
	 * Create the panel.
	 */
	public ChangeRoom() {
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
		
		croom_x = new JLabel("  X");
		croom_x.setBounds(935, 0, 49, 32);
		contentPane.add(croom_x);
		
		croom_x.setFont(new Font("Arial", Font.BOLD, 25));
		croom_x.setForeground(new Color(51,63,125));
		
		JLabel Ssign = new JLabel("");
		Ssign.setForeground(Color.RED);
		Ssign.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		Ssign.setBounds(475, 196, 391, 23);
		contentPane.add(Ssign);
		
		JLabel Dsign = new JLabel("");
		Dsign.setForeground(Color.RED);
		Dsign.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		Dsign.setBounds(475, 272, 391, 23);
		contentPane.add(Dsign);
		
		JLabel Qsign = new JLabel("");
		Qsign.setForeground(Color.RED);
		Qsign.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		Qsign.setBounds(475, 343, 391, 23);
		contentPane.add(Qsign);
		
		Dnumber = new JTextField();
		Dnumber.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		Dnumber.setColumns(10);
		Dnumber.setBounds(574, 280, 70, 48);
		contentPane.add(Dnumber);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(193, 0, 742, 31);
		menuBar.setBorder(null);
		menuBar.setBackground(new Color(255,245,238));
		contentPane.add(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		mnMenu.setForeground(new Color(51,63,125));
		mnMenu.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		
		croom_sh = new JMenuItem("Search hotel");
		

		croom_sh.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		mnMenu.add(croom_sh);
		
		croom_bh = new JMenuItem("Book hotel");
		
		croom_bh.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		mnMenu.add(croom_bh);
		
		croom_cr = new JMenuItem("Change reservation");
		
		croom_cr.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		mnMenu.add(croom_cr);
		
		croom_sr = new JMenuItem("Search reservation");
		
		croom_sr.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		mnMenu.add(croom_sr);
		
		JLabel lblHotel = new JLabel("Change your Reservation");
		lblHotel.setForeground(new Color(51,63,125));
		lblHotel.setFont(new Font("Viner Hand ITC", Font.BOLD, 50));
		lblHotel.setBounds(206, 15, 889, 139);
		contentPane.add(lblHotel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SearchHotel.class.getResource("/images/101Half.jpg")));
		lblNewLabel.setBounds(32, 0, 161, 603);
		contentPane.add(lblNewLabel);
		
		croom_ok = new JButton("OK");
		
		croom_ok.setForeground(SystemColor.inactiveCaptionBorder);
		croom_ok.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		croom_ok.setBackground(new Color(51, 63, 125));
		croom_ok.setBounds(474, 442, 166, 32);
		contentPane.add(croom_ok);
		
		JLabel lblDoubleRoom = new JLabel("Decrease room number:");
		lblDoubleRoom.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblDoubleRoom.setBackground(Color.GRAY);
		lblDoubleRoom.setBounds(339, 292, 243, 23);
		contentPane.add(lblDoubleRoom);
		

	}
}
