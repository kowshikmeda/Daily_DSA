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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       List<List<Integer>> ans=new ArrayList();
       if(root==null)return ans;
       Queue<TreeNode> q=new LinkedList();
       boolean leftToRight=true;
       q.add(root);
       while(!q.isEmpty()){
        int s=q.size();
        List<Integer> row=new ArrayList();
        for(int i=0;i<s;i++){
            TreeNode temp=q.poll();
             if (leftToRight) {
                   row.add(temp.val);
             } else {
                    row.add(0, temp.val);
              }
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
        }
        leftToRight=!leftToRight;
        ans.add(row);

       }
       return ans; 
    }
}