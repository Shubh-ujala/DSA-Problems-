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
    public int pairSum(ListNode head) {

        // step 1
        // find mid
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow will now point at mid

        // reverse the list from mid till end
        ListNode next;
        ListNode prev = null;
        ListNode curr = slow;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        int sum = 0;

        ListNode temp = head;
        while(prev!=null){
            sum = Math.max(sum, temp.val+prev.val);
            prev = prev.next;
            temp = temp.next;
        }
        return sum;
    }
}