class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();
        int minSoFar[][] = new int[m][n];
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0)
                {
                    minSoFar[i][j] = grid.get(i).get(j);
                    continue;
                }
                int minPrev = Integer.MAX_VALUE;
                if(i>0) minPrev = Math.min(minPrev, minSoFar[i-1][j]);
                if(j>0) minPrev = Math.min(minPrev, minSoFar[i][j-1]);
                ans = Math.max(ans, grid.get(i).get(j)-minPrev);
                minSoFar[i][j] = Math.min(minPrev, grid.get(i).get(j));
            }
        }
        return ans;
    }
}