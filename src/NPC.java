import java.util.Random;

/**
 * Created by papazong on 20.02.2015.
 */
public class NPC implements Runnable
{
    public String name;
    public int playerPosition;
    Random zuffi = new Random();

    public NPC(String name, int playerPosition)
    {
        this.name = name;
        this.playerPosition = playerPosition;
    }

    @Override
    public void run()
    {
        while(true)
        {
            synchronized (Game.class)
            {
                if(playerPosition==Game.getCurrentPlayer())
                {
                    int anz=zuffi.nextInt((2)+1);
                    System.out.println("Der Spieler "+name+" hat "+anz+"Streichhoelzer genommen.");
                    Game.takeStreichholz(anz);
                    if(Game.getMaxPlayer()==playerPosition)
                    {
                        Game.setCurrentPlayer(1);

                        notify();
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Game.setCurrentPlayer(++playerPosition);

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
