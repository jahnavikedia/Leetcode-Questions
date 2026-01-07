class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t): return False
        mp = {}
        for c in s:
            mp[c] = mp.get(c,0)+1
        for c in t:
            if c not in mp or mp[c] == 0: return False
            mp[c] = mp[c] - 1
        return True