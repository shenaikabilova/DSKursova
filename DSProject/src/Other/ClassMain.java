package Other;

import javax.swing.SwingUtilities;

/**
 * 
 */

/**
 * @author shenaikabilova
 *
 */

public class ClassMain {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeLater(new WelcomeScreen());
		
//		String egn = new String("9312250955");
//		System.out.println(new Validate().isvalidEGN(egn));
//		String regNumber = new String("�1234ZZ");
//		System.out.println(new Validate().isValidRegNumberVehicle(regNumber));
	}
}