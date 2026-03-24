public class Day82_LC_0236 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode() {}
        TreeNode(int val) { 
            this.val = val; 
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public TreeNode createTree(Integer[] arr, int index) {
        if (index >= arr.length || arr[index] == null) {
            return null;
        }
        
        TreeNode root = new TreeNode(arr[index]);
        root.left = createTree(arr, 2 * index + 1);
        root.right = createTree(arr, 2 * index + 2);
        
        return root;
    }
    
    public TreeNode findNode(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        
        TreeNode left = findNode(root.left, val);
        if (left != null) return left;
        
        return findNode(root.right, val);
    }
    
    public void printTree(TreeNode root) {
        if (root == null) return;
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }

    static TreeNode res = null;

    private static int findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return 0;
        }
        
        int left = findLCA(root.left, p, q);
        
        int right = findLCA(root.right, p, q);
        
        int self = 0;
        if (root == p || root == q) {
            self = 1;
        }
        
        int total = left + self + right;
        
        if (total == 2 && res == null) {
            res = root;
        }
        
        return total;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLCA(root, p, q);
        return res;
    }
    
    public static void main(String[] args) {
        Day82_LC_0236 solution = new Day82_LC_0236();
        
        Integer[] rootArray = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode root = solution.createTree(rootArray, 0);
        
        TreeNode p = solution.findNode(root, 5);
        TreeNode q = solution.findNode(root, 1);
        
        TreeNode result = solution.lowestCommonAncestor(root, p, q);
        
        if (result != null) {
            System.out.println(result.val);
        } else {
            System.out.println("null");
        }
    }
}