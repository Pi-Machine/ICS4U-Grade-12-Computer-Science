
/**
 * ICS4U
 * Recursion Problem Set
 * 
 *  
 */
import java.util.Scanner;
public class Recursion
{
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        //initialize Menu class
        Recursion r = new Recursion();
        r.menu();
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
            System.out.println ("Problem Set for Recursion");
            System.out.println ("--------------");
            System.out.println ("1. GCF Recursive");
            System.out.println ("2. GCF Nonrecursive");
            System.out.println ("3. Fibonacci Recursive");
            System.out.println ("4. Fibonacci Nonrecursive");
            System.out.println ("0. Quit");
            
            //read character
            choice = sc.nextLine().charAt(0);

            //clear screen
            clear();

            //choose options with if statements
            if (choice == '1')
                gcf1Driver();
            else if (choice == '2')
                gcf2Driver();
            else if (choice == '3')
                fib1Driver();
            else if (choice == '4')
                fib2Driver();

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

    
    public void gcf1Driver()
    {
        //variable declaration
        int num1, num2;
        
        //prompt for input
        System.out.print("Enter first number: ");
        num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        num2 = sc.nextInt();
        
        //output
        System.out.print("The greatest common factor is " + gcf1(num1, num2));
        sc.nextLine();
    }
    
    public int gcf1(int num1, int num2)
    {
        //recursive method with Euclidean algorithm
        if(num1 == num2)
        {
            return num1;
        }else if(num1 < num2)
        {
            return gcf1(num2, num1);
        }else
        {
            return gcf1(num2, num1 - num2);
        }
    }
    
    public void gcf2Driver()
    {
        //variable declaration
        int num1, num2;
        
        //prompt for input
        System.out.print("Enter first number: ");
        num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        num2 = sc.nextInt();
        
        //output
        System.out.print("The greatest common factor is " + gcf2(num1, num2));
        sc.nextLine();
      
    }
    
    public int gcf2(int num1, int num2)
    {
        //nonrecursive method with Euclidean algorithm
        int temp = 0;
        while(num1 != num2)
        {
            if(num1 < num2)
            {
                temp = num1;
                num1 = num2;
                num2 = temp;
            }else
            {
                temp = num1;
                num1 = num2;
                num2 = temp - num2;
            }
        }
        return num1;
    }
    
    public void fib1Driver()
    {
        //variable declaration
        int num;
        
        //prompt for input
        System.out.print("Which term of the Fibonacci sequence do you want: ");
        num = sc.nextInt();
        
        //output
        System.out.print("The " + num + "th term of the Fibonacci sequence is: " + fib1(num));
        sc.nextLine();
    }
    
    public int fib1(int num)
    {
        //recursive fibonacci sequence
        if(num == 1 || num == 2)
        {
            return 1;
        }else
        {
            return fib1(num - 1) + fib1(num - 2);
        }
    }
    
    public void fib2Driver()
    {
        //variable declaration
        int num;
        
        //prompt for input
        System.out.print("Which term of the Fibonacci sequence do you want: ");
        num = sc.nextInt();
        
        //output
        System.out.print("The " + num + "th term of the Fibonacci sequence is: " + fib2(num));
        sc.nextLine();
    }
    
    public int fib2(int num)
    {
        //non-recursive fibonacci sequence
        int index = 3; //index from third num of sequence
        int total = 0;
        int a = 1; //first num of sequence
        int b = 1; //second num of sequence
        int c = 1;
        while(index <= num)
        {
            c = a + b;
            a = b;
            b = c;
            index++;
        }
        return c;
    }
    
}

