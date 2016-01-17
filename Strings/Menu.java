
/**
 * ICS4U
 * Strings Problem Set
 * 
 *  
 */
import java.util.Scanner;
import java.util.Random;
public class Menu
{
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    public static void main(String[] args)
    {
        //initialize Menu class
        Menu m = new Menu();
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
            System.out.println ("Problem Set for Strings");
            System.out.println ("--------------");
            System.out.println ("1. Palindrome");
            System.out.println ("2. Shift Code");
            System.out.println ("3. Crypto Code");
            System.out.println ("0. Quit");
            
            //read character
            choice = sc.nextLine().charAt(0);

            //clear screen
            clear();

            //choose options with if statements
            if (choice == '1')
                palindromeDriver();
            else if (choice == '2')
                shiftocodeDriver();
            else if (choice == '3')
                cryptocodeDriver();

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

    
    public void palindromeDriver()
    {
        //prompt for message input
        System.out.print("Enter a string to check if it is a palindrome: ");
        String message = sc.nextLine();
        if(palindrome(message))
        {
            System.out.print(message + " IS a palindrome when ignoring spaces, punctuation and capitalization");
        }else{
            System.out.print(message + " IS NOT a palindrome when ignoring spaces, punctuation and capitalization");
        }
        
    }
    
    public boolean palindrome(String message)
    {
        //lower case
        message = message.toLowerCase();
        String removed = "";
        //remove non-alpha characters
        for(int i = 0; i < message.length(); i++)
        {
            if(message.charAt(i) >= 'a' && message.charAt(i) <= 'z')
            {
                removed += message.charAt(i);
            }
        }
        
        message = removed;
        //match characters
        for(int i = 0; i < message.length(); i++)
        {
            if(message.charAt(i) != message.charAt(message.length() - i - 1))
            {
                return false;
            }
        }
        
        return true;
    }
    
    public void shiftocodeDriver()
    {
        //input
        System.out.print("Enter a message: ");
        String message = sc.nextLine();
        System.out.print("Enter a shift value: ");
        int value = sc.nextInt();
        //pass arguments
        String shifted = shiftocode(message, value);
        System.out.print(message + " shifted by " + value + " is " + shifted);
        sc.nextLine();
    }
    
    public String shiftocode(String message, int shift)
    {
        //create character array and loop through characters
        String end = "";
        char[] characters = message.toCharArray();
        for(int i = 0; i < characters.length; i++)
        {
            char current = characters[i];
            //if not a character, leave alone
            if(current >= 'A' && current <= 'Z')
            {
                //shift and adjust to keep in alphabet
                characters[i] += shift;
                while(characters[i] > 'Z')
                {
                    characters[i] -= 26;
                }
                while(characters[i] < 'A')
                {
                    characters[i] += 26;
                }
            }
            end += characters[i];
        }
        //return end
        return end;
    }
    
    public void cryptocodeDriver()
    {
        //alphabet
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        //input
        System.out.print("Enter a message: ");
        String message = sc.nextLine();
        //pass argument
        String shifted = cryptocode(message, alphabet);
        String alpha = "";
        for(char c: alphabet)
        {
            alpha += c;
        }
        System.out.print(message + " with scrambled alphabet " + alpha + " becomes " + shifted);
    }
    
    public String cryptocode(String message, char[] alphabet)
    {
        
        //shuffle alphabet
        for(int i = 0; i < alphabet.length; i++)
        {
            //find random index and swap
            int index = rand.nextInt(26);
            char temp = alphabet[index];
            alphabet[index] = alphabet[i];
            alphabet[i] = temp;
        }
        
        /*  SAMPLE TEST CASE GIVEN IN PROBLEM ASSIGNMENT
        String testcase = "HOAZXJRTUYBIVEWKLSNCDMFGPQ";
        for(int i = 0; i < alphabet.length; i++)
        {
            alphabet[i] = testcase.charAt(i);
        }
        */
        
        String end = "";
        char[] characters = message.toCharArray();
        for(int i = 0; i < message.length(); i++)
        {
            char current = characters[i];
            //if not a character, leave alone
            if(current >= 'A' && current <= 'Z')
            {
                //shift
                char value = (char) (current - 'A');
                characters[i] = alphabet[value];
            }
            end += characters[i];
        }
        //return end
        return end;
    }
}

