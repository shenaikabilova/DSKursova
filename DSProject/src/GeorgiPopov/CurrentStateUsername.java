/**
 * 
 */
package GeorgiPopov;

/**
 * @author shenaikabilova
 *
 */
public class CurrentStateUsername {
	private static String currentUsername;

	public CurrentStateUsername () {

	}

	public CurrentStateUsername (String currentUsername){
		CurrentStateUsername.currentUsername = currentUsername;
	}
	
	public String getCurrentUsername() {
		return currentUsername;
	}

	public void setCurrentUsername(String currentUsername) {
		CurrentStateUsername.currentUsername = currentUsername;
	}
}