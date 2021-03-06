/**
 * 
 */
package GeorgiPopov;

import java.util.List;

/**
 * @author shenaikabilova
 *
 */
public interface TripsDAO {
	public List<Trips> loadAll ();
	public void insert(Trips trip) throws TripsException;
	public void update (Trips trip) throws TripsException;
	public void delete (int tripID) throws TripsException;
	public Trips search (int tripID) throws TripsException;
	public List<Trips> makeReport(String driverEGN);
}