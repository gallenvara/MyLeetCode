/*
There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.

Example:

Given n = 3. 

At first, the three bulbs are [off, off, off].
After first round, the three bulbs are [on, on, on].
After second round, the three bulbs are [on, off, on].
After third round, the three bulbs are [on, off, off]. 

So you should return 1, because there is only one bulb is on.
*/

/*
f[i]代表第i次操作后灭灯的数量，则有：
f[1] = 0;
f[i] = f[i - 1] + 1 , i 有偶数个因子；
                  0 , i 有奇数个因子；
那么问题变成了求1~n之间因子数为奇数的数的个数，而满足这样要求的数只有完全平方数，即1, 4, 9, 16...., 所以不大于n的个数为n的开方.
*/

public class Solution {
    public int bulbSwitch(int n) {
       return (int) Math.sqrt(n);
    }
}