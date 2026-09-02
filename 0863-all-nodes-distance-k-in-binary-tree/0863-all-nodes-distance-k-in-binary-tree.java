/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode,List<TreeNode>>data;
    HashSet<TreeNode>vis;
    List<Integer>ans;

    void build(TreeNode root,TreeNode parent)
    {
        if(root==null)
           return;

        data.putIfAbsent(root,new ArrayList<>()) ;

        if(parent!=null)
           data.get(root).add(parent);  
        if(root.left!=null)
           data.get(root).add(root.left);  
        if(root.right!=null)
           data.get(root).add(root.right);
        build(root.left,root);     
        build(root.right,root);     
    }

    void help(TreeNode root,int d,int k)
    {
        if(root==null)
           return;

        vis.add(root);

        if(d==k)
         ans.add(root.val);

        for(TreeNode node:data.get(root))
        {
            if(!vis.contains(node))
               help(node,d+1,k);
        }    
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        data=new HashMap<>();
        vis=new HashSet<>();
        ans=new ArrayList<>();
        build(root,null);
        help(target,0,k);
        return ans;

    }
}