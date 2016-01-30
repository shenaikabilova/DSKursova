package ShenaiKabilova;

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
public class CreateTableVehicles extends JFrame implements Runnable{
	private JTable tableVehicles;
	
	public CreateTableVehicles() {
		JFrame frame = new JFrame("Превозни средства");
		
		VehicleDAO vehicles = new VehicleDaoImpl();
		AbstractTableModel tableModel = new TableModelVehicles(vehicles);
		tableVehicles = new JTable(tableModel);
		
		frame.setSize(1000, 500);
		frame.setLocationRelativeTo(null);
		frame.add(new JScrollPane(tableVehicles));
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		//setVisible(true);
	}
}