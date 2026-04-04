import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Day93_LC_2487 {
    
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> s = new Stack<>();
        ListNode current = head;

        while (current != null) {
            while (!s.isEmpty() && s.peek().val < current.val) {
                s.pop();
            }

            s.push(current);
            current = current.next;
        }

        ListNode newRoot = null;
        while (!s.isEmpty()) {
            ListNode node = s.pop();
            node.next = newRoot;
            newRoot = node;
        }

        return newRoot;
    }
    
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" → ");
            }
            current = current.next;
        }
        System.out.println();
    }
    
    public static ListNode createList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }
    
    public static void main(String[] args) {
        int[] inputArray = {5, 3, 7, 2, 6};
        ListNode head = createList(inputArray);
        
        System.out.print("Original: ");
        printList(head);
        
        Day93_LC_2487 solution = new Day93_LC_2487();
        ListNode result = solution.removeNodes(head);
        
        System.out.print("After removal: ");
        printList(result);
    }
}