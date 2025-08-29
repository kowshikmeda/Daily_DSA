/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      if(root==null)return "";
      Queue<TreeNode> q=new LinkedList();
      StringBuilder st=new StringBuilder();
      q.add(root);
      while(!q.isEmpty()){
        TreeNode curr=q.poll();
        if(curr==null){  
            st.append("n ");
            continue;
        }
        st.append(curr.val+" ");
        q.add(curr.left);
        q.add(curr.right);


      } 
      return st.toString(); 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="")return null;
        Queue<TreeNode> q=new LinkedList();
        String []values=data.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for(int i=1;i<values.length;i++){
            TreeNode par=q.poll();
            if(!values[i].equals("n")){
                TreeNode left=new TreeNode(Integer.parseInt(values[i]));
                par.left=left;
                q.add(left);
            }
            if(!values[++i].equals("n")){
                TreeNode right=new TreeNode(Integer.parseInt(values[i]));
                par.right=right;
                q.add(right);
            }

        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));