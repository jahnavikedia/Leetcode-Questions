class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        mp = {}
        for c in s:
            mp[c] = mp.get(c,0)+1
        for c in t:
            if c not in mp : return False
            mp[c] = mp[c] - 1
        for k in mp:
            if mp[k] != 0: return False 
        return True