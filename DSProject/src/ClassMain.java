import javax.swing.SwingUtilities;

/**
 * 
 */

/**
 * @author shenaikabilova
 *
 */

public class ClassMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//SwingUtilities.invokeLater(new UserInterfaceAddVehicle());
		
		Vehicles vehicle = new Vehicles("car", "'V1234RP'", 2010, "blue", 3, 1526987, 55, 2007-5-15, 6);
		VehicleDAO v = new VehicleDB();
		
//		for(Vehicles vehicles : v.listVehicles()) {
//			System.out.println("Vehicle: " + vehicles.getTypeVehicle() + " " + vehicles.getRegistrationNumber() + 
//			 " " + vehicles.getYearVehicle() + " " + vehicles.getColor() + " " + vehicles.getNumerOfPlaces() + 
//			 " " + vehicles.getKm() + " " + vehicles.getRepairCount() + " " + vehicles.getLastRerair() + " " + vehicles.getDriverID());
//		}
		
		v.update(vehicle);
	}
}