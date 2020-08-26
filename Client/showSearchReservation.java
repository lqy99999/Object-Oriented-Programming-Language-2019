

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class showSearchReservation extends JPanel {
	JTable table;
	JLabel showsr_x ;
	JMenuItem showsr_sh ;
	JMenuItem showsr_sr ;
	JMenuItem showsr_bh ;
	JMenuItem showsr_cr ;
	/**
	 * Create the panel.
	 */

	
	public showSearchReservation() {
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
		
		showsr_x = new JLabel("  X");
		showsr_x.setBounds(0, 0, 31, 29);
		contentPane.add(showsr_x);
		
		showsr_x.setFont(new Font("Arial", Font.BOLD, 25));
		showsr_x.setForeground(new Color(51,63,125));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(193, 0, 742, 31);
		menuBar.setBorder(null);
		menuBar.setBackground(new Color(255,245,238));
		contentPane.add(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		mnMenu.setForeground(new Color(51,63,125));
		mnMenu.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		
		showsr_sh = new JMenuItem("Search hotel");
		
		
		showsr_sh.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		mnMenu.add(showsr_sh);
		
		showsr_bh = new JMenuItem("Book hotel");
		
		showsr_bh.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		mnMenu.add(showsr_bh);
		
		showsr_cr = new JMenuItem("Change reservation");
		
		showsr_cr.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		mnMenu.add(showsr_cr);
		
		showsr_sr = new JMenuItem("Search reservation");
		
		showsr_sr.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		mnMenu.add(showsr_sr);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SearchHotel.class.getResource("/images/101Half.jpg")));
		lblNewLabel.setBounds(32, 0, 218, 603);
		contentPane.add(lblNewLabel);
		
		JLabel lblTitle = new JLabel("Search your reservation");
		lblTitle.setForeground(new Color(51,63,125));
		lblTitle.setFont(new Font("Viner Hand ITC", Font.BOLD, 50));
		lblTitle.setBounds(206, 15, 889, 139);
		contentPane.add(lblTitle);
		
		String[] content = new String[1500];
		for(int i = 0; i <1500; i++) {
			content[i] = String.valueOf(i);
		}
		
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(206, 130, 761, 413);
				scrollPane.setVisible(true);
				contentPane.add(scrollPane);
				
		table = new JTable();
//		table.setModel();
		table.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		scrollPane.setViewportView(table);


		
		
	}

}
