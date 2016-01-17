
/**
 * ICS4U1
 * Review Set 2
 * 
 * @  
 */
//import statement for Scanner class from standard library
import java.util.Scanner;

public class Menu
{
    //global Scanner variable called sc
    public Scanner sc = new Scanner(System.in);
    public static void main(String[] agrs)
    {
        //create new instance of Menu class
        Menu m = new Menu();

        //call menu method of object m, an instance of the Menu class
        m.menu();
    }

    public void menu()
    {
        //main menu method
        
        //variable declaration
        char choice;
        
        //do while loop
        do
        {
            //output menu options
            System.out.println ("Problem Set #2");
            System.out.println ("--------------");
            System.out.println ("1. Arithmetic");
            System.out.println ("2. Equation");
            System.out.println ("3. Paycheque");
            System.out.println ("0. Quit");
            
            //read character
            choice = sc.nextLine().charAt(0);

            //clear screen
            clear();

            //choose options with if statements
            if (choice == '1')
                arithmetic();
            else if (choice == '2')
                equation();
            else if (choice == '3')
                paycheque ();

            //prompt to ask to continue
            System.out.println("\nPress any key to continue");
            
            //continue when any key is pressed
            sc.nextLine();
            
            //clear screen
            clear();
        }
        while (choice != '0');
    }

    public void clear()
    {
        //clear screen
        System.out.print('\u000C');
    }

    public void arithmetic()
    {
        //variable declaration
        int num1, num2;
        
        //prompt for and read in 2 operands
        System.out.print("Operand #1: ");
        num1 = Integer.parseInt(sc.nextLine());
        System.out.print("Operand #2: ");
        num2 = Integer.parseInt(sc.nextLine());

        //calculate sum, difference, and multiplication
        int sum = num1 + num2;
        int sub = num1 - num2;
        int mul = num1 * num2;

        //output answers
        System.out.println("\n" + num1 + " + " + num2 + " = " + sum);
        System.out.println(num1 + " - " + num2 + " = " + sub);
        System.out.println(num1 + " x " + num2 + " = " + mul);

        //determine and print error message if division by 0
        if(num2 != 0){
            double div = (double) num1 / (double) num2;
            System.out.format("%d / %d = %.3f", num1, num2, div);
        }else{
            System.out.print(num1 + " / " + num2 + " = undefined");
        }
    }

    public void equation()
    {
        //prompt and read 2 numbers
        System.out.println("Enter values for Ax + B = 0");

        System.out.print("A: ");
        int a = Integer.parseInt(sc.nextLine());

        System.out.print("B: ");
        int b = Integer.parseInt(sc.nextLine());

        //print equation initially
        System.out.format("%dx + %d = 0\n", a, b);
        
        //calculate and print equation 2
        b = -1 * b;
        System.out.format("%dx = %d\n", a, b);
        System.out.format("x = %d/%d\n", b, a);
        
        //solve for x and print
        double answer = (double) b / a;
        System.out.format("x = %.3f", answer);
    }

    public void paycheque()
    {
        //prompt for hourly wage
        System.out.print("Enter hourly wage: ");
        double wage = Double.parseDouble(sc.nextLine());

        //prompt for hours worked
        System.out.print("Enter hours worked for one week: ");
        double hours = Double.parseDouble(sc.nextLine());

        //declare total wage earned variable and overtime pay and time
        double total, overWage, overPay, normalPay;
        double overHours, normalHours;
        overWage = 1.5 * wage;
        
        //determine if overtime was worked
        if(hours > 40)
        {
            //if overtime was worked
            normalHours = 40;
            overHours = hours - 40;
        }else{
            normalHours = hours;
            overHours = 0;
        }
        
        //calculate overtime pay
        overPay = overWage * overHours;
        //calculate normal pay
        normalPay = wage * normalHours;
        //total pay
        total = overPay + normalPay;
        
        System.out.println();
        
        //Print a dollar sign for every dollar earned
        for(int i = 0; i < total; i++){
            System.out.print("$");
        }
        
        //output pay
        System.out.println("\nNice job!");
        System.out.format("You earned $%.2f from working %.1f hours.\n\n", total, hours);
        System.out.format("This breaks down as follows:\n");
        System.out.format("You earned $%.2f from working %.1f hours at $%.2f normal pay.\n", normalPay, normalHours, wage);
        System.out.format("You earned $%.2f from working %.1f hours at $%.2f overtime pay.\n", overPay, overHours, overWage);
    }
}
