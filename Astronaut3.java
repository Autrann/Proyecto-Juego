import greenfoot.*;

public class Astronaut3 extends Enemys
{
    private int speed ;
    private int timer;
    public boolean isSeeing = true;
    private int scrolled;
    private int seeing;
    private GreenfootImage imageL;
    private GreenfootImage imageR;
    GreenfootSound shot = new GreenfootSound("pistol.wav");
    
    public Astronaut3(){
        timer = 0;
        speed = -1;
        imageL = new GreenfootImage("soldierShotgun.png");
        imageR = new GreenfootImage("soldierShotgunD.png");
        setImage(imageL);
    }
    public void act() 
    {
        moveAround();
        fireProyectile();
    }
    
    public void moveAround(){
        if ( ! getWorld().getObjects(Baker.class).isEmpty() )
        {
            Baker act = (Baker) getWorld().getObjects(Baker.class).get(0);
            if (act.getXCoord() > getX())
            {
                isSeeing = false;
                setImage(imageR);
            }
            if (act.getXCoord() < getX())
            {
                isSeeing = true;
                setImage(imageL);
            }
        }
    }
    
    public void fireProyectile(){
        timer++;
        scrolled = ((Scrolling)getWorld()).getUnivX(getX());
        if(timer>110){
            ((Scrolling)getWorld()).addObject(new Proyectile(isSeeing), scrolled, getY(), true);
            ((Scrolling)getWorld()).addObject(new ProyectileY(isSeeing), scrolled, getY(), true);
            ((Scrolling)getWorld()).addObject(new ProyectileX(isSeeing), scrolled, getY(), true);
            timer = 0;
        }
    }

}
