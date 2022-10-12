/***
 * Class to model the entity BankAccount
 * @author Warren Noubi
 * @version 0.1
 * Date of creation: 09/22/2022
 * Last Date Modified: 09/23/2022
 */
abstract class BankAccount implements Closable{
    // Data members
    private long number;
    private  String owner;
    protected double balance;
    /***
     * Default constructor
     * No parameters
     * @param amount
     * @param owner2


     */
    public BankAccount( String owner2, double amount) {
        number=(long) (Math.random() * 999999999);
        this.owner = owner2;
        this.balance = amount;

    }
    /***
     * Constructor with six parameters
     * @param	owner for the account holder
     * @param	balance for the balance

     */
    public BankAccount(long number,String owner, double balance){
        this.number=number;
        this.owner=owner;
        this.balance=balance;

    }
    /***
     * Getters and tostring method
     * no parameters
     * @return formatted string containing the value of the data members
     */
    public String getOwner() {
        return owner;
    }

    public long getNumber() {
        return number;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount){
        balance=balance+amount;

    }
    public  boolean withdraw(double amount){
        balance=balance-amount;

        return false;
    }
    @Override
    public String toString(){
        return String.format("%-10d\t%-30s\t%-10.2f",
               number, owner, balance);
    }
    public String simpleString(){

        return String.format("%-10d\t%-30s\t%-10.2f",number + "|" + owner + "|" + balance+ "|");
    }
public int compareTo(BankAccount ba){

    return 0;
}
    public abstract double applyInterest();
    public abstract double applyRisk();
    public abstract double getYearlyInterestRate() ;
    public abstract String getType();

}
