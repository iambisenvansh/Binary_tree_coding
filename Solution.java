import java.util.*;

// TreeNode definition
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Solution {

    // ------------------- Postorder Traversal -------------------
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    private void postorder(TreeNode node, List<Integer> res) {
        if (node == null) return;

        postorder(node.left, res);
        postorder(node.right, res);
        res.add(node.val);
    }

    // ------------------- Helper: Build Tree from Array -------------------
    // Builds tree using level-order representation. null = empty node.
    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();

            // left child
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;

            // right child
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    // ------------------- Main Method -------------------
    public static void main(String[] args) {
        // Example tree: [1, null, 2, 3]
        Integer[] arr = {1, null, 2, 3};

        TreeNode root = buildTree(arr);

        Solution sol = new Solution();
        List<Integer> result = sol.postorderTraversal(root);

        System.out.println("Postorder Traversal: " + result);
    }
}
