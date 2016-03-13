/*
Given an array of integers, every element appears twice except for one. Find that single one.
*/

public class Solution {
    public static int table_size = 10000;
    //复杂度 n + (n / table_size) * log (n / table_size);
    public int singleNumber(int[] nums) {
        int[] hash = new int[table_size];
        int[] b = new int[10000];
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            while (temp < 0) {
                temp += table_size;
            }
            hash[temp % table_size]++;
        }
        int find = 0;
        int index = 0;
        for (int i = 0; i < table_size; i++) {
            if (hash[i] % 2 == 1) find = i;
        }
        
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            while (temp < 0) {
                temp += table_size;
            }
            if (temp % table_size == find) {
                b[index++] = nums[i];
            }
        }
        if (index == 1) return b[0];
        quickSort(b, 0, index - 1);
        if (b[0] != b[1]) return b[0];
        if (b[index - 1] != b[index - 2]) return b[index - 1];
        for (int i = 1; i < index - 1; i++) {
            if (((b[i] != b[i - 1])&&(b[i] != b[i + 1]))) {
                return b[i];
            }
        }
        return 0;
    }
     private void quickSort(int[] array, int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        int pivot = array[(lowerIndex + higherIndex) >> 1];
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(array, i, j);                
                i++;
                j--;
            }
        }
        if (lowerIndex < j)
            quickSort(array, lowerIndex, j);
        if (i < higherIndex)
            quickSort(array, i, higherIndex);
    }
 
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
