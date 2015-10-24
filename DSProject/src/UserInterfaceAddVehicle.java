import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
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
public class UserInterfaceAddVehicle extends JFrame implements Runnable, ActionListener{
	private JPanel panel;
	
	private JLabel labelTypeVehicle = new JLabel("Type vehicle: ");
	private JLabel labelRegNumber = new JLabel("Registration Number: ");
	private JLabel labelYearVehicle = new JLabel("Year's vehicle: ");
	private JLabel labelColor = new JLabel("Color: ");
	private JLabel labelNumberPlaces = new JLabel("Number places: ");
	private JLabel labelKM = new JLabel("KM: ");
	private JLabel labelRepairCount = new JLabel("Repair count: ");
	private JLabel labelLastRepair = new JLabel("Last repair: ");
	
	private JTextField textFieldTypeVehicle = new JTextField("");
	private JTextField textFieldRegNumber = new JTextField("");
	private JTextField textFieldYearVehicle = new JTextField("");
	private JTextField textFieldColor = new JTextField("");
	private JTextField textFieldNumberPlaces = new JTextField("");
	private JTextField textFieldKM = new JTextField("");
	private JTextField textFieldRepairCount = new JTextField("");
	private JTextField textFieldLastRepair = new JTextField("YYYY-MM-DD");
	
	private JButton buttonCreate = new JButton("Create");
	private JButton buttonDelete = new JButton("Delete");
	private JButton buttonUpdate = new JButton("Update");
	private JButton buttonSearch = new JButton("Search");
	private JButton buttonViewTable = new JButton("View table");
	private JButton buttonExit = new JButton("Exit");
 	
	private VehicleDAO vehicle = new VehicleDB();
	
	public UserInterfaceAddVehicle() {
		setTitle("Add vehicle");
		setSize(450, 450);
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
		
		this.labelLastRepair.setBounds(20, 230, 150, 30);
		panel.add(labelLastRepair);
		
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
		
		this.textFieldLastRepair.setBounds(150, 230, 150, 25);
		panel.add(textFieldLastRepair);
		
		this.buttonCreate.setBounds(30, 290, 100, 30);
		panel.add(buttonCreate);
		
		this.buttonUpdate.setBounds(150, 290, 100, 30);
		panel.add(buttonUpdate);
		
		this.buttonDelete.setBounds(270, 290, 100, 30);
		panel.add(buttonDelete);
		
		this.buttonSearch.setBounds(30, 330, 100, 30);
		panel.add(buttonSearch);
		
		this.buttonViewTable.setBounds(150, 330, 100, 30);
		panel.add(buttonViewTable);
		
		this.buttonExit.setBounds(270, 330, 100, 30);
		panel.add(buttonExit);
		
		buttonCreate.addActionListener(this);
		buttonUpdate.addActionListener(this);
		buttonDelete.addActionListener(this);
		buttonSearch.addActionListener(this);
		buttonViewTable.addActionListener(this);
		buttonExit.addActionListener(this);
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		buttonCreate.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
//				Vehicles vehicle = new Vehicles(textFieldTypeVehicle.getText(), 
//						textFieldRegNumber.getText(), Integer.parseInt(textFieldYearVehicle.getText()), 
//						textFieldColor.getText(), Integer.parseInt(textFieldNumberPlaces.getText()), 
//						Long.parseLong(textFieldKM.getText()), Integer.parseInt(textFieldRepairCount.getText()), 
//						Date.parse(textFieldLastRepair.getText()));
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