import greenfoot.*;


public class Goal extends struct
{
    GreenfootSound coin = new GreenfootSound("Diamante.mp3");
    public GreenfootSound music = new GreenfootSound("World.mp3");
    public int hola=1;
    public int flag1;
    
    public Goal(int flag) 
    {
        flag1=flag;
    } 
    
    public void act() 
    {
        checkForCollisions();
    } 
    
    public void checkForCollisions() {       
       Actor baker = getOneIntersectingObject(Baker.class);
       if( baker != null) {
           World1 world1 = new World1(flag1);
           world1.music.stop();
           if(getWorld() instanceof World1){
              World2 world2 = new World2(flag1);
              Greenfoot.setWorld(world2);
           }
           if(getWorld() instanceof World2){
              World3 world3 = new World3(flag1);
              Greenfoot.setWorld(world3);
           }
           if(getWorld() instanceof World3){
              MenuCreditos mc = new MenuCreditos();
              Greenfoot.setWorld(mc);
           }
           
       }
    }
}
