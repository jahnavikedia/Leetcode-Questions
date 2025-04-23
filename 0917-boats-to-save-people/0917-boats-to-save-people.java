class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int i=0,j=n-1;
        int count=0;
        while(i<=j && i>=0 && j>=0 && i<n && j<n)
        {
            if(people[i]==limit)
            {
                count++;
                i++;
            }
            if(people[j]==limit)
            {
                count++;
                j--;
                continue;
            }
            if(i==j)
            {
                count++;
                break;
            }
            if(people[i]+people[j]<=limit)
            {
                count++;
                i++;
                j--;
            }
            else if(people[i]+people[j]>limit)
            {
                count++;
                j--;
            }
            
        }
        return count;
    }
}