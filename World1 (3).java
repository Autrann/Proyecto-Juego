import greenfoot.*;
    
public class World1 extends Scrolling
{
    private BarraProteactina hudProteactina;
    private BarraNivelRadioactina hudRadioactina;
    private HealthBar ProtectinaBar;
    private RadBar RadioactinaBar;
    public GreenfootSound music = new GreenfootSound("World.mp3");
       
    public World1()
    {    
        super(600, 400, 1, 4000); // Construcctor para el scroll, (largo,ancho,1,tamaño del mundo)
        GreenfootImage bg = new GreenfootImage("backgroundScroll.jpg");
        setScrollingBackground(bg);
        buildWorld();
        music.play();
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
        
    public void buildWorld(){
        // en la siguiente declaración, el actor se coloca en el centro de la ventana
        addMainActor(new Cikar(), 250, 300, 200,400); // los parametros son para que el actor se coloque en el lugar correcto
        // y con esta linea para moverlo al lado izquierdo
        mainActor.setLocation(100, 250);
            
        //aqui se agregan los objetos al mundo, (actor/objeto, x,y)
        addObject(new Platform(), 230, 250);
        addObject(new Platform(), 340, 130);
        addObject(new Platform(), 450, 250);
        addObject(new Radioactina(), 340, 60);//1
        addObject(new Radioactina(), 340, 280);//2
        addObject(new Column(), 800, 275);
        addObject(new Astronaut(), 1130, 280);
        addObject(new Column(), 1280, 275);
        addObject(new Platform(), 1360, 210);
        addObject(new Platform(), 1440, 210);
        addObject(new Platform(), 1520, 210);
        addObject(new Astronaut(), 1500, 155);
        addObject(new Radioactina(), 1360, 280);//3
        addObject(new Platform(), 1960, 260);
        addObject(new Platform(), 2050, 260);
        addObject(new Platform(), 2140, 260);
        addObject(new Astronaut(), 2100, 200);
        addObject(new Platform(), 2280, 190);
        addObject(new Platform(), 2420, 130);
        addObject(new Radioactina(), 2560, 70);//4
        addObject(new Platform(), 2740, 210);
        addObject(new Platform(), 2830, 210);
        addObject(new Platform(), 2920, 210);
        addObject(new Astronaut(), 2860, 150);
        addObject(new Diamante(), 2830, 280);
        addObject(new Column(), 3200, 275);
        addObject(new Radioactina(), 3260, 280);//5
        addObject(new Platform(), 3310, 130);
        addObject(new Platform(), 3400, 130);
        addObject(new Radioactina(), 3400, 70);//6
        addObject(new Platform(), 3490, 130);
        addObject(new Radioactina(), 3540, 280);//7
        addObject(new Column(), 3600, 275);
        addObject(new Astronaut(), 3450, 280);
        addObject(new Goal(), 3950, 285);
        
        addHudScore(); //Agrega el hud del juego, vida y coleccionables
    }
    
    public HealthBar getHealthBar(){
        return ProtectinaBar;
    }
    
    public RadBar getRadBar(){
        return RadioactinaBar;
    }
}