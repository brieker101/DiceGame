/**This class is the main meat of the DiceBattleSimulator. This holds all of the parts except for the rolls. I split the rolls into a different class so I could use all the 
 * Str,Dex,Int, and Luk variables twice. It worked out pretty well. I only ran into one problem with setting the computer's rolls. The variables that are equal to zero before
 * the computer makes its rolls are to prevent the computer from utterly obliterating the player character. This was fun to make and now my hands hurt.
 * @author Brian Hauck
 * @version 1/26/2017
 */
import java.util.Scanner;
import java.io.PrintStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

public class GameFunction
{
    /**
     * Misc variables used for a few specific things
     */
    private String viewRules;
    private int players = 1;
    private String player1;
    private String player2;
    private int dice = 7;
    private int compCounter;

    /**
     * Health and points storages
     */
    private int p1Health;
    private int p2Health;
    private int compHealth;

    private int p1Points;
    private int p2Points;
    private int compPoints;

    /**
     * Roll count storages and roll value storages
     * 
     */
    private int p1StrDice;
    private int p1DexDice;
    private int p1IntDice;
    private int p1LukDice;

    private int p2StrDice;
    private int p2DexDice;
    private int p2IntDice;
    private int p2LukDice;

    private int compStrDice;
    private int compDexDice;
    private int compIntDice;
    private int compLukDice;

    /**
     * Rolls that are 4 and up are counted and stored in these
     */
    private int p1StrMultiplier;
    private int p1DexMultiplier;
    private int p1IntMultiplier;
    private int p1LukMultiplier;

    private int p2StrMultiplier;
    private int p2DexMultiplier;
    private int p2IntMultiplier;
    private int p2LukMultiplier;

    private int compStrMultiplier;
    private int compDexMultiplier;
    private int compIntMultiplier;
    private int compLukMultiplier;

    //General use Constructors
    String[] args;
    Dice diceRoll = new Dice();
    Scanner in = new Scanner(System.in);    
    PrintStream out;
    public GameFunction(String[] arguments) throws FileNotFoundException{
        out = new PrintStream(new File("output.txt"));
        //Passes the comman line arguments from the tester method to here. 
        //args[0] determines whether or not the game will be recorded.
        //args[1] determines whether the stats will be printed out
        args = arguments;
    }

    /**
     * Modification to the original program that writes everything to a file
     */
    public void printSplitter(String writer) throws FileNotFoundException{
        System.out.println(writer);
        //A little bit of handling for no command line arguments
        if(args.length>0){
            if(args[0].equals("yes")||args[0].equals("y")){
                out.println(writer);
            }
        }
    }

    public String inputSplitter(String input) throws FileNotFoundException, InputMismatchException{
        if(args.length>0){
            if(args[0].equals("yes")||args[0].equals("y")){
                out.println(input);
            }
        }
        return input;
    }

    public int inputSplitter(int input) throws FileNotFoundException, InputMismatchException{
        if(args.length>0){
            if(args[0].equals("yes")||args[0].equals("y")){
                out.println(input);
            }
        }
        return input;
    }

    /**
     * Method that can be used for the second or third game in a row.
     * This avoids asking for the same players names again.
     */
    public void setTwoPlayerGameHealth() throws FileNotFoundException{
        printSplitter("Enter " + player1 + "'s health:" );
        p1Health = inputSplitter(in.nextInt());
        printSplitter("Enter " + player2 + "'s health:" );
        p2Health = inputSplitter(in.nextInt());
    }

    /**
     * Method to ask for just health from the player
     */
    public void setOnePlayerGameHealth( ) throws FileNotFoundException{
        printSplitter("Enter " + player1 + "'s health:" );
        p1Health = inputSplitter(in.nextInt() );
        printSplitter("Enter the computer's health:" );
        compHealth = inputSplitter(in.nextInt() );
    }

    /**
     * @param How many of each dice go into each category, should add up to 7(Player 1).
     * Luckily, I can set all 4 at the same time.
     */
    public void setP1Dice(int str, int dex, int inte, int luk)
    {
        p1StrDice = str;
        p1DexDice = dex;
        p1IntDice = inte;
        p1LukDice = luk;
        diceRoll.setP1Dice(p1StrDice, p1DexDice, p1IntDice, p1LukDice);
        p1StrDice = diceRoll.getP1Str();
        p1DexDice = diceRoll.getP1Dex();
        p1IntDice = diceRoll.getP1Int();
        p1LukDice = diceRoll.getP1Luk();
        p1StrMultiplier = diceRoll.getP1StrMultiplier();
        p1DexMultiplier = diceRoll.getP1DexMultiplier();
        p1IntMultiplier = diceRoll.getP1IntMultiplier();
        p1LukMultiplier = diceRoll.getP1LukMultiplier();
    }

    /**
     * @param How many of each dice go into each category, should add up to 7(Player 2).
     * Luckily, I can set all 4 at the same time.
     */
    public void setP2Dice(int str, int dex, int inte, int luk) throws FileNotFoundException
    {
        p2StrDice = str;
        p2DexDice = dex;
        p2IntDice = inte;
        p2LukDice = luk;
        diceRoll.setP2Dice(p2StrDice, p2DexDice, p2IntDice, p2LukDice);
        p2StrDice = diceRoll.getP2Str();
        p2DexDice = diceRoll.getP2Dex();
        p2IntDice = diceRoll.getP2Int();
        p2LukDice = diceRoll.getP2Luk();
        p2StrMultiplier = diceRoll.getP2StrMultiplier();
        p2DexMultiplier = diceRoll.getP2DexMultiplier();
        p2IntMultiplier = diceRoll.getP2IntMultiplier();
        p2LukMultiplier = diceRoll.getP2LukMultiplier();
        twoPlayerDuel();
    }

    /**
     * @param How many of each dice go into each category, should add up to 7(Computer).
     * Luckily, I can set all 4 at the same time.
     */
    public void setCompDice(int str, int dex, int inte, int luk) throws FileNotFoundException
    {
        compStrDice = str;
        compDexDice = dex;
        compIntDice = inte;
        compLukDice = luk;
        diceRoll.setCompDice(compStrDice, compDexDice, compIntDice, compLukDice);
        compStrDice = diceRoll.getCompStr();
        compDexDice = diceRoll.getCompDex();
        compIntDice = diceRoll.getCompInt();        
        compLukDice = diceRoll.getCompLuk();
        compStrMultiplier = diceRoll.getCompStrMultiplier();
        compDexMultiplier = diceRoll.getCompDexMultiplier();
        compIntMultiplier = diceRoll.getCompIntMultiplier();
        compLukMultiplier = diceRoll.getCompLukMultiplier();
        onePlayerDuel();
    }

    /**
     * This is what the DiceGame class calls on to start the game.
     */
    public void newGame() throws FileNotFoundException{
        printSplitter("Welcome to the VS Dice Game!" );
        printSplitter("View Rules? (Y/N): " );
        viewRules = inputSplitter(in.next());

        //Asks to displays rules once
        if((viewRules == "Y")||(viewRules == "y"))
        {
            printSplitter("The rules of the game go as thus:");
            printSplitter("Rule #1: There are 4 main stats (Strength, Dexterity, Intelligence, and Luck.)"); 
            printSplitter("Rule #2: There are 7 die.  All of them are assigned by the player/computer to the 4 stats.");
            printSplitter("Rule #3: The values of the die will determine your bonuses which determine your attack, healing, and chance.");
            printSplitter("Rule #4: Players start    with set amount of health and the game ends when one player reaches zero. The person still alive receives a point.");
        }    

        try{
            printSplitter("Are there going to be 1 or 2 players?" );
            players = inputSplitter(in.nextInt());
        }
        catch(InputMismatchException e){
            printSplitter("Enter 1 or 2 please!");
            while(!in.hasNextInt()){
                printSplitter("Are there going to be 1 or 2 players?" );
                players = inputSplitter(in.nextInt());
            }
        }

        if (players == 2)
        {
            printSplitter("Please enter Player 1's name:" );
            player1 = inputSplitter(in.next());
            printSplitter("Please enter Player 2's name:" );
            player2 = inputSplitter(in.next());
            setTwoPlayerGameHealth();
            twoPlayerDiceRoll();
        }
        else
        {
            printSplitter("Please enter Player 1's name:" );
            player1 = inputSplitter(in.next());
            setOnePlayerGameHealth();
            onePlayerDiceRoll();
        }
    }

    /**
     * Starts the one player gamemode versus a computer.
     * I tried to make the computer play conservatively and be hard to beat.(e.g. no high luk rolls)
     */
    public void onePlayerDiceRoll() throws FileNotFoundException{
        printSplitter(player1 + ", enter your die assignment:" );
        while(((p1StrDice+p1DexDice+p1IntDice+p1LukDice)<dice)||(p1StrDice+p1DexDice+p1IntDice+p1LukDice)>dice){
            printSplitter("The die amounts should add up to 7." );
            printSplitter("Strength: ");
            p1StrDice = inputSplitter(in.nextInt());
            printSplitter("Dexterity: " );
            p1DexDice = inputSplitter(in.nextInt());
            printSplitter("Intelligence: " );
            p1IntDice = inputSplitter(in.nextInt());
            printSplitter("Luck: " );
            p1LukDice = inputSplitter(in.nextInt());
        }
        printSplitter("The computer will now assign their die.");
        //Remove these and the computer will become invincible
        compStrDice = 0;
        compDexDice = 0;
        compIntDice = 0;
        compLukDice = 0;
        //Cool little die selector I made
        for(int i = 7;i>0;i--){
            compCounter = diceRoll.Roll();
            if((compCounter==1)||(compCounter==2)){
                compStrDice++;
            }
            if(compCounter==3){
                compDexDice++;
            }
            if((compCounter==4)||(compCounter==5)){
                compIntDice++;
            }
            if(compCounter==6){
                compLukDice++;
            }
        }
        setP1Dice(p1StrDice, p1DexDice, p1IntDice, p1LukDice);
        setCompDice(compStrDice, compDexDice, compIntDice, compLukDice );

    }

    /**
     * My blood, sweat, and tears went into figuring    how to make this work. Professor Hoy, I'll tell you right now that I am an Info Systems major. I did 
     * that mainly because I don't enjoy thinking very hard and I don't prefer programming. You're a cool teacher so I'll try my best.
     */
    public void twoPlayerDiceRoll(  ) throws FileNotFoundException{
        printSplitter(player1 + " will now enter their desired die assignment." );
        //While the dice amounts are less than 7, don't let the tortured excape
        while(((p1StrDice+p1DexDice+p1IntDice+p1LukDice)<dice)||(p1StrDice+p1DexDice+p1IntDice+p1LukDice)>dice){
            printSplitter("The die amounts should add up to 7." );
            printSplitter("Strength: " );
            p1StrDice = inputSplitter(in.nextInt() );
            printSplitter("Dexterity: " );
            p1DexDice = inputSplitter(in.nextInt() );
            printSplitter("Intelligence: " );
            p1IntDice = inputSplitter(in.nextInt() );
            printSplitter("Luck: " );
            p1LukDice = inputSplitter(in.nextInt() );
        }
        printSplitter(player2 + " will now enter their desired die assignment." );
        printSplitter("The die amounts should add up to 7." );
        //While the dice amounts are less than 7, don't let the tortured excape
        while(((p2StrDice+p2DexDice+p2IntDice+p2LukDice)<dice)||((p2StrDice+p2DexDice+p2IntDice+p2LukDice)>dice)){
            printSplitter("Strength: " );
            p2StrDice = inputSplitter(in.nextInt() );
            printSplitter("Dexterity: " );
            p2DexDice = inputSplitter(in.nextInt() );
            printSplitter("Intelligence: " );
            p2IntDice = inputSplitter(in.nextInt() );
            printSplitter("Luck: " );
            p2LukDice = inputSplitter(in.nextInt() );
        }
        setP1Dice(p1StrDice, p1DexDice, p1IntDice, p1LukDice);
        setP2Dice(p2StrDice, p2DexDice, p2IntDice, p2LukDice );
    }

    public void onePlayerDuel(  ) throws FileNotFoundException
    {
        if(p1DexDice>compDexDice)
        {
            printSplitter("With a value of " + p1DexDice + ", " + player1 + " goes first " + ("\n") + "and the computer will go second with a value of " + compDexDice + "." + "\n" );
        }
        else if(p1DexDice<compDexDice)
        {
            printSplitter("With a value of " + compDexDice + ", the computer goes first " + "\n" + "and " + player1 + " will go second with a value of " + p1DexDice + "." + "\n" );
        }
        else if(p1DexDice==compDexDice)
        {
            printSplitter(player1 + " and the computer tied with a speed value of " + p1DexDice + ". A tie breaker will now occur" + "\n" );
            while (p1DexDice==compDexDice)
            {
                //Quick tie breaker I thought up, worked well.
                p1DexDice = diceRoll.Roll();
                compDexDice = diceRoll.Roll();
                if(p1DexDice>compDexDice)
                {
                    printSplitter("With a value of " + p1DexDice + ", " + player1 + " goes first " + ("\n") +"and the computer will go second with a value of " + compDexDice + "." + "\n" );
                }
                else if(p1DexDice<compDexDice)
                {
                    printSplitter("With a value of " + compDexDice + ", the computer goes first " + ("\n") +"and " + player1 + " will go second with a value of " + p1DexDice + "." + "\n" );
                }
                else if(p1DexDice==compDexDice)
                {
                    printSplitter(player1 + " and the computer tied with a speed value of " + p1DexDice + ". A tie breaker will now occur" + "\n" );
                }
            }
        }
        if(p1StrDice>compStrDice)
        {
            printSplitter(player1 + " had a greater attack value of " + p1StrDice + " and got " + p1StrMultiplier + " multiplier(s).(+3 Attack)" );
            printSplitter("The computer had a lesser attack value of " + compStrDice + " and got " + compStrMultiplier + " multiplier(s).(+3 Attack)" + "\n" );
        }
        else if (p1StrDice<compStrDice)
        {
            printSplitter("The computer had a greater attack value of " + compStrDice + " and got " + compStrMultiplier + " multiplier(s).(+3 Attack)" );
            printSplitter(player1 + " had a lesser attack value of " + p1StrDice + " and got " + p1StrMultiplier + " multiplier(s).(+3 Attack)" + "\n" );
        }
        else if (p1StrDice==compStrDice){
            printSplitter("Both players obtained an attack value of " + p1StrDice + ". \n" + player1 +" received " + p1StrMultiplier + " multiplier(s) and the computer" +
                "received " + compStrMultiplier + " multiplier(s). (+3 Attack)" + "\n" );
        }
        printSplitter(player1 + " got " + p1IntMultiplier + " life bonus(es) and the computer got " + compIntMultiplier + " life bonus(es). (+3 Life)" + "\n" );
        if(p1LukDice>compLukDice)
        {
            printSplitter(player1 + " had a greater Chance value of " + p1LukDice + " and got " + p1LukMultiplier + " multiplier(s).(+5 Attack/Take 2X Damage)" );
            printSplitter("The computer had a lesser Chance value of " + compLukDice + " and got " + compLukMultiplier + " multiplier(s).(+5 Attack/Take 2X Damage)" + "\n" );
        }
        else if (p1LukDice<compLukDice)
        {
            printSplitter("The computer had a greater Chance value of " + compLukDice + " and got " + compLukMultiplier + " multiplier(s).(+5 Attack/Take 2X Damage)" );
            printSplitter(player1 + " had a lesser Chance value of " + p1LukDice + " and got " + p1LukMultiplier + " multiplier(s).(+5 Attack/Take 2X Damage)" + "\n" );
        }
        else if (p1LukDice==compLukDice)
        {
            printSplitter("Both players obtained an Chance value of " + p1LukDice + ". \n" + player1 +" received " + p1LukMultiplier + " multiplier(s) and the computer" +
                " received " + compLukMultiplier + " multiplier(s). (+5 Attack/Take 2X Damage)" + "\n" );
        }

        if (compLukMultiplier > 0)
        {
            compHealth = compHealth - 2*p1StrMultiplier*3;
            compHealth = compHealth - 2*p1LukMultiplier*5; 
            compHealth = compHealth + compIntMultiplier*3;
        }
        else if (compLukMultiplier == 0){
            compHealth = compHealth - p1StrMultiplier*3;
            compHealth = compHealth - p1LukMultiplier*5; 
            compHealth = compHealth + compIntMultiplier*3;
        }
        if (p1LukMultiplier > 0)
        {
            p1Health = p1Health - 2*compStrMultiplier*3;
            p1Health = p1Health - 2*compLukMultiplier*5; 
            p1Health = p1Health + p1IntMultiplier*3;
        }
        else if(p1LukMultiplier == 0){
            p1Health = p1Health - compStrMultiplier*3;
            p1Health = p1Health - compLukMultiplier*5; 
            p1Health = p1Health + p1IntMultiplier*3;
        }
        if(p1DexDice>compDexDice){
            if(compHealth <= 0)
            {
                printSplitter(player1 +"'s HP: " + p1Health );
                printSplitter("The computer's HP: " + compHealth );
                printSplitter(player1 + " has bested the computer and gets +1 point." );
                p1Points++; 
                if(p1Points >= 2){
                    finale(  );
                }
                else if(p1Points < 2){
                    setOnePlayerGameHealth(  );
                    onePlayerDiceRoll(  );
                }
            }
            else if(p1Health <= 0)
            {
                printSplitter(player1 +"'s HP: " + p1Health );
                printSplitter("The computer's HP: " + compHealth );
                printSplitter("The computer has bested " + player1 + " and gets +1 point." );
                compPoints++; 
                if(compPoints >= 2){
                    finale(  );
                }
                else if(compPoints < 2){
                    setOnePlayerGameHealth(  );
                    onePlayerDiceRoll(  );
                }
            } 
        }

        if(p1DexDice<compDexDice){
            if(p1Health <= 0)
            {
                printSplitter(player1 +"'s HP: " + p1Health );
                printSplitter("The computer's HP: " + compHealth );
                printSplitter("The computer has bested " + player1 + " and gets +1 point." );
                compPoints++; 
                if(compPoints >= 2){
                    finale(  );
                }
                else if(compPoints < 2){
                    setOnePlayerGameHealth(  );
                    onePlayerDiceRoll(  );
                }
            } 
            else if(compHealth <= 0)
            {
                printSplitter(player1 +"'s HP: " + p1Health );
                printSplitter("The computer's HP: " + compHealth );
                printSplitter(player1 + " has bested the computer and gets +1 point." );
                p1Points++; 
                if(p1Points >= 2){
                    finale(  );
                }
                else if(p1Points < 2){
                    setOnePlayerGameHealth(  );
                    onePlayerDiceRoll(  );
                }
            }
        }
        if((p1Health>0)&&(compHealth>0)){
            printSplitter(player1 +"'s HP: " + p1Health );
            printSplitter("The computer's HP: " + compHealth + "\n" );
            onePlayerDiceRoll(  );
        }
    }

    public void twoPlayerDuel(  ) throws FileNotFoundException
    {  
        if(p1DexDice>p2DexDice)
        {
            printSplitter("With a value of " + p1DexDice + ", " + player1 + " goes first " + ("\n") +"and " + player2 + " will go second with a value of " + p2DexDice + "." + "\n" );
        }
        else if(p1DexDice<p2DexDice)
        {
            printSplitter("With a value of " + p2DexDice + ", " + player2 + " goes first " + ("\n") +"and " + player1 + " will go second with a value of " + p1DexDice + "." + "\n" );
        }
        else if(p1DexDice==p2DexDice)
        {
            printSplitter(player1 + " and " + player2 + " tied with a speed value of " + p1DexDice + ". A tie breaker will now occur" + "\n" );
            while (p1DexDice==p2DexDice)
            {
                p1DexDice = diceRoll.Roll();
                p2DexDice = diceRoll.Roll();
                if(p1DexDice>p2DexDice)
                {
                    printSplitter("With a value of " + p1DexDice + ", " + player1 + " goes first " + ("\n") +"and " + player2 + " will go second with a value of " + p2DexDice + "." + "\n" );
                }
                else if(p1DexDice<p2DexDice)
                {
                    printSplitter("With a value of " + p2DexDice + ", " + player2 + " goes first " + ("\n") +"and " + player1 + " will go second with a value of " + p1DexDice + "." + "\n" );
                }
                else if(p1DexDice==p2DexDice)
                {
                    printSplitter(player1 + " and " + player2 + " tied with a speed value of " + p1DexDice + ". A tie breaker will now occur" + "\n" );
                }
            }
        }
        if(p1StrDice>p2StrDice)
        {
            printSplitter(player1 + " had a greater attack value of " + p1StrDice + " and got " + p1StrMultiplier + " multiplier(s).(+3 Attack)" );
            printSplitter(player2 + " had a lesser attack value of " + p2StrDice + " and got " + p2StrMultiplier + " multiplier(s).(+3 Attack)" + "\n" );
        }
        else if (p1StrDice<p2StrDice)
        {
            printSplitter(player2 + " had a greater attack value of " + p2StrDice + " and got " + p2StrMultiplier + " multiplier(s).(+3 Attack)" );
            printSplitter(player1 + " had a lesser attack value of " + p1StrDice + " and got " + p1StrMultiplier + " multiplier(s).(+3 Attack)" + "\n" );
        }
        else if (p1StrDice==p2StrDice){
            printSplitter("Both players obtained an attack value of " + p1StrDice + ". \n" + player1 +" received " + p1StrMultiplier + " multiplier(s) and " + player2 +
                " received " + p2StrMultiplier + " multiplier(s). (+3 Attack)" + "\n" );
        }
        printSplitter(player1 + " got " + p1IntMultiplier + " life bonus(es) and " + player2 + " got " + p2IntMultiplier + " life bonus(es). (+3 Life)" );
        if(p1LukDice>p2LukDice)
        {
            printSplitter(player1 + " had a greater Chance value of " + p1LukDice + " and got " + p1LukMultiplier + " multiplier(s).(+5 Attack/Take 2X Damage)" );
            printSplitter(player2 + " had a lesser Chance value of " + p2LukDice + " and got " + p2LukMultiplier + " multiplier(s).(+5 Attack/Take 2X Damage)" + "\n" );
        }
        else if (p1LukDice<p2LukDice)
        {
            printSplitter(player2 + " had a greater Chance value of " + p2LukDice + " and got " + p2LukMultiplier + " multiplier(s).(+5 Attack/Take 2X Damage)" );
            printSplitter(player1 + " had a lesser Chance value of " + p1LukDice + " and got " + p1LukMultiplier + " multiplier(s).(+5 Attack/Take 2X Damage)" + "\n" );
        }
        else if (p1LukDice==p2LukDice)
        {
            printSplitter("Both players obtained an Chance value of " + p1LukDice + ". \n" + player1 +" received " + p1LukMultiplier + " multiplier(s) and " + player2 +
                " received " + p2LukMultiplier + " multiplier(s). (+5 Attack/Take 2X Damage)" + "\n" );
        }
        if (p1LukMultiplier > 0)
        {
            p1Health = p1Health - 2*p2StrMultiplier*3;
            p1Health = p1Health - 2*p2LukMultiplier*5; 
            p1Health = p1Health + p1IntMultiplier*3;
        }
        else if (p1LukMultiplier == 0){
            p1Health = p1Health - p2StrMultiplier*3;
            p1Health = p1Health - p2LukMultiplier*5; 
            p1Health = p1Health + p1IntMultiplier*3; 
        }
        if (p2LukMultiplier > 0)
        {
            p2Health = p2Health - 2*p1StrMultiplier*3;
            p2Health = p2Health - 2*p1LukMultiplier*5; 
            p2Health = p2Health + p2IntMultiplier*3; 
        }
        else if (p2LukMultiplier == 0){
            p2Health = p2Health - p1StrMultiplier*3;
            p2Health = p2Health - p1LukMultiplier*5; 
            p2Health = p2Health + p2IntMultiplier*3; 
        }
        if(p1DexDice>p2DexDice){
            if(p2Health <= 0)
            {
                printSplitter(player1 +"'s HP: " + p1Health  );
                printSplitter(player2 +"'s HP: " + p2Health );
                printSplitter(player1 + " has bested " + player2 + " and gets +1 point." );
                p2Points++; 
                if(p1Points >= 2){
                    finale(  );
                }
                else if(p1Points < 2){
                    setTwoPlayerGameHealth(  );
                    twoPlayerDiceRoll(  );
                }
            }    
            else if(p1Health <= 0)
            {
                printSplitter(player1 +"'s HP: " + p1Health );
                printSplitter(player2 +"'s HP: " + p2Health );
                printSplitter(player2 + " has bested " + player1 + " and gets +1 point." );
                p1Points++; 
                if(p2Points >= 2){
                    finale(  );
                }
                else if(p2Points < 2){
                    setTwoPlayerGameHealth(  );
                    twoPlayerDiceRoll(  );
                }
            }
        }
        if(p1DexDice<p2DexDice){
            if(p1Health <= 0)
            {
                printSplitter(player1 +"'s HP: " + p1Health );
                printSplitter(player2 +"'s HP: " + p2Health );
                printSplitter(player2 + " has bested " + player1 + " and gets +1 point." );
                p1Points++; 
                if(p2Points >= 2){
                    finale(  );
                }
                else if(p2Points < 2){
                    setTwoPlayerGameHealth(  );
                    twoPlayerDiceRoll(  );
                }
            }
            else  if(p2Health <= 0)
            {
                printSplitter(player1 +"'s HP: " + p1Health );
                printSplitter(player2 +"'s HP: " + p2Health );
                printSplitter(player1 + " has bested " + player2 + " and gets +1 point." );
                p1Points++; 
                if(p1Points >= 2){
                    finale(  );
                }
                else if(p1Points < 2){
                    setTwoPlayerGameHealth(  );
                    twoPlayerDiceRoll(  );
                }
            }
        }
        if((p1Health>0)&&(p2Health>0)){
            printSplitter(player1 +"'s HP: " + p1Health );
            printSplitter(player2 +"'s HP: " + p2Health );
            twoPlayerDiceRoll(  );
        }
    }

    public void finale(  ) throws FileNotFoundException{
        printSplitter("Thank you for playing!" );
        if(p1Points>=2){
            printSplitter("Like the 1 in your player count, you are the best " + player1 );
        }
        else if(p2Points>=2){
            printSplitter("Great job on crushing " + player1 + "'s hopes and dreams, " + player2 );
        }
        else if(compPoints>=2){
            printSplitter("You lost to a computer! Wow!" );
        }
        if(args.length>1){
            if(args[1].equals("yes")||args[1].equals("y")){
                //Printing and writing the stats of the game
                OutputReader output = new OutputReader();
                printSplitter(output.counter());
            }
        }
    }
}
