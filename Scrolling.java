import greenfoot.*;
import java.util.List;
import java.util.ArrayList;

public class Scrolling extends World{
    private int scrollingWidth, scrollingHeight;
    private int actorMinX, actorMaxX, actorMinY, actorMaxY;
    private int scrolledX, scrolledY;
    private int scrollType;
    Actor mainActor = null;
    private List<Actor>genActors=new ArrayList();
    private GreenfootImage background = null;
    static int HP = 10;
    
     public Scrolling(int wide, int high, int cellSize, int scrollWide, int scrollHigh){
        super(cellSize==1?wide:(wide/2)*2+1, cellSize==1?high:(high/2)*2+1, cellSize, false);
        scrollType=(scrollWide>wide?1:0)+(scrollHigh>high?2:0);
        scrollingWidth=scrollType%2==1?scrollWide:wide;
        scrollingHeight=scrollType/2==1?scrollHigh:high;
    }
    

    public Scrolling(int wide, int high, int cellSize, int scrollWide){
        this(wide, high, cellSize, scrollWide, high);
    }
    
    public void addMainActor(Actor main, int xLoc, int yLoc, int xRange, int yRange){
        super.addObject(main, xLoc-scrolledX, yLoc-scrolledY);
        mainActor = main;
        xRange= 0;
        yRange=(int)Math.min(yRange, getHeight());
        actorMinX=getWidth()/2-xRange/2;
        actorMaxX=getWidth()/2+xRange/2;
        actorMinY=getHeight()/2-yRange/2;
        actorMaxY=getHeight()/2+yRange/2;
        act();
    }
    

    public void setScrollingBackground(GreenfootImage scrollingBackground){
        background = new GreenfootImage(scrollingBackground);
        background.scale(scrollingWidth*getCellSize(), scrollingHeight*getCellSize());
        scrollBackground();
    }
    
    public void fillScrollingBackground(GreenfootImage fillImage){
        if (fillImage.getWidth()<getWidth() && fillImage.getHeight()<getHeight()){
            setBackground(new GreenfootImage(fillImage));
            fillImage = getBackground();
        }
        World world = new World(scrollingWidth*getCellSize(), scrollingHeight*getCellSize(), 1){};
        world.setBackground(fillImage);
        background = new GreenfootImage(world.getBackground());
        scrollBackground();
    }
        

    public void addObject(Actor obj, int xLoc, int yLoc, boolean scroller){
        if (!scroller){
            super.addObject(obj, xLoc, yLoc);
            if (obj == mainActor){
                act();
            }
            return;
        }
        super.addObject(obj, xLoc-scrolledX, yLoc-scrolledY);
        genActors.add(obj);
    }
    

    public void removeObject(Actor obj){
        if(obj==null){
            return;
        }
        if(obj.equals(mainActor)){
            mainActor=null;
        }
        else {
            genActors.remove(obj);
        }
        super.removeObject(obj);
    }
    
    /**
     * Agrega un objeto al mundo y determina si el objeto se desplazará o no.
     */
    public void addObject(Actor obj, int xLoc, int yLoc){
        addObject(obj, xLoc, yLoc, true);
    }
  

    public void act(){
        scrollObjects();
        scrollBackground();
        if (HP == 0)
        {
            Greenfoot.setWorld(new GameOver());
        }
    }
    

    private void scrollBackground(){
        if (background==null) 
        {
            return;
        }
        int c = getCellSize();
        getBackground().drawImage(background, -scrolledX*c, -scrolledY*c);
    }
    

    private void scrollObjects(){
        if (mainActor==null) {
            return;
        }
        
        int dx=0, dy=0;
        if(mainActor.getX()<actorMinX){
            dx=actorMinX-mainActor.getX();
        }
        if(mainActor.getX()>actorMaxX){
            dx=actorMaxX-mainActor.getX();
        }
        if(mainActor.getY()<actorMinY){
            dy=actorMinY-mainActor.getY();
        }
        if(mainActor.getY()>actorMaxY){
            dy=actorMaxY-mainActor.getY();
        }
        if(dx==0 && dy==0){
            return;
        }
        
        int dxSum = dx, dySum = dy;
        scrolledX-=dx; scrolledY-=dy;
        mainActor.setLocation(mainActor.getX()+dx, mainActor.getY()+dy);
        dx=0; dy=0;
        if(scrolledX > scrollingWidth-getWidth()){
            dx=scrolledX-(scrollingWidth-getWidth());
        }
        if(scrolledX < 0){
            dx=scrolledX;
        }
        if(scrolledY > scrollingHeight-getHeight()){
            dy=scrolledY-(scrollingHeight-getHeight());
        }
        if(scrolledY < 0){
            dy=scrolledY;
        }
        dxSum+=dx; dySum+=dy;
        scrolledX-=dx; scrolledY-=dy;
        mainActor.setLocation(mainActor.getX()+dx, mainActor.getY()+dy);
        for(Object obj : genActors){
            Actor actor=(Actor)obj;
            actor.setLocation(actor.getX()+dxSum, actor.getY()+dySum);
        }
        dx=0; dy=0;
        if(mainActor.getX() < 0){
            dx=0-mainActor.getX();
        }
        if(mainActor.getX() > getWidth()-1){
            dx=(getWidth()-1)-mainActor.getX();
        }
        if(mainActor.getY() < 0){
            dy=0-mainActor.getY();
        }
        if(mainActor.getY() > getHeight()-1){
            dy=(getHeight()-1)-mainActor.getY();
        }
        if(dx==0 && dy==0){
            return;
        }
        mainActor.setLocation(mainActor.getX()+dx, mainActor.getY()+dy);
    }
    

    public int getUnivX(int worldX){
        return worldX+scrolledX;
    }
    

    public int getScrollingWidth(){
        return scrollingWidth;
    }
    
    public void decreaseHp(){
        HP--;
    }
    
    public void increaseHp(int plus){
        HP = HP + plus;
    }
}