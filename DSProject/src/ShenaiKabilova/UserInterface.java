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
public class UserInterface extends JFrame implements Runnable{
	private JPanel panel;
	
	private JButton buttonAddVehice = new JButton("Добави превозно средство");
	private JButton buttonAddDriver = new JButton("Добави шофьор");
	private JButton buttonExit = new JButton("Край");
	
	public UserInterface() {
		setTitle("Админ");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		this.panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
		
		this.buttonAddVehice.setBounds(50, 30, 200, 45);
		ActionListener buttonAddVehicleListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new UserInterfaceAddVehicle().setVisible(true);
			}
		};
		buttonAddVehice.addActionListener(buttonAddVehicleListener);
		panel.add(buttonAddVehice);
		
		this.buttonAddDriver.setBounds(50, 90, 200, 45);
		ActionListener buttonAddDriverVehicle = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new UserInterfaceAddDriver().setVisible(true);
			}
		};
		buttonAddDriver.addActionListener(buttonAddDriverVehicle);
		panel.add(buttonAddDriver);
		
		this.buttonExit.setBounds(50, 150, 200, 45);
		ActionListener buttonExitListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new WelcomeScreen().setVisible(true);;
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