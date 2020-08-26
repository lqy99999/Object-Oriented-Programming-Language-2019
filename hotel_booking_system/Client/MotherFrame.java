

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseMotionAdapter;

public class MotherFrame extends JFrame {

	private JPanel contentPane = new JPanel();
	public int test = 10;
	int xx,xy;

	/**
	 * Launch the application.
	 */
	
	public String stringtype(int i) {
		switch (i) {
		case 1:
			return "Single room";
		case 2:
			return "Double room";
		case 4:
			return "Quad room";
		}

	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MotherFrame frame = new MotherFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	/**
	 * Create the frame.
	 */
	public MotherFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150,50,984,603);
		setUndecorated(true);
		
		CardLayout card;
		card = new CardLayout();
		contentPane.setLayout(card);
		
		SearchReservation searchreservation = new SearchReservation();
		ChangeReservation changereservation = new ChangeReservation();
		Menu menu = new Menu();
		OrderHotel orderhotel = new OrderHotel();
		SearchHotel searchhotel = new SearchHotel();
		CreateAccount createaccount = new CreateAccount();
		SignIn signin = new SignIn();
		Welcome welcome = new Welcome();
		showSearchHotel showsearchhotel = new showSearchHotel();
		showSearchReservation showsearchreservation = new showSearchReservation();
		ChangeDate changedate = new ChangeDate();
		ChangeRoom changeroom = new ChangeRoom();
		
		
		this.add(contentPane);
		contentPane.add(welcome,"1");
		contentPane.add(signin,"2");
		contentPane.add(createaccount,"3");
		contentPane.add(menu,"4");
		contentPane.add(searchhotel,"5");
		contentPane.add(orderhotel,"6");
		contentPane.add(searchreservation,"7");
		contentPane.add(changereservation,"8");
		contentPane.add(showsearchhotel,"9");
		contentPane.add(changedate,"10");
		contentPane.add(changeroom,"11");
		contentPane.add(showsearchreservation,"12");
		

		card.show(contentPane,"1");
		showsearchreservation.showsr_x.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				card.show(contentPane,"1");
			}
		});
		showsearchreservation.showsr_sh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentPane,"5");
			}
		});
		showsearchreservation.showsr_bh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentPane,"6");
			}
		});
		showsearchreservation.showsr_cr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentPane,"8");
			}
		});
		showsearchreservation.showsr_sr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentPane,"7");
			}
		});
		showsearchhotel.showsh_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				user.makeQuery(LISTHOTEL,orderhotel.txt_3.getText(),orderhotel.txt.getText(),
						orderhotel.txt1.getText(),orderhotel.orderhotel_nopeople.getSelectedItem().toString(),
						orderhotel.txt_noroom.getText(),null,null);
				
				Reponse reponse = user.getReponse();
				if(reponse.isSuccess==false){					
				}
				else{
					if(showsearchhotel.showsh_combobox.getSelectedIndex() == 0) {
						showsearchhotel.table.setModel(showsearchhotel.makeHotellist(reponse.getHotelInfoList()));
					}else if (showsearchhotel.showsh_combobox.getSelectedIndex() == 1) {
						showsearchhotel.table.setModel(showsearchhotel.makeHotellist(reponse.getHotelInfoList("STAR")));
					}else if(showsearchhotel.showsh_combobox.getSelectedIndex() == 2) {
						showsearchhotel.table.setModel(showsearchhotel.makeHotellist(reponse.getHotelInfoList("CITY")));
					}
				}
			}
		});
		showsearchhotel.showsh_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				card.show(contentPane,"5");
				
			}
		});
		showsearchhotel.showsh_book.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				card.show(contentPane,"6");
				
			}
		});
		showsearchhotel.showsh_x.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				card.show(contentPane,"1");
			}
		});
		changeroom.croom_x.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				card.show(contentPane,"1");
			}
		});
		changeroom.croom_sh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentPane,"5");
			}
		});
		changeroom.croom_bh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentPane,"6");

			}
		});
		changeroom.croom_cr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentPane,"8");
			}
		});
		changeroom.croom_sr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentPane,"7");
			}
		});
		changeroom.croom_ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				successNote a  = new successNote();
				user.makeQuery(MODIFYROOMNUM,null,null,null,null,null,
						Integer.parseInt(changereservation.cr_txt_noroom.getText(),null);
				Query reponse = user.getResponse();
				if(reponse.isSuccess == false) {
					b.changeContent(reponse.getErrorMessage()); 
				}else {
					a.changeContent("Change success"); 
				}
				 //靽格憭望��耨�����������
				a.setVisible(true);
				
				card.show(contentPane,"8");
			}
		});
		
		changedate.cr_x.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				card.show(contentPane,"1");
			}
		});
		changedate.cr_sh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentPane,"5");
			}
		});
		changedate.cr_bh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentPane,"6");
			}
		});
		changedate.cr_cr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentPane,"8");
			}
		});
		changedate.cr_sr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentPane,"7");
			}
		});
		changedate.cd_ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				successNote a  = new successNote();
				user.makeQuery(MODIFYROOMNUM,null,null,null,null,null,
						Integer.parseInt(changereservation.cr_txt_noroom.getText(),null);
				Query reponse = user.getResponse();
				if(reponse.isSuccess == false) {
					b.changeContent(reponse.getErrorMessage()); 
				}else {
					a.changeContent("Change success"); 
				}
				a.setVisible(true);
				
				card.show(contentPane,"8");
			}
		});

		changereservation.cr_x.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				card.show(contentPane,"1");
			}
		});
		changereservation.cr_sh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentPane,"5");
			}
		});
		changereservation.cr_bh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentPane,"6");
			}
		});
		changereservation.cr_sr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentPane,"7");
			}
		});
		changereservation.cr_changedate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				card.show(contentPane,"10");					
			}
		});
		changereservation.cr_cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {				
				successNote b = new successNote();
				user.makeQuery(CANCEL,null,null,null,null,null,
						Integer.parseInt(changereservation.cr_txt_noroom.getText(),null);
				Query reponse = user.getResponse();
				if(reponse.isSuccess == false) {
					b.changeContent(reponse.getErrorMessage()); 
				}else {
					b.changeContent("Cancel successfully."); 
				}
				
				b.setVisible(true);
				card.show(contentPane,"4");
			}
		});
		changereservation.cr_changeroom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				card.show(contentPane,"11");

			}
		});

		searchreservation.sh_ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {				
				user.makeQuery(CHECKORDER,null,null,null,null,null,null,searchreservation.sr_txt_noroom.getText(),null);
				Query reponse = user.getResponse();
				if(reponse.isSuccess==false){					
				}
				else{
					Query result = reponse.getResult();
					searchreservation.table2.setModel(searchreservation.makeHotellist2(result);
				}

			}
		});

		searchreservation.sr_x.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				card.show(contentPane,"1");
			}
		});
		searchreservation.msr_sh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentPane,"5");
			}
		});
		searchreservation.msr_bh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentPane,"6");
			}
		});
		searchreservation.msr_cr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentPane,"8");
			}
		});
	
		orderhotel.borderhotel_x.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				card.show(contentPane,"1");
			}
		});
		orderhotel.moh_sh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentPane,"5");
			}
		});
		orderhotel.moh_cr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentPane,"8");
			}
		});
		orderhotel.moh_sr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {	
				card.show(contentPane,"7");
			}
		});
		orderhotel.borderhotel_ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				successNote a  = new successNote();
				
				user.makeQuery(BOOK,orderhotel.txt_3.getText(),orderhotel.txt.getText(),
						orderhotel.txt1.getText(),orderhotel.orderhotel_nopeople.getSelectedItem().toString(),
						orderhotel.txt_noroom.getText(),null,null);
				Reponse reponse = user.getReponse();
				if(reponse.isSuccess==false){
					a.changeContent(reponse.getErrorMessage());
				}
				else{
					Query result = reponse.getResult();
					a.changeContent("<Book ID>  "+result.getBookID()+
							"\n<User ID>  " + ID +
							"\n<Hotel ID>  "+ result.getHotelID()+
							"\n<" + stringtype(result.getTypeOfRoom())+ ">  " + result.getNumOfRoom().toString()+
							"\n<Check in>  " + result.getCheckin()+
							"\n<Check out>  " + result.getCheckout()+
							"\nLast for " + Date.difference(result.getCheckin(),result.getCheckout())+
							"days" + "\n<Price>  " + result.getPrice());
				}
				a.setVisible(true);

			}
		});
		
		searchhotel.bsearchhotel_search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				showsearchhotel.checkin1.setText(searchhotel.sh_datecheckin.getText());
				showsearchhotel.checkout1.setText(searchhotel.sh_datecheckout.getText());
				showsearchhotel.numberOfPeople.setText(searchhotel.searchhotel_combobox.getSelectedItem().toString());
				showsearchhotel.numberOfRoom.setText(searchhotel.searchhotel_noroom.getText());
				
				makequery(price low-> high,checkin,)
				if(reponse.isSuccess==false){a.changeContent(reponse.getErrorMessage());}
				else{
					Query result = reponse.getResult();
					showsearchhotel.table.setModel(showsearchhotel.makeHotellist(reponse.getHotelInfoList()));
					card.show(contentPane,"9");
			}
		});
		
		searchhotel.bsearchhotel_x.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				card.show(contentPane,"1");
			}
		});
		
		searchhotel.msh_searchre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentPane,"7");				
			}
		});
		
		searchhotel.msh_changere.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentPane,"8");
			}
		});
		
		searchhotel.msh_bookhotel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentPane,"6");
			}
		});
		
//		searchhotel.bsearchhotel_signup.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				card.show(contentPane,"3");
//			}
//		});
		
		searchhotel.bsearchhotel_signin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				card.show(contentPane,"2");
			}
		});
		menu.bmenu_search_hotel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				card.show(contentPane,"5");
			}
		});
		menu.bmenu_x.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				card.show(contentPane,"1");
			}
		});
		menu.bmenu_book_hotel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				card.show(contentPane,"6");
			}
		});
		menu.bmenu_change_reservation.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				card.show(contentPane,"8");
			}
		});
		menu.bmenu_search_reservation.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				card.show(contentPane,"7");
			}
		});
		
//		createaccount.bcreateaccount_createaccount.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				if(createaccount.isCorrect(createaccount.passwordField.getPassword(), createaccount.passwordField_1.getPassword())) {
//					successNote b = new successNote();
//					user.makeQuery(SIGNIN,null,null,null,null,null,null,
//							signin.signin_txt1.getText()+"/"+String.valueOf(signin.signin_passwordField.getPassword()),null)
//					Query reponse = user.getResponse();
//					if(reponse.isSuccess == false) {
//						b.changeContent(reponse.getErrorMessage());
//					}else {
//						b.changeContent("Create account successfully.");
//					}
//					b.setVisible(true);
//					
//					card.show(contentPane,"4");
//				}
//				else {
//					createaccount.createaccount_sign.setText("Those passwords didn't match. Try again.");
//				}
//			}
//		});
//		
//		createaccount.bcreateaccount_x.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				card.show(contentPane,"1");
//			}
//		});
		
//		signin.bsignin_creataccount.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				card.show(contentPane,"3");
//			}
//		});
//		
		signin.bsignin_x.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				card.show(contentPane,"1");
			}
		});
		
		signin.bsignin_signin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				successNote b = new successNote();
				
				user.makeQuery(SIGNIN,null,null,null,null,null,null,
						signin.signin_txt1.getText()+"/"+String.valueOf(signin.signin_passwordField.getPassword()),null)
				Query reponse = user.getResponse();
				if(reponse.isSuccess == false) {
					b.changeContent(reponse.getErrorMessage());
				}else {
					b.changeContent("Sign in successfully.");
				}
				b.setVisible(true);
				card.show(contentPane,"4");
			}
		});
		welcome.bwelcome_signin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				card.show(contentPane,"2");
			}
		});
		
		welcome.bwelcome_guest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				card.show(contentPane,"5");
			}
		});
		
		welcome.bwelcome_creataccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				card.show(contentPane,"3");
			}
		});
		
		welcome.bwelcome_x.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				xx = arg0.getX();
				xy = arg0.getY();
			}
		});
		getContentPane().addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x-xx,y-xy);
			}
		});
		
		
	
		
	}
}
