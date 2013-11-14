//  Joshua Kuiros
//  CMPCS 473
//  Project 3 - Synchronization
//  November 10, 2013


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.concurrent.*;
import java.util.*;


public class Path 
{
    public static int i = 0;
    public static Queue pathQueue = new Queue();
    public static int currentTime;
    public static FileWriter fstream; 
    public static BufferedWriter out; 

    
    public static void main(String[] args) throws InterruptedException
    {
       
        try
        {
            // read input file
            File f = new File("input_file.txt");
            Scanner s = new Scanner(f);
            
            // write to output file
            fstream = new FileWriter("pr3.txt");
            out = new BufferedWriter(fstream);
            
            
          // read in birthdays
          int tempBirthday1 = s.nextInt();
          int tempBirthday2 = s.nextInt();
          int tempBirthday3 = s.nextInt();
          int tempBirthday4 = s.nextInt();
          int tempBirthday5 = s.nextInt();
          int tempBirthday6 = s.nextInt();
          int tempBirthday7 = s.nextInt();
          int tempBirthday8 = s.nextInt();
          int tempBirthday9 = s.nextInt();
          int tempBirthday10 = s.nextInt();
          int tempBirthday11 = s.nextInt();
          int tempBirthday12 = s.nextInt();
          int tempBirthday13 = s.nextInt();
          int tempBirthday14 = s.nextInt();
          
          currentTime = s.nextInt();
          
          int personOneCross = s.nextInt();
          
          Person tempPerson1 = new Person(tempBirthday1, "CSE", false, pathQueue, personOneCross, "F1");   
          
          for(i = 0; i < personOneCross; i++)
          {
              tempPerson1.times.add(s.nextInt());
          }
          
          int personTwoCross = s.nextInt();
          
          Person tempPerson2 = new Person(tempBirthday2, "CSE", false, pathQueue, personTwoCross,  "F2"); 
          
          for(i = 0; i < personTwoCross; i++)
          {
              tempPerson2.times.add(s.nextInt());
          }
          
          int personThreeCross = s.nextInt();
          
          Person tempPerson3 = new Person(tempBirthday3, "CSE", false, pathQueue, personThreeCross,  "F3"); 
          
          for(i = 0; i < personThreeCross; i++)
          {
              tempPerson3.times.add(s.nextInt());
          }
          
          int personFourCross = s.nextInt();
          
          Person tempPerson4 = new Person(tempBirthday4, "IST", false, pathQueue, personFourCross,  "F1");    
          
          for(i = 0; i < personFourCross; i++)
          {
              tempPerson4.times.add(s.nextInt());
          }
          
          int personFiveCross = s.nextInt();
          
          Person tempPerson5 = new Person(tempBirthday5, "IST", false, pathQueue, personFiveCross, "F2");
          
          for(i = 0; i < personFiveCross; i++)
          {
              tempPerson5.times.add(s.nextInt());
          }
          
          int personSixCross = s.nextInt();
          
          Person tempPerson6 = new Person(tempBirthday6, "CSE", true, pathQueue, personSixCross,  "S1"); 
          
          for(i = 0; i < personSixCross; i++)
          {
              tempPerson6.times.add(s.nextInt());
          }
          
          int personSevenCross = s.nextInt();
          
          Person tempPerson7 = new Person(tempBirthday7, "CSE", true, pathQueue, personSevenCross,  "S2");  
          
          for(i = 0; i < personSevenCross; i++)
          {
              tempPerson7.times.add(s.nextInt());
          }
          
          
          int personEightCross = s.nextInt();
          
          Person tempPerson8 = new Person(tempBirthday8, "CSE", true, pathQueue, personEightCross,  "S3");   
          
          for(i = 0; i < personEightCross; i++)
          {
              tempPerson8.times.add(s.nextInt());
          }
          
          int personNineCross = s.nextInt();
          
          Person tempPerson9 = new Person(tempBirthday9, "CSE", true, pathQueue, personNineCross,  "S4");     
          
          for(i = 0; i < personNineCross; i++)
          {
              tempPerson9.times.add(s.nextInt());
          }
          
          int personTenCross = s.nextInt();
          
          Person tempPerson10 = new Person(tempBirthday10, "CSE", true, pathQueue, personTenCross,  "S5");           
          
          for(i = 0; i < personTenCross; i++)
          {
              tempPerson10.times.add(s.nextInt());
          }
          
          int personElevenCross = s.nextInt();
          
          Person tempPerson11 = new Person(tempBirthday11, "IST", true, pathQueue, personElevenCross,  "S1"); 
         
          for(i = 0; i < personElevenCross; i++)
          {
              tempPerson11.times.add(s.nextInt());
              //System.out.println("arrival times " + tempPerson11.times.get(i));
          }
          
          int personTwelveCross = s.nextInt();
          
          Person tempPerson12 = new Person(tempBirthday12, "IST", true, pathQueue, personTwelveCross,  "S2");    
          
          for(i = 0; i < personTwelveCross; i++)
          {
              tempPerson12.times.add(s.nextInt());
          }
          
          int personThirteenCross = s.nextInt();
          
          Person tempPerson13 = new Person(tempBirthday13, "IST", true, pathQueue, personThirteenCross,  "S3"); 
          
          for(i = 0; i < personThirteenCross; i++)
          {
              tempPerson13.times.add(s.nextInt());
          }
          
          int personFourteenCross = s.nextInt();
          
          Person tempPerson14 = new Person(tempBirthday14, "IST", true, pathQueue, personFourteenCross,  "S4");
          
          for(i = 0; i < personFourteenCross; i++)
          {
              tempPerson14.times.add(s.nextInt());
          }
          
          
          Thread thread1 = new Thread(tempPerson1);
          Thread thread2 = new Thread(tempPerson2);
          Thread thread3 = new Thread(tempPerson3);
          Thread thread4 = new Thread(tempPerson4);
          Thread thread5 = new Thread(tempPerson5);
          Thread thread6 = new Thread(tempPerson6);
          Thread thread7 = new Thread(tempPerson7);
          Thread thread8 = new Thread(tempPerson8);
          Thread thread9 = new Thread(tempPerson9);
          Thread thread10 = new Thread(tempPerson10);
          Thread thread11 = new Thread(tempPerson11);
          Thread thread12 = new Thread(tempPerson12);
          Thread thread13 = new Thread(tempPerson13);
          Thread thread14 = new Thread(tempPerson14);
          
          thread1.start();
          thread2.start();
          thread5.start();
          thread6.start();
          thread3.start();
          thread4.start();
          thread7.start();
          thread8.start();
          thread9.start();
          thread10.start();
          thread11.start();
          thread12.start();
          thread13.start();
          thread14.start();
            
          //Thread.sleep(10000);
          
          out.write("START!\n"); 
          
          pathQueue.signal();           // begin process
            
        }
        catch(Exception e)
        {
            System.out.println("can't find file!");
        }
    }


}
