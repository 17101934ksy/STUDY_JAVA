package thread;

public class WaitNotifyExample {
    public static void main(String[] args){
        WorkObject workObject = new WorkObject();

        ThreadWorkA threadA = new ThreadWorkA(workObject);
        ThreadWorkB threadB = new ThreadWorkB(workObject);

        threadA.start();
        threadB.start();
    }
}
