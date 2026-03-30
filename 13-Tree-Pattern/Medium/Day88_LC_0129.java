class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Day88_LC_0129 {

    int ans = 0;

    public void helper(TreeNode root, int sum) {
        if (root == null) return;

        sum = sum * 10 + root.val;

        if (root.left == null && root.right == null) {
            ans += sum;
        }

        helper(root.left, sum);
        helper(root.right, sum);
    }

    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return ans;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        Day88_LC_0129 obj = new Day88_LC_0129();
        System.out.println(obj.sumNumbers(root));
    }
}