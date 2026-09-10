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
    int ans=0;
    int []help(TreeNode root)
     {
        if(root==null)
           return new int[]{0,0};
        int l[]=help(root.left);   
        int r[]=help(root.right); 
        int val=l[0]+r[0]+root.val;
        int node=l[1]+r[1]+1;
        if(val/node==root.val)
           ans++;
        return new int[]{val,node};   

     }
    public int averageOfSubtree(TreeNode root) {
        help(root);
        return ans;
    }
}