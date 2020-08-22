public class BankAccount{
    private double balance = 0;
    private double fee = 0.50;
    private int transactions;
    private double free = 10;
    
// Constructors  
    //initializes bank account to $0
    public BankAccount(){
        this.balance = 0;
        transactions = 0;
    }

    //Initializes bank account with input parameter
    public BankAccount(double initialBalance){
        this.balance = initialBalance;
        transactions = 0;
    }
// Methods

    //Deposit money into bank account, and tallys transaction
    public void deposit(double amount){
        this.balance += amount;
        this.transactions++;
        System.out.println("New Balance: " + balance);
    }

    //Withdraw money from bank account, and tallys transaction
    public void withdraw(double amount){
        this.balance -= amount;
        this.transactions++;
        System.out.println("New Balance: " + balance);
    }

    //Returns balance of bank account
    public double getBalance(){
        return balance;
    }

    //Deducts balance from account due to going over the limit of free monthly transactions
    public void deductMonthly(){
        double charges = Math.max(transactions, free) - free;
        for(int i = 0; i < charges; i++){
            this.balance -= fee;
        }
        System.out.println("New Balance after monthly fees: " + balance);
        this.transactions = 0;
    }

    //Changes transaction fee to user-input value
    public void setFee(double newFee){
        this.fee = newFee;
    }
    //Changes number of free transactions allowed per month
    public void setFreeLimit(double newFree){
        this.free = newFree;
    }
}