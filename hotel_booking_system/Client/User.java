import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class User
{
	private Queue<Query> queryQueue;
	private Queue<Response> responseQueue;

	public User() {
		queryQueue = new LinkedList<>();
		responseQueue = new LinkedList<>();
		
		try {
			GUIThread userThread = new GUIThread();
			userThread.start();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Fail to open GUI");
		}
	}
	
	public void makeQuery(QueryType type, String hotelID, String checkin, String checkout, String typeOfRoom, String numOfRoom, String bookID) {
		int hotelIDQuery = 0;
		Date checkinQuery = null;
		Date checkoutQuery = null;
		int typeOfRoomQuery = 0;
		int numOfRoomQuery = 0;
		
		if (hotelID != null) {
			hotelIDQuery = Integer.valueOf(hotelID);
		}
		
		if (checkin != null && checkout != null) {
			String[] date1 = checkin.split("/");
			String[] date2 = checkout.split("/");

			try {
				checkinQuery = new Date(Integer.valueOf(date1[0]),Integer.valueOf(date1[1]),Integer.valueOf(date1[2]));
			} catch (NumberFormatException | DateFormatException e) {
				System.out.println(e.getMessage());
			}
			
			try {
				checkoutQuery = new Date(Integer.valueOf(date2[0]),Integer.valueOf(date2[1]),Integer.valueOf(date2[2]));
			} catch (NumberFormatException | DateFormatException e) {
				System.out.println(e.getMessage());
			}
		}
		
		if (typeOfRoom != null) {
			switch (typeOfRoom) {
				case "Single room":
					typeOfRoomQuery = 1;
					break;
				case "Double room":
					typeOfRoomQuery = 2;
					break;
				case "Quad room":
					typeOfRoomQuery = 4;
			}
		}
		
		if (numOfRoom != null) {
			numOfRoomQuery = Integer.valueOf(numOfRoom);
		}
		
		queryQueue.add(new Query(type, hotelIDQuery, checkinQuery, checkoutQuery, typeOfRoomQuery, numOfRoomQuery, bookID, 0));
	}
	
	public Query getQuery() {
		return queryQueue.poll();
	}
	
	public void setResponse(Response response) {
		responseQueue.add(response);
	}
	
	public Response getResponse() {
		Response response = responseQueue.poll();
		System.out.println("Success delivered query. Wait for response...");
		while (response == null) {
			try {
				Thread.sleep(10);
			} catch(Exception e) {
				continue;
			}
			response = responseQueue.poll();
		}
		return response;
	}
	
	private void sortHotelInfoList(List<HotelInfo> hotelInfoList, String sortFactor) {
		switch (sortFactor) {
			default: case "PRICE":
				Collections.sort(hotelInfoList, new Comparator<HotelInfo>() {
					public int compare(HotelInfo hotel1, HotelInfo hotel2) {
						if (hotel1.price != hotel2.price) {
							return hotel1.price - hotel2.price;
						} else if (hotel2.star != hotel1.star) {
							return hotel2.star - hotel1.star;
						} else {
							return hotel1.city.compareTo(hotel2.city);
						}
					}
				});
				break;
			case "STAR":
				Collections.sort(hotelInfoList, new Comparator<HotelInfo>() {
					public int compare(HotelInfo hotel1, HotelInfo hotel2) {
						if (hotel2.star != hotel1.star) {
							return hotel2.star - hotel1.star;
						} else if (hotel1.price != hotel2.price) {
							return hotel1.price - hotel2.price;
						} else {
							return hotel1.city.compareTo(hotel2.city);
						/
					}
				});
				break;
			case "CITY":
				Collections.sort(hotelInfoList, new Comparator<HotelInfo>() {
					public int compare(HotelInfo hotel1, HotelInfo hotel2) {
						if (hotel1.city.compareTo(hotel2.city) != 0) {
							return hotel1.city.compareTo(hotel2.city);
						} else if (hotel1.price != hotel2.price) {
							return hotel1.price - hotel2.price;
						} else {
							return hotel2.star - hotel1.star;
						}
					}
				});
		}
	}
	
	class GUIThread extends Thread {
		public void run() {
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
		}
	}
		
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
		return null;

	}

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
				makeQuery(QueryType.LISTHOTEL,null,searchhotel.sh_datecheckin.getText(),searchhotel.sh_datecheckout.getText(),
						searchhotel.searchhotel_combobox.getSelectedItem().toString(),
						searchhotel.searchhotel_noroom.getText(),null);
				
				Response response = getResponse();
				if(response.getIsSuccess()==false){					
				}
				else{
					List<HotelInfo> hotellist = response.getHotelInfoList();
					if(showsearchhotel.showsh_combobox.getSelectedIndex() == 0) {
						sortHotelInfoList(hotellist, "PRICE");
					}else if (showsearchhotel.showsh_combobox.getSelectedIndex() == 1) {
						sortHotelInfoList(hotellist, "STAR");
					}else if(showsearchhotel.showsh_combobox.getSelectedIndex() == 2) {
						sortHotelInfoList(hotellist, "CITY");
					}
					showsearchhotel.table.setModel(showsearchhotel.makeHotellist(hotellist));
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
				makeQuery(QueryType.MODIFYROOMNUM,null,null,null,null,
						changereservation.cr_txt_noroom.getText(),changeroom.Dnumber.getText());
				Response response = getResponse();
				if(response.getIsSuccess() == false) {
					a.changeContent(response.getErrorMessage()); 
				}else {
					a.changeContent("Change success"); 
				}
				 
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
				makeQuery(QueryType.MODIFYROOMNUM,null,changedate.cd_checkin.getText(),changedate.cd_checkout.getText(),null,null,
						changereservation.cr_txt_noroom.getText());
				Response response = getResponse();
				if(response.getIsSuccess() == false) {
					a.changeContent(response.getErrorMessage()); 
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
				makeQuery(QueryType.CANCEL,null,null,null,null,null,
						changereservation.cr_txt_noroom.getText());
				Response reponse = getResponse();
				if(reponse.getIsSuccess() == false) {
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
				makeQuery(QueryType.CHECKORDER,null,null,null,null,null,searchreservation.sr_txt_noroom.getText());
				Response response =getResponse();
				if(response.getIsSuccess()) {
					Query result = response.getResult();
					searchreservation.table2.setModel(searchreservation.makeHotellist2(result));
				}else {
					successNote a  = new successNote();
					a.changeContent(response.getErrorMessage());
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
				makeQuery(QueryType.BOOK,orderhotel.bh_hotelid.getSelectedItem().toString(),orderhotel.txt.getText(),
						orderhotel.txt1.getText(),orderhotel.orderhotel_nopeople.getSelectedItem().toString(),
						orderhotel.txt_noroom.getText(),null);
				System.out.println(orderhotel.txt.getText()+"/n"+orderhotel.txt1.getText());
				Response reponse = getResponse();
				if(reponse.getIsSuccess()==false){
					a.changeContent(reponse.getErrorMessage());
				}
				else{
					Query result = reponse.getResult();
					a.changeContent("<Book ID>  "+result.getBookID()+
//							"      <User ID>  " + ID +
							"\n"+"      <Hotel ID>  "+ result.getHotelID()+
							"\n"+"      <" + stringtype(result.getTypeOfRoom())+ ">  " + result.getNumOfRoom()+
							"\n      <Check in>  " + result.getCheckin()+
							"\n      <Check out>  " + result.getCheckout()+
							"\n      Last for " + Date.difference(result.getCheckin(),result.getCheckout())+
							"days" + "\n      <Price>  " + result.getPrice());
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
				
				makeQuery(QueryType.LISTHOTEL,null,searchhotel.sh_datecheckin.getText(),searchhotel.sh_datecheckout.getText(),
						searchhotel.searchhotel_combobox.getSelectedItem().toString(),
						searchhotel.searchhotel_noroom.getText(),null);
				Response response = getResponse();
				
				if(response.getIsSuccess()) {
					Query result = response.getResult();
					showsearchhotel.table.setModel(showsearchhotel.makeHotellist(response.getHotelInfoList()));
					card.show(contentPane,"9");
				}
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
				
				makeQuery(QueryType.SIGNIN,null,null,null,null,null,
						signin.signin_txt1.getText()+"/"+String.valueOf(signin.signin_passwordField.getPassword())+"/"
						+"VIP");
				Response response=getResponse();
				if(response.getIsSuccess() == false) {
					b.changeContent(response.getErrorMessage());
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
}
