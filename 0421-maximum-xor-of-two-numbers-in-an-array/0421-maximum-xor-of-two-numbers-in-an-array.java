class Solution {
    static class TrieNode
    {
        TrieNode children[] = new TrieNode[2];
    }
    private void insert(TrieNode root, int num)
    {
        TrieNode node = root;
        for(int i=31;i>=0;i--)
        {
            int bit = (num>>i)&1;
            if(node.children[bit]==null)
            {
                node.children[bit] = new TrieNode();
            }
            node = node.children[bit];
        }
    }
    private int findMax(TrieNode root, int num)
    {
        TrieNode node = root;
        int max = 0;
        for(int i=31;i>=0;i--)
        {
            int bit = (num>>i)&1;
            int oppBit = 1-bit;
            if(node.children[oppBit]!=null) 
            {
                max = max | (1<<i);
                node = node.children[oppBit];
            }
            else node = node.children[bit];
        }
        return max;
    }
    public int findMaximumXOR(int[] nums) {
        TrieNode node = new TrieNode();
        for(int num : nums) insert(node, num);
        int maxXor = 0;
        for(int num : nums)
        {
            maxXor = Math.max(maxXor, findMax(node, num));
        }
        return maxXor;
    }
}