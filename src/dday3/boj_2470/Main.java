package dday3.boj_2470;

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        
        Solution solution = new Solution(n);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            solution.addSolution(i, getInt(st));
        }  
        
        solution.find(); 
    }
    
    private static int getInt(StringTokenizer st) {
        return parseInt(st.nextToken());
    }
}

class Solution {
    
    long[] solutions;
    
    Solution (int n) {
        solutions = new long[n];
    }
    
    void addSolution(int i, int j) {
        solutions[i] = j;
    }
    
    void find() {
        Arrays.sort(solutions);

        int lt = 0;
        int rt = solutions.length - 1;
        long res = abs(solutions[lt] + solutions[rt]);

        int left = lt;
        int right = rt;

        while (left < right) {
            long mix = solutions[left] + solutions[right];

            if (abs(mix) < res) {
                lt = left;
                rt = right;
                res = abs(mix);
                if (res == 0) {
                    break;
                }
            }

            if (mix > 0) right -= 1;
            else left += 1;
        }
        System.out.println(solutions[lt] + " " + solutions[rt]);
    }
}
