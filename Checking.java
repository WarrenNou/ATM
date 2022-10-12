/***
 * Class to model the entity Checking account
 * @author Warren Noubi
 * @version 0.1
 * Date of creation: 09/22/2022
 * Last Date Modified: 09/22/2022
 */
public class Checking extends BankAccount{
    // Data members
    /***
     * Default constructor
     * No parameters

     */
    public Checking(String owner, double balance ) {
        super(owner, balance);
        owner="o";


    }
    public Checking(long number, String owner, double balance){
        super(number,owner, balance);
        /***
         * tostring method
         * no parameters
         * @return formatted string containing the value of the data members
         */
    }
    public String toString() {

        return "Checking\t\t" + super.toString();

    }
    public String simpleString(){

        return super.simpleString();
    }

    @Override
    public double applyInterest() {
        System.out.println("your account is not of type savings");
        return Double.NaN ;
    }

    @Override
    public double applyRisk() {
        System.out.println("your account is not of type Investment");
        return Double.NaN ;
    }

    @Override
    public double getYearlyInterestRate() {
        return 0;
    }

    @Override
    public String getType() {
        return "Checking";
    }

    @Override
    public boolean isClosable() {
        return false;
    }
}
