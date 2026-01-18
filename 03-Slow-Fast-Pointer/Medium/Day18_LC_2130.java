import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Day18_LC_2130 {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        int maxValue = 0;
        ListNode p1 = head;
        ListNode p2 = reverseList(slow);

        while (p1 != null && p2 != null) {
            int sum = p1.val + p2.val;
            maxValue = Math.max(maxValue, sum);
            p1 = p1.next;
            p2 = p2.next;
        }

        return maxValue;
    }

    public static void main(String args[]) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        int result = pairSum(head);
        System.out.println("Maximum Twin Sum: " + result);
    }
}