

import java.util.Random;
import java.util.Scanner;
public class Main {

    public static Random r = new Random();
    public static void main(String[] args) {
        boolean a[] = new boolean[12];
        for (int i = 1; i <12 ; i++) {
            a[i] = false;
        }
        Scanner sc = new Scanner(System.in);
        int waste = 0;
        boolean flag = true;
        while (flag){
            int dice1 = Math.abs((r.nextInt()))%6+1;
            int dice2 = Math.abs((r.nextInt()))%6+1;
            System.out.println("Dice 1 value : " + dice1);
            System.out.println("Dice 2 value : " + dice2);
            System.out.println("Sum :" + (dice1+dice2));
            System.out.println("1.Update 2.Roll Both 3.Keep one dice as same");
            int temp = sc.nextInt();
            if (temp == 2){
                dice1 = Math.abs((r.nextInt()))%6+1;
                dice2 = Math.abs((r.nextInt()))%6+1;
                System.out.println("Dice 1 value : " + dice1);
                System.out.println("Dice 2 value : " + dice2);
                System.out.println("Sum :" + (dice1+dice2));
            }
            else if (temp == 3){
                System.out.print("Lock dice number (1 or 2): " );
                waste += CheckAndUpdate(a,(dice1+dice2));
                int choice = sc.nextInt();
                if (choice == 2){
                    dice1 = Math.abs((r.nextInt()))%6+1;
                    System.out.println("Dice 1 value : " + dice1);
                    System.out.println("Dice 2 value : " + dice2);
                    System.out.println("Sum :" + (dice1+dice2));
                }
                if (choice == 1){
                    dice2 = Math.abs((r.nextInt()))%6+1;
                    System.out.println("Dice 1 value : " + dice1);
                    System.out.println("Dice 2 value : " + dice2);
                    System.out.println("Sum :" + (dice1+dice2));
                }
            }
            else{
                System.out.println("Values are all updated");
            }
            waste += CheckAndUpdate(a,(dice1+dice2));
            if (allUpadated(a)){
                flag = false;
            }
        }
        System.out.println("Total number of waste moves  : " + waste);
    }

    private static boolean allUpadated(boolean[] a) {
        for (int i = 1; i <12 ; i++) {
            if (a[i] == false){
                return false;
            }
        }
        return true;
    }

    private static int CheckAndUpdate(boolean[] a, int i) {
        if (a[i-1] == true){
            return 1;
        }
        a[i-1] = true;
        return 0;
    }

}