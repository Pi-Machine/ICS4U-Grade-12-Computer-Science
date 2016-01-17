
/**
 * ICS4U
 * GovernorGeneral class
 * 
 * This class INHERITS from politican. In other words, a GovernorGeneral IS a Politician.
 * 
 *  
 */
public class GovernorGeneral extends Politician {
    public GovernorGeneral() //DEFAULT CONSTRUCTOR
    {
        super(); //use of SUPER to call the default constructor of the superclass
    }
    public GovernorGeneral(String n, int a) //CONSTRUCTOR
    {        
        super(n, a); //use of SUPER to call the appropriate constructor of the superclass based on number of arguments
    }
    public GovernorGeneral(GovernorGeneral other) //COPY CONSTRUCTOR
    {
        super(other.getName(), other.age); //use of SUPER to call the appropriate constructor of the superclass based on number of arguments
    }
    
    public void performDuties()
    {
        System.out.println(this.getName() + " represents the Queen and is the head of state.");
    }
    
    public void meet() //add ADDITIONAL methods to subclasses on top of the ones inherited from superclasses
    {
        System.out.println(this.getName() + " meets with foreign dignitaries.");
    }
    
    @Override //toString method; OVERRIDES the toString() method inherited from the Politician superclass
    public String toString()
    {
        return this.getName() + " is a " + age + " year old governor general";
    }
  
}
