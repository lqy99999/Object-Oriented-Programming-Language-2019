

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.glass.events.WindowEvent;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class successNote extends JFrame {

	private JPanel contentPane;
	JLabel lblNewLabel;
	
	public void changeContent(String a) {
		lblNewLabel.setText(a);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					successNote frame = new successNote();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public successNote() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setUndecorated(true);
		setBounds(420, 270, 442, 110);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblNewLabel = new JLabel("Your reservation is saved.", SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
		
//		JLabel lblX = new JLabel("  X");
//		lblX.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				dispose();
//			}
//		});
//		lblX.setFont(new Font("Arial", Font.BOLD, 25));
//		lblX.setBounds(404, 0, 46, 29);
//		lblX.setForeground(new Color(51,63,125));
//		contentPane.add(lblX);
	}

}
