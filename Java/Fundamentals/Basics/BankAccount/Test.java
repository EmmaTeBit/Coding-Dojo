
public class Test {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        account1.deposit(100, "checking");
        account1.deposit(200, "savings");

        System.out.println(account1.getCheckingBalance());
        System.out.println(account1.getSavingsBalance());
        // account1.withdraw(100, "checking");
        account1.displayAccountBalance();





    }
}
