package thread;

public class AutoSaveThread extends Thread {
    public void save() {
        System.out.println("saved worked contents");
    }

    @Override
    public void run() {
        while(true){
            try{
                Thread.sleep(1000);
            } catch (Exception e){
                break;
            }
            save();
        }
    }
}
