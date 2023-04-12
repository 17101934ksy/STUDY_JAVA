package dday3.boj_1806;

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = getInt(st);
        int target = getInt(st);
        
        PartialSum sum = new PartialSum(n);
        sum.setTarget(target);
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sum.addNum(i, getInt(st));
        }
        
        sum.find();
    }
    
    private static int getInt(StringTokenizer st) {
        return parseInt(st.nextToken());
    }
}

class PartialSum {
    int[] sum;
    int target;
    
    PartialSum(int n) {
        sum = new int[n + 1];
    }

    void addNum(int i, int n) {
        sum[i] = n;
    }
    
    void setTarget(int target) {
        this.target = target;
    }
    
    void find() {
        int s = 0;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int length = 0;
        while(right <= sum.length - 1) {
            if (s >= target) {
                s -= sum[left++];
                length = right - left + 1;
                if (ans > length) ans = length;
            }

            else if (s < target) {
                s += sum[right++];
            }
        }
        
        if (ans == Integer.MAX_VALUE) System.out.println("0");
        else System.out.println(ans);
    }
}
