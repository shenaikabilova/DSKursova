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
	public void delete(int driverID);
	public void update(Drivers driver);
	public Drivers search(int driverID);
}