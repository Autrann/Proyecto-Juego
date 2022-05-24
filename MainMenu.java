import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MainMenu extends World
{
    public int mx;
    public int my;
    public int act=0;
    public boolean flag=false;
    public MainMenu()
    {    
        super(600, 400, 1); 
    }
    
    public void act(){
        checkMouseMovement();
    }
    
    public void checkMouseMovement(){
      MouseInfo mouse = Greenfoot.getMouseInfo();
      if(mouse!=null){
          mx = mouse.getX();
          my = mouse.getY();
          setBackground("MainMenu.jpg");
          if(mx>250 && my > 150 && mx<350 && my < 250){
             setBackground("MainMenuJugar.jpg");
             if(Greenfoot.mouseClicked(this)){
               World1 world = new World1(act);
               Greenfoot.setWorld(world); 
             }
          }else if(mx>75 && my > 175 && mx<180 && my < 285){
             setBackground("MainMenuRecords.jpg");
             if(Greenfoot.mouseClicked(this)){
                RecordsMenu mc = new RecordsMenu();
                Greenfoot.setWorld(mc); 
             }
          }else if(mx>400 && my > 180 && mx<505 && my < 290){
             setBackground("MainMenuHTP.jpg");
             if(Greenfoot.mouseClicked(this)){
               HowToPlayMenu ma = new HowToPlayMenu();
               Greenfoot.setWorld(ma); 
             }
          }
      }
    }
}
