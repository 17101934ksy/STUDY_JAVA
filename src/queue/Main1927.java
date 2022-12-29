package queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main1927 {

    public static void main(String[] args) throws IOException {

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {

            int x = Integer.parseInt(reader.readLine());

            if ( x == 0) {
                if (minHeap.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(minHeap.poll());
                }
            } else {
                minHeap.add(x);
            }
        }
    }
}
