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
    private int maxPath(TreeNode node , int maxval[]){
        if(node==null) return 0 ;
        int ls = Math.max(0,maxPath(node.left,maxval));
        int rs = Math.max(0,maxPath(node.right,maxval));
        maxval[0] = Math.max(maxval[0],ls+rs+node.val);
        return node.val + Math.max(ls,rs);
    }
    public int maxPathSum(TreeNode root) {
        int maxval[] = new int[1];
        maxval[0] = Integer.MIN_VALUE;
        maxPath(root,maxval);
        return maxval[0];
    }
}