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
	public void insert(Drivers driver);
	public void delete(String driverEgn);
	public void update(Drivers driver);
	public Drivers search(String driverEgn);
	public String checkUser(String driverEgn);
}