import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Chatbot {
    static HashMap<String, String> orders = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Welcome to the GrowSorry Store Chatbot! \nWhat's your name? ");
        String name = sc.nextLine();

        System.out.println("\nHello, " + name + "! How can I assist you today?");
        
        String choice;

        while (true) {
            System.out.println("\nYou can ask for the following:");
            System.out.println("- Store Hours");
            System.out.println("- Store Location");
            System.out.println("- List of Products");
            System.out.println("- Order Products");
            System.out.println("- Track Order");
            System.out.println("- Exit");
            System.out.print("Type: ");
            choice = sc.nextLine().trim().toLowerCase();

            if (choice.equals("store hours")) {
                System.out.println("\nMonday to Friday - 7:00 AM to 10:00 PM \nSaturday - 7:00 AM to 12:00 AM \nSunday - 7:00 AM to 10:00 PM");
            } else if (choice.equals("store location")) {
                System.out.println("\nOur store is located at Rublou Market Place, Cainta, Rizal.");
            } else if (choice.equals("list of products")) {
                productList();
            } else if (choice.equals("order products")) {
                order(name);
            } else if (choice.equals("track order")) {
                track();
            } else if (choice.equals("exit")) {
                System.out.println("\nThank you for visiting GrowSorry Store, " + name + "! Have a great day!");
                break; 
            } else {
                System.out.println("\nSorry, I did not understand that. Please try again.");
            }
        }
    }

    public static void productList() {
        System.out.println("\nHere are the products we have:");

        System.out.println("\nFruits:");
        String[] prutas = {"Apple - PHP 30", "Banana - PHP 50", "Cherry - PHP 80", "Orange - PHP 30", "Grapes - PHP 80", "Mango - PHP 95", "Pineapple - PHP 100", "Strawberry - PHP 150", "Watermelon - PHP 200", "Peach - PHP 100"};
        for (String fruit : prutas) {
            System.out.println("- " + fruit);
        }

        System.out.println("\nVegetables:");
        String[] gulay = {"Carrot - PHP 30", "Broccoli - PHP 50", "Spinach - PHP 40", "Potato - PHP 50", "Tomato - PHP 60", "Onion - PHP 40", "Lettuce - PHP 65", "Cucumber - PHP 50", "Cauliflower - PHP 80", "Pumpkin - PHP 65"};
        for (String vegetable : gulay) {
            System.out.println("- " + vegetable);
        }

        System.out.println("\nDrinks:");
        String[] inumin = {"Water - PHP 30", "Orange Juice - PHP 50", "Apple Juice - PHP 50", "Milk - PHP 60", "Lemonade - PHP 30", "Coca-Cola - PHP 60", "Pepsi - PHP 50", "Iced Tea - PHP 40", "Coffee - PHP 60", "Energy Drink - PHP 50"};
        for (String drink : inumin) {
            System.out.println("- " + drink);
        }

        System.out.println("\nAlcoholic Drinks:");
        String[] tagay = {"Beer (Bottle) - PHP 60", "Red Wine (750ml) - PHP 400", "White Wine (750ml) - PHP 450", "Whiskey (500ml) - PHP 800", "Vodka (500ml) - PHP 600", "Gin (500ml) - PHP 500", "Tequila (750ml) - PHP 900", "Champagne (Bottle) - PHP 1200"};
        for (String alcohol : tagay) {
            System.out.println("- " + alcohol);
        }

        System.out.println("\nSnacks:");
        String[] snacks = {"Chips - PHP 25", "Cookies - PHP 50", "Chocolate - PHP 60", "Candy - PHP 15", "Popcorn - PHP 40", "Biscuits - PHP 35", "Pretzels - PHP 45", "Nuts - PHP 55", "Granola Bars - PHP 40", "Ice Cream - PHP 120"};
        for (String snack : snacks) {
            System.out.println("- " + snack);
        }

        System.out.println("\nDairy:");
        String[] dairy = {"Cheese - PHP 120", "Butter - PHP 80", "Yogurt - PHP 50", "Milk - PHP 60", "Cream - PHP 75", "Cottage Cheese - PHP 100", "Ice Cream - PHP 120", "Eggs - PHP 40", "Milk Powder - PHP 150", "Condensed Milk - PHP 60"};
        for (String dairyItem : dairy) {
            System.out.println("- " + dairyItem);
        }

        System.out.println("\nSpices:");
        String[] spices = {"Salt - PHP 20", "Pepper - PHP 30", "Turmeric - PHP 45", "Ginger - PHP 35", "Cinnamon - PHP 55", "Chili Powder - PHP 25", "Garlic Powder - PHP 40"};
        for (String spice : spices) {
            System.out.println("- " + spice);
        }

        System.out.println("\nShampoo and Hygiene Products:");
        String[] hygienes = {"Shampoo - PHP 150", "Conditioner - PHP 170", "Body Wash - PHP 120", "Soap - PHP 50", "Toothpaste - PHP 90", "Toothbrush - PHP 50", "Deodorant - PHP 180", "Hand Soap - PHP 70", "Facial Cleanser - PHP 200", "Shaving Cream - PHP 150"};
        for (String hygiene : hygienes) {
            System.out.println("- " + hygiene);
        }
    }

    public static void order(String name) {
        Scanner sc = new Scanner(System.in);
        double total = 0;
        String ordetails = "";  
        String productpangalan;
        double productpresyo;

        System.out.println("\nEnter the products you would like to order (type 'done' when finished):");

        while (true) {
            System.out.print("Enter: ");
            productpangalan = sc.nextLine().trim();
            if (productpangalan.equalsIgnoreCase("done")) {
                break;
            }

            productpresyo = getProductpresyo(productpangalan);
            if (productpresyo != -1) {
                total += productpresyo;
                ordetails += productpangalan + " - PHP " + productpresyo + "\n"; 
            } else {
                System.out.println("Product not found. Please try again.");
            }
        }

        if (total > 0) {
            System.out.println("\nYour order details:\n" + ordetails);
            System.out.println("Total Price: PHP " + total);

            System.out.print("Enter your full name: ");
            String fullname = sc.nextLine();
            System.out.print("Enter your address: ");
            String address = sc.nextLine();
            System.out.print("Enter your phone number: ");
            String phonenum = sc.nextLine();

            String paymethod = paymentmethds();

            System.out.print("Confirm your order? (yes/no): ");
            String confirm = sc.nextLine();

            if (confirm.equalsIgnoreCase("yes")) {
                String ordid = orid5();
                String ordstatus = "Processing";
                String receipt = "\nOrder ID: " + ordid + "\nName: " + fullname + "\nAddress: " + address + "\nPhone: " + phonenum + "\nProducts: \n" + ordetails + "\nTotal: PHP " + total + "\nPayment Method: " + paymethod + "\nStatus: " + ordstatus;
                orders.put(ordid, receipt);
                System.out.println("\nYour order has been confirmed.");
                System.out.print(receipt);
            } else {
                System.out.println("\nOrder not confirmed. Returning to main menu.");
            }
        } else {
            System.out.println("\nNo items ordered. Returning to main menu.");
        }
    }

    public static String paymentmethds() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPayment Methods:");
        System.out.println("1. Credit/Debit Card");
        System.out.println("2. Cash on Delivery");
        System.out.print("Choose your payment method (1-2): ");
        String choice = sc.nextLine();
        if (choice.equals("1")) {
            return "Credit/Debit Card";
        } else if (choice.equals("2")) {
            return "Cash on Delivery";
        } else {
            System.out.println("Invalid choice. You need to use Cash on Delivery.");
            return "Cash on Delivery";
        }
    }

    public static String orid5() {
        Random random = new Random();
        return String.format("%05d", random.nextInt(100000)); // para sa 5 digit order id
    }

    public static double getProductpresyo(String productpangalan) {
        String[] prutas = {"Apple - PHP 30", "Banana - PHP 50", "Cherry - PHP 80", "Orange - PHP 30", "Grapes - PHP 80", "Mango - PHP 95", "Pineapple - PHP 100", "Strawberry - PHP 150", "Watermelon - PHP 200", "Peach - PHP 100"};
        String[] gulay = {"Carrot - PHP 30", "Broccoli - PHP 50", "Spinach - PHP 40", "Potato - PHP 50", "Tomato - PHP 60", "Onion - PHP 40", "Lettuce - PHP 65", "Cucumber - PHP 50", "Cauliflower - PHP 80", "Pumpkin - PHP 65"};
        String[] inumin = {"Water - PHP 30", "Orange Juice - PHP 50", "Apple Juice - PHP 50", "Milk - PHP 60", "Lemonade - PHP 30", "Coca-Cola - PHP 60", "Pepsi - PHP 50", "Iced Tea - PHP 40", "Coffee - PHP 60", "Energy Drink - PHP 50"};
        String[] tagay = {"Beer (Bottle) - PHP 60", "Red Wine (750ml) - PHP 400", "White Wine (750ml) - PHP 450", "Whiskey (500ml) - PHP 800", "Vodka (500ml) - PHP 600", "Gin (500ml) - PHP 500", "Tequila (750ml) - PHP 900", "Champagne (Bottle) - PHP 1200"};
        String[] snacks = {"Chips - PHP 25", "Cookies - PHP 50", "Chocolate - PHP 60", "Candy - PHP 15", "Popcorn - PHP 40", "Biscuits - PHP 35", "Pretzels - PHP 45", "Nuts - PHP 55", "Granola Bars - PHP 40", "Ice Cream - PHP 120"};
        String[] dairy = {"Cheese - PHP 120", "Butter - PHP 80", "Yogurt - PHP 50", "Milk - PHP 60", "Cream - PHP 75", "Cottage Cheese - PHP 100", "Ice Cream - PHP 120", "Eggs - PHP 40", "Milk Powder - PHP 150", "Condensed Milk - PHP 60"};
        String[] spices = {"Salt - PHP 20", "Pepper - PHP 30", "Turmeric - PHP 45", "Ginger - PHP 35", "Cinnamon - PHP 55", "Chili Powder - PHP 25", "Garlic Powder - PHP 40"};
        String[] hygienes = {"Shampoo - PHP 150", "Conditioner - PHP 170", "Body Wash - PHP 120", "Soap - PHP 50", "Toothpaste - PHP 90", "Toothbrush - PHP 50", "Deodorant - PHP 180", "Hand Soap - PHP 70", "Facial Cleanser - PHP 200", "Shaving Cream - PHP 150"};

        String[][] categories = {prutas, gulay, inumin, tagay, snacks, dairy, spices, hygienes};

        for (String[] category : categories) {
            for (String item : category) {
                if (item.toLowerCase().contains(productpangalan.toLowerCase())) {
                    String[] parts = item.split(" - PHP ");
                    return Double.parseDouble(parts[1]);
                }
            }
        }

        return -1; 
    }

    public static void track() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter your Order ID to track: ");
        String orid = sc.nextLine();
        if (orders.containsKey(orid)) {
            System.out.println("\nOrder Details for Order ID " + orid + ":");
            System.out.println(orders.get(orid));
        } else {
            System.out.println("\nOrder not found.");
        }
    }
}