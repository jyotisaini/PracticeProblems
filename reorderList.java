/*
Given a singly linked list

    L: L0 → L1 → … → Ln-1 → Ln,
reorder it to:

    L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
You must do this in-place without altering the nodes’ values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.*/


    public ListNode reorderList(ListNode a) {
        if(a==null)
            return null;

        ListNode copyNode = a,copyB =a,prev =null;
        int count = 0;

        while(copyNode!=null)
        {
            copyNode = copyNode.next;
            count++;
        }
        if(count == 1|| count ==2)
            return a;

        int mid = count/2;
        int i=0;
        while(i <=mid)
        {
            prev =copyB;
            copyB = copyB.next;
            i++;

        }
        prev.next= null;
        ListNode revList = reverse(copyB);
        ListNode start=a;
        while(start!=null && revList!=null)
        {
            ListNode b =start.next;
            start.next=revList;
            ListNode x =revList.next;
            revList.next=b;
            start = b;
            revList =x;
           // System.out.println(b);

        }
        return a;
    }
    
     public ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode current = node;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

