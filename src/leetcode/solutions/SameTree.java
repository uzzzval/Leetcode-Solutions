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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<String> list1=new ArrayList<String>();
        List<String> list2=new ArrayList<String>();
        navigate(p,list1);
        navigate(q,list2);
       
        boolean flag=true;
        if(list1.size()!=list2.size())
            return false;
        if(list1.size()==list2.size()){
            for(int i=0;i<list1.size();i++){
                if(!list1.get(i).equals(list2.get(i))){
                    flag=false;
                    break;
                }
            }
        }
        return flag;
    }
    
    public void navigate(TreeNode root,List<String> list){
        if(root==null){
            return;
        }
        list.add(root.val+"");
        if(root.left!=null){
            navigate(root.left,list);
        }else if (root.left==null){
           list.add("NA"); 
        }
        
        if(root.right!=null){
            navigate(root.right,list);
        }else if (root.left==null){
           list.add("NA"); 
        }
    }
}
