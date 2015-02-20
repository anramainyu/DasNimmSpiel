/**
 * Created by papazong on 20.02.2015.
 */
public class Main
{
    public static void main (String[] args)
    {
        Game g1 = new Game();
        g1.setMaxPlayer(4);

        Player spieler = new Player("Spieler1");
        NPC npc1 = new NPC("npc1",1);
        NPC npc2 = new NPC("npc2",2);
        NPC npc3 = new NPC("npc3",3);
        new Thread(spieler,"thread1").start();
        new Thread(npc1,"thread2").start();
        new Thread(npc2,"thread3").start();
        new Thread(npc3,"thread4").start();


    }
}
