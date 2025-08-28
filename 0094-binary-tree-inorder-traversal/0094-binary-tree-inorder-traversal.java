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
    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> ans=new ArrayList();
      if(root==null)return ans;
      Stack<TreeNode> st=new Stack();
    TreeNode node=root;
      while(true){
        if(node!=null){
            st.push(node);
            node=node.left;
        }else{
         if(st.isEmpty()){
            break;
         }
         TreeNode top=st.pop();
         ans.add(top.val);
         node=top.right;
        }
        
      }
      return ans;
    }
}