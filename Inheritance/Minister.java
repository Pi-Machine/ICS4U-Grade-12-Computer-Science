
/**
 * ICS4U
 * Minister class
 * 
 * This class INHERITS from MemberOfParliament. In other words, a Minister IS a MemberOfParliament.
 * 
 *  
 */
public class Minister extends MemberOfParliament {
    public Minister() //DEFAULT CONSTRUCTOR
    {
        super(); //use of SUPER to call the default constructor of the superclass
    }
    public Minister(String n, int a, String r) //CONSTRUCTOR
    {        
        super(n, a, r); //use of SUPER to call the appropriate constructor of the superclass based on number of arguments
    }
    public Minister(Minister other) //COPY CONSTRUCTOR
    {
        super(other.getName(), other.age, other.getRiding()); //use of SUPER to call the appropriate constructor of the superclass based on number of arguments
    }
    
    public void performDuties()
    {
        super.performDuties(); //use of SUPER to call the appropriate method from the superclass
        System.out.println(this.getName() + " manages a Ministry or Department and is on the government Cabinet."); 
    }
    
    @Override //OVERRIDES the mediaBriefing() method inherited
    public void mediaBriefing()
    {
        System.out.println(this.getName() + " talks to the media about his/her work as well as the affairs of their Ministry/Department.");
    }
    
    @Override //toString method; OVERRIDES the toString() method inherited from the Politician superclass
    public String toString()
    {
        return this.getName() + " is a " + age + " year old Minister";
    }
  
}