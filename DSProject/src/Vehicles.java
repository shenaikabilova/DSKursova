import java.util.Date;

/**
 * @author shenaikabilova
 *
 */

public class Vehicles {
	
	private String typeVehicle;
	private String registrationNumber;
	private int yearVehicle;
	private String color;
	private int numberOfPlaces;
	private int km;
	private int repairCount;
	private Date lastRerair;
	private String driverLicense;
	
	public Vehicles (String typeVehicle, String registrationNumber, int yearVehicle,
			         String color, int numberOfPlaces, int km, int repairCount, Date lastRepair, String driverLicense) {
		this.typeVehicle = typeVehicle;
		this.registrationNumber = registrationNumber;
		this.yearVehicle = yearVehicle;
		this.color = color;
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getNumerOfPlaces() {
		return numberOfPlaces;
	}
	public void setNumerOfPlaces(int numerOfPlaces) {
		this.numberOfPlaces = numerOfPlaces;
	}
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
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