/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node p= head;
        while(p!=null)
        {
            Node curr = new Node(p.val);
            curr.next = p.next;
            p.next = curr;
            p = curr.next;
        }
        p=head;
        while(p!=null)
        {
            if(p.random!=null) p.next.random = p.random.next;
            p=p.next.next;
        }
        Node dummy = new Node(-1);
        p=head;
        Node q = dummy;
        while(p!=null)
        {
            q.next = p.next;
            p.next = q.next.next;
            p = p.next;
            q=q.next;
        }
        return dummy.next;
    }
}