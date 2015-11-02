/**
 * @author shenaikabilova
 *
 */

public class Drivers {
	
	private int driverID;
	private String driverFirstName;
	private String driverLastName;
	private String driverLicense;
	
	public Drivers (String driverFirstName, String driverLastName, String driverLicense, int driverID) {
		this.driverFirstName = driverFirstName;
		this.driverLastName = driverLastName;
		this.driverLicense = driverLicense;
		this.driverID = driverID;
	}
	
	public Drivers () {
		
	}
	
	public String getDriverFirstName() {
		return driverFirstName;
	}
	public void setDriverFirstName(String driverFirstName) {
		this.driverFirstName = driverFirstName;
	}
	public String getDriverLastName() {
		return driverLastName;
	}
	public void setDriverLastName(String driverLastName) {
		this.driverLastName = driverLastName;
	}
	public String getDriverLicense() {
		return driverLicense;
	}
	public void setDriverLicense(String driverLicense) {
		this.driverLicense = driverLicense;
	}
	
	public int getDriverID() {
		return driverID;
	}
	public void setDriverID(int driverID) {
		this.driverID = driverID;
	}
}