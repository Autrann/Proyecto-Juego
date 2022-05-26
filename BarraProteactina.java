import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BarraProteactina here.
 * 
 * @author (Alfredo) 
 * @version (a version number or a date)
 */
public class BarraProteactina extends HUD
{
    private boolean isJumping = false;
    Baker baker = new Baker();
    
    public BarraProteactina()
    {
       this(120, 80);
    }
    
    public BarraProteactina(int width, int height)
    {
      GreenfootImage image = getImage();
      image.scale(width, height);
      setImage(image);
 
    }
    public void act() 
    {   
        baker.runTimer();
    }
    
    public void checkRadioactinaUp()
    {
      baker.jump();
      System.out.println(baker.timer);
      if(baker.timer == 10)
      {
       setImage("beep.png");
      }
    }  
}
