/***
 * Class to model the entity Investment
 * @author Warren Noubi
 * @version 0.1
 * Date of creation: 09/22/2022
 * Last Date Modified: 09/23/2022
 */
public class Investment extends BankAccount{
    // Data members
    private String type;
    /***
     * Default constructor
     * No parameters

     */
    public Investment(String owner, double balance,String type){
        super(owner, balance);
        this.type = type;

    }
    public Investment(long number, String owner, double amount, String type) {
        super(number,owner, amount);
        this.type= type;
    }
    /***
     * Getters and tostring method
     * no parameters
     * @return formatted string containing the value of the data members
     */
    public  String getType() {
        return type;
    }
    public String getTypes() {
        return type;

    }

    public void setType(String type) {
        this.type = type;
    }
    public double applyRisk(){
    double balances=balance*0.5;
        return balances;
    }

    @Override
    public double getYearlyInterestRate() {
        return 0;
    }

    public String toString() {

        return "Investment\t\t" + super.toString() + "\t  " + getType();
    }
    public String simpleString(){

        return super.simpleString() + type;

          
    }

    @Override
    public double applyInterest() {
    System.out.println("your account is not of type savings");
        return Double.NaN ;
    }

    @Override
    public boolean isClosable() {
        return false;
    }
}
