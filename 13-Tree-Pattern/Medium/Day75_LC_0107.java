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

public class Day75_LC_0107 {
    public static TreeNode createTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;
        
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
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();

            while (size > 0) {
                TreeNode node = q.peek();
                temp.add(node.val);
                q.remove();

                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }

                size--;
            }

            res.add(0, temp);
        }

        return res;
    }
    
    public static void main(String[] args) {
        Day75_LC_0107 solution = new Day75_LC_0107();
        
        Integer[] arr1 = {3, 9, 20, null, null, 15, 7};
        TreeNode root1 = createTree(arr1);
        System.out.println(solution.levelOrderBottom(root1));
    }
}