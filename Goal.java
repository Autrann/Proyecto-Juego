import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Goal here.
 * 
 * @author (Jose Alfredo) 
 * @version (a version number or a date)
 */
public class Goal extends struct
{
    GreenfootSound coin = new GreenfootSound("Diamante.mp3");
    public GreenfootSound music = new GreenfootSound("World.mp3");
    public int hola = 1;
    public int flag1;
    
    public Goal(int flag) 
    {
        this.flag1 = flag;
    } 
    
    public void act() 
    {
        checkForCollisions();
    } 
    
    public void checkForCollisions() 
    {       
       Actor cikar = getOneIntersectingObject(Cikar.class);
       Actor chitauri = getOneIntersectingObject(Chitauri.class);
       
       if( cikar != null || chitauri != null) 
       {
           World1 world1 = new World1(flag1);
           world1.music.stop();
           if(getWorld() instanceof World1)
           {
              World2 world2 = new World2(flag1);
              Greenfoot.setWorld(world2);
           }
           if(getWorld() instanceof World2)
           {
              World3 world3 = new World3(flag1);
              Greenfoot.setWorld(world3);
           }
       }
    }
}
