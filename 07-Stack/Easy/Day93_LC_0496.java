import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Day93_LC_0496 {
    
    public int[] nextGreaterElement(int nums1[], int nums2[]) {
        Stack<Integer> s = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums2) {
            while (!s.isEmpty() && s.peek() < num) {
                map.put(s.pop(), num);
            }

            s.push(num);
        }

        int result[] = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }

        return result;
    }
    
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        
        System.out.print("nums1: ");
        printArray(nums1);
        System.out.print("nums2: ");
        printArray(nums2);
        
        Day93_LC_0496 solution = new Day93_LC_0496();
        int[] result = solution.nextGreaterElement(nums1, nums2);
        
        System.out.print("Next Greater Elements: ");
        printArray(result);
    }
}