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
        for (int i = 0; i < number.length(); i++) {
            holder = number.substring(i , i+1);
            int index = Arrays.asList(values).indexOf(holder);
            hextot += Math.pow(16,number.length()-1-i)*index;
        }
        return hextot;
    }
    public static  void dConvB(String number){
        int denary = Integer.parseInt(number);
        int[] binNum = new int[32];
        int i = 0;
        while(denary> 0){
            binNum[i] = denary % 2;
            denary /= 2;
            i++;
        }
        for (int j = i-1; j >= 0 ; j--) {
            System.out.print(binNum[j]);
        }

    }
    public  static  void dConvH(String number) {
        int value;
        int denary = Integer.parseInt(number);
        char hexchars[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexVal = "";
        while (denary>0){
            value = denary % 16;
            hexVal = hexchars[value] + hexVal;
            denary /= 16;
        }
        System.out.println(hexVal);
    }
    public static void main(String[] args) {
        Boolean running = Boolean.TRUE;
        String number;
        String[] values = new String[]{"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("1:Binary=>Denary\t2:Hex=>Denary\t3:Denary=>Binary\t4:Denary=>Hex\t5=>END");
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Input binary number: ");
                    number = input.next();
                    System.out.println(bConv(number));
                case 2:
                    System.out.println("Enter a Hex Value: ");
                    number = input.next();
                    if (!Arrays.stream(values).anyMatch(number::equals)){
                        System.out.println("Please Enter a Valid Hex value:");
                        number = input.next();
                    }
                    System.out.println(hConv(number, values));
                case 3:
                    System.out.println("Enter a Denary Number: ");
                    number = input.next();
                    dConvB(number);
                case 4:
                    System.out.println("Enter a Denary Number: ");
                    number = input.next();
                    dConvH(number);
                case 5:
                    running = Boolean.FALSE;
            }

        }while(running);

    }
}
