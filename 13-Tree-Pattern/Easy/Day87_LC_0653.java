import java.util.*;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Day87_LC_0653 {

    static class Solution {
        Stack<TreeNode> asc = new Stack<>();
        Stack<TreeNode> dsc = new Stack<>();

        public TreeNode getSmallest() {
            if (asc.isEmpty()) return null;

            TreeNode node = asc.pop();

            TreeNode temp = node.right;
            while (temp != null) {
                asc.push(temp);
                temp = temp.left;
            }

            return node;
        }

        public TreeNode getBiggest() {
            if (dsc.isEmpty()) return null;

            TreeNode node = dsc.pop();

            TreeNode temp = node.left;
            while (temp != null) {
                dsc.push(temp);
                temp = temp.right;
            }

            return node;
        }

        public boolean findTarget(TreeNode root, int k) {
            if (root == null) return false;

            TreeNode temp = root;
            while (temp != null) {
                asc.push(temp);
                temp = temp.left;
            }

            temp = root;
            while (temp != null) {
                dsc.push(temp);
                temp = temp.right;
            }

            TreeNode left = getSmallest();
            TreeNode right = getBiggest();

            while (left != null && right != null && left != right) {
                int sum = left.val + right.val;

                if (sum == k) {
                    return true;
                } else if (sum < k) {
                    left = getSmallest();
                } else {
                    right = getBiggest();
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        int k = 9;

        Solution sol = new Solution();
        boolean result = sol.findTarget(root, k);

        System.out.println("Output: " + result);
    }
}