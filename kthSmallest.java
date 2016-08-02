/*
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element. 

Example: 
matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.

Note: 
 You may assume k is always valid, 1 ≤ k ≤ n2.
*/

public class Solution {
    public class Point {
        int val;
        int x;
        int y;
        public Point(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    @Override
    public boolean equals(Object others) {
        Point other = (Point) others;
        return (this.val == other.val && this.x == other.x && this.y == other.y);
    }
    @Override
    public int hashCode() {
        return 1;
    }
    }
    public int kthSmallest(int[][] matrix, int k) {
        int[][] flag = new int[matrix.length][matrix.length];
        if(matrix.length == 0) return 0;
        PriorityQueue<Point> pq = new PriorityQueue<Point>(new Comparator<Point>(){
           @Override
           public int compare(Point a, Point b) {
               return a.val - b.val;
           }
        });
        pq.offer(new Point(matrix[0][0], 0, 0));
        for(int i = 1; i < k; i++) {
            Point p = pq.poll();
            flag[p.x][p.y] = 1;
            if (p.x+1 < matrix.length && flag[p.x+1][p.y] == 0) {
                Point down = new Point(matrix[p.x+1][p.y], p.x+1, p.y);
                if (!pq.contains(down)) {
                    pq.offer(down);
                }
            }
            if (p.y+1 < matrix.length && flag[p.x][p.y+1] == 0) {
                Point right = new Point(matrix[p.x][p.y+1], p.x, p.y+1);
                if (!pq.contains(right)) {
                    pq.offer(right);
                }
            }
        }
        return pq.poll().val;
    }
}