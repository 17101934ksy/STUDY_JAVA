package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class QuickSort {

    static StringTokenizer st;
    static int [] arr;

    public static void main(String[] args) throws IOException {
        // BufferReader를 이용하여 입력 받기
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // StringTokenizer를 이용해 토큰 단위로 입력 받기 위해 선언
        st = new StringTokenizer(bufferedReader.readLine());
        int n = parseInt(st.nextToken());
        // 배열의 입력 크기 선언
        int [] arr = new int[n];

        // 배열에 포함되는 정수 입력 받기
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(bufferedReader.readLine());
            arr[i] = parseInt(st.nextToken());
        }

        // 정렬 메소드 적용
        sort(arr);

        // 향상된 for문으로 출력
        for (int i : arr) {
            System.out.println(i);
        }
    }


    // 정렬 메소드 선언
    public static void sort(int[] arr){
        sortByPivotOnLeft(arr, 0, arr.length -1);
    }


    private static void sortByPivotOnLeft(int[] arr, int leftNode, int rightNode){
        // leftNode가 rightNode보다 크거나 같은 경우 정렬해야하는 원소가 1개 이하이므로 return
      if (leftNode >= rightNode){
          return;
      }

      // 파티션 메소드를 선언하여 피봇을 선정
      int pivot = partition(arr, leftNode, rightNode);

      // 선정된 피못을 기준으로 왼쪽, 오른쪽 분할된 배열에 퀵정렬 알고리즘 각각 적용하여 재귀식 구현
      sortByPivotOnLeft(arr, leftNode, pivot - 1);
      sortByPivotOnLeft(arr, pivot + 1, rightNode);
    }


    /**
     * 피봇을 기준으로 파티션을 나누는 메소드
     */
    private static int partition(int[] arr, int leftNode, int rightNode) {


        int left = leftNode; //피봇을 기준으로 가장 왼쪽인 노드(인덱스) 값 할당
        int right = rightNode; //피봇을 기준으로 가장 오른쪽인 노드(인덱스) 값 할당
        int pivot = arr[leftNode]; //피봇값으로 가장 왼쪽의 노드 선정 값 할당

        // 왼쪽의 노드가 오른쪽의 노드보다 작을 때까지 루프
        while(left < right){

            // 배열의 오른쪽 노드의 값이 피봇보다 크고 왼쪽 노드가 오른쪽 노드보다 작을 때
            while((arr[right] > pivot) && (left < right)){ right --; }

            // 배열의 왼쪽 노드의 값이 피봇보다 작고 왼쪽 노드가 오른쪽 노드보다 작을 때
            while((arr[left] <= pivot) && (left < right)){ left ++; }

            // 오른쪽 노드가 피봇보다 작고 왼쪽 노드가 피봇보다 큰 노드가 발견되면, swap을 호출함
            swap(arr, left, right);

            // swap이 적용되면, 기억한 left, right 노드(인덱스)에서부터 다시 loop 진행
        }

        // 모두 체인지 하면, 다시 맨 왼쪽 노드에 피봇 설정
        swap(arr, leftNode, left);

        return left;
    }

    /**
     * @return left, right(인덱스)에 해당하는 배열 값을 서로 교환하는 메소드
     */
    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left]; //arr[left] 값 임시 저장
        arr[left] = arr[right]; //arr[left] <- arr[right] 할당
        arr[right] = temp; //arr[right] <- 저장해놓은 arr[left]값 할당
    }

}
