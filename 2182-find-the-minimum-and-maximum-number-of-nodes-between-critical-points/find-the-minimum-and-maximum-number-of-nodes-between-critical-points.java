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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode curr = head.next;
        ListNode prev = head;
        int count = 1;
        int firstCp = 0;
        int prevCp = 0;

        int minDist = Integer.MAX_VALUE;

        while(curr.next != null){
            if((curr.next.val > curr.val && curr.val < prev.val)||(curr.next.val < curr.val && curr.val > prev.val)){
                if(prevCp == 0){
                    prevCp = count;
                    firstCp = count;
                }else{
                    minDist = Math.min(minDist, count - prevCp);
                    prevCp = count;
                }
               
            }
            count++;
            prev = curr;
            curr = curr.next;
        }

        return minDist == Integer.MAX_VALUE ? new int[]{-1,-1} : new int[]{minDist , prevCp - firstCp};
    }
}