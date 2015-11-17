package ShenaiKabilova;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Other.WelcomeScreen;


/**
 * @author shenaikabilova
 *
 */

@SuppressWarnings("serial")
public class UserInterface extends JFrame implements Runnable, ActionListener{
	private JPanel panel;
	
	private JButton buttonAddVehice = new JButton("Add vehicle");
	private JButton buttonAddDriver = new JButton("Add driver");
	private JButton buttonExit = new JButton("Exit");
	
	public UserInterface() {
		setTitle("DS Project");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
		
		this.buttonAddVehice.setBounds(80, 30, 100, 45);
		panel.add(buttonAddVehice);
		
		this.buttonAddDriver.setBounds(80, 90, 100, 45);
		panel.add(buttonAddDriver);
		
		this.buttonExit.setBounds(80, 150, 100, 45);
		panel.add(buttonExit);
		
		buttonAddVehice.addActionListener(this);
		buttonAddDriver.addActionListener(this);
		buttonExit.addActionListener(this);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		buttonAddVehice.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new UserInterfaceAddVehicle().setVisible(true);
			}
		});
		
		buttonAddDriver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new UserInterfaceAddDriver().setVisible(true);
			}
		});
		
		buttonExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new WelcomeScreen().setVisible(true);;
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