package ShenaiKabilova;
/**
 * @author shenaikabilova
 *
 */

public class Drivers {
	
	private String password;
	private String driverFirstName;
	private String driverLastName;
	private String driverLicense;
	private long egn;
	
	public Drivers (String driverFirstName, String driverLastName, String driverLicense, String password, long egn) {
		this.driverFirstName = driverFirstName;
		this.driverLastName = driverLastName;
		this.driverLicense = driverLicense;
		this.password = password;
		this.egn = egn;
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
	
	public String getPassword() {
		return password;
	}
	public void setDriverID(String password) {
		this.password = password;
	}

	public long getEgn() {
		return egn;
	}

	public void setEgn(long egn) {
		this.egn = egn;
	}
}