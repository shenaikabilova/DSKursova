package ShenaiKabilova;
import java.util.Date;

/**
 * @author shenaikabilova
 *
 */

public class Vehicles {
	
	private String typeVehicle;
	private String registrationNumber;
	private int yearVehicle;
	private int numberOfPlaces;
	private long km;
	private int repairCount;
	private Date lastRerair;
	private String driverLicense;
	
	public Vehicles (String typeVehicle, String registrationNumber, int yearVehicle,
			         int numberOfPlaces, long km, int repairCount, Date lastRepair, String driverLicense) {
		this.typeVehicle = typeVehicle;
		this.registrationNumber = registrationNumber;
		this.yearVehicle = yearVehicle;
		this.numberOfPlaces = numberOfPlaces;
		this.km = km;
		this.repairCount = repairCount;
		this.lastRerair = lastRepair;
		this.driverLicense = driverLicense;
	}

	public Vehicles () {
	}

	public String getTypeVehicle() {
		return typeVehicle;
	}
	public void setTypeVehicle(String typeVehicle) {
		this.typeVehicle = typeVehicle;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public int getYearVehicle() {
		return yearVehicle;
	}
	public void setYearVehicle(int yearVehicle) {
		this.yearVehicle = yearVehicle;
	}
	public int getNumerOfPlaces() {
		return numberOfPlaces;
	}
	public void setNumerOfPlaces(int numerOfPlaces) {
		this.numberOfPlaces = numerOfPlaces;
	}
	public long getKm() {
		return km;
	}
	public void setKm(long km) {
		this.km = km;
	}
	public int getRepairCount() {
		return repairCount;
	}
	public void setRepairCount(int repairCount) {
		this.repairCount = repairCount;
	}
	public Date getLastRerair() {
		return lastRerair;
	}
	public void setLastRerair(Date lastRerair) {
		this.lastRerair = lastRerair;
	}
	public String getDriverLicense() {
		return driverLicense;
	}
	public void setDriverLicense(String driverLicense) {
		this.driverLicense = driverLicense;
	}
}