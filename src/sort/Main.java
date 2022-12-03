package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int inputs = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[inputs];

        for(int i=0; i<inputs; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }


        shellSort(arr);


        for (int i : arr) {
            System.out.println(i);
        }
    }

    static void shellSort(int[] arr) {

        for (int h = arr.length / 2; h > 0; h /= 2) {

            for (int i = h; i < arr.length; i++) {

                int j;
                int temp = arr[i];

                for (j = i - h; j >= 0 && arr[j] > temp; j -= h) {
                    arr[j + h] = arr[j];
                }

                arr[j + h] = temp;
            }
        }

    }
}
