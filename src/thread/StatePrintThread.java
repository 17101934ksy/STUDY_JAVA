package thread;

public class StatePrintThread extends Thread{
    private Thread targetThread;

    public StatePrintThread(Thread targetThread){
        this.targetThread = targetThread;
    }
    public void run(){
        while(true){
            Thread.State state = targetThread.getState();
            System.out.println("target thread: " + state);

            if (state == Thread.State.NEW){
                targetThread.start();
            }

            if (state == State.TERMINATED){
                break;
            }

            try{
                Thread.sleep(400);
            } catch(Exception e){}
        }
    }
}
