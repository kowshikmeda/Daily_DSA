// import java.util.List;
// import java.util.ArrayList;

// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

class Solution {
    private int count = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorderTraversalWithCounter(root, k);
        return result;
    }

    private void inorderTraversalWithCounter(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        inorderTraversalWithCounter(node.left, k);

        // Check the count only after visiting the left subtree
        count++;
        if (count == k) {
            result = node.val;
            return; // We've found the result, no need to continue traversal
        }
        
        // This is a small optimization to stop further recursion
        if (count >= k) {
            return;
        }

        inorderTraversalWithCounter(node.right, k);
    }
}