package xyz.funfan.algorithm.string;

import java.util.Arrays;

/*
循环左移
給定一個字符串S[0, ..., n-1] ,将字符串前k位，移动至字符串的尾部
e.g. "abcdef" 循环左移2位“cdefab”

要求：时间复杂度是O(n),空间复杂度数O(1)
 */
public class StringMove {
    /*
    *  (X'Y')'=YX
    * */
    public static char[] leftRotateString(char[]s, int m) {
        int length = s.length;
        m = m % length;

        reverseString(s, 0, m-1);
        System.out.println("X'Y: " + Arrays.toString(s));
        reverseString(s, m, length-1);
        System.out.println("X'Y': "+ Arrays.toString(s));
        reverseString(s, 0, length -1);
        System.out.println("YX: "+ Arrays.toString(s));
        return s;
    }


    public static void reverseString(char[] s , int from, int to) {
        while (from < to) {
            char t = s[from];
            s[from++] = s[to];
            s[to--] = t;
        }
    }

    public static void main(String[] args) {
        char[] s = {'a', 'b', 'c', 'd', 'e', 'f'};
        leftRotateString(s, 2);
        leftRotateString(s, 5);
        leftRotateString(s, 5);
        leftRotateString(s, 10);
        leftRotateString(s, 99);
    }
}
