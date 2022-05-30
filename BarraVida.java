import greenfoot.*;

public class BarraVida extends HUD
{
    private boolean isJumping = false;
    Baker baker = new Baker();
    
    public BarraVida(){
       this(120, 80);
    }
    public BarraVida(int width, int height){
      GreenfootImage image = getImage();
      image.scale(width, height);
      setImage(image);
 
    }
    public void act() 
    {   
        baker.runTimer();
        //checkRadioactinaUp();
    }
    
    public void checkRadioactinaUp(){
      baker.jump();
      System.out.println(baker.timer);
      if(baker.timer == 10){
       setImage("beep.png");
      }
    }  
}
