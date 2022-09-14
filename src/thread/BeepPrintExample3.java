package thread;

public class BeepPrintExample3 {
    public static void main(String[] args){
        Thread thread = new BeepThread();
        thread.start();

        for(int i=0; i<5; i++){
            System.out.println("Thing");
            try{
                Thread.sleep(500);
            }catch (Exception e) {}
        }
    }
}
