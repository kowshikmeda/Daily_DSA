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
    public int maxPathSum(TreeNode root) {
       int maxval[]= new int[1];
       maxval[0]=Integer.MIN_VALUE;
       helper(root,maxval);
       return maxval[0]; 
    }
    int helper(TreeNode root,int []maxval){
        if(root==null){
            return 0;
        }
        int left=Math.max(0,helper(root.left,maxval));
        int right=Math.max(0,helper(root.right,maxval));
        maxval[0]=Math.max(maxval[0],left+right+root.val);
        return Math.max(left,right)+root.val;

    }
}