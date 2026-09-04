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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,List<Integer>> map =  new TreeMap<>();
        Queue<Pair<TreeNode,Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root,0));
        while(!q.isEmpty()){
            int n = q.size();
            List<int[]> lvl = new ArrayList<>();
            for(int i=0;i<n;i++){
               Pair<TreeNode,Integer> curr = q.poll();
               TreeNode node = curr.getKey();
               int col = curr.getValue();
               lvl.add(new int[]{col,node.val});
               if(node.left!=null) q.offer(new Pair<>(node.left,col-1));
               if(node.right!=null) q.offer(new Pair<>(node.right,col+1)); 
            }
            Collections.sort(lvl,(a,b)->{
                if(a[0]!=b[0]) 
                   return Integer.compare(a[0],b[0]);
                return Integer.compare(a[1],b[1]);
            });
            for(int[] x : lvl){
                map.putIfAbsent(x[0],new ArrayList<>());
                map.get(x[0]).add(x[1]);
            }
        }
        return new ArrayList<>(map.values());
    }
}