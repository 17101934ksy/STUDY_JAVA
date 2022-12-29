package queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Main11286 {

    static class AbsNumber implements Comparable<AbsNumber>{
        private int num;

        public AbsNumber (int num) {
            this.num = num;
        }

        @Override
        public int compareTo(AbsNumber absNumber) {

            if (Math.abs(this.num) == Math.abs(absNumber.num)) {
                return Integer.compare(this.num, absNumber.num);
            }
            return Integer.compare(Math.abs(this.num), Math.abs(absNumber.num));
        }
    }

    public static void main(String[] args) throws IOException {

        PriorityQueue<AbsNumber> absHeap = new PriorityQueue<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(reader.readLine());

            if (x == 0) {
                if (absHeap.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(absHeap.poll().num);
                }
            } else {
                absHeap.add(new AbsNumber(x));
            }
        }
    }

}
