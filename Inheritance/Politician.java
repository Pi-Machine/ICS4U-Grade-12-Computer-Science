
/**
 * ICS4U
 * Politician class
 * abstract
 * 
 * This class is ABSTRACT because it contains abstract methods. These methods are named abstract because
 * subclasses can have such a wide variety of possible implementations that it is unfeasible to provide
 * implementation here.
 * 
 *  
 */
public abstract class Politician {
    protected int age; //PROTECTED variable; accessible by subclasses and other classes in the same package
    private String name; //PRIVATE variable; accessible by getter and setter methods
    public static final String COUNTRY = "Canada"; //PUBLIC means accessible from outside; it is a static constant, but as a variable public is not good
    public Politician() //DEFAULT CONSTRUCTOR
    {
        this.name = ""; //initializing values in a constructor
        this.age = 0;
    }
    public Politician(String n, int a) //CONSTRUCTOR
    {        
        this.name = n; //this refers to the current class (it is not necessary here but provides more clarity)
        this.age = a;
    }
    public Politician(Politician other) //COPY CONSTRUCTOR
    {
        this.name = other.name;
        this.age = other.age;
    }
    
    //GETTER and SETTER methods, also called ACCESSORS and MODIFIERS for private variables
    public String getName()
    {
        return name;
    }
    public void setName(String n)
    {
        this.name = n;
    }
    
    //ABSTRACT methods; no reasonable implementation, so left as abstract header
    public abstract void performDuties(); //ABSTRACT method with no feasible implementation to be inherited
    
    //NON-ABSTRACT methods    
    public void mediaBriefing()
    {
        System.out.print(name + " talks to the media about his/her work.");
    }
    
    @Override //toString method; OVERRIDES the toString() method inherited from the Object superclass
    public String toString()
    {
        return name + " is a " + age + " year old politician.";
    }
  
}
