package ShenaiKabilova;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author shenaikabilova
 *
 */

public class VehicleDaoImpl implements VehicleDAO{
	@Override
	public void insert(Vehicles vehicle) {
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl",
				"DSProject", "password")) {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			final String QUERY = "INSERT INTO "
					+ "VEHICLE (TYPE_VEHICLE, REGISTRATION_NUMBER, YEAR_VEHICLE, COLOR,"
					+ "NUMBER_PLACES, KM, REPAIR_COUNT, LAST_REPAIR, DRIVER_LICENSE) "
					+ "VALUES(?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement pr = connection.prepareStatement(QUERY);
			
			pr.setString(1, vehicle.getTypeVehicle());
			pr.setString(2, vehicle.getRegistrationNumber());
			pr.setInt(3, vehicle.getYearVehicle());
			pr.setString(4, vehicle.getColor());
			pr.setInt(5, vehicle.getNumerOfPlaces());
			pr.setLong(6, vehicle.getKm());
			pr.setInt(7, vehicle.getRepairCount());
			
			Date date = new Date(vehicle.getLastRerair().getTime());
			pr.setDate(8, date);

			pr.setString(9, vehicle.getDriverLicense());
			
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
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl",
				"DSProject", "password")){
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			final String QUERY = "DELETE FROM VEHICLE WHERE REGISTRATION_NUMBER = '" + regNumber + "'";
			
			PreparedStatement pr = connection.prepareStatement(QUERY);
			
			pr.executeUpdate();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Vehicles vehicle) {
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl",
				"DSProject", "password")) {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			final String QUERY = "UPDATE VEHICLE SET TYPE_VEHICLE = ?, "
					+ "REGISTRATION_NUMBER = ?, YEAR_VEHICLE = ?, COLOR = ?,"
					+ "NUMBER_PLACES = ?, KM = ?, REPAIR_COUNT = ?, LAST_REPAIR = ?, DRIVER_LICENSE = ? "
					+ "WHERE REGISTRATION_NUMBER = '" + vehicle.getRegistrationNumber() + "'";
			
			PreparedStatement pr = connection.prepareStatement(QUERY);
			
			pr.setString(1, vehicle.getTypeVehicle());
			pr.setString(2, vehicle.getRegistrationNumber());
			pr.setInt(3, vehicle.getYearVehicle());
			pr.setString(4, vehicle.getColor());
			pr.setInt(5, vehicle.getNumerOfPlaces());
			pr.setLong(6, vehicle.getKm());
			pr.setInt(7, vehicle.getRepairCount());
			pr.setDate(8, (Date) vehicle.getLastRerair());
			pr.setString(9, vehicle.getDriverLicense());
			
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
		
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl",
				"DSProject", "password")){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			final String QUERY = "SELECT TYPE_VEHICLE, REGISTRATION_NUMBER, YEAR_VEHICLE,"
					+ "COLOR, NUMBER_PLACES, KM, REPAIR_COUNT, LAST_REPAIR, DRIVER_LICENSE FROM VEHICLE";
			final String QUERY_COUNT = "SELECT COUNT(*) as count FROM VEHICLE";
			
			PreparedStatement pr = connection.prepareStatement(QUERY);
			PreparedStatement prCount = connection.prepareStatement(QUERY_COUNT);
			
			ResultSet resultSet = pr.executeQuery();
			ResultSet rsCount = prCount.executeQuery();
			
			rsCount.next();
			int count = rsCount.getInt("count");
			
			vehicles = new ArrayList<Vehicles>(count); 
			
			while(resultSet.next()) {
				String typeVehicle = resultSet.getString("TYPE_VEHICLE");
				String registrationNumber = resultSet.getString("REGISTRATION_NUMBER");
				int yearVehicle = resultSet.getInt("YEAR_VEHICLE");
				String color = resultSet.getString("COLOR");
				int numberOfPlaces = resultSet.getInt("NUMBER_PLACES");
				int km = resultSet.getInt("KM");
				int repairCount = resultSet.getInt("REPAIR_COUNT");
				Date lastRerair = resultSet.getDate("LAST_REPAIR");
				String driverLicense = resultSet.getString("DRIVER_LICENSE");
				
				vehicles.add(new Vehicles(typeVehicle, registrationNumber, yearVehicle, color, 
					               numberOfPlaces, km, repairCount, lastRerair, driverLicense));
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
	public Vehicles search(String regNumber){
		Vehicles vehicle = new Vehicles();
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl",
				"DSProject", "password")){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			final String QUERY = "SELECT TYPE_VEHICLE, REGISTRATION_NUMBER, "
					+ "YEAR_VEHICLE, COLOR, NUMBER_PLACES, KM, REPAIR_COUNT, LAST_REPAIR, DRIVER_LICENSE"
					+ " FROM VEHICLE WHERE REGISTRATION_NUMBER = '" + regNumber + "'";
			
			PreparedStatement pr = connection.prepareStatement(QUERY);
			ResultSet resultSet = pr.executeQuery();
			
		if(resultSet.next()) {
				String typeVehicle = resultSet.getString("TYPE_VEHICLE");
				int yearVehicle = resultSet.getInt("YEAR_VEHICLE");
				String color = resultSet.getString("COLOR");
				int numberOfPlaces = resultSet.getInt("NUMBER_PLACES");
				int km = resultSet.getInt("KM");
				int repairCount = resultSet.getInt("REPAIR_COUNT");
				Date lastRerair = resultSet.getDate("LAST_REPAIR");
				String driverLicense = resultSet.getString("DRIVER_LICENSE");
				
				vehicle = new Vehicles(typeVehicle, regNumber, yearVehicle, color, 
					               numberOfPlaces, km, repairCount, lastRerair, driverLicense);
				
				return vehicle;
			} else {
				throw new SQLDataException("Data not found");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		} 
		return vehicle;
	}

	/* (non-Javadoc)
	 * @see ShenaiKabilova.VehicleDAO#searchVehicle(java.lang.String)
	 */
	@Override
	public List<String> searchVehicle(String license) {
		List<String> searchVehicle = new ArrayList<String>();
		
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl",
				"DSProject", "password")){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			final String QUERY = "SELECT REGISTRATION_NUMBER FROM VEHICLE WHERE DRIVER_LICENSE='" + license + "'";
			final String QUERYCOUNT = "SELECT COUNT(REGISTRATION_NUMBER) as count FROM VEHICLE WHERE DRIVER_LICENSE='" + license + "'";
			
			PreparedStatement prepareStatement = connection.prepareStatement(QUERY);
			PreparedStatement prepareStatementCount = connection.prepareStatement(QUERYCOUNT);
			ResultSet resultSet = prepareStatement.executeQuery();
			ResultSet resultSetCount = prepareStatementCount.executeQuery();
			
			resultSetCount.next();
			int count = resultSetCount.getInt("count");
			
			searchVehicle = new ArrayList<String>(count);
			
			while(resultSet.next()){
				String regNumber = resultSet.getString("REGISTRATION_NUMBER");
				
				searchVehicle.add(regNumber);
			}
			return searchVehicle;
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		} 
		return searchVehicle;
	}
}