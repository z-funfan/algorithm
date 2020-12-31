package xyz.funfan.algorithm.search;

import java.util.Arrays;

public class MaxSubArray {
    /*
     最大连续子数组
     给定数组 A，求A的连续子数组，是的改子数组的和最大
     e.g.
     [1, -2, 3, 10,-4,7,2,-5]
     最大连续子数组是 [3.10.-4.7.2]
     */
    private static int[] A1 = {1, -2, 3, 10,-4,7,2,-5};
    private static int[] A2 = {3,4,7,8,9,0,0,-3,2,5,7,4,5,-3,2,3,4,7,8};
    private static int cnt = 0;

    // 暴力法O(n^3)
    public static int[] simpleMaxSeq(int[] input) {
        int maxSum = 0;
        int start=0;
        int end = 0;
        int count = 0;

        for (int i = 0; i < input.length; i++) {
            for (int j = i; j < input.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += input[k];
                    count ++;
                    System.out.println(String.format("%d: 遍历[%d]至[%d], 求和[%d]",count, i,k, sum ));
                }
                if (sum >= maxSum) {
                    maxSum = sum;
                    start = i;
                    end = j;
                }
            }
        }
        int[] result =  Arrays.copyOfRange(input, start, end + 1);
        System.out.println("最大连续子数组: " + Arrays.toString(result) + "遍历次数：" + count);
        return result;
    }

    // 分治 O(nlgn)
    public static int[] divideConquerMaxSeq(int[] input) {
        cnt = 0;
        if (input.length <= 0){
            return input;
        }

        Object[] r = divideConquerMaxSeqHelper(input, 0, input.length - 1);
        int[] result = (int[]) r[1];
        System.out.println("最大连续子数组: " + Arrays.toString(result)+ "遍历次数：" + cnt);
        cnt = 0;
        return result;
    }

    public static Object[] divideConquerMaxSeqHelper(int[] input, int from, int to) {
        if (from >= to) {
            Object[] result = new Object[]{input[from], Arrays.copyOfRange(input, from, from + 1)};

            cnt++;
            System.out.println(String.format("%d: 递归至节点[%d], 值为[%d]",cnt, from, input[from] ));

            return result;
        }
        int middle = from + (to - from )/2;
        int m_max_sum = input[middle];
        cnt++;
        System.out.println(String.format("%d: 查找中值至[%d], 值为[%d]",cnt, middle, m_max_sum ));

        Object[] left = divideConquerMaxSeqHelper(input, from, middle - 1);
        Object[] right = divideConquerMaxSeqHelper(input, middle + 1, to);


        int m_l_sum = m_max_sum;
        int m_l = middle;
        int m_r = middle;
        for (int i = middle-1; i >= from ; i--) {
            m_l_sum += input[i];
            if (m_max_sum <= m_l_sum) {
                m_max_sum = m_l_sum;
                m_l = i;
            }
            cnt ++;
            System.out.println(String.format("%d: 遍历左边[%d]至[%d], 求和[%d]",cnt, i,middle, m_l_sum ));

        }

        m_l_sum = m_max_sum;
        for (int i = middle + 1; i <= to ; i++) {
            m_l_sum += input[i];
            if (m_max_sum <= m_l_sum) {
                m_max_sum = m_l_sum;
                m_r = i;
            }
            cnt++;
            System.out.println(String.format("%d: 遍历右边[%d]至[%d], 求和[%d]",cnt, m_l,i, m_l_sum ));

        }

        if (m_max_sum >= (int) left[0] && m_max_sum >= (int) right[0]) {
            int[] result = Arrays.copyOfRange(input, m_l, m_r + 1);
            return new Object[]{m_max_sum, result};
        } else if ((int) left[0]  >  (int) right[0]) {
            return left;
        } else {
            return right;
        }
    }

    // 分析
    /*
    假设：
    - p[n] = a[0] + a[1] + a[2] + ... + a[n]
    - p[-1] = 0
    则子数组和 s[i.j]:
    s[i.j] = a[i] + ... + a[j]
        =  (a[0] + a[1] + ... + a[j] ) - (a[0] + a[1]+ ... + a[i-1])
        = p[j] - p[i-1]
    则：S[j] = s_max[i,j] = p_max[j] - p_min[i-1]
    S[j+1] = max((S[j] + a[j+1]), a[j+1])
     */
    public static int[] enhancedConquerMaxSeq(int[] input) {
        int max_sum = input[0];
        int current_sum = input[0];
        int previous_sum = 0;

        int left = 0;
        int right = 0;
        cnt = 1;
        System.out.println(String.format("%d: 遍历[%d]至[%d], 最大和[%d]",cnt, left,right, max_sum ));

        for (int i = 1; i < input.length; i++) {
            if (input[i] > previous_sum + input[i] ) {
                current_sum = input[i];
                left = i;
            } else {
                current_sum = previous_sum + input[i];
            }

            if (current_sum > max_sum) {
                max_sum = current_sum;
                right = i;
            }

            cnt++;
            System.out.println(String.format("%d: 遍历[%d]至[%d], 最大和[%d]",cnt, left,right, max_sum ));
            previous_sum = current_sum;
        }
        int[] result = Arrays.copyOfRange(input, left, right + 1);
        System.out.println("最大连续子数组: " + Arrays.toString(result)+ "遍历次数：" + cnt);
        return result;
    }

    // 动态规划

    public static void main(String[] args) {
        simpleMaxSeq(A1); // 最大连续子数组: [3, 10, -4, 7, 2]遍历次数：84
//        simpleMaxSeq(A2); // 最大连续子数组: [3, 4, 7, 8, 9, 0, 0, -3, 2, 5, 7, 4, 5, -3, 2, 3, 4, 7]遍历次数：1140
//
//        divideConquerMaxSeq(A1);
//        divideConquerMaxSeq(A2);

        enhancedConquerMaxSeq(A1);
//        enhancedConquerMaxSeq(A2);


    }

}
