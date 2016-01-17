import java.util.Scanner;
public class Receipt {
  
  public static void main(String[] args) { 
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter item information\n");
    
    System.out.print("Price: ");
    double price = sc.nextDouble();
    System.out.print("Quantity: ");
    int quantity = sc.nextInt();
    
    for(int i = 0; i < 20; i++)
    {
    System.out.print("-");
    }
    
    System.out.println("\nHere is your receipt\n");
    
    System.out.format("%d x %.2f = $%.2f%n%n", quantity, price, quantity * price);
    
    System.out.println("Thank you. Come again.");
  }
  
}
