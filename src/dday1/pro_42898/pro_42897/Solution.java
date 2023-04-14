package dday1.pro_42898.pro_42897;

// 6: 25
class Solution {
 
    public int solution(int[] money) {
        
        int len = money.length;
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
                
        dp1[0] = dp1[1] = money[0];
        dp2[1] = money[1]; // (만약 3개이더라도, 0번x, 3번만) 혹은 2번만 선택
        
        
        for (int i = 2; i < len; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + money[i]);
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + money[i]);
        }
        
        return Math.max(dp1[len - 2], dp2[len - 1]);
    }
}