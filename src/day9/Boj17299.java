package day9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;
import java.util.HashMap;

import static java.lang.Integer.parseInt;

public class Boj17299 {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = parseInt(br.readLine());
        arr = new int[n];

        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = parseInt(st.nextToken());

            if (map.get(arr[i]) == null) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }

        // 이미 map에 전부 값을 넣었으므로 null 존재 x
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && map.get(arr[stack.peek()]) < map.get(arr[i])) {
                arr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }
}
