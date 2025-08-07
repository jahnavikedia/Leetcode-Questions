class Solution {
    public void sortColors(int[] arr) {
       int start =0, mid = 0, end=arr.length-1;
       while(mid<=end)
       {
        switch(arr[mid])
        {
            case 0:
                swap(arr,start,mid);
                start++;
                mid++;
                break;
            case 1:
                mid++;
                break;
            case 2:
                swap(arr,mid,end);
                end--;
                break;
        }
       }
    }
    private void swap(int arr[], int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}