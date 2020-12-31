package xyz.funfan.algorithm.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringSort {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("vbdfzilas");
        list.add("gauipwefhn");
        list.add("auifhs");
        list.add("0-agjkol");

        // ComparableTimSort.sort
        // MIN_MERGE = 32
        Collections.sort(list);
        for (String s : list) {
            System.out.println(s);
        }
    }


}
