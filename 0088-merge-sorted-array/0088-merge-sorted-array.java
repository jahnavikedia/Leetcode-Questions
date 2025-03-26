class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2==null || n==0) return;
        if(m==0)
        {
            for(int i=0;i<n;i++)
            {
                nums1[i] = nums2[i];
            }
            return;
        }
        int curr = m+n-1;
        m=m-1;
        n=n-1;
        while(m>=0 && n>=0)
        {
            if(nums2[n]>=nums1[m])
            {
                nums1[curr] = nums2[n];
                n--;
                curr--;
            }
            else if(nums1[m]>nums2[n])
            {
                nums1[curr] = nums1[m];
                m--;
                curr--;
            }
        }
        while(m>=0)
        {
            nums1[curr] = nums1[m];
            curr--;
            m--;
        }
        while(n >=0){
            nums1[curr] = nums2[n];
            curr--;
            n--;
        }

    }
}