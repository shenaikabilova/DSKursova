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
	private long km;
	private int repairCount;
	private long lastRerair;
	private int driverID;
	
	public Vehicles (String typeVehicle, String registrationNumber, int yearVehicle,
			         String color, int numberOfPlaces, long km, int repairCount, long lastRepair, int driverID) {
		this.typeVehicle = typeVehicle;
		this.registrationNumber = registrationNumber;
		this.yearVehicle = yearVehicle;
		this.color = color;
		this.numberOfPlaces = numberOfPlaces;
		this.km = km;
		this.repairCount = repairCount;
		this.lastRerair = lastRepair;
		this.driverID = driverID;
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
	public long getLastRerair() {
		return lastRerair;
	}
	public void setLastRerair(long lastRerair) {
		this.lastRerair = lastRerair;
	}
	
	public int getDriverID() {
		return driverID;
	}

	public void setDriverID(int driverID) {
		this.driverID = driverID;
	}
}