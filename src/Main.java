import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
public class Main{
    public static int bConv(String binaryNumber){
        double total = 0;
        for (int i = 0; i < binaryNumber.length(); i++) {
            if (binaryNumber.charAt(i) == '1') {
                total = total + Math.pow(2, binaryNumber.length() - 1 - i);
            }
        }
        int totalInt = (int) total;
        return totalInt;
    }
    public static int hConv(String binaryNumber,String[] values){
        int hextot = 0;
        String holder;
        boolean result = Arrays.stream(values).anyMatch(binaryNumber::equals);
        for (int i = 0; i < binaryNumber.length(); i++) {
            holder = binaryNumber.substring(i , i+1);
            int index = Arrays.asList(values).indexOf(holder);
            hextot += Math.pow(16,binaryNumber.length()-1-i)*index;
        }
        return hextot;
    }
    public static void main(String[] args) {
        String[] values = new String[]{"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        Scanner input = new Scanner(System.in);
        String binaryNumber;
        System.out.print("Input binary number: ");
        binaryNumber = input.nextLine();
        System.out.println(bConv(binaryNumber));
        System.out.println("Enter a Hex Value: ");
        binaryNumber = input.nextLine();
        System.out.println(hConv(binaryNumber,values));
    }
}
