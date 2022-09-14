package thread;

public class WorkObject {
    public synchronized void methodA(){
        System.out.println("ThreadA methodA run");
        notify();
        try{
            wait();
        }catch (InterruptedException e){}
    }
    public synchronized  void methodB() {
        System.out.println("ThreadB methodB run");
        notify();
        try{
            wait();
        }catch(InterruptedException e){}
    }
}
