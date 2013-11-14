//  Joshua Kuiros
//  CMPCS 473
//  Project 3 - Synchronization
//  November 10, 2013


import java.util.concurrent.*;
import java.util.*;


public class Person extends Thread implements Runnable
{
    public Semaphore sem = new Semaphore(0);
    public int birthDate;
    public boolean student;
    public Queue q;
    public int crossTimes;
    public String department;
    public String id;
    public LinkedList<Integer> times = new LinkedList<Integer>();
    
    // init Person object
    public Person(int birthDate, String department, boolean student, Queue q, int crossTimes, String id)
    {
        this.birthDate = birthDate;
        this.department = department;
        this.student = student;
        this.q = q;
        this.crossTimes = crossTimes;
        this.id = id;
    }
    
    // "cross path"
    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                
                // Entry Point
                
                q.wait(this);
                
                // Critical Section
                
                String temp;
                
                if(this.student)
                {
                    temp = "Student";
                }
                else
                {
                    temp = "Professor";
                }
                
                Path.out.write(this.department + this.id + " enters path at time " + Path.currentTime + "\n");
                Path.out.write("    Birthday: " + this.birthDate + "\n");
                Path.out.write("    Type: " + temp + "\n");
                Path.currentTime++;
                Path.out.write(this.department + this.id + " leaves path at time " + Path.currentTime + "\n");
                
                q.signal();
                
                // Exit
                
                //Thread.sleep(15000);
                        
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
