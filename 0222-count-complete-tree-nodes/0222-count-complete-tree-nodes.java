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
    
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        
        int h = findHeight(root);
        h--;

        int l = 0;
        int r = (int)Math.pow(2, h)-1;

        while(l <= r){
            int mid = (l + r)/2;

            if(traverse(root, h, mid)){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return (int)Math.pow(2, h) + r;
    }
    public boolean traverse(TreeNode node, int height, int mid){
        if(height == 0 && node == null)return false;
        if(height == 0)return true;

        int bit = mid & (1 << height - 1);

        if(bit == 0){
            return traverse(node.left, height - 1, mid);
        }else{
            return traverse(node.right, height - 1, mid);
        }
    
    }

    private int findHeight(TreeNode node){
        if(node == null)return 0;
        return findHeight(node.left) + 1;
    }
}