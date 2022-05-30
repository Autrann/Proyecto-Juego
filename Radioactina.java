import greenfoot.*;

public class Radioactina extends items
{
    private GreenfootImage Radioactina;
    public boolean Up = false;
    private int desplaza=1;
    public int nivelRadio=0;
    public int i=0;
    public int nivel=1;
    public int flag;
    public int cont=1;
    GreenfootSound coin = new GreenfootSound("Radioactina.mp3");
    
    public Radioactina(){
       this(35,55);
       Radioactina = new GreenfootImage("Radiactina☢.png");
    }
    public Radioactina(int width, int height){
      GreenfootImage image = getImage();
      image.scale(width, height);
      setImage(image);
 
    }
    
    public void act() 
    {  
         checkForCollisions();
         //System.out.println(nivelRadio);
    }
    
    public void checkForCollisions() {       
       Actor baker = getOneIntersectingObject(Baker.class);
       if( baker != null) {
               if(getWorld() instanceof World1){
                   World1 mundo = (World1)getWorld();
                   RadBar Rad = mundo.getRadBar();
                   Rad.PlusHealth();
               }
               if(getWorld() instanceof World2){
                   World2 mundo = (World2)getWorld();
                   RadBar Rad = mundo.getRadBar();
                   Rad.PlusHealth();
               }
               if(getWorld() instanceof World3){
                   World3 mundo = (World3)getWorld();
                   RadBar Rad = mundo.getRadBar();
                   Rad.PlusHealth();
               }
               getWorld().removeObject(this);
               coin.play();      
       }
    }
    
   
}
