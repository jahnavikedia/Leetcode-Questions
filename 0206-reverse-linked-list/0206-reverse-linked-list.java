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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p = null;
        ListNode q = head;
        ListNode r= q.next;
        while(r!=null)
        {
            q.next = p;
            p=q;
            q= r;
            r = r.next;
        }
        q.next=p;
        head.next = null;
        return q;
    }
}