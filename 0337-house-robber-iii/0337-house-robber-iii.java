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
    HashMap<TreeNode,Integer>map;
    Integer dp[][];
    int idx=0;
    void traversal(TreeNode root)
    {
        if(root==null)
           return ;
        map.put(root,idx++);
        traversal(root.left);
        traversal(root.right);   
    }
    int help(int i,int st,TreeNode root)
    {
        if(root==null)
           return 0;
        if(dp[i][st]!=null)
           return dp[i][st];
        int l_idx=-1;
        int r_idx=-1;
        if(root.left!=null)
        {
            l_idx=map.get(root.left); 
        }    
        if(root.right!=null)
        {
            r_idx=map.get(root.right);
        }
        if(st==0)
        {
            int take=root.val+help(l_idx,1,root.left)+help(r_idx,1,root.right);
            int notake=help(l_idx,0,root.left)+help(r_idx,0,root.right);
            dp[i][st]=Math.max(take,notake);
        }
        else//not take
        {
            dp[i][st]=help(l_idx,0,root.left)+help(r_idx,0,root.right);
        }
        return dp[i][st]; 
    }

    public int rob(TreeNode root) {
        map=new HashMap<>();
        traversal(root);
        dp=new Integer[idx][2];
        return help(0,0,root);
    }
}