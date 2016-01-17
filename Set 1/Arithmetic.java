import java.util.Scanner;
public class Arithmetic
{
   public static void main(String[] args)
   {
       Scanner sc = new Scanner(System.in);
       int num1, num2;
       System.out.print("Operand #1: ");
       num1 = Integer.parseInt(sc.nextLine());
       System.out.print("Operand #2: ");
       num2 = Integer.parseInt(sc.nextLine());
       
       int sum = num1 + num2;
       int sub = num1 - num2;
       int mul = num1 * num2;
       double div = (double) num1 / (double) num2;
       
       System.out.println("\n" + num1 + " + " + num2 + " = " + sum);
       System.out.println(num1 + " - " + num2 + " = " + sub);
       System.out.println(num1 + " x " + num2 + " = " + mul);
       System.out.format("%d / %d = %.3f", num1, num2, div);
    }    
}
