class Solution {
    public int candy(int[] ratings) {
        int sum=1,i=1,n=ratings.length;
        while(i<n)
        {
            if(ratings[i]==ratings[i-1])
            {
                sum=sum+1;
                i++;
                continue;
            }
            int peak=1;
            while(i<n && ratings[i]>ratings[i-1])
            {
                peak++;
                sum=sum+peak;
                i++;
            }
            int down=0;
            while(i<n && ratings[i]<ratings[i-1])
            {
                down++;
                sum=sum+down;
                i++;
            }
            down++;
            if(down>peak) sum = sum + (down-peak);
        }
        return sum;
    }
}