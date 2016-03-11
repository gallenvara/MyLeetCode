/*Given an array of size n, find the majority element. The majority element is 
the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/

public class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                count++;
                if (count > nums.length / 2) return nums[i];
            } else {
                count = 1;
            }
        }
        return nums[0];
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