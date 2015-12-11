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
	
	private JButton buttonAddVehice = new JButton("Добави превозно средство");
	private JButton buttonAddDriver = new JButton("Добави шофьор");
	private JButton buttonExit = new JButton("Изход");
	
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
		panel.add(buttonAddVehice);
		
		this.buttonAddDriver.setBounds(50, 90, 200, 45);
		panel.add(buttonAddDriver);
		
		this.buttonExit.setBounds(50, 150, 200, 45);
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