/**This class doesn't do much other than start the game.
 * 
 * ----Things to work on in GameFunction.
 * -Fix how the points are awarded because they only get awarded at the end of both attacks instead of as soon as
 * someone's health reaches zero
 * -Redo the rules
 * -Bug test more
 * 
 */
import java.io.FileNotFoundException;
public class DiceGame
{
  public static void main(String[] args) throws FileNotFoundException
  {
     GameFunction newGame = new GameFunction(args);
     newGame.newGame();
      
  }
}
