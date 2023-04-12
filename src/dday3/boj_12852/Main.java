package dday3.boj_12852;// 8:30
import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Calculation cal = new Calculation(n);
        cal.find();

        br.close();
    }   
}

class Calculation {
    int[] dp;
    int[] trace;
    
    Calculation(int n) {
        dp = new int[n + 2];
        trace = new int[n + 2];
    }
        
    void find() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dp[1] = 0;
        trace[1] = -1;
        
        for (int i = 2; i <= dp.length - 2; i++) {
            dp[i] = dp[i - 1] + 1;
            trace[i] = i - 1;
            
            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                trace[i] = i / 2;
            }
            
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                trace[i] = i / 3;
            }
        }
        
        int num = dp[dp.length - 2];
        bw.write(num + "\n");
        
        int idx = dp.length - 2;
        for (int i = 0; i <= num; i++) {
            bw.write(idx + " ");
            idx = trace[idx];
        }
        
        bw.flush();
        bw.close();
    }
    
}

// [0, 0]
// [2, 1] / 2 or -1
// [2, 2, 1]