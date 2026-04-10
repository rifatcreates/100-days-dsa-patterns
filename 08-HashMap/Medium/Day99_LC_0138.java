import java.util.HashMap;

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

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        HashMap<Node, Node> map = new HashMap<>();
        
        Node current = head;
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }
        
        current = head;
        while (current != null) {
            Node copyNode = map.get(current);
            copyNode.next = map.get(current.next);
            copyNode.random = map.get(current.random);
            current = current.next;
        }
        
        return map.get(head);
    }
}

public class Day99_LC_0138 {
    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        
        head.random = null;
        head.next.random = head;
        head.next.next.random = head.next.next;
        
        Solution solution = new Solution();
        Node result = solution.copyRandomList(head);
        
        System.out.print(result.val + " " + result.next.val + " " + result.next.next.val);
    }
}