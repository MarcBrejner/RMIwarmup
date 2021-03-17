import java.io.Serializable;

public class Car implements Serializable, Runnable {

    public synchronized void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public synchronized int getWheels(){
        return wheels;
    }

    boolean isDone;
    int wheels;
    int lights;
    BinaryTree binaryTree = new BinaryTree().createBinaryTree();


    public Car(){
        wheels = 4;
        lights = 2;
    }

    public void run(){
        System.out.println(wheels+" wheels ,"+lights+" lights wroom wroom");
        binaryTree.traverseInOrder(binaryTree.root);
    }

}
