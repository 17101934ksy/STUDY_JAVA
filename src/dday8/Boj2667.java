package dday8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Boj2667 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Villa villa = new Villa(n);
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            villa.init(i, str); // villa 초기화
        }
        
        List<Integer> villas = villa.calculateTotalVilla();
        Collections.sort(villas); // villa 정렬

        System.out.println(villas.size()); // 다른 단지 수 출력
        
        StringBuilder sb = new StringBuilder();
        for (Integer v : villas) {
            sb.append(v).append('\n');
        }
        
        System.out.println(sb); // 단지의 하우스 출력
    }    
}

class Villa {
    
    static int count; // static으로 단지 개수 출력
    
    static final int[] D_X = {-1, 0, 1, 0}; // 왼 - 오 좌표
    static final int[] D_Y = {0, 1, 0, -1}; // 상 - 아 좌표
    
    house[][] houses; // 하우스 이차원 배열
    List<Integer> counts = new ArrayList<>(); // count를 담을 list
    
    class house {
        int num; // 하우스 1 or 0
        boolean visited; // 방문 여부
        
        house(int num) {
            this.num = num;
        }
    }
    
    Villa(int n) {
        houses = new house[n][n];
    } // 생성자
    
    void init(int idx, String str) {
        for (int i = 0; i < houses.length; i++) {
            houses[idx][i] = new house(Character.getNumericValue(str.charAt(i))); // 초기화
        }
    }
    
    List<Integer> calculateTotalVilla() { // 총 빌라 수 구하기
        for (int i = 0; i < houses.length; i++) {
            for (int j = 0; j < houses[0].length; j++) {

                // 한번도 방문하지 않으면서 num이 1인 하우스 dfs
                if (!houses[i][j].visited && houses[i][j].num == 1) {
                    count = 0;
                    dfs(i, j);
                    counts.add(count);
                }
            }
        }
        return counts;
    }

    private void dfs(int x, int y) {
        if ((!houses[x][y].visited) && (houses[x][y].num == 1)) {
            houses[x][y].visited = true; // 방문한 곳 true 처리
            ++count;
            for (int k = 0; k < 4; k++) {
                int newX = D_X[k] + x; // 앞 서 정의한 x 좌표
                int newY = D_Y[k] + y; // 앞 서 정의한 y 좌표
                if (validRange(newX, newY)) dfs(newX, newY); // dfs 재귀
            }
        }
     }

     // house의 배열에 유효한 인덱스인지 판단
    private boolean validRange(int x, int y) {
        return (x >= 0) && (y >= 0) && (x < houses.length) && (y < houses.length);
    }
}
