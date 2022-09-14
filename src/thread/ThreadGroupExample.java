package thread;

public class ThreadGroupExample {
    public static void main(String[] args){
        ThreadGroup myGroup = new ThreadGroup("myGroup");
        WorkThread workThreadA = new WorkThread(myGroup, "workThreadA");
        WorkThread workThreadB = new WorkThread(myGroup, "workThreadB");

        workThreadA.start();
        workThreadB.start();

        System.out.println("[main thread list print ]");
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        mainGroup.list();
        System.out.println();

        try{
            Thread.sleep(3000);
        } catch(InterruptedException e){}

        System.out.println("[myGroup interrupt method call]");
        myGroup.interrupt();
    }
}
