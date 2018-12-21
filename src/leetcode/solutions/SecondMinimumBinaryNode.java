/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SecondMinimumBinaryNode {
    
    public int findSecondMinimumValue(TreeNode root) {
        if (root==null) return 0;
        if(root.left==null && root.right==null) return -1;
        
        Set<Integer> set=new HashSet<Integer>();
        navigate(root,set);
        
        List<Integer> list=new ArrayList<Integer>();
        list.addAll(set);
        
        if(list.size()==1 && (root.left!=null || root.right!=null))
            return -1;
        else if (list.size()==0)
            return 0;
        else if(list.size()==1)
            return list.get(0);
        else
            return list.get(1);
    }
    
    public void navigate(TreeNode root,Set set){
        if(root==null)
            return ;
        if(root.left!=null){
            set.add(root.left.val);
            navigate(root.left,set);
        }
        
        if(root.right!=null){
            set.add(root.right.val);
            navigate(root.right,set);
        }
    }
    
}
