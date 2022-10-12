/***
 * Class to model the entity Investment
 * @author Warren Noubi
 * @version 0.1
 * Date of creation: 09/22/2022
 * Last Date Modified: 09/23/2022
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
public class Bank {// Data members
    private BankAccount [] accounts;
    private  int count;
    public Bank() {
        count = 0;
        accounts = new BankAccount[100];
        readAccount("accounts.txt");
    }
    public Bank( String filename){

    }
    //Creating methodes
    private void readAccount(String filename) { //this method read the data on the files
        try{
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine())
            {
                String input = scan.nextLine();
                String[] line = input.split("\\|");
                if(line[0].charAt(0) == 'S')
                {
                    accounts[count++] = new Savings(Long.parseLong(line[1]),line[2],Double.parseDouble(line[3]), Double.parseDouble(line[4]));
                }
                else if(line[0].charAt(0) == 'I')
                {

                    accounts[count++] = new Investment(Long.parseLong(line[1]),line[2],Double.parseDouble(line[3]),(line[4]));
                }
                else if (line[0].charAt(0) == 'C'){

                    accounts[count++] = new Checking(Long.parseLong(line[1]),line[2],Double.parseDouble(line[3]));
                }

            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public  BankAccount find(long number ){
        int num = 0;
        BankAccount [] list = new BankAccount[count];

        for(int i=0;i<count;i++)
            if(list[i].getNumber() == number)
                list[num++] = list[i];

        BankAccount[] list2 = new BankAccount[num];
        int w=0;
        for(int i=0;i<num;i++) {
            list2[i] = list[i];
            list[w] = list2[i];
        }

        return list[w];
    }
    public boolean add (BankAccount ba){
        accounts[count++] = ba;
        return false;
    }
    public boolean remove (long number){// methods to remove accounts


        int index = 0;
        for(index=0;index < accounts.length; index++)
        {
            if(accounts[index].getNumber()==(number))
                break;

            if(index == accounts.length - 1)
                index = -1;
        }

        try{
            if(index != -1)
            {
                for(int i=index+1;i<count;i++)
                    accounts[i-1] = accounts[i];
                System.out.println("account removed successfully.");
                count--;
            }
            else
                throw new Exception("account not found.");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public void viewAll(){// method to view all the data on the file
        System.out.println(String.format("\n\n%-20s%-10s%-30s%-10s%-10s",
                "Type","Number", "Owner", "Balance", "Interest/Investment"));
        for(int i=0;i<count;i++)
            System.out.println(accounts[i].toString());
           // System.out.printf("%-20s%-20s%-30s%-30s%-10s%n",
                //    accounts[i].getType() ,accounts[i].getNumber(), accounts[i].getOwner(), accounts[i].getBalance()+"$",accounts[i].getYearlyInterestRate());
    }
    public void viewClosable(){// method to return account with less than 200 dollars
for (int i = 0; i < count; i++) {
    if(accounts[i].getBalance()<200.0){
        System.out.println(accounts[i]);
    }
}
    }
    public void sort() { //method that sort the account depending on the balance

        for (int i = 0; i < count - 1; i++) {
            int max = i;
            for (int j = i+1; j < count; j++) {
                if (accounts[max].getBalance() < accounts[j].getBalance()) {
                    max = j;
                }
            }

            if (i != max) {
                BankAccount temp = accounts[i];
                accounts[i] = accounts[max];
                accounts[max] = temp;
            }
        }

    }
    public void saveAccount(String filename){// save the account which was added to the list
        try{
            FileOutputStream file = new FileOutputStream(filename);
            PrintWriter output = new PrintWriter(file);

            for(int i=0;i<count;i++)
                System.out.println(accounts[i].toString());
            output.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public BankAccount getAccount(long number){// get account number
        for (int i = 0; i < count; i++){
            if (accounts[i].getNumber() == number){
                return accounts[i];
            }

        }

        return null;
    }
    public void manageAcct(Scanner myScanner, Bank myBank) { // method managing the accounts
        int choice;
        BankAccount ba;
        long acct;

        do {
            System.out.println("Enter your account number");
            acct = (Long) myScanner.nextLong();
            ba = getAccount(acct);
            if (ba == null) {
                System.out.println("Invalid Account -- try again");
            }
        } while (ba == null);
        do {
            choice = manageAcctMenu(myScanner);
            switch (choice) {
                case 1:
                    ba = myBank.getAccount(acct);

                    System.out.println("balance = "+ ba.getBalance());
                    break;
                case 2:
                    ba = myBank.getAccount(acct);
                    System.out.println("Enter the amount you want to withdraw");
                    int amount =myScanner.nextInt();
                    ba.withdraw(amount);
                    if(ba.getBalance()>=0) {
                        System.out.println("successful withdraw, balance is :" + ba.getBalance());
                    }else if(ba.getBalance()<0){
                        System.out.println("Withdraw fail you don't have enough fund");
                    }
                    break;
                case 3:
                    ba = myBank.getAccount(acct);
                    System.out.println("Enter the amount you want to deposit");
                    int amounts =myScanner.nextInt();
                    ba.deposit(amounts);
                    System.out.println("Successful deposit, balance is:"+ ba.getBalance());
                    break;
                case 4:
                    ba = myBank.getAccount(acct);
                    if (ba.applyInterest()>=0) {
                        System.out.println("Interest rate applied. The amount: "+ ba.applyInterest());
                    }else {
                        System.out.print("");
                    }
                    break;
                case 5:
                    ba = myBank.getAccount(acct);
                    if (ba.applyRisk()>=0) {
                        System.out.println("Risk applied successfully\n"+"The amount: "+ ba.applyRisk());///
                    }else {
                        System.out.print("");
                    }
                    break;
                case 6 :
                    break;
            }
        } while (choice != 6);

    }
    public  int manageAcctMenu(Scanner myScan){
        System.out.println("Select an operation:");
        System.out.println("1: View Balance");
        System.out.println("2: Withdraw");
        System.out.println("3: Deposit");
        System.out.println("4: Monthly Interest");
        System.out.println("5: apply investment risk");
        System.out.println("6: Return to Main Menu");
        int choice = myScan.nextInt();
        return choice;
    }
public  String manage (){// method to add accounts
    Scanner myScan = new Scanner(System.in);
    double balance;
    String owner;
    long interest;
    String type;
    System.out.println("Enter account type (checking/savings/investment): ");
    String account=myScan.nextLine();

    if (account.equals("checking")){
        System.out.println("Enter name of the owner (first name and last name)");
        owner=myScan.nextLine();
        System.out.println("Enter account balance: ");
        balance=myScan.nextInt();

        accounts[count++]= new Checking((owner), (balance)) ;
    }else if (account.equals("savings")){
        System.out.println("Enter name of the owner (first name and last name)");
        owner=myScan.nextLine();
        System.out.println("Enter account balance: ");
        balance=myScan.nextInt();
        System.out.println("enter the interest");
        interest=myScan.nextLong();
        accounts[count++]= new Savings((owner), (balance),(interest)) ;}

    else if (account.equals("investment")) {
        System.out.println("Enter name of the owner (first name and last name)");
        owner = myScan.nextLine();

        System.out.println("Enter account balance: ");
        balance=myScan.nextInt();
        System.out.println("Type of investment: ");
        type=(myScan.next());
        count=50;
        accounts[count++]= new Investment((owner), (balance), (type));

    }else{System.out.println("error retry ");}

    return null;
}
}
