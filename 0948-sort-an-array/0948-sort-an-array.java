class Solution {
    public int[] sortArray(int[] arr) {
        if(arr==null || arr.length<=1) return arr;
        mergeSort(arr,0,arr.length-1);
        return arr;
    }
    public void mergeSort(int arr[],int start, int end)
    {
        if(start>=end) return;
        int mid = start + (end-start)/2;
        mergeSort(arr,start,mid);
        mergeSort(arr,mid+1,end);
        merge(arr,start, mid, end);
    }
    public void merge(int arr[], int lb, int mid, int ub)
    {
        int b[] = new int[arr.length];
        int i=lb,j=mid+1,k=lb;
        while(i<=mid && j<=ub)
        {
            if(arr[i]<=arr[j]) b[k++] = arr[i++];
            else b[k++] = arr[j++];
        }
        while(i<=mid) b[k++] = arr[i++];
        while(j<=ub) b[k++] = arr[j++];
        for(int x =lb;x<=ub;x++) arr[x] = b[x];
    }
}