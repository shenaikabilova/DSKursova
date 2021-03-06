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
public class CreateTableTripsReport extends JFrame implements Runnable, ActionListener{
	private JTable tableTrip;
	
	public CreateTableTripsReport () {
		JFrame frame = new JFrame("�����");
		
		TripsDAO trips = new TripsDaoImpl();
		AbstractTableModel tableModel = new TableModelTripsReport(trips);
		tableTrip = new JTable(tableModel);
		
		frame.setSize(1000, 500);
		frame.setLocationRelativeTo(null);
		frame.add(new JScrollPane(tableTrip));
		frame.setVisible(true);
		frame.setResizable(false);
		
		tableTrip.getColumnModel().getColumn(0).setPreferredWidth(20);
		tableTrip.getColumnModel().getColumn(3).setPreferredWidth(20);
		tableTrip.getColumnModel().getColumn(4).setPreferredWidth(40);
		tableTrip.getColumnModel().getColumn(8).setPreferredWidth(20);
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