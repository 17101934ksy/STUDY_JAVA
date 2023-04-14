package dday1.pro_42898.pro_176962;//9: 34
    
import java.util.*;

import static java.lang.Integer.parseInt;

class Solution {
    
    int cnt;
    String[] sub;
    String[] answer;
    int[][] times;
    Stack<Integer> stack = new Stack<>(); // 마치지 못한 과제는 stack에 넣기 (가장 최근에 멈춘 과제)
    
    public String[] solution(String[][] plans) {
        
        answer = new String[plans.length];
        sub = new String[plans.length];
        times = new int[plans.length][2];
        
        Arrays.sort(plans, Comparator.comparing((String[] p) -> p[1])); // 정렬
              
        for (int i = 0; i < plans.length; i++) {
            String[] time = plans[i][1].split(":"); 
            sub[i] = plans[i][0];
            times[i][0] = 60 * parseInt(time[0]) + parseInt(time[1]);
            times[i][1] = parseInt(plans[i][2]); // 소요시간 (남은 시간)
        }

        for (int i = 0; i < plans.length; i++) {
            
            if (i + 1 < plans.length) {
                          
                if (times[i][0] + times[i][1] < times[i + 1][0]) {  // 시작 시간에 소요시간이 다음 시작 시간보다 작은 경우
                    answer[cnt++] = plans[i][0]; // 카운트 증가
                    
                    if (!stack.isEmpty()) doHomework(times[i + 1][0] - (times[i][0] + times[i][1])); // 남은 시간 인자로 넣어주기 
                }
                
                else if (times[i][0] + times[i][1] == times[i + 1][0]) {
                    answer[cnt++] = plans[i][0]; // 카운트만 중가
                }
                
                else {
                    times[i][1] = times[i][0] + times[i][1] - times[i + 1][0];
                    stack.push(i);
                }
            }
            
            if (i == plans.length - 1) {
                answer[cnt++] = plans[i][0];
            }
        }
        
        while(!stack.isEmpty()) {
            answer[cnt++] = plans[stack.pop()][0];
        }
        
        return answer;
    }
    
    // 남은 과제 하기
    private void doHomework(int t) {
        while(t > 0) {        
            int i = stack.pop();       // 최근 과제 꺼내기
            if (times[i][1] - t > 0 ) {
                times[i][1] -= t; // 만약 과제 남은 시간이 t보다 크다면 과제 남은 시간 업데이트
                t = 0;
                stack.push(i); // 스택에 다시 넣기
            }

            else if (times[i][1] == t) {
                times[i][1] = t = 0; // 남은 시간동안 과제 처리해서 스택에 넣지 않기
                answer[cnt++] = sub[i];
            }

            else {
                t -= times[i][1]; // t 업데이트
                times[i][1] = 0; // 남은 시간 없애고 스택에 넣지 않기
                answer[cnt++] = sub[i];
                if (stack.isEmpty()) break;
            }           
        }
    }
    
}