public class Day78_LC_0101 {
    
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
        if (root == null) {
            System.out.print("null ");
            return;
        }
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }

    public static boolean helper(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return helper(root1.left, root2.right) && helper(root1.right, root2.left);
    }
    
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return helper(root.left, root.right);
    }
    
    public static void main(String[] args) {
        Day78_LC_0101 solution = new Day78_LC_0101();
        
        Integer[] rootArray = {1, 2, 2, 3, 4, 4, 3};
        
        TreeNode root = solution.createTree(rootArray, 0);
        
        System.out.print("Tree (inorder): ");
        solution.printTree(root);
        System.out.println();
        
        boolean result = solution.isSymmetric(root);
        
        System.out.println("Is the tree symmetric? " + result);
    }
}