import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Proyectile extends Projectiles
{
    private int speed = -10;
    private boolean RigthLeft = true;
    private int deleteProyectil;
    private int timeDeleteProyectil;
    boolean touchingAct = false;
    
    public Proyectile(boolean AstronautSeeing)
    {
        getImage().scale(20,20);
        RigthLeft = AstronautSeeing;
        deleteProyectil = 30;
    }
    
    public void act() 
    {
        timeDeleteProyectil ++;
        moveProyectile(RigthLeft);
        checkForCollisions();
        removeProyectil();
    }
    
    public void moveProyectile(boolean isSeeing)
    {
        if(isSeeing) 
            setLocation(getX() + speed, getY());
        if(!isSeeing) 
            setLocation(getX() - speed, getY());
    }
    
    private void removeProyectil()
    {
        if (timeDeleteProyectil >= deleteProyectil)
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
              if(touchingAct == false)
              {
                  Health.loseHealth();
                  touchingAct = true;
                if(Health.health <= 0)
                {
                   //GameOver
                }
              }
               getWorld().removeObject(this);
           }
           
           if(getWorld() instanceof World2)
           {
              World2 mundo = (World2)getWorld();
              HealthBar Health = mundo.getHealthBar();
              if(touchingAct == false)
              {
                  Health.loseHealth();
                  touchingAct = true;
               if(Health.health<=0)
               {
                   //GameOver
               }
               }
             getWorld().removeObject(this);
           }
           
           if(getWorld() instanceof World3)
           {
              World3 mundo = (World3)getWorld();
              HealthBar Health = mundo.getHealthBar();
              if(touchingAct == false)
              {
                  Health.loseHealth();
                  touchingAct = true;
                if(Health.health <= 0)
                {
                   //GameOver
                }
              }
               getWorld().removeObject(this);
           }
       }else{
           touchingAct = false;
       }
    }
}

