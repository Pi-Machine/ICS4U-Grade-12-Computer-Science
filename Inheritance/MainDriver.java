
/**
 * ICS4U
 * MainDriver class
 * 
 * This class contains the main method to drive the program.
 * 
 *  
 */
import java.util.Scanner;
public class MainDriver {
  public static void main(String[] args) { 
    Scanner sc = new Scanner(System.in);
    char choice;
    Politician p;
    do
    {
      System.out.println("***************************");
      System.out.println("Inheritance Set by  ");
      System.out.println("Country: " + Politician.COUNTRY); //PUBLIC variables can be accessed anywhere
      System.out.println("Please choose what to create: ");
      System.out.println("1 - Member of Parliament");
      System.out.println("2 - Minister");
      System.out.println("3 - Party Leader");
      System.out.println("4 - Opposition Leader");
      System.out.println("5 - Prime Minister");
      System.out.println("6 - Governor General");
      System.out.println("7 - Senator");
      System.out.println("Default - Example");
      choice = sc.nextLine().charAt(0);
      String name = "";
      int age = 0;
      String riding = "";
      if(choice  >= '1' & choice < '7')
      {
        System.out.println("Please enter a name, age, and riding for the politician. (Leave the riding empty if you are choosing Governor General or Senator).");
        name = sc.nextLine();
        age = Integer.parseInt(sc.nextLine());
        riding = sc.nextLine();
      }
      if(choice == '1')
        p = new MemberOfParliament(name, age, riding);
      else if(choice == '2')
        p = new Minister(name, age, riding);
      else if(choice == '3')
        p = new PartyLeader(name, age, riding);
      else if(choice == '4')
        p = new OppositionLeader(name, age, riding);
      else if(choice == '5')
        p = new PrimeMinister(name, age, riding);
      else if(choice == '6')
        p = new GovernorGeneral(name, age);
      else if(choice == '7')
        p = new Senator(name, age);
      else
        p = new PrimeMinister("Justin Trudeau", 43, "Papineau");
     
      System.out.println(p);
      System.out.println();
      p.performDuties(); //POLYMORPHISM - the appropriate method is dynamically chosen from the inheritance heirachy
      System.out.println();
      p.mediaBriefing(); //POLYMORPHISM - the appropriate method is dynamically chosen from the inheritance heirachy
      
      if(p instanceof GovernorGeneral) //INSTANCEOF
      {
        GovernorGeneral copy = (GovernorGeneral)p; //using CLASS CASTING to convert the Politician holding a Senator object into a Senator
        System.out.println("\n");
        copy.meet();
      }
      
      if(p instanceof Senator) //INSTANCEOF
      {
        Senator copy = (Senator)p; //using CLASS CASTING to convert the Politician holding a Senator object into a Senator
        System.out.println("\n" + copy + " is a copy of the senator done through classcasting.");
      }
    
      
      System.out.println("Press any key to continue. (0 to quit)");
      choice = sc.nextLine().charAt(0);
      System.out.println("\n\n\n\n\n");
    }while(choice != '0');
  }
  
  public static void example()
  {
  }
}
