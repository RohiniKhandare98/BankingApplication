package org.example;
import java.util.Scanner;

public class BankingApplication {

    public static String accountNumber;
    public static String accountHolderName;
    public static void main(String[] args)  throws Exception{

        BankAccountDetails bank = new BankAccountDetails(accountNumber , accountHolderName);  // here we access the BankAccountDetails
        Scanner sc = new Scanner(System.in); // used Scanner Class for User Input

        //Follow GuidLines Down Below
        System.out.println("....Welcome to Baking Application ......\n");
        System.out.println("Follow GuidLined Down Below ...");
        System.out.println("For CREATE: AccountNumber follwed By Account Holder Name->(Ex. ACC001 ROHINI)");
        System.out.println("For DEPOSIT: AccountNumber follwed By deposit Amount->(Ex. ACC001 3000)");
        System.out.println("For WITHDRAW: AccountNumber follwed By withdraw Amount->(Ex. ACC001 1000)");
        System.out.println("For BALANCE: Only AccountNumber ->(Ex. ACC001)");
        System.out.println("lets Use Banking Application ....");

        while(true){             // infinte loop Because user can add multiple random commands here
            String input = sc.nextLine();        // taking user input as String
            String[] details = input.split(" ");         // spliting String into action And Details and Stored in String Array
            String action = details[0];       // first Word of String is Action to be Performed
            System.out.println();
            switch (action){          //based on Actions we use switch cases .
                case "CREATE" :
                    accountNumber = details[1];
                    accountHolderName = details[2];
                    bank.createAccount(accountNumber , accountHolderName);   //createAccount called from BankAccountDetails
                    break;

                case "DEPOSIT" :
                    accountNumber =details[1];
                    int deposit = Integer.parseInt(details[2]);  // parsing String into int
                    bank.depositAmount(accountNumber , deposit);   //depositAmount called from BankAccountDetails
                    break;

                case "WITHDRAW" :
                    accountNumber = details[1];
                    int withdraw = Integer.parseInt(details[2]);  // parsing String into int
                    bank.withdrawAmount(accountNumber , withdraw);    //withdrawAmount called from BankAccountDetails
                    break;

                case "BALANCE" :
                    accountNumber = details[1];
                    bank.showBalance(accountNumber);   //showBalance called from BankAccountDetails
                    break;

                default:
                    System.out.println("Please Enter Valid Actions to be performed in Banking Application ...");
            }
        }

        System.out.println("THANK YOU");

    }
}


