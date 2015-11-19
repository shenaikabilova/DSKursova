package Other;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import GeorgiPopov.CurrentStateUsername;
import GeorgiPopov.UserInterfaceTrips;
import ShenaiKabilova.DriverDAO;
import ShenaiKabilova.DriverDaoImpl;
import ShenaiKabilova.UserInterface;

/**
 * 
 */

/**
 * @author shenaikabilova
 *
 */
@SuppressWarnings("serial")
public class WelcomeScreen extends JFrame implements Runnable, ActionListener{
	private JPanel panel;
	
	private JLabel labelUsername = new JLabel("Username:");
	private JLabel labelPassword = new JLabel("Password:");
	
	private JTextField textFieldUsername = new JTextField("");
	private JPasswordField password = new JPasswordField();
	
	private JButton buttonEnter = new JButton("Enter");
	private JButton buttonExit = new JButton("Exit");
	
	public WelcomeScreen() {
		setTitle("Admin panel");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
		
		this.labelUsername.setBounds(20, 30, 80, 30);
		panel.add(labelUsername);
		
		this.labelPassword.setBounds(20, 60, 80, 30);
		panel.add(labelPassword);
		
		this.textFieldUsername.setBounds(100, 30, 100, 25);
		
		panel.add(textFieldUsername);
		
		this.password.setBounds(100, 60, 100, 25);
		panel.add(password);
		
		this.buttonEnter.setBounds(40, 100, 80, 30);
		panel.add(buttonEnter);
		
		this.buttonExit.setBounds(150, 100, 80, 30);
		panel.add(buttonExit);
		
		buttonEnter.addActionListener(this);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		buttonEnter.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				DriverDAO driver = new DriverDaoImpl();
				String pass = driver.checkUser(textFieldUsername.getText());
				
				if (textFieldUsername.getText().equals("Admin") && password.getText().equals("admin")) {
					dispose();
					new UserInterface().setVisible(true);;
				}
				else if(password.getText().equals(pass)){
					dispose();
					CurrentStateUsername current = new CurrentStateUsername();
					current.setCurrentUsername(textFieldUsername.getText());
					new UserInterfaceTrips().setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(panel, "Wrong username or password", "ERROR!",
							JOptionPane.ERROR_MESSAGE);
				}
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

	public String getTextFieldUsername() {
		return textFieldUsername.getText();
	}
}