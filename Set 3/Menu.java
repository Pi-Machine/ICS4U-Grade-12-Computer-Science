
/**
 * ICS4U1
 * Review Set 3
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
            System.out.println ("Problem Set #3");
            System.out.println ("--------------");
            System.out.println ("1. Product");
            System.out.println ("2. Factorial");
            System.out.println ("3. Invest");
            System.out.println ("0. Quit");
            
            //read character
            choice = sc.nextLine().charAt(0);

            //clear screen
            clear();

            //choose options with if statements
            if (choice == '1')
                product();
            else if (choice == '2')
                factorial();
            else if (choice == '3')
                invest();

            //prompt to ask to continue
            System.out.println("\n\nPress any key to continue");
            
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

    public void product()
    {
        //declare variables
        int num, total, input;
        total = 1;
        
        //input total nums
        System.out.print("How many numbers to process? ");
        num = sc.nextInt();
        
        //Prompt for nums
        System.out.println("\nEnter " + num + " positive integers");
        for(int i = 0; i < num; i++)
        {
            //input
            System.out.print("#" + (i + 1) + ": ");
            input = sc.nextInt();
            if(input > 0)
            {
                //multiply total
                total *= input;
            }else
            {
                //output error
                System.out.println(input + " not counted");
            }
        }
        
        //output
        System.out.print("\nThe product of the positives is " + total + ".");
        //catch extra return
        sc.nextLine();
    }

    public void factorial()
    {
        //declare variables
        int num, factorial;
        
        //prompt and input for number
        System.out.print("Enter a non-negative integer: ");
        num = sc.nextInt();
        System.out.println();
        
        if(num <= 12 && num >= 0)
        {
            //loop through factorial
            System.out.print(num);
            factorial = num;
            for(int i = num - 1; i > 0; i--)
            {
                System.out.print(" x " + i);
                factorial *= i;
            }
        
            //output result
            System.out.print(" = " + factorial);
        }else
        {
            System.out.print("Number entered is negative or results in a number "
                + "too big for an int to handle\nThe maximum size is " + Integer.MAX_VALUE
                + " which is only enough for 12!.");
        }
        
        
        //catch extra return
        sc.nextLine();
    }

    public void invest()
    {
        //declare variables
        double deposit, rate, term, monthlyRate, balance, interest, endBalance;
        
        //input values
        System.out.format("%-27s: ", "Monthly Deposit");
        deposit = sc.nextDouble();
        System.out.format("%-27s: ", "Annual Interest Rate (%)");
        rate = sc.nextDouble();
        System.out.format("%-27s: ", "Term (Months)");
        term = sc.nextDouble();
        
        //Print Chart
        System.out.println();
        System.out.format("%-10s%-10s%-10s%-10s\n", "Starting", "Interest", "Monthly", "Ending");
        System.out.format("%-10s%-10s%-10s%-10s\n", "Balance", "Earned", "Deposit", "Balance");
        System.out.format("%-10s%-10s%-10s%-10s\n", "--------", "--------", "-------", "-------");
        
        //initialize
        balance = 0;
        monthlyRate = rate * 0.01 / 12;
        
        //loop output
        for(int i = 0; i < term; i++)
        {
            //calculate interest and balance
            interest = balance * monthlyRate;
            endBalance = balance + deposit + interest;
            System.out.format("%6.2f%10.2f%10.2f%10.2f\n", balance, interest, deposit, endBalance);
            balance = endBalance;
        }
        
        //catch extra return
        sc.nextLine();
    }
}
