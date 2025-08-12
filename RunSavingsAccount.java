import java.util.Scanner;

public class RunSavingsAccount {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        SavingsAccount savings = new SavingsAccount();

        System.out.print("Enter interest rate: ");
        SavingsAccount.setInterestRate(sc.nextDouble());
        System.out.print("Enter deposit amount: ");
        savings.deposit(sc.nextDouble());
        System.out.println("Your balance is " + savings.getBalance());
        System.out.print("Press D for another deposit or W to withdraw: ");
        char press = Character.toUpperCase(sc.next().trim().charAt(0));

        if (press == 'D') {
            System.out.print("Enter deposit amount: ");
            savings.deposit(sc.nextDouble());

            if (savings.getBalance() > 1000) {
                savings.addInterest();
                System.out.print("Your new balance is " + savings.getBalance());
            }
        }

        else if (press == 'W') {
            System.out.print("Enter withdraw amount: ");
            double nobalanceinwithdraw = savings.withdraw(sc.nextDouble());
            if (nobalanceinwithdraw == 0) {
                System.out.print("Not enough balance!");
            }
            else {
                System.out.print("Your new balance is " + savings.getBalance());
            }
        }
    }
}

class SavingsAccount {
    private double balance = 0;
    public static double interestRate = 0;

    public static void setInterestRate(double newRate) {
        interestRate = newRate;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        }
        else if (amount ==0) {
        }
        return amount;
    }
    
    public void addInterest() {
        double interest = balance * interestRate;
        balance += interest;
    }

    public static void showBalance(SavingsAccount account) {
        System.out.printf("Your balance is %.2f\n", account.getBalance());
    }
    
}