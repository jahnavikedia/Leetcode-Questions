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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode p = list1;
        ListNode q = list2;
        ListNode dummy = new ListNode(-1,null);
        ListNode curr = dummy;
        while(p!=null && q!=null)
        {
            if(p.val<=q.val)
            {
                curr.next = p;
                curr = p;
                p=p.next;
            }
            else
            {
                curr.next = q;
                curr = q;
                q=q.next;
            }
        }
        if(p!=null)
        {
            curr.next = p;
        }
        else curr.next = q;
        return dummy.next;
    }
}