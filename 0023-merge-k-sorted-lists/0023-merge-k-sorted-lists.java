/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a->a.val));
        for(ListNode node : lists){
            if(node!=null) minHeap.offer(node);
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!minHeap.isEmpty())
        {
            ListNode min = minHeap.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next!=null) minHeap.offer(min.next);
        }
        return dummy.next;
    }
}