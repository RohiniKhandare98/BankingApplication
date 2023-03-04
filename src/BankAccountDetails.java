package org.example;

import java.util.HashMap;

class BankAccountDetails {

    // Account Number and Account Holder name is Stored
    public static HashMap<String , String> accNumber_AccHolderName = new HashMap<>() ;

    // Account Number and Account total balance is Stored
    public static HashMap<String , Integer> accNumber_accBalance = new HashMap<>();
    private String accountNumber;
    private String accountHolderName;
    private int accountBalance ;
    private int depositAmount;
    private int withdrawAmount;

    public BankAccountDetails(String accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountBalance =0;

    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public BankAccountDetails() {

    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public int getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(int depositAmount) {
        this.depositAmount = depositAmount;
    }

    public int getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(int withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }


    // On CREATE , Account will be Created by CreateAccount
    public void createAccount(String accountNumber , String accountHolderName) {

        try{
            if(!isAccExist(accountNumber)){  // creates new account only when account not exists
                accNumber_AccHolderName.put(accountNumber ,accountHolderName);
                accNumber_accBalance.put(accountNumber , 0);
                System.out.println(" Account Created Successfully!....");

            }
            else{
                throw new IllegalAccessException();
            }
        }
        catch (IllegalAccessException e){
            System.out.println("Account Number: "+accountNumber +" Already Exist , Account NOT Be Created");
        }
    }


    // on DEPOSIT , money gets Deposited by depositAmount
    void depositAmount(String accountNumber , int amountToBeDeposited) {

        try{
            if(isAccExist(accountNumber)){   // Money will be deposited Only when Account is Exists.
                accNumber_accBalance.put(accountNumber , accNumber_accBalance.get(accountNumber) + amountToBeDeposited);
                System.out.println(" Amount Deposited Successfully!....");
            }
            else{
                throw new IllegalAccessException();
            }
        }
        catch(IllegalAccessException e){
            System.out.print(" Account Does Not Exists , Money will be Not deposited");
        }

    }


    // on WITHDRAW , money gets Withdrawn by withdrawAmount
    public void withdrawAmount(String accountNumber , int Withdraw) {
        int balance = accNumber_accBalance.get(accountNumber);

        try{
            if (isAccExist(accountNumber)) {    // first case : is Account Number Exist or Not
                if(balance > Withdraw) {    // Second Case : is Balance is greater than Withdraw Amount

                    accNumber_accBalance.put(accountNumber, accNumber_accBalance.get(accountNumber) - Withdraw);
                    System.out.println(" Amount Withdrawn Successfully!....");
                }
                else {

                    throw new IllegalAccessException();  //  exception called when account Not Exist
                }
            }
            else{
                throw new IllegalCallerException(); // Exception called when Insufficient Balance
            }
        }
        catch (IllegalCallerException e){
            System.out.println("Account Does Not Exists , Hence Money could Not withdrawn");
        }
        catch(IllegalAccessException e){
            System.out.println("Insufficient Account Balance , Money will Not Be WithDrawn");
        }
    }


    // on BALANCE , Total Account Balance is Displayed
    public  void showBalance(String accountNumber) {
        try{
            if(isAccExist(accountNumber)){  // show balance only when Account is Exists
                int balance = accNumber_accBalance.get(accountNumber);
                String holderName= accNumber_AccHolderName.get(accountNumber);
                System.out.println(holderName + " " + balance);   // prints balance ex. (ROHINI  ACC0001)
            }
            else{
                throw new IllegalAccessException();
            }
        }
        catch(IllegalAccessException e){
            System.out.print(" Account Does Not Exists ,Please Enter Correct Account Number");
        }
    }

    // checks that Account exists or Not with Given Account Number.
    boolean isAccExist(String accountNumber){
        if(accNumber_AccHolderName.containsKey(accountNumber)){
            return true;  // if Account Number is contains in HashMap then return true
        }
        else{
            return false;
        }

    }
}
