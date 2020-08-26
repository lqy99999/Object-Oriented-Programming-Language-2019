

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SignIn extends JPanel {
	Button bsignin_signin;
	JLabel bsignin_x ;
	JTextField signin_txt1 ;
	JPasswordField signin_passwordField ;

	public SignIn() {
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(150,50,984,603);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 984, 603);
		panel.setBackground(new Color(255, 255, 255));
		add(panel);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		
		signin_txt1 = new JTextField();
		signin_txt1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		signin_txt1.setBounds(369, 232, 232, 48);
		panel.add(signin_txt1);
		signin_txt1.setColumns(10);
		
		bsignin_signin = new Button("Sign in");
		bsignin_signin.setForeground(SystemColor.inactiveCaptionBorder);
		bsignin_signin.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		bsignin_signin.setBackground(new Color(241,57,83));
		bsignin_signin.setBounds(398, 443, 175, 32);
		panel.add(bsignin_signin);
		
		signin_passwordField = new JPasswordField();
		signin_passwordField.setFont(new Font("Arial", Font.PLAIN, 20));
		signin_passwordField.setBounds(369, 337, 232, 48);
		panel.add(signin_passwordField);
		
		JLabel lblUserName = new JLabel("User name");
		lblUserName.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		lblUserName.setBackground(Color.GRAY);
		lblUserName.setBounds(369, 192, 130, 23);
		panel.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		lblPassword.setBackground(Color.GRAY);
		lblPassword.setBounds(370, 295, 130, 23);
		panel.add(lblPassword);
		
		JLabel lblHotel = new JLabel("Hotel - Sign In");
		lblHotel.setFont(new Font("Viner Hand ITC", Font.BOLD, 50));
		lblHotel.setBounds(58, 15, 412, 139);
		panel.add(lblHotel);
		
		JLabel image = new JLabel("Image");
		
		bsignin_x = new JLabel("  X");
		bsignin_x.setFont(new Font("Arial", Font.BOLD, 25));
		bsignin_x.setBounds(935, 0, 49, 32);
		bsignin_x.setForeground(SystemColor.textHighlightText);
		panel.add(bsignin_x);
		
		image.setFont(new Font("Bradley Hand ITC", Font.BOLD, 50));
		image.setBounds(0, -425, 2311, 1330);
		panel.add(image);
		image.setIcon(new ImageIcon(SignIn.class.getResource("/images/101white.png")));
	}
}
