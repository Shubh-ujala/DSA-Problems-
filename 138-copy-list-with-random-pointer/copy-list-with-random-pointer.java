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
        HashMap<Node,Node> hm = new HashMap<>();

        Node curr = head;
        while(curr!=null){
            Node node = new Node(curr.val); // this is the copied node of the original node
            hm.put(curr,node);
            curr = curr.next;
        }

        curr = head;
        Node deepCopy = new Node(0);
        Node temp = deepCopy;
        while(curr!=null){
            temp.next = hm.get(curr);
            temp.next.random = hm.get(curr.random);
            temp = temp.next;
            curr = curr.next;
        }

        return deepCopy.next;
    }
}