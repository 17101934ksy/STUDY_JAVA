package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main1920 {

  static int N, M;

  static int[] result;

  public static void main(String args[]) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(bf.readLine());
    st = new StringTokenizer(bf.readLine());
    int[] nArr = parseInt(N, st);

    M = Integer.parseInt(bf.readLine());
    st = new StringTokenizer(bf.readLine());
    int[] mArr = parseInt(M, st);

    result = new int[M];

    Arrays.sort(nArr);
    isExists(nArr, mArr);

    for (int i = 0; i < result.length; i++) {
      System.out.println(result[i]);
    }
  }

  private static int[] parseInt(int n, StringTokenizer st) {
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    return arr;
  }

  private static void isExists(int[] nArr, int[] mArr) {

    int right, left, point = 0;

    for (int i = 0; i < M; i++) {

      if ((i >= 1) && result[i-1]==1) {
        left = (nArr.length + point - 1) / 2;
      }

      left = (nArr.length - 1) / 2;
      right  = (nArr.length - 1);

      while (true) {

        if ((right - left) == 1) {
          if ((left == 1 && nArr[0] == mArr[i]) || right == M-1 && nArr[M-1] == mArr[i] ||
                  nArr[left] == mArr[i] || nArr[right] == mArr[i]) {
            result[i] = 1;
            point = left;
          }
          break;
        }

        if (mArr[i] < nArr[left]) {
          right = left;
          left = left / 2;
        } else if (mArr[i] > nArr[left]) {
          left = (right + left) / 2;
        } else {
          result[i] = 1;
          point = left;
          break;
        }
      }
    }
  }
}
