
/**
 * ICS4U
 * MemberOfParliament class
 * 
 * This class INHERITS from politican. In other words, a MemberOfParliament IS a Politician.
 * 
 *  
 */
public class MemberOfParliament extends Politician {
    private String riding; //This variable is specific only to MemberOfParliament class and its subclasses
    public MemberOfParliament() //DEFAULT CONSTRUCTOR
    {
        super(); //use of SUPER to call the default constructor of the superclass
        this.riding = "";
    }
    public MemberOfParliament(String n, int a, String r) //CONSTRUCTOR
    {        
        super(n, a); //use of SUPER to call the appropriate constructor of the superclass based on number of arguments
        this.riding = r;
    }
    public MemberOfParliament(MemberOfParliament other) //COPY CONSTRUCTOR
    {
        super(other.getName(), other.age); //use of SUPER to call the appropriate constructor of the superclass based on number of arguments
        this.riding = other.riding;
    }
    
    //GETTER and SETTER methods, also called ACCESSORS and MODIFIERS for private variables
    public String getRiding()
    {
        return riding;
    }
    public void setRiding(String r)
    {
        this.riding = r;
    }
    
    public void performDuties()
    {
        System.out.println(this.getName() + " debates bills in House of Commons");
    }
    
    @Override //toString method; OVERRIDES the toString() method inherited from the Politician superclass
    public String toString()
    {
        return this.getName() + " is a " + age + " year old Member of Parliament for the riding of " + riding;
    }
  
}
