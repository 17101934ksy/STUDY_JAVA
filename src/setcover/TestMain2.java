package setcover;

import java.util.*;

public class TestMain2 {

    static class NodeDto implements Comparable<NodeDto> {
        int index;
        Set subset;

        public NodeDto(int index, Set subset) {
            this.index = index;
            this.subset = subset;
        }

        @Override
        public int compareTo(NodeDto nodeDto) {
            return this.subset.size() > nodeDto.subset.size() ? -1 : 1;
        }
    }


    public static void main(String[] args) {


        Map<Integer, Set> map = new HashMap<>();

        Set[] a = new Set[10];
        a[0] = new HashSet<>(Arrays.asList(3));

        Set[] b = new Set[10];
        b[0] = new HashSet<>(Arrays.asList(3, 4, 5, 6, 7));

        NodeDto nodeDto1 = new NodeDto(1, a[0]);
        NodeDto nodeDto2 = new NodeDto(2, b[0]);
        
        PriorityQueue<NodeDto> nodeDtoQueue = new PriorityQueue<>();
        nodeDtoQueue.add(nodeDto1);
        nodeDtoQueue.add(nodeDto2);

        System.out.println("nodeDtoQueue.poll() = " + nodeDtoQueue.poll().subset);
        System.out.println("nodeDtoQueue.poll() = " + nodeDtoQueue.poll());


    }
}
