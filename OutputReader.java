import java.util.Scanner;
import java.lang.NumberFormatException;
import java.io.File;
import java.io.FileNotFoundException;

public class OutputReader{
    public OutputReader(){
        //I do nothing!
    }
    /**
     * This class only exists for this method
     * I had three seperate methods for the counters but realized this was better
     */
    public String counter() throws FileNotFoundException{
        //The method sees the file and sets up its internals
        Scanner in = new Scanner(new File("output.txt"));
        int lineCounter = 0;
        int wordCounter = 0;
        int numCounter = 0;
        //Loop that goes through the document as long as something exists
        while(in.hasNext()){
            //Easy money
            lineCounter++;
            //I remembered this from the NameSorter we did. It helped.
            String[] helper = in.nextLine().split(" ");
            for(int i = 0; i<helper.length;i++){
                //Little try catch that sort of works as an if else statement.
                //in.next is either able to become a number or it is not.
                try{
                    int a = Integer.parseInt(helper[i]);
                    numCounter++;
                }
                catch(NumberFormatException nfe){
                    wordCounter++;
                }
            }
        }
        return "Lines: " + lineCounter + "\n" + "Words: " + wordCounter +
         "\n" + "Numbers: " + numCounter;
    }
}
