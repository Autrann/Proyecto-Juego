import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ProyectileY extends Projectiles
{
    private int speed = -10;
    private int speedY = -5;
    private boolean RigthLeft =true;
    private int deleteProyectile;
    private int timeDeleteProyectile;
    boolean touchingAct = false;
    
    public ProyectileY(boolean AstronautSeeing)
    {
        getImage().scale(20,20);
        RigthLeft = AstronautSeeing;
        deleteProyectile = 30;
    }
    
    public void act() 
    {
        timeDeleteProyectile++;
        moveProyectile(RigthLeft);
        checkForCollisions();
        removeProyectile();
    }
    
    public void moveProyectile(boolean isSeeing)
    {
        if(isSeeing)
            setLocation(getX() + speed, getY()+ speedY);
        if(!isSeeing)
            setLocation(getX() - speed, getY()+ speedY);
    }
    
    private void removeProyectile()
    {
        if (timeDeleteProyectile >= deleteProyectile)
        {
            getWorld().removeObject(this);
        }
    }
    
    public void checkForCollisions() 
    {
       Actor cikar = getOneIntersectingObject(Cikar.class);
       Actor chitauri = getOneIntersectingObject(Chitauri.class);
       if( cikar != null || chitauri != null ) 
       {
           if(getWorld() instanceof World1)
           {
              World1 mundo = (World1)getWorld();
              HealthBar Health = mundo.getHealthBar();
              if(touchingAct==false){
                  Health.loseHealth();
                  touchingAct = true;
               if(Health.health<=0){
                   //GameOver
                }
               }
               getWorld().removeObject(this);
           }
           if(getWorld() instanceof World2){
              World2 mundo = (World2)getWorld();
              HealthBar Health = mundo.getHealthBar();
              if(touchingAct==false){
                  Health.loseHealth();
                  touchingAct = true;
               if(Health.health<=0){
                   //GameOver
                }
               }
               getWorld().removeObject(this);
           }
           if(getWorld() instanceof World3){
              World3 mundo = (World3)getWorld();
              HealthBar Health = mundo.getHealthBar();
              if(touchingAct==false){
                  Health.loseHealth();
                  touchingAct = true;
               if(Health.health<=0){
                   //GameOver
                }
               }
               getWorld().removeObject(this);
           }
           //mundo.vidas.decrementar(); 
       }else
       {
           touchingAct = false;
       }
       }
}

