package dday3.boj_3273;

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        
        Pointer pointer = new Pointer(n);
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            pointer.addPoint(i, getInt(st));
        }
        
        pointer.setSatisfiedNum(parseInt(br.readLine()));
        System.out.println(pointer.find());
    }
    
    private static int getInt(StringTokenizer st) {
        return parseInt(st.nextToken());
    }
}

class Pointer {
    
    long[] points;
    int x;
    
    Pointer(int n) {
        points = new long[n];
    }
    
    void addPoint(int i, int j) {
        points[i] = j;
    }
    
    void setSatisfiedNum(int x) {
        this.x = x;
    }
    
    int find() {
        Arrays.sort(points);
        
        int result = 0;
        
        for (int i = 0; i < points.length; i++) {
            if (points[i] > x) break;
            for (int j = i + 1; j < points.length; j++) {

                if (points[i] + points[j] > x) break;
                
                if (points[i] + points[j] == x) {
                    result++;
                }
            }
        }
        return result;
    } 
}