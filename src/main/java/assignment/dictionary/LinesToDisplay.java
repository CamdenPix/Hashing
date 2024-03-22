package assignment.dictionary;

import java.util.Iterator;


/**
 * A class that will be used to display the lines of text that are corrected.
 *
 */

public class LinesToDisplay {

    public static final int LINES = 10;     // Display 10 lines
    private AList<Wordlet>[] lines;
    private int currentLine;

    /**
     * Constructor for objects of class LinesToDisplay
     */
    public LinesToDisplay() {
        //ADD CODE FOR THE CONSTRUCTOR
//>>>>>>>>>>> ADDED CODE >>>>>>>>>>>>>>>>>>>>>>        
        currentLine = 0;
        lines = new AList[LINES]; //This code isn't safe
        for(int i = 0; i < LINES; i++){
            lines[i] = new AList<Wordlet>(15);
        }
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    }

    /**
     * Add a new wordlet to the current line.
     *
     */
    public void addWordlet(Wordlet w) {
        //ADD CODE HERE TO ADD A WORDLET TO THE CURRENT LINE
//>>>>>>>>>>> ADDED CODE >>>>>>>>>>>>>>>>>>>>>>
        lines[currentLine].add(w);
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    }

    /**
     * Go to the next line, if the number of lines has exceeded LINES, shift
     * them all up by one
     *
     */
    public void nextLine() {
        //ADD CODE TO HANDLE THE NEXT LINE
//>>>>>>>>>>> ADDED CODE >>>>>>>>>>>>>>>>>>>>>>
        int sizeIncrease = 5;
        if(currentLine+1 == lines.length){
            AList<Wordlet>[] temp = new AList[lines.length + sizeIncrease];
            for(int i = 0; i<lines.length; i++)
            {
                temp[i] = lines[i];
            }
            for(int i = lines.length; i<lines.length+sizeIncrease; i++)
            {
                temp[i] = new AList<Wordlet>(15);
            }
            lines = temp;
        }
        currentLine++;
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    }

      
    public int getCurrentLine(){
        return currentLine;
    }
    
    public AList<Wordlet>[] getLines(){
        return lines;
    }
}
