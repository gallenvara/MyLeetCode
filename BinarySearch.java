public int binary_search(int[] a, int len, int goal)
{
    int low = 0;
    int high = len -1;
    while (low <= high)
    {
        int middle = (high - low) / 2 + low; // 直接使用(high + low) / 2 可能导致溢出
        if (a[middle] == goal)
            return middle;
        //在左半边
        else if (a[middle] > goal)
            high = middle - 1;
        //在右半边
        else
            low = middle + 1;
    }
    //没找到
    return -1;
}