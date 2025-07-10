class Solution {
    public boolean makesquare(int[] matchsticks) {
        int total=0;
        for(int i: matchsticks) total=total+i;
        if(total%4!=0) return false;
        int sides[] = new int[4];
        int target = total/4;
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        return backtrack(matchsticks, 0, sides, target);
    }
    private boolean backtrack(int matchsticks[], int start, int sides[], int target)
    {
        if(start==matchsticks.length)
        {
            return (target == sides[0] && target == sides[1] && target == sides[2] && target == sides[3]);
        }
        int stick = matchsticks[start];
        for(int i=0;i<4;i++)
        {
            if(sides[i]+stick <=target)
            {
                sides[i] = sides[i]+stick;
                if (backtrack(matchsticks,start+1,sides,target)) return true;
                sides[i] = sides[i]-stick;
            }
            if(sides[i] == 0) break;
        }
        return false;
    }
    private void reverse(int arr[])
    {
        int i=0,j=arr.length-1;
        while(i<=j)
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
        return;
    }
}