/**
 * 
 */
package GeorgiPopov;

import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * @author shenaikabilova
 *
 */
@SuppressWarnings("serial")
public class TableModelTripsReport extends AbstractTableModel{
	private Object[][] tableTrip;
	private String[] columnName = {"TRIP_ID", "DRIVER_FIRST_NAME", "DRIVER_LAST_NAME", "DRIVER_LICENSE", 
								   "DRIVER_EGN", "VEHICLE_REGISTRATION_NUMBER", "START_DATE", "END_DATE", "KM"};

	public TableModelTripsReport (TripsDAO trips) {
		List<Trips> trip = trips.makeReport(new CurrentStateUsername().getCurrentUsername());
		
		tableTrip = new Object[trip.size()][columnName.length];
		
		int i=0;
		for (Trips t : trip) {
			tableTrip[i][0] = t.getTripID();
			tableTrip[i][1] = t.getDriverFirstName();
			tableTrip[i][2] = t.getDriverLastName();
			tableTrip[i][3] = t.getDriverLicense();
			tableTrip[i][4] = t.getDriverEgn();
			tableTrip[i][5] = t.getVehicleRegNumber();
			tableTrip[i][6] = t.getStartDate();
			tableTrip[i][7] = t.getEndDate();
			tableTrip[i][8] = t.getKm();
			
			i++;
		}
	}
	
	public String getColumnName (int col) {
		return columnName[col];
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return columnName.length;
	}
	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return tableTrip.length;
	}
	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int arg0, int arg1) {
		return tableTrip[arg0][arg1];
	}
}
