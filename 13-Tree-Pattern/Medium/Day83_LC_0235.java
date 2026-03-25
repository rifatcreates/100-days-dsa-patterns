public class Day83_LC_0235 {
    
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
    
    public void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
    
    public TreeNode findNode(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        
        TreeNode left = findNode(root.left, val);
        if (left != null) return left;
        
        return findNode(root.right, val);
    }
    
    public static TreeNode res;
    
    public static void helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return;
        }
        
        if (root.val == p.val || root.val == q.val) {
            res = root;
            return;
        }
        
        if (root.val < p.val) {
            helper(root.right, p, q);
        } else if (root.val > q.val) {
            helper(root.left, p, q);
        } else {
            res = root;
            return;
        }
    }
    
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < q.val) {
            helper(root, p, q);
        } else {
            helper(root, q, p);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        Day83_LC_0235 solution = new Day83_LC_0235();
        
        Integer[] rootArray = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        TreeNode root = solution.createTree(rootArray, 0);
        
        TreeNode p = solution.findNode(root, 2);
        TreeNode q = solution.findNode(root, 8);
        
        System.out.print("Tree (preorder): ");
        solution.printTree(root);
        System.out.println();
        
        System.out.println("p = " + p.val + ", q = " + q.val);
        
        TreeNode result = solution.lowestCommonAncestor(root, p, q);
        
        if (result != null) {
            System.out.println("LCA: " + result.val);
        } else {
            System.out.println("LCA not found");
        }
    }
}