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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right || head == null || head.next == null) return head;
        int i=1;
        ListNode dummy = new ListNode(-1,head);
        ListNode prev = dummy;
        while(i<left)
        {
            prev = prev.next;
            i++;
        }
        ListNode p = prev;
        ListNode q = prev.next;
        ListNode r = q.next;
        i=0;
        while(i<=(right-left))
        {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
            i++;
        }
        prev.next.next = r;
        prev.next = p;
        return dummy.next;
    }
}