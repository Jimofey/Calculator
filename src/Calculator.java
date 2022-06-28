package src;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Calculator {
    private static final int div_scale = 10;

    public double add(String num1, String num2) {
        BigDecimal[] retNum = retNum(num1, num2);
        System.out.print("Addition results: ");
        return retNum[0].add(retNum[1]).doubleValue();
    }

    public double sub(String num1, String num2) {
        BigDecimal[] retNum = retNum(num1, num2);
        System.out.print("Subtraction results: ");
        return retNum[0].subtract(retNum[1]).doubleValue();
    }

    public double mul(String num1, String num2) {
        BigDecimal[] retNum = retNum(num1, num2);
        System.out.print("Multiplication results: ");
        return retNum[0].multiply(retNum[1]).doubleValue();
    }

    public double div(String num1, String num2) {
        BigDecimal[] retNum = retNum(num1, num2);
        System.out.print("Division results: ");
        return retNum[0].divide(retNum[1], div_scale, RoundingMode.HALF_UP  ).doubleValue();
    }
    
    public static BigDecimal[] retNum(String num1, String num2){
        BigDecimal b1 = new BigDecimal(num1);
        BigDecimal b2 = new BigDecimal(num2);

        return new BigDecimal[]{b1, b2};
    }

    public void printStart() {
        String welcome = "Calculator guide:\n";
        String guide = "Press 1 - addition\n" +
                "Press 2 - subtraction\n" +
                "Press 3 - multiplication\n" +
                "Press 4 - division";
        System.out.println(welcome + guide);
    }

    public static  boolean continueChecking(){
        Scanner scan = new Scanner(System.in);
        boolean continueFlag = true;
        char continueInput;

        System.out.println("Continue? ('Y' or others to quit)");
        continueInput = scan.next().charAt(0);
        if (continueInput != 'y' && continueInput != 'Y') {
            continueFlag = false;
        }
        
        return continueFlag;
    }

    public static String[] scanString(){
        Scanner scan = new Scanner(System.in);
        String[] scanString = new String[2];
        System.out.println("Input the 1/2 number:");
        scanString[0] = scan.nextLine();
        System.out.println("Input the 2/2 number:");
        scanString[1] = scan.nextLine();

        return scanString;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scan = new Scanner(System.in);

        byte calMethodFlag;
        boolean continueFlag = true;
        
        while(continueFlag) {
            calculator.printStart();

            calMethodFlag= scan.nextByte();
            switch(calMethodFlag) {
                case 1:
                    String[] scanString = scanString();
                    System.out.println(calculator.add(scanString[0], scanString[1]));
                    continueFlag = continueChecking();
                        
                    break; 
                case 2:
                    scanString = scanString();
                    System.out.println(calculator.sub(scanString[0], scanString[1]));
                    continueFlag = continueChecking();

                    break;
                case 3:
                    scanString = scanString();
                    System.out.println(calculator.mul(scanString[0], scanString[1]));
                    continueFlag = continueChecking();

                    break;
                case 4:
                    scanString = scanString();
                    while (scanString[1].equals("0")){
                        System.out.println("divisor must not be 0.");
                        scanString = scanString();
                    }
                    System.out.println(calculator.div(scanString[0], scanString[1]));
                    continueFlag = continueChecking();

                    break;
                default:
                    System.out.println("Enter the number between 1 and 4.");
                    break;
            }
        }
    }
}
