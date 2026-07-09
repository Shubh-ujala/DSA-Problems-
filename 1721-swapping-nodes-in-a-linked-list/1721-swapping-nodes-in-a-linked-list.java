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
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode p1 = null;
        ListNode p2 = null;
        ListNode temp = head;
        while(temp!=null){
            if(p2!=null){
                p2 = p2.next;
            }
            k--;
            if(k == 0){
                p1 = temp;
                p2 = head;
            }
            temp = temp.next;
        }
        int value = p1.val;
        p1.val = p2.val;
        p2.val = value;
        return head;   
    }
}