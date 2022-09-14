package thread;

public class ConsumerThread extends Thread{
    private DataBox dataBox;

    public ConsumerThread(DataBox databox){
        this.dataBox = databox;
    }

    @Override
    public void run() {
        for(int i=0; i<5; i++){
            String data = dataBox.getData();
        }
    }
}
