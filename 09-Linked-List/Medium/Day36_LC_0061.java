public class Day36_LC_0061 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode last = head;
        int n = 1;

        while (last.next != null) {
            n++;
            last = last.next;
        }

        k = k % n;
        if (k == 0) {
            return head;
        }

        ListNode t = head;

        for (int i=1; i<n-k; i++) {
            t = t.next;
        }

        ListNode res = t.next;
        last.next = head;
        t.next = null;

        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        System.out.println("Original:");
        printList(head);

        head = rotateRight(head, k);

        System.out.println("After Operation:");
        printList(head);
    }
}
