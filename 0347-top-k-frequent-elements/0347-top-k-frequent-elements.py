import heapq
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = {}
        for num in nums:
            freq[num] = freq.get(num,0)+1
        heap = []
        for num in freq:
            heapq.heappush(heap,(freq[num],num))
            if len(heap)>k:
                heapq.heappop(heap)
        res = []
        for f,num in heap:
            res.append(num)
        return res