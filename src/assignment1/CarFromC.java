/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

class CarFromC extends Thread
{
    String carName;
    RoadJunction theJunction;
    
    public CarFromC(String carName, RoadJunction theJunction)
    {
        this.carName = carName;
        this.theJunction = theJunction;
    }
    
    public void run()
    {
        int count =0;
        //start the process.
        theJunction.joinC(carName);
        CDS.idleQuietly((int)Math.random()*100);
        if(count <=1)
        {
            theJunction.moveOverJunctionFromC();
            count++;
        }
        
    }
}