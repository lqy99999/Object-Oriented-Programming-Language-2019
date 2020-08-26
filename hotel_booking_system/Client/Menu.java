

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class Menu extends JPanel {
	private String userName;
	JLabel bmenu_x ;
	JButton bmenu_search_hotel ;
	JButton bmenu_book_hotel ;
	JButton bmenu_change_reservation ;
	JButton bmenu_search_reservation ;
	
	/**
	 * Create the panel.
	 */
	public Menu() {
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(150,50,984,603);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 984, 603);
		panel.setBackground(new Color(255, 255, 255));
		add(panel);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		
		bmenu_search_hotel = new JButton("");
		bmenu_search_hotel.setIcon(new ImageIcon(Menu.class.getResource("/images/ok.png")));
		bmenu_search_hotel.setForeground(null);
		bmenu_search_hotel.setBackground(null);
		bmenu_search_hotel.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		bmenu_search_hotel.setBounds(354, 159, 54, 54);
//		search_hotel.setBorderPainted(false);
		bmenu_search_hotel.setOpaque(false);
		bmenu_search_hotel.setContentAreaFilled(false);
		
		bmenu_x = new JLabel("  X");
		bmenu_x.setFont(new Font("Arial", Font.BOLD, 25));
		bmenu_x.setBounds(935, 0, 49, 32);
		bmenu_x.setForeground(SystemColor.textHighlightText);
		panel.add(bmenu_x);
		panel.add(bmenu_search_hotel);
		
		bmenu_book_hotel = new JButton("");
		
		bmenu_book_hotel.setIcon(new ImageIcon(Menu.class.getResource("/images/ok.png")));
		bmenu_book_hotel.setForeground((Color) null);
		bmenu_book_hotel.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		bmenu_book_hotel.setContentAreaFilled(false);
//		book_hotel.setBorderPainted(false);
		bmenu_book_hotel.setOpaque(false);
		bmenu_book_hotel.setBackground((Color) null);
		bmenu_book_hotel.setBounds(274, 230, 54, 54);
		panel.add(bmenu_book_hotel);
		
		bmenu_change_reservation = new JButton("");
		bmenu_change_reservation.setIcon(new ImageIcon(Menu.class.getResource("/images/ok.png")));
		bmenu_change_reservation.setForeground((Color) null);
		bmenu_change_reservation.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		bmenu_change_reservation.setContentAreaFilled(false);
//		change_reservation.setBorderPainted(false);
		bmenu_change_reservation.setOpaque(false);
		bmenu_change_reservation.setBackground((Color) null);
		bmenu_change_reservation.setBounds(322, 302, 54, 54);
		panel.add(bmenu_change_reservation);
		
		bmenu_search_reservation = new JButton("");
		
		bmenu_search_reservation.setIcon(new ImageIcon(Menu.class.getResource("/images/ok.png")));
		bmenu_search_reservation.setForeground((Color) null);
		bmenu_search_reservation.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		bmenu_search_reservation.setContentAreaFilled(false);
//		search_reservation.setBorderPainted(false);
		bmenu_search_reservation.setOpaque(false);
		bmenu_search_reservation.setBackground((Color) null);
		bmenu_search_reservation.setBounds(374, 375, 54, 54);
		panel.add(bmenu_search_reservation);
		
//		JLabel lblWelcome = new JLabel("");
//		lblWelcome.setText(this.getUserName());
//		lblWelcome.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
//		lblWelcome.setBackground(Color.GRAY);
//		lblWelcome.setBounds(742, -1, 282, 36);
//		panel.add(lblWelcome);
		
		JLabel lblHotel = new JLabel("Hotel - Menu");
		lblHotel.setBackground(SystemColor.menu);
		lblHotel.setFont(new Font("Viner Hand ITC", Font.BOLD, 50));
		lblHotel.setBounds(58, 15, 889, 139);
		panel.add(lblHotel);
		
		JLabel lblUserName = new JLabel("• Search available hotel");
		lblUserName.setFont(new Font("Bahnschrift", Font.PLAIN, 26));
		lblUserName.setBackground(Color.GRAY);
		lblUserName.setBounds(68, 169, 282, 36);
		panel.add(lblUserName);
		
		JLabel lblSearchYour = new JLabel("• Book your room");
		lblSearchYour.setFont(new Font("Bahnschrift", Font.PLAIN, 26));
		lblSearchYour.setBackground(Color.GRAY);
		lblSearchYour.setBounds(68, 235, 198, 42);
		panel.add(lblSearchYour);
		
		JLabel lblCancelOr = new JLabel("• Change reservation");
		lblCancelOr.setFont(new Font("Bahnschrift", Font.PLAIN, 26));
		lblCancelOr.setBackground(Color.GRAY);
		lblCancelOr.setBounds(68, 307, 260, 42);
		panel.add(lblCancelOr);
		
		JLabel lblSearchYour_1 = new JLabel("• Search your reservation");
		lblSearchYour_1.setFont(new Font("Bahnschrift", Font.PLAIN, 26));
		lblSearchYour_1.setBackground(Color.GRAY);
		lblSearchYour_1.setBounds(68, 380, 302, 36);
		panel.add(lblSearchYour_1);		
		
//		JLabel lblNewLabel = new JLabel("New label");
//		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/images/透明白.png")));
//		lblNewLabel.setBounds(0, 143, 984, 307);
//		panel.add(lblNewLabel);
		
		JLabel image = new JLabel("Image");
		image.setFont(new Font("Bradley Hand ITC", Font.BOLD, 50));
		image.setBounds(0, -425, 2311, 1330);
		panel.add(image);
		image.setIcon(new ImageIcon(Menu.class.getResource("/images/101white.png")));
	
		

	}
}
