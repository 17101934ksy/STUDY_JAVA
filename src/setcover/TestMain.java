package setcover;

import java.util.*;

public class TestMain {

    static class SetLengthCompare implements Comparator<Set> {
        @Override
        public int compare(Set t1, Set t2) {
            return t1.size() > t2.size() ? 1: t1.size() < t2.size() ? -1 : 0;
        }
    }


    static List<Set> aa;

    public static void main(String[] args) {


        Set a = new HashSet<>(Arrays.asList(3, 4, 8, 123, 2));

        Set b = new HashSet<>(Arrays.asList(7, 6 ,4));

        aa = new ArrayList<>(20);

        Set[] bb = new Set[20];

        bb[0] = new HashSet<>(Arrays.asList(3,4, 5));
        System.out.println("bb[0] = " + bb[0]);


        bb[0].addAll(new HashSet<>(Arrays.asList(3, 6, 40, 100)));

        PriorityQueue<Set> subsetNodesQueue = new PriorityQueue<>(new Comparator<Set>() {
            @Override
            public int compare(Set t1, Set t2) {
                return t1.size() > t2.size() ? 1 : t1.size() < t2.size() ? -1 : 0;
            }
        });
        subsetNodesQueue.add(bb[0]);

        System.out.println("subsetNodesQueue.poll() = " + subsetNodesQueue.poll());


        System.out.println("bb[0] = " + bb[0]);

//        aa.get(0);
//        aa.get(0).add(a);
//        aa.get(9).add(a);

        
        List<Set> k = new ArrayList<>();
        
        k.add(a);
        k.add(b);

        Collections.sort(k, new SetLengthCompare());

        System.out.println("k.get(0) = " + k);

        Set c = new HashSet<>(a);

        a.remove(2);

        c.removeAll(a);

        System.out.println("c.size() = " + c.size());

        System.out.println("c = " + c);

        c.remove(123);

        System.out.println("a = " + a);

        System.out.println("c.getClass() = " + c.getClass());

        System.out.println("k.size() = " + k.size());

        
        PriorityQueue queue = new PriorityQueue<>(new Comparator<Set>() {
            @Override
            public int compare(Set t1, Set t2) {
                return t1.size() > t2.size() ? 1: t1.size() < t2.size() ? -1 : 0 ;
            }
        });
        queue.add(a);
        queue.add(c);

        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.poll() = " + queue.poll());

    }



}
