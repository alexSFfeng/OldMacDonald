import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class OldMacDonald extends PApplet {


public void setup()
{   
  Farm oldMacdonald = new Farm();
  oldMacdonald.animalSounds();

}
interface Animals
{
	public String getSound();
	public String getType();
}
class Cow implements Animals 
{     
  protected String myType;     
  protected String mySound;      
  public Cow(String type, String sound)    
  {         
     myType = type;         
     mySound = sound;     
  }     
  public Cow()    
  {         
     myType = "unknown";         
     mySound = "unknown";     
  }      
  public String getSound(){return mySound;}     
  public String getType(){return myType;} 
}
class NamedCow extends Cow
{
  private String myName;
  NamedCow(String type, String name, String sound)
  {
  	myType = type;
  	mySound = sound;
  	myName = name;
  }
  public String getName(){return myName;}
}
class Chick implements Animals
{
   private String myType;     
  private String mySound; 
  private String sound2;     
  public Chick(String type, String sound, String sound2)    
  {         
     myType = type;         
     if(((int)(Math.random()*2)+1) % 2 == 0)
     {
     	mySound = sound;
     }
     else 
     {
     	mySound = sound2;
     }   
  }     
  public Chick()    
  {         
     myType = "unknown";         
     mySound = "unknown";     
  }     
  public String getSound(){return mySound;}     
  public String getType(){return myType;} 
}
class Pig implements Animals
{
    private String myType;     
  private String mySound;      
  public Pig(String type, String sound)    
  {         
     myType = type;
     mySound = sound;
  }     
  public Pig()    
  {         
     myType = "unknown";         
     mySound = "unknown";     
  }     
  public String getSound(){return mySound;}     
  public String getType(){return myType;} 
}
class Farm 
{     
  private Animals[] lotsOfAnimals = new Animals[3];    
  public Farm()    
  {       
   lotsOfAnimals[0] = new NamedCow("cow","Elsie","moo");          
   lotsOfAnimals[1] = new Chick("chick","cheep","cluck");
   lotsOfAnimals[2] = new Pig("pig","oink");    
  }     
  public void animalSounds()    
  {
    for (int nI=0; nI < lotsOfAnimals.length; nI++) 
    {             
       System.out.println( lotsOfAnimals[nI].getType() + " goes " + lotsOfAnimals[nI].getSound() );       
    }       
    System.out.println( "The cow is known as " + ((NamedCow)lotsOfAnimals[0]).getName() );    
  } 
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "OldMacDonald" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
