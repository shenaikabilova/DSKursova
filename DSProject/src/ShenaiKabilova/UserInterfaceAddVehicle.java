package ShenaiKabilova;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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

import Other.Validate;

/**
 * 
 */

/**
 * @author shenaikabilova
 *
 */
@SuppressWarnings("serial")
public class UserInterfaceAddVehicle extends JFrame implements Runnable{	
	private JPanel panel;
	
	private JLabel labelTypeVehicle = new JLabel("Вид: ");
	private JLabel labelRegNumber = new JLabel("Регистрационен номер: ");
	private JLabel labelYearVehicle = new JLabel("Година: ");
	private JLabel labelNumberPlaces = new JLabel("Брой места: ");
	private JLabel labelKM = new JLabel("км: ");
	private JLabel labelRepairCount = new JLabel("Брой ремонти: ");
	private JLabel labelDriverLicense = new JLabel("Категория: ");
	private JLabel labelDay = new JLabel("Ден:");
	private JLabel labelMonth = new JLabel("Месец:");
	private JLabel labelYear = new JLabel("Година:");
	private JLabel labelLastRepair = new JLabel("Последен ремонт:");
	
	private JTextField textFieldRegNumber = new JTextField("");
	private JTextField textFieldYearVehicle = new JTextField("");
	private JTextField textFieldNumberPlaces = new JTextField("");
	private JTextField textFieldKM = new JTextField("");
	private JTextField textFieldRepairCount = new JTextField("");
	
	private String[] license = {"A", "B", "C", "D", "BE", "CE", "DE", "T", "M"};
	private String[] vehicleTypes = {"мотор", "автомобил", "камион", "автобус", "автомобил с ремарке", "камион с ремарке",
			"автобус с ремарке", "тир", "мотопед"};
	private String[] numberPlaces = {"1", "5", "3", "52", "5", "3", "52", "3", "1"};
	
	private JComboBox<String> comboBoxTypeVehicle = new JComboBox<String>(vehicleTypes);
	private JTextField textFieldLicense = new JTextField();
	private JComboBox<Integer> comboBoxDays = new JComboBox<Integer>();
	private JComboBox<Integer> comboBoxMonths = new JComboBox<Integer>();
	private JComboBox<Integer> comboBoxYears = new JComboBox<Integer>();
	
	private JButton buttonCreate = new JButton("Добави");
	private JButton buttonDelete = new JButton("Изтрий");
	private JButton buttonUpdate = new JButton("Промени");
	private JButton buttonSearch = new JButton("Намери");
	private JButton buttonReset = new JButton("Изчисти");
	private JButton buttonViewTable = new JButton("Изведи");
	private JButton buttonExit = new JButton("Край");
 	
	private VehicleDAO vehicle = new VehicleDaoImpl();
	
	public UserInterfaceAddVehicle() {
		setTitle("Добавете превозно средство");
		setSize(600, 450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		this.panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);

		this.labelTypeVehicle.setBounds(20, 20, 150, 30);
		panel.add(labelTypeVehicle);
		
		this.labelRegNumber.setBounds(20, 50, 150, 30);
		panel.add(labelRegNumber);
		
		this.labelYearVehicle.setBounds(20, 80, 150, 30);
		panel.add(labelYearVehicle);
		
		this.labelNumberPlaces.setBounds(20, 110, 150, 30);
		panel.add(labelNumberPlaces);
		
		this.labelKM.setBounds(20, 140, 150, 30);
		panel.add(labelKM);
		
		this.labelRepairCount.setBounds(20, 170, 150, 30);
		panel.add(labelRepairCount);
		
		this.labelDriverLicense.setBounds(20, 200, 150, 30);
		panel.add(labelDriverLicense);
		
		this.labelLastRepair.setBounds(20, 230, 150, 30);
		panel.add(labelLastRepair);
		
		this.labelDay.setBounds(150, 230, 150, 30);
		panel.add(labelDay);
		
		this.labelMonth.setBounds(210, 230, 150, 30);
		panel.add(labelMonth);
		
		this.labelYear.setBounds(270, 230, 150, 30);
		panel.add(labelYear);
		
		this.comboBoxTypeVehicle.setBounds(170, 20, 150, 25);
		comboBoxTypeVehicle.setSelectedIndex(1);
		comboBoxTypeVehicle.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				int a = comboBoxTypeVehicle.getSelectedIndex();
				for(int i=0; i<license.length; i++) {
					if(i==a) {
						textFieldNumberPlaces.setText(numberPlaces[i]);
						textFieldLicense.setText(license[i]);
					}
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
			}
		});
		comboBoxTypeVehicle.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER) {
					textFieldRegNumber.requestFocus();
				}
			}
		});
		panel.add(comboBoxTypeVehicle);
		
		this.textFieldRegNumber.setBounds(170, 50, 150, 25);
		textFieldRegNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (textFieldRegNumber.getText().length() == 8) {  
					textFieldRegNumber.requestFocus();
                	JOptionPane.showMessageDialog(UserInterfaceAddVehicle.this, "Регистрационният номер трябва да е максимално 8 символа!", 
                			"Надвишен брой символи", JOptionPane.WARNING_MESSAGE);
                        e.consume();// ignore event  
                }
				
				if(Character.isLowerCase(e.getKeyChar())) {
					e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
				}
			}
			
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER) {
					textFieldYearVehicle.requestFocus();
				}
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					comboBoxTypeVehicle.requestFocus();
				}
			}
		});
		textFieldRegNumber.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				if(new Validate().isValidRegNumberVehicle(textFieldRegNumber.getText())!=true) {
					textFieldRegNumber.requestFocus();
					JOptionPane.showMessageDialog(UserInterfaceAddVehicle.this, "Въведеният регистрационен номер не може да съществува!",
							"Грешен регистрационен номер", JOptionPane.WARNING_MESSAGE);
				}
			}
		});	
		panel.add(textFieldRegNumber);
		
		this.textFieldYearVehicle.setBounds(170, 80, 150, 25);
		textFieldYearVehicle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
			    if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
			        getToolkit().beep();
			        e.consume();
			    }
 
                if (textFieldYearVehicle.getText().length() > 4) {  
                	textFieldYearVehicle.requestFocus();
//                	JOptionPane.showMessageDialog(UserInterfaceAddVehicle.this, "Годината трябва да е с 4 цифри!",
//                			"Невалидна година", JOptionPane.WARNING_MESSAGE);
                      e.consume();// ignore event  
                }
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					textFieldKM.requestFocus();
				}
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					textFieldKM.requestFocus();
				}
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					textFieldRegNumber.requestFocus();
				}
			}
		});
		textFieldYearVehicle.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (Integer.parseInt(textFieldYearVehicle.getText()) < Year.now().getValue() - 20) {
					textFieldYearVehicle.requestFocus();
					JOptionPane.showMessageDialog(UserInterfaceAddVehicle.this, "Годината на производство не може да е по-малка от: " + (Year.now().getValue() - 20),
							"Невалидна година на производство", JOptionPane.WARNING_MESSAGE);
				}
				if(Integer.parseInt(textFieldYearVehicle.getText()) > Year.now().getValue()) {
					textFieldYearVehicle.requestFocus();
                	JOptionPane.showMessageDialog(UserInterfaceAddVehicle.this, "Годината на производство не може да надвишава: " + Year.now().getValue(),
                			"Невалидна година на производсвто", JOptionPane.WARNING_MESSAGE);
                }
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panel.add(textFieldYearVehicle);
		
		this.textFieldNumberPlaces.setBounds(170, 110, 40, 25);
		textFieldNumberPlaces.setEnabled(false);
		panel.add(textFieldNumberPlaces);
		
		this.textFieldKM.setBounds(170, 140, 150, 25);
		textFieldKM.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
			    if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
			        getToolkit().beep();
			        e.consume();
			    }
 
                if (textFieldKM.getText().length() > 6) {  
                	textFieldKM.requestFocus();
//                	JOptionPane.showMessageDialog(UserInterfaceAddVehicle.this, "Kилометражът не може да надвишава 6 цифри!",
//                			"Невалидно въведен километраж", JOptionPane.WARNING_MESSAGE);
                        e.consume();// ignore event  
                }
			}
			
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER) {
					textFieldRepairCount.requestFocus();
				}
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					textFieldYearVehicle.requestFocus();
				}
			}
		});
		panel.add(textFieldKM);
		
		this.textFieldRepairCount.setBounds(170, 170, 150, 25);
		textFieldRepairCount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
			    if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
			        getToolkit().beep();
			        e.consume();
			    }
			    
			    if(textFieldRepairCount.getText().length() == 3) {
			    	textFieldRepairCount.requestFocus();
			    	JOptionPane.showMessageDialog(UserInterfaceAddVehicle.this, "Броят ремонти не може да надвишава 999!",
			    			"Невалиден брой ремонти", JOptionPane.WARNING_MESSAGE);
			    	e.consume();
			    }
			}
			
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					textFieldKM.requestFocus();
				}
			}
		});
		panel.add(textFieldRepairCount);
		
		this.textFieldLicense.setBounds(170, 200, 40, 25);
		textFieldLicense.setEnabled(false);
		panel.add(textFieldLicense);
		
		this.comboBoxDays.setBounds(150, 260, 50, 20);
		for(int i=1; i<=31;i++) {
			comboBoxDays.addItem(i);
		}
		panel.add(comboBoxDays);
		
		this.comboBoxMonths.setBounds(210, 260, 50, 20);
		for(int i=1; i<=12; i++) {
			comboBoxMonths.addItem(i);
		}
		panel.add(comboBoxMonths);
		
		this.comboBoxYears.setBounds(270, 260, 60, 20);
		for(int i=Year.now().getValue()-20; i<=(Year.now().getValue()); i++){
			comboBoxYears.addItem(i);
		}
		panel.add(comboBoxYears);
		
		this.buttonCreate.setBounds(400, 20, 100, 30);
		ActionListener buttonCreateListener = new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					Date date = new Date((int)comboBoxYears.getSelectedItem()-1900, 
										 (int)comboBoxMonths.getSelectedItem()-1, 
										 (int)comboBoxDays.getSelectedItem());
					
				
					Vehicles addVehicle = new Vehicles(comboBoxTypeVehicle.getSelectedItem().toString(),
													   textFieldRegNumber.getText(),
													   Integer.parseInt(textFieldYearVehicle.getText()),
													   Integer.parseInt(textFieldNumberPlaces.getText()),
													   Integer.parseInt(textFieldKM.getText()),
													   Integer.parseInt(textFieldRepairCount.getText()),
													   date,
													   textFieldLicense.getText());
				
					if(new Validate().isValidRegNumberVehicle(textFieldRegNumber.getText()) == false ){
						textFieldRegNumber.requestFocus();
						JOptionPane.showMessageDialog(UserInterfaceAddVehicle.this, "Въведеният регистрационен номер е невалидно",
								"Невалиден регистрационен №!", JOptionPane.ERROR_MESSAGE);
					} else {
						vehicle.insert(addVehicle);
						JOptionPane.showMessageDialog(UserInterfaceAddVehicle.this, "Превозното средство е добавено!",
								"Добавено",JOptionPane.INFORMATION_MESSAGE);
					}
				}catch(VehicleErrorException exc){
					JOptionPane.showMessageDialog(UserInterfaceAddVehicle.this, exc.getMessage(),
							"Грешка при добавяне", JOptionPane.ERROR_MESSAGE);
				} catch(NumberFormatException exp) {
					JOptionPane.showMessageDialog(UserInterfaceAddVehicle.this, "Попълнете празните полета!");
				}
			}
		};
		buttonCreate.addActionListener(buttonCreateListener);
		panel.add(buttonCreate);
		
		this.buttonUpdate.setBounds(400, 60, 100, 30);
		ActionListener buttonUpdateListener = new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					Date date = new Date((int)comboBoxYears.getSelectedItem()-1900, 
										 (int)comboBoxMonths.getSelectedItem()-1, 
										 (int)comboBoxDays.getSelectedItem());
				
					Vehicles updateVehicle = new Vehicles(comboBoxTypeVehicle.getSelectedItem().toString(),
														  textFieldRegNumber.getText(),
														  Integer.parseInt(textFieldYearVehicle.getText()),
														  Integer.parseInt(textFieldNumberPlaces.getText()),
														  Integer.parseInt(textFieldKM.getText()),
														  Integer.parseInt(textFieldRepairCount.getText()),
														  date,
														   textFieldLicense.getText());
				
					if(new Validate().isValidRegNumberVehicle(textFieldRegNumber.getText()) == false ){
						JOptionPane.showMessageDialog(UserInterfaceAddVehicle.this, "Въведеният регистрационен № е невалиден!",
								"Невалиден регистрационен №!", JOptionPane.ERROR_MESSAGE);
					} else {
						vehicle.update(updateVehicle);
						JOptionPane.showMessageDialog(UserInterfaceAddVehicle.this, "Превозното средство е променено!",
								"Промяна", JOptionPane.INFORMATION_MESSAGE);
					}
				}catch (VehicleErrorException exp) {
					JOptionPane.showMessageDialog(UserInterfaceAddVehicle.this, exp.getMessage(),
							"Грешка при промяна", JOptionPane.ERROR_MESSAGE);
				} catch(NumberFormatException exp) {
					JOptionPane.showMessageDialog(UserInterfaceAddVehicle.this, "Попълнете празните полета!",
							"Липсваща информация", JOptionPane.WARNING_MESSAGE);
				}
			}
		};
		buttonUpdate.addActionListener(buttonUpdateListener);
		panel.add(buttonUpdate);
		
		this.buttonDelete.setBounds(400, 100, 100, 30);
		ActionListener buttonDeleteListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					vehicle.delete(textFieldRegNumber.getText());
//					JOptionPane.showMessageDialog(UserInterfaceAddVehicle.this, "Превозното средство е изтрито!",
//							"Изтриване", JOptionPane.OK_OPTION);
				} catch (VehicleErrorException exp) {
					JOptionPane.showMessageDialog(UserInterfaceAddVehicle.this, exp.getMessage(),
							"Грешка при изтриване", JOptionPane.ERROR_MESSAGE);
				}
			}
		};
		buttonDelete.addActionListener(buttonDeleteListener);
		panel.add(buttonDelete);
		
		this.buttonSearch.setBounds(400, 140, 100, 30);
		ActionListener buttonSearchListener = new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					Vehicles v = vehicle.search(textFieldRegNumber.getText());
			
					comboBoxTypeVehicle.setSelectedItem(v.getTypeVehicle());
					textFieldYearVehicle.setText(Integer.toString(v.getYearVehicle()));
					textFieldNumberPlaces.setText(Integer.toString(v.getNumerOfPlaces()));
					textFieldKM.setText(Long.toString(v.getKm()));
					textFieldRepairCount.setText(Integer.toString(v.getRepairCount()));
					comboBoxDays.setSelectedItem(v.getLastRerair().getDate());
					comboBoxMonths.setSelectedItem(v.getLastRerair().getMonth()+1);
					comboBoxYears.setSelectedItem(v.getLastRerair().getYear()+1900);
					textFieldLicense.setText(v.getDriverLicense());
				} catch (VehicleErrorException exp) {
					JOptionPane.showMessageDialog(UserInterfaceAddVehicle.this, exp.getMessage(),
							"Грешка при търсене", JOptionPane.ERROR_MESSAGE);
				}
			}
		};
		buttonSearch.addActionListener(buttonSearchListener);
		panel.add(buttonSearch);
		
		this.buttonReset.setBounds(400, 180, 100, 30);
		ActionListener buttonResenListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboBoxTypeVehicle.setSelectedItem(1);
				textFieldRegNumber.setText("");
				textFieldYearVehicle.setText("");
				textFieldNumberPlaces.setText("");
				textFieldKM.setText("");
				textFieldRepairCount.setText("");
				textFieldLicense.setText("");
				comboBoxDays.setSelectedItem(1);
				comboBoxMonths.setSelectedItem(1);
				comboBoxYears.setSelectedItem(1);
			}
		};
		buttonReset.addActionListener(buttonResenListener);
		panel.add(buttonReset);
		
		this.buttonViewTable.setBounds(400, 220, 100, 30);
		ActionListener buttonTableListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new CreateTableVehicles();
			}
		};
		buttonViewTable.addActionListener(buttonTableListener);
		panel.add(buttonViewTable);
		
		this.buttonExit.setBounds(400, 260, 100, 30);
		ActionListener buttonExitListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new UserInterface().setVisible(true);
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
		comboBoxTypeVehicle.requestFocus();
	}
}