
/**
 * ICS4U
 * OppositionLeader class
 * 
 * This class INHERITS from PartyLeader. In other words, a OppositionLeader IS a PartyLeader.
 * 
 *  
 */
public class OppositionLeader extends PartyLeader {
    public OppositionLeader() //DEFAULT CONSTRUCTOR
    {
        super(); //use of SUPER to call the default constructor of the superclass
    }
    public OppositionLeader(String n, int a, String r) //CONSTRUCTOR
    {        
        super(n, a, r); //use of SUPER to call the appropriate constructor of the superclass based on number of arguments
    }
    public OppositionLeader(OppositionLeader other) //COPY CONSTRUCTOR
    {
        super(other.getName(), other.age, other.getRiding()); //use of SUPER to call the appropriate constructor of the superclass based on number of arguments
    }
    
    public void performDuties()
    {
        super.performDuties(); //use of SUPER to call the appropriate method from the superclass
        System.out.println(this.getName() + " keeps the government accountable."); 
    }
    
    @Override //toString method; OVERRIDES the toString() method inherited
    public String toString()
    {
        return this.getName() + " is a " + age + " year old opposition leader";
    }
  
}