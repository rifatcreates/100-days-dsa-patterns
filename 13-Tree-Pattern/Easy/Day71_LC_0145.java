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

public class Day71_LC_0145 {
    private static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) return null;
        
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();
            
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;
            
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    public static void postorderHelper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        postorderHelper(root.left, res);
        postorderHelper(root.right, res);
        res.add(root.val);
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderHelper(root, res);
        return res;
    }
    
    public static void main(String[] args) {
        Day71_LC_0145 solution = new Day71_LC_0145();
        
        Integer[] treeArray = {1, null, 2, 3};
        TreeNode root = buildTree(treeArray);
        
        List<Integer> result = solution.postorderTraversal(root);
        
        System.out.println("Postorder Traversal: " + result);
    }
}