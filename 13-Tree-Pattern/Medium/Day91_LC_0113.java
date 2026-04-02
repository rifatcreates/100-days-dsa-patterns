import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Day91_LC_0113 {
    
    public void helper(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> path, int sum) {
        if (root == null) {
            return;
        }

        sum += root.val;
        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                result.add(new ArrayList<>(path));
            }
        }

        helper(root.left, targetSum, result, path, sum);
        helper(root.right, targetSum, result, path, sum);
        
        path.remove(path.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, targetSum, result, new ArrayList<>(), 0);
        return result;
    }

    public static void main(String[] args) {
        Day91_LC_0113 solution = new Day91_LC_0113();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;
        List<List<Integer>> result = solution.pathSum(root, targetSum);

        System.out.println("Target Sum " + targetSum + " এর জন্য পাথগুলো হলো:");
        System.out.println(result);
    }
}