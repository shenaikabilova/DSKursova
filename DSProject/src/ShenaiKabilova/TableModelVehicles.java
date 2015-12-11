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
public class TableModelVehicles extends AbstractTableModel {
	private Object[][] tableVehicles;
	private String[] columnNameVehicles = {"Вид превозно средство", "Регистрационен №", "Година", 
										   "Брой места", "Км", "Брой ремонти", "Последен ремонт", "Категория"};
	
	public TableModelVehicles (VehicleDAO dao) {
		List<Vehicles> vehicles = dao.listVehicles();
			
		tableVehicles = new Object[vehicles.size()][columnNameVehicles.length];
		int i=0;
		for (Vehicles vehicle : vehicles) {
			tableVehicles[i][0] = vehicle.getTypeVehicle();
			tableVehicles[i][1] = vehicle.getRegistrationNumber();
			tableVehicles[i][2] = vehicle.getYearVehicle();
			tableVehicles[i][3] = vehicle.getNumerOfPlaces();
			tableVehicles[i][4] = vehicle.getKm();
			tableVehicles[i][5] = vehicle.getRepairCount();
			tableVehicles[i][6] = vehicle.getLastRerair();
			tableVehicles[i][7] = vehicle.getDriverLicense();

			i++;
		}
	}

	public int getColumnCount() {
		return columnNameVehicles.length;
	}
	
	public int getRowCount() {
		return tableVehicles.length;
	}

	public Object getValueAt(int arg0, int arg1) {
		return tableVehicles[arg0][arg1];
	}
	
	public String getColumnName (int columnInex) {
		return columnNameVehicles[columnInex];
	}
}