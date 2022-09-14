package thread;

public class ThreadB extends Thread{
    public boolean stop = false;
    public boolean work = true;

    public void run(){
        while(!stop){
            if(work){
                System.out.println("ThreadB worked list");
            }else{
                Thread.yield();
            }
        }
        System.out.println("ThreadB terminated");
    }
}
