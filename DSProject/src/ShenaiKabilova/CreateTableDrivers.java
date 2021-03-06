package ShenaiKabilova;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 * 
 */

/**
 * @author shenaikabilova
 *
 */
@SuppressWarnings("serial")
public class CreateTableDrivers extends JFrame implements Runnable, ActionListener{
	private JTable tableDrivers;
	
	public CreateTableDrivers() {
		JFrame frame = new JFrame("�������");
		
		DriverDAO drivers = new DriverDaoImpl();
		AbstractTableModel tableModel = new TableModelDrivers(drivers);
		tableDrivers = new JTable(tableModel);
		
		frame.setSize(800, 500);
		frame.setLocationRelativeTo(null);
		frame.add(new JScrollPane(tableDrivers));
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		setVisible(true);
	}
}