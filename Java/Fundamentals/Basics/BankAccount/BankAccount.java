public class BankAccount {
    //VariableInstances: Belongs to BankAccount class
    private double checkingBalance;
    private double savingsBalance;
    //statics: belongs to BankAccount class
    public static int numberOfAccount = 0;
    public static double totalAmount = 0;

    public BankAccount(){
        this.checkingBalance = 0;
        this.savingsBalance = 0;
        BankAccount.numberOfAccount++;
    }
    /*---------------------------------------------------*/
    // Create a getter method for the user's checking + saving account balance.
    public double getCheckingBalance() {
        return this.checkingBalance;
    }
    public double getSavingsBalance() {
        return this.savingsBalance;
    }
    /*---------------------------------------------------*/
    //Create a method that will allow a user to deposit 
    //money into either the checking or saving, be sure to add to total amount stored.
    public void deposit(double amount, String typeOfAccount){
        //Check which account ++balance
        if (typeOfAccount == "checking"){
            this.checkingBalance += amount;
        }
        else {
            this.savingsBalance += amount;
        }
        this.totalAmount += amount;
        //or:
        // if(typeOfAccount.equals("savings"))
        // 			this.savingsBalance += amount;
        // 		else if(typeOfAccount.equals("checking"))
        // 			this.checkingBalance += amount;
        // 		BankAccount.totalAmount += amount;
        // 	}
    }
    //Create a method to withdraw money from one balance. Do not allow them to withdraw money 
    //if there are insufficient funds.
    public void withdraw(double amount, String typeOfAccount){
        boolean successful = false;
        if(typeOfAccount.equals("checking")) {
            //see if theres $$ in account
            if(this.checkingBalance - amount >= 0){
                successful = true;
                this.checkingBalance -= amount;
            }
        }else if(typeOfAccount.equals("savings")) {
            //see if enough in savings account
            if(this.savingsBalance - amount >= 0) {
                successful = true;
                this.savingsBalance -= amount;
            }
        }
        if(successful) {
            BankAccount.totalAmount -= amount;
        }
        else {
            System.out.println("Insufficient Funds");
        }
    }

    public void displayAccountBalance(){
        System.out.printf("Savings: $%.2f, Checking: $%.2f",this.savingsBalance, this.checkingBalance);
}





    


}