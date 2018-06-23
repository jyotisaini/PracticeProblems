/*

Find the lowest common ancestor in an unordered binary tree given two values in the tree.

 Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants. 
Example :


        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2_     0        8
         /   \
         7    4
*/

 
    public int lca(TreeNode a, int b, int c) {

        if(a==null)
            return -1;
        if(a.right==null && a.left==null)
            return -1;

        ArrayList<Integer> nodeB = new ArrayList<Integer>();
        ArrayList<Integer> nodeC =  new ArrayList<Integer>();
       boolean cFlag=  findNode(a, c, nodeC);
       boolean bFlag = findNode(a, b, nodeB);
       if(!cFlag || !bFlag )
           return -1;


       for( int i =0; i<nodeB.size();i++ )
       {
           for( int j =0; i<nodeC.size(); j++)
           {
               if(nodeB.get(i)== nodeC.get(j))
                   return nodeB.get(i);
           }
       }
       return -1;
    }

   boolean findNode(TreeNode a, int b, ArrayList<Integer> path)
    {
        if(a==null)
            return false;
        if(a.val==b) {
            path.add(a.val);
            return true;
        }
        boolean left = findNode(a.left,b, path);
        boolean right = findNode(a.right, b,path);
        if(left)
        {
            path.add(a.val);
            return true;
        }
        else if(right)
        {
            path.add(aval);
            return true;
        }
        return false;

    }
