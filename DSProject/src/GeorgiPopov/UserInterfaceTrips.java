/**
 * 
 */
package GeorgiPopov;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Year;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Other.WelcomeScreen;
import ShenaiKabilova.DriverDAO;
import ShenaiKabilova.DriverDaoImpl;
import ShenaiKabilova.VehicleDAO;
import ShenaiKabilova.VehicleDaoImpl;

/**
 * @author shenaikabilova
 *
 */
@SuppressWarnings("serial")
public class UserInterfaceTrips extends JFrame implements Runnable, ActionListener{
	private JPanel panel;
	
	private JLabel labelRegNumber = new JLabel("Registration N:");
	private JLabel labelFirstName = new JLabel("First name:");
	private JLabel labelLastName = new JLabel("Last name:");
	private JLabel labelEGN = new JLabel("EGN:");
	private JLabel labelLicense = new JLabel("License:");
	private JLabel labelStartTrip = new JLabel("Start trip:");
	private JLabel labelEntTrip = new JLabel("End trip:");
	private JLabel labelKM = new JLabel("KM:");
	private JLabel labelDay = new JLabel("day");
	private JLabel labelMonth = new JLabel("month");
	private JLabel labelYear = new JLabel("year");
	private JLabel labelHour = new JLabel("hour");
	private JLabel labelMinute = new JLabel("minute");
	private JLabel labelTripID = new JLabel("Trip ID:");
	
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
	
	private JButton buttonAdd = new JButton("Add");
	private JButton buttonUpdate = new JButton("Update");
	private JButton buttonDelete = new JButton("Delete");
	private JButton buttonSearch = new JButton("Search");
	private JButton buttonViewTrips = new JButton("View trips");
	private JButton buttonReset = new JButton("Reset");
	private JButton buttonExit = new JButton("Exit");
	
	private CurrentStateUsername current = new CurrentStateUsername();
	private TripsDAO newTrip = new TripsDaoImpl();
	private DriverDAO driver = new DriverDaoImpl();
	private VehicleDAO vehicle = new VehicleDaoImpl();
	
	public UserInterfaceTrips() {
		setTitle("Add trip");
		setSize(800, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
		
		this.labelFirstName.setBounds(20, 30, 80, 50);
		panel.add(labelFirstName);
		
		this.labelLastName.setBounds(260, 30, 80, 50);
		panel.add(labelLastName);
		
		this.labelEGN.setBounds(500, 30, 80, 50);
		panel.add(labelEGN);
		
		this.labelStartTrip.setBounds(20, 120, 80, 50);
		panel.add(labelStartTrip);
		
		this.labelDay.setBounds(85, 100, 80, 50);
		panel.add(labelDay);
		
		this.labelMonth.setBounds(130, 100, 80, 50);
		panel.add(labelMonth);
		
		this.labelYear.setBounds(190, 100, 80, 50);
		panel.add(labelYear);
		
		this.labelHour.setBounds(250, 100, 80, 50);
		panel.add(labelHour);
		
		this.labelMinute.setBounds(300, 100, 80, 50);
		panel.add(labelMinute);
		
		this.labelEntTrip.setBounds(20, 150, 80, 50);
		panel.add(labelEntTrip);
		
		this.labelLicense.setBounds(20, 70, 80, 50);
		panel.add(labelLicense);
		
		this.labelRegNumber.setBounds(170, 70, 100, 50);
		panel.add(labelRegNumber);
		
		this.labelKM.setBounds(380, 70, 80, 50);
		panel.add(labelKM);
		
		this.labelTripID.setBounds(480, 70, 80, 50);
		panel.add(labelTripID);
		
		this.textFieldFirstName.setBounds(90, 45, 160, 25);
		textFieldFirstName.setText(driver.search(current.getCurrentUsername()).getDriverFirstName());
		textFieldFirstName.setEditable(false);
		panel.add(textFieldFirstName);
		
		this.textFieldLastName.setBounds(330, 45, 160, 25);
		textFieldLastName.setText(driver.search(current.getCurrentUsername()).getDriverLastName());
		textFieldLastName.setEditable(false);
		panel.add(textFieldLastName);
		
		this.textFieldEGN.setBounds(540, 45, 160, 25);
		textFieldEGN.setText(current.getCurrentUsername());
		textFieldEGN.setEditable(false);
		panel.add(textFieldEGN);
		
		this.textFieldLicense.setBounds(90, 80, 60, 25);
		textFieldLicense.setText(driver.search(current.getCurrentUsername()).getDriverLicense());
		textFieldLicense.setEditable(false);
		panel.add(textFieldLicense);
		
		this.textFieldKM.setBounds(410, 84, 60, 25);
		panel.add(textFieldKM);
		
		this.textFieldTripID.setBounds(525, 84, 60, 25);
		panel.add(textFieldTripID);
		
		this.comboBoxRegNumber.setBounds(260, 80, 100, 30);
		for(String s : vehicle.searchVehicle(textFieldLicense.getText())) {
			comboBoxRegNumber.addItem(s);
		}
		panel.add(comboBoxRegNumber);
		
		this.comboBoxStartDay.setBounds(80, 135, 40, 20);
		for(int i=1; i<=31; i++) {
			comboBoxStartDay.addItem(i);
		}
		panel.add(comboBoxStartDay);
		
		this.comboBoxStartMonth.setBounds(130, 135, 40, 20);
		for(int i=1; i<=12; i++) {
			comboBoxStartMonth.addItem(i);
		}
		panel.add(comboBoxStartMonth);
		
		this.comboBoxStartYear.setBounds(180, 135, 60, 20);
		for(int i=Year.now().getValue(); i<(Year.now().getValue())+20;i++){
			comboBoxStartYear.addItem(i);
		}
		panel.add(comboBoxStartYear);
		
		this.comboBoxStartHour.setBounds(250, 135, 40, 20);
		for(int i=1; i<=24; i++) {
			comboBoxStartHour.addItem(i);
		}
		panel.add(comboBoxStartHour);
		
		this.comboBoxStartMinute.setBounds(300, 135, 40, 20);
		for(int i=0; i<=59; i++) {
			comboBoxStartMinute.addItem(i);
		}
		panel.add(comboBoxStartMinute);
		
		this.comboBoxEndDay.setBounds(80, 165, 40, 20);
		for(int i=1; i<=31; i++) {
			comboBoxEndDay.addItem(i);
		}
		panel.add(comboBoxEndDay);
		
		this.comboBoxEndMonth.setBounds(130, 165, 40, 20);
		for(int i=1; i<=12; i++) {
			comboBoxEndMonth.addItem(i);
		}
		panel.add(comboBoxEndMonth);
		
		this.comboBoxEndYear.setBounds(180, 165, 60, 20);
		for(int i=Year.now().getValue(); i<(Year.now().getValue())+20; i++){
			comboBoxEndYear.addItem(i);
		}
		panel.add(comboBoxEndYear);
		
		this.comboBoxEndHour.setBounds(250, 165, 40, 20);
		for(int i=1; i<=24; i++) {
			comboBoxEndHour.addItem(i);
		}
		panel.add(comboBoxEndHour);
		
		this.comboBoxEndMinute.setBounds(300, 165, 40, 20);
		for(int i=0; i<=59; i++) {
			comboBoxEndMinute.addItem(i);
		}
		panel.add(comboBoxEndMinute);
		
		this.buttonAdd.setBounds(20, 200, 80, 30);
		panel.add(buttonAdd);
		
		this.buttonUpdate.setBounds(120, 200, 80, 30);
		panel.add(buttonUpdate);
		
		this.buttonDelete.setBounds(220, 200, 80, 30);
		panel.add(buttonDelete);
		
		this.buttonSearch.setBounds(320, 200, 80, 30);
		panel.add(buttonSearch);
		
		this.buttonViewTrips.setBounds(420, 200, 100, 30);
		panel.add(buttonViewTrips);
		
		this.buttonReset.setBounds(540, 200, 80, 30);
		panel.add(buttonReset);
		
		this.buttonExit.setBounds(640, 200, 80, 30);
		panel.add(buttonExit);
		
		buttonAdd.addActionListener(this);
		buttonUpdate.addActionListener(this);
		buttonDelete.addActionListener(this);
		buttonSearch.addActionListener(this);
		buttonViewTrips.addActionListener(this);
		buttonReset.addActionListener(this);
		buttonExit.addActionListener(this);
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		buttonAdd.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
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
			}
		});
		
		buttonUpdate.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
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
			}
		});
		
		buttonDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newTrip.delete(Integer.parseInt(textFieldTripID.getText()));
			}
		});
		
		buttonSearch.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				Trips trip = newTrip.search(Integer.parseInt(textFieldTripID.getText()));
				
				textFieldFirstName.setText(trip.getDriverFirstName());
				textFieldLastName.setText(trip.getDriverLastName());
				textFieldLicense.setText(trip.getDriverLicense());
				textFieldEGN.setText(trip.getDriverEgn());
				textFieldKM.setText(Long.toString((trip.getKm())));
				comboBoxRegNumber.setSelectedItem(trip.getVehicleRegNumber());
				
				comboBoxStartDay.setSelectedItem(trip.getStartDate().getDay());
				comboBoxStartMonth.setSelectedItem(trip.getStartDate().getMonth()+1);
				comboBoxStartYear.setSelectedItem(trip.getStartDate().getYear()+1900);
				comboBoxStartHour.setSelectedItem(trip.getStartDate().getHours());
				comboBoxStartMinute.setSelectedItem(trip.getStartDate().getMinutes());
				
				comboBoxEndDay.setSelectedItem(trip.getEndDate().getDay());
				comboBoxEndMonth.setSelectedItem(trip.getEndDate().getMonth()+1);
				comboBoxEndYear.setSelectedItem(trip.getEndDate().getYear()+1900);
				comboBoxEndHour.setSelectedItem(trip.getEndDate().getHours());
				comboBoxEndMinute.setSelectedItem(trip.getEndDate().getMinutes());
			}
		});
		
		buttonViewTrips.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CreateTableTrips().setVisible(true);
			}
		});
		
		buttonReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboBoxRegNumber.setSelectedItem(1);
				textFieldKM.setText("");
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
		});
		
		buttonExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new WelcomeScreen().setVisible(true);
			}
		});
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		setVisible(true);
	}
}