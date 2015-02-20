import java.util.Random;

/**
 * Created by papazong on 20.02.2015.
 */
public class Player implements Runnable
{
    String name;
    Random zuffi = new Random();

    @Override
    public void run()
    {
        while(true)
        {
            synchronized (Game.class)
            {
                if (Game.getCurrentPlayer() == 1)
                {
                    Game.setCurrentPlayer(2);

                    int anz = zuffi.nextInt((2) + 1);
                    System.out.println("Der Spieler " + name + " hat " + anz + "Strecihhoelzer genommen");
                    Game.takeStreichholz(anz);

                    notify();

                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                notify();
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
