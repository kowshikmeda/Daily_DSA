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

// Custom BST Iterator class to simulate inorder (or reverse inorder) traversal
class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    private boolean reverse;  // if true → reverse inorder (right to left), else normal inorder (left to right)

    public BSTIterator(TreeNode root, boolean reverse) {
        this.reverse = reverse;
        // Start by pushing the full path down either left (inorder) or right (reverse inorder)
        pushAll(root);
    }

    // Return the next value in current traversal direction
    public int next() {
        TreeNode node = stack.pop();

        // Move in the opposite direction of current traversal to keep it going
        // Normal inorder: after visiting node, go right
        // Reverse inorder: after visiting node, go left
        if (reverse) {
            pushAll(node.left);
        } else {
            pushAll(node.right);
        }

        return node.val;
    }

    // Check if there are more nodes to visit
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // Helper to push all left (or right) children onto stack until null
    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = reverse ? node.right : node.left;
        }
    }
}


class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        // Initialize two iterators:
        // l → moves from smallest to largest (inorder)
        // r → moves from largest to smallest (reverse inorder)
        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);

        // Start with the smallest and largest elements
        int i = l.next();
        int j = r.next();

        // Two-pointer approach: move inward until values cross
        while (i < j) {
            int sum = i + j;

            if (sum == k) return true;  // Found the target pair
            else if (sum < k) {
                // If sum is too small, move left pointer forward
                if (l.hasNext()) i = l.next();
                else break;  // No more values to check on left
            } else {
                // If sum is too large, move right pointer backward
                if (r.hasNext()) j = r.next();
                else break;  // No more values to check on right
            }
        }

        // No such pair found
        return false;
    }
}