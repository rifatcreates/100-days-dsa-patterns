public class Day38_LC_1721 {

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

    public static ListNode swapNodes(ListNode head, int k) {
        ListNode n1 = head;
        int jumps = 0;

        while (jumps < (k-1)) {
            jumps++;
            n1 = n1.next;
        }

        ListNode nT1 = n1;
        ListNode n2 = head;

        while (nT1.next != null) {
            nT1 = nT1.next;
            n2 = n2.next;
        }

        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;

        return head;
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

        head = swapNodes(head, k);

        System.out.println("After Operation:");
        printList(head);
    }
}