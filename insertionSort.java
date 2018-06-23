c ListNode insertionSortList(ListNode a) {
        if(a==null || a.next ==null)
            return a;

        ListNode b = new ListNode(a.val);
        a=a.next;
        while(a!=null)
        {
            ListNode c = b;
            ListNode prec =null;
            while(c!=null)
            {
                if(c.val <a.val) {
                    prec = c;
                    c = c.next;
                }
                else {
                    ListNode newNode = new ListNode(a.val);
                    if(prec !=null)
                        prec.next = newNode;
                    else
                        b = newNode;
                    newNode.next=c;
                    break;
                }

            }

            if(c==null)
            {
              prec.next=new ListNode(a.val);
            }
            a=a.next;
        }

        return b;
    }
