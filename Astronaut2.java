import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Astronaut2 extends Enemys
{
    private int speed ;
    private int time;
    private int timer;
    public boolean isSeeing = true;
    public int timerAnimation;
    private int scrolled;
    GreenfootSound shot = new GreenfootSound("pistol.wav");
    
    public Astronaut2()
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
        if(time < 120)
        {
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
        scrolled = ((Scrolling)getWorld()).getUniversalX(getX());
        if(timer == 50)
        {
          ((Scrolling)getWorld()).addObject(new Proyectile(isSeeing), scrolled, getY(), true);    
        }
        if(timer == 60)
        {
         ((Scrolling)getWorld()).addObject(new Proyectile(isSeeing), scrolled, getY(), true);   
        }
        if(timer == 70)
        {
         ((Scrolling)getWorld()).addObject(new Proyectile(isSeeing), scrolled, getY(), true);
          timer=0;
        }
    }

    public void runTimer()
    {
        timerAnimation ++;
        if(timerAnimation == 30)
            timerAnimation = 0;
    }
    
    private void animate()
    {
        if(true)
        {
            
            if(timerAnimation == 0){               
                if(isSeeing)
                    setImage("soldierFusilWalk1.png");
                else
                    setImage("soldierFusilWalk1D.png");
            }
            else if(timerAnimation == 5){
                if(isSeeing)
                    setImage("soldierFusilWalk2.png");
                else
                    setImage("soldierFusilWalk2D.png");
            }
            else if(timerAnimation == 10){
                if(isSeeing)
                    setImage("soldierFusilWalk3.png");
                else
                    setImage("soldierFusilWalk3D.png");
            }
            else if(timerAnimation == 15){
                if(isSeeing)
                    setImage("soldierFusilWalk4.png");
                else
                    setImage("soldierFusilWalk4D.png");
            }
            else if(timerAnimation == 20){
                if(isSeeing)
                    setImage("soldierFusilWalk5.png");
                else
                    setImage("soldierFusilWalk5D.png");
            }

        }
    }
}