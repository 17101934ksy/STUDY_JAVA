package dp1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s1 = bf.readLine();
        String s2 = bf.readLine();

        int result = calculateLCS(s1, s2);
        System.out.print(result);
    }

    private static int calculateLCS(String s1, String s2) {
        int[][] dpArr = new int[s1.length()][s2.length()];
        int result = 0;

        for (int j = 0; j < s2.length(); j++) {
            if (s1.charAt(0) == s2.charAt(j)) {
                dpArr[0][j] += 1;
            }
        }

        for (int i = 1; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {

                if (s1.charAt(i) == s2.charAt(j)) {
                    dpArr[i][j] = Math.max(dpArr[i - 1][j] , dpArr[i][j] + 1);
                }

                result = Math.max(dpArr[i][j], result);
            }
        }

        return result;
    }
}