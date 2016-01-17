
/**
 * ICS4U1
 * Review Set 4
 * 
 * @  
 */
//import statement for Scanner class from standard library
import java.util.Scanner;
import java.util.Random;

public class Menu
{
    //global Scanner variable called sc and Random called rand
    public Scanner sc = new Scanner(System.in);
    public Random rand = new Random();
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
            System.out.println ("Problem Set #4");
            System.out.println ("--------------");
            System.out.println ("1. Invest (version 2)");
            System.out.println ("2. BankAccount");
            System.out.println ("3. HilLo");
            System.out.println ("0. Quit");

            //read character
            choice = sc.nextLine().charAt(0);

            //clear screen
            clear();

            //choose options with if statements
            if (choice == '1')
                invest2();
            else if (choice == '2')
                bankAccount();
            else if (choice == '3')
                hiLo();

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

    public void invest2()
    {
        //declare variables
        double deposit, rate, target, monthlyRate, balance, interest, endBalance;
        int months;

        //input values
        System.out.format("%-27s: ", "Monthly Deposit");
        deposit = sc.nextDouble();
        System.out.format("%-27s: ", "Annual Interest Rate (%)");
        rate = sc.nextDouble();
        System.out.format("%-27s: ", "Target Value");
        target = sc.nextDouble();

        //Print Chart
        System.out.println();
        System.out.format("%-10s%-10s%-10s%-10s\n", "Starting", "Interest", "Monthly", "Ending");
        System.out.format("%-10s%-10s%-10s%-10s\n", "Balance", "Earned", "Deposit", "Balance");
        System.out.format("%-10s%-10s%-10s%-10s\n", "--------", "--------", "-------", "-------");

        //initialize
        balance = 0;
        monthlyRate = rate * 0.01 / 12;
        months = 0;

        //loop output
        while(balance < target)
        {
            //calculate interest and balance
            interest = balance * monthlyRate;
            endBalance = balance + deposit + interest;
            System.out.format("%6.2f%10.2f%10.2f%10.2f\n", balance, interest, deposit, endBalance);
            balance = endBalance;
            months++;
        }

        System.out.println("\nIt took " + months + " months to reach your target.");

        //catch extra return
        sc.nextLine();
    }

    public void bankAccount()
    {
        //declare variables
        double balance, deposit, withdrawal;
        int months;

        //prompt for starting balance
        System.out.print("Starting Balance: ");
        balance = sc.nextDouble();

        //loop through months
        months = 1;
        do{
            //input deposit and withdrawal
            System.out.format("\nMonth #%-5dDeposits: ", months);
            deposit = sc.nextDouble();
            if(deposit != -1)
            {
                System.out.format("%12sWithdrawals: ", " ");
                withdrawal = sc.nextDouble();

                //calculate new balance
                balance += deposit;
                balance -= withdrawal;
                months++;
            }
        }while(balance >= 0 && deposit != -1);

        //output final balance
        System.out.format("\nYou have $%.2f left.", balance);

        //catch extra return
        sc.nextLine();
    }

    public void hiLo()
    {
        //declare variables
        int previous, num, score;
        score = 0;
        char guess;
        boolean correct;

        num = rand.nextInt(99) + 1;
        previous = num;
        do{
            //input num
            System.out.print("The number is " + num + ". Next one? (h/l) ");
            guess = sc.nextLine().charAt(0);

            //generate next num
            num = rand.nextInt(99) + 1;

            //determine if loop should continue
            if(num > previous && guess == 'h')
            {
                correct = true;
            }else if(num < previous && guess == 'l')
            {
                correct = true;
            }else
            {
                correct = false;
            }

            //set up for next loop
            previous = num;
            if(correct)
            {
                score++;
            }
        }while(correct);

        //output
        System.out.print("The number is " + num + ". You scored " + score + " points.");
    }

}
