package thread;

public class ThreadWorkA extends Thread{
    private WorkObject workObject;

    public ThreadWorkA(WorkObject workObject){
        this.workObject = workObject;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            workObject.methodA();
        }
    }
}
