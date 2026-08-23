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
        if(head == null) return null;
        if(left == right) return head;
        ListNode curr = head;
        ListNode prev = null;
        ListNode afterRight = null;

        for(int i = 1 ; i<left ; i++){
            prev = curr;
            curr = curr.next;
        }

        curr = head;
        for(int i = 1 ; i<=right ; i++){
            afterRight = curr;
            curr = curr.next;
        }
        afterRight.next = null;
        // curr holds the nodes which are after right value
        ListNode reversed = (prev == null) ? reverse(head) : reverse(prev.next); 
        if(prev == null){
            prev = reversed;
            ListNode tempo = prev;
            while(tempo.next!=null){
                tempo = tempo.next;
            }
            tempo.next = curr;
            return prev;
        }else{
            prev.next = reversed;
        }

        ListNode temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }

        temp.next = curr;
        return head;
    }

    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}