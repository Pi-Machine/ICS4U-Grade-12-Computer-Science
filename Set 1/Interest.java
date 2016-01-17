import java.util.Scanner;
public class Interest {
  
  
  public static void main(String[] args) { 
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Principal ($): ");
    int princ = sc.nextInt();
    System.out.print("Interest Rate (%): ");
    double rate = sc.nextDouble();
    
    double interest1 = 0.01 * rate * princ;
    System.out.format("\nYear 1 Interest = $%.2f\n", interest1);
    
    princ += interest1;
    
    double interest2 = 0.01 * rate * princ;
    System.out.format("Year 2 Interest = $%.2f\n", interest2);
  }
  
}
