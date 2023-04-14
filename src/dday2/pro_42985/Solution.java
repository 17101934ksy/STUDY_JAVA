package dday2.pro_42985;

import java.util.*;

class Solution {
    
    int answer;
    
    public int solution(int N, int number) {
        
        answer = -1;
        
        dfs(N, number, 0, 0);
        
        return answer;
    }
    
    
    private void dfs(int n, int number, int sum, int count) {
        
        if (count > 8) return ;
        
        if (sum == number) {
            if (count < answer || answer == -1) answer = count;
            return;
        }
        
        int t = 0;
        for (int i = 1; i < 9; i++) {
            t = t * 10 + n;
            dfs(n, number, sum + t, count + i);
            dfs(n, number, sum - t, count + i);
            dfs(n, number, sum * t, count + i);
            dfs(n, number, sum / t, count + i);
        }
        
    }
    
}