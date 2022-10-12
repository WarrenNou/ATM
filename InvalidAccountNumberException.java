/***
 * Class to model the entity Investment
 * @author Warren Noubi
 * @version 0.1
 * Date of creation: 09/22/2022
 * Last Date Modified: 09/23/2022
 */
import java.util.InputMismatchException;
public class InvalidAccountNumberException  extends InputMismatchException {
    public InvalidAccountNumberException(){

    }
    public InvalidAccountNumberException(String message) {
        super(message);

    }
    
}
