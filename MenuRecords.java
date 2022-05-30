import greenfoot.*;

public class MenuRecords extends World
{

    private int mx;
    private int my;
    public MenuRecords()
    {    
        super(600, 400, 1); 
        
    }
    public void act(){
     MouseInfo mouse = Greenfoot.getMouseInfo();
     if(mouse!=null){
       mx = mouse.getX();
       my = mouse.getY();
       setBackground("Records.jpg");
       if(mx>10 && my > 10 && mx<60 && my < 60){
             setBackground("RecordsAtras.jpg");
             if(Greenfoot.mouseClicked(this)){
               IntroPortada ip = new IntroPortada();
               Greenfoot.setWorld(ip); 
             }
       }
     }   
    }
}