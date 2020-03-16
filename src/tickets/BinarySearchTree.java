//Ogheneyoma Akoni
//oxa180001
package tickets;
import java.io.PrintWriter;
//BinarySearchTree of the package Tickets 
public class BinarySearchTree 
{   //private variable that is the pointer to the Node class
    private Node Root;
    //this is the default class constructor
    public BinarySearchTree()
    {
        this.Root = null;
    }
    /*
    this is the overloaded class constrctor that sets the Node  
    */
    public BinarySearchTree(Node root)
    {
        this.Root = root;
    }
    /*
    This is a mutator that sets the private variable Root to a variable
    */
    public void set_root(Node root)
    {
        this.Root = root;
    }
    /*
    This is a accessor that gets the private variable Root to a variable
    */
    public Node get_root()
    {
        return this.Root;
    }
    /*
    This function that adds new Nodes and also modifies the current nodes
    if the node is equal to null it returns the node as a new root
    else if the title of the movie is greater in the alphabet it goes to the right Node
    else if the title of the movie is lesser in the alphabet it goes to left Node
    else if the same as the alphabet, removes the node if neccessary
    */
    public Node insert(Node root, Node key, Node par)
    {
        if(root == null)
        {
            return key;
        }
        else if(key.get_tit().compareTo(root.get_tit())> 0)
        {
            root.set_right(insert(root.get_right(), key,root));
        }
        else if(key.get_tit().compareTo(root.get_tit())<0)
        {
            root.set_left(insert(root.get_left(),key,root));
        }
      
        else if(key.get_tit().compareTo(root.get_tit())== 0)
        {
            if(root.get_av() + key.get_av() == 0 && root.get_rent() == 0 && root.get_av() < 0 && root.get_rent() ==0)
            {
                par = delete(root, par);
                return par;
            }
            else 
            {
                root.set_av(root.get_av()+ key.get_av());
                root.set_rent(root.get_rent()+root.get_rent());
            }
        }
        return root;
    }
    /*
     This is the recursive print writer function that prints if it is corrctly formatted
    @ param write is used for writing to a file 
    @ param nde is the pointer to the class Node
    */
    public void rep_r(Node node, PrintWriter write)
    {
        if(node != null)
        {
            rep_r(node.get_left(),write);
            rep_r(node.get_right(),write);
            write.printf("%25s%5d%5d",node.get_tit(), node.get_av(), node.get_rent());//print it with the correct formatting
            write.println();//go to next line
        }
    }
    /*
    This is the recursive insert function that adds Nodes when needed
    */
    public void insert_h(Node key)
    {
        Root = insert(Root,key,null);
    }
    /*
    This is the function that deletes nodes 
    if the node is the root node it gets the last node on the left or right or becomes the new root  
    @param key is the pointer to the node
    @param Par is the new root 
    it is used to get nodes at the left or at the right
    */
    public Node delete(Node key, Node par)
    {
       if(key == Root)
       {
           par = key;
           key = last(key);
           if(key != null)
           {
               key.set_left(par.get_left());
               key.set_right(par.get_right());
               return key;
           }
       }
       else if(key.get_left() != null && key.get_right()!= null)
       {
           if(key == par.get_left())
           {
               par.set_left(key.get_right());
               par.get_left().set_left(key.get_left());
           }
           else 
           {
               par.set_right(key.get_right());
               par.get_right().set_left(key.get_left());
           }
       }
       else if(key.get_left() == null && key.get_right() == null)
       {
           if(key == par.get_left())
           {
               par.set_left(null);
           }
           else
           {
               par.set_right(null);
           }
       }
       else
       {
           if(key.get_left() == null)
           {
               if(key == par.get_left())
               {
                   par.set_left(key.get_left());
               }
               else
               {
                   par.set_right(key.get_left());
               }
           }
           else
           {
               if(key == par.get_left())
               {
                   par.set_left(key.get_right());
               }
               else
               {
                   par.set_right(key.get_right());
               }
           }
       }
       return this.Root;
    }
    /*
    The last function returns the last node
    @param start is assigned to the key node which is used to get the leftmost node
    */
    private Node last(Node start)
    {
        Node user = null;
        Node par = null;
        Node key = start;
        while(key != null)
        {
            if(key.get_left() != null)
            {
                par = key;
                user = key.get_left();
            }
            key = key.get_left();
        }
        if(par != null)
        {
            par.set_left(null);
        }
        return user;
    }
    /*
    recursive function that prints out node 
    it first prints to the left
    it then prits to the right
    the nextline makes sure it id printed in the correct format
    */
    public void rep(Node node)
    {
     if(node != null) 
     {
         rep(node.get_left());
         rep(node.get_right());
        System.out.printf("%25s%5d%5d",node.get_tit(), node.get_av(), node.get_rent());
         System.out.println();
     }
    }
    /*
    Finds a node recursively to remove when being called 
    */
     public boolean find(Node node, String title, Node par)
     { //if the node is equal to null then false is returned 
        if(node == null)
        {
            return false;
        }
        //if the node is equal to the title it deletes the node
        if(node.get_tit().equals(title))
        {
                delete(node, par);
                return true;
        }//returns the function to make it recursive
        return find(node.get_left(), title, node) || find(node.get_right(), title, node);
    }
}
