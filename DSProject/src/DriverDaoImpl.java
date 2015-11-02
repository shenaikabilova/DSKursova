import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author shenaikabilova
 *
 */
public class DriverDaoImpl implements DriverDAO {
	
	/* (non-Javadoc)
	 * @see DriverDAO#listDrivers()
	 */
	@Override
	public List<Drivers> listDrivers() {
		List<Drivers> drivers = null;
		
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl",
				"DSProject", "password")){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			final String QUERY = "SELECT DRIVER_ID, DRIVER_FIRST_NAME, DRIVER_LAST_NAME, DRIVER_LICENSE FROM DRIVERS";
			final String QUERY_COUNT = "SELECT COUNT(*) as count FROM DRIVERS";
			PreparedStatement pr = connection.prepareStatement(QUERY);
			PreparedStatement prCount = connection.prepareStatement(QUERY_COUNT);
			
			ResultSet resultSet = pr.executeQuery();
			ResultSet rsCount = prCount.executeQuery();
			
			rsCount.next();
			int count = rsCount.getInt("count");
			
			drivers = new ArrayList<Drivers>(count);
			
			while(resultSet.next()) {
				int driverID = resultSet.getInt("DRIVER_ID");
				String driverFirstName = resultSet.getString("DRIVER_FIRST_NAME");
				String driverLastName = resultSet.getString("DRIVER_LAST_NAME");
				String driverLicense = resultSet.getString("DRIVER_LICENSE");
				
				drivers.add(new Drivers(driverFirstName, driverLastName, driverLicense, driverID));
			}
			
			return drivers;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return drivers;
	}

	/* (non-Javadoc)
	 * @see DriverDAO#insert(Drivers)
	 */
	@Override
	public void insert(Drivers driver) {
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl",
				"DSProject", "password")){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			final String QUERY = "INSERT INTO DRIVERS (DRIVER_FIRST_NAME, DRIVER_LAST_NAME, DRIVER_LICENSE, DRIVER_ID) VALUES(?,?,?,?)";
			PreparedStatement pr = connection.prepareStatement(QUERY);
			
			pr.setString(1, driver.getDriverFirstName());
			pr.setString(2, driver.getDriverLastName());
			pr.setString(3, driver.getDriverLicense());
			pr.setInt(4, driver.getDriverID());
			
			pr.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see DriverDAO#delete(int)
	 */
	@Override
	public void delete(int driverID) {
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl",
				"DSProject", "password")){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			final String QUERY = "DELETE FROM DRIVERS WHERE DRIVER_ID = '" + driverID + "'";
			PreparedStatement pr = connection.prepareStatement(QUERY);
			
			pr.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see DriverDAO#update(Drivers)
	 */
	@Override
	public void update(Drivers driver) {
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl",
				"DSProject", "password")){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			PreparedStatement pr = connection.prepareStatement("UPDATE DRIVERS SET DRIVER_FIRST_NAME = ?,"
					+ "DRIVER_LAST_NAME = ?, DRIVER_LICENSE = ? WHERE DRIVER_ID = " + driver.getDriverID());
			
			pr.setInt(1, driver.getDriverID());
			pr.setString(2, driver.getDriverFirstName());
			pr.setString(3, driver.getDriverLastName());
			pr.setString(4, driver.getDriverLicense());
			
			pr.executeUpdate();
					
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see DriverDAO#search(int)
	 */
	@Override
	public Drivers search(int driverID) {
		Drivers driver = new Drivers();
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl",
				"DSProject", "password")){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			final String QUERY = "SELECT DRIVER_FIRST_NAME, DRIVER_LAST_NAME, DRIVER_LICENSE, DRIVER_ID"
					+ "FROM DRIVERS WHERE DRIVER_ID = '" + driverID + "'";
			
			PreparedStatement pr = connection.prepareStatement(QUERY);
			ResultSet resultSet = pr.executeQuery();
			
			if(resultSet.next()){
				String firstName = resultSet.getString("DRIVER_FIRST_NAME");
				String lastName = resultSet.getString("DRIVER_LAST_NAME");
				String license = resultSet.getString("DRIVER_LICENSE");
				
				driver = new Drivers(firstName, lastName, license, driverID);
				
				return driver;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return driver;
	}
}