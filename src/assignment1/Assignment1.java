/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.util.concurrent.atomic.*;

public class Assignment1 
{
    //global constant initilizing number of cars to access junction.
    static final int CARS_FROM_A = 30;
    static final int CARS_FROM_B = 30;
    static final int CARS_FROM_C = 30;
    static final int CARS_FROM_D = 30;
    static RoadJunction theRoadJunction;
    

    
    public static void main(String[] args) 
    {
        //create the junction.
        theRoadJunction = new RoadJunction();
                
        System.out.println("Started");
        
        //create arrays to hold cars.
        CarFromA[] carFromA = new CarFromA [CARS_FROM_A];
        CarFromB[] carFromB = new CarFromB [CARS_FROM_B];
        CarFromC[] carFromC = new CarFromC [CARS_FROM_C];
        CarFromD[] carFromD = new CarFromD [CARS_FROM_D];
        
        //create cars to enter junction.
        for (int i = 0; i< CARS_FROM_A; i++)
        {
            carFromA[i] = new CarFromA("A" +i, theRoadJunction);
        }
        for (int i = 0; i< CARS_FROM_B; i++)
        {
            carFromB[i] = new CarFromB("B" +i, theRoadJunction);
        }
        for (int i = 0; i< CARS_FROM_C; i++)
        {
            carFromC[i] = new CarFromC("C" +i, theRoadJunction);
        }
        for (int i = 0; i< CARS_FROM_D; i++)
        {
            carFromD[i] = new CarFromD("D" +i, theRoadJunction);
        }
        
        //set the Car processes running.
        for(int i = 0;i < CARS_FROM_A; i++)
        {
                carFromA[i].start();
        }
        for(int i = 0;i < CARS_FROM_B; i++)
        {
                carFromB[i].start();
        }
        for(int i = 0;i < CARS_FROM_C; i++)
        {
                carFromC[i].start();
        }
        for(int i = 0;i < CARS_FROM_D; i++)
        {
                carFromD[i].start();
        }
        
        //wait for all Car threads to finish.
        for(int i = 0; i < CARS_FROM_A; i++)
        {
            try
            {
                carFromA[i].join();
            }
            catch(InterruptedException ex){}
        }
        for(int i = 0; i < CARS_FROM_B; i++)
        {
            try
            {
                carFromB[i].join();
            }
            catch(InterruptedException ex){}
        }
        for(int i = 0; i < CARS_FROM_C; i++)
        {
            try
            {
                carFromC[i].join();
            }
            catch(InterruptedException ex){}
        }
        for(int i = 0; i < CARS_FROM_D; i++)
        {
            try
            {
                carFromD[i].join();
            }
            catch(InterruptedException ex){}
        }
        
        //display all movements taken place.
        theRoadJunction.theCarActivity.printActivities();
        
        System.out.println("all the cars have successfully navigated the junction!");        
    }
    
}
