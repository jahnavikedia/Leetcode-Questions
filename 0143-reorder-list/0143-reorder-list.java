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
    public void reorderList(ListNode head) {
        ListNode middle = findMiddle(head);
        ListNode middleNext = middle.next;
        middle.next=null;
        ListNode newNodeHead = reverse(middleNext);
        ListNode p = head;
        ListNode q = newNodeHead;
        while(q!=null)
        {
            ListNode r = q.next;
            q.next = p.next;
            p.next=q;
            p = q.next;
            q = r;
        }
        return;
    }
    public ListNode findMiddle(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head)
    {
        ListNode p = null, q = head, r=null;
        while(q!=null)
        {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        return p;
    }



}