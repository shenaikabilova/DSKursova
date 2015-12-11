package ShenaiKabilova;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * 
 */

/**
 * @author shenaikabilova
 *
 */
@SuppressWarnings("serial")
public class TableModelDrivers extends AbstractTableModel {
	private Object[][] tableDrivers;
	private String[] columnNameDrivers = {"Име", "Фамилия", "Категория", "№", "ЕГН"};
	
	public TableModelDrivers (DriverDAO dao) {
		List<Drivers> drivers = dao.listDrivers();
		
		tableDrivers = new Object[drivers.size()][columnNameDrivers.length];
		
		int i=0;
		for (Drivers driver : drivers) {
			tableDrivers[i][0] = driver.getDriverFirstName();
			tableDrivers[i][1] = driver.getDriverLastName();
			tableDrivers[i][2] = driver.getDriverLicense();
			tableDrivers[i][3] = driver.getPassword();
			tableDrivers[i][4] = driver.getEgn();
			
			i++;
		}
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return columnNameDrivers.length;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return tableDrivers.length;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return tableDrivers[rowIndex][columnIndex];
	}
	
	public String getColumnName(int columnIndex) {
		return columnNameDrivers[columnIndex];
	}
}