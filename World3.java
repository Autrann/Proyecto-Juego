import greenfoot.*; 


public class World3 extends Scrolling
{

   private BarraVida hudVida;
    private BarraNivelRadioactina hudRadioactina;
    private HealthBar VidaBar;
    private RadBar RadioactinaBar;
    public int band;
    public GreenfootSound music = new GreenfootSound("World.mp3");
       
    public World3(int act)
    {    
        super(600, 400, 1, 4000);
        GreenfootImage bg = new GreenfootImage("background3Scroll.jpg");
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
          
        addObject(new Radioactina(), 600, 100);
        addObject(new Radioactina(), 650, 150);
        addObject(new Column(), 300, 275);
        addObject(new Column(), 650, 275);
        addObject(new Astronaut3(), 550, 280);
        addObject(new Platform(), 900, 290);
        addObject(new Platform(), 1010, 240);
        addObject(new Platform(), 1120, 190);
        addObject(new Platform(), 1390, 290);
        addObject(new Platform(), 1500, 240);
        addObject(new Platform(), 1610, 190);
        addObject(new Platform(), 1970, 120);
        addObject(new Platform(), 2050, 120);
        addObject(new Platform(), 2130, 120);
        addObject(new Platform(), 2210, 120);
        addObject(new Cora(), 1960, 80);
        addObject(new Astronaut(), 2050, 60);
        addObject(new Radioactina(), 1370, 260);
        addObject(new Platform(), 1800, 230);
        addObject(new Platform(), 1890, 230);
        addObject(new Platform(), 1980, 230);
        addObject(new Astronaut2(), 2020,172);
        addObject(new Platform(), 2450, 260);
        addObject(new Platform(), 2585, 190);
        addObject(new Radioactina(), 2560, 70);
        addObject(new Platform(), 2740, 210);
        addObject(new Platform(), 2830, 210);
        addObject(new Platform(), 2920, 210);
        addObject(new Astronaut(), 2860, 150);
        addObject(new Column(), 3400, 275);
        addObject(new Column(), 3450, 275);
        addObject(new Column(), 3500, 275);
        addObject(new Radioactina(), 3260, 280);
        addObject(new Radioactina(), 3400, 70);
        addObject(new Radioactina(), 3560, 280);
        addObject(new Astronaut3(), 3700, 280);
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
