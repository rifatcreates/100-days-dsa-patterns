import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Day16_LC_0142 {
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        ListNode n1 = head;
        ListNode n2 = slow;

        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }

        return n1;
    }

    public static void main(String args[]) {
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        node4.next = node2;

        ListNode cycleNode = detectCycle(head);

        if (cycleNode != null) {
            System.out.println("Cycle starts at node with value: " + cycleNode.val);
        } else {
            System.out.println("No cycle detected");
        }
    }
}
