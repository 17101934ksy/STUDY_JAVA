package setcover;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {

    // subset의 우선순위를 기억하기 위한 Dto 객체 생성
    static class NodeDto implements Comparable<NodeDto>{
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

    static int node;
    static int edge;

    static List<String> results;

    static Set[] subsetNodes;

    static PriorityQueue<NodeDto> subsetNodesQueue;

    static Set<Integer> unionNodes;


    public static void main(String[] args) throws IOException {

        // buffer 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // node, edge 초기화
        node = parseInt(st.nextToken());
        edge = parseInt(st.nextToken());

        subsetNodes = new Set[node+1];
        unionNodes = new HashSet<>(node);

        results = new ArrayList<>();

        // queue에 입력되는 순서를 set의 개수로 내림차순하되, 인덱스를 기억하기 위해 NodeDto 객체화
        subsetNodesQueue = new PriorityQueue<>();

        // unionNode 초기화
        initUnionNodes();

        // edge 입력받고 subset 만들기
        initInputEdgesAndMakeSubSet(br);

        // 서브셋 만들기 우선순위 큐
        sortSubsetNodesQueue();

        //그리디 알고리즘 적용
        satisfiedUnionSetByGreedy();

        System.out.printf(String.join(" ", results));

    }

    private static void initUnionNodes() {
        for (int i=1; i<=node; i++) {
            unionNodes.add(i);
        }
    }

    private static void initInputEdgesAndMakeSubSet(BufferedReader br) throws IOException {
        for (int i = 1; i<=edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = parseInt(st.nextToken());
            int y = parseInt(st.nextToken());

            // subset에 넣기 입력 + 배열에 넣기 O(n)
            if (subsetNodes[x] == null) { subsetNodes[x] = new HashSet<Integer>(Arrays.asList(x, y)); }
            else { subsetNodes[x].addAll(new HashSet<Integer>(Arrays.asList(x, y))); }

            if (subsetNodes[y] == null) { subsetNodes[y] = new HashSet<Integer>(Arrays.asList(x, y)); }
            else { subsetNodes[y].addAll(new HashSet<Integer>(Arrays.asList(x, y))); }
        }
    }

    private static void sortSubsetNodesQueue() {

        // set의 개수에 따라 정렬하기 위한 SetLengthComparator 클래스 생성
        for (int i=1; i<subsetNodes.length; i++) {
           NodeDto nodeDto = new NodeDto(i, subsetNodes[i]);
           subsetNodesQueue.add(nodeDto);
        }
    }

    private static void satisfiedUnionSetByGreedy() {

        int preUnionSize = unionNodes.size();

        while (unionNodes.size() != 0) {

            NodeDto nodeDto = subsetNodesQueue.poll();
            unionNodes.removeAll(nodeDto.subset);

            if (preUnionSize != unionNodes.size()) {
                preUnionSize = unionNodes.size();
                results.add(String.valueOf(nodeDto.index));
            }
        }
        Collections.sort(results);
    }

}
