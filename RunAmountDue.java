import java.util.Scanner;

class AmountDue {

    double computeAmountDue(double price) {
        return price + (price * 0.12);
    }

    double computeAmountDue(double price, double quantity) {
        double total = price * quantity;
        double totaldue = total + (total * 0.12);
        return totaldue;
    }

    double computeAmountDue(double price, double quantity, double discountamount) {
        double total = quantity * price - discountamount;
        double totaldue = total + (total * 0.12);
        return totaldue;
    }
}

public class RunAmountDue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AmountDue due = new AmountDue();

        while (true) { // para mag loop if hindi 1/2/3 ang pinili ng user

        System.out.println("Press any of the following then enter values separated by spaces: ");
        System.out.println("1 - Price only");
        System.out.println("2 - Price and quantity");
        System.out.println("3 - Price, quantity, and discount amount");

        int press = sc.nextInt();

        double pressamount;

        switch (press) {

            case 1:
            System.out.print("");
            double price = sc.nextDouble();
            pressamount = due.computeAmountDue(price);
            break;

            case 2:
            System.out.print("");
            double price2 = sc.nextDouble();
            int quantity = sc.nextInt();
            pressamount = due.computeAmountDue(price2, quantity);
            break;

            case 3:
            System.out.print("");
            double price3 = sc.nextDouble();
            int quantity2 = sc.nextInt();
            double discountamount = sc.nextDouble();
            pressamount = due.computeAmountDue(price3, quantity2, discountamount);
            break;

            // if mag eenter ang user ng apat, hindi to masasama sa computation at answer, yung tatlo lang ma coconsider. 

            default:
            System.out.println("Please choose from 1-3 only.");
            continue;
        }

            System.out.printf("Amount due is %.1f\n", pressamount); 
            break; // para mag stop na ang loop
        }  
    }
}