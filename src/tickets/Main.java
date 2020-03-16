//Ogheneyoma Akoni
//oxa180001
package tickets;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.regex.*;
import java.util.HashMap;


public class Main 
{
    //The main function
    public static void main(String[] args)throws FileNotFoundException
    {
       //This is the the Printriter variable that writes to the error file when there is an error
       PrintWriter error = new PrintWriter("error.txt");
       BinarySearchTree use = new BinarySearchTree();
       //try catch statement that catches errors 
       try 
       {
            //declaration of variables
            String first,tit;
            //the hold is meant to read the inventory text file
            Scanner hold = new Scanner(new File("inventory5.dat"));
            //while the function has a next line
            while(hold.hasNext()) 
            {
                //sets the string being read to the nextline
                first = hold.nextLine();
                //scanner class object 
                Scanner check = new Scanner(first);
                //scanner class object calls the java use delimeter function to check for the comma
                check.useDelimiter(",");
                //title is assigned to the next variable 
                tit = check.next();
                // it takes the substring in which the begin index and last index are put
                tit = tit.substring(1,tit.length()-1);
                //calls the recursive function that inserts a node
                use.insert_h(new Node(tit, check.nextInt(), check.nextInt(), null, null));

            } 
            //closes th file
            hold.close();
            use.rep(use.get_root());
        } catch (FileNotFoundException e){System.out.println("File not found" + e);}//catch error if file not found
        //transaction text file   reading
        Scanner read = new Scanner(new File("transaction5.log"));
        //while the read has next line
        while(read.hasNext())
        {
            //reads the nextline
            String file = read.nextLine();
            System.out.println("\n");
            use.rep(use.get_root());
            switch(file.substring(0, 3))
            {/* if the case is an add case i.e if the transaction requores adding a new node the insert 
                recursive function is called. A pattern instance is made to match the text against a regular
                expression pattern
            */
                case "add":
                        if(Pattern.compile("[A-Za-z]+\\s+\\\"+[A-za-z0-9\\s\\:\\,\\;\\'\\\\\\.\\?\\!\\(\\)\\{\\}\\[\\]]+\\\"+\\,+[0-9]").matcher(file).find())
                        {
                            file = file.substring(5);
                            String ins = file.substring(0, file.indexOf('\"'));
                            file = file.substring(file.indexOf("\"")+2);
                            //use.insert_h(new Node(ins, Integer.parseInt(file), 0,null,null));
                        }
                        else{
                            error.print(file);
                            error.println();
                        }
                        break;
            /* if the case is an rem case i.e if the transaction requores removing  node the insert 
                recursive function is called. A pattern instance is made to match the text against a regular
                expression pattern
            */
                case "remove":
                       if(Pattern.compile("[A-Za-z]+\\s+\\\"+[A-za-z0-9\\s\\:\\,\\;\\'\\\\\\.\\?\\!\\(\\)\\{\\}\\[\\]]+\\\"+\\,+[0-9]").matcher(file).find()){
                            file = file.substring(8);
                            String header = file.substring(0, file.indexOf('\"'));
                            file = file.substring(file.indexOf("\"")+2);
                            use.insert_h(new Node(header, Integer.parseInt(file)*-1, 0,null,null)); 
                        }
                        else{
                            error.print(file);
                            error.println();
                        }
                        break;
            /* if the case is an ren case i.e if the transaction requores renting  node the insert 
                recursive function is called. A pattern instance is made to match the text against a regular
                expression pattern
            */
                case "rent":
                        if(Pattern.compile("[A-Za-z]+\\s+\\\"+[A-za-z0-9\\s\\:\\,\\;\\'\\\\\\.\\?\\!\\(\\)\\{\\}\\[\\]]+\\\"").matcher(file).find())
                        {
                            file = file.substring(6);
                            use.insert_h(new Node(file.substring(0, file.indexOf('\"')), -1, +1,null,null));
                        }
                        else
                        {
                            error.print(file);
                            error.println();
                       }
                        break;
                        /* if the case is an ret case i.e if the transaction requores remving  node the insert 
                recursive function is called. A pattern instance is made to match the text against a regular
                expression pattern
            */
                case "return":
                        if(Pattern.compile("[A-Za-z]+\\s+\\\"+[A-za-z0-9\\s\\:\\,\\;\\'\\\\\\.\\?\\!\\(\\)\\{\\}\\[\\]]+\\\"").matcher(file).find())
                        {
                            file = file.substring(8);
                            use.insert_h(new Node(file.substring(0, file.indexOf('\"')), +1, -1,null,null));
                        }
                        else
                        {
                            error.print(file);
                            error.println();
                        }
                        break;
                        //insert function deletes and also modifies the nodes
                // this happens when none f the options work therefore an error line is written to the file 
                default:
                       System.out.println("error line");
                       error.print(file);
                       error.println();
            }
        }
        // closes the file after writing to the error file 
        error.close();
        // writes the report to the red_box kiosk file 
        PrintWriter write = new PrintWriter("redbox_kiosk.txt");
        use.rep_r(use.get_root(), write);
        write.close();
    }

}
