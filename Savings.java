/***
 * Class to model the entity Savings
 * @author Warren Noubi
 * @version 0.1
 * Date of creation: 09/22/2022
 * Last Date Modified: 09/23/2022
 */
public class Savings extends BankAccount{
    // Data members
    private  double YearlyInterestRate;
    /***
     * Default constructor
     * No parameters

     */
    public Savings(String owner, double balance, double yearlyInterestRate) {
        super(owner, balance);
        this.YearlyInterestRate = yearlyInterestRate;

    }
    /***
     * Getters and tostring method
     * no parameters
     * @return formatted string containing the value of the data members
     */
    public Savings(long number,String owner, double balance, double yearlyInterestRate){
        super(number,owner, balance);
        this.YearlyInterestRate=yearlyInterestRate;

    }

    public double getYearlyInterestRate() {
        return YearlyInterestRate;
    }

    @Override
    public String getType() {
        return "Savings";
    }

    public void setYearlyInterestRate(double yearlyInterestRate) {

    }
    public double getMonthlyInterestRate() {

        return 0;
    }
    @Override
    public String toString(){
        return "Savings\t\t\t" + super.toString() + String.format("\t\t%.2f", getYearlyInterestRate());
                //+ String.format("%-10.2f\t%-30.2f\t%-10.2f", YearlyInterestRate, getMonthlyInterestRate());
    }
    public String simpleString(){

        return super.simpleString() + YearlyInterestRate;
    }

    @Override
    public double applyInterest() {
        double balancei = (balance * YearlyInterestRate / 12) / 100;
        this.balance=balancei+balance;
        return balancei;
    }

    @Override
    public double applyRisk() {
        System.out.println("your account is not of type Invesment");
        return Double.NaN;
    }

    @Override
    public boolean isClosable() {
        return false;
    }
}
