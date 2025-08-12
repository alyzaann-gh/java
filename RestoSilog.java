import java.util.Scanner;

public class RestoSilog {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // array to para ma track yung reservations at tables
        String[] reservedNames = new String[5];  // para ma store yung names ng reservations
        String[] reserved2 = new String[5];  // para ma store yung time ng reservations
        String[][] table = {
            {"*", "*", "*", "*"},
            {"*", "*", "*", "*"},
            {"*", "*", "*", "*"},
            {"*", "*", "*", "*"},
            {"*", "*", "*", "*"}
        };

        boolean option = false;

        System.out.println("\nWELCOME TO OUR RESTO SILOG");

        while (!option) {
            System.out.println("\nPlease choose an option:");
            System.out.println("\nMenu");
            System.out.println("Reservation");
            System.out.println("Operating Hours");
            System.out.println("Cancel Reservation");
            System.out.println("Exit");
            System.out.print("\nEnter: ");
            String choice = sc.nextLine().trim();    

            if (choice.equalsIgnoreCase("Menu")) {
                Menu();
                System.out.print("\nIs there anything else? (yes/no): ");
                String backMenu = sc.nextLine().trim();
                if (backMenu.equalsIgnoreCase("no")) {
                    System.out.println("Thank you for visiting RESTO SILOG!");
                    option = true;  // exit
                }
            } else if (choice.equalsIgnoreCase("Reservation")) {
                Reservation(table, reservedNames, reserved2);
            } else if (choice.equalsIgnoreCase("Operating Hours")) {
                OperatingHours();
                System.out.print("\nIs there anything else? (yes/no): ");
                String backMenu = sc.nextLine().trim();
                if (backMenu.equalsIgnoreCase("no")) {
                    System.out.println("Thank you for visiting RESTO SILOG!");
                    option = true;  // exit
                }
            } else if (choice.equalsIgnoreCase("Cancel Reservation")) {
                cancelReservation(table, reservedNames, reserved2);
            } else if (choice.equalsIgnoreCase("Exit")) {
                System.out.println("Thank you for visiting RESTO SILOG!");
                option = true;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    public static void Menu() {
        System.out.println("\n--- Menu ---");
        System.out.println("\nSILOG MEALS");

        System.out.println("BEST SELLER (-)");

        System.out.println("\nBACSILOG (Bacon, Sinangag, Itlog) -");
        System.out.println("TOCILOG (Tocino, Sinangag, Itlog)");
        System.out.println("SISILOG (Sisig, Sinangag, Itlog) -");
        System.out.println("LIEMPOSILOG (Liempo, Sinangag, Itlog) -");
        System.out.println("BANGSILOG (Bangus, Sinangag, Itlog)");
        System.out.println("TILAPSILOG (Tilapia, Sinangag, Itlog)");
        System.out.println("HOTSILOG (Hotdog, Sinangag, Itlog)");
        System.out.println("TAPSILOG (Tapa, Sinangag, Itlog)");
        System.out.println("LONGSILOG (Longganisa, Sinangag, Itlog)");
        System.out.println("DANGGITSILOG (Danggit, Sinangag, Itlog)");
        System.out.println("SPAMSILOG (Luncheon Meat, Sinangag, Itlog) -");
        System.out.println("CORNSILOG (Corned Beef, Sinangag, Itlog)");

        System.out.println("\nDRINKS");
        System.out.println("\nWATER");
        System.out.println("COKE");
        System.out.println("SPRITE");
        System.out.println("BEER");
    }

    public static void OperatingHours() {
        System.out.println("\n--- Operating Hours ---");
        System.out.println("\nMonday to Friday: 7:00 AM - 11:00 PM");
        System.out.println("Saturday: 8:00 AM - 12:00 AM");
        System.out.println("Sunday: 24/7 with Band Concerts starting at 8:00 PM");
    }

    public static void Reservation(String[][] table, String[] reservedNames, String[] reserved2) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Reservation ---");
    
        String[] columns = { "1", "2", "3", "4" };
        String[] Rows = { "1 ", "2 ", "3 ", "4 ", "5 " };
    
        boolean reserved = false;
        int row1 = -1, col1 = -1;
    
        while (!reserved) {
            printUpdatedTable(columns, Rows, table); 
            
            System.out.print("\nEnter row and column to reserve a table (Ex: 1 1): ");
            row1 = sc.nextInt() - 1; 
            col1 = sc.nextInt() - 1; 
    
            if (row1 >= 0 && row1 < 5 && col1 >= 0 && col1 < 4) {
                if (table[row1][col1].equals("X")) {
                    System.out.println("\nSeat is already reserved.");
                } else {
                    table[row1][col1] = "X"; 
                    reserved = true; //  mag exit sa loop
                }
            } else {
                System.out.println("Invalid row or column input. Please try again.");
            }
        }
    
        sc.nextLine(); 
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Date (MM/DD/YYYY): ");
        String date = sc.nextLine();
        System.out.print("Time (HH:MM AM/PM): ");
        String time = sc.nextLine();
        System.out.print("Number of guests: ");
        int guests = sc.nextInt();
    
        // para ma save yung reservation details
        reservedNames[row1] = name;
        reserved2[row1] = time;
    
        System.out.println("\n--- Your Reservation ---");
        System.out.println("Name: " + name);
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("Guests: " + guests);
        System.out.println("Table reserved at row " + (row1 + 1) + ", column " + (col1 + 1));
        System.out.println("Seat Status: Reserved");
    
        System.out.println("\nUpdated Table: ");
        printUpdatedTable(columns, Rows, table);
    
        System.out.print("\nDo you want to go back to the main menu? (yes/no): ");
        String back = sc.next();
        if (back.equalsIgnoreCase("no")) {
            System.out.println("Thank you! Your reservation is confirmed.");
            System.exit(0); // mag exit sa method and main loop
        }
    }

    public static void cancelReservation(String[][] table, String[] reservedNames, String[] reserved2) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Cancel Reservation ---");
    
        // check if may reservations
        boolean mayReservation = false;
        for (String name : reservedNames) {
            if (name != null) {
                mayReservation = true;
                break;
            }
        }
    
        if (!mayReservation) {
            System.out.println("No reservations yet.");
            return;
        }
    
        System.out.print("Enter your name to cancel the reservation: ");
        String cancel = sc.nextLine();
        boolean check = false;
    
        // hanapin yung reservation ng icacancel
        for (int i = 0; i < reservedNames.length; i++) {
            if (reservedNames[i] != null && reservedNames[i].equalsIgnoreCase(cancel)) {
                // dito i cacancel yung reservation
                reservedNames[i] = null;
                reserved2[i] = null;
    
                // hanapin yung row and column ng icacancel
                for (int row = 0; row < table.length; row++) {
                    for (int col = 0; col < table[row].length; col++) {
                        if (table[row][col].equals("X")) {
                            table[row][col] = "*";  
                            break;
                        }
                    }
                }
    
                System.out.println("\nReservation canceled for " + cancel);
                check = true;
                break;
            }
        }
    
        if (!check) {
            System.out.println("No reservation found for that name.");
        } else {
            System.out.println("\nUpdated Table"); // print ulit updated table after nung cancellation
            printUpdatedTable(new String[] { "1", "2", "3", "4" }, new String[] { "1 ", "2 ", "3 ", "4 ", "5 " }, table);
        }
    }

    public static void printUpdatedTable(String[] columns, String[] Rows, String[][] table) {
        System.out.print("\t");
        for (String col : columns) {
            System.out.print(col + "\t");
        }
        System.out.println();

        for (int row = 0; row < table.length; row++) {
            System.out.print(Rows[row]); // row labels 1-5
            for (int col = 0; col < table[row].length; col++) {
                System.out.print("\t" + table[row][col]); // piniprint yung table value
            }
            System.out.println();
        }
    }
}