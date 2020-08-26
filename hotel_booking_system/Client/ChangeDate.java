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
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;


public class ChangeDate extends JPanel {
	JTextField cd_checkout;
	JTextField cd_checkin;
	JLabel cr_x ;
	JMenuItem cr_sh ;
	JMenuItem cr_bh ;
	JMenuItem cr_cr ;
	JButton cd_ok ;
	JMenuItem cr_sr ;
	
	/**
	 * Create the panel.
	 */
	public ChangeDate() {
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
		cr_x.setBounds(0, 0, 49, 32);
		contentPane.add(cr_x);
		
		cr_x.setFont(new Font("Arial", Font.BOLD, 25));
		cr_x.setForeground(new Color(51,63,125));

		
		JLabel lblHotel = new JLabel("Change your Reservation");
		lblHotel.setForeground(new Color(51,63,125));
		lblHotel.setFont(new Font("Viner Hand ITC", Font.BOLD, 50));
		lblHotel.setBounds(206, 15, 889, 139);
		contentPane.add(lblHotel);
		
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

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SearchHotel.class.getResource("/images/101Half.jpg")));
		lblNewLabel.setBounds(32, 0, 161, 603);
		contentPane.add(lblNewLabel);
		
		JLabel lblDate = new JLabel("Date from:");
		lblDate.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblDate.setBackground(Color.GRAY);
		lblDate.setBounds(206, 296, 114, 23);
		contentPane.add(lblDate);
		
		
		JLabel lblTo = new JLabel("to");
		lblTo.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblTo.setBackground(Color.GRAY);
		lblTo.setBounds(586, 296, 31, 23);
		contentPane.add(lblTo);
		
		cd_ok = new JButton("OK");
		
		cd_ok.setForeground(SystemColor.inactiveCaptionBorder);
		cd_ok.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		cd_ok.setBackground(new Color(51, 63, 125));
		cd_ok.setBounds(474, 442, 166, 32);
		contentPane.add(cd_ok);
		
		cd_checkout = new JTextField();
		cd_checkout.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		cd_checkout.setBounds(646, 284, 218, 48);
		contentPane.add(cd_checkout);
		cd_checkout.setColumns(10);
		
		cd_checkin = new JTextField();
		cd_checkin.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		cd_checkin.setBounds(335, 284, 218, 48);
		contentPane.add(cd_checkin);
		cd_checkin.setColumns(10);
		
		cd_checkout.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				DatePopup datepopup = new DatePopup(cd_checkout);
				datepopup.showDialog();
			}
		});
		
		cd_checkin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				DatePopup datepopup = new DatePopup(cd_checkin);
				datepopup.showDialog();
			}
		});
		
		/*
		 * 退訂成功，已取消您的訂房紀錄
		 * 修改成功，已將您的訂房數量變更為<房型><數量>, 
		 * 修改成功，已將您的住宿日期變更為<入住日期>-<退房日期>
		 * 修改失敗，修改數量超過訂房數量
		 * 退訂/修改失敗，此訂位代號不存在
		 */
	}
}
