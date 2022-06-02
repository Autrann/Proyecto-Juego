import greenfoot.*;

public class IntroPortada extends World{
    private int mx;
    private int my;
    private int act=0;
    private boolean flag=false;
    public IntroPortada()
    {    
        super(600, 400, 1);
    }

    public void act(){
        checkMouseMove();
    }
    
    
    public void checkMouseMove()
    {
      MouseInfo mouse = Greenfoot.getMouseInfo();
      if(mouse!=null)
      {
          mx = mouse.getX();
          my = mouse.getY();
          setBackground("MainMenu.jpg");
          if(mx>250 && my > 150 && mx<350 && my < 250)
          {
             setBackground("MainMenuJugar.jpg");
             
             if(Greenfoot.mouseClicked(this))
             {
               Baker.namePlayer = Greenfoot.ask("Nombre del jugador");
               World1 world = new World1(act);
               Greenfoot.setWorld(world); 
             }
          }else if(mx>75 && my > 175 && mx<180 && my < 285)
          {
             setBackground("MainMenuRecords.jpg");
             if(Greenfoot.mouseClicked(this))
             {
                MenuRecords mc = new MenuRecords();
                Greenfoot.setWorld(mc); 
             }
          }else if(mx>400 && my > 180 && mx<505 && my < 290){
             setBackground("MainMenuHTP.jpg");
             if(Greenfoot.mouseClicked(this)){
               MenuAyuda ma = new MenuAyuda();
               Greenfoot.setWorld(ma); 
             }
          }
      }
    }
}