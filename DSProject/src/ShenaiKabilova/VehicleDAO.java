package ShenaiKabilova;
import java.util.List;

/**
 * @author shenaikabilova
 *
 */

public interface VehicleDAO {
	public List<Vehicles> listVehicles();
	public void insert(Vehicles vehicle) throws VehicleErrorException;
	public void delete(String regNumber) throws VehicleErrorException;
	public void update(Vehicles vehicle) throws VehicleErrorException;
	public Vehicles search(String regNumber) throws VehicleErrorException;
	public List<String> searchVehicle (String license);
}