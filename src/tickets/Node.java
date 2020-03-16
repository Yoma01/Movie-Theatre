//Ogheneyoma Akoni
//oxa180001

package tickets;
/*The class Node contains the different members of the class which will be used to access the various 
nodes in the class*/
public class Node
{
    /*
    @param Title gets the title of the dvd
    @param Available gets the available dvd that can be rented
    @param Rented gets the rented dvd
    @param left is a pointer to the Node class 
    @param right is a pointer to the Node class
    */
    private String Title;
    private int Available;
    private int Rented;
    private Node Left;
    private Node Right;
    /*
    This is the constructor of the class Node which assigns the various members of the 
    class Node to a default variable. This is the default constructor
    */
    public Node()
    {
        this.Title="";
        this.Available=0;
        this.Rented = 0;
        this.Left = null;
        this.Right = null;
    }
    /*
    This is the overloaded constructor for the class node and it assigns the various private members to the 
    variable that the user wants to set it as 
    */
    public Node(String titl, int av, int rent, Node left, Node right)
    {
        this.Title = titl;
        this.Available = av;
        this.Rented = rent;
        this.Left = left;
        this.Right = right;
    }
    /*
    This mutator sets the title to the String passed in the function
    */
    public void set_title(String tit)
    {
        this.Title= tit;
    }
    /*
    This mutator sets the available to the integer passed into the function
    */
    public void set_av(int av)
    {
        this.Available= av;
    }
    /*
    This mutator sets the rent to the integer passed into the function
    */
    public void set_rent(int rent)
    {
        this.Rented= rent;
    }
    /*
    This mutator sets the Node to the Node passed into the function
    The left Node is a pointer to the Node class 
    */
    public void set_left(Node left)
    {
        this.Left = left;
    }
    /*
    This mutator sets the Node to the Node passed into the function
    The right Node is the pointer to the Node class
    */
    public void set_right(Node right)
    {
        this.Right = right;
    }
    /*
    The accessor of the Node class that gets the private variables title
    */
    public String get_tit()
    {
        return this.Title;
    }
    /*
    The accessor of the Node class that gets the private variables available 
    */
    public int get_av()
    {
        return this.Available;
    }
    /*
    The accessor of the Node class that gets the private variable rent 
    */
    public int get_rent()
    {
        return this.Rented;
    }
    /*
    The accessor of the Node class that gets the private variable left 
    */
    public Node get_left()
    {
        return this.Left;
    }
     /*
    The accessor of the Node class that gets the private variable right 
    */
    public Node get_right()
    {
        return this.Right;
    }
            
    
}
