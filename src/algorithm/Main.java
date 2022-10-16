package algorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main{
    static int[][] board;
    static int x, y, k;
    static int num;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = (int) Math.pow(2, parseInt(st.nextToken()));
        board = new int[k + 1][k + 1];

        st = new StringTokenizer(br.readLine());
        x = parseInt(st.nextToken());
        y = parseInt(st.nextToken());

        board[y][x] = -1;

        // 메소드 실행
        divideConquer(1,1, k);

        // 출력
        for(int i=1; i<=k; i++){
            for(int j=1; j<=k; j++){
                System.out.printf(board[i][j]+" ");
            }
            System.out.println();
        }

    }


    public static void divideConquer(int x, int y, int size){

        num ++;
        int ns = size / 2;
        if(boardCheckZero(x, y, ns)) { board[x+ns-1][y+ns-1] = num; }
        if(boardCheckZero(x+ns, y, ns)) { board[x+ns][y+ns-1] = num; }
        if(boardCheckZero(x, y+ns, ns)) { board[x+ns-1][y+ns] = num; }
        if(boardCheckZero(x+ns, y+ns, ns)) { board[x+ns][y+ns] = num; }

        if (size == 2) {return;}


        divideConquer(x, y, ns);
        divideConquer(x+ns, y, ns);
        divideConquer(x, y+ns, ns);
        divideConquer(x+ns,y+ns, ns);

    }

    public static boolean boardCheckZero(int x, int y, int size){

        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){

                if(board[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

}