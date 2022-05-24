import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World3 extends Scrolling
{

   private BarraProteactina hudProteactina;
    private BarraNivelRadioactina hudRadioactina;
    private HealthBar ProtectinaBar;
    private RadBar RadioactinaBar;
    public int band;
    public GreenfootSound music = new GreenfootSound("World.mp3");
       
    public World3(int act)
    {    
        super(600, 400, 1, 4000); // Construcctor para el scroll, (largo,ancho,1,tamaño del mundo)
        GreenfootImage bg = new GreenfootImage("background3Scroll.jpg");
        setScrollingBackground(bg);
        buildWorld(act);
        //music.play();
    }
    
        //Agrega todo lo que tiene el hub, es neesario tener esta funcion en todos los mundos
    public void addHudScore(){
        hudProteactina = new BarraProteactina();
        ProtectinaBar = new HealthBar();
        hudRadioactina = new BarraNivelRadioactina();
        RadioactinaBar = new RadBar();
        addObject(hudProteactina, 70, 40, false);
        addObject(ProtectinaBar, 86, 35, false);
        addObject(hudRadioactina, 530, 40, false);
        addObject(RadioactinaBar, 546, 35, false);
        RadioactinaBar.health = 0;
    }
        
    public void buildWorld(int act){
        if(act == 2 || act == 4)
        {
          addMainActor(new Cikar(), 250, 300, 200,400); // los parametros son para que el actor se coloque en el lugar correcto
          // y con esta linea para moverlo al lado izquierdo
          mainActor.setLocation(100, 250);
        }else{
          addMainActor(new Chitauri(), 250, 300, 200,400); // los parametros son para que el actor se coloque en el lugar correcto
          // y con esta linea para moverlo al lado izquierdo
          mainActor.setLocation(100, 290);
        }
        addObject(new Radioactina(), 600, 100);//1
        addObject(new Radioactina(), 650, 150);//2
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
        addObject(new Diamante(), 1960, 80);
        addObject(new Astronaut(), 2050, 60);
        addObject(new Radioactina(), 1370, 260);//3
        addObject(new Platform(), 1800, 230);
        addObject(new Platform(), 1890, 230);
        addObject(new Platform(), 1980, 230);
        addObject(new Astronaut2(), 2020,172);
        addObject(new Platform(), 2450, 260);
        addObject(new Platform(), 2585, 190);
        addObject(new Radioactina(), 2560, 70);//4
        addObject(new Platform(), 2740, 210);
        addObject(new Platform(), 2830, 210);
        addObject(new Platform(), 2920, 210);
        addObject(new Astronaut(), 2860, 150);
        addObject(new Column(), 3400, 275);
        addObject(new Column(), 3450, 275);
        addObject(new Column(), 3500, 275);
        addObject(new Radioactina(), 3260, 280);//5
        addObject(new Radioactina(), 3400, 70);//6
        addObject(new Radioactina(), 3560, 280);//7
        addObject(new Astronaut3(), 3700, 280);
        addObject(new Goal(act), 3950, 285);
        
        addHudScore(); //Agrega el hud del juego, vida y coleccionables
    }
    
    public HealthBar getHealthBar(){
        return ProtectinaBar;
    }
    
    public RadBar getRadBar(){
        return RadioactinaBar;
    }
}
