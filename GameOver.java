import greenfoot.*;

public class GameOver extends World
{
    private int enterDelayCount;
    GreenfootSound lost = new GreenfootSound("Lost.wav");
    GreenfootSound clicked = new GreenfootSound("Clicked.wav");
    Scrolling mainHp;

    public GameOver()
    {    
        super(600, 400, 1); 
        lost.play();
    }

    public void act()
    {      
        mainHp.HP = 10;
        enterDelayCount ++;
        if (Greenfoot.isKeyDown("enter") && enterDelayCount > 15)
        {
            clicked.play();
            Greenfoot.setWorld(new IntroPortada());
        }
    }
}
