class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean matchA=false,matchB=false,matchC=false;
        for(int triplet[] : triplets)
        {
            if(triplet[0]>target[0] || triplet[1]>target[1] || triplet[2]>target[2]) continue;
            if(triplet[0]==target[0]) matchA=true;
            if(triplet[1]==target[1]) matchB = true;
            if(triplet[2] == target[2]) matchC = true;
            if(matchA && matchB && matchC) return true;
        }
        return (matchA && matchB && matchC);
    }
}