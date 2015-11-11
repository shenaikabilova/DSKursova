package ShenaiKabilova;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 */

/**
 * @author shenaikabilova
 *
 */
@SuppressWarnings("serial")
public class UserInterfaceAddVehicle extends JFrame implements Runnable, ActionListener{
	private JPanel panel;
	
	private JLabel labelTypeVehicle = new JLabel("Type vehicle: ");
	private JLabel labelRegNumber = new JLabel("Registration Number: ");
	private JLabel labelYearVehicle = new JLabel("Year's vehicle: ");
	private JLabel labelColor = new JLabel("Color: ");
	private JLabel labelNumberPlaces = new JLabel("Number places: ");
	private JLabel labelKM = new JLabel("KM: ");
	private JLabel labelRepairCount = new JLabel("Repair count: ");
	private JLabel labelDriverLicense = new JLabel("License: ");
	private JLabel labelDay = new JLabel("Day:");
	private JLabel labelMonth = new JLabel("Month:");
	private JLabel labelYear = new JLabel("Year:");
	private JLabel labelLastRepair = new JLabel("Last repair:");
	
	private JTextField textFieldTypeVehicle = new JTextField("");
	private JTextField textFieldRegNumber = new JTextField("");
	private JTextField textFieldYearVehicle = new JTextField("");
	private JTextField textFieldColor = new JTextField("");
	private JTextField textFieldNumberPlaces = new JTextField("");
	private JTextField textFieldKM = new JTextField("");
	private JTextField textFieldRepairCount = new JTextField("");
	
	private String[] license = {"A", "B", "C", "D", "BE", "CE", "DE", "T", "A"};
	private Integer[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
							  22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
	private Integer[] months = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
	private Integer[] years = {1993, 1994, 1995, 1996, 1997, 1998, 2000,
							   2001, 2002, 2003, 2004, 2005, 2006, 2007,
							   2008, 2009, 2010, 2011, 2012, 2013, 2014,
							   2015};
	
	private JComboBox<String> comboboxLicense = new JComboBox<String>(license);
	private JComboBox<Integer> comboBoxDays = new JComboBox<Integer>(days);
	private JComboBox<Integer> comboBoxMonths = new JComboBox<Integer>(months);
	private JComboBox<Integer> comboBoxYears = new JComboBox<Integer>(years);
	
	private JButton buttonCreate = new JButton("Create");
	private JButton buttonDelete = new JButton("Delete");
	private JButton buttonUpdate = new JButton("Update");
	private JButton buttonSearch = new JButton("Search");
	private JButton buttonReset = new JButton("Reset");
	private JButton buttonViewTable = new JButton("View table");
	private JButton buttonExit = new JButton("Exit");
 	
	private VehicleDAO vehicle = new VehicleDaoImpl();
	
	public UserInterfaceAddVehicle() {
		setTitle("Add vehicle");
		setSize(600, 450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
		
		this.labelTypeVehicle.setBounds(20, 20, 150, 30);
		panel.add(labelTypeVehicle);
		
		this.labelRegNumber.setBounds(20, 50, 150, 30);
		panel.add(labelRegNumber);
		
		this.labelYearVehicle.setBounds(20, 80, 150, 30);
		panel.add(labelYearVehicle);
		
		this.labelColor.setBounds(20, 110, 150, 30);
		panel.add(labelColor);
		
		this.labelNumberPlaces.setBounds(20, 140, 150, 30);
		panel.add(labelNumberPlaces);
		
		this.labelKM.setBounds(20, 170, 150, 30);
		panel.add(labelKM);
		
		this.labelRepairCount.setBounds(20, 200, 150, 30);
		panel.add(labelRepairCount);
		
		this.labelDriverLicense.setBounds(20, 230, 150, 30);
		panel.add(labelDriverLicense);
		
		this.labelLastRepair.setBounds(20, 260, 150, 30);
		panel.add(labelLastRepair);
		
		this.labelDay.setBounds(150, 260, 150, 30);
		panel.add(labelDay);
		
		this.labelMonth.setBounds(210, 260, 150, 30);
		panel.add(labelMonth);
		
		this.labelYear.setBounds(270, 260, 150, 30);
		panel.add(labelYear);
		
		this.textFieldTypeVehicle.setBounds(150, 20, 150, 25);
		panel.add(textFieldTypeVehicle);
		
		this.textFieldRegNumber.setBounds(150, 50, 150, 25);
		panel.add(textFieldRegNumber);
		
		this.textFieldYearVehicle.setBounds(150, 80, 150, 25);
		panel.add(textFieldYearVehicle);
		
		this.textFieldColor.setBounds(150, 110, 150, 25);
		panel.add(textFieldColor);
		
		this.textFieldNumberPlaces.setBounds(150, 140, 150, 25);
		panel.add(textFieldNumberPlaces);
		
		this.textFieldKM.setBounds(150, 170, 150, 25);
		panel.add(textFieldKM);
		
		this.textFieldRepairCount.setBounds(150, 200, 150, 25);
		panel.add(textFieldRepairCount);
		
		this.comboboxLicense.setBounds(150, 230, 150, 25);
		panel.add(comboboxLicense);
		
		this.comboBoxDays.setBounds(150, 290, 50, 20);
		panel.add(comboBoxDays);
		
		this.comboBoxMonths.setBounds(210, 290, 50, 20);
		panel.add(comboBoxMonths);
		
		this.comboBoxYears.setBounds(270, 290, 60, 20);
		panel.add(comboBoxYears);
		
		this.buttonCreate.setBounds(400, 20, 100, 30);
		panel.add(buttonCreate);
		
		this.buttonUpdate.setBounds(400, 60, 100, 30);
		panel.add(buttonUpdate);
		
		this.buttonDelete.setBounds(400, 100, 100, 30);
		panel.add(buttonDelete);
		
		this.buttonSearch.setBounds(400, 140, 100, 30);
		panel.add(buttonSearch);
		
		this.buttonReset.setBounds(400, 180, 100, 30);
		panel.add(buttonReset);
		
		this.buttonViewTable.setBounds(400, 220, 100, 30);
		panel.add(buttonViewTable);
		
		this.buttonExit.setBounds(400, 260, 100, 30);
		panel.add(buttonExit);
		
		buttonCreate.addActionListener(this);
		buttonUpdate.addActionListener(this);
		buttonDelete.addActionListener(this);
		buttonSearch.addActionListener(this);
		buttonViewTable.addActionListener(this);
		buttonExit.addActionListener(this);
		buttonReset.addActionListener(this);
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		buttonCreate.addActionListener(new ActionListener() {	
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				Date date = new Date((int)comboBoxYears.getSelectedItem()-1900, 
								     (int)comboBoxMonths.getSelectedItem()-1, 
								     (int)comboBoxDays.getSelectedItem());
				
				Vehicles addVehicle = new Vehicles(textFieldTypeVehicle.getText(),
												   textFieldRegNumber.getText(),
												   Integer.parseInt(textFieldYearVehicle.getText()),
												   textFieldColor.getText(),
												   Integer.parseInt(textFieldNumberPlaces.getText()),
												   Integer.parseInt(textFieldKM.getText()),
												   Integer.parseInt(textFieldRepairCount.getText()),
												   date,
												   (String) comboboxLicense.getSelectedItem());
				
				vehicle.insert(addVehicle);
			}
		});
		
		buttonUpdate.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				Date date = new Date((int)comboBoxYears.getSelectedItem()-1900, 
									 (int)comboBoxMonths.getSelectedItem()-1, 
									 (int)comboBoxDays.getSelectedItem());
		
				Vehicles updateVehicle = new Vehicles(textFieldTypeVehicle.getText(),
													  textFieldRegNumber.getText(),
													  Integer.parseInt(textFieldYearVehicle.getText()),
													  textFieldColor.getText(),
													  Integer.parseInt(textFieldNumberPlaces.getText()),
													  Integer.parseInt(textFieldKM.getText()),
													  Integer.parseInt(textFieldRepairCount.getText()),
													  date,
													 (String) comboboxLicense.getSelectedItem());

				vehicle.update(updateVehicle);
			}
		});
		
		buttonDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vehicle.delete(textFieldRegNumber.getText());
			}
		});
		
		buttonSearch.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				Vehicles v = vehicle.search(textFieldRegNumber.getText());
			
				textFieldTypeVehicle.setText(v.getTypeVehicle());
				textFieldYearVehicle.setText(Integer.toString(v.getYearVehicle()));
				textFieldColor.setText(v.getColor());
				textFieldNumberPlaces.setText(Integer.toString(v.getNumerOfPlaces()));
				textFieldKM.setText(Long.toString(v.getKm()));
				textFieldRepairCount.setText(Integer.toString(v.getRepairCount()));
				comboBoxDays.setSelectedItem(v.getLastRerair().getDate());
				comboBoxMonths.setSelectedItem(v.getLastRerair().getMonth()+1);
				comboBoxYears.setSelectedItem(v.getLastRerair().getYear()+1900);
				comboboxLicense.setSelectedItem(v.getDriverLicense());
			}
		});
		
		buttonViewTable.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new CreateTableVehicles().setVisible(true);
			}
		});
		
		buttonReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textFieldTypeVehicle.setText("");
				textFieldRegNumber.setText("");
				textFieldYearVehicle.setText("");
				textFieldColor.setText("");
				textFieldNumberPlaces.setText("");
				textFieldKM.setText("");
				textFieldRepairCount.setText("");
				comboboxLicense.setSelectedItem(1);
				comboBoxDays.setSelectedItem(1);
				comboBoxMonths.setSelectedItem(1);
				comboBoxYears.setSelectedItem(1);
			}
		});
		buttonExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new UserInterface().setVisible(true);
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