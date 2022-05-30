import greenfoot.*;
    
public class World1 extends Scrolling
{
    private BarraVida hudVida;
    private BarraNivelRadioactina hudRadioactina;
    private HealthBar VidaBar;
    private RadBar RadioactinaBar;
    public GreenfootSound music; 
    public int act;
       
    public World1(int act)
    {    
        super(600, 400, 1, 4000);
        GreenfootImage bg = new GreenfootImage("backgroundScroll.jpg");
        music=new GreenfootSound("World.mp3");
        music.play();
        setScrollingBackground(bg);
        buildWorld(act);

    }
    
    public void addHudScore(){
        hudVida = new BarraVida();
        VidaBar = new HealthBar();
        hudRadioactina = new BarraNivelRadioactina();
        RadioactinaBar = new RadBar();
        addObject(hudVida, 70, 40, false);
        addObject(VidaBar, 86, 35, false);
        addObject(hudRadioactina, 530, 40, false);
        addObject(RadioactinaBar, 546, 35, false);
        RadioactinaBar.health = 0;
    }
        
    public void buildWorld(int act){
        
          addMainActor(new Baker(), 250, 300, 200,400);

          mainActor.setLocation(100, 250);
          addObject(new Goal(act), 3950, 285);
        
            
        addObject(new Platform(), 230, 250);
        addObject(new Platform(), 340, 130);
        addObject(new Platform(), 450, 250);
        addObject(new Radioactina(), 340, 60);
        addObject(new Radioactina(), 340, 280);
        addObject(new Column(), 800, 275);
        addObject(new Astronaut(), 1130, 280);
        addObject(new Column(), 1280, 275);
        addObject(new Platform(), 1360, 210);
        addObject(new Platform(), 1440, 210);
        addObject(new Platform(), 1520, 210);
        addObject(new Astronaut(), 1500, 155);
        addObject(new Radioactina(), 1360, 280);
        addObject(new Platform(), 1960, 260);
        addObject(new Platform(), 2050, 260);
        addObject(new Platform(), 2140, 260);
        addObject(new Astronaut(), 2100, 200);
        addObject(new Platform(), 2280, 190);
        addObject(new Platform(), 2420, 130);
        addObject(new Radioactina(), 2560, 70);
        addObject(new Platform(), 2740, 210);
        addObject(new Platform(), 2830, 210);
        addObject(new Platform(), 2920, 210);
        addObject(new Astronaut2(), 2860, 150);
        addObject(new Cora(), 2830, 280);
        addObject(new Column(), 3200, 275);
        addObject(new Radioactina(), 3260, 280);
        addObject(new Platform(), 3310, 130);
        addObject(new Platform(), 3400, 130);
        addObject(new Radioactina(), 3400, 70);
        addObject(new Platform(), 3490, 130);
        addObject(new Radioactina(), 3540, 280);
        addObject(new Column(), 3600, 275);
        addObject(new Astronaut(), 3450, 280);
        
        
        addHudScore();
    }
    
    public HealthBar getHealthBar(){
        return VidaBar;
    }
    
    public RadBar getRadBar(){
        return RadioactinaBar;
    }
    

}