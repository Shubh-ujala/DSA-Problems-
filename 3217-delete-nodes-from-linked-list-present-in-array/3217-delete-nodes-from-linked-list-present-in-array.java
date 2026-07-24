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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> st = new HashSet<>();
        for(int x : nums){
            st.add(x);
        }

        ListNode curr = head;
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while(curr!=null){
            if(!st.contains(curr.val)){
                temp.next = curr;
                temp = temp.next;
            }
            curr = curr.next;
        }
        temp.next = null;
        return dummy.next;
    }
}