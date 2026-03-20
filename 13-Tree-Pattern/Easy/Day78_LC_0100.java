public class Day78_LC_0100 {
    
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
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        
        if (p == null || q == null) {
            return false;
        }
        
        if (p.val != q.val) {
            return false;
        }
        
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        
        return left && right;
    }
    
    public static void main(String[] args) {
        Day78_LC_0100 solution = new Day78_LC_0100();
        
        Integer[] pArray = {1, 2, 3};
        Integer[] qArray = {1, 2, 3};
        
        TreeNode p = solution.createTree(pArray, 0);
        TreeNode q = solution.createTree(qArray, 0);
        
        System.out.print("Tree p (inorder): ");
        solution.printTree(p);
        System.out.println();
        
        System.out.print("Tree q (inorder): ");
        solution.printTree(q);
        System.out.println();
        
        boolean result = solution.isSameTree(p, q);
        
        System.out.println("Are the trees same? " + result);
    }
}