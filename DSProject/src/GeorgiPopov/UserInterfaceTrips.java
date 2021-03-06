/**
 * 
 */
package GeorgiPopov;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.Year;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Other.WelcomeScreen;
import ShenaiKabilova.DriverDAO;
import ShenaiKabilova.DriverDaoImpl;
import ShenaiKabilova.DriverErrorException;
import ShenaiKabilova.VehicleDAO;
import ShenaiKabilova.VehicleDaoImpl;

/**
 * @author shenaikabilova
 *
 */
@SuppressWarnings("serial")
public class UserInterfaceTrips extends JFrame implements Runnable{
	private JPanel panel;
	
	private JLabel labelRegNumber = new JLabel("�������������� N:");
	private JLabel labelFirstName = new JLabel("���:");
	private JLabel labelLastName = new JLabel("�������:");
	private JLabel labelEGN = new JLabel("���:");
	private JLabel labelLicense = new JLabel("���������:");
	private JLabel labelStartTrip = new JLabel("������:");
	private JLabel labelEntTrip = new JLabel("����:");
	private JLabel labelKM = new JLabel("��:");
	private JLabel labelDay = new JLabel("���");
	private JLabel labelMonth = new JLabel("�����");
	private JLabel labelYear = new JLabel("������");
	private JLabel labelHour = new JLabel("���");
	private JLabel labelMinute = new JLabel("������");
	private JLabel labelTripID = new JLabel("ID:");
	
	private JTextField textFieldFirstName = new JTextField();
	private JTextField textFieldLastName = new JTextField();
	private JTextField textFieldEGN = new JTextField();
	private JTextField textFieldLicense = new JTextField();
	private JTextField textFieldKM = new JTextField();
	private JTextField textFieldTripID = new JTextField();
	
	private JComboBox<String> comboBoxRegNumber = new JComboBox<String>();
	private JComboBox<Integer> comboBoxStartDay = new JComboBox<Integer>();
	private JComboBox<Integer> comboBoxStartMonth = new JComboBox<Integer>();
	private JComboBox<Integer> comboBoxStartYear = new JComboBox<Integer>();
	private JComboBox<Integer> comboBoxStartHour = new JComboBox<Integer>();
	private JComboBox<Integer> comboBoxStartMinute = new JComboBox<Integer>();
	private JComboBox<Integer> comboBoxEndDay = new JComboBox<Integer>();
	private JComboBox<Integer> comboBoxEndMonth = new JComboBox<Integer>();
	private JComboBox<Integer> comboBoxEndYear = new JComboBox<Integer>();
	private JComboBox<Integer> comboBoxEndHour = new JComboBox<Integer>();
	private JComboBox<Integer> comboBoxEndMinute = new JComboBox<Integer>();
	
	private JButton buttonAdd = new JButton("������");
	private JButton buttonUpdate = new JButton("�������");
	private JButton buttonDelete = new JButton("������");
	private JButton buttonSearch = new JButton("������");
	private JButton buttonViewTrips = new JButton("������");
	private JButton buttonReset = new JButton("�������");
	private JButton buttonExit = new JButton("����");
	
	private CurrentStateUsername current = new CurrentStateUsername();
	private TripsDAO newTrip = new TripsDaoImpl();
	private DriverDAO driver = new DriverDaoImpl();
	private VehicleDAO vehicle = new VehicleDaoImpl();
	
	public UserInterfaceTrips() throws DriverErrorException {
		setTitle("���� �������");
		setSize(650, 350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		this.panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
		
		this.labelFirstName.setBounds(20, 30, 80, 50);
		panel.add(labelFirstName);
		
		this.labelLastName.setBounds(230, 30, 80, 50);
		panel.add(labelLastName);
		
		this.labelEGN.setBounds(20, 65, 80, 50);
		panel.add(labelEGN);
		
		this.labelLicense.setBounds(230, 65, 80, 50);
		panel.add(labelLicense);
		
		this.labelStartTrip.setBounds(20, 160, 80, 50);
		panel.add(labelStartTrip);
		
		this.labelDay.setBounds(100, 140, 80, 50);
		panel.add(labelDay);
		
		this.labelMonth.setBounds(150, 140, 80, 50);
		panel.add(labelMonth);
		
		this.labelYear.setBounds(210, 140, 80, 50);
		panel.add(labelYear);
		
		this.labelHour.setBounds(290, 140, 80, 50);
		panel.add(labelHour);
		
		this.labelMinute.setBounds(350, 140, 80, 50);
		panel.add(labelMinute);
		
		this.labelEntTrip.setBounds(20, 200, 80, 50);
		panel.add(labelEntTrip);
		
		this.labelRegNumber.setBounds(20, 105, 120, 50);
		panel.add(labelRegNumber);
		
		this.labelKM.setBounds(260, 105, 80, 50);
		panel.add(labelKM);
		
		this.labelTripID.setBounds(380, 105, 80, 50);
		panel.add(labelTripID);
		
		this.textFieldFirstName.setBounds(60, 45, 160, 25);
		textFieldFirstName.setText(driver.search(current.getCurrentUsername()).getDriverFirstName());
		textFieldFirstName.setEditable(false);
		panel.add(textFieldFirstName);
		
		this.textFieldLastName.setBounds(300, 45, 160, 25);
		textFieldLastName.setText(driver.search(current.getCurrentUsername()).getDriverLastName());
		textFieldLastName.setEditable(false);
		panel.add(textFieldLastName);
		
		this.textFieldEGN.setBounds(60, 80, 160, 25);
		textFieldEGN.setText(current.getCurrentUsername());
		textFieldEGN.setEditable(false);
		panel.add(textFieldEGN);
		
		this.textFieldLicense.setBounds(300, 80, 60, 25);
		textFieldLicense.setText(driver.search(current.getCurrentUsername()).getDriverLicense());
		textFieldLicense.setEditable(false);
		panel.add(textFieldLicense);
		
		this.textFieldKM.setBounds(300, 120, 60, 25);
		textFieldKM.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
				    e.consume();
				}
	 
	            if (textFieldKM.getText().length() == 6) {
	            	JOptionPane.showMessageDialog(UserInterfaceTrips.this, "K����������� �� ���� �� ��������� 6 �����!",
	            			"��������� ����� �� ���������", JOptionPane.WARNING_MESSAGE);
	                e.consume();// ignore event  
	            }
			}
				
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_ENTER) {
					textFieldTripID.requestFocus();
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					comboBoxRegNumber.requestFocus();
				}
			}
		});
		panel.add(textFieldKM);
		
		this.textFieldTripID.setBounds(400, 120, 60, 25);
		textFieldTripID.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
				    e.consume();
				}
			}
			
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					textFieldKM.requestFocus();
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					comboBoxRegNumber.requestFocus();
				}
				
				if (textFieldTripID.getText().length() == 6) {
	            	JOptionPane.showMessageDialog(UserInterfaceTrips.this, "ID �� ���� �� ��������� 6 �����!",
	            			"��������� ����� �� ���������", JOptionPane.WARNING_MESSAGE);
	                e.consume();// ignore event  
	            }
			}
		});
		panel.add(textFieldTripID);
		
		this.comboBoxRegNumber.setBounds(140, 115, 100, 30);
		for(String s : vehicle.searchVehicle(textFieldLicense.getText())) {
			comboBoxRegNumber.addItem(s);
		}
		comboBoxRegNumber.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					textFieldKM.requestFocus();
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					textFieldTripID.requestFocus();
				}
			}
		});
		panel.add(comboBoxRegNumber);
		
		this.comboBoxStartDay.setBounds(90, 180, 40, 20);
		for(int i=1; i<=31; i++) {
			comboBoxStartDay.addItem(i);
		}
		panel.add(comboBoxStartDay);
		
		this.comboBoxStartMonth.setBounds(150, 180, 40, 20);
		for(int i=1; i<=12; i++) {
			comboBoxStartMonth.addItem(i);
		}
		panel.add(comboBoxStartMonth);
		
		this.comboBoxStartYear.setBounds(210, 180, 60, 20);
		for(int i=Year.now().getValue(); i<(Year.now().getValue())+20;i++){
			comboBoxStartYear.addItem(i);
		}
		panel.add(comboBoxStartYear);
		
		this.comboBoxStartHour.setBounds(290, 180, 40, 20);
		for(int i=1; i<=24; i++) {
			comboBoxStartHour.addItem(i);
		}
		panel.add(comboBoxStartHour);
		
		this.comboBoxStartMinute.setBounds(350, 180, 40, 20);
		for(int i=0; i<=59; i++) {
			comboBoxStartMinute.addItem(i);
		}
		panel.add(comboBoxStartMinute);
		
		this.comboBoxEndDay.setBounds(90, 210, 40, 20);
		for(int i=1; i<=31; i++) {
			comboBoxEndDay.addItem(i);
		}
		panel.add(comboBoxEndDay);
		
		this.comboBoxEndMonth.setBounds(150, 210, 40, 20);
		for(int i=1; i<=12; i++) {
			comboBoxEndMonth.addItem(i);
		}
		panel.add(comboBoxEndMonth);
		
		this.comboBoxEndYear.setBounds(210, 210, 60, 20);
		for(int i=Year.now().getValue(); i<(Year.now().getValue())+20; i++){
			comboBoxEndYear.addItem(i);
		}
		panel.add(comboBoxEndYear);
		
		this.comboBoxEndHour.setBounds(290, 210, 40, 20);
		for(int i=1; i<=24; i++) {
			comboBoxEndHour.addItem(i);
		}
		panel.add(comboBoxEndHour);
		
		this.comboBoxEndMinute.setBounds(350, 210, 40, 20);
		for(int i=0; i<=59; i++) {
			comboBoxEndMinute.addItem(i);
		}
		panel.add(comboBoxEndMinute);
		
		this.buttonAdd.setBounds(500, 20, 100, 30);
		ActionListener buttonAddListener = new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					Date startDate = new Date((int)comboBoxStartYear.getSelectedItem()-1900, 
											  (int)comboBoxStartMonth.getSelectedItem()-1,
											  (int)comboBoxStartDay.getSelectedItem(), 
											  (int)comboBoxStartHour.getSelectedItem(), 
											  (int)comboBoxStartMinute.getSelectedItem());
					
					Date endDate = new Date((int)comboBoxEndYear.getSelectedItem()-1900, 
											(int)comboBoxEndMonth.getSelectedItem()-1,
									        (int)comboBoxEndDay.getSelectedItem(), 
										    (int)comboBoxEndHour.getSelectedItem(), 
											(int)comboBoxEndMinute.getSelectedItem());
					
					Trips trip = new Trips(Integer.parseInt(textFieldTripID.getText()), 
															textFieldFirstName.getText(), 
															textFieldLastName.getText(), 
															textFieldLicense.getText(), 
															textFieldEGN.getText(), 
															comboBoxRegNumber.getSelectedItem().toString(), 
															startDate, 
															endDate, 
															Long.parseLong(textFieldKM.getText()));
					newTrip.insert(trip);
					JOptionPane.showMessageDialog(UserInterfaceTrips.this, "���������� � ��������!", 
							"��������", JOptionPane.INFORMATION_MESSAGE);
				} catch (TripsException exp) {
					JOptionPane.showMessageDialog(UserInterfaceTrips.this, exp.getMessage(),
							"������ ��� ��������", JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException exp) {
					JOptionPane.showMessageDialog(UserInterfaceTrips.this, "������� �������� ������!",
							"�������� ����������", JOptionPane.WARNING_MESSAGE);
				}
			}
		};
		buttonAdd.addActionListener(buttonAddListener);
		panel.add(buttonAdd);
		
		this.buttonUpdate.setBounds(500, 60, 100, 30);
		ActionListener buttonUpdateListener = new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					Date startDate = new Date((int)comboBoxStartYear.getSelectedItem()-1900, 
							  (int)comboBoxStartMonth.getSelectedItem()-1,
							  (int)comboBoxStartDay.getSelectedItem(), 
							  (int)comboBoxStartHour.getSelectedItem()-1, 
							  (int)comboBoxStartMinute.getSelectedItem()-1);
	
					Date endDate = new Date((int)comboBoxEndYear.getSelectedItem()-1900, 
											(int)comboBoxEndMonth.getSelectedItem()-1,
									        (int)comboBoxEndDay.getSelectedItem(), 
										    (int)comboBoxEndHour.getSelectedItem()-1, 
											(int)comboBoxEndMinute.getSelectedItem()-1);
					
					Trips trip = new Trips(Integer.parseInt(textFieldTripID.getText()), 
															textFieldFirstName.getText(), 
															textFieldLastName.getText(), 
															textFieldLicense.getText(), 
															textFieldEGN.getText(), 
															comboBoxRegNumber.getSelectedItem().toString(), 
															startDate, 
															endDate, 
															Long.parseLong(textFieldKM.getText()));
					
					newTrip.update(trip);
					JOptionPane.showMessageDialog(UserInterfaceTrips.this, "���������� � ���������!",
							"�������", JOptionPane.INFORMATION_MESSAGE);
				} catch (TripsException exp) {
					JOptionPane.showMessageDialog(UserInterfaceTrips.this, exp.getMessage(), 
							"������ ��� �������", JOptionPane.ERROR_MESSAGE );
				} catch (NumberFormatException exp) {
					JOptionPane.showMessageDialog(UserInterfaceTrips.this, "������� �������� ������!",
							"�������� ����������", JOptionPane.WARNING_MESSAGE);
				}
			}
		};
		buttonUpdate.addActionListener(buttonUpdateListener);
		panel.add(buttonUpdate);
		
		this.buttonDelete.setBounds(500, 100, 100, 30);
		ActionListener buttonDeleteListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					newTrip.delete(Integer.parseInt(textFieldTripID.getText()));
//					JOptionPane.showMessageDialog(UserInterfaceTrips.this, "���������� � �������!",
//							"���������", JOptionPane.OK_OPTION);
				} catch(TripsException exp) {
					JOptionPane.showMessageDialog(UserInterfaceTrips.this, exp.getMessage(),
							"������ ��� ���������", JOptionPane.ERROR_MESSAGE);
				}
			}
		};
		buttonDelete.addActionListener(buttonDeleteListener);
		panel.add(buttonDelete);
		
		this.buttonSearch.setBounds(500, 140, 100, 30);
		ActionListener buttonSearchListener = new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					Trips trip = newTrip.search(Integer.parseInt(textFieldTripID.getText()));
				
					textFieldFirstName.setText(trip.getDriverFirstName());
					textFieldLastName.setText(trip.getDriverLastName());
					textFieldLicense.setText(trip.getDriverLicense());
					textFieldEGN.setText(trip.getDriverEgn());
					textFieldKM.setText(Long.toString((trip.getKm())));
					comboBoxRegNumber.setSelectedItem(trip.getVehicleRegNumber());
					
					comboBoxStartDay.setSelectedItem(trip.getStartDate().getDate());
					comboBoxStartMonth.setSelectedItem(trip.getStartDate().getMonth()+1);
					comboBoxStartYear.setSelectedItem(trip.getStartDate().getYear()+1900);
					comboBoxStartHour.setSelectedItem(trip.getStartDate().getHours());
					comboBoxStartMinute.setSelectedItem(trip.getStartDate().getMinutes());
					
					comboBoxEndDay.setSelectedItem(trip.getEndDate().getDate());
					comboBoxEndMonth.setSelectedItem(trip.getEndDate().getMonth()+1);
					comboBoxEndYear.setSelectedItem(trip.getEndDate().getYear()+1900);
					comboBoxEndHour.setSelectedItem(trip.getEndDate().getHours());
					comboBoxEndMinute.setSelectedItem(trip.getEndDate().getMinutes());
				} catch(TripsException exp) {
					JOptionPane.showMessageDialog(UserInterfaceTrips.this, exp.getMessage(),
							"������ ��� �������", JOptionPane.ERROR_MESSAGE);
				}
			}
		};
		buttonSearch.addActionListener(buttonSearchListener);
		panel.add(buttonSearch);
		
		this.buttonViewTrips.setBounds(500, 180, 100, 30);
		ActionListener buttonViewTripsListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String buttons[] = {"������ �� ����", "������ ������"};
				
				int response = JOptionPane.showOptionDialog(UserInterfaceTrips.this, "������� ����� �� ���� ��� �� ������?", "�����", 
						JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, buttons.length);
				
			
				if(response == JOptionPane.OK_OPTION) {
					new CreateTableTripsReport();
				}
				else {
					new CreateTableTrips();
				}
			}
		};
		buttonViewTrips.addActionListener(buttonViewTripsListener);
		panel.add(buttonViewTrips);
		
		this.buttonReset.setBounds(500, 220, 100, 30);
		ActionListener buttonResetListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboBoxRegNumber.setSelectedItem(1);
				textFieldKM.setText("");
				textFieldTripID.setText("");
				comboBoxStartDay.setSelectedItem(1);
				comboBoxStartMonth.setSelectedItem(1);
				comboBoxStartYear.setSelectedItem(1);
				comboBoxStartHour.setSelectedItem(1);
				comboBoxStartMinute.setSelectedItem(1);
				comboBoxEndDay.setSelectedItem(1);
				comboBoxEndMonth.setSelectedItem(1);
				comboBoxEndYear.setSelectedItem(1);
				comboBoxEndHour.setSelectedItem(1);
				comboBoxEndMinute.setSelectedItem(1);
			}
		};
		buttonReset.addActionListener(buttonResetListener);
		panel.add(buttonReset);
		
		this.buttonExit.setBounds(500, 260, 100, 30);
		ActionListener buttonExitListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new WelcomeScreen().setVisible(true);
			}
		};
		buttonExit.addActionListener(buttonExitListener);
		panel.add(buttonExit);
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		setVisible(true);
	}
}