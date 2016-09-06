/*
第二题幸运数： 

时间限制：C/C++语言 1000MS；其他语言 3000MS
 内存限制：C/C++语言 65536KB；其他语言 589824KB 

题目描述： 

4和7是两个幸运数字，我们定义，十进制表示中，每一位只有4和7两个数的正整数都是幸运数字。前几个幸运数字是：4,7,44,47,74,77,444,447… 

现在输入一个数字k，输出第k个幸运数
 输入输出我忘了。
 样例输入
 3
 5
 100
 10000000
 样例输出
 74
 744747
 44774447447477474444447 
 */
 
import java.util.*;
import java.math.*;
public class LuckyNumber {
  public StringBuilder find(int num) {
    int sum = 0;
    int count = 1;
    int countM = 0;
    while (sum < num) {
      count *= 2;
      countM++;
      sum += count;
    }
    int index = num - (sum - count) - 1;
    int[] a = new int[countM];
    while (index >= 1) {
      int temp = (int)(Math.log(index) / Math.log(2));
      a[temp] = 1;
      int power = 1;
      for (int i = 0; i < temp; i++) {
        power *= 2;
      }
      index -= power;
    }
    StringBuilder sb = new StringBuilder("");
    for (int i = countM - 1; i >= 0; i--) {
      if (a[i] == 1) {
        sb.append("7");
      } else {
        sb.append("4");
      }
    }
    return sb;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
    int n = sc.nextInt();
    LuckyNumber ln = new LuckyNumber();
    System.out.println(ln.find(n));
    }
  }
}