import java.lang.Math;
public class Dice
{
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
    private int diceCounter;
    public int Roll()
    {
        int roll = (int)Math.round(Math.random()*6);
        if(roll < 1)
        {
            roll = 1;
        }
        return roll;
    }
    public int getP1Str(){
        diceCounter = 0;
        diceCounter = p1StrDice;
        p1StrDice = 0;
        p1StrMultiplier = 0;
        for(int i = diceCounter;i > 0;i--)
        {
            p1StrDice = p1StrDice + Roll();
            if(Roll() >= 4){
                p1StrMultiplier++;
            }
        }
        return p1StrDice;
    }
    public int getP1Dex(){
        diceCounter = 0;
        diceCounter = p1DexDice;
        p1DexDice = 0;
        p1DexMultiplier = 0;
        for(int i = diceCounter;i > 0;i--)
        {
            p1DexDice = p1DexDice + Roll();
            if(Roll() >= 4){
                p1DexMultiplier++;
            }
        }
        return p1DexDice;
    }
    public int getP1Int(){
        diceCounter = 0;
        diceCounter = p1IntDice;
        p1IntDice = 0;
        p1IntMultiplier = 0;
        for(int i = diceCounter;i > 0;i--)
        {   
            p1IntDice = p1IntDice + Roll();
            if(Roll() >= 4){
                p1IntMultiplier++;
            }
        }
        return p1IntDice;
    }
    public int getP1Luk(){
        diceCounter = 0;
        diceCounter = p1LukDice;
        p1LukDice = 0;
        p1LukMultiplier = 0;
        for(int i = diceCounter;i > 0;i--)
        {
            p1LukDice = p1LukDice + Roll();
            if(Roll() >= 4){
                p1LukMultiplier++;
            }
        }
        return p1LukDice;
    }
    public int getP2Str(){
        diceCounter = 0;
        diceCounter = p2StrDice;
        p2StrDice = 0;
        p2StrMultiplier = 0;
        for(int i = diceCounter;i > 0;i--)
        {
            p2StrDice = p2StrDice + Roll();
            if(Roll() >= 4){
                p2StrMultiplier++;
            }
        }
        return p2StrDice;
    }
    public int getP2Dex(){
        diceCounter = 0;
        diceCounter = p2DexDice;
        p2DexDice = 0;
        p2DexMultiplier = 0;
        for(int i = diceCounter;i > 0;i--)
        {
            p2DexDice = p2DexDice + Roll();
            if(Roll() >= 4){
                p2DexMultiplier++;
            }
        }
        return p2DexDice;
    }
    public int getP2Int(){
        diceCounter = 0;
        diceCounter = p2IntDice;
        p2IntDice = 0;
        p2IntMultiplier = 0;
        for(int i = diceCounter;i > 0;i--)
        {
            p2IntDice = p2IntDice + Roll();
            if(Roll() >= 4){
                p2IntMultiplier++;
            }
        }
        return p2IntDice;
    }
    public int getP2Luk(){
        diceCounter = 0;
        diceCounter = p2LukDice;
        p2LukDice = 0;
        p2LukMultiplier = 0;
        for(int i = diceCounter;i > 0;i--)
        {
            p2LukDice = p2LukDice + Roll();
            if(Roll() >= 4){
                p2LukMultiplier++;
            }
        }
        return p2LukDice;
    }
    public int getCompStr(){
        diceCounter = 0;
        diceCounter = compStrDice;
        compStrDice = 0;
        compStrMultiplier = 0;
        for(int i = diceCounter;i > 0;i--)
        {
            compStrDice = compStrDice + Roll();
            if(Roll() >= 4){
                compStrMultiplier++;
            }
        }
        return compStrDice;
    }
    public int getCompDex(){
        diceCounter = 0;
        diceCounter = compDexDice;
        compDexDice = 0;
        compDexMultiplier = 0;
        for(int i = diceCounter;i > 0;i--)
        {
            compDexDice = compDexDice + Roll();
            if(Roll() >= 4){
                compDexMultiplier++;
            }
        }
        return compDexDice;
    }
    public int getCompInt(){
        diceCounter = 0;
        diceCounter = compIntDice;
        compIntDice = 0;
        compIntMultiplier = 0;
        for(int i = diceCounter;i > 0;i--)
        {
            compIntDice = compIntDice + Roll();
            if(Roll() >= 4){
                compIntMultiplier++;
            }
        }
        return compIntDice;
    }
    public int getCompLuk(){
        diceCounter = 0;
        diceCounter = compLukDice;
        compLukDice = 0;
        compLukMultiplier = 0;
        for(int i = diceCounter;i > 0;i--)
        {
            compLukDice = compLukDice + Roll();
            if(Roll() >= 4){
                compLukMultiplier++;
            }
        }
        return compLukDice;
    }
    public int getP1StrMultiplier(){
        return p1StrMultiplier;
    }
    public int getP1DexMultiplier(){
        return p1DexMultiplier;
    }
    public int getP1IntMultiplier(){
        return p1IntMultiplier;
    }
    public int getP1LukMultiplier(){
        return p1LukMultiplier;
    }
    public int getP2StrMultiplier(){
        return p2StrMultiplier;
    }
    public int getP2DexMultiplier(){
        return p2DexMultiplier;
    }
    public int getP2IntMultiplier(){
        return p2IntMultiplier;
    }
    public int getP2LukMultiplier(){
        return p2LukMultiplier;
    }
    public int getCompStrMultiplier(){
        return compStrMultiplier;
    }
    public int getCompDexMultiplier(){
        return compDexMultiplier;
    }
    public int getCompIntMultiplier(){
        return compIntMultiplier;
    }
    public int getCompLukMultiplier(){
        return compLukMultiplier;
    }
    public void setP1Dice(int str, int dex, int inte, int luk)
    {
        p1StrDice = str;
        p1DexDice = dex;
        p1IntDice = inte;
        p1LukDice = luk;
    }
    public void setP2Dice(int str, int dex, int inte, int luk)
    {
        p2StrDice = str;
        p2DexDice = dex;
        p2IntDice = inte;
        p2LukDice = luk;
    }
    public void setCompDice(int str, int dex, int inte, int luk)
    {
        compStrDice = str;
        compDexDice = dex;
        compIntDice = inte;
        compLukDice = luk;
    }
}
