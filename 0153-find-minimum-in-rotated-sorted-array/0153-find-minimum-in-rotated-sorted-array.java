class Solution {
    public int findMin(int[] arr) {
        int start=0,end=arr.length-1,mid;
        if (arr[start] <= arr[end]) return arr[start];
        while(start<=end)
        {
            mid = start + (end-start)/2;
            if(mid > 0 && arr[mid]<arr[mid-1]) return arr[mid];
            if(mid < arr.length-1 && arr[mid+1]<arr[mid]) return arr[mid+1];
            if(arr[mid]>arr[start]) start = mid+1;
            else end = mid-1; 
        }
        return -1;
    }
}