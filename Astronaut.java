import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Astronaut extends Enemys
{
    private int speed ;
    private int time;
    private int timer;
    public boolean isSeeing = true;
    public int timerAnimation;
    private int scrolled;
    GreenfootSound shot = new GreenfootSound("pistol.wav");
    
    public Astronaut()
    {
        timer = timer = timerAnimation = 0;
        speed = -1;
    }
    public void act() 
    {
        time++;
        moveAround();
        fireProyectile();
        runTimer();
        animate();
    }
    
    public void moveAround()
    {
        if(time < 120){
            setLocation(getX() + speed, getY());
        }
        else
        {
            isSeeing = !isSeeing;
            speed = -speed;
            time = 0;
        }
    }
    
    public void fireProyectile()
    {
        timer++;
        scrolled = ((Scrolling)getWorld()).getUnivX(getX());
        if(timer > 110)
        {
            ((Scrolling)getWorld()).addObject(new Proyectile(isSeeing), scrolled, getY(), true);
            timer = 0;
        }
    }

    public void runTimer()
    {
        timerAnimation++;
        if(timerAnimation == 30)
            timerAnimation = 0;
    }
    
    private void animate()
    {
        if(true)
        {
            
            if(timerAnimation == 0){               
                if(isSeeing)
                    setImage("soldierGunWalk1.png");
                else
                    setImage("soldierGunWalk1D.png");
            }
            else if(timerAnimation == 5){
                if(isSeeing)
                    setImage("soldierGunWalk2.png");
                else
                    setImage("soldierGunWalk2D.png");
            }
            else if(timerAnimation == 10){
                if(isSeeing)
                    setImage("soldierGunWalk3.png");
                else
                    setImage("soldierGunWalk3D.png");
            }
            else if(timerAnimation == 15){
                if(isSeeing)
                    setImage("soldierGunWalk4.png");
                else
                    setImage("soldierGunWalk4D.png");
            }
            else if(timerAnimation == 20){
                if(isSeeing)
                    setImage("soldierGunWalk5.png");
                else
                    setImage("soldierGunWalk5D.png");
            }
        }
    }
}
