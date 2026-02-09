public class Day39_LC_0025 {

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

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        int count = 0;

        while (count < k) {
            if (temp == null) {
                return head;
            }

            temp = temp.next;
            count++;
        }

        ListNode prevNode = reverseKGroup(temp, k);

        temp = head;
        count = 0;

        while (count < k) {
            ListNode next = temp.next;
            temp.next = prevNode;

            prevNode = temp;
            temp = next;
            count++;
        }

        return prevNode;
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

        head = reverseKGroup(head, k);

        System.out.println("After Operation:");
        printList(head);
    }
}
