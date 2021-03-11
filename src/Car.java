import java.io.Serializable;

public class Car implements Serializable, Runnable {

    public synchronized void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public synchronized int getWheels(){
        /*
        while(!isDone){
            try{
                wait();
            }catch(InterruptedException e){}
        }*/

        return wheels;
    }

    boolean isDone;
    int wheels;
    int lights;


    public Car(){
        wheels = 4;
        lights = 2;
    }

    public void run(){
        System.out.println(wheels+" wheels ,"+lights+" lights wroom wroom");
    }

}
