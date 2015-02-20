/**
 * Created by papazong on 20.02.2015.
 */
public class Game
{

    private static int anzStreichhoelzer;
    private static int currentPlayer;

    public static void takeStreichholz(int anz)
    {
        anzStreichhoelzer-=anz;
    }


    public static int getAnzStreichhoelzer() {
        return anzStreichhoelzer;
    }


    public static void setCurrentPlayer(int currentPlayer) {
        Game.currentPlayer = currentPlayer;
    }

    public static int getCurrentPlayer()
    {
        return currentPlayer;
    }
}
