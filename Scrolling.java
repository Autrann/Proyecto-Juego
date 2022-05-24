import greenfoot.*;
import java.util.List;
import java.util.ArrayList;

public class Scrolling extends World{
    private int scrollingWidth, scrollingHeight; //define dónde puede moverse el actor principal en las coordenadas universales
    private int actorMinX, actorMaxX, actorMinY, actorMaxY; //define dónde puede moverse el actor principal en las coordenadas del mundo
    private int scrolledX, scrolledY; //cuánto se ha desplazado el mundo
    private int scrollType; //determina la dirección de desplazamiento
    Actor mainActor = null; //El actor en el que se centra la pantalla
    private List<Actor>genActors=new ArrayList(); //lista para todos los actores
    private GreenfootImage background = null;
    static int HP = 10;
    
    /**
     * Define las variables necesarias para crear el mundo con scroll.
     */
    public Scrolling(int wide, int high, int cellSize, int scrollWide, int scrollHigh)
    {
        super(cellSize ==1 ? wide : (wide/2)*2+1, cellSize==1 ? high : (high/2)*2+1, cellSize, false);
        scrollType = (scrollWide > wide ? 1:0) + (scrollHigh > high ? 2:0);
        scrollingWidth = scrollType % 2 == 1 ? scrollWide :wide;
        scrollingHeight = scrollType/2 == 1 ? scrollHigh:high;
    }
    
    /**
     * Crea el scroll horitntal del mundo
     */
    public Scrolling(int wide, int high, int cellSize, int scrollWide)
    {
        this(wide, high, cellSize, scrollWide, high);
    }
    
    /**
     * Añade al actor principal en el centro del mundo
     * Establece la coordenada para que la pantalla se desplace dentro del mundo, y determina que tan lejos puede ir el actor
     */
    public void addMainActor(Actor main, int xLoctation, int yLoctation, int xRange, int yRange)
    {
        super.addObject(main, xLoctation-scrolledX, yLoctation-scrolledY);
        mainActor = main;
        xRange= 0;
        yRange = (int) Math.min(yRange, getHeight());
        actorMinX = getWidth()/2 - xRange/2;
        actorMaxX = getWidth()/2 + xRange/2;
        actorMinY = getHeight()/2 - yRange/2;
        actorMaxY = getHeight()/2 + yRange/2;
        act();
    }
    
    /**
     * Añade el scroll al mundo con la imagen seleccionada
     */
    public void setScrollingBackground(GreenfootImage scrollingBackground)
    {
        background = new GreenfootImage(scrollingBackground);
        background.scale(scrollingWidth*getCellSize(), scrollingHeight*getCellSize());
        scrollBackground();
    }
    
    /**
     * Hace que la imagen de fondo se adapte al mundo de scroll
     */
    public void fillScrollingBackground(GreenfootImage fillImage)
    {
        if (fillImage.getWidth() < getWidth() && fillImage.getHeight() < getHeight()){
            setBackground(new GreenfootImage(fillImage));
            fillImage = getBackground();
        }
        World world = new World(scrollingWidth*getCellSize(), scrollingHeight*getCellSize(), 1){};
        world.setBackground(fillImage);
        background = new GreenfootImage(world.getBackground());
        scrollBackground();
    }
        
    /**
     * Agrega un objeto al mundo y determina si el objeto se desplazará o no.
     */
    public void addObject(Actor object, int xLocation, int yLocation, boolean scroller)
    {
        if (!scroller)
        {
            super.addObject(object, xLocation, yLocation);
            if (object == mainActor)
            {
                act();
            }
            return;
        }
        super.addObject(object, xLocation-scrolledX, yLocation-scrolledY);
        genActors.add(object);
    }
    
    /**
     * Remueve objetos del mundo
     */
    public void removeObject(Actor object)
    {
        if(object == null)
        {
            return;
        }
        if(object.equals(mainActor))
        {
            mainActor=null;
        }
        else 
        {
            genActors.remove(object);
        }
        super.removeObject(object);
    }
    
    /**
     * Agrega un objeto al mundo y determina si el objeto se desplazará o no.
     */
    public void addObject(Actor object, int xLocation, int yLocation)
    {
        addObject(object, xLocation, yLocation, true);
    }
  
    /**
     * Inicia el scrolling.
     */
    public void act(){
        scrollObjects();
        scrollBackground();
        if (HP == 0)
        {
            Greenfoot.setWorld(new GameOver());
        }
    }
    
    /**
     * Desplaza la imagen de fondo
     */
    private void scrollBackground(){
        if (background==null) 
        {
            return;
        }
        int c = getCellSize();
        getBackground().drawImage(background, -scrolledX*c, -scrolledY*c);
    }
    
    /**
     * Desplaza todos los objetos que se han definido como desplazables cuando se agregaron según la ubicación del actor principal
     * en la ventana
     */
    private void scrollObjects(){
        if (mainActor==null)
        {
            return;
        }
        
        int directionX=0, directionY=0;
        if(mainActor.getX() < actorMinX){
            directionX = actorMinX - mainActor.getX();
        }
        if(mainActor.getX() > actorMaxX){
            directionX = actorMaxX - mainActor.getX();
        }
        if(mainActor.getY() < actorMinY){
            directionY = actorMinY - mainActor.getY();
        }
        if(mainActor.getY() > actorMaxY){
            directionY = actorMaxY - mainActor.getY();
        }
        if(directionX == 0 && directionY == 0)
        {
            return;
        }
        
        int directionXSum = directionX;
        int directionYSum = directionY;
        scrolledX -= directionX; 
        scrolledY -= directionY;
        mainActor.setLocation(mainActor.getX() + directionX, mainActor.getY() + directionY);
        directionX=0; 
        directionY=0;
        if(scrolledX > scrollingWidth - getWidth())
        {
            directionX = scrolledX - (scrollingWidth - getWidth());
        }
        if(scrolledX < 0)
        {
            directionX = scrolledX;
        }
        if(scrolledY > scrollingHeight - getHeight())
        {
            directionY = scrolledY - (scrollingHeight - getHeight());
        }
        if(scrolledY < 0)
        {
            directionY = scrolledY;
        }
        
        directionXSum += directionX; directionYSum += directionY;
        scrolledX-=directionX; scrolledY-=directionY;
        mainActor.setLocation(mainActor.getX() + directionX, mainActor.getY() + directionY);
        
        for(Object object : genActors)
        {
            Actor actor = (Actor)object;
            actor.setLocation(actor.getX()+directionXSum, actor.getY()+directionYSum);
        }
        
        directionX=0; directionY=0;
        if(mainActor.getX() < 0)
        {
            directionX = 0 - mainActor.getX();
        }
        if(mainActor.getX() > getWidth()-1)
        {
            directionX = (getWidth()-1) - mainActor.getX();
        }
        if(mainActor.getY() < 0) 
        {
            directionY = 0 - mainActor.getY();
        }
        if(mainActor.getY() > getHeight()-1)
        {
            directionY = (getHeight()-1) - mainActor.getY();
        }
        if(directionX == 0 && directionY == 0)
        {
            return;
        }
        mainActor.setLocation(mainActor.getX() + directionX, mainActor.getY() + directionY);
    }
    
    /**
     *  Determina hasta dónde se ha movido el actor principal en general
     */
    public int getUniversalX(int worldX)
    {
        return worldX + scrolledX;
    }
    
    /**
     *  Cuando se llama, devuelve el ancho del área de desplazamiento
     */
    public int getScrollingWidth()
    {
        return scrollingWidth;
    }
    
    public void decreaseHp()
    {
        HP--;
    }
    
    public void increaseHp(int plus)
    {
        HP = HP + plus;
    }
}
