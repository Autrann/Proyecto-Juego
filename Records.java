import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Records extends Actor
{
    private final int LIMIT = 5;
    private List<String> nameList = new ArrayList<String>();
    private List<Integer> scoreList = new ArrayList<Integer>();
    
    public void act()
    {
        
    }
    
    public List<Integer> getScoreList()
    {
        return this.scoreList;
    }
    
    public List<String> getNameList()
    {
        return this.nameList;
    }
    

    public void createFile()
    {
        try
        {
            File recordFile = new File("records.txt");
            if(!recordFile.createNewFile())
            {
                System.out.println("File created");
            }else{
                System.out.println("File already exist");
            }
        }catch(IOException e)
        {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public void readRecord()
    {
        try
        {
            File recordFile = new File("records.txt");
            Scanner reader = new Scanner(recordFile);

            if(recordFile.length() == 0)
            {
                System.out.println("No records");
            }else{
                while(reader.hasNextLine())
                {
                    String[] data = reader.nextLine().split(";");
                    String name = data[0];
                    String scoreStr = data[1];
                    try{
                        int score = Integer.parseInt(scoreStr);

                        this.nameList.add(name);
                        this.scoreList.add(score);
                    }catch(NumberFormatException e){
                        e.printStackTrace();
                    }
                }
            }
            reader.close();
        }catch (FileNotFoundException e)
        {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public void writeRecord(String newName, int newScore)
    {
        int flag1 = 0;
        int flag2 = 0;

        if(this.scoreList.isEmpty() || this.nameList.isEmpty())
        {
            System.out.println("Both empty");
            this.nameList.add(newName);
            this.scoreList.add(newScore);
        }else {
            for (int index = 0; index < this.scoreList.size(); index++)
            {
                if (newScore == this.scoreList.get(index)) {
                    // This record already exist
                    flag1 = 1;
                    break;
                } else if (newScore > this.scoreList.get(index)) {
                    flag2 = 1;
                    this.nameList.add(index, newName);
                    this.scoreList.add(index, newScore);
                    break;
                }
            }

            if(flag1 == 0 && flag2 == 0){
                this.nameList.add(newName);
                this.scoreList.add(newScore);
            }
        }

        try{
            FileWriter file = new FileWriter("records.txt");

            for(int i=0; i < this.LIMIT && i < this.scoreList.size(); i++)
            {
                file.write(this.nameList.get(i) + ";" + this.scoreList.get(i) + "\n");
            }
            file.close();
        }catch(IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }

    }
    
    
    
}
