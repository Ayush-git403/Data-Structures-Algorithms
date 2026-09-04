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
          Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> traverse = new LinkedList<List<Integer>>();
        if(root==null) return traverse;
        q.offer(root);
        boolean flag = true;
        while(!q.isEmpty()){
            List<Integer> sublist = new LinkedList<>();
            int size = q.size();
            for(int i =0;i<size;i++){
                if(flag){
                    sublist.add(q.peek().val);
                }else{
                    sublist.add(0,q.peek().val);
                }
                if(q.peek().left!=null) q.offer(q.peek().left);
                 if(q.peek().right!=null) q.offer(q.peek().right);
                  q.poll();
            }
            traverse.add(sublist);
            flag = !flag;
        }
        return traverse;
    }
}