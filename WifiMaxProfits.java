某司编程题，题目忘了，大意是给n个房间放置m个路由，使得每个房间有信号且收益值最大，每个房间1个或者最多不超过3个房间相连，路由信号只有相邻房间可以接受到。

import java.util.*;
/**
 * Created by gallenvara on 16/10/3.
 */
public class MaxProfits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        int[][] f = new int[n + 1][n + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            f[i][i] = 1;
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            f[x][y] = 1;
            f[y][x] = 1;
            List<Integer> list1 = map.get(x);
            list1.add(y);
            map.put(x, list1);
            List<Integer> list2 = map.get(y);
            list2.add(x);
            map.put(y, list2);
        }
        int maxSum = 0;
        for (int i = 0; i < m; i++) {
            int max = 0;
            int index = 1;
            for (int j = 1; j <= n; j++) {
                List<Integer> list = map.get(j);
                int temp = a[j];
                for (Integer aList : list) {
                    temp += a[aList];
                }
                if (temp > max) {
                    max = temp;
                    index = j;
                }
            }
            for (int k = 1; k <= n; k++) {
                if (f[k][index] == 1 || f[index][k] == 1) {
                    a[k] = 0;
                }
            }
            maxSum += max;
        }
        System.out.println(maxSum);
    }
}
