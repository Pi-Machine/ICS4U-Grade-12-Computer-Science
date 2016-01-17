
/**
 * ICS4U
 * Senator class
 * 
 * This class INHERITS from politican. In other words, a Senator IS a Politician.
 * 
 *  
 */
public class Senator extends Politician {
    public Senator() //DEFAULT CONSTRUCTOR
    {
        super(); //use of SUPER to call the default constructor of the superclass
    }
    public Senator(String n, int a) //CONSTRUCTOR
    {        
        super(n, a); //use of SUPER to call the appropriate constructor of the superclass based on number of arguments
    }
    public Senator(Senator other) //COPY CONSTRUCTOR
    {
        super(other.getName(), other.age); //use of SUPER to call the appropriate constructor of the superclass based on number of arguments
    }
    
    public void performDuties()
    {
        System.out.println(this.getName() + " works with other senators in the Senate to act as a chamber of sober second thought.");
    }
    
    @Override //toString method; OVERRIDES the toString() method inherited from the Politician superclass
    public String toString()
    {
        return this.getName() + " is a " + age + " year old senator";
    }
  
}
