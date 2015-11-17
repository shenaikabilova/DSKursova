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
public class CreateTableVehicles extends JFrame implements Runnable, ActionListener{
	private JTable tableVehicles;
	
	public CreateTableVehicles() {
		JFrame frame = new JFrame("Vehicles");
		
		VehicleDAO vehicles = new VehicleDaoImpl();
		AbstractTableModel tableModel = new TableModelVehicles(vehicles);
		tableVehicles = new JTable(tableModel);
		
		frame.setSize(800, 500);
		frame.setLocationRelativeTo(null);
		frame.add(new JScrollPane(tableVehicles));
		frame.setVisible(true);
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