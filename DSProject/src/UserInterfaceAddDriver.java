import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public class UserInterfaceAddDriver extends JFrame implements Runnable, ActionListener{
	private JPanel panel;
	
	private JLabel labelFirstName = new JLabel("First name: ");
	private JLabel labelLastName = new JLabel("Last name: ");
	private JLabel labelLicense = new JLabel("License: ");
	private JLabel labelDriverID = new JLabel("Driver ID: ");
	
	private JTextField textFieldFirstName = new JTextField("");
	private JTextField textFieldLastName = new JTextField("");
	private JTextField textFieldDriverID = new JTextField("");
	
	private String[] license = {"A", "B", "C", "D", "BE", "CE", "DE", "T", "A"};
	private JComboBox<String> comboBoxLicense = new JComboBox<String>(license);
	
	private JButton buttonInsert = new JButton("Insert");
	private JButton buttonDelete = new JButton("Delete");
	private JButton buttonUpdate = new JButton("Update");
	private JButton buttonSearch = new JButton("Search");
	private JButton buttonReset = new JButton("Reset");
	private JButton buttonViewTable = new JButton("View table");
	private JButton buttonExit = new JButton("Exit");
	
	private DriverDAO driver = new DriverDaoImpl();
	
	public UserInterfaceAddDriver () {
		setTitle("Add driver");
		setSize(400, 350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
		
		this.labelFirstName.setBounds(20, 20, 100, 30);
		panel.add(labelFirstName);
		
		this.labelLastName.setBounds(20, 50, 100, 30);
		panel.add(labelLastName);
		
		this.labelLicense.setBounds(20, 80, 100, 30);
		panel.add(labelLicense);
		
		this.labelDriverID.setBounds(20, 110, 100, 30);
		panel.add(labelDriverID);
		
		this.textFieldFirstName.setBounds(100, 20, 150, 25);
		panel.add(textFieldFirstName);
		
		this.textFieldLastName.setBounds(100, 50, 150, 25);
		panel.add(textFieldLastName);
		
		this.comboBoxLicense.setBounds(100, 80, 150, 25);
		panel.add(comboBoxLicense);
		
		this.textFieldDriverID.setBounds(100, 110, 150, 25);
		panel.add(textFieldDriverID);
		
		this.buttonInsert.setBounds(20, 150, 100, 30);
		panel.add(buttonInsert);
		
		this.buttonUpdate.setBounds(130, 150, 100, 30);
		panel.add(buttonUpdate);
		
		this.buttonDelete.setBounds(240, 150, 100, 30);
		panel.add(buttonDelete);
		
		this.buttonSearch.setBounds(20, 190, 100, 30);
		panel.add(buttonSearch);
		
		this.buttonReset.setBounds(130, 190, 100, 30);
		panel.add(buttonReset);
		
		this.buttonViewTable.setBounds(240, 190, 100, 30);
		panel.add(buttonViewTable);
		
		this.buttonExit.setBounds(130, 230, 100, 30);
		panel.add(buttonExit);
		
		buttonInsert.addActionListener(this);
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
		buttonInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Drivers addDriver = new Drivers(textFieldFirstName.getText(), textFieldLastName.getText(),
										(String) comboBoxLicense.getSelectedItem(), Integer.parseInt(textFieldDriverID.getText()));
				driver.insert(addDriver);
			}
		});
		
		buttonUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Drivers updateDriver = new Drivers(textFieldFirstName.getText(), textFieldLastName.getText(),
												   (String) comboBoxLicense.getSelectedItem(), Integer.parseInt(textFieldDriverID.getText()));
				driver.update(updateDriver);
			}
		});
		
		buttonDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				driver.delete(Integer.parseInt(textFieldDriverID.getText()));
			}
		});
		
		buttonViewTable.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new CreateTableDrivers().setVisible(true);
			}
		});
		
		buttonSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Drivers d = driver.search(Integer.parseInt(textFieldDriverID.getText()));
				
				textFieldFirstName.setText(d.getDriverFirstName());
				textFieldLastName.setText(d.getDriverLastName());
				comboBoxLicense.setSelectedItem(d.getDriverLicense());
			}
		});
		
		buttonReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textFieldFirstName.setText("");
				textFieldLastName.setText("");
				comboBoxLicense.setSelectedItem(1);
				textFieldDriverID.setText("");
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