import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Diamante extends Items
{
    public boolean Up = false;
    private int desplaza = 1;
    public int ref = 5;
    GreenfootSound coin = new GreenfootSound("Diamante.mp3");

    public Diamante()
    {
        this(35,55);
    }

    public Diamante(int width, int height)
    {
        GreenfootImage image = getImage();
        image.scale(width, height);
        setImage(image);
    }

    public void act() 
    {
        checkForCollisions();
    }

    public void checkForCollisions() 
    {       
        Actor baker = getOneIntersectingObject(Baker.class);
        if( baker != null)
        {
            if(getWorld() instanceof World1)
            {
                World1 mundo = (World1)getWorld();
                HealthBar Health = mundo.getHealthBar();
                Health.recoveryHealth();
            }
            coin.play();
            getWorld().removeObject(this);
        }
    }
}