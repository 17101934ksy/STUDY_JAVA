package thread;

public class PrintThread2 extends Thread{
    @Override
    public void run() {
        while(true){
            System.out.println("running");
            if(Thread.interrupted()){
                break;
            }
        }
        System.out.println("source end");
        System.out.println("program exit");
    }
}
