package greedysetcover;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {

    static Set<Integer> unionNodes;
    static int node;
    static int edge;
    static List<Integer> results;
    static Set[] subsetNodes;
    static List<NodeDto> subsetNodeList;

    public static class NodeDto implements Comparable<NodeDto> {
        private int index;
        private Set<Integer> subset;

        public NodeDto(int index, Set subset) {
            this.index = index;
            this.subset = subset;
        }

        public int getIndex() { return this.index; }
        public Set<Integer> getSubset() { return this.subset; }

        public int countOfSubtractSubsetFromUnionSet(Set<Integer> unionSet) {
            int count = 0;
            for (Integer e : this.subset) { if (unionSet.contains(e)){ count ++;} }
            return count;
        }

        @Override
        public int compareTo(NodeDto nodeDto) {

            return this.countOfSubtractSubsetFromUnionSet(unionNodes) > nodeDto.countOfSubtractSubsetFromUnionSet(unionNodes) ? 1 :
                    this.countOfSubtractSubsetFromUnionSet(unionNodes) < nodeDto.countOfSubtractSubsetFromUnionSet(unionNodes) ? -1 :
                            this.getSubset().size() < nodeDto.getSubset().size() ?  1 : -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = parseInt(st.nextToken());
        edge = parseInt(st.nextToken());

        subsetNodes = new Set[node+1];
        unionNodes = new HashSet<>(node);

        results = new ArrayList<>();

        // List에 입력되는 순서를 unionSet과 교집합의 개수가 가장 많은 순서로 내림차순하되, 인덱스를 기억하기 위해 NodeDto 객체화
        subsetNodeList = new ArrayList<>();

        // 전체집합 초기화
        initUnionNodes();

        // 간선에 값 입력받아 subsetNodeList 만들기
        initInputEdgesAndMakeSubset(br);

        // 컬렉션 리스트로 그리디 순회 순서 구하기
        satisfiedUpdateSubset();

        // 출력
        extractResult();
    }

    private static void extractResult() {
        for (int i=0; i<results.size(); i++) {
            if (i == results.size() -1) {
                System.out.printf(String.valueOf(results.get(i)));
            } else {
                System.out.printf(results.get(i) + " ");
            }
        }
    }

    private static void initUnionNodes() {
        for (int i=1; i<=node; i++) {
            unionNodes.add(i);
        }
    }

    private static void initInputEdgesAndMakeSubset(BufferedReader br) throws IOException {
        for (int i=1; i<=edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = parseInt(st.nextToken());
            int y = parseInt(st.nextToken());

            if (subsetNodes[x] == null) { subsetNodes[x] = new HashSet<Integer>(); }
            if (subsetNodes[y] == null) { subsetNodes[y] = new HashSet<Integer>(); }

            subsetNodes[x].add(x);
            subsetNodes[x].add(y);

            subsetNodes[y].add(x);
            subsetNodes[y].add(y);
        }

        for (int i=1; i< subsetNodes.length; i++) {
            NodeDto nodeDto = new NodeDto(i, subsetNodes[i]);
            subsetNodeList.add(nodeDto);
        }
    }

    public static void satisfiedUpdateSubset() {
        while (unionNodes.size() != 0) {
            Collections.sort(subsetNodeList);
            NodeDto nodeDto = subsetNodeList.remove(subsetNodeList.size() - 1);

            results.add(nodeDto.getIndex());
            unionNodes.removeAll(nodeDto.getSubset());
        }
        Collections.sort(results);
    }


}
