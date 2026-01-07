class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        mp ={}
        for s in strs:
            key = "".join(sorted(s))
            mp.setdefault(key,[]).append(s)
        return list(mp.values())