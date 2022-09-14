package thread;

public class DataBox {
    private String data;

    public synchronized String getData(){
        if(this.data == null){
            try{
                wait();
            } catch(InterruptedException e){}
        }
        String returnvalue = data;
        System.out.println("Consumer Thread : " + returnvalue);
        data = null;
        notify();
        return returnvalue;
    }

    public synchronized void setData(String data){
        if(this.data != null){
            try{
                wait();
            } catch(InterruptedException e){}
        }
        this.data=data;
        System.out.println("Product Thread : " + data);
        notify();
    }
}
