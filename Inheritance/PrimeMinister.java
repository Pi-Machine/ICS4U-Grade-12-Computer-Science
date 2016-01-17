
/**
 * ICS4U
 * PrimeMinister class
 * 
 * This class INHERITS from PartyLeader. In other words, a PrimeMinister IS a PartyLeader.
 * 
 *  
 */
public class PrimeMinister extends PartyLeader {
    public PrimeMinister() //DEFAULT CONSTRUCTOR
    {
        super(); //use of SUPER to call the default constructor of the superclass
    }
    public PrimeMinister(String n, int a, String r) //CONSTRUCTOR
    {        
        super(n, a, r); //use of SUPER to call the appropriate constructor of the superclass based on number of arguments
    }
    public PrimeMinister(PrimeMinister other) //COPY CONSTRUCTOR
    {
        super(other.getName(), other.age, other.getRiding()); //use of SUPER to call the appropriate constructor of the superclass based on number of arguments
    }
    
    public void performDuties()
    {
        super.performDuties(); //use of SUPER to call the appropriate method from the superclass
        System.out.println(this.getName() + " manages the whole country!"); 
    }
    
    @Override //OVERRIDES the ABSTRACT mediaBriefing() method inherited
    public void mediaBriefing()
    {
        System.out.println(this.getName() + " talks to the media about the government as a whole managing the country.");
    }
    
    @Override //toString method; OVERRIDES the toString() method inherited
    public String toString()
    {
        return this.getName() + " is a " + age + " year old prime minister";
    }
  
}