/*
Given a binary tree, invert the binary tree and return it. 
Look at the example for more details.

Example : 
Given binary tree

     1
   /   \
  2     3
 / \   / \
4   5 6   7
invert and return

     1
   /   \
  3     2
 / \   / \
7   6 5   4

*/


    public TreeNode invertTree(TreeNode a) {
        if(a==null)
            return a;
        
        if(a.right==null && a.left==null)
            return a;
        TreeNode temp = a.left;
        a.left = a.right;
        a.right = temp;
        a.left = invertTree(a.left);
        a.right = invertTree(a.right);
        return a;
        
    }

