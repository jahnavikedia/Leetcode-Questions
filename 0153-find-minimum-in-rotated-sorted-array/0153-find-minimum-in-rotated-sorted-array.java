class Solution {
    public int findMin(int[] arr) {
        int n = arr.length;
        int start=0, end = n-1;
        if(arr[start]<=arr[end]) return arr[start];
        while(start<=end)
        {
            int mid = start+(end-start)/2;
            if(mid>0 && arr[mid]<arr[mid-1]) return arr[mid];
            if(mid<n-1 && arr[mid] > arr[mid+1]) return arr[mid+1];
            else if(arr[mid]>arr[start]) start = mid+1;
            else end=mid-1;
        }
        return -1;
    }
}