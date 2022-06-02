import greenfoot.*;
import java.util.*;

public class MenuRecords extends World
{

    private int mx;
    private int my;

    public MenuRecords()
    {    
        
        super(600, 400, 1); 
        Records record = new Records();
        
        record.createFile();
        record.readRecord();
        
        List<String> names = record.getNameList();
        List<Integer> score = record.getScoreList();
        
        int scoreYPosition = 100;
        
        
        
        for(int i = 0; i < 5 && i < score.size(); i++)
        {
            showText("Name Player " + names.get(i) + " " + "score" + score.get(i), 300, scoreYPosition);
            scoreYPosition += 50; 
        }
    }
    
    public void act(){
     MouseInfo mouse = Greenfoot.getMouseInfo();
     if(mouse!=null)
     {
       mx = mouse.getX();
       my = mouse.getY();
       setBackground("Records.jpg");
       
       if(mx>10 && my > 10 && mx<60 && my < 60)
       {
           
        setBackground("RecordsAtras.jpg");
        
        if(Greenfoot.mouseClicked(this))
        {
            IntroPortada ip = new IntroPortada();
            Greenfoot.setWorld(ip); 
        }
       }
     }   
    }
}