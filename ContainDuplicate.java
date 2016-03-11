/*
Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, 
and it should return false if every element is distinct.
*/

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0) return false;
        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
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