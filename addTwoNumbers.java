/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

    342 + 465 = 807
Make sure there are no trailing zeros in the output list
So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.



*/

 public ListNode addTwoNumbers(ListNode a, ListNode b) {
        if(a== null &&  b== null)
            return null;
        if(a==null)
            return b;
        if(b==null)
            return a;

        int carry =0;

        ListNode start =new ListNode(-1);
        ListNode prev = start;
        while(a!=null && b!= null)
        {
            ListNode l = new ListNode((a.val + b.val+carry)%10);
            carry = ( a.val+b.val+carry)/10;
            a= a.next; b= b.next;
            prev.next = l;
            prev= l;
        }
        if(a==null)
        {
            while( b!=null)
            {
                ListNode l = new ListNode((b.val+carry)%10);
                carry = (b.val+carry)/10;
                prev.next = l;
                prev= l;
                b=b.next;
            }

        }
        else
        {
            while( a!=null)
            {
                ListNode l = new ListNode((a.val+carry)%10);
                carry = (a.val+carry)/10;
                prev.next = l;
                prev= l;
                a=a.next;
            }
        }
        if(carry ==1) {
            ListNode l = new ListNode(carry);
            prev.next = l;
            l.next=null;
        }
        return start.next;
    }
