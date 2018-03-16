
package assignment1;

class CarFromB extends Thread
{
    String carName;
    RoadJunction theJunction;
    
    public CarFromB(String carName, RoadJunction theJunction)
    {
        this.carName = carName;
        this.theJunction = theJunction;
    }
    
    public void run()
    {
        int count = 0;
        //start the process.
        theJunction.joinB(carName);
        CDS.idleQuietly((int)Math.random()*100);
        if(count <=1)
        {
            theJunction.moveOverJunctionFromB();
            count++;
        }
        
    }
}
