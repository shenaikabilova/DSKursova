/**
 * 
 */
package GeorgiPopov;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shenaikabilova
 *
 */
public class TripsDaoImpl implements TripsDAO{

	/* (non-Javadoc)
	 * @see GeorgiPopov.TripsDAO#loadAll()
	 */
	@Override
	public List<Trips> loadAll() {
		List<Trips> trips;
		
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl",
				"DSProject", "password")){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			final String QUERY = "SELECT TRIP_ID, DRIVER_FIRST_NAME, DRIVER_LAST_NAME, DRIVER_LICENSE, DRIVER_EGN, VEHICLE_REGISTRATION_NUMBER, START_DATE, END_DATE, KM FROM TRIPS";
			final String QUERY_COUNT = "SELECT COUNT(*) as count FROM TRIPS";
			
			PreparedStatement prepareStatement = connection.prepareStatement(QUERY);
			PreparedStatement prepareStatementCount = connection.prepareStatement(QUERY_COUNT);
			
			ResultSet resultSet = prepareStatement.executeQuery();
			ResultSet resultSetCount = prepareStatementCount.executeQuery();
			
			resultSetCount.next();
			int count = resultSetCount.getInt("count");
			
			trips = new ArrayList<Trips>(count);
			
			while(resultSet.next()) {
				int tripID = resultSet.getInt("TRIP_ID");
				String driverFirstName = resultSet.getString("DRIVER_FIRST_NAME");
				String driverLastName = resultSet.getString("DRIVER_LAST_NAME");
				String driverLicense = resultSet.getString("DRIVER_LICENSE");
				String driverEgn = resultSet.getString("DRIVER_EGN");
				String vehicleRegistrationNumber = resultSet.getString("VEHICLE_REGISTRATION_NUMBER");
				Timestamp startDate = resultSet.getTimestamp("START_DATE");
				Timestamp endDate = resultSet.getTimestamp("END_DATE");
				long km = resultSet.getLong("KM");
				
				trips.add(new Trips(tripID, driverFirstName, driverLastName, driverLicense, driverEgn, 
						            vehicleRegistrationNumber, startDate, endDate, km));
				
			}
			
			return trips;
		} catch (Exception exp) {
			return new ArrayList<Trips>(0);
		}
	}

	/* (non-Javadoc)
	 * @see GeorgiPopov.TripsDAO#insert(GeorgiPopov.Trips)
	 */
	@Override
	public void insert(Trips trip) throws TripsException {
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl",
				"DSProject", "password")){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			final String QUERY = "INSERT INTO TRIPS (TRIP_ID, DRIVER_FIRST_NAME, DRIVER_LAST_NAME, DRIVER_LICENSE, "
					+ "DRIVER_EGN, VEHICLE_REGISTRATION_NUMBER, START_DATE, END_DATE, KM)"
					+ "VALUES (?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement prepareStatement = connection.prepareStatement(QUERY);
			
			prepareStatement.setInt(1, trip.getTripID());
			prepareStatement.setString(2, trip.getDriverFirstName());
			prepareStatement.setString(3, trip.getDriverLastName());
			prepareStatement.setString(4, trip.getDriverLicense());
			prepareStatement.setString(5, trip.getDriverEgn());
			prepareStatement.setString(6, trip.getVehicleRegNumber());
			prepareStatement.setTimestamp(7, new Timestamp(trip.getStartDate().getTime()));
			prepareStatement.setTimestamp(8, new Timestamp(trip.getEndDate().getTime()));
			prepareStatement.setLong(9, trip.getKm());

			prepareStatement.executeUpdate();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLIntegrityConstraintViolationException e) {
			throw new TripsException("ID �� ���������� ���� ����������!");
		}catch (SQLException e) {
			throw new TripsException("���������� �� ���� �� �� ������!");
		}
	}

	/* (non-Javadoc)
	 * @see GeorgiPopov.TripsDAO#update(GeorgiPopov.Trips)
	 */
	@Override
	public void update(Trips trip) throws TripsException {
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl",
				"DSProject", "password")){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			final String QUERY = "UPDATE TRIPS SET TRIP_ID=?, DRIVER_FIRST_NAME=?, DRIVER_LAST_NAME=?, DRIVER_LICENSE=?, "
					+ "DRIVER_EGN=?, VEHICLE_REGISTRATION_NUMBER=?, START_DATE=?, END_DATE=?, KM=?"
					+ "WHERE TRIP_ID=" + trip.getTripID();
			
			PreparedStatement prepareStatement = connection.prepareStatement(QUERY);
			
			prepareStatement.setInt(1, trip.getTripID());
			prepareStatement.setString(2, trip.getDriverFirstName());
			prepareStatement.setString(3, trip.getDriverLastName());
			prepareStatement.setString(4, trip.getDriverLicense());
			prepareStatement.setString(5, trip.getDriverEgn());
			prepareStatement.setString(6, trip.getVehicleRegNumber());
			prepareStatement.setTimestamp(7, new Timestamp(trip.getStartDate().getTime()));
			prepareStatement.setTimestamp(8, new Timestamp(trip.getEndDate().getTime()));
			prepareStatement.setLong(9, trip.getKm());
			
			prepareStatement.executeUpdate();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLIntegrityConstraintViolationException e) {
			throw new TripsException("ID �� �������� ���� ����������!");
		}catch (SQLException e) {
			throw new TripsException("���������� �� ���� �� �� ������!");
		}
	}

	/* (non-Javadoc)
	 * @see GeorgiPopov.TripsDAO#delete(int)
	 */
	@Override
	public void delete(int tripID) throws TripsException {
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl",
				"DSProject", "password")){
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			final String QUERY = "DELETE FROM TRIPS WHERE TRIP_ID = '" + tripID + "'";
			
			PreparedStatement pr = connection.prepareStatement(QUERY);
			
			pr.executeUpdate();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e) {
			throw new TripsException("���������� �� ���� �� �� ������!");
		}
	}

	/* (non-Javadoc)
	 * @see GeorgiPopov.TripsDAO#search(int)
	 */
	@Override
	public Trips search(int tripID) throws TripsException {
		Trips trip = new Trips();
		
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl",
				"DSProject", "password")){
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			final String QUERY = "SELECT TRIP_ID, DRIVER_FIRST_NAME, DRIVER_LAST_NAME, DRIVER_LICENSE, "
							   + "DRIVER_EGN, VEHICLE_REGISTRATION_NUMBER, START_DATE, END_DATE, KM FROM TRIPS WHERE TRIP_ID = " + tripID;
			PreparedStatement prepareStatement = connection.prepareStatement(QUERY);
			ResultSet resultSet = prepareStatement.executeQuery();
			
			if(resultSet.next()){
				String driverFirstName = resultSet.getString("DRIVER_FIRST_NAME");
				String driverLastName = resultSet.getString("DRIVER_LAST_NAME");
				String driverLicense = resultSet.getString("DRIVER_LICENSE");
				String driverEgn = resultSet.getString("DRIVER_EGN");
				String vehicleRegistrationNumber = resultSet.getString("VEHICLE_REGISTRATION_NUMBER");
				Timestamp startDate = resultSet.getTimestamp("START_DATE");
				Timestamp endDate = resultSet.getTimestamp("END_DATE");
				long km = resultSet.getLong("KM");
				
				trip = new Trips(tripID, driverFirstName, driverLastName, driverLicense, driverEgn, vehicleRegistrationNumber, startDate, endDate, km);

				return trip;
			} else {
				throw new TripsException("���������� �� ���� �� �� ������!");
			}
			
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e) {
			throw new TripsException("�� ���� �� �� ������ �������� � ID " + tripID);
		}
		return trip;
	}

	/* (non-Javadoc)
	 * @see GeorgiPopov.TripsDAO#makeReport(java.lang.String)
	 */
	@Override
	public List<Trips> makeReport(String driverEGN) {
		List<Trips> reportList;
		
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl",
				"DSProject", "password")){
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			final String QUERY = "SELECT TRIP_ID, DRIVER_FIRST_NAME, DRIVER_LAST_NAME, DRIVER_LICENSE, "
							   + "DRIVER_EGN, VEHICLE_REGISTRATION_NUMBER, START_DATE, END_DATE, KM FROM TRIPS WHERE DRIVER_EGN = '" + driverEGN + "'";
			final String QUERYCOUNT = "SELECT COUNT(*) as count FROM TRIPS WHERE DRIVER_EGN = '" + driverEGN + "'";
			
			PreparedStatement prSt = connection.prepareStatement(QUERY);
			PreparedStatement prStCount = connection.prepareStatement(QUERYCOUNT);
			
			ResultSet resultSet = prSt.executeQuery();
			ResultSet rsCount = prStCount.executeQuery();
			
			rsCount.next();
			int count = rsCount.getInt("count");
			
			reportList = new ArrayList<Trips>(count);
			
			while(resultSet.next()){
				int tripID = resultSet.getInt("TRIP_ID");
				String driverFirstName = resultSet.getString("DRIVER_FIRST_NAME");
				String driverLastName = resultSet.getString("DRIVER_LAST_NAME");
				String driverLicense = resultSet.getString("DRIVER_LICENSE");
				String driverEgn = resultSet.getString("DRIVER_EGN");
				String vehicleRegistrationNumber = resultSet.getString("VEHICLE_REGISTRATION_NUMBER");
				Timestamp startDate = resultSet.getTimestamp("START_DATE");
				Timestamp endDate = resultSet.getTimestamp("END_DATE");
				long km = resultSet.getLong("KM");
				
				reportList.add(new Trips(tripID, driverFirstName, driverLastName, driverLicense, driverEgn, 
						            vehicleRegistrationNumber, startDate, endDate, km));
				
			}
			return reportList;
		} catch (Exception exp) {
			return new ArrayList<Trips>(0);
		}
	}
}