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
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list1 = reverse(l1);
        ListNode list2 = reverse(l2);

        ListNode dummy = new ListNode(0);

        ListNode i = list1;
        ListNode j = list2;
        int carry = 0;
        ListNode dummyP = dummy;

        while(i!=null && j!=null){
            int sum = i.val + j.val + carry;
            carry = sum/10;
            int val = sum%10;

            ListNode node = new ListNode(val);
            dummyP.next = node;
            dummyP = dummyP.next;

            i = i.next;
            j = j.next;
        }

        while(i!=null){
            int sum = i.val + carry;
            carry = sum/10;
            int val = sum%10;

            ListNode node = new ListNode(val);
            dummyP.next = node;
            dummyP = dummyP.next;

            i = i.next;
        }

        while(j!=null){
            int sum = j.val + carry;
            carry = sum/10;
            int val = sum%10;

            ListNode node = new ListNode(val);
            dummyP.next = node;
            dummyP = dummyP.next;

            j = j.next;
        }

        if(carry!=0){
           ListNode node = new ListNode(carry);
           dummyP.next = node;
        }
       
        return reverse(dummy.next);
    }
}