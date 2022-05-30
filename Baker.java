import greenfoot.*;

public class Baker extends Personajes
{
    private final int Gravity = 1;
    private int velocity;
    public int positionX;
    private int positionY; 
    private boolean isFacingRight = true;
    private boolean isFacingLeft = false;
    private boolean isJumping = false;
    public GreenfootSound stomp = new GreenfootSound("stomp.wav");
    public int timer = 0;
    
    public Baker(){
        velocity = 2;
    }
    public void addedToWorld(World w){    
        positionX = getX();
        positionY = getY();
    }  

    public void act() 
    {
        fall();
        if(Greenfoot.isKeyDown("space") && isOnSolidGround()) jump();
        runTimer();
        move();
        deleteEnemy();
    }
   
    
    public void fall(){
        setLocation(getX(), getY() + velocity);
        
        if(isOnSolidGround()) velocity = 0;
        else velocity += Gravity;
    }
    
    public void jump(){
        isJumping = true;
        velocity = -15;
        if(isFacingRight)setImage("JumpingR.png");
        if(isFacingLeft)setImage("JumpingL.png");
    }
    
    public void runTimer()
    {
        timer++;
        if(timer == 30)
            timer = 0;
    }
    
    public void move(){
        int x = getX(), y = getY();
        
        if(Greenfoot.isKeyDown("right")){
             x+=2;
             isFacingRight = true;
             isFacingLeft = false;
             animate();
        }else  if(Greenfoot.isKeyDown("left")){
             isFacingLeft = true;
             isFacingRight = false;
             animate();
             x-=2;
         }        
        
        setLocation(x,y);
    }
    
    private void animate()
    {
        if(true)
        {
            if(!isJumping){
                if(timer == 0)
                {
                    if(isFacingRight)
                        setImage("FacingR1.png");
                    if(isFacingLeft)
                        setImage("FacingL1.png");
                    }
                else if(timer == 5)
                {
                    if(isFacingRight)
                        setImage("FacingR2.png");
                    if(isFacingLeft)
                        setImage("FacingL2.png");
                }
            }
        }
    }
    
    public boolean isOnSolidGround(){
        boolean isOnGround = false;
        
        if(getY() > getWorld().getHeight() - 130) {
            isOnGround = true;
            isJumping = false;
        }
        if(getOneObjectAtOffset(0, getImage().getHeight()/2 - 2, Platform.class) != null || getOneObjectAtOffset(0, getImage().getHeight()/2 - 2, Column.class) != null){
            isOnGround = true;
            isJumping = false;
        }
        return isOnGround;
    }
    
    public void deleteEnemy(){
        Actor Astronaut = getOneObjectAtOffset (0, getImage().getHeight()/2, Astronaut.class);
        Actor Astronaut2 = getOneObjectAtOffset (0, getImage().getHeight()/2, Astronaut2.class);
        Actor Astronaut3 = getOneObjectAtOffset (0, getImage().getHeight()/2, Astronaut3.class);
        if(Astronaut != null)
        {
            velocity = -10;
            stomp.play();
            getWorld().removeObject(Astronaut);
        }
        if(Astronaut2 != null)
        {
            velocity = -10;
            stomp.play();
            getWorld().removeObject(Astronaut2);
        }
        if(Astronaut3 != null)
        {
            velocity = -10;
            stomp.play();
            getWorld().removeObject(Astronaut3);
        }
    }
    
    public int getXCoord(){
        return getX();
    }
}