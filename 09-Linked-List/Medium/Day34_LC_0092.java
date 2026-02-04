public class Day34_LC_0092 {

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

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;
        if (left == right) return head;

        ListNode temp = head;
        ListNode before = null;
        int pos = 1;

        while (temp != null) {

            if (pos < left) {
                before = temp;
                temp = temp.next;
                pos++;
                continue;
            }

            ListNode prev = null;
            ListNode curr = temp;
            int times = right - left + 1;

            while (times > 0) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                times--;
            }

            temp.next = curr;
            if (before != null) {
                before.next = prev;
                return head;
            } else {
                return prev;
            }
        }

        return head;
    }

    // ===== Main =====
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original:");
        printList(head);

        head = reverseBetween(head, 2, 4);

        System.out.println("After Operation:");
        printList(head);
    }
}
