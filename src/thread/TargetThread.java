package thread;

public class TargetThread extends Thread {
    public void run() {
        for(long i=0; i<100000000; i++){}

        try{
            Thread.sleep(500);
        }catch (Exception e){}

        for(long i=0; i<1000000; i++){}
    }
}
