package xyz.funfan.algorithm.dp;

/**
 * 动态规划
 *
 * A * "1+1+1+1+1+1+1+1 =？" *
 *
 * A : "上面等式的值是多少"
 * B : *计算* "8!"
 *
 * A *在上面等式的左边写上 "1+" *
 * A : "此时等式的值为多少"
 * B : *quickly* "9!"
 * A : "你怎么这么快就知道答案了"
 * A : "只要在8的基础上加1就行了"
 * A : "所以你不用重新计算因为你记住了第一个等式的值为8!
 * 动态规划算法也可以说是 '记住求过的解来节省时间'"
 *
 * 解题框架：
 * {@code
  # 初始化 base case
  dp[0][0][...] = base
  # 进行状态转移
  for 状态1 in 状态1的所有取值：
      for 状态2 in 状态2的所有取值：
          for ...
              dp[状态1][状态2][...] = 求最值(选择1，选择2...)
  }
 */
public class DynamicProgram {

    /*
    斐波拉契数列
    递归版
     */
    public static int fib1(int n) {
        if (n < 1) return 0;
        if (n == 1 || n == 2) {
            System.out.print("1 ");
            return 1;
        }
        int result = fib1(n - 1) + fib1(n - 2);
        System.out.print(result + " ");
        return result;
    }

    /*
    斐波拉契数列
    递归+备忘录版 （自顶向下）
     */

    /*
    斐波拉契数列
    递归+动态规划版 （自底向上）
     */
    public static void main(String[] args) {
        int n = 7;
        System.out.println("\n斐波拉契数列第位" + n + "为: " + fib1(n));
    }
}



