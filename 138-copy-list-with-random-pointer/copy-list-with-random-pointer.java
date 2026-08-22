/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // 3 step process
        // 1. place the copied node in between

        Node temp = head;
        Node next = null;
        while(temp!=null){
            next = temp.next;
            Node copied = new Node(temp.val);
            temp.next = copied;
            copied.next = next;
            temp = next;
        }

        // 2. connect the random pointers
        temp = head;
        while(temp!=null){
            if(temp.random!= null){
                temp.next.random = temp.random.next;
            }else{
                temp.next.random = temp.random;
            }
            temp = temp.next.next;
        }
        
        // 3. connect the next pointers
        Node dummy = new Node(0);
        temp = head;
        Node res = dummy;

        while(temp!=null){

            res.next = temp.next;
            res = res.next;
            temp.next = temp.next.next;

            temp = temp.next;
        }

        return dummy.next;
    }
}