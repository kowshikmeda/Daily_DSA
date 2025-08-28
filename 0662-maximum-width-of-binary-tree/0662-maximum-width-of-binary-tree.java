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
    class Pair{
        int num;
        TreeNode node;
        Pair(TreeNode no,int n){
            node=no;
            num=n;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        int ans=0;
        Queue<Pair> q=new LinkedList();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int s=q.size();
            int mini=q.peek().num;
            int first=0,last=0;
            for(int i=0;i<s;i++){
                int cur_id=q.peek().num-mini;
                TreeNode temp=q.peek().node;
                q.poll();
                if(i==0)first=cur_id;
                if(i==s-1)last=cur_id;
                if(temp.left!=null){
                    q.offer(new Pair(temp.left,cur_id*2+1));
                }
                 if(temp.right!=null){
                    q.offer(new Pair(temp.right,cur_id*2+2));
                }

            }
            ans=Math.max(ans,last-first+1);

        }
        return ans;
    }
}