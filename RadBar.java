import greenfoot.*;

public class RadBar extends BarraNivelRadioactina
{
    int health = 7;
    int healthBarWidth = 70;
    int healthBarHeight = 5;
    int pixelPerHealthPoint = (int)healthBarWidth/health;
    
    public void act() 
    {
        update();
    }
    
    public void update(){
        setImage(new GreenfootImage(healthBarWidth+2, healthBarHeight+2));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.WHITE);
        myImage.drawRect(0, 0, healthBarWidth+1, healthBarHeight+1);
        myImage.setColor(Color.GREEN);
        myImage.fillRect(1, 1, health*pixelPerHealthPoint, healthBarHeight);
    }
    
    public void PlusHealth(){
        health++;
    }
}

