package day9;

import java.util.Queue;
import java.util.ArrayDeque;

public class QueueTest {

    public static void main(String[] args) {
        
        Queue<Integer> queue = new ArrayDeque();
        
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);

        
        while(!queue.isEmpty()) {
            System.out.println("queue.poll() = " + queue.poll());
        }
        
    }


}

