package thread;

public class WaitNotifyExample2 {
    public static void main(String[] args){
        DataBox dataBox = new DataBox();

        ProducerThread pct = new ProducerThread(dataBox);
        ConsumerThread cst = new ConsumerThread(dataBox);

        pct.start();
        cst.start();
    }
}
