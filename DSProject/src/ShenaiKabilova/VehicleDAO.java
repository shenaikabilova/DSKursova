package ShenaiKabilova;
import java.util.List;

/**
 * @author shenaikabilova
 *
 */

public interface VehicleDAO {
	public List<Vehicles> listVehicles();
	public void insert(Vehicles vehicle);
	public void delete(String regNumber);
	public void update(Vehicles vehicle);
	public Vehicles search(String regNumber);
}