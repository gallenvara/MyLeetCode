/*
题目描述

给定K个整数的序列{ N1, N2, ..., NK }，其任意连续子序列可表示为{ Ni, Ni+1, ..., 
Nj }，其中 1 <= i <= j <= K。最大连续子序列是所有连续子序列中元素和最大的一个， 
例如给定序列{ -2, 11, -4, 13, -5, -2 }，其最大连续子序列为{ 11, -4, 13 }，最大和 
为20。 
在今年的数据结构考卷中，要求编写程序得到最大和，现在增加一个要求，即还需要输出该 
子序列的第一个和最后一个元素。 

输入描述:
测试输入包含若干测试用例，每个测试用例占2行，第1行给出正整数K( < 10000 )，第2行给出K个整数，中间用空格分隔。当K为0时，输入结束，该用例不被处理。

输出描述:
对每个测试用例，在1行里输出最大和、最大连续子序列的第一个和最后一个元 
       
素，中间用空格分隔。如果最大连续子序列不唯一，则输出序号i和j最小的那个（如输入样例的第2、3组）。
若所有K个元素都是负数，则定义其最大和为0，输出整个序列的首尾元素。     

输入例子:
6
-2 11 -4 13 -5 -2
10
-10 1 2 3 4 -5 -23 3 7 -21
6
5 -8 3 2 5 0
1
10
3
-1 -5 -2
3
-1 0 -2
0

输出例子:
20 11 13
10 1 4
10 3 5
10 10 10
0 -1 -2
0 0 0 
*/

import java.util.Scanner;
public class HDU1231 {
  public Position findMax(int[] a) {
    int len = a.length;
    Position[] p = new Position[len];
    p[0] = new Position(0, 0, a[0]);
    for (int i = 1; i < len; i++) {
      if (a[i] > p[i - 1].sum + a[i]) {
        p[i] = new Position(i, i, a[i]);
      } else {
        p[i] = new Position(p[i - 1].start, i, p[i - 1].sum + a[i]);
      }
    }
    int max = p[0].sum;
    int index = 0;
    for (int i = 1; i < len; i++) {
      if (max < p[i].sum) {
        max = p[i].sum;
        index = i;
      }
    }
    return p[index];
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
    int n = sc.nextInt();
    if (n == 0) {
      break;
    } else {
      int[] a = new int[n];
      boolean boo = true;
      for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
        if (a[i] >= 0) {
          boo = false;
        }
      }
      if (boo) {
        System.out.println(0 + " " + a[0] + " " + a[n - 1]);
      } else {
      HDU1231 hdu = new HDU1231();
      Position position = hdu.findMax(a);
      System.out.println(position.sum + " " + a[position.start] + " " + a[position.end]);
      }
      }
    }
  }
}
class Position {
  int start;
  int end;
  int sum;
  public Position(int s, int e, int sum) {
    this.start = s;
    this.end = e;
    this.sum = sum;
  }
}