//  Joshua Kuiros
//  CMPCS 473
//  Project 3 - Synchronization
//  November 10, 2013


import java.util.concurrent.*;
import java.util.*;


public class Queue 
{
    LinkedList<Person> q = new LinkedList<Person>();
    LinkedList<Person> waitingQueue = new LinkedList<Person>();
    Semaphore mutex = new Semaphore(1);
    
    
    // return list of people that are waiting to cross
    public LinkedList<Person> getWaitingQueue (int currentTime)
    {
        
        for(int i = 0; i < q.size(); i++)
        {
            LinkedList<Integer> temp = q.get(i).times;
            for(int j = 0; j < temp.size(); j++)
            {
                if(temp.get(j) == currentTime)
                {
                    Person waitingPerson = q.get(i);
                    if(!(waitingQueue.contains(waitingPerson)))
                    {
                        waitingQueue.add(waitingPerson);
                    }
                    
                }
            }
        }
        
        return waitingQueue;
        
    }
    
    // add to queue and wait to run
    public void wait(Person p) throws InterruptedException
    {
        mutex.acquire();
        q.add(p);
        mutex.release();
        p.sem.acquire();
    }
    
    // decide which person crosses the patch next
    public void signal() throws InterruptedException
    {
        try
        {
        if(Path.currentTime == 37)                  // final runtime
        {
            Path.out.write("END!\n");
            Path.out.close();
            System.exit(0);
        }
         mutex.acquire();                               // acquire queue lock
         
         int currentIst = 0;
         int currentCse = 0;
         Person pRemove;
         int toRemove = 0;        
         boolean professorExists;
         int tempBirthDate; 
         
         waitingQueue = getWaitingQueue(Path.currentTime);
         
         while(waitingQueue.size() == 0)            // no one is waiting
         {
             Path.out.write("No one at path!!! at time " + Path.currentTime + "\n");
             Path.currentTime++;
             waitingQueue = getWaitingQueue(Path.currentTime);
            
         }
         
         for(int i = 0; i < waitingQueue.size(); i++)
         {
                String temp;
                if(waitingQueue.get(i).student)
                {
                    temp = "Student";
                }
                else
                {
                    temp = "Professor";
                }
             Path.out.write( "    " + temp + " " + waitingQueue.get(i).department + waitingQueue.get(i).id + " is waiting with a birthday " + waitingQueue.get(i).birthDate + "\n");
             
             if(waitingQueue.get(i).department == "CSE")
                 currentCse++;
             else
                 currentIst++;
         }
         
         // skirmish
         if(currentCse >= currentIst)                       // CSE wins
         {
             professorExists = false;
             
             Path.out.write("        CSE wins.\n");
             Path.out.write("            CSE count: " + currentCse + "\n");
             Path.out.write("            IST count: " + currentIst + "\n");
             
             for(int j = 0; j < waitingQueue.size(); j++)
             {
                 if(waitingQueue.get(j).department == "CSE" && waitingQueue.get(j).student == false)
                 {
                     professorExists = true;
                 }
             }
                 if(professorExists)                            // CSE Professor
                 {
                     tempBirthDate = 0;
                     
                     for(int k = 0; k < waitingQueue.size(); k++)
                     {
                         if(waitingQueue.get(k).department == "CSE" && waitingQueue.get(k).student == false)
                         {
                             if(tempBirthDate < waitingQueue.get(k).birthDate)
                             {
                                 tempBirthDate = waitingQueue.get(k).birthDate;
                                 toRemove = k;
                             }
                          }
                      }
                 }
                 else                                           // CSE Student 
                 {
                     tempBirthDate = 0;
                     
                     for(int l = 0; l < waitingQueue.size(); l++)
                     {
                         if(waitingQueue.get(l).department == "CSE" && waitingQueue.get(l).student == true)
                         {
                             if(tempBirthDate < waitingQueue.get(l).birthDate)
                             {
                                 tempBirthDate = waitingQueue.get(l).birthDate;
                                 toRemove = l;
                             }
                         }
                     }
                     
                 }
         }
         else                                       // IST
         {
             professorExists = false;
             
             Path.out.write("        IST wins.\n");
             Path.out.write("            CSE count: " + currentCse + "\n");
             Path.out.write("            IST count: " + currentIst + "\n");
            
             
             for(int m = 0; m < waitingQueue.size(); m++)
             {
                 if(waitingQueue.get(m).department == "IST" && waitingQueue.get(m).student == false)
                 {
                     professorExists = true;
                 }
             }
                 if(professorExists)                // IST Professor
                 {
                     tempBirthDate = 0;
                     
                     for(int n = 0; n < waitingQueue.size(); n++)
                     {
                         if(waitingQueue.get(n).department == "IST" && waitingQueue.get(n).student == false)
                         {
                             if(tempBirthDate < waitingQueue.get(n).birthDate)
                             {
                                 tempBirthDate = waitingQueue.get(n).birthDate;
                                 toRemove = n;
                             }
                          }
                      }
                 }
                 else                               // IST Student
                 {
                     tempBirthDate = 0;
                     
                     for(int p = 0; p < waitingQueue.size(); p++)
                     {
                         if(waitingQueue.get(p).department == "IST" && waitingQueue.get(p).student == true)
                         {
                             if(tempBirthDate < waitingQueue.get(p).birthDate)
                             {
                                 tempBirthDate = waitingQueue.get(p).birthDate;
                                 toRemove = p;
                             }
                         }
                     }
                     
                 }
             
         }
         pRemove = waitingQueue.remove(toRemove);               // remove person from waiting queue           
         mutex.release();                                       // release queue
         pRemove.sem.release();                                 // allow person to cross
        }   
        catch(Exception e)
        {
            System.out.println("error");
        }
         
         
    }
}
