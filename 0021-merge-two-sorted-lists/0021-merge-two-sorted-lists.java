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
        if(list1==null)return list2;
        if(list2==null)return list1;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode p=list1,q=list2;
        while(p!=null && q!=null)
        {
            if(p.val<=q.val)
            {
                curr.next = p;
                curr=p;
                p=curr.next;
            }
            else
            {
                curr.next=q;
                curr=q;
                q=q.next;
            }
        }
        if(p==null)curr.next=q;
        else curr.next=p;
        return dummy.next;
    }
}