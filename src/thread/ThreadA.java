package thread;

public class ThreadA extends Thread{
    public boolean stop = false;
    public boolean work = true;

    @Override
    public void run() {
        while(!stop){
            if(work){
                System.out.println("Thread Work contents");
            } else{
                Thread.yield();
            }
        }
        System.out.println("ThreadA terminated");
    }
}
