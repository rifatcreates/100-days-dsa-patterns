public class Day35_LC_0024 {

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

    public static ListNode reverseLinkedList(ListNode head, int times) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null && times > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            times--;
        }

        return prev;
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode left = head;
        ListNode right = head;
        ListNode prevLeft = null;
        ListNode prevRight = null; 
        ListNode res = null;
        int size = 2;

        while (left != null && left.next != null) {
            right = left;
            for (int i=0; i<size-1; i++) {
                if (right == null) {
                    break;
                }
                right = right.next;
            }

            ListNode next = right.next;
            prevLeft = left;
            ListNode newHead = reverseLinkedList(left, size);
            if (res == null) {
                res = newHead;
            }

            if (prevRight != null) { 
                prevRight.next = newHead;
            }

            if (prevLeft != null) {
                prevLeft.next = next;
            }

            prevRight = left; 

            if (next != null) {
                left = next;
            } else {
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original:");
        printList(head);

        head = swapPairs(head);

        System.out.println("After Operation:");
        printList(head);
    }
}
