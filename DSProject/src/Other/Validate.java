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
                throw new Exception("ЕГН трябва да бъде с 10 числа!");
        }
        try {
                Long.parseLong(egn);
        } catch (NumberFormatException ex) {   
                throw new Exception("ЕГН трябва да съдържа само числа!");
        }
        if(year < 0 || year > 99) {
        	throw new Exception("Очаква се година между 00...99!");
        }
        if(month > 20 && month < 40) {
                month -= 20;
        } else if(month > 40) {
                month -=40;                     
        }
        if (month < 1 || month > 12) {
                throw new Exception("Месецът трябва да бъде между 1...12!");
        }
        if(day < 1 || day > 31) {
                throw new Exception("Датата трябва да бъде между 1...31");
        }
         
        for(int i = 0; i < egn.length() - 1; i++) {
                checkSum += (int)(egn.charAt(i) - '0')*weights[i];
        }
        checkSum %= 11;
        if(checkSum != (int)(egn.charAt(9) - '0')) {
                throw new Exception("Невалидна контролна сума!");
        }
        return true;
    }
	
	public boolean isValidRegNumberVehicle (String regNumber){
		return regNumber.matches("^[Е|А|В|ВТ|ВН|ВР|ЕВ|ТХ|К|КН|ОВ|М|РА|РК|ЕН|РВ|РР|Р|СС|СН|СМ|СО|[С|СА|СВ]|СТ|Т|Х|Н|У][1-9]{4}[A-Z]{1,2}");
	}
}