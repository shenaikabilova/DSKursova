package ShenaiKabilova;
import java.util.List;

/**
 * 
 */

/**
 * @author shenaikabilova
 *
 */
public interface DriverDAO {
	public List<Drivers> listDrivers();
	public void insert(Drivers driver) throws DriverErrorException;
	public void delete(String driverEgn) throws DriverErrorException;
	public void update(Drivers driver) throws DriverErrorException;
	public Drivers search(String driverEgn) throws DriverErrorException;
	public String checkUser(String driverEgn);
}