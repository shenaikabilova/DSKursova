import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 * @author shenaikabilova
 *
 */

public class VehicleDB implements VehicleDAO{
	
	private Connection connection;
	private ResultSet resultSet;
	private Vehicles vehicle;
	private PreparedStatement pr;
	
	@Override
	public void insert(Vehicles vehicle) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl",
					"DSProject", "password");
			
			pr = connection.prepareStatement("INSERT INTO "
					+ "VEHICLE (TYPEVEHICLE, REGISTRATIONNUMBER, YEARVEHICLE, COLOR,"
					+ "NUMBERPLACES, KM, REPAIRCOUNT, LASTREPAIR, DRIVERID) "
					+ "VALUES(?,?,?,?,?,?,?,?,?)");
			
			pr.setString(1, vehicle.getTypeVehicle());
			pr.setString(2, vehicle.getRegistrationNumber());
			pr.setInt(3, vehicle.getYearVehicle());
			pr.setString(4, vehicle.getColor());
			pr.setInt(5, vehicle.getNumerOfPlaces());
			pr.setLong(6, vehicle.getKm());
			pr.setInt(7, vehicle.getRepairCount());
			
			Date date = new Date(vehicle.getLastRerair());
			pr.setDate(8, date);
			
			pr.setInt(9, vehicle.getDriverID());
			
			pr.executeUpdate();
			
			pr.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String regNumber) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl",
					"DSProject", "password");
			
			pr = connection.prepareStatement("DELETE FROM VEHICLE WHERE REGISTRATIONNUMBER =" 
							+ regNumber);
			pr.executeUpdate();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Vehicles vehicle) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl",
					"DSProject", "password");
		
			pr = connection.prepareStatement("UPDATE VEHICLE SET TYPEVEHICLE = ?, "
					+ "REGISTRATIONNUMBER = ?, YEARVEHICLE = ?, COLOR = ?,"
					+ "NUMBERPLACES = ?, KM = ?, REPAIRCOUNT = ?, LASTREPAIR = ?, DRIVERID = ? "
					+ "WHERE REGISTRATIONNUMBER = " + vehicle.getRegistrationNumber());
			
			pr.setString(1, vehicle.getTypeVehicle());
			pr.setString(2, vehicle.getRegistrationNumber());
			pr.setInt(3, vehicle.getYearVehicle());
			pr.setString(4, vehicle.getColor());
			pr.setInt(5, vehicle.getNumerOfPlaces());
			pr.setLong(6, vehicle.getKm());
			pr.setInt(7, vehicle.getRepairCount());
			
			Date date =  new Date(vehicle.getLastRerair());
			pr.setDate(8, date);
			
			pr.setInt(9, vehicle.getDriverID());
			
			pr.executeUpdate();
			
			pr.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see VehicleDAO#listVehicles()
	 */
	@Override
	public List<Vehicles> listVehicles() {
		List<Vehicles> vehicles;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl",
					"DSProject", "password");
			
			pr = connection.prepareStatement("SELECT TYPEVEHICLE, REGISTRATIONNUMBER, YEARVEHICLE,"
					+ "COLOR, NUMBERPLACES, KM, REPAIRCOUNT, LASTREPAIR, DRIVERID FROM VEHICLE");
			PreparedStatement prCount = connection.prepareStatement("SELECT COUNT(*) as count FROM VEHICLE");
			
			resultSet = pr.executeQuery();
			ResultSet rsCount = prCount.executeQuery();
			
			rsCount.next();
			int count = rsCount.getInt("count");
			
			vehicles = new ArrayList<Vehicles>(count); 
			
			String typeVehicle;
			String registrationNumber;
			int yearVehicle;
			String color;
			int numberOfPlaces;
			long km;
			int repairCount;
			Date lastRerair;
			int driverID;
			
			long d;
			while(resultSet.next()) {
				typeVehicle = resultSet.getString("TYPEVEHICLE");
				registrationNumber = resultSet.getString("REGISTRATIONNUMBER");
				yearVehicle = resultSet.getInt("YEARVEHICLE");
				color = resultSet.getString("COLOR");
				numberOfPlaces = resultSet.getInt("NUMBERPLACES");
				km = resultSet.getLong("KM");
				repairCount = resultSet.getInt("REPAIRCOUNT");
				lastRerair = resultSet.getDate("LASTREPAIR");
				driverID = resultSet.getInt("DRIVERID");
				
				d = lastRerair.getTime();
				
				vehicles.add(new Vehicles(typeVehicle, registrationNumber, yearVehicle, color, 
					               numberOfPlaces, km, repairCount, d, driverID));
			}
		
			
			return vehicles;
		} catch (Exception exp) {
			return new ArrayList<Vehicles>(0);
		}
	}

	/* (non-Javadoc)
	 * @see VehicleDAO#search(java.lang.String)
	 */
	@Override
	public Vehicles search(String regNumber) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl",
					"DSProject", "password");
			
			pr = connection.prepareStatement("SELECT TYPEVEHICLE, REGISTRATIONNUMBER, "
					+ "YEARVEHICLE, COLOR, NUMBERPLACES, KM, REPAIRCOUNT, LASTREPAIR, DRIVERID"
					+ " FROM VEHICLE WHERE REGISTRATIONNUMBER =  " + regNumber);
			
			resultSet = pr.executeQuery();
		
			String typeVehicle;
			int yearVehicle;
			String color;
			int numberOfPlaces;
			long km;
			int repairCount;
			Date lastRerair;
			int driverID;
			
			if(resultSet.next()) {
				typeVehicle = resultSet.getString(1);
				yearVehicle = resultSet.getInt(3);
				color = resultSet.getString(4);
				numberOfPlaces = resultSet.getInt(5);
				km = resultSet.getLong(6);
				repairCount = resultSet.getInt(7);
				lastRerair = resultSet.getDate(8);
				driverID = resultSet.getInt(9);
				
				long d = lastRerair.getTime();
				vehicle = new Vehicles(typeVehicle, regNumber, yearVehicle, color, 
					               numberOfPlaces, km, repairCount, d, driverID);
			}
			else {
				throw new SQLDataException("Data not found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return vehicle;
	}
}