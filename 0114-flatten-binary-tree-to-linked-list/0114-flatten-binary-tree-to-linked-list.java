/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode rightmost = curr.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }
                
                // Attach the original right subtree to the rightmost node of the left subtree
                rightmost.right = curr.right;
                
                // Move the entire left subtree to the right
                curr.right = curr.left;
                
                // Disconnect the original left pointer
                curr.left = null;
            }
            // Move to the next node in the new flattened list
            curr = curr.right;
        }
    }
}