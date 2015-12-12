/**
 * 
 */
package Other;

/**
 * @author shenaikabilova
 *
 */
public class Validate {
	public boolean isvalidEGN (String egn) throws Exception{
		int[] weights = { 2, 4, 8, 5, 10, 9, 7, 3, 6 };

		int year = Integer.parseInt(egn.substring(0,2));
        int month = Integer.parseInt(egn.substring(2,4));
        int day = Integer.parseInt(egn.substring(4, 6));
        int checkSum  = 0;
         
        if(egn.length() != 10) {
                throw new Exception("��� ������ �� ���� � 10 �����!");
        }
        try {
                Long.parseLong(egn);
        } catch (NumberFormatException ex) {   
                throw new Exception("��� ������ �� ������� ���� �����!");
        }
        if(year < 0 || year > 99) {
        	throw new Exception("������ �� ������ ����� 00...99!");
        }
        if(month > 20 && month < 40) {
                month -= 20;
        } else if(month > 40) {
                month -=40;                     
        }
        if (month < 1 || month > 12) {
                throw new Exception("������� ������ �� ���� ����� 1...12!");
        }
        if(day < 1 || day > 31) {
                throw new Exception("������ ������ �� ���� ����� 1...31!");
        }
         
        for(int i = 0; i < egn.length() - 1; i++) {
                checkSum += (int)(egn.charAt(i) - '0')*weights[i];
        }
        checkSum %= 11;
        if(checkSum != (int)(egn.charAt(9) - '0')) {
                throw new Exception("��������� ��������� ����!");
        }
        return true;
    }
	
	public boolean isValidRegNumberVehicle (String regNumber){
		return regNumber.matches("^[�|�|�|��|��|��|��|��|�|��|��|�|��|��|��|��|��|�|��|��|��|��|[�|��|��]|��|�|�|�|�][1-9]{4}[�-�]{1,2}");
	}
}