/**
 * 
 */
package GeorgiPopov;

import java.util.Date;

/**
 * @author shenaikabilova
 *
 */
public class Trips {
	private String driverFirstName;
	private String driverLastName;
	private String driverLicense;
	private String driverEgn;
	private String vehicleRegNumber;
	private Date startDate;
	private Date endDate;
	private long km;
	private int tripID;
	
	public Trips(){
	}
	
	public Trips (int tripID, String driverFirstName, String driverLastName, String driverLicense, String driverEgn, 
				  String vehicleRegNumber, Date startDate, Date endDate, long km) {
		this.tripID = tripID;
		this.driverFirstName = driverFirstName;
		this.driverLastName = driverLastName;
		this.driverLicense = driverLicense;
		this.driverEgn = driverEgn;
		this.vehicleRegNumber = vehicleRegNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.km = km;
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

	public String getDriverEgn() {
		return driverEgn;
	}

	public void setDriverEgn(String driverEgn) {
		this.driverEgn = driverEgn;
	}

	public String getVehicleRegNumber() {
		return vehicleRegNumber;
	}

	public void setVehicleRegNumber(String vehicleRegNumber) {
		this.vehicleRegNumber = vehicleRegNumber;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public long getKm() {
		return km;
	}

	public void setKm(long km) {
		this.km = km;
	}

	public int getTripID() {
		return tripID;
	}

	public void setTripID(int tripID) {
		this.tripID = tripID;
	}
}