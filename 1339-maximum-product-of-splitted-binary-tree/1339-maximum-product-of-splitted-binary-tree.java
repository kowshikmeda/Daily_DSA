import java.util.ArrayList;
import java.util.List;

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
    private static final int MOD = 1_000_000_007;
    private List<Long> allSubtreeSums = new ArrayList<>();
    private long totalSum = 0;

    public int maxProduct(TreeNode root) {
        // Step 1: Calculate the total sum of the tree and populate allSubtreeSums
        totalSum = calculateSubtreeSums(root);
        
        // Step 2: Iterate through all possible subtree sums to find the maximum product
        long maxProduct = 0;
        for (long subTreeSum : allSubtreeSums) {
            // The two subtrees have sums: subTreeSum and (totalSum - subTreeSum)
            long currentProduct = subTreeSum * (totalSum - subTreeSum);
            if (currentProduct > maxProduct) {
                maxProduct = currentProduct;
            }
        }
        
        // Return the maximum product modulo 10^9 + 7
        return (int) (maxProduct % MOD);
    }

    /**
     * Helper function to perform DFS, calculate subtree sums, and store them.
     */
    private long calculateSubtreeSums(TreeNode node) {
        if (node == null) {
            return 0;
        }

        long leftSum = calculateSubtreeSums(node.left);
        long rightSum = calculateSubtreeSums(node.right);
        long currentSubtreeSum = node.val + leftSum + rightSum;
        
        // Store the sum of the current subtree
        allSubtreeSums.add(currentSubtreeSum);
        
        return currentSubtreeSum;
    }
}