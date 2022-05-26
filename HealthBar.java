import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HealthBar extends BarraProteactina
{
    int health = 10;
    int healthBarWidth = 70;
    int healthBarHeight = 5;
    int pixelPerHealthPoint = (int)healthBarWidth/health;
    
    public void act() 
    {
        update();
    }
    
    public void update()
    {
        setImage(new GreenfootImage(healthBarWidth+2, healthBarHeight+2));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.WHITE);
        myImage.drawRect(0, 0, healthBarWidth+1, healthBarHeight+1);
        myImage.setColor(Color.CYAN);
        myImage.fillRect(1, 1, health*pixelPerHealthPoint, healthBarHeight);
    }
    
    public void loseHealth()
    {
        Scrolling mainHp = (Scrolling)getWorld();
        health--;
        mainHp.decreaseHp();
    }
    
    public void recoveryHealth()
    {
        Scrolling mainHp = (Scrolling)getWorld();
        if(health<8){
            health+=3;
            mainHp.increaseHp(3);
        }
        else{
            if(health!=10){
                health++;
                mainHp.increaseHp(1);
            }
        }
    }
}

