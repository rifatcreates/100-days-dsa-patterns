class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Day88_LC_0112 {

    boolean ans = false;

    public void helper(TreeNode root, int sum, int targetSum) {
        if (root == null) return;

        sum += root.val;

        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                ans = true;
                return;
            }
        }

        helper(root.left, sum, targetSum);
        helper(root.right, sum, targetSum);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        helper(root, 0, targetSum);
        return ans;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;

        Day88_LC_0112 obj = new Day88_LC_0112();
        System.out.println(obj.hasPathSum(root, targetSum));
    }
}