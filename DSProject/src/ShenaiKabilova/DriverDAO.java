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
	public void delete(long driverEgn);
	public void update(Drivers driver);
	public Drivers search(long driverEgn);
}