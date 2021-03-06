package ShenaiKabilova;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
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
			
			final String QUERY = "SELECT DRIVER_FIRST_NAME, DRIVER_LAST_NAME, DRIVER_LICENSE, PASSWORD, DRIVER_EGN FROM DRIVERS";
			final String QUERY_COUNT = "SELECT COUNT(*) as count FROM DRIVERS";
			PreparedStatement pr = connection.prepareStatement(QUERY);
			PreparedStatement prCount = connection.prepareStatement(QUERY_COUNT);
			
			ResultSet resultSet = pr.executeQuery();
			ResultSet rsCount = prCount.executeQuery();
			
			rsCount.next();
			int count = rsCount.getInt("count");
			
			drivers = new ArrayList<Drivers>(count);
			
			while(resultSet.next()) {
				String driverFirstName = resultSet.getString("DRIVER_FIRST_NAME");
				String driverLastName = resultSet.getString("DRIVER_LAST_NAME");
				String driverLicense = resultSet.getString("DRIVER_LICENSE");
				String password = resultSet.getString("PASSWORD");
				String driverEGN = resultSet.getString("DRIVER_EGN");
				
				drivers.add(new Drivers(driverFirstName, driverLastName, driverLicense, password, driverEGN));
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
	public void insert(Drivers driver) throws DriverErrorException {
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl",
				"DSProject", "password")){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			final String QUERY = "INSERT INTO DRIVERS (DRIVER_FIRST_NAME, DRIVER_LAST_NAME, DRIVER_LICENSE, PASSWORD, DRIVER_EGN) VALUES(?,?,?,?,?)";
			PreparedStatement pr = connection.prepareStatement(QUERY);
			
			pr.setString(1, driver.getDriverFirstName());
			pr.setString(2, driver.getDriverLastName());
			pr.setString(3, driver.getDriverLicense());
			pr.setString(4, driver.getPassword());
			pr.setString(5, driver.getEgn());
			
			pr.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLIntegrityConstraintViolationException e){
			throw new DriverErrorException("���� ��� ���� ����������!");
		}catch (SQLException e) {
			throw new DriverErrorException("�������� �� ���� �� �� ������!");
		}
	}

	/* (non-Javadoc)
	 * @see DriverDAO#delete(int)
	 */
	@Override
	public void delete(String driverEgn) throws DriverErrorException {
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl",
				"DSProject", "password")){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			final String QUERY = "DELETE FROM DRIVERS WHERE DRIVER_EGN = '" + driverEgn + "'";
			PreparedStatement pr = connection.prepareStatement(QUERY);
			
			pr.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			throw new DriverErrorException("�������� �� ���� �� �� ������!");
		}
	}

	/* (non-Javadoc)
	 * @see DriverDAO#update(Drivers)
	 */
	@Override
	public void update(Drivers driver) throws DriverErrorException {
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl",
				"DSProject", "password")){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			PreparedStatement pr = connection.prepareStatement("UPDATE DRIVERS SET DRIVER_FIRST_NAME = ?,"
					+ "DRIVER_LAST_NAME = ?, DRIVER_LICENSE = ?, PASSWORD = ?, DRIVER_EGN = ? WHERE DRIVER_EGN = '" + driver.getEgn()+"'");
			
			pr.setString(1, driver.getDriverFirstName());
			pr.setString(2, driver.getDriverLastName());
			pr.setString(3, driver.getDriverLicense());
			pr.setString(4, driver.getPassword());
			pr.setString(5, driver.getEgn());
			
			pr.executeUpdate();
					
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLIntegrityConstraintViolationException e){
			throw new DriverErrorException("���� ��� ���� ����������!");
		} catch (SQLException e) {
			throw new DriverErrorException("�������� �� ���� �� �� �������!");
		}
	}

	/* (non-Javadoc)
	 * @see DriverDAO#search(int)
	 */
	@Override
	public Drivers search(String driverEgn) throws DriverErrorException {
		Drivers driver = new Drivers();
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl",
				"DSProject", "password")){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			final String QUERY = "SELECT DRIVER_FIRST_NAME, DRIVER_LAST_NAME, DRIVER_LICENSE, PASSWORD FROM DRIVERS WHERE DRIVER_EGN = '" + driverEgn + "'";
			
			PreparedStatement pr = connection.prepareStatement(QUERY);
			ResultSet resultSet = pr.executeQuery();
			
			if(resultSet.next()){
				String firstName = resultSet.getString("DRIVER_FIRST_NAME");
				String lastName = resultSet.getString("DRIVER_LAST_NAME");
				String license = resultSet.getString("DRIVER_LICENSE");
				String password = resultSet.getString("PASSWORD");
				
				driver = new Drivers(firstName, lastName, license, password, driverEgn);
				
				return driver;
			}
			else {
				throw new DriverErrorException("������ � ��� " + driverEgn + " �� ���� �� �� ������!");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			throw new DriverErrorException("������ � ��� " + driverEgn + " �� ���� �� �� ������!"); 
		}
		return driver;
	}
	
	public String checkUser(String driverEgn){
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl",
				"DSProject", "password")){
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			final String QUERY = "SELECT PASSWORD FROM DRIVERS WHERE DRIVER_EGN = '" + driverEgn + "'";
			PreparedStatement pr = connection.prepareStatement(QUERY);
			ResultSet rs = pr.executeQuery();
			
			if(rs.next()){
				String pass = rs.getString("PASSWORD");
				
				return pass;
			}
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return null;
	}
}