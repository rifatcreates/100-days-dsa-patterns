public class Day83_LC_0700 {
    
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
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }
    
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        if (root.val < val) {
            return searchBST(root.right, val);
        }

        return searchBST(root.left, val);
    }
    
    public static void main(String[] args) {
        Day83_LC_0700 solution = new Day83_LC_0700();
        
        Integer[] rootArray = {4, 2, 7, 1, 3};
        TreeNode root = solution.createTree(rootArray, 0);
        
        int val = 2;
        
        TreeNode result = searchBST(root, val);
        
        if (result != null) {
            System.out.println("Found node with value: " + result.val);
            System.out.print("Subtree (inorder): ");
            solution.printTree(result);
        } else {
            System.out.println("Value " + val + " not found in BST");
        }
    }
}