import greenfoot.*;

public class BarraNivelRadioactina extends HUD
{
    private boolean isJumping = false;
    Baker baker = new Baker();
    
    public BarraNivelRadioactina(){
       this(120, 80);
    }
    public BarraNivelRadioactina(int width, int height){
      GreenfootImage image = getImage();
      image.scale(width, height);
      setImage(image);
 
    }
    public void act() 
    {   
        baker.runTimer();
    }
    
    public void checkRadioactinaUp(){
      baker.jump();
      System.out.println(baker.timer);
      if(baker.timer == 10){
       setImage("beep.png");
      }
    }
}


