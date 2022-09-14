package thread;

import java.awt.*;
import java.lang.Thread;

public class BeepPrintExample1 {
    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for(int i=0; i<5; i++){
            toolkit.beep();
        }
        try{
            Thread.sleep(500);
        } catch(Exception e){}

        for (int i=0; i<5; i++) {
            System.out.println("Thing");
            try{Thread.sleep(500); } catch(Exception e){}
        }
    }
}
