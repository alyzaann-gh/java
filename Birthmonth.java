import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class Birthmonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set group1 = new HashSet();
        Set group2 = new HashSet();
        Set self = new HashSet();

        for(int i = 0; i<3; i++) {
            String g1;
            System.out.print("Enter birth month " + (i+1) + ": ");
            g1 = sc.nextLine();
            group1.add(g1);
        }

        for(int j = 0; j<3; j++) {
            String g2;
            System.out.print("Enter birth month " + (j+1) + ": ");
            g2 = sc.nextLine();
            group2.add(g2);
        }

        System.out.println("Group 1: " + group1);
        System.out.println("Group 2: " + group2);

        System.out.print("Enter your birth month: ");
        String bm = sc.nextLine();
        self.add(bm);

        Set union = new HashSet(group1);
        Set inter = new HashSet(group1);
        Set diff = new HashSet(group1);
        union.addAll(group2);
        inter.retainAll(group2);
        diff.removeAll(group2);

        System.out.println("Union: " + union);
        System.out.println("Intersection: " + inter);
        System.out.println("Difference: " + diff);

        if(union.containsAll(self)) {
            System.out.println("You have the same birth month with one of your classmates.");
        } else {
            System.out.println("You don't have the same birth month with one of your classmates.");
        }
    }
}