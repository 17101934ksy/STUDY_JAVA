package dday3.boj_1644;

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<Integer> prime = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        getPrime(n);

        int left = 0, right = 0;
        int ans = 0;
        int sum = 2;
        int size = prime.size();

        while (left < size && right < size) {
            if (sum == n) {
                ans++;
                sum -= prime.get(left++);
            }
            else if (sum > n) {
                sum -= prime.get(left++);
            }
            else {
                if (++right >= size) break;
                sum += prime.get(right);
            }
        }
        System.out.println(ans);
    }

    private static void getPrime(int n) {
        int[] arr = new int[n + 1];
        int root = (int) Math.sqrt(n);
        for (int i = 2; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= root; i++) {
            if (arr[i] != 0) {
                for (int j = i * 2; j <= n; j += i) {
                    arr[j] = 0;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (arr[i] != 0) {
                prime.add(arr[i]);
            }
        }
    }
}