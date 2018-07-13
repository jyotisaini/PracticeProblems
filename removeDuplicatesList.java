/*

Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

*/

 public ListNode deleteDuplicates(ListNode a) {
        if(a ==null || a.next ==null)
            return a;
        ListNode start =a;
        while(a!=null)
        {
            ListNode next = a.next;
            if(next!=null&& a.val==a.next.val)
            {
                ListNode n = a.next.next;
                a.next = n;
            }
            else
                a=a.next;

        }
        return  start;
    }
