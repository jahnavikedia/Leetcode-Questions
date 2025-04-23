class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int i=0,j=n-1;
        int count=0;
        while(i<=j && i>=0 && j>=0 && i<n && j<n)
        {
            if(people[i]+people[j]<=limit)
            {
                i++;
            }
            j--;
            count++;
            
            
        }
        return count;
    }
}