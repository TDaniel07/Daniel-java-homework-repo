public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount("Daniel", 1, 100);
        BankAccount bankAccount2 = new BankAccount("Alex", 2, 200);

        bankAccount1.deposit(400);
        System.out.println(bankAccount1.getBalance());
        bankAccount1.withdraw(100);
        System.out.println(bankAccount1.getBalance());

        System.out.println(bankAccount2.getBalance());
        bankAccount1.transferFunds(bankAccount2, 200);
        System.out.println(bankAccount2.getBalance());
        System.out.println(bankAccount1.getBalance());
    }
}