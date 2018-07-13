/*
Sort a linked list in O(n log n) time using constant space complexity.

Example :

Input : 1 -> 5 -> 4 -> 3

Returned list : 1 -> 3 -> 4 -> 5

*/


     public ListNode sortList(ListNode a) {
        if(a==null || a.next ==null)
            return a;
        ListNode start=a;
        int count =0;
        while( a!=null)
        {
            count++;
            a=a.next;
        }
        return  sortListHelper(start, count);
    }

    ListNode sortListHelper(ListNode a , int size)
    {
        if(size ==1)
            return a;
        int count = 0;
        ListNode start =a;
        while(count<(size/2)-1)
        {
            start= start.next;
            count++;
        }
        ListNode next = start.next;
        start.next=null;
        if(size%2==0)
        {

            ListNode a1 = sortListHelper(a,size/2);
            ListNode a2 = sortListHelper(next,size/2);
            return MergeNodes(a1,a2);
        }
        ListNode a1 = sortListHelper(a,size/2);
        ListNode a2 = sortListHelper(next, size/2+1);
        return MergeNodes(a1,a2);
    }
    
    ListNode MergeNodes(ListNode a, ListNode b)
    {
        if(a==null)
            return b;
        if(a==null)
            return a;
        ListNode result = new ListNode(-1);
        ListNode x = result;
        while(a!=null&& b!=null)
        {
            if(a.val<b.val)
            {
               result.next=a;
               a=a.next;
               result = result.next;
            }
            else{
                result.next=b;
                b=b.next;
                result = result.next;
            }
        }
         while(a!=null)
         {
             result.next= a;
             a=a.next;
             result= result.next;
         }
        while(b!=null)
        {
            result.next= b;
            b=b.next;
            result= result.next;
        }
        return x.next;
    }

