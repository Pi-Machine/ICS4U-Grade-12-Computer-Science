
/**
 * Set 5
 * 
 * @ 
 */
import java.util.Random;
import java.util.Scanner;
public class Set5
{
    //declare random object
    public Random rand = new Random();
    public Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        //new Set5 object followed by call to program
        Set5 set = new Set5();
        set.program();
    }

    //--------------CALL THIS METHOD TO RUN FINAL PROGRAM-------------------
    public void program()
    {
        //print title
        this.title("The LCM Machine");
        System.out.println();
        
        //get input
        int pairs = readChar('1', '9') - 48;
        System.out.println();
        
        //generate chart
        int num1, num2;
        System.out.println("Numbers   LCM");
        for(int i = 0; i < pairs; i++)
        {
            num1 = getRandom(1, 100);
            num2 = getRandom(1, 100);
            System.out.format("\n%3d%4d%6d", num1, num2, lcm(num1, num2));
        }
        
        //continue?
        System.out.println("\n");
        char option = readChar("yYnN", "Want to go again?");
        if(option == 'y' || option == 'Y')
        {
            System.out.print('\u000c');
            program();
        }
    }
    
    public void title(String message)
    {
        //using unicode characters for the box
        //UNICODE CHARACTERS MAY APPEAR DIFFERENT WITH DIFFERENT FONTS (WORKS ON MY COMPUTER)
        //print top
        System.out.print('\u250c'); //corner
        for(int i = 0; i < message.length() * 2 / 3; i++)
        {
            System.out.print('\u2500');
        }
        System.out.print('\u2510');
        
        //print middle
        System.out.println();
        System.out.print('\u2502' + " " + message + " " + '\u2502');
        
        //print bottom
        System.out.println();
        System.out.print('\u2514');
        for(int i = 0; i < message.length() * 2 / 3; i++)
        {
            System.out.print('\u2500');
        }
        System.out.print('\u2518');
        System.out.println();
    }
    
    public int getRandom(int low, int high)
    {
        //returns random value
        return rand.nextInt(high - low) + low;
    }
    
    public char readChar(char low, char high)
    {
        //variable declaration
        char in;
        
        //input
        System.out.print("How many pairs to process (" + low + "-" + high + ")? ");
        in = sc.nextLine().charAt(0);
        
        //loop while not in range
        while(in < low || in > high)
        {
            System.out.print("Error " + low + "-" + high + " only: ");
            in = sc.nextLine().charAt(0);
        }
        
        //return
        return in;
    }
    
    public char readChar(String valids, String message)
    {
        //variable declaration
        char in;
        
        //prompt for input
        System.out.print(message + " ");
        in = sc.nextLine().charAt(0);
        
        //loop while invalid input
        while(valids.indexOf(in) < 0)
        {
            System.out.print("Error " + valids + " only: ");
            in = sc.nextLine().charAt(0);
        }
        
        //return
        return in;
    }
    
    public int lcm(int num1, int num2)
    {
        //variable declaration
        int multiple;
        
        //return 0 if <= 0
        if(num1 <= 0 || num2 <= 0)
        {
            return 0;
        }
        
        //loop through for common factors
        for(int i = 1; i < Math.min(num1, num2); i++)
        {
            multiple = i * Math.max(num1, num2);
            if(multiple % Math.min(num1, num2) == 0)
            {
                return multiple;
            }
        }
        
        return num1 * num2;
    }
}
