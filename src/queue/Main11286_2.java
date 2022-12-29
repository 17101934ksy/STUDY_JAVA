package queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Main11286_2 {

    static class AbsNumber {
        private int num;

        public AbsNumber (int num) {
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {

        PriorityQueue<AbsNumber> absHeap = new PriorityQueue<>(
                (absNumber, t1) -> {

                    if (Math.abs(absNumber.num) == Math.abs(t1.num)) {
                        return absNumber.num - t1.num;
                    }
                    return Math.abs(absNumber.num) - Math.abs(t1.num);
                }
        );

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
