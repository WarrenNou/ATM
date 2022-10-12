/***
 * Class to model the entity Investment
 * @author Warren Noubi
 * @version 0.1
 * Date of creation: 09/22/2022
 * Last Date Modified: 09/23/2022
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BankManager {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int choice;
        int count = 0;
        Bank bank = new Bank();
        BankAccount[] bankAccounts;

        /***
         Creating the condition to print out the different cases
         */
        System.out.println("Welcome to Lehigh University Bank");
        do {
            choice = bankMenu(myScanner);

            switch (choice) {
                case 1:
                    bank.viewAll();
                    break;
                case 2:
                    bank.manageAcct(myScanner,bank);
                    break;
                case 3:
                    bank.manage();

                    break;
                case 4:
                    System.out.println("Enter the account number");
                    bank.remove(myScanner.nextLong());
                    break;
                case 5:
                    bank.sort();
                    bank.viewAll();
                    break;
                case 6:
                    bank.viewClosable();
                    break;
                case 7:
                    bank.saveAccount("accounts.txt");
                    System.out.println("Thank you");
            }
        } while (choice != 7);
    }

    public static int bankMenu(Scanner myScan) { // the table to help the user selecting the different operation to do
        System.out.println(" ");
        System.out.println("Select an operation:");
        System.out.println("1: View all accounts ");
        System.out.println("2: manage account ");
        System.out.println("3: add new  account ");
        System.out.println("4: remove account ");
        System.out.println("5: Sorts accounts by balance ");
        System.out.println("6:View closable accounts");
        System.out.println("7: Exit ");
        int choice = myScan.nextInt();
        return choice;
    }




}
