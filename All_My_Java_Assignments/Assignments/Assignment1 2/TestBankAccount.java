public class TestBankAccount{
    public static void main(String[] args){
        BankAccount acc = new BankAccount(200);
        acc.deposit(650);
        acc.withdraw(300);
        acc.withdraw(400);
        acc.deposit(60);
        acc.deposit(1500);
        acc.withdraw(900);
        acc.withdraw(100);
        acc.deposit(220);
        acc.deposit(100);
        acc.withdraw(100);
        acc.withdraw(500);
        acc.deposit(100);
        acc.deductMonthly();
        acc.setFee(1.25);
        acc.setFreeLimit(3);
        acc.deposit(600);
        acc.withdraw(500);
        acc.withdraw(100);
        acc.deposit(5);
        acc.deposit(50);
        acc.deposit(90);
        acc.deductMonthly();
        acc.deposit(5000);
        acc.withdraw(4500);
        acc.deductMonthly();
    }
}