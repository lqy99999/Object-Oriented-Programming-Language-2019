

import java.awt.Color;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Arrays;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

public class CreateAccount extends JPanel {
	JPasswordField passwordField;
	JPasswordField passwordField_1;
	JLabel bcreateaccount_x ;
	JButton bcreateaccount_createaccount ;
	JLabel createaccount_sign ;
	
	public boolean isCorrect(char[] a, char[] b) {
		boolean correct = false;
		if(Arrays.equals(a,b)) {
			correct = true;
		}
		return correct;
	}
	/**
	 * Create the panel.
	 */
	public CreateAccount() {
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(150,50,984,603);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 984, 603);
		panel.setBackground(new Color(255, 255, 255));
		add(panel);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);

		
		JTextField textField = new JTextField();
		textField.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		textField.setBounds(213, 221, 232, 48);
		panel.add(textField);
		textField.setColumns(10);
		
		createaccount_sign = new JLabel("");
		createaccount_sign.setForeground(Color.RED);
		createaccount_sign.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		createaccount_sign.setBounds(524, 413, 391, 23);
		panel.add(createaccount_sign);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 20));
		passwordField.setBounds(213, 352, 232, 48);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Arial", Font.PLAIN, 20));
		passwordField_1.setBounds(524, 352, 232, 48);
		panel.add(passwordField_1);
		
		JTextField textField_1 = new JTextField();
		textField_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(524, 221, 232, 48);
		panel.add(textField_1);
		
		JLabel lblRepeatYourPassword = new JLabel("Confirm");
		lblRepeatYourPassword.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		lblRepeatYourPassword.setBackground(Color.GRAY);
		lblRepeatYourPassword.setBounds(525, 310, 241, 23);
		panel.add(lblRepeatYourPassword);
		
		JLabel lblEmail = new JLabel("Email address");
		lblEmail.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		lblEmail.setBackground(Color.GRAY);
		lblEmail.setBounds(524, 181, 220, 23);
		panel.add(lblEmail);
		
		JLabel lblUserName = new JLabel("User name");
		lblUserName.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		lblUserName.setBackground(Color.GRAY);
		lblUserName.setBounds(213, 181, 130, 23);
		panel.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		lblPassword.setBackground(Color.GRAY);
		lblPassword.setBounds(214, 310, 130, 23);
		panel.add(lblPassword);
		
		JLabel lblHotel = new JLabel("Hotel - Creat your account");
		lblHotel.setFont(new Font("Viner Hand ITC", Font.BOLD, 50));
		lblHotel.setBounds(58, 15, 836, 139);
		panel.add(lblHotel);
		
		
		bcreateaccount_createaccount = new JButton("Create account");
		bcreateaccount_createaccount.setForeground(new Color(51,23,125));
		bcreateaccount_createaccount.setBackground(SystemColor.control);
		bcreateaccount_createaccount.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		bcreateaccount_createaccount.setBounds(417, 479, 143, 32);
		
		panel.add(bcreateaccount_createaccount);
		
		JLabel image = new JLabel("Image");
		
		bcreateaccount_x = new JLabel("  X");
		bcreateaccount_x.setFont(new Font("Arial", Font.BOLD, 25));
		bcreateaccount_x.setBounds(935, 0, 49, 32);
		bcreateaccount_x.setForeground(SystemColor.textHighlightText);
		panel.add(bcreateaccount_x);
		
		image.setFont(new Font("Bradley Hand ITC", Font.BOLD, 50));
		image.setBounds(0, -425, 2311, 1330);
		panel.add(image);
		image.setIcon(new ImageIcon(CreateAccount.class.getResource("/images/101white.png")));
	

	}

}
