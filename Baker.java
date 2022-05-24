import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Baker extends Actor
{
    private final int Gravity = 1;
    private int velocity;
    public int positionX;
    private int positionY; 
    private boolean isFacingRight = true;
    private boolean isFacingLeft = false;
    private boolean isJumping = false;
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
        if(Greenfoot.isKeyDown("space")) jump();
        runTimer();
        move();

    }
    
    public void runTimer()
    {
        timer++;
        if(timer == 20)
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
    
    public void jump(){
        isJumping = true;
        velocity = -15;
        if(isFacingRight)setImage("JumpingR.png");
        if(isFacingLeft)setImage("JumpingL.png");
    }
    
    public void fall(){
        setLocation(getX(), getY() + velocity);
        
        if(isOnSolidGround()) velocity = 0;
        else velocity += Gravity;
    }
    
    public boolean isOnSolidGround(){
        boolean isOnGround = false;
        
        if(getY() > getWorld().getHeight() - 130) {
            isOnGround = true;
            isJumping = false;
        }
        return isOnGround;
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
    
    public int getXCoord(){
        return getX();
    }
}
