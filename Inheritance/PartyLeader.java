
/**
 * ICS4U
 * PartyLeader class
 * 
 * This class INHERITS from MemberOfParliament. In other words, a PartyLeader IS a MemberOfParliament.
 * 
 *  
 */
public class PartyLeader extends MemberOfParliament {
    public PartyLeader() //DEFAULT CONSTRUCTOR
    {
        super(); //use of SUPER to call the default constructor of the superclass
    }
    public PartyLeader(String n, int a, String r) //CONSTRUCTOR
    {        
        super(n, a, r); //use of SUPER to call the appropriate constructor of the superclass based on number of arguments
    }
    public PartyLeader(PartyLeader other) //COPY CONSTRUCTOR
    {
        super(other.getName(), other.age, other.getRiding()); //use of SUPER to call the appropriate constructor of the superclass based on number of arguments
    }
    
    public void performDuties()
    {
        super.performDuties(); //use of SUPER to call the appropriate method from the superclass
        System.out.println(this.getName() + " manages a political party."); 
    }
    
    @Override //OVERRIDES the mediaBriefing() method inherited
    public void mediaBriefing()
    {
        System.out.println(this.getName() + " talks to the media about the policies of his/her political party.");
    }
    
    @Override //toString method; OVERRIDES the toString() method inherited
    public String toString()
    {
        return this.getName() + " is a " + age + " year old party leader";
    }
  
}