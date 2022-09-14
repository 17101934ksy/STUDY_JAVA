package thread;

public class InterruptExample {
    public static void main(String[] args){
        Thread thread = new PrintThread2();
        thread.start();

        try{
            Thread.sleep(50);
        } catch(InterruptedException e){}

        thread.interrupt();

    }
}
