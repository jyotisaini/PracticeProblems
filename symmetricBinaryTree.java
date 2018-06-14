/*

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

Example :

    1
   / \
  2   2
 / \ / \
3  4 4  3
The above binary tree is symmetric. 
But the following is not:

    1
   / \
  2   2
   \   \
   3    3
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

*/

 public int isSymmetric(TreeNode a) {
        if(a==null)
            return 1;
        if(a.left == null && a.right==null)
            return 1;
        boolean result =false;
        if(a.left!=null & a.right!=null)
             result = isMirror(a.left, a.right);
        
        if(result)
            return 1;
        return 0;
    }
    
    public  boolean isMirror(TreeNode a, TreeNode b){
        if(a==null && b==null)
            return true;
        if(a==null || b==null || a.val!= b.val)
            return false;
        return  isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }
