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
    ArrayList<Integer> arr = new ArrayList<>();
    public Solution(ListNode head) {
        ListNode curr = head;
        while(curr!=null){
            arr.add(curr.val);
            curr= curr.next;
        }
    }
    
    public int getRandom() {
        int n = arr.size();
        return arr.get((int)(Math.random()*n));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */