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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0) return null;
        return divideIntoLists(0,n-1,lists);
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val >= l2.val){
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }else{
            l1.next = mergeTwoLists(l2,l1.next);
            return l1;
        }
    }

    public ListNode divideIntoLists(int sp , int ep ,ListNode[] lists ){
        if(sp>ep) return null;
        if(sp == ep) return lists[sp];

        int mid = sp + (ep-sp)/2;
        ListNode L1 = divideIntoLists(sp,mid,lists);
        ListNode L2 = divideIntoLists(mid+1,ep,lists);

        return mergeTwoLists(L1,L2);
    }
}