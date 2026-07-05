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
    public ListNode removeZeroSumSublists(ListNode head) {
        int prefixSum = 0;
        HashMap<Integer,ListNode> hm = new HashMap<>();

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        hm.put(0,dummyNode);

        while(head!=null){
            prefixSum+= head.val;
            if(hm.containsKey(prefixSum)){
                //delete wala kaam yha karna hai
                ListNode start = hm.get(prefixSum);
                ListNode temp = start;

                int pSum = prefixSum;
                while(temp!=head){
                    temp = temp.next;
                    pSum+= temp.val;

                    if(temp!=head){
                        hm.remove(pSum);
                    }
                }
                start.next = head.next;
            }else{
                hm.put(prefixSum,head);
            }
            head = head.next;
        }
        return dummyNode.next;
    }
}