import greenfoot.*;

public class MenuCreditos extends World
{

    private int mx;
    private int my;
    public MenuCreditos()
    {    
        super(600, 400, 1); 
        
    }
    public void act(){
     MouseInfo mouse = Greenfoot.getMouseInfo();
     if(mouse!=null){
       mx = mouse.getX();
       my = mouse.getY();
       setBackground("Creditos.jpg");
       if(mx>10 && my > 10 && mx<60 && my < 60){
             setBackground("CreditosAtras.jpg");
             if(Greenfoot.mouseClicked(this)){
               IntroPortada ip = new IntroPortada();
               Greenfoot.setWorld(ip); 
             }
       }
     }   
    }
}
