/**
 * 
 */
package ShenaiKabilova;

/**
 * @author shenaikabilova
 *
 */
public class VehicleErrorException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VehicleErrorException(){
		super();
	}
	
	public VehicleErrorException(String message) {
		super(message);
	}
}