package xyz.funfan.algorithm.string;

/**
 * 字符串查找，模式匹配
 *
 * 暴力算法 O（M*N）
 * KMP（M+N）
 */
public class KMP {

    /**
     * 暴力求解，双指针
     * @param s 文本串
     * @param p 模式串
     * @return
     */
    public static int simpleSearch(char[] s, char[] p){
        int i = 0; // 文本传指针
        int j = 0; // 模式串指针
        int result = -1;
        int count = 0;

        while (i < s.length && j < p.length) {
            count++;
            if (s[i+j] == p[j]) {
                j++;
                result = i;
            } else {
                i ++;
                j = 0;
                result = -1;
            }
        }
        System.out.println("Found pattern in:" + result + "; loop: " + count);
        return result;
    }

    public static int simpleSearchWrong(char[] s, char[] p){
        int i = 0; // 文本传指针
        int j = 0; // 模式串指针
        int result = -1;
        int count = 0;

        while (i < s.length && j < p.length) {
            count++;
            if (s[i] == p[j]) {
                i++; // 比较是，不能移动文本指针，否则指针可能跳过部分匹配的字符
                // e.g. vabaaaaaaababababa 匹配 aaaaab
                j++;
                result = i - j;
            } else {
                i ++;
                j = 0;
                result = -1;
            }
        }
        System.out.println("Found pattern in: " + result + "; loop: " + count);
        return result;
    }

    /**
     * KMP 减少回溯步数
     * @param args
     */

    public static void main(String[] args) {
        char[] s = "aTYIdn abcdefwgfvabaaaaaaabababababhjaoiiu".toCharArray();
        char[] p = "aaaaab".toCharArray();
        int result = simpleSearch(s,p);
        result = simpleSearchWrong(s, p);
    }
}
