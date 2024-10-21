public class BankAccount {
    private String accountHolderName;
    private int accountNumber;
    private double balance;

    public BankAccount(String accountHolderName, int accountNumber, double balance){
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount){
        if(amount <= 0)
            throw new IllegalArgumentException("amount must be positive integer");
        balance += amount;
    }

    public void withdraw(double amount){
        if(amount <= 0 || amount > balance)
            throw new IllegalArgumentException("amount must be positive integer and smaller than balance");

        balance -= amount;
    }

    public double getBalance(){
        return balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void getAccountDetails(){
        System.out.println("account holder name: " + accountHolderName);
        System.out.println("account number: " + accountNumber);
    }

    public void transferFunds(BankAccount targetAccount, double amount){
        if(amount > balance)
            throw new IllegalArgumentException("amount must be smaller than or equal to the current balance");
        withdraw(amount);
        targetAccount.deposit(amount);
    }

}
