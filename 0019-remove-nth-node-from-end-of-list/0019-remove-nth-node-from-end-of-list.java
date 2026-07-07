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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        if(head.next == null) return null;
        ListNode curr = head;
        ListNode trav = head;
        ListNode prev = null;
        int len = 0;
        while(trav!=null){
            len++;
            trav = trav.next;
        }
        if (len == n)
            return head.next;
        System.out.print(len);
        for(int i = 0 ; i< len - n ; i++){
            prev = curr;
            curr = curr.next;
        }
        if(prev.next!=null) prev.next = curr.next;
        return head;
    }
}