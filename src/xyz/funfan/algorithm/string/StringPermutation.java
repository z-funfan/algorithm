package xyz.funfan.algorithm.string;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QDecoderStream;

import java.util.Arrays;

/**
 * 字符串全排列
 */
public class StringPermutation {
    public static void swap(char[] s, int source, int dest) {
        char t = s[source];
        s[source] = s[dest];
        s[dest] = t;
    }

    /**
     * 递归算法
     *
     */
    public static void permutation(char[] s, int from, int to) {
        if (from == to) { // 只剩一个元素，打印数组
            System.out.println(Arrays.toString(s));
            return;
        }
        for (int i = from; i < to + 1; i++) { // 固定
            swap(s, from , i);
            permutation(s, from + 1, to);
            swap(s, from , i);
        }
    }


    public static void main(String[] args) {
        char[] s = {'a', 'b','c','d'};
        permutation(s, 0, s.length - 1);
    }
}
