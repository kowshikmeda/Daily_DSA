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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> inmap=new HashMap();
      for(int i=0;i<inorder.length;i++){
        inmap.put(inorder[i],i);
      }
      TreeNode root=buildTree(postorder,0,postorder.length-1,inorder,0,inorder.length-1,inmap);
      return root; 
    }
     TreeNode buildTree(int [] postorder,int poStart,int poEnd,int [] inorder,int inStart,int inEnd,Map<Integer,Integer> inmap){
        if(poStart>poEnd || inStart>inEnd){
            return null;
        }
        TreeNode root=new TreeNode(postorder[poEnd]);
        int inRoot=inmap.get(postorder[poEnd]);
        int numsleft=inRoot-inStart;
         root.left=buildTree(postorder,poStart,poStart+numsleft-1,inorder,inStart,inRoot-1,inmap);
          root.right=buildTree(postorder,poStart+numsleft,poEnd-1,inorder,inRoot+1,inEnd,inmap);
        return root;
    }
}