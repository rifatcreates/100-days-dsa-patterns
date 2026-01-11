public class Day11_LC_0019 {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    public Node removeNthFromEnd(Node head, int n) {
        Node dummy = new Node(0);
        dummy.next = head;

        int len = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }

        int idxToFind = len - n + 1;
        int i = 1;
        Node prev = dummy;
        Node curr = head;
        while (i < idxToFind) {
            prev = prev.next;
            curr = curr.next;
            i++;
        }

        prev.next = prev.next.next;
        return dummy.next;
    }

    public void print() {
        if (head == null) {
            System.out.println("LinkedList is empty.");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public static void main(String args[]) {
        Day11_LC_0019 ll = new Day11_LC_0019();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        System.out.print("Original List: ");
        ll.print();

        int n = 2;
        head = ll.removeNthFromEnd(head, n);

        System.out.print("After Deletion: ");
        ll.print();
    }
}