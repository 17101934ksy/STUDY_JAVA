package knapsack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Test {


    public static void main(String[] args) {


        ArrayList<Integer>[] list = new ArrayList[10];

        list[0] = new ArrayList<>();
        list[0].add(3);
        list[0].add(5);

        Integer remove = list[0].remove(0);
        System.out.println("remove = " + remove);


//
//        Integer remove = list[0].remove(list[0].size());
//        System.out.println("remove = " + remove);


    }


}
