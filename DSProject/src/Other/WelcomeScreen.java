package Other;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
import ShenaiKabilova.DriverErrorException;
import ShenaiKabilova.UserInterface;

/**
 * @author shenaikabilova
 *
 */
@SuppressWarnings("serial")
public class WelcomeScreen extends JFrame implements Runnable, ActionListener{
	private JPanel panel;
	
	private JLabel labelUsername = new JLabel("����������:");
	private JLabel labelPassword = new JLabel("������:");
	
	private JTextField textFieldUsername = new JTextField("");
	private JPasswordField password = new JPasswordField();
	
	private JButton buttonEnter = new JButton("����");
	private JButton buttonExit = new JButton("����");
	
	public WelcomeScreen() {
		setTitle("Admin panel");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		this.panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
		
		this.labelUsername.setBounds(20, 30, 80, 30);
		panel.add(labelUsername);
		
		this.labelPassword.setBounds(20, 60, 80, 30);
		panel.add(labelPassword);
		
		this.textFieldUsername.setBounds(100, 30, 100, 25);
		textFieldUsername.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
			    if (!((c >= '�') && (c <= '�') || (c >= '�') && (c <= '�') || (c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
			        getToolkit().beep();
			        e.consume();
			    }
 
                if (textFieldUsername.getText().length() == 10) {  
                	JOptionPane.showMessageDialog(WelcomeScreen.this, "���������� ���� ������� ��� ������������� ���: 10!", "�������� ���� �������",
                			JOptionPane.WARNING_MESSAGE);
                        e.consume();// ignore event  
                }
			}
			
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER) {
					password.requestFocus();
				}
			}
		});
		panel.add(textFieldUsername);
		
		this.password.setBounds(100, 60, 100, 25);
		password.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			public void keyTyped(KeyEvent e) {
			    if (password.getText().length() == 8) {  
                	JOptionPane.showMessageDialog(WelcomeScreen.this, "�������� ������ �� � �� 8 �������",
                			"�������� ���� �������", JOptionPane.WARNING_MESSAGE);
                        e.consume();// ignore event  
                }
			}
		});
		panel.add(password);
		
		this.buttonEnter.setBounds(40, 100, 80, 30);
		panel.add(buttonEnter);
		
		this.buttonExit.setBounds(150, 100, 80, 30);
		panel.add(buttonExit);

		buttonEnter.addActionListener(this);
		buttonExit.addActionListener(this);
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
				
				if (textFieldUsername.getText().equals("�����") && password.getText().equals("�����")) {
					dispose();
					new UserInterface().setVisible(true);;
				}
				else if(password.getText().equals(pass)){
					dispose();
					CurrentStateUsername current = new CurrentStateUsername();
					current.setCurrentUsername(textFieldUsername.getText());
					try {
						new UserInterfaceTrips().setVisible(true);
					} catch (DriverErrorException e1) {
						e1.printStackTrace();
					}
				}
				else{
					JOptionPane.showMessageDialog(WelcomeScreen.this, "������ ��������� ��� ������������� ��� ��� ������!", 
							"������ ������������� ��� ��� ������", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		buttonExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
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