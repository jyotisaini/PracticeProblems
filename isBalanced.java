/*

Given a binary tree, determine if it is height-balanced.

 Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Example :

Input : 
          1
         / \
        2   3

Return : True or 1 

Input 2 : 
         3
        /
       2
      /
     1

Return : False or 0 
         Because for the root node, left subtree has depth 2 and right subtree has depth 0. 
         Difference = 2 > 1. 
*/

public int isBalanced(TreeNode a) {
        if(a==null)
            return 1;
        if(a.left==null&& a.right==null)
            return 1;
        int left = height(a.left);
        int right = height(a.right);
        if(Math.abs(left-right) >1)
            return 0;
        int l = isBalanced(a.left);
        int r = isBalanced(a.right);
        if( l==1&& r==1)
            return 1;
        return 0;
    }
    
    int height(TreeNode a){
        if(a==null)
            return 0;
        if(a.left==null  && a.right ==null)
            return 1;
        int left = height(a.left);
        int right = height(a.right);
        return 1+Math.max(left, right);
    }
