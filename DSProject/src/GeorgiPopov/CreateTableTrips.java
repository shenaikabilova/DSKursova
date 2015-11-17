/**
 * 
 */
package GeorgiPopov;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 * @author shenaikabilova
 *
 */
@SuppressWarnings("serial")
public class CreateTableTrips extends JFrame implements Runnable, ActionListener{
	private JTable tableTrip;
	
	public CreateTableTrips () {
		JFrame frame = new JFrame("Trips");
		
		TripsDAO trips = new TripsDaoImpl();
		AbstractTableModel tableModel = new TableModelTrips(trips);
		tableTrip = new JTable(tableModel);
		
		frame.setSize(800, 500);
		frame.setLocationRelativeTo(null);
		frame.add(new JScrollPane(tableTrip));
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