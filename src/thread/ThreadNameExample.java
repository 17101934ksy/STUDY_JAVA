package thread;

public class ThreadNameExample {
    public static void main(String[] args){
        Thread mainThread = Thread.currentThread();
        System.out.println(mainThread.getName());

        Thread threadA = new Thread();
        System.out.println(threadA.getName());
        threadA.setName("test1");
        System.out.println(threadA.getName());
        threadA.start();

        Thread threadB = new Thread();
        System.out.println(threadB.getName());
        threadB.start();
    }
}
