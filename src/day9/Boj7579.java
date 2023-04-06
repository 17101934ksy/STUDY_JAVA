package day9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Boj7579 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String boom = br.readLine();

        Stack<Character> stack = new Stack<>();

        // stack 값 입력
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            // 만약 stack에 boom 보다 길이가 길어진다면
            if (stack.size() >= boom.length()) {
                boolean flag = true; // true가 유지된다면 pop

                for (int j = 0; j < boom.length(); j++) {
                    // stack에서 boom의 길이를 빼고 인덱스 크기에 위치한 값이 boom 문자열과 같은지 판단
                    if (stack.get(stack.size() - boom.length() + j) != boom.charAt(j)) {
                        flag = false;
                        break;
                    }
                }

                // 길이만큼 pop 실행
                if (flag) {
                    for (int j = 0; j < boom.length(); j++) stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}