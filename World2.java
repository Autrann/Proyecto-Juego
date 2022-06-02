import greenfoot.*;


public class World2 extends Scrolling
{

    private BarraVida hudVida;
    private BarraNivelRadioactina hudRadioactina;
    private HealthBar VidaBar;
    private RadBar RadioactinaBar;
    public int band;
    public GreenfootSound music = new GreenfootSound("World.mp3");
       
    public World2(int act)
    {    
        super(600, 400, 1, 4000);
        GreenfootImage bg = new GreenfootImage("background2Scroll.jpg");
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
        
            
        addObject(new Platform(), 250, 320);
        addObject(new Platform(), 360, 270);
        addObject(new Platform(), 470, 220);
        addObject(new Radioactina(), 600, 100);
        addObject(new Radioactina(), 650, 150);
        addObject(new Column(), 900, 285);
        addObject(new Column(), 900, 80);
        addObject(new Astronaut(), 1130, 280);
        addObject(new Platform(), 1360, 230);
        addObject(new Platform(), 1440, 230);
        addObject(new Platform(), 1540, 120);
        addObject(new Platform(), 1620, 120);
        addObject(new Platform(), 1700, 120);
        addObject(new Platform(), 1780, 120);
        addObject(new Platform(), 1970, 120);
        addObject(new Platform(), 2050, 120);
        addObject(new Platform(), 2130, 120);
        addObject(new Platform(), 2210, 120);
        addObject(new Cora(), 1960, 80);
        addObject(new Astronaut(), 2050, 60);
        addObject(new Radioactina(), 1360, 280);
        addObject(new Platform(), 1800, 230);
        addObject(new Platform(), 1890, 230);
        addObject(new Platform(), 1980, 230);
        addObject(new Astronaut(), 2020,172);
        addObject(new Platform(), 2450, 230);
        addObject(new Platform(), 2590, 170);
        addObject(new Radioactina(), 2560, 70);
        addObject(new Platform(), 2740, 210);
        addObject(new Platform(), 2830, 210);
        addObject(new Platform(), 2920, 210);
        addObject(new Astronaut2(), 2860, 150);
        addObject(new Column(), 3400, 275);
        addObject(new Radioactina(), 3260, 280);
        addObject(new Platform(), 3310, 130);
        addObject(new Radioactina(), 3400, 70);
        addObject(new Platform(), 3490, 130);
        addObject(new Radioactina(), 3540, 280);
        addObject(new Astronaut2(), 3700, 280);
        addObject(new Goal(act), 3950, 285);
        
        addHudScore();
    }
    
    public HealthBar getHealthBar(){
        return VidaBar;
    }
    
    public RadBar getRadBar(){
        return RadioactinaBar;
    }
}

