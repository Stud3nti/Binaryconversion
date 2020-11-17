import java.util.Scanner;
import java.util.Arrays;
public class Main{
    public static int bConv(String number){
        double total = 0;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '1') {
                total = total + Math.pow(2, number.length() - 1 - i);
            }
        }
        int totalInt = (int) total;
        return totalInt;
    }
    public static int hConv(String number,String[] values){
        int hextot = 0;
        String holder;
        boolean result = Arrays.stream(values).anyMatch(number::equals);
        for (int i = 0; i < number.length(); i++) {
            holder = number.substring(i , i+1);
            int index = Arrays.asList(values).indexOf(holder);
            hextot += Math.pow(16,number.length()-1-i)*index;
        }
        return hextot;
    }
    public static void main(String[] args) {
        Boolean running = Boolean.TRUE;
        String number;
        String[] values = new String[]{"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("1:Binary=>Denary 2:Hex=>Denary 3=>END");
            int choice = input.nextInt();
            if (choice == 1) {
                System.out.println("Input binary number: ");
                number = input.next();
                System.out.println(bConv(number));
            } else if (choice == 2) {
                System.out.println("Enter a Hex Value: ");
                number = input.next();
                System.out.println(hConv(number, values));
            } else
                running = Boolean.FALSE;
        }while(running);

    }
}
