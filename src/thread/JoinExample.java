package thread;

public class JoinExample {
    public static void main(String[] args){
        SumThread sumThread = new SumThread();
        sumThread.start();

        try{
            sumThread.join();
        }catch (Exception e){}

        System.out.println("1 ~ 100 of sum" + sumThread.getSum());
    }
}
