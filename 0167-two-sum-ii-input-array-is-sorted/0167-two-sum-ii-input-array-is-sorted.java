class Solution {
    public int[] twoSum(int[] num, int target) {
        int op[] = new int[2];
        int n = num.length;
        int i=0,j=n-1;
        while(i<j)
        {
            int sum=num[i]+num[j];
            if(sum == target)
            {
                op[0] = i+1;
                op[1] = j+1;
                break;
            }
            else if(sum<target) i++;
            else j--;
        }
        return op;
    }
}