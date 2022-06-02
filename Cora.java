import greenfoot.*;

public class Cora extends items
{
    public boolean Up = false;
    private int desplaza=1;
    public int ref=5;
    GreenfootSound coin = new GreenfootSound("Diamante.mp3");

    public Cora(){
        this(35,55);
    }

    public Cora(int width, int height){
        GreenfootImage image = getImage();
        image.scale(width, height);
        setImage(image);

    }

    public void act() 
    {
        checkForCollisions();
    }

    public void checkForCollisions() {       
        Actor baker = getOneIntersectingObject(Baker.class);
        if( baker != null) {
            if(getWorld() instanceof World1){
                World1 mundo = (World1)getWorld();
                HealthBar Health = mundo.getHealthBar();
                Health.recoveryHealth();
            }
            coin.play();
            getWorld().removeObject(this);
        }
    }
}