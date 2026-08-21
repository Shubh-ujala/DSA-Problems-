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
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        ListNode i = list1;
        ListNode j = list2;

        while(i!=null && j!=null){
            if(i.val <= j.val){
                current.next = i;
                i = i.next;
            }else if(j.val < i.val){
                current.next = j;
                j = j.next;
            }

            current = current.next;
        }

        while(i!=null){
            current.next = i;
            i = i.next;
            current = current.next;
        }
        while(j!=null){
            current.next = j;
            j = j.next;
            current = current.next;
        }
        return dummy.next;
    }
}